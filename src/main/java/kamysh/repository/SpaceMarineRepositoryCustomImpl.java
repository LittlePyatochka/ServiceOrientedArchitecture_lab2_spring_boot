package kamysh.repository;

import kamysh.controller.FilterConfiguration;
import kamysh.entity.AstartesCategory;
import kamysh.entity.SpaceMarine;
import kamysh.exceptions.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

class FilterMode {
    public static final String EQUAL = "==";
    public static final String CONTAINS = "contains";
}

public class SpaceMarineRepositoryCustomImpl implements SpaceMarineRepositoryCustom {
    private static final List<String> EXPECTED_FIELDS = Collections.unmodifiableList(Arrays.asList("id", "name", "coordinates", "creationDate", "health", "heartCount", "loyal", "category", "chapter"));

    @PersistenceContext
    EntityManager em;

    @Override
    public List<SpaceMarine> findAllByFilterConfiguration(FilterConfiguration filterConfiguration) {
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<SpaceMarine> criteria = criteriaBuilder.createQuery(SpaceMarine.class);
        Root<SpaceMarine> root = criteria.from(SpaceMarine.class);
        List<Order> orders = new ArrayList<>();
        System.err.println("SIZE = " + filterConfiguration.toString());


        filterConfiguration.getOrder().forEach(order -> {
            String[] parts = order.split(",", 2);
            if (parts.length < 2) throw new RuntimeException(new IncorrectOrderString());
            String fieldName = parts[0];
            if (!EXPECTED_FIELDS.contains(fieldName)) throw new RuntimeException(new FilterModeNotFound(fieldName));
            String orderKey = parts[1];
            System.err.println("orderKey = " + orderKey);
            if (!orderKey.equals("d") && !orderKey.equals("a")){
                throw new RuntimeException(new IncorrectOrderString(orderKey));
            }
            if (orderKey.equals("d")) orders.add(criteriaBuilder.desc(root.get(fieldName)));
            else {
                orders.add(criteriaBuilder.asc(root.get(fieldName)));
            }
        });
        if (orders.size() > 0) criteria.orderBy(orders);

        List<Predicate> predicates = new ArrayList<>();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        filterConfiguration.getFilter().forEach(filter -> {
            String[] parts = filter.split(",");
            if (parts.length > 3 || parts.length < 2) throw new RuntimeException(new IncorrectFilterString());
            String fieldName = parts[0];
            if (!EXPECTED_FIELDS.contains(fieldName)) throw new RuntimeException(new FilterModeNotFound(fieldName));
            String mode = parts.length == 3 ? parts[1] : FilterMode.EQUAL;
            String value = parts.length == 3 ? parts[2] : parts[1];
            switch (mode) {
                case FilterMode.EQUAL:
                    if (fieldName.equals("creationDate")) {
                        try {
                            predicates.add(criteriaBuilder.equal(root.<Date>get(fieldName), formatter.parse(value)));
                        } catch (ParseException e) {
                            throw new RuntimeException(new IncorrectFilterString());
                        }
                    } else if (fieldName.equals("coordinates") || fieldName.equals("chapter")) {
                        if (fieldName.equals("chapter") && value.equals("None")) {
                            predicates.add(criteriaBuilder.isNull(root.get(fieldName).get("id")));
                        } else {
                            predicates.add(criteriaBuilder.equal(root.get(fieldName).get("id"), value));
                        }
                    } else if (fieldName.equals("category")) {

                        predicates.add(criteriaBuilder.equal(root.get(fieldName), AstartesCategory.valueOf(value)));
                    } else if (fieldName.equals("loyal")) {
                        if (!isBoolean(value)){
                            throw new RuntimeException(new IncorrectFilterString());
                        }
                            predicates.add(criteriaBuilder.equal(root.get(fieldName), Boolean.valueOf(value)));
                    } else if (fieldName.equals("heartCount") || fieldName.equals("health") || fieldName.equals("id")) {
                        predicates.add(criteriaBuilder.equal(root.get(fieldName), Integer.valueOf(value)));
                    } else {
                        predicates.add(criteriaBuilder.equal(root.get(fieldName), value));
                    }
                    break;
                case FilterMode.CONTAINS:
                    predicates.add(criteriaBuilder.like(root.get(fieldName), "%" + value + "%"));
                    break;
                default:
                    throw new RuntimeException(new FilterModeNotFound(mode));
            }
        });
        if (predicates.size() > 0)
            criteria.where(criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()])));

        TypedQuery<SpaceMarine> query = em.createQuery(criteria);
        filterConfiguration.getCount().ifPresent((count) -> {
            if (count < 1) throw new RuntimeException(new InvalidValueException(ErrorCode.INVALID_COUNT_VALUE, "Parameter 'count' must be positive integer"));
            int page = filterConfiguration.getPage().orElse(1);
            if (page < 1) throw new RuntimeException(new InvalidValueException(ErrorCode.INVALID_PAGE_VALUE, "Parameter 'page' must be positive integer"));
            query.setMaxResults(count);
            query.setFirstResult((page - 1) * count);
        });

        return query.getResultList();
    }


    private boolean isBoolean(String value){
        return value.equals(Boolean.FALSE.toString()) || value.equals(Boolean.TRUE.toString());
    }
}
