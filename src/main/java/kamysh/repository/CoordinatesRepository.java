package kamysh.repository;

import kamysh.entity.Coordinates;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CoordinatesRepository extends CrudRepository<Coordinates, Long> {
    List<Coordinates> findAll();

    Optional<Coordinates> findById(Long id);
}
