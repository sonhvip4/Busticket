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
<link rel="shortcut icon" href="http://example.com/favicon.ico" />
<!-- <link rel="stylesheet" href="css/style.css"> -->
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css" integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">
<link rel="stylesheet" href="${pageContext.request.contextPath}/def/vendor/bootstrap/bootstrap.min.css">
<script src="${pageContext.request.contextPath}/def/vendor/jquery/jquery.js"></script>
<script src="${pageContext.request.contextPath}/def/vendor/bootstrap/bootstrap.min.js" ></script>
<link href="${pageContext.request.contextPath}/def/css/homepage.css" style="text/css" rel="stylesheet">
<link rel="shortcut icon" href="${pageContext.request.contextPath}/def/images/icon.ico">
</head>
<body>

	<t:headerindex></t:headerindex>  
	
	<article class="bbody">
		<div class="container search-box">
			<form class="form-inline form-group form-search" action="Login" method="post" style="padding: 30px;">
				<label for="select" style="padding-right: 3px; color: #FFFFFF;"><b>Starting Point:</b></label>

			  	<select name="str" class="custom-select" style="width: 180px;" required>
			  	<c:forEach items="${province}" var="item">
			  		<option>${item.name}</option>
				</c:forEach>
			  	</select>
			  	<label for="select" style="padding-left: 40px; padding-right: 3px; color: #FFFFFF;"><b>Destination: </b></label>
			  	<select name="des" class="custom-select" style="width: 180px;" required>
			  	<c:forEach items="${province}" var="item">
			  		<option>${item.name}</option>
				 </c:forEach>
			  	</select>
			  	<label for="select" style="padding-left: 40px;padding-right: 3px; color: #FFFFFF;"><b>Depart Date: </b></label>
			  	<input  class="custom-date form-control" type="date" style="margin-right: 30px; width: 180px;" required name="departDate">
			  	<input style="width: 72px;height: 35px" type="submit" class="btn btn-primary btn-sm btn-submit" value="Find">
	
			</form>
	</div>
	</article>
	
	<t:footer></t:footer>
</body>
</html>