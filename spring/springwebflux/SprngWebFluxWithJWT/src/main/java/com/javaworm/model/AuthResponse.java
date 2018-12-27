package com.javaworm.model;

public class AuthResponse {
	
	private String token;

	public AuthResponse(String generateToken) {
		// TODO Auto-generated constructor stub
		this.token = generateToken;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

}
