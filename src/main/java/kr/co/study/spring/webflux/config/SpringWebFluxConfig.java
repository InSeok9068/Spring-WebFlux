package kr.co.study.spring.webflux.config;

import kr.co.study.spring.webflux.biz.handler.UserHandlerAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.config.WebFluxConfigurer;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@RequiredArgsConstructor
@Configuration
@EnableWebFlux
public class SpringWebFluxConfig implements WebFluxConfigurer {

    private final UserHandlerAdapter userHandlerAdapter;

    @Bean
    RouterFunction<ServerResponse> routerFunction() {
        return RouterFunctions.route().
                GET("", userHandlerAdapter.selectUserList)
                .build();
    }

}
