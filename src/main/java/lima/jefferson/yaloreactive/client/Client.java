package lima.jefferson.yaloreactive.client;

import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

public abstract class Client {
  private final String url;
  private final WebClient webClient;

  public Client(String url, WebClient webClient) {
    this.url = url;
    this.webClient = webClient;
  }

  protected <T> Flux<T> getFlux(String url, Class<T> type) {
    return this.webClient
        .get()
        .uri(url)
        .retrieve()
        .bodyToFlux(type);
  }

  protected String getUrl() {
    return this.url;
  }
}
