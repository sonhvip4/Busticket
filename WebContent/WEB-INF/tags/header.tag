<%@tag import="busticket.model.User"%>
<%@ tag language="java" pageEncoding="UTF-8"%>
<header class="header">
<%User user= (User) session.getAttribute("user"); %>
	<nav
		class="navbar navbar-expand-lg navbar-primary justify-content-between fixed-top task-bar">
		<a class="navbar-brand" href="HomeCustomer"> <img src="${pageContext.request.contextPath}/def/images/logo-1.jpg"
			width="90" height="40" class="d-inline-block" alt="">
		</a>
		<ul class="nav nav-pills">
			<li class="nav-item active">
			<a class="a nav-link" href="HomeCustomer" style="font-weight: bolder">HOME</a>
			</li>
			<li class="nav-item">
				<a class="nav-link"href="ListTicket" style="font-weight: bolder">MANAGE TICKET</a>
			</li>
			<li class="nav-item">
				<a class="nav-link" href="#" style="font-weight: bolder">ABOUT</a>
			</li>
			<li class="nav-item" style="padding-right: 20px;">
				<a class="nav-link"  href="#" style="font-weight: bolder">SUPPORT</a>
			</li>
			<div class="text-primary" id="hi-user"
				style="padding-top: 15px; padding-right: 10px;">Hi <%=user.getUserName()%>,
			</div>
			<div class="dropdown float-right" style="padding-top: 10px;">
				<button type="button" class="btn btn-primary "
					data-toggle="dropdown">
					<i class=" fas fa-user"></i>
				</button>
				<div class="dropdown-menu dropdown-menu-right bg-info menu-user">
					<a class="dropdown-item" href="ProfileCustomer">View Profile</a> <a
						class="dropdown-item" href="ListTicket">Manage Ticket</a> <a
						class="dropdown-item" href="Logout">Logout</a>
				</div>
			</div>
		</ul>
	</nav>
</header>