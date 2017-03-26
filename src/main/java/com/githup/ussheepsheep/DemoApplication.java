package com.githup.ussheepsheep;

import com.githup.ussheepsheep.handler.GlobalException;
import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.net.Inet4Address;
import java.net.InetAddress;

@SpringBootApplication
@EnableAutoConfiguration
public class DemoApplication {

	private static final Logger logger = Logger.getLogger(GlobalException.class);

	public static void main(String[] args) throws Exception{
		SpringApplication.run(DemoApplication.class, args);
		String address = InetAddress.getLocalHost().getHostAddress();
		logger.info("\n----------------------------------------------------------\n\t" +
				"External: \thttp://" + address + ":8080/swagger-ui.html\n----------------------------------------------------------");
		;
	}


}

