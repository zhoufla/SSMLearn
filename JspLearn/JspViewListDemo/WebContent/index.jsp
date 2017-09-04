<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*" import="entity.Items"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
hr {
	border-color: FF7F00;
}

div {
	float: left;
	margin: 10px;
}

div dd {
	margin: 0px;
	font-size: 10pt;
}

div dd.dd_name {
	color: blue;
}

div dd.dd_city {
	color: #221;
}
</style>
<title>商品展示</title>
</head>
<body>
	<h1>商品详情</h1>
	<a href="index.jsp">首页</a>
	<hr>
	<jsp:useBean id="MyItemDAO" class="dao.ItemsDAO" scope="page"></jsp:useBean>

	<center>
		<table width="820" height="60" cellpadding="0" cellspacing="0"
			border="0">
			<tr>
				<td>
					<!-- 商品循环开始 --> 
					<%
 						List<Items> list = MyItemDAO.getAllItems();
 						if (list != null && !list.isEmpty())
 							for (int i = 0; i < list.size(); i++) {
 								Items item = list.get(i);
 					%>
					<div>
						<dl>
							<dt>
								<a href="details.jsp?id=<%=item.getId()%>"><img
									src="images/<%=item.getPicture()%>" width="120" height="90"
									border="0"></a>
							</dt>
							<dd class="dd_name"><%=item.getName()%></dd>
							<dd class="dd_city">
								产地：<%=item.getCity()%>&nbsp;&nbsp;价格：￥<%=item.getPrice()%></dd>
						</dl>
					</div> 
					<%
 						}
 					%> 
				 <!-- 商品循环结束 -->
				</td>
			</tr>
		</table>
	</center>
</body>
</html>