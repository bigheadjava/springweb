<%@page language="java" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	
<nav class="navbar navbar-default" role="navigation">
	<div class="navbar-header">
		<button type="button" class="navbar-toggle" data-toggle="collapse"
			data-target="#menu">
			<span class="sr-only">展开导航</span> <span class="icon-bar"></span> <span
				class="icon-bar"></span> <span class="icon-bar"></span> <span
				class="icon-bar"></span>
		</button>
		<a class="navbar-brand" href="<%=request.getContextPath()%>/logout"><span class="text-success h4">注销</span></a>
	</div>
	<div class="collapse navbar-collapse" id="menu">
		<ul class="nav navbar-nav" >
			<li class="active">
				<a href="<%=request.getContextPath()%>/countryBirthday/?country=中华人民共和国&age=70"><span class="text-success h4">庆祝国庆</span></a>
			</li>
			<li class="active">
				<a href="<%=request.getContextPath()%>/loadHomePage"><span class="text-success h4">首页</span></a>
			</li>
			<li>
				<a href="<%=request.getContextPath()%>/loadLotteryPage"><span class="text-success h4">课堂抽奖</span></a>
			</li>
			<li>
				<a href="<%=request.getContextPath()%>/loadAddCourse"><span class="text-success h4">添加课程</span></a>
			</li>
			<li class="dropdown"> 
				<a href="#" class="dropdown-toggle" data-toggle="dropdown">
					<span class="text-success h4">Code Admin</span> 
					<b class="caret"></b>
				</a>
                <ul class="dropdown-menu">
                    <li><a href="<%=request.getContextPath()%>/code/loadAddCodeType"><span class="text-danger h5">添加 Code Type</span></a></li>
                    <li><a href="<%=request.getContextPath()%>/code/listCodeType"><span class="text-danger h5">编辑 Code Type</span></a></li>
                    <li class="divider"></li>
                    <li><a href="<%=request.getContextPath()%>/code/loadAddCodePage"><span class="text-danger h5">添加 Code</span></a></li>
                    <li><a href="#"><span class="text-danger h5">编辑 Code</span></a></li>
                </ul>
            </li>
            <li class="dropdown"> 
				<a href="#" class="dropdown-toggle" data-toggle="dropdown">
					<span class="text-success h4">课程管理</span> 
					<b class="caret"></b>
				</a>
                <ul class="dropdown-menu">
                    <li><a href="<%=request.getContextPath()%>/course/loadCreateClass"><span class="text-danger h5">创建班级</span></a></li>
                    <li><a href="<%=request.getContextPath()%>/code/listCodeType"><span class="text-danger h5">编辑班级</span></a></li>
                    <li class="divider"></li>
                    <li><a href="<%=request.getContextPath()%>/code/loadAddCodePage"><span class="text-danger h5">创建课程</span></a></li>
                    <li><a href="#"><span class="text-danger h5">编辑课程</span></a></li>
                </ul>
            </li>
		</ul>
	</div>
</nav> 

<script type="text/javascript"src="<%=request.getContextPath()%>/js/jquery-1.12.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/bootstrap.js"></script>
<script>
	$(function () {
        $(".navbar-nav").find("li").each(function () {
            var a = $(this).find("a:first");
            if ($(a).attr("href") == location.pathname) {
                $(this).addClass("active");
            } else {
                $(this).removeClass("active");
            }
        });
    });
</script>