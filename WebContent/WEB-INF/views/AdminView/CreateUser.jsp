<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
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
<%
int mess= (Integer) session.getAttribute("mess");
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
		<%if(mess!=0){
			if(mess==1){
			%>
            <div>
            	<div class="alert alert-success alert-dismissible" style="margin-top: 20px;">
			    	<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
			    <strong>Create user successfully!</strong> 
			  </div>
			  <%}if(mess==-1){ %>	
            	<div class="alert alert-danger alert-dismissible" style="margin-top: 20px; ">
			    	<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
			    	<strong>UserName is already exist</strong> Please try again!
			  </div>
			  <%}
			  }%>
                    <form class="form" action="CreateUser" method="POST">
                            <div style="padding-top: 40px" class="row">
                                    <div class="col-sm-3 col-md-2 col-5">
                                        <label >Role</label>
                                    </div>
                                    <div class="col-md-8 col-6">
                                        <select name="role" class="form-control">
                                        	<option value="1">Admin</option>
                                            <option value="2">Seller</option>
                                            <option value="3">Customer</option>
                                        </select>
                                    </div>
                                </div>
                                <hr />
                            <div class="row">
                                    <div class="col-sm-3 col-md-2 col-5">
                                        <label >User Name</label>
                                    </div>
                                    <div class="col-md-8 col-6">
                                        <input name="userName" class="form-control" type="text"  required>
                                    </div>
                                </div>
                                <hr />
                                
                                <div class="row">
                                        <div class="col-sm-3 col-md-2 col-5">
                                            <label >Password</label>
                                        </div>
                                        <div class="col-md-8 col-6">
                                                <input name="password" class="form-control" type="password" pattern="[a-zA-Z0-9]{6,}" title="Six or more characters and don't have special characters!"  required>
                                        </div>
                                    </div>
                                    

                                <hr />
                                <div class="row">
								<div class="col-sm-3 col-md-2 col-5">
	                                    <label >Full Name</label>
	                             </div>
	                             <div class="col-md-8 col-6">
	                                    <input name="name" class="form-control" type="text" required>
	                             </div>
	                            </div>
	                            <hr />
                                <div class="row">
                                    <div class="col-sm-3 col-md-2 col-5">
                                        <label >Birth Date</label>
                                    </div>
                                    <div class="col-md-8 col-6">
                                            <input name="birthDate" class="form-control" type="date"  required>
                                    </div>
                                </div>
                                <hr />
                                
                                
                                <div class="row">
                                    <div class="col-sm-3 col-md-2 col-5">
                                        <label >Gender</label>
                                    </div>
                                    <div class="col-md-8 col-6">
                                        <select name="gender" class="form-control">
                                            <option value="male" selected="checked">Male</option>
                                            <option value="female">Female</option>
                                        </select>
                                    </div>
                                </div>
                                <hr />
                                <div class="row">
                                    <div class="col-sm-3 col-md-2 col-5">
                                        <label >Email</label>
                                    </div>
                                    <div class="col-md-8 col-6">
                                        <input name="email" type="email" class="form-control" aria-describedby="emailHelp" required>
                                    </div>
                                </div>
                                <hr />
                                <div class="row">
                                    <div class="col-sm-3 col-md-2 col-5">
                                        <label >Phone number</label>
                                    </div>
                                    <div class="col-md-8 col-6">
                                        <input name="phonenumber" type="tel" class="form-control" name="phone" pattern="[0]{1}[0-9]{9}" title="Phonenumber has 10 numbers!" required>
                                    </div>
                                </div>
                                <hr />
                             
                                <input type="submit" class="btn btn-warning" value="Create" onclick="return confirm('Are you sure you want to create new user?')" />
                        </form>
            </div>
        </div>
    </div>

</div>


</body>
</html> 
