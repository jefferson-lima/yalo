package lima.jefferson.yaloreactive.service;

import lima.jefferson.yaloreactive.api.Page;
import lima.jefferson.yaloreactive.client.PostsClient;
import lima.jefferson.yaloreactive.model.Post;
import lima.jefferson.yaloreactive.repository.AuthorRepository;
import lima.jefferson.yaloreactive.repository.CommentRepository;
import lima.jefferson.yaloreactive.repository.PostsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class PostsService {
  private final PostsRepository postsRepository;
  private final AuthorRepository authorRepository;
  private final CommentRepository commentRepository;

  public Flux<Post> getPosts(Page page) {
    return this.postsRepository
        .findAll(page)
        .flatMap(this::findAuthor)
        .flatMap(this::findComments);
  }

  private Mono<Post> findAuthor(Post post) {
    return this.authorRepository
        .findById(post.getId())
        .doOnNext(post::setAuthor)
        .thenReturn(post);
  }

  private Mono<Post> findComments(Post post) {
    return this.commentRepository
        .findByPostId(post.getId())
        .doOnNext(post::setComments)
        .thenReturn(post);
  }
}
