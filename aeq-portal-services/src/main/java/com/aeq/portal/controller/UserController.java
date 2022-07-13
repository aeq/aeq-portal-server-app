/**
 * 
 */
package com.aeq.portal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aeq.portal.entity.SecurityUser;
import com.aeq.portal.service.UserService;

/**
 * @author abhisheknair
 *
 * @Desc User Controller for handling the user details
 *       requests from client
 */

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/getUsers")
	public ResponseEntity<List<SecurityUser>> getAllUsers() {
		return new ResponseEntity<List<SecurityUser>>(userService.getAllUsers(), HttpStatus.OK);
	}
}
