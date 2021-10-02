package lima.jefferson.yaloreactive.model;

import java.util.List;
import lombok.Builder;
import lombok.Data;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Data
@Builder
@Jacksonized
public class Post {
  Integer userId;
  Integer id;
  String title;
  String body;
  Author author;
  List<Comment> comments;
}
