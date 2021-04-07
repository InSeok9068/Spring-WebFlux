package kr.co.study.spring.webflux.biz.handler;

import kr.co.study.spring.webflux.biz.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.HandlerFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;
import reactor.core.publisher.SignalType;

import java.util.logging.Level;

@Component
public class UserHandlerAdapter {

    @Autowired
    private UserDao userDao;

    public HandlerFunction<ServerResponse> selectUserList = request ->
            Mono.just(request)
                    .log("Request", Level.INFO,true)
                    .flatMap(req -> userDao.selectUserList())
                    .log("Response", Level.INFO,true, SignalType.ON_NEXT)
                    .flatMap(users -> ServerResponse.ok().bodyValue(users));
}