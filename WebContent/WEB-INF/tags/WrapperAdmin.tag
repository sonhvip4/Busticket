<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8" />
<title>Trang quản lý</title>
<meta
	content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0, shrink-to-fit=no'
	name='viewport' />
<!--     Fonts and icons     -->
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css" integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">
<link
	href="https://fonts.googleapis.com/css?family=Montserrat:400,700,200"
	rel="stylesheet" />
<link
	href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css"
	rel="stylesheet">
<!-- CSS Files -->
<link
	href="${pageContext.request.contextPath}/def/vendor/bootstrap/bootstrap.min.css"
	rel="stylesheet" />
<link
	href="${pageContext.request.contextPath}/def/vendor/bootstrap/paper-dashboard.css"
	rel="stylesheet" />
<link href="${pageContext.request.contextPath}/def/css/plugins/jquery.dataTables.min.css"
	rel="stylesheet" />
<script
	src="${pageContext.request.contextPath}/def/vendor/jquery/jquery.js"></script>
<!-- CSS Just for demo purpose, don't include it in your project -->
<link href="${pageContext.request.contextPath}/def/css/wrapperadmin.css"
	rel="stylesheet" />
<link href="${pageContext.request.contextPath}/def/css/ChooseSeat.css"
	rel="stylesheet" />	
<link href="${pageContext.request.contextPath}/def/css/chooseroute.css"
	rel="stylesheet" />	
<link href="${pageContext.request.contextPath}/def/css/confirm.css"
	rel="stylesheet" />
<link href="${pageContext.request.contextPath}/def/css/manageticket.css"
	rel="stylesheet" />
<link href="${pageContext.request.contextPath}/def/css/proviewcustomer.css"
	rel="stylesheet" />
<link href="${pageContext.request.contextPath}/def/css/edit-route.css"
	rel="stylesheet" />
<link href="${pageContext.request.contextPath}/def/css/sellerstyle.css"
	rel="stylesheet" />
<link href="${pageContext.request.contextPath}/def/css/route-management.css"
	rel="stylesheet" />
</head>

<body class="">
	<div class="wrapper">

		<t:SideAdminMenu></t:SideAdminMenu>

		<div class="main-panel">


			<t:header></t:header>
			<!-- End Navbar -->

			<div class="content">
				<jsp:doBody></jsp:doBody>
				<t:footer></t:footer>
			</div>


			<!--   Core JS Files   -->
			<script
				src="${pageContext.request.contextPath}/def/vendor/jquery/jquery.js"></script>
			<script
				src="${pageContext.request.contextPath}/def/vendor/bootstrap/popper.min.js"></script>
			<script
				src="${pageContext.request.contextPath}/def/vendor/bootstrap/bootstrap.min.js"></script>
			<script
				src="${pageContext.request.contextPath}/def/js/plugins/perfect-scrollbar.jquery.min.js"></script>
			<!--  Google Maps Plugin    -->
			<script
				src="${pageContext.request.contextPath}/def/js/plugins/chartjs.min.js"></script>
			<!--  Notifications Plugin    -->
			<script
				src="${pageContext.request.contextPath}/def/js/plugins/bootstrap-notify.js"></script>
			<!-- Control Center for Now Ui Dashboard: parallax effects, scripts for the example pages etc -->
			<script
				src="${pageContext.request.contextPath}/def/js/paper-dashboard.min.js"
				type="text/javascript"></script>
			<!-- Paper Dashboard DEMO methods, don't include it in your project! -->
			<script src="${pageContext.request.contextPath}/def/js/wrapperadmin.js"></script>
			<script src="${pageContext.request.contextPath}/def/js/chooseseat.js"></script>
			<script src="${pageContext.request.contextPath}/def/js/awesome.js"></script>
			<script src="${pageContext.request.contextPath}/def/js/edit-seller.js"></script>
			<scrip src="${pageContext.request.contextPath}/def/vendor/jquery/jquery.dataTables.min.js"></script>
		</div>
	</div>
</body>
</html>
