package lima.jefferson.yaloreactive.api;

import lima.jefferson.yaloreactive.model.Post;
import lima.jefferson.yaloreactive.service.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequiredArgsConstructor
public class PostsApi {

  private final PostsService postsService;

  @GetMapping("posts")
  public Flux<Post> getPosts(Page page) {
    return this.postsService.getPosts(page);
  }
}
