<%@page language="java" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<title>添加 Code</title>

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
					<span class="text-success">添加 Code</span>
					<hr>
				</div>
			</div>
		</div>
		<form action="<%=request.getContextPath() %>/code/addCode" method="post">
			<div class="row">
				<div class="col-lg-12">
					<c:if test="${not empty succMsg}">
						<p class="text-danger">${succMsg }</p>
						<hr>
					</c:if>
				</div>
			</div>
			<div class="row">
				<div class="col-lg-2">
					<div class="form-group">
						<label for="codeTypeName">请选择 Code Type</label> 
					</div>
				</div>
				<div class="col-lg-4">
					<div class="form-group">
						<select id="codeTypeName"  name="typeName" class="form-control">
							<option value="">请选择</option>
							<c:forEach items="${allCodeTypeList}" var="codeType">
								<c:choose>
									<c:when test="${code. typeName eq codeType.typeName}">
										<option value="${codeType.typeName}" selected="selected">${codeType.typeName}</option>
									</c:when>
									<c:otherwise>
										<option value="${codeType.typeName}">${codeType.typeName}</option>
									</c:otherwise>
								</c:choose>
							</c:forEach>
						</select>
					</div>
				</div>
				<div class="col-lg-6">
				</div>
			</div>
			<div class="row">
				<div class="col-lg-2">
					<div class="form-group">
						<label for="codeId">Code ID</label> 
					</div>
				</div>
				<div class="col-lg-4">
					<div class="form-group">
						<input id="codeId" name="codeId" class="form-control" value="${code.codeId }">
					</div>
				</div>
				<div class="col-lg-6">
				</div>
			</div>
			<div class="row">
				<div class="col-lg-2">
					<div class="form-group">
						<label for="codeDesc">Code 描述</label> 
					</div>
				</div>
				<div class="col-lg-4">
					<div class="form-group">
						<textarea name="description" cols="100"  rows="5" id="codeDesc" class="form-control">${code.description }</textarea>
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