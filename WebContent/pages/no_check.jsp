<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="cn.mldn.exception.login.*" %>
<%@ page import="cn.mldn.vo.*" %>
<%@ page import="cn.mldn.util.*" %>
<%@ page import="cn.mldn.util.factory.*" %>
<%@ page import="cn.mldn.service.front.*" %>
<%@ page import="cn.mldn.util.enctype.*" %>
<%
	request.setCharacterEncoding("UTF-8") ;
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath() + "/";
	String path = basePath + "login.jsp" ;
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
	String mid = cookieUtil.loadMid() ;	// 读取保存的mid数据
	if (mid != null) {
		IMemberServiceFront memberService = Factory.getServiceInstance("member.service") ;
		try {
			Map<String,Object> map = memberService.login(mid) ;	// 进行登录处理
			session.setAttribute("mid", mid) ;	// 将用户登录编号保存在session之中 
			session.setAttribute("name",map.get("name")) ;
			session.setAttribute("lastdate",map.get("lastdate")) ;
			session.setAttribute("allRoles", map.get("allRoles")) ;
			session.setAttribute("allActions", map.get("allActions")) ;
			path = basePath + "pages/index.jsp" ;
		} catch (Exception e) {	// 如果失败则出现异常
		} 
	}
	response.sendRedirect(path) ;
%>
</body>
</html>