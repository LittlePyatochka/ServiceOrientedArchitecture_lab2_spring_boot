package kamysh.exceptions;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class FieldNotFoundException extends Exception {
    private String field;

    public FieldNotFoundException(String field) {
        super("Field not found");
        this.field = field;
    }
}
