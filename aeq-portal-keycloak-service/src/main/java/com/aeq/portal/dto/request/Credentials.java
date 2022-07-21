/**
 * 
 */
package com.aeq.portal.dto.request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author abhisheknair
 *
 */
public class Credentials {

	@NotNull(message = "Password type should not be empty")
	final private String type = "password";

	@NotNull(message = "Password should not be empty")
	@Size(min = 5, message = "Password should be atleast 5 characters")
	private String value;

	final private boolean temporary = false;

	public boolean isTemporary() {
		return temporary;
	}

	public String getType() {
		return type;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "Credentials [type=" + type + ", value=" + value + ", temporary=" + temporary + "]";
	}

}
