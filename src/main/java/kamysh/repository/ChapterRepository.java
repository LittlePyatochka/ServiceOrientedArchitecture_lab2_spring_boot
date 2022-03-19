package kamysh.repository;

import kamysh.entity.Chapter;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ChapterRepository extends CrudRepository<Chapter, Long> {
    List<Chapter> findAll();

    Optional<Chapter> findById(Long id);
}
