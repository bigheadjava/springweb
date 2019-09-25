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
		<div class="row">
			<div class="col-lg-12">
				<%@include file="base/navbar.jsp"%>
			</div>
		</div>
		<div class="row">
			<div class="col-lg-12">
				<div class="h4">
					<br>
					
					<c:if test="${empty LotteryErrorMsg}">
						<span class="glyphicon  glyphicon-tint text-success"></span>
						<span class="text-success">本次参与抽奖的同学名单</span>
					</c:if>
					<c:if test="${not empty LotteryErrorMsg}">
						<span class="glyphicon  glyphicon-tint text-danger"></span>
						<span class="text-danger">${LotteryErrorMsg }</span>
					</c:if>
					<br><br>
				</div>
			</div>
		</div>
		<form action="<%=request.getContextPath() %>/lottery" method="post">
			<div class="row">
				<div class="col-lg-12">
					<div class="text-warning">
						<c:forEach items="${studentList}" var="student">
							<div class="h4">${student.name }</div>
						</c:forEach>
					</div>
					<br><br>
				</div>
			</div>
			<div class="row">
				<div class="col-lg-12">
						<button type="submit" class="btn btn-success btn-large">点击开始抽奖</button>
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