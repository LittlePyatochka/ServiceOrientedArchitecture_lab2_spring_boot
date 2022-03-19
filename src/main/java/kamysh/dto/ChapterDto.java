package kamysh.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.xml.bind.annotation.XmlRootElement;

@Data
@NoArgsConstructor
@XmlRootElement
public class ChapterDto {
    private Long id;
    @NotBlank(message = "Field 'name' must not be blank")
    private String name;
    private String parentLegion;
}

