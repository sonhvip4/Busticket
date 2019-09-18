<%@page import="busticket.model.ProfileManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<LINK REL="SHORTCUT ICON"  HREF="${pageContext.request.contextPath}/def/images/icon.ico">
    <link href="${pageContext.request.contextPath}/def/vendor/bootstrap/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="${pageContext.request.contextPath}/def/vendor/jquery/jquery.js"></script>
     <script src="${pageContext.request.contextPath}/def/vendor/bootstrap/bootstrap.min.js"></script>
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
<body>
<%
	ProfileManager pm = (ProfileManager) session.getAttribute("pm");
	String mess= (String) session.getAttribute("mess");
	
%>
<div class="container-fluid">
        
    <div class="row">
        <div class="col-2 wrapper">
            <div class="sidebar nav flex-column nav-pills" id="v-pills-tab" role="tablist" aria-orientation="vertical">
                    <a href="AdminHome" style="text-decoration: none"><h2>Admin</h2></a>
                    <a href="AdminHome" class="nav-link active" > 
                            Admin Info
                        </a>
                    <a href="UserMan" class="nav-link"  > 
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
        
        <div style="padding-top: 90px;" class="col-9">
            <div >
            <%if(mess.equals("success")){ %>
            	<div class="alert alert-success alert-dismissible">
			    	<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
			    <strong>Update Route successfully!</strong> 
			  </div>
			  <%}if(mess.equals("fail")){ %>	
            	<div class="alert alert-warning alert-dismissible" style="margin-top: 20px; ">
			    	<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
			    	<strong>Routes were updated!</strong>
			  </div>
			  <%}%>
                <form class="form" action="ChangeProfileAd" method="POST">
                        	<div class="row">
                                <div class="col-sm-3 col-md-2 col-5">
                                    <label >Full Name</label>
                                </div>
                                <%if(pm!=null){ %>
                                <div class="col-md-8 col-6">
                                    <input name="name" class="form-control" type="text" value="<%=pm.getManagerName() %>" required>
                                </div>
                            </div>
                            <hr />

                            <div class="row">
                                <div class="col-sm-3 col-md-2 col-5">
                                    <label >Birth Date</label>
                                </div>
                                <div class="col-md-8 col-6">
                                        <input name="birthDate" class="form-control" type="date" value="<%=pm.getDateOfBirth()%>" required>
                                </div>
                            </div>
                            <hr />
                            
                            
                            <div class="row">
                                <div class="col-sm-3 col-md-2 col-5">
                                    <label >Gender</label>
                                </div>
                                <div class="col-md-8 col-6">
                                        <select name="gender" class="form-control">
                                        <%if(pm.getGender().equals("male")){
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
                                    <label >Phone number</label>
                                </div>
                                <div class="col-md-8 col-6">
                                    <input name="phoneNumber" type="tel" class="form-control" name="phone" pattern="[0]{1}[0-9]{9}" value="<%=pm.getPhoneNumber() %>" required>
                                </div>
                            </div>
                            <hr />
                            <%} %>
                            <input type="submit" class="btn btn-primary"  id="btnChange" value="Change" onclick="return confirm('Are you sure you want to Change?')" />  
                    </form>
                </div>
                    
            </div>
        </div>
    </div>

</div>

<script src="js/jquery/jquery.js"></script>
<script src="js/bootstrap/bootstrap.min.js"></script>


<script src="js/bootstrap/popper.min.js"></script>
   
</body>
</html> 