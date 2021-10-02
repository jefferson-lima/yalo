package lima.jefferson.yaloreactive.client;

import lima.jefferson.yaloreactive.model.Post;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@Component
public class PostsClient extends Client {

  public PostsClient(@Value("${url.posts}") String url, WebClient webClient) {
    super(url, webClient);
  }

  public Flux<Post> getPosts() {
    return this.getFlux(this.getUrl(), Post.class);
  }
}
