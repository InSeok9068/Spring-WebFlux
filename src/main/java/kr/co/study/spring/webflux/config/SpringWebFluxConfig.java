package kr.co.study.spring.webflux.config;

import kr.co.study.spring.webflux.biz.UserHandlerAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.config.WebFluxConfigurer;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Configuration
@EnableWebFlux
public class SpringWebFluxConfig implements WebFluxConfigurer {

    @Autowired
    UserHandlerAdapter userHandlerAdapter;

    @Bean
    RouterFunction<ServerResponse> routerFunction() {
        return RouterFunctions.route().
                GET("", this::handlerFunction)
                .build();
    }

    private Mono<ServerResponse> handlerFunction(ServerRequest request) {
        return ServerResponse.ok().body(userHandlerAdapter.selectUserList(), Object.class);
    }
}
