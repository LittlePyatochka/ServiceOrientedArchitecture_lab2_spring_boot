package kamysh.exceptions;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class EntityEntryNotFound extends Exception {
    private Long id;

    public EntityEntryNotFound(String message, Long id) {
        super(message);
        this.id = id;
    }

    public EntityEntryNotFound(Long id) {
        super("Item not found");
        this.id = id;
    }

    public EntityEntryNotFound() {
        super("Item not found");
    }
}
