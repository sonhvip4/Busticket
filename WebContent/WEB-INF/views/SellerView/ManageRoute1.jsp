<%@page import="busticket.model.Session"%>
<%@page import="java.util.ArrayList"%>
<%@page import="busticket.model.Car"%>
<%@page import="busticket.model.Route"%>
<%@page import="busticket.model.Province"%>
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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/def/css/route-management.css"> 
    <link rel="stylesheet" href="${pageContext.request.contextPath}/def/css/sellerstyle.css">
</head>
<!-- 
	ArrayList<Session> listSession= (ArrayList<Session>)  session.getAttribute("listSession");
	ArrayList<Province> listStartingPoint = (ArrayList<Province>) session.getAttribute("listStartingPoint");
	ArrayList<Province> listDestination = (ArrayList<Province>) session.getAttribute("listDestination");
	ArrayList<String> listStartingTime = (ArrayList<String>) session.getAttribute("listStartingTime");
-->
<%
	ArrayList<Session> listSession = (ArrayList<Session>) session.getAttribute("listSession");
	ArrayList<Province> listStartingPoint = (ArrayList<Province>) session.getAttribute("listStartingPoint");
	ArrayList<Province> listDestination = (ArrayList<Province>) session.getAttribute("listDestination");
	ArrayList<String> listStartingTime = (ArrayList<String>) session.getAttribute("listStartingTime");
%>
<body>
	<div class="container-fluid">
        <div class="row">
            <div class="col-2 wrapper">
                <div class="sidebar nav flex-column nav-pills" id="v-pills-tab" role="tablist" aria-orientation="vertical">
                        <a href="SellerHome" style="text-decoration: none;"><h2>Seller</h2></a>
                        <a href="SellerHome" class="nav-link ">Profile Seller</a>
                        <a href="ManageRoute" class="nav-link active">Route management</a>
                        <a href="Logout" class="nav-link">Log out</a>
                </div>
            </div>
            
            <div class="col-10" style="padding-top:50px;">
            <form action="FilterRoute" method="POST" class="form form-inline" style="padding-bottom:40px">
            		<div style="width:956.66px; margin:auto;">
		            	<select class="mdb-select md-form form-control" name="startingPoint">
		            		<option value="" disabled selected>Choose Starting Point</option>
		            		<%for (Province x : listStartingPoint){ %>
								<option value="<%=x.getName()%>"><%=x.getName() %></option>
							<%} %>
						</select>
						<select class="mdb-select md-form form-control" style="margin-left: 20px" name="destination">
		            		<option value="" disabled selected>Choose Destination</option>
							<%for (Province x : listDestination){ %>
								<option value="<%=x.getName()%>"><%=x.getName() %></option>
							<%} %>
						</select>
						<input type='date' name="departDate" class="custom-date md-control form-control" style="margin-left: 20px"/>
						<select class="mdb-select md-form form-control" style="margin-left: 20px" name="startingTime">
		            		<option value="" disabled selected>Choose Starting Time	</option>
							<%for (String x : listStartingTime){ %>
								<option value="<%=x%>"><%=x%></option>
							<%} %>
						</select>
						<input type="submit" class="btn btn-primary" value="Filter" style="margin-left: 20px"/>
            	</div>
		            
            	
            </form>
            
                <table id="data-route">
                </table>

            </div>
        </div>
    </div>
	
    <script>
        var dataSet = [
		<% for (Session x : listSession){%>
				["<%=x.getId()%>",
				 "<%=x.getCarObject().getCarName()%>", 
				 "<%=x.getRouteObject().getStartingPoint()%>",
				 "<%=x.getRouteObject().getDestination()%>",
				 "<%=x.getDepartDate()%>",
				 "<%=x.getRouteObject().getTimeStarting()%>",
				 "<%=x.getRouteObject().getTimeFinishing()%>",
				 "<%=x.getTicketNumber()%>",
				 "<form action='EditRoute' method='post'><input type='hidden' name='getSession' value='" + <%=x.getId()%> + "'/><button class='btn btn-info' style='float: right;' ><i class='fas fa-edit'></i></button></form>"],
		<%	}
		%>];
        $(document).ready( function () {
            $('#data-route').DataTable({
                data: dataSet,
                columns: [
                    { title: "Session ID", width: "10%" },
                    { title: "Car Name", width: "9%"  },
                    { title: "Starting Point", width: "13%"  },
                    { title: "Destination", width: "13%"  },
                    { title: "Depart Date", width: "11%"  },
                    { title: "Starting Time", width: "11%"  },
                    { title: "Finishing Time", width: "11%"  },
                    { title: "Booked Tickets", width: "12%"  },
                    { defaultContent: "" }
        		]	
            });
        });
  
    </script>
    
    <script>
    $(document).ready(function() {
    	$('.mdb-select').materialSelect();
    	});
    </script>
</body>
</html>