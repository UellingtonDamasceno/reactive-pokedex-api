package pokedex.api.model;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author Uellington Damasceno
 */
@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pokemon {
    @Id
    private String id;
    private Integer number;
    private String name;
    private List<String> types;
}
