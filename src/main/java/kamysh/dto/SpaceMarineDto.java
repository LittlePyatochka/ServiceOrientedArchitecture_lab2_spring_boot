package kamysh.dto;

import kamysh.entity.AstartesCategory;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

@Data
@XmlRootElement
@NoArgsConstructor
public class SpaceMarineDto {
    private Long id;
    private String name;
    private CoordinatesDto coordinates;
    private Date creationDate;
    private Float health;
    private Long heartCount;
    private boolean loyal;
    private AstartesCategory category;
    private ChapterDto chapter;
}
