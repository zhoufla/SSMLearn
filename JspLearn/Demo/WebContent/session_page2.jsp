<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Session内置对象</title>
</head>
<body>
	<h1>Session2</h1>
	<hr>
	<%
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		//session.setAttribute("name", "周凤林");
	%>
	创建时间：<%=sdf.format(new Date(session.getCreationTime()))%><br>
	session ID:<%=session.getId()%><br> 
	从session中获取用户名：<%=session.getAttribute("name")%><br>
	过期时间：<%=session.getMaxInactiveInterval() %>
</body>
</html>