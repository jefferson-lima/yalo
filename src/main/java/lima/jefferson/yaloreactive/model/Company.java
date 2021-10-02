package lima.jefferson.yaloreactive.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Company {
  @JsonProperty("name")
  private String name;

  @JsonProperty("catchPhrase")
  private String catchPhrase;

  @JsonProperty("bs")
  private String bs;
}
