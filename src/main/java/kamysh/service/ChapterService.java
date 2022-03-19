package kamysh.service;

import kamysh.dto.ChapterDto;
import kamysh.exceptions.EntityEntryNotFound;
import kamysh.exceptions.ErrorMessage;
import kamysh.mapper.ChapterMapper;
import kamysh.repository.ChapterRepository;
import kamysh.utils.Utils;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ChapterService {

    private final ChapterRepository personRepository;
    private final ChapterMapper personMapper;

    @Autowired
    public ChapterService(ChapterRepository personRepository, ChapterMapper personMapper) {
        this.personRepository = personRepository;
        this.personMapper = personMapper;
    }

    public List<ChapterDto> findAll() {
        return this.personRepository.findAll().stream().map(personMapper::entityToDto).collect(Collectors.toList());
    }

    @SneakyThrows
    public ChapterDto save(ChapterDto dto) {
        Utils.validate(dto);
        return personMapper.entityToDto(personRepository.save(personMapper.dtoToEntity(dto)));
    }

    @SneakyThrows
    public ChapterDto findById(Long id) {
        return personMapper.entityToDto(personRepository.findById(id).orElseThrow(
                () -> new EntityEntryNotFound(ErrorMessage.CHAPTER_NOT_FOUND, id)));
    }

    @SneakyThrows
    public void delete(Long id) {
        personRepository.delete(personRepository.findById(id).orElseThrow(
                () -> new EntityEntryNotFound(ErrorMessage.CHAPTER_NOT_FOUND, id)));
    }
}
