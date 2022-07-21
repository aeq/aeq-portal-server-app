/**
 * 
 */
package com.aeq.portal.config;

import org.keycloak.adapters.springboot.KeycloakSpringBootConfigResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author abhisheknair
 *
 */

@Configuration
public class KeycloakConfig {
	/**
	 * Let Spring Boot establish the keycloak config
	 * 
	 * @return
	 */
	/**
	 * Load Keycloak configuration from application.properties or application.yml,
	 * rather than keycloak.json.
	 */
	@Bean
	KeycloakSpringBootConfigResolver keycloakConfigResolver() {
		return new KeycloakSpringBootConfigResolver();
	}
}
