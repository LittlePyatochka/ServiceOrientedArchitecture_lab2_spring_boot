package kamysh.exceptions;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class IncorrectOrderString extends Exception {
    public IncorrectOrderString(String mess) {
        super("Incorrect Order String " + mess);
    }

    public IncorrectOrderString() {
        super("Incorrect Order String");
    }
}
