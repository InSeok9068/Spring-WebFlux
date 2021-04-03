package kr.co.study.spring.webflux.biz.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.r2dbc.core.DatabaseClient;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Map;

@Repository
public class UserDao {

    @Autowired
    private DatabaseClient databaseClient;

    public Mono<List<Map<String, Object>>> selectUserList(){
        return databaseClient.sql("SELECT * FROM USERS").fetch().all().collectList();
    }

}
