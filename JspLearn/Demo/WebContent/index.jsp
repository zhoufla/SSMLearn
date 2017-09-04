<%@ page language="java" contentType="text/html; charset=utf-8"
	import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Learn JSP</title>
</head>
<body>
	<h2>Hello World!</h2>
	<hr>
	<%-- 	<br>
	测试注释 
	<!-- HTML注释 -->
	<%!String str = "张三";

	int add(int x, int y) {
		return x + y;
	}%>
	你好，<%=str%><br> x+y=<%=add(10, 2)%> --%>
	<%
		//request.setCharacterEncoding("utf-8");
		Enumeration<?> enu = request.getHeaderNames();
		String name = "";
		String value = "";

		while (enu.hasMoreElements()) {
			name = (String) enu.nextElement();
			value = request.getHeader(name);
			out.append("<h3>" + name + "  :  " + value + "<br>" + "</h3>");
		}
		out.flush();
		String str = "";
		if (request.getParameter("name") != null)
			str = request.getParameter("name");
		out.append("<h2>" + new String(str.getBytes("iso-8859-1"), "utf-8") + ",你好!</h2><br>");
	%>
	<h2>
		缓冲区大小：<%=out.getBufferSize()%></h2>
	<br>
	<h2>
		缓冲区剩余大小：<%=out.getRemaining()%></h2>
	<br>
	<h2>
		是否自动清空缓存：<%=out.isAutoFlush()%></h2>
</body>
</html>