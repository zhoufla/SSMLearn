<%@ page language="java" contentType="text/html; charset=utf-8"
	import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>九九乘法表</title>
</head>
<body>
	<%!StringBuffer stb = new StringBuffer();//

	public String printMulti() {
		stb.setLength(0);
		for (int i = 1; i <= 9; i++) {
			for (int j = 1; j <= i; j++) {
				stb.append(i + " * " + j + " = " + (i * j)).append("&nbsp&nbsp&nbsp&nbsp");
			}
			stb.append("<br>");
		}

		return stb.toString();
	}%>
	<h1>登录成功</h1>
	<!-- 	<h1>九九乘法表</h1> -->
	<hr>
	<%-- <%=printMulti()%> --%>
	<%
		request.setCharacterEncoding("utf-8");
		Enumeration<?> enu = request.getHeaderNames();
		String name = "";
		String value = "";

		while (enu.hasMoreElements()) {
			name = (String) enu.nextElement();
			value = request.getHeader(name);
			out.append("<h3>" + name + "  :  " + value + "<br>" + "</h3>");
		}
		out.append("<h2>" + request.getParameter("username") + "</h2>");
		out.append("<h2>" + request.getParameter("password") + "</h2>");
	%>
</body>
</html>