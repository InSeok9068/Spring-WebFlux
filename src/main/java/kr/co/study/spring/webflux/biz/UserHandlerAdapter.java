package kr.co.study.spring.webflux.biz;

import org.springframework.r2dbc.core.DatabaseClient;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

import java.util.Map;

@Repository
public class UserHandlerAdapter {

    private final DatabaseClient databaseClient;

    public UserHandlerAdapter(DatabaseClient databaseClient) {
        this.databaseClient = databaseClient;
    }

    public Flux<Map<String, Object>> selectUserList() {
        return databaseClient.sql("SELECT * FROM USERS").fetch().all();
    }
}
