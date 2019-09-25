<%@page language="java" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<title>学员登陆</title>

<!-- 引入Bootstrap必须的css文件 -->
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/bootstrap.css">
<!-- 引入Bootstrap的主题样式 -->
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/bootstrap-theme.css">

<style>
img {
	width: 100%;
	height: 100%;
}
</style>

</head>
<body>

	<div class="container">
		<div class="row">
			<div class="col-lg-12">
				<%@include file="base/header.jsp"%>
			</div>
		</div>
		<form action="<%=request.getContextPath() %>/login" method="post">
			<div class="row">
				<div class="col-lg-12">
					<div class="h4">
						<br>
						<c:if test="${empty LoginErrorMsg}">
							<span class="glyphicon  glyphicon-user text-success"></span>
							<span class="text-success">学员登陆</span>
						</c:if>
						<c:if test="${not empty LoginErrorMsg}">
							<span class="glyphicon  glyphicon-user text-danger"></span>
							<span class="text-danger">${LoginErrorMsg }</span>
						</c:if>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-lg-1">
					<div class="form-group">
						<label for="userName">用户名</label> 
					</div>
				</div>
				<div class="col-lg-3">
					<div class="form-group">
						<input type="text" name="userName" id="userName" class="form-control"/>
					</div>
				</div>
				<div class="col-lg-8">
				</div>
			</div>
			<div class="row">
				<div class="col-lg-1">
					<div class="form-group">
						<label for="userPassword">密 码</label> 
					</div>
				</div>
				<div class="col-lg-3">
					<div class="form-group">
						<input type="password" name="userPassword" id="userPassword" class="form-control"/>
					</div>
				</div>
				<div class="col-lg-8">
				</div>
			</div>
			<div class="row">
				<div class="col-lg-1">
					<div class="form-group">
					</div>
				</div>
				<div class="col-lg-3">
					<button type="submit" class="btn btn-success">登 陆</button>
					<button type="reset" class="btn btn-success">重 置</button>
				</div>
				<div class="col-lg-8">
				</div>
			</div>
			<script type="text/javascript">
			
			</script>
		</form>

		<div class="row">
			<div class="col-lg-12">
				<%@include file="base/footer.jsp"%>
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