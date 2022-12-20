package com.test.model;

import java.io.Serializable;

public class TokenValidationResponse implements Serializable {

	private static final long serialVersionUID = -8091879091924046844L;
	private final String status;

	public TokenValidationResponse(String status) {
		this.status = status;
	}

	public String getStatus() {
		return this.status;
	}
}