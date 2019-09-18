<%@page import="busticket.model.Route"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
             "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>T-Rex Bus</title>

<!-- <link rel="stylesheet" href="css/style.css"> -->
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css" integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">
<link rel="stylesheet" href="${pageContext.request.contextPath}/def/vendor/bootstrap/bootstrap.min.css">
<script src="${pageContext.request.contextPath}/def/vendor/jquery/jquery.js"></script>
<script src="${pageContext.request.contextPath}/def/vendor/bootstrap/bootstrap.min.js" ></script>
<link href="${pageContext.request.contextPath}/def/css/homepage.css" style="text/css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/def/css/chooseroute.css" style="text/css" rel="stylesheet">
<link rel="shortcut icon" href="${pageContext.request.contextPath}/def/images/icon.ico">
</head>
<body>

	<t:header></t:header>  
	<%ArrayList<Route> listRoute= (ArrayList<Route>)session.getAttribute("lst_Route");%>
	<div class="main" style="padding-top:19px;" >
		<div class="custom-nav">
			<a href="HomeCustomer">Step 1: Choose Location</a>
			<i class="fas fa-angle-double-right"></i>
			<a href="FindRoute" style="color: #a84600;text-decoration: underline;">Step 2: Choose Route</a>
			<i class="fas fa-angle-double-right" ></i>
			<a class="btn disabled" href="">Step 3: Choose Seat</a>
			<i class="fas fa-angle-double-right"></i>
			<a class="btn disabled" href="">Step 4: Confirm Infomation</a>
		</div>
		<div class="container row " style="background-color:#fffbcf; margin: auto ; border-radius: 2px;border: 0.5px solid #011329">
			<div class="col-4">
				<div style="padding: 10px; padding-left: 50px; font-weight: bolder;">Starting point</div>
			</div>
			<div class="col-2">
				
			</div>
			<div class="col-4">
				<div style="padding: 10px; padding-left: 50px; font-weight: bolder;">Destination</div>
			</div>
			<div class="col-2">
				<div style="padding: 10px; padding-left: 20px; font-weight: bolder;">Price</div>	
			</div>
		</div>
		<%for(Route route:listRoute){ %>

		<form action="/BusTicket1/AddRoute" method="post" class="container row" style="background-color: #96b9ff; margin: auto ;border-radius: 10px; border: 0.5px solid #011329	">
			<div class="col-4">
				<img src="${pageContext.request.contextPath}/def/images/icon.svg" style="padding-right: 10px; width: 50px; height: 50px">
				<span style="font-weight: bold;"><%=route.getStartingPoint()%></span> - <%=route.getTimeStarting()%>
				<input type="hidden" name="startingPoint" value="<%=route.getStartingPoint()%>">
				<input type="hidden" name="timeStarting" value="<%=route.getTimeStarting()%>">
			</div>
			<div class="col-2">
				<i style="padding-top: 15px; padding-left: 30px;" class="fas fa-arrow-right"></i>
				<div>Expected time: <%=route.getTimeFinishing()%></div>
				<input type="hidden" name="timeExpecting" value="<%=route.getTimeFinishing()%>">
			</div>
			<div class="col-4">
				<div style="padding-top: 14px; padding-left: 50px;">
					<span style="font-weight: bold;"><%=route.getDestination() %></span>
					<input type="hidden" name="destination" value="<%=route.getDestination() %>">
				</div>
				
			</div>
			<div class="col-2">
				<div style="padding-top: 5px;">
					<button type="submit" class="btn btn-warning"><i class="fas fa-bus"></i> Book</button>
				</div>	
				<div><%=route.getPrice() %> VND</div>
			</div>
		
		</form>
		<%} %>
	</div>
	
	<t:footer></t:footer>
</body>
</html>