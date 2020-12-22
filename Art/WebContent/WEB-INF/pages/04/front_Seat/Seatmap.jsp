<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="<c:url value='/frontstyle/css/processbar.css' />">

<style>
.area {
    background:	#CC0000;
    display:block;
    height:195px;
    opacity:0;
    position:absolute;
    width:380px;
}
#area1 {
    left:125px;
    Top:110px;
}
#area2 {
    left:125px;
    Top:300px;
}
#area3 {
	background:	#CC0000;
    display:block;
    height:675px;
    opacity:0;
    position:absolute;
    width:600px;
	clip-path: polygon(6% 17%, 19% 17%, 19% 73%, 81% 73%, 81% 17%, 94% 17%, 94% 93%, 6% 93%);
}
#area1:hover, #area2:hover ,#area3:hover{
    opacity:0.4;
}

tr:hover { 
background-color:#CC0000;
 opacity:0.4;
 color:white;
 }

.color{
}
.ticketarea{
width:20px;
}
.tickettype{
width:100px;
}
.seat{
}
.price{
}
.seatnum{
}
body {
	color: black;
	font-size:18px;
}



</style>

</head>
<body>


	<!-- start banner Area -->
	<section class="banner-area relative" id="home">
		<div class="overlay overlay-bg"></div>
		<div class="container">
			<div class="row d-flex align-items-center justify-content-center">
				<div class="about-content col-lg-12">
					<h1 class="text-white">AAART Ticket</h1>
					<p class="text-white link-nav">
						<a href="<c:url value='/index.html' />">Home </a> <span
							class="lnr lnr-arrow-right"></span> <a href=""> Search</a><span
							class="lnr lnr-arrow-right"></span><a href=""> Order</a>
					</p>
				</div>
			</div>
		</div>
	</section>
	<!-- End banner Area -->

	<div class="container">

		<div class="row bs-wizard" style="border-bottom: 0;">

			<div class="col-lg-3 bs-wizard-step start">
				<!-- start -->
				<div class="text-center bs-wizard-stepnum">Step 1</div>
				<div class="progress">
					<div class="progress-bar" style="width: 0%;"></div>
				</div>
				<a href="" class="bs-wizard-dot"></a>
				<div class="bs-wizard-info text-center">區域/張數</div>
			</div>

			<div class="col-lg-3 bs-wizard-step complet">
				<!-- complete -->
				<div class="text-center bs-wizard-stepnum">Step 2</div>
				<div class="progress">
					<div class="progress-bar" style="width: 0%;"></div>
				</div>
				<a href="#" class="bs-wizard-dot"></a>
				<div class="bs-wizard-info text-center">劃位</div>
			</div>

			<div class="col-lg-3 bs-wizard-step active">
				<!-- complete -->
				<div class="text-center bs-wizard-stepnum">Step 3</div>
				<div class="progress">
					<div class="progress-bar"></div>
				</div>
				<a href="" class="bs-wizard-dot"></a>
				<div class="bs-wizard-info text-center">購票確認</div>
			</div>

			<div class="col-lg-3 bs-wizard-step disabled">
				<!-- active -->
				<div class="text-center bs-wizard-stepnum">Step 4</div>
				<div class="progress">
					<div class="progress-bar"></div>
				</div>
				<a href="" class="bs-wizard-dot"></a>
				<div class="bs-wizard-info text-center">完成訂購</div>
			</div>
		</div>


		<c:set var="seat" value="${requestScope.seat}" />
		<form name="order" action="<c:url value='/04/booking.ctrl'/>"
			method="get">
			<h1>票區選擇</h1>
			<h2>選擇票區</h2>
			<p>請在灰色空位上點選您要的票區</p>

			<div class="row">
				<div class="col-sm-5">
					<table class="table table-bordered">
						<tr>
							<td class="color">顏色</td>
							<td class="ticketarea">票區</td>
							<td class="tickettype">票種</td>
							<td class="seat">座位</td>
							<td class="price">票價</td>
							<td class="seatnum">剩餘票券</td>

						</tr>
						<tr class="trA">
							<td style="background-color: rgb(156, 194, 229)"></td>
							<td>前台區</td>
							<td>全票<br>半票</td>
							<td>50</td>
							<td >$2000<br>$1000</td>
							<td id="seatnum1">0</td>

						</tr>
						<tr class="trB">
							<td style="background-color: rgb(48, 84, 150)"></td>
							<td>藍區</td>
							<td>全票<br>半票</td>
							<td>50</td>
							<td >$800<br>$400</td>
							<td id="seatnum2">0</td>

						</tr>
						<tr class="trC">
							<td style="background-color: rgb(255, 192, 0)"></td>
							<td>黃區</td>
							<td>全票<br>半票</td>
							<td>66</td>
							<td >$400<br>$400</td>
							<td id="seatnum3">0</td>
						</tr>
					</table>

		<p id="actid"  style="display: none;">${sessionScope.actid}<p>					
				</div>
				<div class="col-sm-7">

					<a id="area1" class="area" href="<c:url value='/04/booking.ctrl'/>"></a>
       				<a id="area2" class="area" href="#"></a>
       				<a id="area3" class="area" href="#"></a>
					<img src="<c:url value='/images/04/seatmap.jpg' />" border="0" usemap="#Map" alt="座位表" id="seatmap" class="map"   /> 
				</div>
		</div>



		</body>
<script type="text/javascript">
//選取變色
$("#area1").mouseenter(function(){
	  $(".trA").css({"background-color":"#CC0000","opacity":"0.4","color":"white"});
	}).mouseleave(function(){
	  $(".trA").css({"background-color":"","opacity":"","color":"black"});
	});
$("#area2").mouseenter(function(){
	  $(".trB").css({"background-color":"#CC0000","opacity":"0.4","color":"white"});
	}).mouseleave(function(){
	  $(".trB").css({"background-color":"","opacity":"","color":"black"});
	});
$("#area3").mouseenter(function(){
	  $(".trC").css({"background-color":"#CC0000","opacity":"0.4","color":"white"});
	}).mouseleave(function(){
	  $(".trC").css({"background-color":"","opacity":"","color":"black"});
	});
	</script>
	
<script>	

$(document).ready(function(){
	var actid =$("#actid").text();
   	 $.ajax({
			type: "get",
			url: "/Art/04/seatnumSearch.ctrl",
			contentType: "application/json",
			dataType: "json",
			data: {"actno":actid},
			cache: false,
			success: function(json) {
		    	$("#seatnum1").text(json.seatnum)
		    	$("#seatnum2").text(json.seatnum2)
		    	$("#seatnum3").text(json.seatnum3)			
			},
			error:  function() {
				alert("failure");
			}
			});	

	});

	
</script>
</html>