<%@page import="busticket.service.ProfileCustomerService"%>
<%@page import="busticket.service.UserService"%>
<%@page import="busticket.model.Ticket"%>
<%@page import="java.util.ArrayList"%>
<%@page import="busticket.model.Session"%>
<%@page import="busticket.model.Route"%>
<%@page import="busticket.model.Car"%>
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
    
    <link rel="stylesheet" href="${pageContext.request.contextPath}/def/css/sellerstyle.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/def/css/edit-route.css"> 
</head>
<%  
	ArrayList<Ticket> listTicket = (ArrayList<Ticket>) session.getAttribute("listTicket");
	Session thisSession = (Session) session.getAttribute("thisSession");
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
            
            <div class="col-10">
                <nav class="nav-menu" style="padding-bottom:30px">  
                     <form action="ManageRoute" method="get" style="float:left;"><button type="submit" class="btn btn-primary back-route-management"> <i class="fas fa-angle-left"></i> Back</button></form>  
                     <!-- <input class="form-control" id="myInput" type="text" placeholder="Search.." style="float: right; width:40%; ">   -->
                     <form action="SellerBooking" method="get" style="float:right;"><input type='hidden' value='<%=thisSession.getId() %>' name='getIdBooking'/><button type="submit" class="btn btn-primary booking-ticket"> <i class="fas fa-plus"></i> Booking ticket</button></form>                  
                 </nav>

                <div class="route" style="margin-top:10	0px">
                    <div class="route-date">
                        <div style="float: left;">
                            <i class="fas fa-clock"></i>
                        </div>                            
                        <div class="time" >
                            <div class="label-time">Time: </div>
                            <div> <%=thisSession.getRouteObject().getTimeStarting() %> </div>
                            <div class="fas fa-arrow-right"></div>
                            <div><%=thisSession.getRouteObject().getTimeFinishing() %></div>
                            <div class="date"><b>Date:</b>  <%=thisSession.getDepartDate() %></div>
                        </div>  
                    </div>

                    <div class="route-point">
                        <div class=" fas fa-map-marked-alt" id="icon"></div>
                        <div class="label-route">Route: </div>
                        <div><%=thisSession.getRouteObject().getStartingPoint() %></div>
                        <div class="fas fa-arrow-right"></div>
                        <div><%=thisSession.getRouteObject().getDestination() %></div>
                    </div>

                    <div class="route-car">
                        <div class="fas fa-bus" id="icon"></div>
                        <div class="car">
                            <div><b>Car ID:</b> <%=thisSession.getCarObject().getId() %> </div>
                            <div><b>Car Name:</b> <%=thisSession.getCarObject().getCarName() %></div>
                        </div>
                    </div>

                    <div class="route-booked-ticket" style="float:left">
                        <i class="fas fa-ticket-alt"></i>

                        <span><b>Booked Tickets: </b></span>
                        <span><%=thisSession.getTicketNumber() %> tickets</span>
                    </div>
                </div> 
                
	                <table id="data-route">
	                </table>
                
                </div>
            </div>
        </div>
    </div>
    <!--
    
     UserService.getUserById(x.getBillObject().getCustomerObject().getIdUser()).getEmail()
     
     -->
    <script>
        var dataSet=[
        <%for (Ticket x: listTicket){ %>
            ["<%=x.getSeatObject().getSeatName()%>",
            "<%=x.getBillObject().getIdCustomer()%>",
            "<%=x.getBillObject().getCustomerObject().getCustomerName() %>",
            "<%=x.getBillObject().getCustomerObject().getPhoneNumber() %>",
            "<%=ProfileCustomerService.getEmailById(x.getBillObject().getCustomerObject().getId())%>",
            "<%=x.getBillObject().getId()  %>",
            "<%=x.getBillObject().getBookingdate()%>",
            "<form method='post' action='EditRoute'><input type='hidden' name='delTicket' value='"+<%=x.getId()%>+"-"+<%=thisSession.getId()%>+"'/><button class='btn btn-info'><center><i class='fas fa-times'></center></i></button></form>"],
        <% } %>   
        ];

        $(document).ready( function () {
            $('#data-route').DataTable({
                data: dataSet,
                columns: [
                    { title: "Seat", width: "2%"},
                    { title: "Cus. ID", width: "7%"},
                    { title: "Cus. Name", width: "23%"},
                    { title: "Cus. Phone Number", width:"13%"},
                    { title: "Cus. Email", width: "25%"},
                    { title: "Bill Code", width:"10%"},
                    { title: "Booked Date", width:"12%"},
                    { defaultContent: "" }
        ]
            });
        });
  
    </script>
 <!--    <script>
    	var request;
    	function deleteTicket(){
    		var idticket = $(this).val();
    		alert(idticket);
    		/*var url="EditRoute-ajax.jsp?id="+idticket;
    		if (window.XMLHttpRequest){
    			request = new XMLHttpRequest();	
    		} else if (window.ActiveXObject){
    			request = new ACtiveXObject("Microsoft.XMLHTTP");
    		}
    		try {
    			request.onreadystatechange = getInfo;
                request.open("GET", url, true);
                request.send();
            } catch (e) {
                alert("Unable to connect to server");
            }*/
            
            name='deleteTicket' value='"+<=x.getId()%>+"' onClick='deleteTicket()'
    	}
    </script> -->
</body>
</html>