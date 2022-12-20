package com.test.model;

import java.io.Serializable;

public class LoginRequest implements Serializable {

	private static final long serialVersionUID = 5926468583005150707L;
	
	private String username;
	private String password;
	private long timeinminutes;
	
	//need default constructor for JSON Parsing
	public LoginRequest()
	{
		
	}

	public LoginRequest(String username, String password, long timeinminutes) {
		this.setUsername(username);
		this.setPassword(password);
		this.setTimeinminutes(timeinminutes);
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public long getTimeinminutes() {
		return this.timeinminutes;
	}

	public void setTimeinminutes(long timeinminutes) {
		this.timeinminutes = timeinminutes;
	}
}