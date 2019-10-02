<%@page language="java" pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<!DOCTYPE html>
<html>
<head>
<title>首页</title>

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
					<br> <span class="glyphicon  glyphicon-chevron-right text-success"></span>
					<span class="text-success">抽奖结果</span>
					<br><br>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-lg-12">
				<div>
					本次中奖的是&nbsp;<span class="h4 text-success"> ${luckyStudent.name} </span>&nbsp;同学,恭喜!
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-lg-12">
				<div>
					<br>
					<a href="<%=request.getContextPath()%>/loadLotteryPage" class="btn btn-success btn-large">继续抽奖</a>
				</div>
			</div>
		</div>
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