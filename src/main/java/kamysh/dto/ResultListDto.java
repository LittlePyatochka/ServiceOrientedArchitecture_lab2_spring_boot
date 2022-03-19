package kamysh.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@XmlRootElement
public class ResultListDto<T> {
    private List<T> results;
    @JacksonXmlElementWrapper(useWrapping = false)
    public List<T> getResults() {
        return results;
    }
}