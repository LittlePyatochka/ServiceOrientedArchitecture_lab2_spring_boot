package kamysh.mapper;

import kamysh.dto.ChapterDto;
import kamysh.entity.Chapter;
import org.springframework.stereotype.Component;

@Component
public class ChapterMapper {

    public Chapter dtoToEntity(ChapterDto dto) {
        Chapter person = new Chapter();

        person.setId(dto.getId());
        person.setName(dto.getName());
        person.setParentLegion(dto.getParentLegion());

        return person;
    }

    public ChapterDto entityToDto(Chapter entity) {
        ChapterDto personDto = new ChapterDto();

        personDto.setId(entity.getId());
        personDto.setName(entity.getName());
        personDto.setParentLegion(entity.getParentLegion());

        return personDto;
    }

}
