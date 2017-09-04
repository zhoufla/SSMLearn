<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>使用JavaBean</title>
</head>
<body>
	<h1>JavaBean</h1>
	<hr>
	<jsp:useBean id="myUser" class="com.po.Users" scope="page"></jsp:useBean>
	<%
		request.setCharacterEncoding("utf-8");
	%>
	<jsp:setProperty property="*" name="myUser" />
	用户名：<%=myUser.getUsername()%><br> 密码：<%=myUser.getPassword()%><br>

	<jsp:forward page="dologin.jsp"><jsp:param
			value="1234@163.com" name="email" /></jsp:forward>

</body>
</html>