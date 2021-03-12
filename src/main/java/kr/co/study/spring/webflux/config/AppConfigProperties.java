package kr.co.study.spring.webflux.config;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
@Data
@Slf4j
@ConfigurationProperties(prefix = "app-config")
public class AppConfigProperties implements InitializingBean {

    @Autowired
    Environment environment;

    private WebFluxConfigProperties webFlux = new WebFluxConfigProperties();

    @Override
    public void afterPropertiesSet() throws Exception {
        log.debug("\r\n[AppConfig] - active profiles: {}\r\n{}", environment, this);
    }

    @Data
    public static class WebFluxConfigProperties {

        private boolean logEnabled = false;

        private int h2ConsolePort;

        public void appendLog(StringBuilder sb, String prefix) {
            sb.append(prefix + "logEnabled: " + logEnabled + "\r\n");
        }
    }
}
