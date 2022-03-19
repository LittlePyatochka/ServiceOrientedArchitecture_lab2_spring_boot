package kamysh.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.stream.Stream;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StreamWrapper<T> {
    private Stream<T> stream;
}