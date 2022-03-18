package com.grupoPZBM.backendtrabppi;

public class User {
	
	String username;
	String password;
	String email;
	String phoneNum;
	int userId;
	
	public User(String username, String password, String email, String phoneNum, int userId) {
		this.username = username;
		this.email = email;
		this.password = password;
		this.phoneNum = phoneNum;
		this.userId = userId;
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
	
	public int getUserId() {
		return userId;
	}
}
