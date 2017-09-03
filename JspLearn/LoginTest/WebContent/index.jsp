<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
</head>
<body>
	<h1>用户登录</h1>
	<hr>
	<jsp:useBean id="LoginUser" class="com.po.Users" scope="page"></jsp:useBean>
	<%
		Cookie[] cookies = request.getCookies();
		if (cookies == null || cookies.length <= 0)
			return;
		for (Cookie c : cookies) {
			if ("username".equals(c.getName())) {
				LoginUser.setUsername(c.getValue());
			}
			if ("password".equals(c.getName())) {
				LoginUser.setPassword(c.getValue());
			}
		}
	%>
	<form action="usebean.jsp" method="post" name="loginForm">
		<table>
			<tr>
				<td>用户名：</td>
				<td><input type="text" name="username"
					value=<%=LoginUser.getUsername()%>></td>
			</tr>
			<tr>
				<td>密码：</td>
				<td><input type="password" name="password"
					value=<%=LoginUser.getPassword()%>></td>
			</tr>
			<tr>
				<td colspan="2"><input type="checkbox" name="isChecked"
					checked="checked"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="登录"></td>
			</tr>
		</table>
	</form>
	<br>
	<%-- 	<%@include file="date.jsp"%> --%>
	<jsp:include page="date.jsp" flush="false"></jsp:include>

</body>
</html>