/**
 * 
 */
package com.aeq.portal.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.aeq.portal.entity.SecurityUser;
import com.aeq.portal.exception.ItemExistsException;
import com.aeq.portal.exception.ResourceNotFoundException;
import com.aeq.portal.model.request.UserModel;
import com.aeq.portal.repository.SecurityUserRepository;
import com.aeq.portal.service.UserService;

/**
 * @author abhisheknair
 *
 */

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private PasswordEncoder bcryptEncoder;

	@Autowired
	private SecurityUserRepository securityUserRepository;

	@Override
	public SecurityUser createUser(UserModel user) {
		if (securityUserRepository.existsByEmail(user.getEmail())) {
			throw new ItemExistsException("User is already register with email:" + user.getEmail());
		}
		SecurityUser securityUser = new SecurityUser();
		BeanUtils.copyProperties(user, securityUser);
		
		securityUser.setPassword(bcryptEncoder.encode(securityUser.getPassword()));
		return securityUserRepository.save(securityUser);
	}

	@Override
	public SecurityUser readUser() {
		Long userId = getLoggedInUser().getId();
		return securityUserRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User not found for the id:" + userId));
	}

	@Override
	public SecurityUser getLoggedInUser() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String email = authentication.getName();

		return securityUserRepository.findByEmail(email)
				.orElseThrow(() -> new UsernameNotFoundException("User not found for the email" + email));
	}

	@Override
	public List<SecurityUser> getAllUsers() {
		return securityUserRepository.findAll();
		
	}

}
