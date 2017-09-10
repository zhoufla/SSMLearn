<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>微信公众号</title>
<!--讨论区滚动条begin-->
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>resources/css/jscrollpane1.css" />
<script src="<%=basePath%>resources/js/jquery-1.8.0.min.js"
	type="text/javascript"></script>
<script type="text/javascript"
	src="<%=basePath%>resources/js/jquery.mousewheel.js"></script>
<script type="text/javascript"
	src="<%=basePath%>resources/js/jquery.jscrollpane.min.js"></script>
<script type="text/javascript"
	src="<%=basePath%>resources/js/scroll-startstop.events.jquery.js"></script>
<script type="text/javascript" src="<%=basePath%>resources/js/talk.js"></script>
</head>
<body>
	<input type="hidden" value="<%=basePath%>" id="basePath" />
	<br />
	<div class="talk">
		<div class="talk_title">
			<span>正在与公众号对话</span>
		</div>
		<div class="talk_record">
			<div id="jp-container" class="jp-container">
				<div class="user">
					<img src="<%=basePath%>resource/images/thumbs/talk_recordbox.jpg" />公众号
				</div>
				<div class="talk_recordtextbg">&nbsp;</div>
				<div class="talk_recordtext">
					<h3>客官，来啦，坐吧！回复[查看]收取更多精彩内容。</h3>
					<span class="talk_time">2017-09-08 15:02</span>
				</div>
			</div>
			<div class="talk_recordboxme">
				<div class="user">
					<img src="<%=basePath%>resource/images/thumbs/talk_recordboxme.jpg" />
				</div>
				<div class="talk_recordtextbg">&nbsp;</div>
				<div class="talk_recordtext">
					<h3>查看</h3>
					<span class="talk_time">2017-09-08 15:02</span>
				</div>
			</div>
		</div>

		<div class="talk_word">
			&nbsp; <input class="add_face" id="facial" type="button" title="添加表情"
				value="" /> <input id="content" class="messages emotion" /> <input
				class="talk_send" onclick="send();" type="button" title="发送"
				value="发送" />
		</div>
	</div>
	<div
		style="text-align: center; margin: 50px 0; font: normal 14px/24px 'MicroSoft YaHei';"></div>
</body>
</html>