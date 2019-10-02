<%@page language="java" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<title>添加 Code Type</title>

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
						<span class="glyphicon  glyphicon-chevron-right text-success"></span>
						<span class="text-success">添加 Code Type</span>
						<hr>
					</div>
				</div>
			</div>
		<form action="<%=request.getContextPath() %>/code/addCodeType" method="post">
			<div class="row">
				<div class="col-lg-12">
					<c:if test="${not empty addErrorMsg}">
						<p class="text-danger">${addErrorMsg }</p>
						<hr>
					</c:if>
				</div>
			</div>
			<div class="row">
				<div class="col-lg-2">
					<div class="form-group">
						<label for="codeTypeName">Code Type 名字</label> 
					</div>
				</div>
				<div class="col-lg-4">
					<div class="form-group">
						<input type="text" name="codeTypeName" value="${ codeTypeName}" id="codeTypeName" class="form-control"/>
					</div>
				</div>
				<div class="col-lg-6">
				</div>
			</div>
			<div class="row">
				<div class="col-lg-2">
					<div class="form-group">
						<label for="codeTypeDesc">Code Type 描述</label> 
					</div>
				</div>
				<div class="col-lg-4">
					<div class="form-group">
						<textarea name="codeTypeDesc" cols="100"  rows="5" id="codeTypeDesc" class="form-control">${codeTypeDesc}</textarea>
					</div>
				</div>
				<div class="col-lg-6">
				</div>
			</div>
			<div class="row">
				<div class="col-lg-2">
					<div class="form-group">
					</div>
				</div>
				<div class="col-lg-4">
					<button type="submit" class="btn btn-success">添 加</button>
					<button type="reset" class="btn btn-success">重 置</button>
				</div>
				<div class="col-lg-6">
				</div>
			</div>
		</form>

		<div class="row">
			<div class="col-lg-12">
				<%@include file="base/footer.jsp"%>
			</div>
		</div>
	</div>

</body>
</html>