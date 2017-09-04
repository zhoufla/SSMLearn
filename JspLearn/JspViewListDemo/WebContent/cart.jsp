<%@page import="java.util.Map.Entry"%>
<%@page import="entity.Items"%>
<%@page import="java.util.*"%>
<%@page import="entity.Cart"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet" href="css/style1.css" />
<title>我的购物车</title>
<script type="text/javascript">
function delcfm() {
    if (!confirm("确认要删除？")) {
        window.event.returnValue = false;
    }
}
</script>
</head>
<body>
	<h1>我的购物车</h1>
	<a href="index.jsp">首页</a>>>购物车
	<div id="shopping">
		<form action="">
			<table>
				<tr>
					<th>商品名称</th>
					<th>商品单价</th>
					<th>购买数量</th>
					<th>商品总价</th>
					<th>操作</th>
				</tr>

				<!-- 循环开始 -->
				<%
					Cart cart = (Cart) request.getSession().getAttribute("cart");
					if (null != cart && !cart.getGoods().isEmpty()) {
						Map<Items, Integer> goods = cart.getGoods();
						Iterator<Entry<Items, Integer>> iterator = goods.entrySet().iterator();
						while (iterator.hasNext()) {
							Entry<Items, Integer> entry = iterator.next();
							Items item = entry.getKey();
				%>

				<tr id="product_id_1">
					<td class="thumb"><img src="images/<%=item.getPicture()%>"><a
						href=""><%=item.getName()%></a></td>
					<td class="number"><%=item.getPrice()%></td>
					<td class="number"><%=entry.getValue()%></td>
					<td class="price" id="price_id_1"><span><%=entry.getValue() * item.getPrice()%></span>
						<input type="hidden" value="" /></td>
					<td class="delete"><a href="CartServlet?action=delete&id=<%=item.getId()%>"
						onclick="delcfm()">删除</a></td>
				</tr>
				<%
					}
				%>
			</table>
			<div class="total">
				<span id="total">总计：<%=cart.calTotalPrice()%>￥
				</span>
			</div>
			<%
				}
			%>
			<div class="button">
				<input type="submit" value="" />
			</div>
		</form>
	</div>
</body>
</html>