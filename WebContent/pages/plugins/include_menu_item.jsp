<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	Set<String> allRoles = (Set<String>) session.getAttribute("allRoles") ;
	Set<String> allActions = (Set<String>) session.getAttribute("allActions") ; 
%>
<aside class="main-sidebar">
	<!-- sidebar: style can be found in sidebar.less -->
	<section class="sidebar">
		<!-- Sidebar user panel -->
		<div class="user-panel">
			<div class="pull-left image">
				<img src="upload/emp/nophoto.png" class="img-circle"
					alt="User Image">
			</div>
			<div class="pull-left info">
				<p><%=session.getAttribute("name")%></p>
			</div> 
		</div>
		<!-- /.search form -->
		<!-- sidebar menu: : style can be found in sidebar.less -->
		<ul class="sidebar-menu">
			<li class="header"><i class="fa fa-slack"></i> 企业信息管理系统</li>
			<%
				if (allRoles.contains("member")) {
			%>
			<li class="treeview"><a href="<%=basePath%>pages/index.jsp"> <i
					class="fa fa-folder-open"></i> <span>用户管理</span> <i
					class="fa fa-angle-left pull-right"></i>
			</a>
				<ul class="treeview-menu">
					<%
						if (allActions.contains("member:add")) {
					%>
					<li><a href="pages/back/admin/member/member_add.jsp"><i class="fa fa-circle-o"></i>
							创建用户</a></li>
					<%
						}
					%>
					<%
						if (allActions.contains("member:list")) {
					%>
					<li><a href="pages/back/admin/member/member_list.jsp"><i class="fa fa-circle-o"></i>
							用户列表</a></li>
					<%
						}
					%>
				</ul></li>
			<%
				}
			%>
			<%
				if (allRoles.contains("dept")) {
			%>
			<li class="treeview"><a href="<%=basePath%>pages/index.jsp"> <i class="fa  fa-folder-open"></i>
					<span>部门管理</span> <i class="fa fa-angle-left pull-right"></i>
			</a>
				<ul class="treeview-menu">
					<%
						if (allActions.contains("dept:list")) {
					%>
					<li><a href="pages/back/admin/dept/dept_list.jsp"><i
							class="fa fa-circle-o"></i> 部门列表</a></li>
					<%
						}
					%>
					<%
						if (allActions.contains("dept:add")) {
					%>
					<li><a href="pages/back/admin/dept/dept_add.jsp"><i
							class="fa fa-circle-o"></i> 增加部门</a></li>
					<%
						}
					%>
				</ul></li>
			<%
				}
			%>
			<%
				if (allRoles.contains("goods")) {
			%>
			<li class="treeview"><a href="<%=basePath%>pages/index.jsp"> <i class="fa  fa-folder-open"></i>
					<span>办公用品</span> <i class="fa fa-angle-left pull-right"></i>
			</a>
				<ul class="treeview-menu">
					<%
						if (allActions.contains("goods:item")) {
					%>
					<li><a href="pages/type/type_list.jsp"><i 
							class="fa fa-circle-o"></i> 商品分类</a></li>
					<%
						}
					%>
					<%
						if (allActions.contains("goods:list")) {
					%>
					<li><a href="pages/res/res_list.jsp"><i
							class="fa fa-circle-o"></i> 商品列表</a></li>
					<%
						}
					%>	
				</ul></li>
			<%
				}
			%>
		</ul>
	</section>
	<!-- /.sidebar -->
</aside>