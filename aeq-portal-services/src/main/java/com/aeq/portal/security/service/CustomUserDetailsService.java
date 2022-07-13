/**
 * 
 */
package com.aeq.portal.security.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.aeq.portal.entity.SecurityUser;
import com.aeq.portal.repository.SecurityUserRepository;

/**
 * @author abhisheknair
 *
 * @Desc Custom User Details Service Implementation for loading user by Email
 *       and Mapping Roles to Spring Security Roles, The login credentials are
 *       authenticated using Spring UsernamePasswordAuthenticationToken class
 */

@Service
public class CustomUserDetailsService implements UserDetailsService {

	String ROLE_PREFIX = "ROLE_";

	@Autowired
	private SecurityUserRepository securityUserRepository;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		SecurityUser existingUser = securityUserRepository.findByEmail(username)
				.orElseThrow(() -> new UsernameNotFoundException("User not found for the email:" + username));

		return new User(existingUser.getEmail(),
				existingUser.getPassword(), getGrantedAuthorities(existingUser.getRole()));
	}

	public void authenticate(String email, String password) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));
		} catch (DisabledException e) {
			throw new Exception("User disabled");
		} catch (BadCredentialsException e) {
			throw new Exception("Bad Credentials");
		}
	}

	private List<GrantedAuthority> getGrantedAuthorities(String role) {
		List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
		grantedAuthorities.add(new SimpleGrantedAuthority((ROLE_PREFIX + role)));
		return grantedAuthorities;
	}

}
