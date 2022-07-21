package com.aeq.portal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class AeqPortalDiscoveryServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(AeqPortalDiscoveryServerApplication.class, args);
	}

}
