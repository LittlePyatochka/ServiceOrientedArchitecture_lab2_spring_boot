package kamysh.controller;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Optional;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FilterConfiguration {
    private Integer count;
    private Integer page;
    private List<String> order;
    private List<String> filter;

    public Optional<Integer> getCount() {
        return Optional.ofNullable(count);
    }

    public Optional<Integer> getPage() {
        return Optional.ofNullable(page);
    }
}
