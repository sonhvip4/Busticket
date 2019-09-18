
<%@page import="busticket.model.User"%>
<%@page import="busticket.model.ProfileCustomer"%>
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
<link href="${pageContext.request.contextPath}/def/css/proviewcustomer.css" style="text/css" rel="stylesheet">
<link rel="shortcut icon" href="${pageContext.request.contextPath}/def/images/icon.ico">
</head>
<body>
<%ProfileCustomer pc= (ProfileCustomer) session.getAttribute("pc");
	User user = (User) session.getAttribute("user");
%>
	<t:header></t:header>  
	
	<div class="main">
        <div class=" container" style="width: 800px">
                <div class="row">
                    <div class="col-12">
                        <div class="card">

                            <div class="card-body">
                            
                                <div class="card-title mb-4">
                                    <div class="d-flex justify-content-start">
                                        <div class="image-container">
                                            <img src="${pageContext.request.contextPath}/def/images/login.png" id="imgProfile"  class="img-thumbnail" />                    
                                        </div>
                                        <div class="userData ml-3">
                                            <h2 class="d-block" style="padding-top: 50px;font-size: 30px"><%=user.getUserName()%></h2>
                                            
                                        </div>
                                        
                                    </div>
                                </div>

                                <div class="row">
                                    <div class="col-12">
                                        <ul class="nav nav-tabs mb-4" id="myTab" role="tablist">
                                            <li class="nav-item">
                                                <a class="nav-link active" id="basicInfo-tab" data-toggle="tab" 
                                                href="#basicInfo" role="tab" aria-controls="basicInfo" aria-selected="true">Information</a>
                                            </li>
                                            
                                        </ul>
                                        <form>
                                        <div class="tab-content ml-1" id="myTabContent">
                                            <div class="tab-pane fade show active"  id="basicInfo" role="tabpanel" aria-labelledby="basicInfo-tab">
                                                <div class="row">
                                                    <div class="col-sm-3 col-md-2 col-5">
                                                        <label >User Name</label>
                                                    </div>
                                                    <div class="col-md-8 col-6">
                                                        <input type="text" class="form-control" disabled value="<%=user.getUserName() %>" required>
                                                    </div>
                                                </div>
                                                <hr /><div class="row">
                                                    <div class="col-sm-3 col-md-2 col-5">
                                                        <label >User Name</label>
                                                    </div>
                                                    <div class="col-md-8 col-6">
                                                        <input type="password" class="form-control" value="<%=user.getPassword()%>" pattern="[a-zA-Z0-9]{6,20}" title="Six to twenty characters and don't have special characters!"  required>
                                                    </div>
                                                </div>
                                                <hr />
                                                <div class="row">
                                                    <div class="col-sm-3 col-md-2 col-5">
                                                        <label >Full Name</label>
                                                    </div>
                                                    <div class="col-md-8 col-6">
                                                        <input type="text" class="form-control" value="<%=pc.getCustomerName() %>" pattern="[A-z\s]{5,30}" title="Name too long or have special characters!"  required>
                                                    </div>
                                                </div>
                                                <hr />

                                                <div class="row">
                                                    <div class="col-sm-3 col-md-2 col-5">
                                                        <label >Birth Date</label>
                                                    </div>
                                                    <div class="col-md-8 col-6">
                                                            <input type="date" class="form-control" value="<%=pc.getDateOfBirth()%>" max="2019-01-01" required>
                                                    </div>
                                                </div>
                                                <hr />
                                                
                                                
                                                <div class="row">
                                                    <div class="col-sm-3 col-md-2 col-5">
                                                        <label >Gender</label>
                                                    </div>
                                                    <div class="col-md-8 col-6">
                                                        <select id="inputState" class="form-control">
                                                            <%if(pc.getGender().equals("male")){
                                        						%>
                                        					<option value="male" selected="checked">Male</option>
                                           					 <option value="female">Female</option>
                                           					 <% 
                                        					}else{
                                            				%>
                                            				<option value="male">Male</option>
                                            				<option value="female" selected="checked">Female</option>
                                            				<%} %>
                                                        </select> 
                                                    </div>
                                                </div>
                                                <hr />
                                                <div class="row">
                                                    <div class="col-sm-3 col-md-2 col-5">
                                                        <label >Email</label>
                                                    </div>
                                                    <div class="col-md-8 col-6">
                                                        <input type="email" class="form-control" aria-describedby="emailHelp" value="<%=user.getEmail() %>" required>
                                                    </div>
                                                </div>
                                                <hr />
                                                <div class="row">
                                                    <div class="col-sm-3 col-md-2 col-5">
                                                        <label >Phone number</label>
                                                    </div>
                                                    <div class="col-md-8 col-6">
                                                        <input type="tel" class="form-control" name="phone" pattern="[0-9]{1}[0-9]{9}" value="<%=pc.getPhoneNumber() %>" required>
                                                    </div>
                                                </div>
                                                <hr />
                                                <div class="row">
                                                    <div class="col-sm-3 col-md-2 col-5">
                                                        <label >Country</label>
                                                    </div>
                                                    <div class="col-md-8 col-6">
                                                            <input type="text" class="form-control" value="<%=pc.getCountry() %>" pattern="[A-z\s]{5,30}" title="Too short/long or have special characters!" required>
                                                    </div>
                                                </div>
                                                <hr />
                                            
                                            </div>
                                            <input type="submit" class="btn btn-primary"  id="btnChange" value="Change" onclick="return confirm('Are you sure you want to Change?')" />  
                                        </div>
                                    </div>
                                    
                                </div>
                            </form>

                            </div>

                        </div>
                    </div>
                </div>
            </div>
    </div>    
	
	<t:footer></t:footer>
</body>
</html>