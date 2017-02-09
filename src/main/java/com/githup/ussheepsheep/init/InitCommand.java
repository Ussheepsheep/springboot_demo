package com.githup.ussheepsheep.init;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Created by daren on 2017/2/9.
 */
@Component
public class InitCommand implements CommandLineRunner {

    /**
     * you can do something before application start, like load data
     * @param strings
     * @throws Exception
     */
    @Override
    public void run(String... strings) throws Exception {
        System.out.println("balabalabalabala .......................");
    }
}
