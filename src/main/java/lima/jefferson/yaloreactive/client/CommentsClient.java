package lima.jefferson.yaloreactive.client;

import lima.jefferson.yaloreactive.model.Comment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@Component
public class CommentsClient extends Client {

  public CommentsClient(@Value("${url.comments}") String url, WebClient webClient) {
    super(url, webClient);
  }

  public Flux<Comment> getComments(Integer postId) {
    return this.getFlux(getCommentsUrl(postId), Comment.class);
  }

  private String getCommentsUrl(Integer postId) {
    return String.format("%s/%d/comments", this.getUrl(), postId);
  }
}
