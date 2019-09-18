<%@page import="busticket.model.Bill"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@page import="java.text.SimpleDateFormat"%>
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
<link rel="shortcut icon" href="${pageContext.request.contextPath}/def/images/icon.ico">
<link href="${pageContext.request.contextPath}/def/css/manageticket.css" style="text/css" rel="stylesheet">
</head>
<body>
<%
	int mess= (Integer)request.getAttribute("mess");
%>
	<t:header></t:header>  
	
		<div class="main">
		<div class="tab">
			<div id="title" align="center">Your Ticket</div>
		<%if(mess==-1) {%>
			   <div class="alert alert-danger alert-dismissible">
			    <button type="button" class="close" data-dismiss="alert">&times;</button>
			    <strong>Warning!</strong> You can't cancel ticket which was booked over 24 hours. 
			  </div>
			  <%} %>
			<table class="table table-striped">
				<thead class="bg-info">
					<tr>
						<th>.No</th>
						<th>Code Bill</th>
						<th>Booked date</th>
						<th>Seat</th>
 						<th>Bus name</th> 
						<th>Starting point</th>
						<th>Destination</th>
						<th>Depart time</th>
						<th>Action</th> 					
					</tr>
				</thead>
				<tbody>
				<c:forEach items="${list}" var="item" varStatus="Myindex">
					<tr>
						<td> ${Myindex.index+1}</td>
						<td>${item.id}</td>
						<td><fmt:formatDate type = "both" value = "${item.bookingdate}" /></td>
						<td>${item.ticketObject.seatObject.seatName}</td>
						<td>${item.ticketObject.sessionObject.carObject.carName}</td>
						<td>${item.ticketObject.sessionObject.routeObject.startingPoint}</td>
						<td>${item.ticketObject.sessionObject.routeObject.destination}</td>
						<td>${item.ticketObject.sessionObject.routeObject.timeStarting} <fmt:formatDate type = "date" value = "${item.ticketObject.sessionObject.departDate}" /></td> 
						<td><a href="${pageContext.request.contextPath}/DeleteTicket?id=${item.id}">Cancel</a></td>  
					</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	
	<t:footer></t:footer>
</body>
</html>