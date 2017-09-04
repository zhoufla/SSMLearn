<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*" import="entity.Items"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<link href="css/main.css" rel="stylesheet" type="text/css" />
<base href="<%=basePath%>">
<script type="text/javascript" src="js/lhgcore.js"></script>
<script type="text/javascript" src="js/lhgdialog.js"></script>
<script type="text/javascript">
	function setflog_show(id) {
		 var num =  document.getElementById("number").value; 
         J.dialog.get({id: 'haoyue_creat',title: '购物成功',width: 600,height:400, 
        	 link: '<%=path %>/CartServlet?id=' + id + '&num=' + num+ '&action=add',cover : true});
	}
	
	function add() {
		var num = document.getElementById("number").value;
		if (num < 100)
			num ++;
		document.getElementById("number").value = num;
	}
	
	function sub() {
		var num = document.getElementById("number").value;
		if (num > 0)
			num = num--;
		document.getElementById("number").value = num;
	}
</script>

<style type="text/css">
hr {
	border-color: FF7F00;
}

div {
	float: left;
	margin-left: 30px;
	margin-right: 30px;
	margin-top: 5px;
	margin-bottom: 5px;
}

div dd {
	margin: 0px;
	font-size: 10pt;
}

div dd.dd_name {
	color: blue;
}

div dd.dd_city {
	color: #000;
}

div #cart {
	margin: 0px auto;
	text-align: right;
}

span {
	padding: 0 2px;
	border: 1px #c0c0c0 solid;
	cursor: pointer;
}

a {
	text-decoration: none;
}
</style>
<title>商品详情</title>
</head>
<body>
	<h1>商品详情</h1>
	<a href="index.jsp">首页</a>>>商品详情
	<hr>
	<jsp:useBean id="MyItemDAO" class="dao.ItemsDAO" scope="page"></jsp:useBean>

	<center>
		<table width="820" height="60" cellpadding="0" cellspacing="0"
			border="0">
			<tr>
				<!-- 显示商品详细信息 -->
				<%
					String id = request.getParameter("id");
					Items item = MyItemDAO.getItemByID(Integer.valueOf(id));
					if (item != null) {
				%>
				<td width="70%" valign="top">
					<table>
						<tr>
							<td rowspan="4"><img src="images/<%=item.getPicture()%>"
								width="200" height="160" border="0"></td>
						</tr>
						<tr>
							<td><B><%=item.getName()%></B></td>
						</tr>
						<tr>
							<td>产地：<%=item.getCity()%></td>
						</tr>
						<tr>
							<td>价格：<%=item.getPrice()%>￥
							</td>
						</tr>
						<tr>
							<td>购买数量：<span id="sub" onclick="sub()">-</span> <input
								type="text" id="number" name="number" value="1" size="2" /> <span
								id="add" onclick="add()">+</span>
							</td>
						</tr>
					</table>
					<div id="cart">
					<a href="javascript:setflog_show(<%=item.getId()%>)"><img src="images/buy_now.png"><img
							src="images/in_cart.png"></a> <a href="CartServlet?action=show"><img
							src="images/view_cart.jpg"></a>
					</div>
				</td>
				<%
					}
				%>

				<%
					Set<String> set = new LinkedHashSet();
					Cookie[] cookies = request.getCookies();
					if (cookies != null && cookies.length > 0) {
						for (Cookie cookie : cookies) {
							if ("ListViewCookie".equals(cookie.getName())) {
								String listString = cookie.getValue();
								Collections.addAll(set, listString.split(","));
							}
						}
					}

					//加入当前浏览商品的ID
					if (set.contains(id))
						set.remove(id);
					set.add(id);

					LinkedList<String> list = new LinkedList(set);
					//如果Cookie中存储的ID大于5则移除第一个元素
					if (list.size() > 5) {
						list.removeFirst();
					}

					StringBuffer stb = new StringBuffer();
					for (String str : list) {
						stb.append(str).append(",");
					}
					//去掉最后一个逗号
					stb.setLength(stb.length() - 1);
					Cookie newCookie = new Cookie("ListViewCookie", stb.toString());
					//	newCookie.setMaxAge(2400);
					response.addCookie(newCookie);
				%>

				<td width="30%" align="center" bgcolor="#EEE"><br>您浏览过的商品<br>
					<!-- 循环开始 -->
					<%
						List<Items> result = MyItemDAO.getViewList(list);
						if (result != null && !result.isEmpty())
							for (int i = 0; i < result.size(); i++) {
								Items cookieItem = result.get(i);
					%>
					<div>
						<dl>
							<dt>
								<a href="details.jsp?id=<%=cookieItem.getId()%>"><img
									src="images/<%=cookieItem.getPicture()%>" width="120"
									height="90" border="0"></a>
							</dt>
							<dd class="dd_name"><%=cookieItem.getName()%></dd>
							<dd class="dd_city">
								产地：<%=cookieItem.getCity()%>&nbsp;&nbsp;价格：￥<%=cookieItem.getPrice()%></dd>
						</dl>
					</div> 
					<%
 						}
 					%> 
 					<!-- 循环结束 -->
 					</td>
			</tr>
		</table>
	</center>

</body>
</html>