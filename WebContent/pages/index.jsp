<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<jsp:include page="/pages/plugins/include_basepath.jsp" />
<jsp:include page="/pages/plugins/include_javascript_head.jsp" />
</head>
<body class="hold-transition skin-blue sidebar-mini">
<%
	if (session.getAttribute("mid") != null) {
%>
	<div class="wrapper">
		<!-- 导入头部标题栏内容 -->
		<jsp:include page="/pages/plugins/include_title_head.jsp" />
		<!-- 导入左边菜单项 -->
		<jsp:include page="/pages/plugins/include_menu_item.jsp" />
		<div class="content-wrapper text-center">
			<!-- 此处编写需要显示的页面 -->
			<img src="images/welcome_index.jpg" style="">
		</div>
		<!-- 导入公司尾部认证信息 -->
		<jsp:include page="/pages/plugins/include_title_foot.jsp" />
		<!-- 导入右边工具设置栏 -->
		<jsp:include page="/pages/plugins/include_menu_sidebar.jsp" />
		<div class="control-sidebar-bg"></div>
	</div>
	<jsp:include page="/pages/plugins/include_javascript_foot.jsp" />
<%
	} else {
%>
		<jsp:forward page="/pages/no_check.jsp"/>
<%
	}
%>
</body>
</html>
