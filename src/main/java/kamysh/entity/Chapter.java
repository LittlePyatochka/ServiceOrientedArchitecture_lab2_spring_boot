package kamysh.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@Entity(name = "CHAPTER")
public class Chapter {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NAME")
    @NotBlank(message = "Field 'name' must not be blank")
    private String name; //Поле не может быть null, Строка не может быть пустой

    @Column(name = "PARENT_LEGION")
    private String parentLegion;

    public Chapter(String name, String parentLegion) {
        this.name = name;
        this.parentLegion = parentLegion;
    }
}
