<%@page import="org.apache.tomcat.util.http.Cookies"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:useBean id="MyUser" class="com.po.Users"></jsp:useBean>
<jsp:useBean id="MyUserDao" class="com.dao.UsersDao"></jsp:useBean>
<jsp:setProperty property="*" name="MyUser" />
<%
	MyUserDao.saveCookies(MyUser, response);
	if (MyUserDao.usersLogin(MyUser)) {
		request.getRequestDispatcher("login_success.jsp").forward(request, response);
	} else {
		response.sendRedirect("login_failed.jsp");//重定向
	}
%>
<%-- <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>jsp:setProperty的使用</title>
</head>
<body>
	<h1>jsp:setProperty的使用</h1>
	<hr>
	<jsp:useBean id="myUsers" class="com.po.Users" scope="page"></jsp:useBean>
	<jsp:setProperty name="myUsers" property="username"></jsp:setProperty>
	<jsp:setProperty name="myUsers" property="password" value="12345"></jsp:setProperty>
	<jsp:setProperty name="myUsers" property="password" param="myPass"></jsp:setProperty>
	用户名：<%=myUsers.getUsername()%><br> 密码：<%=myUsers.getPassword()%><br>
	用户名：<jsp:getProperty property="username" name="myUsers" /><br> 密码：<jsp:getProperty
		property="password" name="myUsers" /><br>

</body>
</html> --%>