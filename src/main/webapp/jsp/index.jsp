<%@page language="java" pageEncoding="utf-8"%>
<%@page import="java.net.URLEncoder" %>
<!DOCTYPE html>
<html>
<head>
<title>Spring Web学习</title>

<!-- 引入Bootstrap必须的css文件 -->
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/bootstrap.css">
<!-- 引入Bootstrap的主题样式 -->
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/bootstrap-theme.css">

<style>
img {
	width: 100%;
	height: 50%;
}
</style>

</head>

	<div class="container">
		<div class="row">
			<div class="col-lg-12">
				<%@include file="base/header.jsp"%>
			</div>
		</div>

		<div class="row">
			<div class="col-lg-12">
				<div class="h4 text-success text-center">
					<br>
					<span class="glyphicon  glyphicon-exclamation-sign"></span>
					欢迎来到其然软件培训，请先进行登陆或者注册! 新用户注册即可参加抽奖！
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-lg-12">
				<div class="text-center">
					<a href="<%=request.getContextPath() %>/loadLogin" class="btn btn-large btn-success">登 陆</a>
					<a href="<%=request.getContextPath() %>/loadRegister" class="btn btn-large btn-success">注 册</a>
				</div>
			</div>
		</div>
	</div>

	<!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
	<script type="text/javascript"
		src="<%=request.getContextPath()%>/js/jquery-1.12.js"></script>
	<!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
	<script type="text/javascript"
		src="<%=request.getContextPath()%>/js/bootstrap.js"></script>
</body>
</html>