package kamysh.dto;

import kamysh.entity.AstartesCategory;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

@Data
@XmlRootElement
@NoArgsConstructor
public class SpaceMarineWithIdDto {
    @Min(value = 0, message = "Id min value is 0")
    private Long id;

    @NotBlank(message = "Field 'name' cannot be blank")
    String name;

    @NotNull(message = "Field 'coordinates' cannot be null")
    @Min(value = 0, message = "coordinates min value is 0")
    private Long coordinates;

    private Date creationDate;

    @NotNull(message = "Field 'health' cannot be null")
    @Min(value = 0, message = "'health' min value is 0")
    private Float health;

    @Max(value = 3, message = "'heartCount' max value is 3")
    @Min(value = 0, message = "'heartCount' min value is 0")
    @NotNull(message = "Field 'heartCount' cannot be null")
    private Long heartCount;

    private boolean loyal;

    @NotNull(message = "Field 'category' cannot be null")
    private AstartesCategory category;

    @Min(value = 0, message = "chapter min value is 0")
    @NotNull(message = "Field 'chapter' cannot be null")
    private Long chapter;
}
