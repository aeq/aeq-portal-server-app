package com.aeq.portal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class AeqPortalKeycloakServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AeqPortalKeycloakServiceApplication.class, args);
	}

}
