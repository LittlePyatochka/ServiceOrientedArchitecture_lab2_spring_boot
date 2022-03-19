package kamysh.utils;

import lombok.SneakyThrows;

import javax.validation.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Set;

public class Utils {

    @SneakyThrows
    public static Object runGetter(String field, Object o) throws IllegalAccessException, InvocationTargetException {
        for (Method method : o.getClass().getMethods()) {
            if ((method.getName().startsWith("get")) && (method.getName().length() == (field.length() + 3))) {
                if (method.getName().toLowerCase().endsWith(field.toLowerCase())) {
                    return method.invoke(o);

                }
            }
        }
        return null;
    }

    @SneakyThrows
    public static void validate(Object o) {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<Object>> constraintViolations = validator.validate(o);
        if (constraintViolations.size() > 0) throw new ConstraintViolationException(constraintViolations);
    }

}
