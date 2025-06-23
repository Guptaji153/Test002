package com.java.lib.model;

public class AdminUser {

	private String adminUserName;
	private String password;
	public String getAdminName() {
		return adminUserName;
	}
	public AdminUser(String adminUserName, String password) {
		super();
		this.adminUserName = adminUserName;
		this.password = password;
	}
	public AdminUser() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getAdminUserName() {
		return adminUserName;
	}
	public void setAdminUserName(String adminUserName) {
		this.adminUserName = adminUserName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	
	
}
