package com.aeq.portal.entity;

import java.util.Date;

/**
 * @author abhisheknair
 *
 * @Desc ErrorObject Class for mapping error as HTTP Servlet response from Exceptions
 */

public class ErrorObject {

	private Integer statusCode;

	private String message;

	private Date timestamp;

	public Integer getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

}
