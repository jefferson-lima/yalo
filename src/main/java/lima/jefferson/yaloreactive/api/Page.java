package lima.jefferson.yaloreactive.api;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Page {
  Integer start = 0;
  Integer size = 10;

  public Integer getIndex() {
    return this.size * this.start;
  }
}
