package lima.jefferson.yaloreactive.repository;

import java.util.Map;
import java.util.function.Function;
import lima.jefferson.yaloreactive.client.AuthorsClient;
import lima.jefferson.yaloreactive.model.Author;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
@RequiredArgsConstructor
public class AuthorRepository {
  private final AuthorsClient client;

  public Mono<Author> findById(Integer id) {
    return this.getAuthorsMap()
        .filter(map -> map.containsKey(id))
        .map(map -> map.get(id));
  }

  private Mono<Map<Integer, Author>> getAuthorsMap() {
    return this.client
        .getAuthors()
        .collectMap(Author::getId, Function.identity());
  }
}
