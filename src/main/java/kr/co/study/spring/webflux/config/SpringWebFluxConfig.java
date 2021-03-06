package kr.co.study.spring.webflux.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.config.WebFluxConfigurer;
import org.springframework.web.reactive.function.server.*;
import reactor.core.publisher.Mono;

@Configuration
@EnableWebFlux
public class SpringWebFluxConfig implements WebFluxConfigurer {

    @Bean
    RouterFunction<ServerResponse> routerFunction() {
        return RouterFunctions.route().
                GET("", this::handlerFunction)
                .build();
    }

    private Mono<ServerResponse> handlerFunction(ServerRequest request) {
        return ServerResponse.ok().body(Mono.just("왜 가능입니다"),String.class);
    }

}
