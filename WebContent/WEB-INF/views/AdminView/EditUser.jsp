<%@page import="java.sql.Date"%>
<%@page import="busticket.model.ProfileManager"%>
<%@page import="busticket.model.ProfileCustomer"%>
<%@page import="busticket.model.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <link href="${pageContext.request.contextPath}/def/vendor/bootstrap/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="${pageContext.request.contextPath}/def/vendor/bootstrap/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/def/vendor/jquery/jquery.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/def/css/proview.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/def/css/style.css">
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
     
     table {
  border-collapse: collapse;
  width: 100%;
}

td {
    max-width: 100px;
    overflow: hidden;
    text-overflow: ellipsis;
    white-space: nowrap;
}

th, td {
  padding: 8px;
  text-align: left;
  border-bottom: 1px solid #ddd;
}
        

</style>
<link rel="shortcut icon" href="${pageContext.request.contextPath}/def/images/icon.ico">     
</head>
<% User user=(User) session.getAttribute("edituser");
	Date birthdate=null;
	String gender=null;
	String phoneNumber=null;
	String name=null;
	if(user.getIdRoleUser()==3){
		ProfileCustomer pc= (ProfileCustomer) session.getAttribute("userplus");
		birthdate=pc.getDateOfBirth();
		gender=pc.getGender();
		phoneNumber=pc.getPhoneNumber();
		name=pc.getCustomerName();
	}else{
		ProfileManager pm= (ProfileManager) session.getAttribute("userplus");
		birthdate=pm.getDateOfBirth();
		gender=pm.getGender();
		phoneNumber=pm.getPhoneNumber();
		name=pm.getManagerName();
	}

%>
<body>
<div class="container-fluid">
        
    <div class="row">
        <div class="col-2 wrapper">
            <div class="sidebar nav flex-column nav-pills" id="v-pills-tab" role="tablist" aria-orientation="vertical">
                    <a href="AdminHome"  style="text-decoration: none"><h2>Admin</h2></a>
                    <a href="AdminHome" class="nav-link" > 
                            Admin Info
                        </a>
                    <a href="UserMan" class="nav-link active"  > 
                            User management
                        </a>
                        <a href="UpdateRoute" class="nav-link"  > 
                            Update Route
                        </a>
                	<div style="padding-top: 300px; font-size: 20px;">
                    	<a href="Logout" class="nav-link" style="text-decoration: underline;">Logout</a>
                    </div>
             
            </div>
        </div>
        
        <div class="col-9">
            <form class="form" action="AdminChangeUser" method="POST">
            	<input type="hidden" name="idroleuser" value="<%=user.getIdRoleUser()%>" >
                <div style="padding-top: 80px" class="row">
                    <div class="col-sm-3 col-md-2 col-5">
                        <label >User Name</label>
                    </div>
                    <div class="col-md-8 col-6">
                        <input class="form-control" type="text" value="<%=user.getUserName()%>" disabled >
                    </div>
                </div>
                <hr />
                                
                <div class="row">
                    <div class="col-sm-3 col-md-2 col-5">
                        <label >Password</label>
                    </div>
                    <div class="col-md-8 col-6">
                        <input class="form-control" name="password" type="password" value="<%=user.getPassword() %>" required>
                    </div>
                </div>
                <hr/>
                <div class="row">
                                <div class="col-sm-3 col-md-2 col-5">
                                    <label >Full Name</label>
                                </div>
                                <div class="col-md-8 col-6">
                                    <input name="name" class="form-control" type="text" value="<%=name%>" required>
                                </div>
                            </div>
                            <hr />
                <div class="row">
                    <div class="col-sm-3 col-md-2 col-5">
                        <label >Birth Date</label>
                    </div>
                    <div class="col-md-8 col-6">
                        <input class="form-control" name="date" type="date" value="<%=birthdate%>" required>
                    </div>
                </div>
                <hr />  
                <div class="row">
                    <div class="col-sm-3 col-md-2 col-5">
                        <label >Gender</label>
                    </div>
                    <div class="col-md-8 col-6">
                        <select class="form-control" name="gender">
                            <%if(gender.equals("male")){
                                        	%>
                                        	<option value="male" selected="checked">Male</option>
                                            <option value="female">Female</option>
                                            <% 
                                        }else{
                                            %>
                                            <option value="male">Male</option>
                                            <option value="female" selected="checked">Female</option>
                                            <%
                                        	}
                                            %>
                        </select>
                    </div>
                </div>
                <hr />
                <div class="row">
                    <div class="col-sm-3 col-md-2 col-5">
                        <label >Email</label>
                    </div>
                    <div class="col-md-8 col-6">
                        <input type="email" class="form-control" name="email" aria-describedby="emailHelp" value="<%=user.getEmail() %>" required>
                    </div>
                </div>
                <hr />
                <div class="row">
                    <div class="col-sm-3 col-md-2 col-5">
                        <label >Phone number</label>
                    </div>
                    <div class="col-md-8 col-6">
                        <input type="tel" class="form-control" name="phone" pattern="[0]{1}[0-9]{9}" value="<%=phoneNumber %>" required>
                    </div>
                </div>
                <hr />
                
                <input type="submit" class="btn btn-warning" value="Change" onclick="return confirm('Are you sure you want to change?')" />
            </form>
        </div>
    </div>

</div>

<script src="js/jquery/jquery.js"></script>
<script src="js/bootstrap/bootstrap.min.js"></script>


<script src="js/bootstrap/popper.min.js"></script>
   
</body>
</html> 