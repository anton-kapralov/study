package kae.hello.hellospringcloudfunctions;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import reactor.core.publisher.Flux;

import java.util.function.Function;

@SpringBootApplication
public class HelloSpringCloudFunctionsApplication {

  @Bean
  public Function<Flux<Integer>, Flux<Integer>> sqr() {
    return integerFlux -> integerFlux.map(a -> a * a);
  }

  @Bean
  public Function<Integer, Integer> increment() {
    return a -> a + 2;
  }

  public static void main(String[] args) {
    SpringApplication.run(HelloSpringCloudFunctionsApplication.class, args);
  }
}
