<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>内置对象application</title>
</head>
<body>
	<h1>application</h1>
	<%
		application.setAttribute("name", "zhou");
		application.setAttribute("postcode", "610500");
		application.setAttribute("email", "zhou@123.com");
	%>
	application的属性有：<%
		Enumeration<String> enumeration = application.getAttributeNames();
		while (enumeration.hasMoreElements()) {
			out.println(
					enumeration.nextElement() + ":" + "<br>");
		}
	%>
	服务器版本信息：<%=application.getServerInfo() %>
</body>
</html>