/**
 * 
 */
package com.aeq.portal.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

/**
 * @author abhisheknair
 *
 */

@Configuration
@EnableWebFluxSecurity
public class SecurityConfig {

	@Bean
	SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {
		http.authorizeExchange(exchange -> exchange.anyExchange().authenticated())
				.oauth2ResourceServer(ServerHttpSecurity.OAuth2ResourceServerSpec::jwt);

		http.csrf().disable();
		return http.build();
	}

}
