package com.capg.model;

public class UserRole {
	private String userName;
	private String password;
	private String roleCode;

	public UserRole() {
	}

	public UserRole(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}

	public UserRole(String userName, String password, String roleCode) {
		super();
		this.userName = userName;
		this.password = password;
		this.roleCode = roleCode;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRoleCode() {
		return roleCode;
	}

	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}

	@Override
	public String toString() {
		return "UserRole [userName=" + userName + ", password=" + password + ", roleCode=" + roleCode + "]";
	}
}