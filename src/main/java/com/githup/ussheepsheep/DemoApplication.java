package com.githup.ussheepsheep;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

import java.net.Inet4Address;
import java.net.UnknownHostException;

@SpringBootApplication
@EnableAutoConfiguration
@EnableGlobalMethodSecurity
public class DemoApplication {

    private static final Logger logger = LoggerFactory.getLogger(DemoApplication.class);

    public static void main(String[] args) {
        Environment env = SpringApplication.run(DemoApplication.class, args).getEnvironment();
        try {
            String host = Inet4Address.getLocalHost().getHostAddress();
            String port = env.getProperty("server.port");
            logger.info("API DOC {}:{}/swagger-ui.html", host, port);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}

