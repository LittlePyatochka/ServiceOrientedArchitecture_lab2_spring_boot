package kamysh.entity;

import com.vladmihalcea.hibernate.type.basic.PostgreSQLEnumType;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity(name = "SPACE_MARINE")
@TypeDef(name = "pgsql_enum", typeClass = PostgreSQLEnumType.class)
public class SpaceMarine {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически

    @Column(name = "NAME")
    @NotBlank(message = "Field 'name' cannot be blank")
    private String name; //Поле не может быть null, Строка не может быть пустой

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "COORDINATES")
    @NotNull(message = "Field 'coordinates' cannot be null")
    private Coordinates coordinates; //Поле не может быть null

    @Column(name = "CREATION_DATE")
    private Date creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически

    @Column(name = "HEALTH")
    @NotNull(message = "Field 'health' cannot be null")
    @Min(value = 0, message = "'health' min value is 0")
    private Float health; //Значение поля должно быть больше 0

    @Column(name = "HEART_COUNT")
    @Max(value = 3, message = "'heartCount' max value is 3")
    @Min(value = 0, message = "'heartCount' min value is 0")
    @NotNull(message = "Field 'heartCount' cannot be null")
    private Long heartCount; //Поле не может быть null, Значение поля должно быть больше 0, Максимальное значение поля: 3

    @Column(name = "LOYAL")
    private boolean loyal;

    @Column(name = "CATEGORY")
    @Enumerated(EnumType.STRING)
    @Type(type = "pgsql_enum")
    @NotNull(message = "Field 'category' cannot be null")
    private AstartesCategory category; //Поле не может быть null

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "CHAPTER")
    @NotNull(message = "Field 'chapter' cannot be null")
    private Chapter chapter; //Поле не может быть null
}
