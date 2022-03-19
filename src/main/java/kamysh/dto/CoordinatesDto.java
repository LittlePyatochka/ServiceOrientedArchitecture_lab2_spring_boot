package kamysh.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

@Data
@NoArgsConstructor
@XmlRootElement
public class CoordinatesDto {
    private Long id;
    @NotNull(message = "Field 'x' must be specified in request body")
    private Long x;
    @NotNull(message = "Field 'y' must be specified in request body")
    private Integer y;
}

