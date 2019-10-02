<%@page language="java" pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<!DOCTYPE html>
<html>
<head>
<title>学员注册</title>

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
					<div class="h4">
						<br> <span class="glyphicon  glyphicon-user text-success"></span>
						<span class="text-success">注册成功!</span>
						<br><br>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-lg-1">
					<label for="userName">用户名</label> 
				</div>
				<div class="col-lg-3">
						${user.userName}
				</div>
				<div class="col-lg-8">
				</div>
			</div>
			<div class="row">
				<div class="col-lg-1">
					<label for="userName">名 字</label> 
				</div>
				<div class="col-lg-3">
					<c:out value="${user.name}"></c:out>
				</div>
				<div class="col-lg-8">
				</div>
			</div>
			<div class="row">
				<div class="col-lg-1">
					<label for="userName">性 别</label> 
				</div>
				<div class="col-lg-3">
					<c:if test="${user.gender eq 'M' }">
						男
					</c:if>
					<c:if test="${user.gender eq 'F' }">
						女
					</c:if>
				</div>
				<div class="col-lg-8">
				</div>
			</div>
			<div class="row">
				<div class="col-lg-1">
					<label for="userName">年 级</label> 
				</div>
				<div class="col-lg-3">
					<c:if test="${user.grade == -1 }">
						已毕业
					</c:if>
					<c:if test="${user.grade==1 }">
						大一
					</c:if>
					<c:if test="${user.grade==2 }">
						大二
					</c:if>
					<c:if test="${user.grade==3}">
						大三
					</c:if>
					<c:if test="${user.grade==4 }">
						大四
					</c:if>
				</div>
				<div class="col-lg-8">
				</div>
			</div>
			<div class="row">
				<div class="col-lg-1">
					<label for="userName">手 机</label> 
				</div>
				<div class="col-lg-3">
						${user.telNo}
				</div>
				<div class="col-lg-8">
				</div>
			</div>
			<%-- <div class="row">
				<div class="col-lg-12">
					<span class="text-success">请点击 <a href="<%=request.getContextPath() %>/loadHomePage" class="btn btn-warning">首页</a> 访问首页，或者等待3秒，系统会自动跳转到首页!</span>
					<% response.setHeader("refresh","3;URL="+request.getContextPath()+"/loadHomePage");%>
				</div>
			</div> --%>
			<script type="text/javascript">
			
			</script>

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