package kr.co.study.spring.webflux.biz;

import org.springframework.r2dbc.core.DatabaseClient;
import org.springframework.stereotype.Repository;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Repository
public class UserHandlerAdapter {

    private final DatabaseClient databaseClient;

    public UserHandlerAdapter(DatabaseClient databaseClient) {
        this.databaseClient = databaseClient;
    }

    public Mono<ServerResponse> selectUserList() {
        return ServerResponse.ok().body(databaseClient.sql("SELECT * FROM USERS").fetch().all().collectList(),Object.class);
    }
}
