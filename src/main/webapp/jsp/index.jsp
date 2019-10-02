<%@page language="java" pageEncoding="utf-8"%>
<%@page import="java.net.URLEncoder" %>
<!DOCTYPE html>
<html>
<head>
<title>庆祝国庆</title>

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
				<c:if test="${empty UnLoginError }">
					<div class="h4 text-success text-center">
						<br>
						<span class="glyphicon  glyphicon-exclamation-sign"></span>
						欢迎来到其然软件培训，请先进行登陆或者注册! 新用户注册即可参加抽奖！
					</div>
				</c:if>
				<c:if test="${not empty UnLoginError }">
					<div class="h4 text-danger text-center">
						<br>
						<span class="glyphicon  glyphicon-exclamation-sign"></span>
						${UnLoginError }
					</div>
				</c:if>
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

</body>
</html>