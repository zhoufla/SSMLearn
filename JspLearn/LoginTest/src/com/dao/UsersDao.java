package com.dao;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import com.po.Users;

/**
 * 用户登录的业务逻辑类
 * 
 * @author zhou
 *
 */
public class UsersDao {

	public boolean usersLogin(Users user) {
		if ("admin".equals(user.getUsername()) && "admin".equals(user.getPassword()))
			return true;
		else
			return false;
	}

	/**
	 * 保存cookie
	 * 
	 * @param user
	 * @param isChecked
	 * @param response
	 */
	public void saveCookies(Users user, HttpServletResponse response) {
		Cookie username = null;
		Cookie password = null;
		if ("on".equals(user.getIsChecked())) {
			username = new Cookie("username", user.getUsername());
			password = new Cookie("password", user.getPassword());
			username.setMaxAge(100);
			password.setMaxAge(100);
			response.addCookie(username);
			response.addCookie(password);
		}
	}

}
