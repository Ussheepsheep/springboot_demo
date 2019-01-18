package com.githup.bigminions.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by daren on 2017/2/10.
 */
@ConfigurationProperties(prefix = "server")
@Component
@Data
public class ServerConfig {

    private String port;

    private String desc;

    private String uuid;
}
