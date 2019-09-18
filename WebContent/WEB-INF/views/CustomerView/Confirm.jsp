<%@page import="busticket.model.ProfileCustomer"%>
<%@page import="busticket.model.User"%>
<%@page import="java.sql.Date"%>
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
<link href="${pageContext.request.contextPath}/def/css/confirm.css" style="text/css" rel="stylesheet">
<link rel="shortcut icon" href="${pageContext.request.contextPath}/def/images/icon.ico">s
</head>
<body>
<%ArrayList<Integer> listSeatChoosed = (ArrayList<Integer>) session.getAttribute("lst_chooseSeatName");
Route route= (Route) session.getAttribute("choosedRoute");
Date departDate=(Date) session.getAttribute("depart_Date");
ArrayList <String> listIdBill=(ArrayList <String>) session.getAttribute("lst_idBill");
User user= (User)session.getAttribute("user");
ProfileCustomer pc= (ProfileCustomer) session.getAttribute("pc");
%>
	<t:header></t:header>  
	
	<div class="main" style="padding-top:19px;" >
		<div class="custom-nav">
			<a href="HomeCustomer">Step 1: Choose Location</a>
			<i class="fas fa-angle-double-right"></i>
			<a href="FindRoute">Step 2: Choose Route</a>
			<i class="fas fa-angle-double-right" ></i>
			<a href="AddRoute">Step 3: Choose Seat</a>
			<i class="fas fa-angle-double-right"></i>
			<a  href="" style="color: #a84600;text-decoration: underline;">Step 4: Confirm Infomation</a>
		</div>
		<div style="padding:10px;"></div>
		<div class="ticket row">
			<div class="col-7">Bus ticket</div>
			<div class="col-5">Customer info</div>
		</div>
		<div class="ticket-main row">
			<div class="col-7">
				<div id="title">Route : </div>
				<div id="title" style="padding-left: 5px;font-weight: 600;font-size: 18px;">- Date : <%=departDate%></div>
				<div class="row route">
					<div class="col-5">
						<img src="${pageContext.request.contextPath}/def/images/icon.svg" style=" width: 30px; height: 30px">
						<span style="font-weight: bold;"><%=route.getStartingPoint() %></span> - <%=route.getTimeStarting() %>
					</div>
					<div class="col">
						<i style="padding-left: 50px;"  class="fas fa-arrow-right"></i>
						<div style="padding-left: 0px; font-size: 15px">Expected time: 	<%=route.getTimeFinishing() %></div>
					</div>
					<div class="col-4">
						 <span style="font-weight: bold;"><%=route.getDestination() %></span>				
					</div>
				</div>
				<div id="title">Ticket : </div>
				<table class="table table-striped">
					<thead>
						<tr>
							<th>Code bill</th>
							<th>Seat ID</th>
							<th>Bus Name</th>
							<th>Price (VND)</th>
						</tr>
					</thead>
					<tbody>
						<%for(int i=0; i<listSeatChoosed.size();i++) {%>
						<tr>
							<td id="codebill"><%=listIdBill.get(i)%></td>
							<td><%=listSeatChoosed.get(i) %></td>
							<td>Bus <%=route.getIdCar() %></td>
							<td><%=route.getPrice()%></td>
						</tr>
						<%} %>
						<tr style="color:blue;font-weight: 500;">
							<td ></td>
							<td></td>
							<td>Total price</td>
							<td><%=(listSeatChoosed.size()*route.getPrice()) %></td>
						</tr>
					</tbody>
					
				</table>
			</div>
			<div class="col-5">
				<div class="row">
					<div class="col"><strong>Name : </strong></div>
					<div class="col"><%=pc.getCustomerName() %></div>
				</div>
				<div class="row">
					<div class="col"><strong>Gender : </strong></div>
					<div class="col"><%=pc.getGender() %></div>
				</div>
				<div class="row">
					<div class="col"><strong>BirthDay : </strong></div>
					<div class="col"><%=pc.getDateOfBirth() %></div>
				</div>
				<div class="row">
					<div class="col"><strong>Phonenumber : </strong></div>
					<div class="col"><%=pc.getPhoneNumber() %></div>
				</div>
				<div class="row">
					<div class="col"><strong>Mail : </strong></div>
					<div class="col"><%=user.getEmail()%></div>
				</div>
				<div class="row" style="padding-top: 50px;">
				
					<form class="form" action="AddBill" method="post" style="position: absolute;bottom:30px;">
						<a href="AddRoute" class="btn btn-link" style=" text-decoration: underline; color: black;padding-right: 80px;">Back</a>
                    	<input class="btn btn-warning" type="submit" value="Confirm" style="width: 300px;" >
                	</form>
				</div>
			</div>
		</div>
	</div>
	
	<t:footer></t:footer>
</body>
</html>