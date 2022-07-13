/**
 * 
 */
package com.aeq.portal.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.aeq.portal.entity.SecurityUser;
import com.aeq.portal.model.request.LoginModel;
import com.aeq.portal.model.request.UserModel;
import com.aeq.portal.model.response.JwtResponse;
import com.aeq.portal.security.service.CustomUserDetailsService;
import com.aeq.portal.service.UserService;
import com.aeq.portal.util.JwtTokenUtil;

/**
 * @author abhisheknair
 *
 * @Desc Authentication Controller for handling the user login and user creation
 *       requests from client
 */

@RestController
public class AuthenticationController {

	@Autowired
	private UserService userService;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private CustomUserDetailsService userDetailsService;

	@PostMapping("/auth")
	public ResponseEntity<JwtResponse> login(@RequestBody LoginModel loginModel) throws Exception {
		userDetailsService.authenticate(loginModel.getEmail(), loginModel.getPassword());
		final UserDetails userDetails = userDetailsService.loadUserByUsername(loginModel.getEmail());

		// Generate JWT Token
		final String token = jwtTokenUtil.generateToken(userDetails);

		return new ResponseEntity<JwtResponse>(new JwtResponse(token), HttpStatus.OK);
	}

	@PostMapping("/user/create")
	public ResponseEntity<SecurityUser> save(@Valid @RequestBody UserModel user) {

		// The UserModel DTO is received and validated to create new users using
		// UserService
		return new ResponseEntity<SecurityUser>(userService.createUser(user), HttpStatus.CREATED);
	}
}
