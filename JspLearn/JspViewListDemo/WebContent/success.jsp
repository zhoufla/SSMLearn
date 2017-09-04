<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加成功</title>
</head>
<body>
	<center>
	<img src="images/add_cart_success.jpg">
	<hr>
	您成功购买了<%=request.getParameter("num") %>件编号为<%=request.getParameter("id") %>的商品。
	</center>
	
</body>
</html>