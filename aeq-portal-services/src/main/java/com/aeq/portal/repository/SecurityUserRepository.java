/**
 * 
 */
package com.aeq.portal.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aeq.portal.entity.SecurityUser;

/**
 * @author abhisheknair
 *
 */

@Repository
public interface SecurityUserRepository extends JpaRepository<SecurityUser, Long> {
	Boolean existsByEmail(String email);

	Optional<SecurityUser> findByEmail(String email);
}
