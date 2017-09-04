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
	<h1>Session</h1>
	<hr>
	<%
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		session.setAttribute("name", "周凤林");
		//设置当前session生存周期，单位s
		//session.setMaxInactiveInterval(10);
	%>
	创建时间：<%=sdf.format(new Date(session.getCreationTime()))%><br>
	session ID:<%=session.getId()%><br> 从session中获取用户名：<%=session.getAttribute("name")%><br>
	<a href="session_page2.jsp" target="_blank">跳转到session_page2.jsp</a>
	<%
		//销毁当前session
		//	session.invalidate();
	%>
</body>
</html>