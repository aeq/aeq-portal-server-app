package com.aeq.portal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class AeqPortalConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(AeqPortalConfigServerApplication.class, args);
	}

}
