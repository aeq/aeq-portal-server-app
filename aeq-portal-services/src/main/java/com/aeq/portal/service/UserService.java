package com.aeq.portal.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.aeq.portal.entity.SecurityUser;
import com.aeq.portal.model.request.UserModel;

/**
 * @author abhisheknair
 *
 */

@Service
public interface UserService {
	SecurityUser createUser(UserModel user);

	SecurityUser readUser();

	SecurityUser getLoggedInUser();

	List<SecurityUser> getAllUsers();
}
