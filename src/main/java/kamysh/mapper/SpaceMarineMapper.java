package kamysh.mapper;

import kamysh.dto.SpaceMarineDto;
import kamysh.dto.SpaceMarineWithIdDto;
import kamysh.entity.SpaceMarine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SpaceMarineMapper {
    private final CoordinatesMapper coordinatesMapper;
    private final ChapterMapper chapterMapper;

    @Autowired
    public SpaceMarineMapper(CoordinatesMapper coordinatesMapper, ChapterMapper chapterMapper) {
        this.coordinatesMapper = coordinatesMapper;
        this.chapterMapper = chapterMapper;
    }


    public SpaceMarine dtoToEntity(SpaceMarineWithIdDto dto) {
        SpaceMarine spaceMarine = new SpaceMarine();

        spaceMarine.setId(dto.getId());
        spaceMarine.setName(dto.getName());
        spaceMarine.setCreationDate(dto.getCreationDate());
        spaceMarine.setHealth(dto.getHealth());
        spaceMarine.setHeartCount(dto.getHeartCount());
        spaceMarine.setLoyal(dto.isLoyal());
        spaceMarine.setCategory(dto.getCategory());

        return spaceMarine;
    }

    public SpaceMarineDto entityToDto(SpaceMarine entity) {
        SpaceMarineDto spaceMarineDto = new SpaceMarineDto();

        spaceMarineDto.setId(entity.getId());
        spaceMarineDto.setName(entity.getName());
        spaceMarineDto.setCoordinates(coordinatesMapper.entityToDto(entity.getCoordinates()));
        spaceMarineDto.setCreationDate(entity.getCreationDate());

        spaceMarineDto.setHealth(entity.getHealth());
        spaceMarineDto.setHeartCount(entity.getHeartCount());
        spaceMarineDto.setLoyal(entity.isLoyal());
        spaceMarineDto.setCategory(entity.getCategory());
        if (entity.getChapter() != null) {
            spaceMarineDto.setChapter(chapterMapper.entityToDto(entity.getChapter()));
        }

        return spaceMarineDto;
    }

}
