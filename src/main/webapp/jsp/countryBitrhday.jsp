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
				<%@include file="base/navbar.jsp"%>
			</div>
		</div>
		<div class="row">
			<div class="col-lg-12">
				<c:if test="${empty UnLoginError }">
					<div class="h2 text-danger text-center">
						<br>
						<span class="glyphicon  glyphicon-exclamation-sign"></span>
							${company }${msg1 }${country }${age }${msg2 }
					</div>
				</c:if>
			</div>
		</div>
		
	</div>

</body>
</html>