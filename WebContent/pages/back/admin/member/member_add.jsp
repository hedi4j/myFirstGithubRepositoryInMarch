<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<jsp:include page="/pages/plugins/include_basepath.jsp" />
<jsp:include page="/pages/plugins/include_javascript_head.jsp" />
</head>
<body class="hold-transition skin-blue sidebar-mini">
	<div class="wrapper">
		<!-- 导入头部标题栏内容 -->
		<jsp:include page="/pages/plugins/include_title_head.jsp" />
		<!-- 导入左边菜单项 -->
		<jsp:include page="/pages/plugins/include_menu_item.jsp" />
		<div class="content-wrapper text-center">
			<!-- 此处编写需要显示的页面 -->
			<form action="" method="post" class="form-horizontal" id="deptForm">
				<div class="form-group" id="midDiv">
					<label class="col-md-2 control-label" for="mid">用户名：</label>
					<div class="col-md-5">
						<input type="text" id="mid" name="mid"
							class="form-control input-sm">
					</div>
					<span class="col-md-5" id="midSpan">*</span>
				</div>
				<div class="form-group" id="passwordDiv">
					<label class="col-md-2 control-label" for="password">密码：</label>
					<div class="col-md-5">
						<input type="text" id="password" name="password" class="form-control">
					</div>
					<span class="col-md-5" id="passwordSpan">*</span>
				</div>
				<div class="form-group" id="nameDiv">
					<label class="col-md-2 control-label" for="name">真实姓名：</label>
					<div class="col-md-5">
						<input type="text" id="name" name="name" class="form-control">
					</div>
					<span class="col-md-5" id="nameSpan">*</span>
				</div>
				<div class="form-group">
					<label class="col-md-2 control-label" for="rid">角色：</label>
					<div class="col-md-5">
						<div class="checkbox">
							<label><input type="checkbox" id="rid" name="rid">用户管理</label>
						</div>
						<div class="checkbox">
							<label><input type="checkbox" id="rid" name="rid">部门管理</label>
						</div>
						<div class="checkbox">
							<label><input type="checkbox" id="rid" name="rid">用品管理</label>
						</div>
					</div>
					<span class="col-md-5" id="ridSpan">*</span>
				</div>
				<div class="form-group">
					<label class="col-md-2 control-label" for="lock">锁定：</label>
					<div class="col-md-5">
						<div class="checkbox">
							<label class="left-text"><input type="checkbox" id="lock" name="lock" checked>锁定</label>
						</div>
					</div>
					<span class="col-md-5" id="lockSpan">*</span>
				</div>
				
				<div class="form-group">
					<div class="col-md-3 col-md-offset-3">
						<input type="submit" value="提交" class="btn btn-primary">
						<input type="reset" value="重置" class="btn btn-warning">
					</div>
				</div>
			</form>
		</div>
		<!-- 导入公司尾部认证信息 -->
		<jsp:include page="/pages/plugins/include_title_foot.jsp" />
		<!-- 导入右边工具设置栏 -->
		<jsp:include page="/pages/plugins/include_menu_sidebar.jsp" />
		<div class="control-sidebar-bg"></div>
	</div>
	<jsp:include page="/pages/plugins/include_javascript_foot.jsp" />
</body>
</html>
