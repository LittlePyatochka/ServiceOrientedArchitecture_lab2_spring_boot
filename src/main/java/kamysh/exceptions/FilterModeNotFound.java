package kamysh.exceptions;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class FilterModeNotFound extends Exception {
    String filterMode;

    public FilterModeNotFound(String message, String filterMode) {
        super(message);
        this.filterMode = filterMode;
    }

    public FilterModeNotFound(String filterMode) {
        super("Filter mode not found");
        this.filterMode = filterMode;
    }
}
