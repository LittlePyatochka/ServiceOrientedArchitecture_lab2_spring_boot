package kamysh.exceptions;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class IncorrectFilterString extends Exception{
    public IncorrectFilterString() {
        super("Incorrect Filter String");
    }
}
