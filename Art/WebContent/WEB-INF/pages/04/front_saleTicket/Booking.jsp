<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="zh-tw">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>節目內容</title>
<link rel="stylesheet" href="<c:url value='/frontstyle/css/processbar.css' />"> 
<style>
td {

}

#ticketnum {
	width: 50px;
}

.title {
	width: 200px;
}

.total1 {
	width: 120px;
}

.total2 {
	width: 120px;
}

.totalprice {
	width: 120px;
}

.price2 {
	width: 200px;
}
.genric-btn success medium{
width: 100px;
}
.num{
width: 260px;
}
.price{
width: 100px;
}

body {
	color: black;
	font-size:18px;
}


</style>

</head>

<body >

	<!-- start banner Area -->
			<section class="banner-area relative" id="home">	
				<div class="overlay overlay-bg"></div>
				<div class="container">
					<div class="row d-flex align-items-center justify-content-center">
						<div class="about-content col-lg-12">
							<h1 class="text-white">
								AAART Ticket
							</h1>	
							<p class="text-white link-nav"><a href="<c:url value='/index.html' />">Home </a>  <span class="lnr lnr-arrow-right"></span>  <a href=""> Search</a><span class="lnr lnr-arrow-right"></span><a href=""> Order</a></p>
						</div>											
					</div>
				</div>
			</section>
	<!-- End banner Area -->
	

 
<div class="container">

<div class="row bs-wizard" style="border-bottom:0;">
                    
                    <div class="col-lg-3 bs-wizard-step start"><!-- start -->
                      <div class="text-center bs-wizard-stepnum">Step 1</div>
                      <div class="progress"><div class="progress-bar" style="width:0%;"></div></div>
                      <a href="<c:url value='/04/booking.ctrl'/>" class="bs-wizard-dot"></a>
                      <div class="bs-wizard-info text-center">區域/張數</div>
                    </div>
                    
                    <div class="col-lg-3 bs-wizard-step complet"><!-- complete -->
                      <div class="text-center bs-wizard-stepnum">Step 2</div>
                      <div class="progress"><div class="progress-bar" ></div></div>
                      <a href="" class="bs-wizard-dot"></a>
                      <div class="bs-wizard-info text-center">劃位</div>
                    </div>
                    
                    <div class="col-lg-3 bs-wizard-step active"><!-- complete -->
                      <div class="text-center bs-wizard-stepnum">Step 3</div>
                      <div class="progress"><div class="progress-bar"></div></div>
                      <a href="" class="bs-wizard-dot"></a>
                      <div class="bs-wizard-info text-center">購票確認</div>
                    </div>
                    
                    <div class="col-lg-3 bs-wizard-step disabled"><!-- active -->
                      <div class="text-center bs-wizard-stepnum">Step 4</div>
                      <div class="progress"><div class="progress-bar"></div></div>
                      <a href="#" class="bs-wizard-dot"></a>
                      <div class="bs-wizard-info text-center">完成訂購</div>
                    </div>
                </div>

<div class="d-flex justify-content-center">


	<form id="order" name="order" action="<c:url value='/04/seatSearch.ctrl'/>" method="get">

		<!-- 用param.取，相當於request.getParameter-->
<%-- 		<c:set var="title" value="${param.title}" /> --%>
<%-- 		<c:set var="description" value="${param.description}" /> --%>
<%-- 	<c:set var="actid" value="${param.actid}" scope="session"/> --%>
		
		<H1>節目詳細</H1>
		節目名稱:
		<P>${sessionScope.title}</P>
		節目簡介:
		<P>${sessionScope.description}</P><br><br>
		
		<H2>訂購票券</H2>

		<table class="table table-bordered">
		<tr> 
				<td>節目名稱</td>
				<td>票種</td>
				<td>座位</td>
				<td class="price">票價</td>
				<td class="num">數量</td>
				<td class=>剩餘票券</td>

			</tr>
			<tr> 
				<td class="title">${sessionScope.title}</td>
				<td>
<!-- 				<div class="default-select" id="default-select" > -->
				
				<div class="row d-flex justify-content-center" style="text-align: center;">
				<div class="default-select mb-10" id="default-select">
		
					<select id="ticketcategry" name="ticketcategry">
					<option value="全票">全票</option>
					<option value="半票">半票</option>						
					</select>
				</div>
				</div>
						
				</td>
				<td>
					<div class="row d-flex justify-content-center" style="text-align: center;">
					<div class="default-select mb-10" id="default-select">
		
						<select id="seattype" name="seattype">
						<option value="自行劃位">自行劃位</option>
						<option value="電腦選票">電腦選票</option>						
					</select>
					</div>
				</td>
				<td id="price">NT$2000</td>
				<td >	
				<div class="form-inline">
				<input type="button" value="-" name="minus" class="genric-btn success medium" id="minus" "> 					
				<input type="text" name="ticketnum" id="ticketnum" class="single-input"value="" readonly="readonly"> 
				<input type="button" value="+" name="plus" class="genric-btn success medium" id="plus">
				</div>			
				
				</td>
				<td id="totalnum" >${sessionScope.seatBean.SEATNUM}</td>
			</tr>

		</table>

<!-- 		<div class="g-recaptcha" data-sitekey="6Lc94vEZAAAAAMs-vGxyGUXuXB3jucfpLckJTfsC"></div> -->

		
		<br> <input type="submit" value="確認數量" name="submit"
			class="genric-btn primary-border radius" id="submit">
		
	</form>
	
	
	</div>
	
	<script src="https://www.google.com/recaptcha/api.js" async defer></script>
	<script src="https://code.jquery.com/jquery-3.5.1.js"
		integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc="
		crossorigin="anonymous"></script>
 <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
 	 
	<script>
	$(document).ready(		
			function() {
				//選取票別切換票價
				$("#ticketcategry").change(function() {
					if($("#ticketcategry").val()=== "全票"){
					$("#price").text("NT$2000")
					}else{
					$("#price").text("NT$1000")
					}					 
				});
				//票券數量
				var count = 0;
				$("#ticketnum").val(count);
				$("#plus").click(
						function() {
							if (count < 4) {
								count++;
							} else if (count = 4) {
								count = 4;
								swal("最大購買數量","最多訂購4張","warning");
							}
							$("#ticketnum").val(count);
						})
				$("#minus").click(
						function() {
							if (count > 0) {
								count--;
							} else if (count = 0) {
								count2 = 0;
							}
							$("#ticketnum").val(count);
							
						})
						
			$("#submit").click(function(){
	  			var selectnum = parseInt($("#ticketnum").val());
	  			var totalnum =  parseInt($("#totalnum").text());
	  			console.log("selectnum: "+selectnum)
				if (selectnum == 0) {

					swal("數量錯誤","請選擇購買數量","warning");
        			return false;
    		 	}else if (totalnum < selectnum) {
    		 		swal("剩餘票券不足，請重新選擇數量","warning");
        			return false;
				}
			}); 
				$("#seattype").change(function() {
					if($("#seattype").val()=== "自行劃位"){
					$("#order").attr("action", "<c:url value='/04/seatSearch.ctrl'/>")	
					}else{
					$("#order").attr("action", "<c:url value='/04/radomSeat.ctrl'/>")
					}					 
				});

		})
		
		
		
		
	</script>


</body>





</html>