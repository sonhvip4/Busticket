<%@page import="java.sql.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <!-- Required meta tags-->
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="Colorlib Templates">
    <meta name="author" content="Colorlib">
    <meta name="keywords" content="Colorlib Templates">
	<link rel="shortcut icon" href="${pageContext.request.contextPath}/def/images/icon.ico">
    <!-- Title Page-->
    <title>REGISTER</title>

    <!-- Icons font CSS-->
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css" integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">
    <link href="${pageContext.request.contextPath}/def/vendor/mdi-font/css/material-design-iconic-font.min.css" rel="stylesheet" media="all">
    <link href="${pageContext.request.contextPath}/def/vendor/font-awesome-4.7/css/font-awesome.min.css" rel="stylesheet" media="all">
    <!-- Font special for pages-->
    <link href="https://fonts.googleapis.com/css?family=Roboto:100,100i,300,300i,400,400i,500,500i,700,700i,900,900i" rel="stylesheet">

    <!-- Vendor CSS-->
    <link href="${pageContext.request.contextPath}/def/vendor/select2/select2.min.css" rel="stylesheet" media="all">
    <link href="${pageContext.request.contextPath}/def/vendor/datepicker/daterangepicker.css" rel="stylesheet" media="all">

    <!-- Bootstrap and Jquery-->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/def/vendor/bootstrap/bootstrap.min.css">
    <script src="${pageContext.request.contextPath}/def/vendor/jquery/jquery.js"></script>
    <script src="${pageContext.request.contextPath}/def/vendor/bootstrap/bootstrap.min.js" ></script>

    <!-- <link rel="stylesheet" href="css/style.css"> -->
    <link href="${pageContext.request.contextPath}/def/css/index.css" style="text/css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/def/css/main.css" rel="stylesheet" media="all">
</head>

<body>
 	
 	<t:headerindex></t:headerindex> 
 	<%long millis=System.currentTimeMillis(); 
Date maxdate=new java.sql.Date(millis);
String mess= (String)request.getAttribute("mess");
%>
    <div class="page-wrapper bg-blue p-t-100 p-b-100 font-robo">
        <div class="wrapper wrapper--w680">
            <div class="card card-1">
                <div class="card-heading"></div>
                <div class="card-body">
                    <h2 class="title">Register</h2>
                    <%if(!mess.equals("mess")) {%>
	                    <div class="alert alert-danger alert-dismissible" style="margin-top: 20px; ">
					    	<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
					    	<strong><%=mess %> is already exist</strong> Please try again!
				  		</div>
			  		<%} %>
                    <form action="Register" method="POST">
                        <div class="input-group">
                            <input class="input--style-1" type="text" placeholder="NAME" name="name" pattern="[A-z\s]{5,30}" title="Name too long or have special characters!"  required>
                        </div>
                        <div class="input-group">
                                <input class="input--style-1" type="text" placeholder="USERNAME" name="username" pattern="[a-zA-Z0-9]{6,20}" title="Six to twenty characters" required>
                        </div>
                        <div class="input-group">
                                <input id="password" class="input--style-1" type="password" placeholder="PASSWORD" name="password"  pattern="[a-zA-Z0-9]{6,20}" title="Six to twenty characters and don't have special characters!"  required>
                        </div>
                        <div class="input-group">
                                <input id="confirm_password" class="input--style-1" type="password" placeholder="REPEAT PASSWORD"  required>
                        </div>
                        <div class="input-group">
                                <input class="input--style-1" type="text" placeholder="EMAIL" name="email" type="email" aria-describedby="emailHelp" required>
                            </div>
                        <div class="row row-space">
                            <div class="col-12 col-sm-6">
                                <div class="input-group">
                                    <input type="date" placeholder="BIRTHDATE" name="birthday" max="<%=maxdate %>" required>
                                    <i class="zmdi zmdi-calendar-note input-icon js-btn-calendar"></i>
                                </div>
                            </div>
                            <div class="col-12 col-sm-6">
                                <div class="input-group">
                                    <div class="rs-select2 js-select-simple select--no-search">
                                        <select name="gender" required>
                                            <option disabled="disabled" selected="selected">GENDER</option>
                                            <option>Male</option>
                                            <option>Female</option>
                                        </select>
                                        <div class="select-dropdown"></div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="row row-space">
                            <div class="col-12 col-sm-6">
                                <div class="input-group">
                                    <input class="input--style-1" type="text" placeholder="PHONE NUMBER" name="phonenumber" pattern="[0]{1}[0-9]{9}" title="Phonenumber has 10 numbers!" required>
                                </div>
                            </div>
                            <div class="col-12 col-sm-6">
                                    <div class="input-group">
                                        <input class="input--style-1" type="text" placeholder="COUNTRY" name="country" pattern="[A-z\s]{5,30}" title="Too short/long or have special characters!" required>
                                    </div>
                                </div>
                        </div>
                        <div class="p-t-20">
                            <button class="btn btn--radius btn--green" type="submit">Submit</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>

	<t:footer></t:footer>
	<script>
	var password = document.getElementById("password")
	  , confirm_password = document.getElementById("confirm_password");

	function validatePassword(){
	  if(password.value != confirm_password.value) {
	    confirm_password.setCustomValidity("Password Don't Match");
	  } else {
	    confirm_password.setCustomValidity('');
	  }
	}

	password.onchange = validatePassword;
	confirm_password.onkeyup = validatePassword;
	</script>
    <!-- Jquery JS-->
    <script src="${pageContext.request.contextPath}/def/vendor/jquery/jquery.min.js"></script>
    <!-- Vendor JS-->
    <script src="${pageContext.request.contextPath}/def/vendor/select2/select2.min.js"></script>
    <script src="${pageContext.request.contextPath}/def/vendor/datepicker/moment.min.js"></script>
    <script src="${pageContext.request.contextPath}/def/vendor/datepicker/daterangepicker.js"></script>

    <!-- Main JS-->
    <script src="${pageContext.request.contextPath}/def/js/global.js"></script>

</body><!-- This templates was made by Colorlib (https://colorlib.com) -->

</html>