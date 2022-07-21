package com.aeq.portal.controller;

import java.net.URI;

import org.keycloak.adapters.springsecurity.client.KeycloakRestTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aeq.portal.constants.AppConstant;
import com.aeq.portal.dto.request.User;

@RestController
@RequestMapping("/admin/o/api")
public class UserController {

	private KeycloakRestTemplate restTemplate;

	private String keycloakServerUrl;

	public UserController(KeycloakRestTemplate restTemplate,
			@Value("${keycloak.auth-server-url}") String keycloakServerUrl) {
		this.restTemplate = restTemplate;
		this.keycloakServerUrl = keycloakServerUrl;
	}

	@GetMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> getAllUsers() {

		return restTemplate.getForEntity(URI.create(keycloakServerUrl + AppConstant.REALM_URL + "/users/"),
				String.class);
	}

	@GetMapping(value = "/users/{user_id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> getUser(@PathVariable("user_id") String userId) {

		return restTemplate.getForEntity(URI.create(keycloakServerUrl + AppConstant.REALM_URL + "/users/" + userId),
				String.class);
	}

	@PostMapping(value = "/users", consumes = "application/json", produces = "application/json")
	public ResponseEntity<String> createUser(@RequestBody User user) {
		System.out.println("IN POST");
		System.out.println(user.toString());
		return restTemplate.postForEntity(URI.create(keycloakServerUrl + AppConstant.REALM_URL + "/users"), user,
				String.class);
	}

}
