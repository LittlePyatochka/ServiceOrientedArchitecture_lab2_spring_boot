package kamysh.utils;

import kamysh.exceptions.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Error {
    private ErrorCode errorCode;

    private String message;
}
