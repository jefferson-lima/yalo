package lima.jefferson.yaloreactive.model;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Value
@Builder
@Jacksonized
public class Comment {
  Integer postId;
  Integer id;
  String name;
  String email;
  String body;
}
