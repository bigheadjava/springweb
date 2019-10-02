<%@page language="java" pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<!DOCTYPE html>
<html>
<head>
<title>编辑 Code Type</title>

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
							<span class="glyphicon  glyphicon-chevron-right text-success"></span>
							<span class="text-success">Code Type 列表</span>
						<br><br>
					</div>
				</div>
			</div>
		<div class="row">
			<div class="col-lg-12">
				<table class="table table-striped table-bordered table-hover table-condensed">
		    <caption>
		    	<p class="h6">
		    		可用 Code Type 列表
		    	</p>
		    </caption>
		    <thead>
		        <tr>
		        	<th>序 号</th>
		            <th>Code Type 名字</th>
		            <th>Code Type 描述</th>
		        </tr>
		    </thead>
		    <tbody>
		       <c:forEach items="${codeTypeList }" var="codeType" varStatus="status" >
		       		<tr>
		       			<td>
		       				<a href="<%=request.getContextPath()%>/code/loadEditCodeTypePage/${codeType.id}" title="点击进行编辑">${status.count }</a>
		       			</td>
		       			<td>
		       				<a href="" title="点击进行编辑">${codeType.typeName }</a>
		       			</td>
		       			<td>${codeType.description }</td>
		       		</tr>
		       </c:forEach>
		    </tbody>
		</table>
			</div>
		</div>
		<div class="row">
			<div class="col-lg-12">
				<%@include file="base/footer.jsp"%>
			</div>
		</div>
	</div>

</body>
</html>