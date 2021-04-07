package kr.co.study.spring.webflux.biz;

import kr.co.study.spring.webflux.biz.dao.UserDao;
import kr.co.study.spring.webflux.biz.handler.UserHandlerAdapter;
import kr.co.study.spring.webflux.config.H2R2dbcConfig;
import kr.co.study.spring.webflux.config.SpringWebFluxConfig;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.context.ApplicationContext;
import org.springframework.r2dbc.core.DatabaseClient;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.reactive.server.WebTestClient;

@ContextConfiguration(classes = {
        SpringWebFluxConfig.class,
        UserHandlerAdapter.class,
        UserDao.class,
        H2R2dbcConfig.class,
        DatabaseClient.class
})
@TestPropertySource("classpath:application.yml")
@WebFluxTest
public class UserHandlerAdapterTest {

    @Autowired
    ApplicationContext applicationContext;

    WebTestClient webTestClient;

    @BeforeEach
    public void setUp() {
        webTestClient = WebTestClient.bindToApplicationContext(applicationContext).build();
    }

    @Test
    void userHandlerAdapterTest() {
        webTestClient.get()
                .exchange()
                .expectStatus()
                .isOk()
                .expectBody(Object.class)
                .value(System.out::println);
    }
}
