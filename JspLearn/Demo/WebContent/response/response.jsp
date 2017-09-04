<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="java.io.*"%>
<!-- <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
</body>
</html> -->
<%
	response.setContentType("text/html;charset=utf-8");
	out.println("<h1>内置对象</h1>");
	out.println("<hr>");
	//out.flush();
	
	PrintWriter writer = response.getWriter();//获得输出流对象
	writer.println("response获取的输出流对象");
	
	//response.sendRedirect("/Demo/request.jsp");//重定向
	request.getRequestDispatcher("/request.jsp").forward(request, response);
	
	
	
%>