package lima.jefferson.yaloreactive.repository;

import java.util.Comparator;
import lima.jefferson.yaloreactive.api.Page;
import lima.jefferson.yaloreactive.client.PostsClient;
import lima.jefferson.yaloreactive.model.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
@RequiredArgsConstructor
public class PostsRepository {
  private final PostsClient client;

  public Flux<Post> findAll(Page page) {
    return this.findAll()
        .sort(Comparator.comparing(Post::getId))
        .skip(page.getIndex())
        .take(page.getSize());
  }

  public Flux<Post> findAll() {
    return this.client.getPosts();
  }
}
