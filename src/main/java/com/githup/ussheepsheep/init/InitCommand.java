package com.githup.ussheepsheep.init;

import com.githup.ussheepsheep.config.ServerConfig;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Created by daren on 2017/2/9.
 * you can do something before application start, like load data, it ask you to implement CommandLineRunner
 */
@Component
public class InitCommand implements CommandLineRunner {

    private Logger logger = LogManager.getLogger(getClass());

    @Autowired
    private ServerConfig serverConfig;

    @Override
    public void run(String... strings) throws Exception {
        logger.info("server uuid : {}, port : {}, goodDesc : {}", serverConfig.getUuid(), serverConfig.getPort(), serverConfig.getDesc());
    }
}
