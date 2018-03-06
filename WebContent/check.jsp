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
	String msg = "用户登录失败，请重新登录！" ;
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
	String rand = (String) session.getAttribute("rand") ;
	String code = request.getParameter("code") ;
	if (!rand.equalsIgnoreCase(code)) {	// 验证码不正确
		msg = "验证码输入错误，无法进行登录处理！" ;
	} else {
		Member member = new Member() ;
		String mid = request.getParameter("mid") ;
		member.setMid(mid) ;
		member.setPassword(PasswordUtil.encoder(request.getParameter("password"))) ;
		IMemberServiceFront memberService = Factory.getServiceInstance("member.service") ;
		try {
			Map<String,Object> map = memberService.login(member) ;	// 进行登录处理
			boolean flag = (Boolean) map.get("flag") ;	// 取得登录成功与否的判断标记
			if (flag) {	// 登录成功
				session.setAttribute("mid", mid) ;	// 将用户登录编号保存在session之中 
				session.setAttribute("name",map.get("name")) ;
				session.setAttribute("lastdate",map.get("lastdate")) ;
				session.setAttribute("allRoles", map.get("allRoles")) ;
				session.setAttribute("allActions", map.get("allActions")) ;
				path = basePath + "pages/index.jsp" ;
				msg = "用户登录成功，欢迎您的光临！" ;
				CookieUtil cookieUtil = new CookieUtil(request,response) ;
				cookieUtil.saveMid(mid) ;	// 保存用户名到Cookie之中
			} 
		} catch (Exception e) {
			msg = e.getCause().getMessage() ;
		} 
	}
%>
<div id="promptMessageDiv">
	<p><%=msg%></p>
	<p><a href="<%=path%>">继续访问</a></p>
</div>
</body>
</html>