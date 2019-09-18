<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
   <meta charset="UTF-8">
   <meta name="viewport" content="width=device-width, initial-scale=1">
   <!-- <link rel="stylesheet" href="css/style.css"> -->
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css" integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/def/vendor/bootstrap/bootstrap.min.css">
	<script src="${pageContext.request.contextPath}/def/vendor/jquery/jquery.js"></script>
	<script src="${pageContext.request.contextPath}/def/vendor/bootstrap/bootstrap.min.js" ></script>
	<link href="${pageContext.request.contextPath}/def/css/index.css" style="text/css" rel="stylesheet">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/def/css/login.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/def/css/reset.css">
	<title>LOGIN</title>
	<link rel="shortcut icon" href="${pageContext.request.contextPath}/def/images/icon.ico">
</head>
<body> 
	 <t:headerindex></t:headerindex>
		
      <div class="limiter">
		<div class="container-login">
			<div class="wrap-login">
				<form class="login-form" method="POST" action="Login">
					<span class="title-login-form">Login Bus Ticket</span>
					<input type="hidden" name="redirectId" value="${param.redirectId}" /> 
					<div class="icon-login-form"><img src="https://img.lovepik.com/original_origin_pic/19/01/07/4b5dcca1acbb615c893638ba35f98b03.png_wh860.png"></div>
                    <br/>
					<div class="wrap-input" data-validate="Valid email is: a@b.c">
						<input type="text" placeholder="Username" name="userName">
					</div>
					<div class="wrap-input" data-validate="Xin nhập mật khẩu">
						<input type="password" placeholder="Password" name="passWord">
                    </div>
                    <div class="ck"><input type="checkbox" name="">Remember password</div>
					<div class="input-btn"><button type="submit">Login</button></div>
					<p style="color: red;">${errorString}</p>
					<div class="input-option">
                    <div class="register"><a href="${pageContext.request.contextPath}/Register">Register</a></div>
					<div class="forget"><a href="${pageContext.request.contextPath}/Register">Forgot password</a></div>
					</div>
					
				</form>	
				</div>
			</div>
		</div>
	</div>

	<t:footer></t:footer> 
</body>
</html>