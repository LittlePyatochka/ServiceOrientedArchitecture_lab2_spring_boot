package kamysh.mapper;

import kamysh.dto.CoordinatesDto;
import kamysh.entity.Coordinates;
import org.springframework.stereotype.Component;

@Component
public class CoordinatesMapper {

    public Coordinates dtoToEntity(CoordinatesDto dto) {
        Coordinates coordinates = new Coordinates();

        coordinates.setId(dto.getId());
        coordinates.setX(dto.getX());
        coordinates.setY(dto.getY());

        return coordinates;
    }

    public CoordinatesDto entityToDto(Coordinates entity) {
        CoordinatesDto coordinatesDto = new CoordinatesDto();

        coordinatesDto.setId(entity.getId());
        coordinatesDto.setX(entity.getX());
        coordinatesDto.setY(entity.getY());

        return coordinatesDto;
    }

}
