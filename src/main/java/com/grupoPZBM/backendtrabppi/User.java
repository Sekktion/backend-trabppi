package com.grupoPZBM.backendtrabppi;

public class User {
	
	String username;
	String password;
	String email;
	String phoneNum;
	
	public User(String username, String password, String email, String phoneNum) {
		this.username = username;
		this.email = email;
		this.password = password;
		this.phoneNum = phoneNum;
	}

	public String getUsername() {
		return username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getPhoneNum() {
		return phoneNum;
	}
}
