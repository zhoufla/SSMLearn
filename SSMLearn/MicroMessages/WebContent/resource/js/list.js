/**
 * 调用批量删除后台服务
 */

function deleteBatch(basePath) {
	$("#mainForm").attr("action",basePath+"MaintainServlet.action?action=deletebatch");
	$("#mainForm").submit();
}