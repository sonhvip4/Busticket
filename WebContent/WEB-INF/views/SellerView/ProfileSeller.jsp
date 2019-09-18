<%@page import="busticket.model.User"%>
<%@page import="busticket.model.ProfileManager"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>Route Management</title>
	<link rel="shortcut icon" href="${pageContext.request.contextPath}/def/images/icon.ico">
	<meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="${pageContext.request.contextPath}/def/vendor/bootstrap/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <link href="${pageContext.request.contextPath}/def/vendor/jquery/jquery.dataTables.min.css" rel="stylesheet" id="bootstrap-css"> 
    <script src="${pageContext.request.contextPath}/def/vendor/jquery/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/def/vendor/jquery/jquery.js"></script>
    
    <script type="text/javascript" charset="utf8" src="${pageContext.request.contextPath}/def/vendor/jquery/jquery.dataTables.min.js"></script>
    <script src="${pageContext.request.contextPath}/def/js/awesome.js"></script>
     <script src="${pageContext.request.contextPath}/def/vendor/bootstrap/bootstrap.min.js"></script>
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
    
    <link rel="stylesheet" href="${pageContext.request.contextPath}/def/css/sellerstyle.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/def/css/edit-route.css"> 
</head>
<body>
<%ProfileManager pm = (ProfileManager) session.getAttribute("pm");
User user= (User) session.getAttribute("seller");
int mess=(Integer) request.getAttribute("mess");%>
	<div class="container-fluid">
           
        <div class="row">
            <div class="col-2 wrapper">
                <div class="sidebar nav flex-column nav-pills" id="v-pills-tab" role="tablist" aria-orientation="vertical">
                        <a href="SellerHome" style="text-decoration: none;"><h2>Seller</h2></a>
                        <a href="SellerHome" class="nav-link active">Profile Seller</a>
                        <a href="ManageRoute" class="nav-link ">Route management</a>
                        <a href="Logout" class="nav-link">Log out</a>
                </div>
            </div>
            
            <div style="padding-top: 90px;" class="col-9">
            <div >
            <%if(mess==1){ %>
	            <div class="alert alert-success alert-dismissible">
				    	<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
				    <strong>Update profile successfully!</strong> 
				  </div>
				  <%} %>
                <form class="form" action="ChangeProfileSeller" method="POST">
                        	<div class="row">
                                <div class="col-sm-3 col-md-2 col-5">
                                    <label >Full Name</label>
                                </div>
                                
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
                            <input type="submit" class="btn btn-primary"  id="btnChange" value="Change" onclick="return confirm('Are you sure you want to Change?')" />  
                    </form>
                </div>
                    
            </div>
       </div>
  	</div>
</body>
</html>