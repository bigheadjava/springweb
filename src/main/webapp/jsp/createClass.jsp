<%@page language="java" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<title>创建班级</title>

<!-- 引入Bootstrap必须的css文件 -->
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/bootstrap.css">
<!-- 引入Bootstrap的主题样式 -->
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/bootstrap-theme.css">
	
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/main.css">

<style>
img {
	width: 100%;
	height: 100%;
}
</style>

</head>

<script type="text/javascript">
</script>

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
					<span class="text-success">创建班级</span>
					<hr>
				</div>
			</div>
		</div>
		<form:form action="createClass" method="post" modelAttribute="clazzBean">
			<div class="row">
				<div class="col-lg-12">
					<c:if test="${not empty succMsg}">
						<p class="error-field">${succMsg }</p>
						<hr>
					</c:if>
				</div>
			</div>
			<div class="row">
				<div class="col-lg-2">
					<div class="form-group">
						<label for="classKind">班级类型</label> 
					</div>
				</div>
				<div class="col-lg-4">
					<div class="form-group">
						<form:radiobuttons id="classKind" path="kind" items="${classKindList}" 
							itemLabel="description" itemValue="codeId" cssClass="form-control" />
					</div>
				</div>
				<div class="col-lg-6">
					<form:errors path="kind" cssClass="error-field"></form:errors>
				</div>
			</div>
			<div class="row">
				<div class="col-lg-2">
					<div class="form-group">
						<label for="classLocation">班级地点</label> 
					</div>
				</div>
				<div class="col-lg-4">
					<div class="form-group">
						<form:select path="location" id="classLocation" items="${classLocationList}" itemLabel="description" itemValue="codeId" cssClass="form-control"></form:select>
					</div>
				</div>
				<div class="col-lg-6">
					<form:errors path="location" cssClass="error-field"></form:errors>
				</div>
			</div>
			<div class="row">
				<div class="col-lg-2">
					<div class="form-group">
						<label for="className">班级名称</label> 
					</div>
				</div>
				<div class="col-lg-4">
					<div class="form-group">
						<form:input path="name" id="className" cssClass="form-control"/>
					</div>
				</div>
				<div class="col-lg-6">
					<form:errors path="name" cssClass="error-field"></form:errors>
				</div>
			</div>
			<div class="row">
				<div class="col-lg-2">
					<div class="form-group">
						<label for="planStartDate">计划开班时间</label> 
					</div>
				</div>
				<div class="col-lg-4">
					<div class="form-group">
						<input type="date" name="planStartDate" id="planStartDate" pattern="yyyy-MM-dd" value="${clazzBean.planStartDateAsStr }">
					</div>
				</div>
				<div class="col-lg-6">
					<form:errors path="planStartDate" cssClass="error-field"></form:errors>
				</div>
			</div>
			<div class="row">
				<div class="col-lg-2">
					<div class="form-group">
						<label for="planEndDate">计划毕业时间</label> 
					</div>
				</div>
				<div class="col-lg-4">
					<div class="form-group">
						<input type="date" name="planEndDate" id="planEndDate" value="${clazzBean.planEndDateAsStr }">
					</div>
				</div>
				<div class="col-lg-6">
					<form:errors path="planEndDate" cssClass="error-field"></form:errors>
				</div>
			</div>
			<div class="row">
				<div class="col-lg-2">
					<div class="form-group">
						<label for="classDesc">班级简介</label> 
					</div>
				</div>
				<div class="col-lg-4">
					<div class="form-group">
						<form:textarea path="description" id="classDesc" cssClass="form-control" cols="100" rows="5"/>
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
		</form:form>

		<div class="row">
			<div class="col-lg-12">
				<%@include file="base/footer.jsp"%>
			</div>
		</div>
	</div>

</body>
</html>