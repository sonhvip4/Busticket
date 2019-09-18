<%@page import="busticket.model.User"%>
<%@page import="java.util.ArrayList"%>
<%@page import="busticket.model.ProfileManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <link href="${pageContext.request.contextPath}/def/vendor/bootstrap/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="${pageContext.request.contextPath}/def/vendor/bootstrap/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/def/vendor/jquery/jquery.js"></script>
    <script src="${pageContext.request.contextPath}/def/js/jquery.dataTables.min.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/def/css/jquery.dataTables.min.css">
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
	ArrayList<User> listUser= (ArrayList<User>) session.getAttribute("listUser");
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
            <div >
                
                <div >
                        <div style="padding-top: 50px;" class="nav_menu">
                                <nav>
                                    
                                      
                                    <a href="AdminCreateUser"><button class="btn btn-primary" >Create new user</button></a>
                                     	
                                  
                                  <ul class="nav navbar-nav navbar-right">
                                    <li class="">
                                     
                                    </li>
                    
                                    
                                  </ul>
                                </nav>
                              </div>
                             <table id="data-user" ></table>
                    </div>
                    
            </div>
        </div>
    </div>
	
</div>

<script>
        var dataSet=[<%
                     String [] arr={"Admin","Seller","Customer"};
        	for(User user:listUser){
        %>
          ["<%=user.getId()%>","<%=user.getUserName()%>","<%=user.getEmail()%>","yes","<%=arr[user.getIdRoleUser()-1]%>","<form action=\"AdminEdit\" method=\"POST\"><input type=\"hidden\" name=\"id\" value=\"<%=user.getId()%>\"><td><button type=\"submit\" class=\"btn btn-info\" style=\"float: right;\">Edit</button></td></form>"],
         <%}%>
        ];

        $(document).ready( function () {
            $('#data-user').DataTable({
                data: dataSet,
                columns: [
                    { title:"Id", width: "7%" },
                    { title: "User Name", width: "20%"  },
                    { title: "Email", width: "30%"  },
                    { title: "Active", width: "7%"  },
                    { title: "Rolename", width: "8%"  },
                    { defaultContent: "" }
        ]
            });
        });

    </script>
<script src="js/jquery/jquery.js"></script>
<script src="js/bootstrap/bootstrap.min.js"></script>
<script src="js/bootstrap/popper.min.js"></script>
   
</body>
</html> 