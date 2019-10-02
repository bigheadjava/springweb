<%@page language="java" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<title>添加课程</title>

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
		<form action="<%=request.getContextPath() %>/addCourse" method="post">
			<div class="row">
				<div class="col-lg-12">
					<div class="h4">
						<br> 
						<c:if test="${empty RegErrorMsg}">
							<span class="glyphicon  glyphicon-user text-success"></span>
							<span class="text-success">添加课程</span>
						</c:if>
						<c:if test="${not empty RegErrorMsg}">
							<span class="glyphicon  glyphicon-user text-danger"></span>
							<span class="text-danger">${RegErrorMsg }</span>
						</c:if>
						<br><br>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-lg-1">
					<div class="form-group">
						<label for="courseName">课程名</label> 
					</div>
				</div>
				<div class="col-lg-3">
					<div class="form-group">
						<input type="text" name="courseName" id="courseName" class="form-control"/>
					</div>
				</div>
				<div class="col-lg-8">
				</div>
			</div>
			<div class="row">
				<div class="col-lg-1">
					<div class="form-group">
						<label for="courseIntroduction">课程介绍</label> 
					</div>
				</div>
				<div class="col-lg-3">
					<div class="form-group">
						<textarea rows="5" cols="100" name="courseIntroduction" id="courseIntroduction" class="form-control"></textarea>
					</div>
				</div>
				<div class="col-lg-8">
				</div>
			</div>
			<div class="row">
				<div class="col-lg-1">
					<div class="form-group">
						<label for="teacher">讲师</label> 
					</div>
				</div>
				<div class="col-lg-3">
					<div class="form-group">
						<select class="form-control" id="teacher" name="teacher">
							<option value="">请安排讲师</option>
							<c:forEach items="${teacherList }" var="teacher">
								<option value="${teacher.id }">${teacher.name }</option>
							</c:forEach>
						</select> 
					</div>
				</div>
				<div class="col-lg-8">
				</div>
			</div>
			<div class="row">
				<div class="col-lg-1">
					<div class="form-group">
						<label for="coursePeriod">课时</label> 
					</div>
				</div>
				<div class="col-lg-3">
					<div class="form-group">
						<input type="text" name="coursePeriod" id="coursePeriod" class="form-control"/>
					</div>
				</div>
				<div class="col-lg-8">
				</div>
			</div>
			<div class="row">
				<div class="col-lg-1">
					<div class="form-group">
						<label for="className">班级</label> 
					</div>
				</div>
				<div class="col-lg-3">
					<div class="form-group">
						<select class="form-control" id="className" name="className">
							<option value="">请安排班级</option>
							<c:forEach items="${classList }" var="class">
								<option value="${class.id }">${class.name }</option>
							</c:forEach>
						</select> 
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
					<button type="submit" class="btn btn-success">添加课程</button>
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

</body>
</html>