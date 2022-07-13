/**
 * 
 */
package com.aeq.portal.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author abhisheknair
 *
 */
public class JwtResponse {

	@JsonProperty("token")
	private String token;

	public JwtResponse(String token) {
		this.token = token;
	}

	public String getToken() {
		return token;
	}
}
