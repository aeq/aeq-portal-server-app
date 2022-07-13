/**
 * 
 */
package com.aeq.portal.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author abhisheknair
 *
 */

@ResponseStatus(value = HttpStatus.UNAUTHORIZED)
public class ExpiredJwtTokenException extends RuntimeException {

	private static final long serialVersionUID = -2155605321210061614L;

	public ExpiredJwtTokenException(String message) {
		super(message);
	}
}
