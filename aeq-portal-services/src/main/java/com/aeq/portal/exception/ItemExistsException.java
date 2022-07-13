package com.aeq.portal.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author abhisheknair
 *
 */

@ResponseStatus(value = HttpStatus.CONFLICT)
public class ItemExistsException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public ItemExistsException(String message) {
		super(message);
	}
}
