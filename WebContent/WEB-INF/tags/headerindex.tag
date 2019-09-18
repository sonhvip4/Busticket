<%@ tag language="java" pageEncoding="UTF-8"%>
<header class="header">
	<nav
		class="navbar navbar-expand-lg navbar-primary justify-content-between fixed-top task-bar">
		<a class="navbar-brand" href="${pageContext.request.contextPath}/Home"> <img src="${pageContext.request.contextPath}/def/images/logo-1.jpg"
			width="90" height="40" class="d-inline-block" alt="">
		</a>
		<ul class="nav nav-pills">
			<li class="nav-item active">
				<a class="a nav-link " href="Home" style="font-weight: bolder">HOME</a></li>
			<li class="nav-item">
				<a class="nav-link "  href="#" style="font-weight: bolder">MANAGE TICKET</a></li>
			<li class="nav-item">
				<a class="nav-link"  href="#" style="font-weight: bolder">ABOUT</a></li>
			<li class="nav-item" style="padding-right: 20px;">
				<a class="nav-link"  href="#" style="font-weight: bolder">SUPPORT</a></li>
			<li class="nav-item">
				  <a class="nav-link"  href="${pageContext.request.contextPath}/Login" style="font-weight: bolder">LOGIN</a>
			</li>
		</ul>
	</nav>
</header>
