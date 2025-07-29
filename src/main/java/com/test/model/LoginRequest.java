package com.test.model;

import java.io.Serializable;

public class LoginRequest implements Serializable {

	private static final long serialVersionUID = 5926468583005150707L;
	
	private String username;
	private String password;
	private long time;
	
	//need default constructor for JSON Parsing
	public LoginRequest()
	{
		
	}

	public LoginRequest(String username, String password, long time) {
		this.setUsername(username);
		this.setPassword(password);
		this.setTime(time);
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

	public long getTime() {
		return this.time;
	}

	public void setTime(long time) {
		this.time = time;
	}
}