package lima.jefferson.yaloreactive.client;

import lima.jefferson.yaloreactive.model.Author;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@Component
public class AuthorsClient extends Client {

  public AuthorsClient(@Value("${url.authors}") String url, WebClient webClient) {
    super(url, webClient);
  }

  public Flux<Author> getAuthors() {
    return this.getFlux(this.getUrl(), Author.class);
  }

}
