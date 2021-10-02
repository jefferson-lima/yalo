package lima.jefferson.yaloreactive.repository;

import java.util.List;
import lima.jefferson.yaloreactive.client.CommentsClient;
import lima.jefferson.yaloreactive.model.Comment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
@RequiredArgsConstructor
public class CommentRepository {
  private final CommentsClient client;

  public Mono<List<Comment>> findByPostId(Integer postId) {
    return this.client
        .getComments(postId)
        .collectList();
  }
}
