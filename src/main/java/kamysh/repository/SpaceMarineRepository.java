package kamysh.repository;

import kamysh.entity.SpaceMarine;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface SpaceMarineRepository extends CrudRepository<SpaceMarine, Long>, SpaceMarineRepositoryCustom {
    List<SpaceMarine> findAll();


    Optional<SpaceMarine> findById(Long id);

}
