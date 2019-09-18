<%@ tag language="java" pageEncoding="UTF-8"%>
<div class="sidebar" data-color="blue" data-active-color="danger">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<div class="logo">
		<a href="http://www.creative-tim.com" class="simple-text logo-mini">
			<div class="logo-image-small">
				<img
					src="#">
			</div>
		</a> <a href="http://www.creative-tim.com" class="simple-text logo-normal">
			Group 2 </a>
	</div>
	<div class="sidebar-wrapper">
		<ul class="nav">
			<li><a href="#"> <i class="nc-icon nc-bank"></i> Homepage
			</a></li>

<!-- Phan quyen admin -->
			<c:if test="${loginedUser.roleObject.roleName eq 'admin' }">
				<li><a href="#"> <i
					class="nc-icon nc-bell-55"></i> Info 
				</a></li>
				<li><a href="${pageContext.request.contextPath}/">
						<i class="nc-icon nc-tile-56"></i> User Management
				</a></li>
			</c:if>

<!-- Phan quyen seller -->
			<c:if test="${loginedUser.roleObject.roleName eq 'seller' }">
				<li><a href="#"> <i
					class="nc-icon nc-bell-55"></i> Info 
				</a></li>
				<li><a href="${pageContext.request.contextPath}/">
						<i class="nc-icon nc-pin-3"></i> Ticket Management
				</a></li>
			</c:if>
			
			
<!-- Phan quyen customer -->
			<c:if test="${loginedUser.roleObject.roleName eq 'customer' }">
				<li><a href="#"> <i
					class="nc-icon nc-bell-55"></i> Info 
				</a></li>
				<li><a href="#">
						<i class="nc-icon nc-tile-56"></i> Booking Ticket
				</a></li>
			</c:if>
			
			<li><a href="${pageContext.request.contextPath}/Logout"> <i
					class="nc-icon nc-pin-3"></i> Log out
			</a></li>

		</ul>
	</div>
</div>


