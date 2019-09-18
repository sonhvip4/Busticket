<%@page import="busticket.model.Route"%>
<%@page import="busticket.dto.SeatDetail"%>
<%@page import="java.util.ArrayList"%>
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
<link href="${pageContext.request.contextPath}/def/css/ChooseSeat.css" style="text/css" rel="stylesheet">
<link rel="shortcut icon" href="${pageContext.request.contextPath}/def/images/icon.ico">
</head>
<body>
<% ArrayList<SeatDetail> listSeatBooked = (ArrayList<SeatDetail>) session.getAttribute("lst_idSeat");
	int countbill =0;
	countbill=(Integer) session.getAttribute("count_Bill");
	int tickets= 5-countbill;
	Route r = (Route) session.getAttribute("choosedRoute");
%>
	<t:header></t:header>  
	
<div class="main" style="padding-top:19px;" >
        <div class="custom-nav">
            <a href="HomeCustomer">Step 1: Choose Location</a>
            <i class="fas fa-angle-double-right"></i>
            <a href="FindRoute">Step 2: Choose Route</a>
            <i class="fas fa-angle-double-right" ></i>
            <a href="AddRoute" style="color: #a84600;text-decoration: underline;">Step 3: Choose Seat</a>
            <i class="fas fa-angle-double-right"></i>
            <a class="btn disabled"  href="" >Step 4: Confirm Infomation</a>
        </div>
        <div style="padding:10px;"></div>
    	<div class="row choose">
            <div class="col-6">
                <div id="title"> Choose seats below:</div>
                <div id="holder"> 
                    <ul  id="place"></ul>    
                </div>
                <div id="seatDescription"> 
                    <ul>
                        <li>
                            <img src="${pageContext.request.contextPath}/def/images/available.png">
                            <div>Available Seat</div>
                        </li>
                        <li>
                            <img src="${pageContext.request.contextPath}/def/images/booked.png">
                            <div>Booked Seat</div>
                        </li>
                        <li>
                            <img src="${pageContext.request.contextPath}/def/images/selection.png">
                            <div>Selected Seat</div>
                        </li>
                    </ul>
                </div>
            </div>
            <div class="col-6">
                <div class="infobill">
                    <div id="title">Seat ID: 
                        <div id="showSeat"></div>
                    </div>
                    <div id="title">Price
                        <div id="price"></div>
                    </div>
                </div>
                <form class="form"  action="Confirm" method="POST">
                	<input id="s1" type="hidden" name="seat1">
        			<input id="s2" type="hidden" name="seat2">
        			<input id="s3" type="hidden" name="seat3">
        			<input id="s4" type="hidden" name="seat4">
        			<input id="s5" type="hidden" name="seat5">
                    <a href="FindRoute" class="btn btn-link" style=" text-decoration: underline; color: black;padding-right: 80px;">Back</a>
                    <button id="submit" class="btn btn-primary" type="submit" style="width: 200px" >Next</button>
                </form>
            </div>  
        </div>
    </div>
    <t:footer></t:footer>
	<script>
	$(document).ready(function() {
		$('#submit').attr('disabled','disabled');
		// setting
		var settings = {
		               rows: 4,
		               cols: 7,
		               rowCssPrefix: 'row',
		               colCssPrefix: 'col',
		               seatWidth: 60	,
		               seatHeight: 40,
		               seatCss: 'seat',
		               selectedSeatCss: 'selectedSeat',
		               selectingSeatCss: 'selectingSeat'
		           };

		//set layout
		var init = function (reservedSeat) {
		                var str = [], seatNo, className;
		                for (i = 0; i < settings.rows; i++) {
		                    for (j = 0; j < settings.cols; j++) {
		                        seatNo = (i + j * settings.rows + 1);
		                        className = settings.seatCss + ' ' + settings.rowCssPrefix + i.toString() + ' ' + settings.colCssPrefix + j.toString();
		                        if ($.isArray(reservedSeat) && $.inArray(seatNo, reservedSeat) != -1) {
		                            className += ' ' + settings.selectedSeatCss;
		                        }
		                        str.push('<li class="' + className + '"' +
		                                  'style="top:' + (i * settings.seatHeight).toString() + 'px;left:' + (j * settings.seatWidth).toString() + 'px">' +
		                                  '<a title="' + seatNo + '">' + seatNo + '</a>' +
		                                  '</li>');
		                    }
		                }
		                $('#place').html(str.join(''));
		            };
		            //case I: Show from starting
		            //init();
		 
		            //Case II: If already booked
		            var bookedSeats = [<%for(SeatDetail sd:listSeatBooked){
		            	out.print(sd.getNameSeat()+",");
		            }%>];
		            init(bookedSeats);  
		            var count=0;        

		//set selection
		var listTicket=[];
		$('.' + settings.seatCss).click(function () {
			if ($(this).hasClass(settings.selectedSeatCss)){
			    	alert('This seat is already reserved');
			}
			else{
				if(count<<%=tickets%>){
					if ($(this).hasClass(settings.selectingSeatCss)){
						count--;
					}else{
						count++;
					}
				    $(this).toggleClass(settings.selectingSeatCss);
				    var str = [], item;
				    $.each($('#place li.' + settings.selectingSeatCss + ' a'), function (index, value) {
				        item = $(this).attr('title');                   
				        str.push(item);                   
				    }); 
				    $('#showSeat').text(str.join(' , '));
				    var price=str.length+' x <%=r.getPrice()%> = '+(str.length*<%=r.getPrice()%>)+' VND';
				   	$("#price").text(price);
				   	listTicket=str;
				    
				}
				else{
					if ($(this).hasClass(settings.selectingSeatCss)){
						count--;
						$(this).toggleClass(settings.selectingSeatCss);
						var str = [], item;
				    	$.each($('#place li.' + settings.selectingSeatCss + ' a'), function (index, value) {
				        	item = $(this).attr('title');                   
				        	str.push(item);                   
				    	});
				    	$('#showSeat').text(str.join(' , '));
				    	var price=str.length+' x <%=r.getPrice()%> = '+(str.length*<%=r.getPrice()%>)+' VND';
				   		$("#price").text(price);
				   		listTicket=str;
					}
					else{
						alert("limited 5 seats");
					}
				}
			}
			var i;
			for(i=0;i<5;i++){
				$("#s"+(i+1)+"").val("");
			}
			for(i=0;i<listTicket.length;i++){
				$("#s"+(i+1)+"").val(listTicket[i]);
			}
			if(listTicket.length==0){
				$('#submit').attr('disabled','disabled');
			}else{
				$('#submit').removeAttr('disabled');
			}	
		});
		
		
	});

	</script>

</body>
</html>