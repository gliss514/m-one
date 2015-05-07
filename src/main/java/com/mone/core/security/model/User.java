package com.mone.core.security.model;

import org.springframework.data.mongodb.core.mapping.Document;
import com.mone.core.data.BaseObject;

@Document
public class User extends BaseObject {

	private static final long serialVersionUID = -3264669655420468440L;

	private String username;

	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
