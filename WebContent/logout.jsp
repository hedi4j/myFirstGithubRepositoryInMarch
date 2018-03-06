<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page import="cn.mldn.util.*" %>
<%
	request.setCharacterEncoding("UTF-8") ;
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath() + "/";
%>
<html>
<head>
<base href="<%=basePath%>" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP + 业务层实现部门管理</title>
</head>
<body>
<%
	CookieUtil cookieUtil = new CookieUtil(request,response) ;
	cookieUtil.cleanMid() ;
	String path = basePath + "login.jsp" ;
	session.invalidate() ;
%>
<div id="promptMessageDiv">
	<p>用户注销成功！</p>
	<p><a href="<%=path%>">继续访问</a></p>
</div>
</body>
</html>