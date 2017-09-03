<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login success</title>
</head>
<body>
	<h2>登录成功</h2>
	<hr>
	用户名为：<%=request.getParameter("username")%><br>
	密码为：<%=request.getParameter("password")%><br>
	邮箱为：<%=request.getParameter("email") %><br>
</body>
</html>