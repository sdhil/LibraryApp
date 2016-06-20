package com.gcit.lms.domain;

public class User {
	private String username;
	private String password;
	private int roleid;
	
	public User() {
		
	}

	public User(String username, String password, int roleid) {
		super();
		this.username = username;
		this.password = password;
		this.roleid = roleid;
	}

	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

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

	public int getRoleid() {
		return roleid;
	}

	public void setRoleid(int roleid) {
		this.roleid = roleid;
	}
	
	
}
