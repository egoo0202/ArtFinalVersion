<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<c:url value='/frontstyle/css/processbar.css' />"> 
<style type="text/css">
.sofa{
	width: 60px;
	border-width: 3px;
	border-style: dashed;
	border-color: #FFFFFF;
}
.sofatick{
	width: 60px;
	border-width: 3px;
	border-style: dashed;
	border-color: #FFFFFF;
}
.sofa1 {
	width: 60px;
}
.sofademo {
	width: 60px;
}
.progressbar{
	width: 100px;
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
                      <div class="progress"><div class="progress-bar" style="width: 100%;"></div></div>
                      <a href="" class="bs-wizard-dot"></a>
                      <div class="bs-wizard-info text-center">區域/張數</div>
                    </div>
                    
                    <div class="col-lg-3 bs-wizard-step complet"><!-- complete -->
                      <div class="text-center bs-wizard-stepnum">Step 2</div>
                      <div class="progress"><div class="progress-bar" style="width: 50%;"></div></div>
                      <a href="#" class="bs-wizard-dot"></a>
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
                      <a href="" class="bs-wizard-dot"></a>
                      <div class="bs-wizard-info text-center">完成訂購</div>
                    </div>
                </div>
	
	<c:set var="seat" value="${requestScope.seat}" />
<form name="order" action="<c:url value='/04/shoppingcart.ctrl'/>" method="get">	
	<p id="ticketnum" style="display:none">${sessionScope.shoppingcart.TICKET_NUM}</p>
	<h1>座位表</h1>
	<h2>請勾選位置</h2>
	<p>請在灰色空位上點選您要的位置</p>
	<table>
	<tr>
		<td>座位資訊</td>
		<td id="showseat" ></td>
	</tr>
	<tr id="selectseattr" >
		<td>已選擇的座位資訊 </td>
		<td id="selectseat"></td>

	</tr>
	<tr>
		<td>已選擇座位數量</td>
		<td id="selectnum"></td>
		<input type="hidden" value="" id="seatnum" name="seatnum"/>
	</tr>
	</table>
<div class="row justify-content-center">
	<table class="justify-content-center">
		
		<tr>
			<td><img src="<c:url value='/images/04/sofaOff.png' />" alt="" title="" class="sofa${seat.A1}" id="A1" ></td>
			<td><img src="<c:url value='/images/04/sofaOff.png' />" alt="" title="" class="sofa${seat.A2}" id="A2"></td>
			<td><img src="<c:url value='/images/04/sofaOff.png' />" alt="" title="" class="sofa${seat.A3}" id="A3" ></td>
			<td><img src="<c:url value='/images/04/sofaOff.png' />" alt="" title="" class="sofa${seat.A4}" id="A4" ></td>
			<td><img src="<c:url value='/images/04/sofaOff.png' />" alt="" title="" class="sofa${seat.A5}" id="A5" ></td>
			<td><img src="<c:url value='/images/04/sofaOff.png' />" alt="" title="" class="sofa${seat.A6}" id="A6" ></td>
			<td><img src="<c:url value='/images/04/sofaOff.png' />" alt="" title="" class="sofa${seat.A7}" id="A7" ></td>
			<td><img src="<c:url value='/images/04/sofaOff.png' />" alt="" title="" class="sofa${seat.A8}" id="A8" ></td>
			<td><img src="<c:url value='/images/04/sofaOff.png' />" alt="" title="" class="sofa${seat.A9}" id="A9" ></td>
			<td><img src="<c:url value='/images/04/sofaOff.png' />" alt="" title="" class="sofa${seat.A10}" id="A10" ></td>

		</tr><br><br>
		<tr>
			<td><img src="<c:url value='/images/04/sofaOff.png' />" alt="" title="" class="sofa${seat.B1}" id="B1" ></td>
			<td><img src="<c:url value='/images/04/sofaOff.png' />" alt="" title="" class="sofa${seat.B2}" id="B2" ></td>
			<td><img src="<c:url value='/images/04/sofaOff.png' />" alt="" title="" class="sofa${seat.B3}" id="B3" ></td>
			<td><img src="<c:url value='/images/04/sofaOff.png' />" alt="" title="" class="sofa${seat.B4}" id="B4" ></td>
			<td><img src="<c:url value='/images/04/sofaOff.png' />" alt="" title="" class="sofa${seat.B5}" id="B5" ></td>
			<td><img src="<c:url value='/images/04/sofaOff.png' />" alt="" title="" class="sofa${seat.B6}" id="B6" ></td>
			<td><img src="<c:url value='/images/04/sofaOff.png' />" alt="" title="" class="sofa${seat.B7}" id="B7" ></td>
			<td><img src="<c:url value='/images/04/sofaOff.png' />" alt="" title="" class="sofa${seat.B8}" id="B8" ></td>
			<td><img src="<c:url value='/images/04/sofaOff.png' />" alt="" title="" class="sofa${seat.B9}" id="B9" ></td>
			<td><img src="<c:url value='/images/04/sofaOff.png' />" alt="" title="" class="sofa${seat.B10}" id="B10" ></td>

		</tr>
		<tr>
			<td><img src="<c:url value='/images/04/sofaOff.png' />" alt="" title="" class="sofa${seat.C1}" id="C1" ></td>
			<td><img src="<c:url value='/images/04/sofaOff.png' />" alt="" title="" class="sofa${seat.C2}" id="C2" ></td>
			<td><img src="<c:url value='/images/04/sofaOff.png' />" alt="" title="" class="sofa${seat.C3}" id="C3" ></td>
			<td><img src="<c:url value='/images/04/sofaOff.png' />" alt="" title="" class="sofa${seat.C4}" id="C4" ></td>
			<td><img src="<c:url value='/images/04/sofaOff.png' />" alt="" title="" class="sofa${seat.C5}" id="C5" ></td>
			<td><img src="<c:url value='/images/04/sofaOff.png' />" alt="" title="" class="sofa${seat.C6}" id="C6" ></td>
			<td><img src="<c:url value='/images/04/sofaOff.png' />" alt="" title="" class="sofa${seat.C7}" id="C7" ></td>
			<td><img src="<c:url value='/images/04/sofaOff.png' />" alt="" title="" class="sofa${seat.C8}" id="C8" ></td>
			<td><img src="<c:url value='/images/04/sofaOff.png' />" alt="" title="" class="sofa${seat.C9}" id="C9" ></td>
			<td><img src="<c:url value='/images/04/sofaOff.png' />" alt="" title="" class="sofa${seat.C10}" id="C10" ></td>

		</tr>
		<tr>
			<td><img src="<c:url value='/images/04/sofaOff.png' />" alt="" title="" class="sofa${seat.D1}" id="D1" ></td>
			<td><img src="<c:url value='/images/04/sofaOff.png' />" alt="" title="" class="sofa${seat.D2}" id="D2" ></td>
			<td><img src="<c:url value='/images/04/sofaOff.png' />" alt="" title="" class="sofa${seat.D3}" id="D3" ></td>
			<td><img src="<c:url value='/images/04/sofaOff.png' />" alt="" title="" class="sofa${seat.D4}" id="D4" ></td>
			<td><img src="<c:url value='/images/04/sofaOff.png' />" alt="" title="" class="sofa${seat.D5}" id="D5" ></td>
			<td><img src="<c:url value='/images/04/sofaOff.png' />" alt="" title="" class="sofa${seat.D6}" id="D6" ></td>
			<td><img src="<c:url value='/images/04/sofaOff.png' />" alt="" title="" class="sofa${seat.D7}" id="D7" ></td>
			<td><img src="<c:url value='/images/04/sofaOff.png' />" alt="" title="" class="sofa${seat.D8}" id="D8" ></td>
			<td><img src="<c:url value='/images/04/sofaOff.png' />" alt="" title="" class="sofa${seat.D9}" id="D9" ></td>
			<td><img src="<c:url value='/images/04/sofaOff.png' />" alt="" title="" class="sofa${seat.D10}" id="D10" ></td>

		</tr>
		
		<tr>
			<td><img src="<c:url value='/images/04/sofaOff.png' />" alt="" title="" class="sofa${seat.E1}" id="E1" ></td>
			<td><img src="<c:url value='/images/04/sofaOff.png' />" alt="" title="" class="sofa${seat.E2}" id="E2" ></td>
			<td><img src="<c:url value='/images/04/sofaOff.png' />" alt="" title="" class="sofa${seat.E3}" id="E3" ></td>
			<td><img src="<c:url value='/images/04/sofaOff.png' />" alt="" title="" class="sofa${seat.E4}" id="E4" ></td>
			<td><img src="<c:url value='/images/04/sofaOff.png' />" alt="" title="" class="sofa${seat.E5}" id="E5" ></td>
			<td><img src="<c:url value='/images/04/sofaOff.png' />" alt="" title="" class="sofa${seat.E6}" id="E6" ></td>
			<td><img src="<c:url value='/images/04/sofaOff.png' />" alt="" title="" class="sofa${seat.E7}" id="E7" ></td>
			<td><img src="<c:url value='/images/04/sofaOff.png' />" alt="" title="" class="sofa${seat.E8}" id="E8" ></td>
			<td><img src="<c:url value='/images/04/sofaOff.png' />" alt="" title="" class="sofa${seat.E9}" id="E9" ></td>
			<td><img src="<c:url value='/images/04/sofaOff.png' />" alt="" title="" class="sofa${seat.E10}" id="E10" ></td>

		</tr>
	</table>
	</div>
	<br>
	<br>
	<table>
		<tr>
			<td><img src="<c:url value='/images/04/sofaOff.png' />" alt="" title="" class="sofademo">空位</td>
			<td><img src="<c:url value='/images/04/sofa.png' />" alt="" title="" class="sofademo">已售出</td>
			<td><img src="<c:url value='/images/04/sofaTick.png' />" alt="" title=""class="sofademo">已加入購物車</td>
		</tr>
	</table>
	
	<br><br><input type="submit" id="submit" class="genric-btn primary-border radius" value="下一步" onclick="checknum()">
	</form>
</div>	
</div>	
	
<script src="https://code.jquery.com/jquery-3.5.1.js"
		integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc="
		crossorigin="anonymous"></script>
 	<script> 
 	//將已劃位的位置改為sofa.png
 	 $(".sofa1").attr("src", "<c:url value='/images/04/sofa.png' />");

 	    //點擊更換圖片 利用圖片src的value來判斷 		
 	    $(".sofa").mouseover(function() {
 	 	    //顯示選取框
			$(this).css("border-color", "#FFAC55");
			//顯示已選座位數量
			$("#showseat").text($(this).attr('id'));
 		}).mouseout(function() {
 			//隱藏選取框
 			$(this).css("border-color", "#FFFFFF")
 		}).click(function() {
 			//座位數量大於4無法選取(換圖片)
 			if ($(this).attr("src") == "<c:url value='/images/04/sofaOff.png' />" && $(".seat").length <parseInt($("#ticketnum").text())) {
 	 			//換成選取座位圖
 				$(this).attr("src", "<c:url value='/images/04/sofaTick.png' />")		
 				//新增td		
 				$("#selectseat").append("<td class='seat' id='td"+$(this).attr('id')+"'>"+$(this).attr('id')+"<td>");
 				$("#selectseat").append("<input type='hidden' id='hide"+$(this).attr('id')+"' name='seat' value='"+$(this).attr('id')+"'/>");				
				//顯示數量
 				$("#selectnum").text($(".seat").length);
//  				$("#seatnum").val($(".seat").length); 
 				var tickstring=$("#ticketnum").text();
 				var ticknum =parseInt(tickstring);			
 				if ($(".seat").length ==parseInt($("#ticketnum").text())) {
//  					alert("已經選擇"+$(".seat").length+"個座位");
 					swal("劃位完成","已經選擇"+$(".seat").length+"個座位","success");
				}
 			} else {
 	 			//換回空位
 	 			var id ="td"+$(this).attr('id');
 	 			var id2 ="hide"+$(this).attr('id');
 				$(this).attr("src", "<c:url value='/images/04/sofaOff.png' />")
//   				$("td").remove("#"+id);
 				$("#"+id).remove();
 				$("#"+id2).remove();
 				$("#selectnum").text($(".seat").length);
//  				$("#seatnum").val($(".seat").length); 
 			}
 		});    	


 	   $("#submit").click(function(){
 		  	var selectnum = $(".seat").length;
			var ticketnum = parseInt($("#ticketnum").text());
			var notselect=ticketnum-selectnum;
			if (selectnum < ticketnum ) {
// 				alert("尚有"+notselect+"個座位未劃位");
 				swal("劃位錯誤","尚有"+notselect+"個座位未劃位","error");
 	           return false;
 	        }
 	  }); 


		</script> 




</body>
</html>