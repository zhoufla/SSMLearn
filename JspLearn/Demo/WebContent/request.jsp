<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>request.jsp</title>
</head>
<body>
	<h1>内置对象request的学习</h1>
	<%
		request.setCharacterEncoding("utf-8");
		request.setAttribute("name", "周凤林");
		request.setAttribute("password", "1234567");
	%>
	用户名：<%=request.getParameter("username")%><br> 爱 好：<%=Arrays.toString(request.getParameterValues("favorite"))%>
	<br>
	密码：<%=request.getAttribute("password") %><br>
	服务器名：<%=request.getServerName() %><br>
	ContentType:<%=request.getContentType() %><br>
	协议版本号：<%=request.getProtocol() %><br>
	端口号：<%=request.getServerPort() %><br> 请求的真实路径：<%=request.getRealPath("request.jsp")%><br>
	请求的上下文地址：<%=request.getContextPath() %><br>
	请求的IP地址：<%=request.getRemoteAddr() %>
</body>
</html>