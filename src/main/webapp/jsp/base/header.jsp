<%@page language="java" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<img src="<%=request.getContextPath()%>/images/top1.png"
	class="img-responsive">
	
<%-- <nav class="navbar navbar-default" role="navigation">
	<div class="navbar-header">
		<button type="button" class="navbar-toggle" data-toggle="collapse"
			data-target="#menu">
			<span class="sr-only">展开导航</span> <span class="icon-bar"></span> <span
				class="icon-bar"></span> <span class="icon-bar"></span> <span
				class="icon-bar"></span>
		</button>
		<a class="navbar-brand" href="<%=request.getContextPath()%>/jsp/logout.jsp">注销</a>
	</div>
	<div class="collapse navbar-collapse" id="menu">
		<ul class="nav navbar-nav" >
			<li class="active"><a
				href="<%=request.getContextPath()%>/jsp/index.jsp">首页</a></li>
			<li><a href="<%=request.getContextPath()%>/jsp/jsp-basic.jsp">JSP基础</a></li>
			<li><a href="<%=request.getContextPath()%>/jsp/access-javabean.jsp">JSP访问JavaBean</a></li>
			<li><a href="<%=request.getContextPath()%>/jsp/el.jsp">EL表达式</a></li>
			<li><a href="<%=request.getContextPath()%>/jstl-tag">JSTL标签</a></li>
			<li><a href="<%=request.getContextPath()%>/mylocale">Locale</a></li>
			<li><a href="<%=request.getContextPath()%>/jsp/lottery.jsp">课堂抽奖</a></li>
		</ul>
	</div>
</nav> --%>

<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/jquery-1.12.js"></script>
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