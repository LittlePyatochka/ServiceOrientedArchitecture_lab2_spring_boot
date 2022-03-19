package kamysh.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@Entity(name = "COORDINATES")
public class Coordinates {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "X")
    @NotNull(message = "Field 'x' must be specified in request body")
    private Long x; //Поле не может быть null

    @Column(name = "Y")
    @NotNull(message = "Field 'y' must be specified in request body")
    private Integer y; //Поле не может быть null

    public Coordinates(Long x, Integer y) {
        this.x = x;
        this.y = y;
    }
}
