package com.po;

/**
 * 用户bean
 * 
 * @author zhou
 *
 */
public class Users {

	private String username;
	private String password;
	private String isChecked;

	public Users() {
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

	public String getIsChecked() {
		return isChecked;
	}

	public void setIsChecked(String isChecked) {
		this.isChecked = isChecked;
	}
}
