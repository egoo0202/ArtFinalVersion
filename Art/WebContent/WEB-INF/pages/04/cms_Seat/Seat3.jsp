<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style type="text/css">
.sofa{
	width: 40px;
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
	width: 40px;
	border-width: 3px;
	border-style: dashed;
	border-color: #FFFFFF;
}
.sofademo {
	width: 60px;
}
.progressbar{
	width: 100px;
}

.area {
    background:	#CC0000;
    display:block;
    height:95px;
    opacity:0;
    position:absolute;
    width:187px;
}
#area1 {
    height:313px;
    opacity:0;
    position:absolute;
    width:300px;
    clip-path: inset(17% 19% 52% 19%);
}
#area2 {
    height:313px;
    opacity:0;
    position:absolute;
    width:300px;
    clip-path: inset(49% 19% 20% 19%);
    
}
#area3 {
	background:	#CC0000;
    display:block;
    height:313px;
    opacity:0;
    position:absolute;
    width:300px;
	clip-path: polygon(6% 16%, 19% 16%, 19% 79%, 80% 80%, 81% 16%, 93% 16%, 93% 97%, 7% 97%);
}
#area1:hover, #area2:hover ,#area3:hover{
    opacity:0.4;
}


</style>
</head>
<body>


	
	

<div class="container">

<!-- <div class="row justify-content-center"> -->


<div class="row">
 <div class="col-8">

<c:set var="seat" value="${requestScope.seat}" />
<form name="order" action="<c:url value='/04/Cms/seat3Update.ctrl'/>" method="POST" id="update">	
	<p id="ticketnum" style="display:none">${sessionScope.shoppingcart.TICKET_NUM}</p>
	<br>
	<h1>黃區座位表</h1>

	<input type="hidden" value="${seat.actno}" id="actno" name="actno"/>

					<table>
						<tr>
							<td>座位資訊</td>
							<td id="showseat"></td>
						</tr>
						<tr>
							<td>開放購買座位數量</td>
							<td id="selectnum"></td>
							<input type="hidden" id="seatnum" name="seatnum" value="" />
						</tr>

					</table>

					<div id="seat">
						<input type="hidden" id="hideK1" name="K1" value="${seat.K1}" />
						<input type="hidden" id="hideK2" name="K2" value="${seat.K2}" />
						<input type="hidden" id="hideK3" name="K3" value="${seat.K3}" />
						<input type="hidden" id="hideK4" name="K4" value="${seat.K4}" />
						<input type="hidden" id="hideK5" name="K5" value="${seat.K5}" />
						<input type="hidden" id="hideK6" name="K6" value="${seat.K6}" />
						<input type="hidden" id="hideK7" name="K7" value="${seat.K7}" />
						<input type="hidden" id="hideK8" name="K8" value="${seat.K8}" />
						<input type="hidden" id="hideK9" name="K9" value="${seat.K9}" />


						<input type="hidden" id="hideL1" name="L1" value="${seat.L1}" />
						<input type="hidden" id="hideL2" name="L2" value="${seat.L2}" />
						<input type="hidden" id="hideL3" name="L3" value="${seat.L3}" />
						<input type="hidden" id="hideL4" name="L4" value="${seat.L4}" />
						<input type="hidden" id="hideL5" name="L5" value="${seat.L5}" />
						<input type="hidden" id="hideL6" name="L6" value="${seat.L6}" />
						<input type="hidden" id="hideL7" name="L7" value="${seat.L7}" />
						<input type="hidden" id="hideL8" name="L8" value="${seat.L8}" />
						<input type="hidden" id="hideL9" name="L9" value="${seat.L9}" />
						<input type="hidden" id="hideL10" name="L10" value="${seat.L10}" />
						<input type="hidden" id="hideL10" name="L10" value="${seat.L10}" />


						<input type="hidden" id="hideM1" name="M1" value="${seat.M1}" />
						<input type="hidden" id="hideM2" name="M2" value="${seat.M2}" />
						<input type="hidden" id="hideM3" name="M3" value="${seat.M3}" />
						<input type="hidden" id="hideM4" name="M4" value="${seat.M4}" />
						<input type="hidden" id="hideM5" name="M5" value="${seat.M5}" />
						<input type="hidden" id="hideM6" name="M6" value="${seat.M6}" />
						<input type="hidden" id="hideM7" name="M7" value="${seat.M7}" />
						<input type="hidden" id="hideM8" name="M8" value="${seat.M8}" />
						<input type="hidden" id="hideM9" name="M9" value="${seat.M9}" />
						<input type="hidden" id="hideM10" name="M10" value="${seat.M10}" />
						<input type="hidden" id="hideM10" name="M10" value="${seat.M10}" />

						<input type="hidden" id="hideN1" name="N1" value="${seat.N1}" />
						<input type="hidden" id="hideN2" name="N2" value="${seat.N2}" />
						<input type="hidden" id="hideN3" name="N3" value="${seat.N3}" />
						<input type="hidden" id="hideN4" name="N4" value="${seat.N4}" />
						<input type="hidden" id="hideN5" name="N5" value="${seat.N5}" />
						<input type="hidden" id="hideN6" name="N6" value="${seat.N6}" />
						<input type="hidden" id="hideN7" name="N7" value="${seat.N7}" />
						<input type="hidden" id="hideN8" name="N8" value="${seat.N8}" />
						<input type="hidden" id="hideN9" name="N9" value="${seat.N9}" />


						<input type="hidden" id="hideO1" name="O1" value="${seat.O1}" />
						<input type="hidden" id="hideO2" name="O2" value="${seat.O2}" />
						<input type="hidden" id="hideO3" name="O3" value="${seat.O3}" />
						<input type="hidden" id="hideO4" name="O4" value="${seat.O4}" />
						<input type="hidden" id="hideO5" name="O5" value="${seat.O5}" />
						<input type="hidden" id="hideO6" name="O6" value="${seat.O6}" />
						<input type="hidden" id="hideO7" name="O7" value="${seat.O7}" />
						<input type="hidden" id="hideO8" name="O8" value="${seat.O8}" />
						<input type="hidden" id="hideO9" name="O9" value="${seat.O9}" />
						<input type="hidden" id="hideO10" name="O10" value="${seat.O10}" />

						<input type="hidden" id="hideP1" name="P1" value="${seat.P1}" />
						<input type="hidden" id="hideP2" name="P2" value="${seat.P2}" />
						<input type="hidden" id="hideP3" name="P3" value="${seat.P3}" />
						<input type="hidden" id="hideP4" name="P4" value="${seat.P4}" />
						<input type="hidden" id="hideP5" name="P5" value="${seat.P5}" />
						<input type="hidden" id="hideP6" name="P6" value="${seat.P6}" />
						<input type="hidden" id="hideP7" name="P7" value="${seat.P7}" />
						<input type="hidden" id="hideP8" name="P8" value="${seat.P8}" />
						<input type="hidden" id="hideP9" name="P9" value="${seat.P9}" />
						<input type="hidden" id="hideP10" name="P10" value="${seat.P10}" />

						<input type="hidden" id="hideQ1" name="Q1" value="${seat.Q1}" />
						<input type="hidden" id="hideQ2" name="Q2" value="${seat.Q2}" />
						<input type="hidden" id="hideQ3" name="Q3" value="${seat.Q3}" />
						<input type="hidden" id="hideQ4" name="Q4" value="${seat.Q4}" />
						<input type="hidden" id="hideQ5" name="Q5" value="${seat.Q5}" />
						<input type="hidden" id="hideQ6" name="Q6" value="${seat.Q6}" />
					</div>




					<!-- <div class="row justify-content-center"> -->
	<table>
		
		<tr>
			<td><img src="<c:url value='/images/04/sofaOff.png' />" alt="" title="" class="sofa${seat.K1}" id="K1" ></td>
			<td><img src="<c:url value='/images/04/sofaOff.png' />" alt="" title="" class="sofa${seat.L1}" id="L1"></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td><img src="<c:url value='/images/04/sofaOff.png' />" alt="" title="" class="sofa${seat.M1}" id="M1" ></td>
			<td><img src="<c:url value='/images/04/sofaOff.png' />" alt="" title="" class="sofa${seat.N1}" id="N1" ></td>

		</tr>
		<tr>
			<td><img src="<c:url value='/images/04/sofaOff.png' />" alt="" title="" class="sofa${seat.K2}" id="K2" ></td>
			<td><img src="<c:url value='/images/04/sofaOff.png' />" alt="" title="" class="sofa${seat.L2}" id="L2"></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td><img src="<c:url value='/images/04/sofaOff.png' />" alt="" title="" class="sofa${seat.M2}" id="M2" ></td>
			<td><img src="<c:url value='/images/04/sofaOff.png' />" alt="" title="" class="sofa${seat.N2}" id="N2" ></td>

		</tr>
		<tr>
			<td><img src="<c:url value='/images/04/sofaOff.png' />" alt="" title="" class="sofa${seat.K3}" id="K3" ></td>
			<td><img src="<c:url value='/images/04/sofaOff.png' />" alt="" title="" class="sofa${seat.L3}" id="L3"></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td><img src="<c:url value='/images/04/sofaOff.png' />" alt="" title="" class="sofa${seat.M3}" id="M3" ></td>
			<td><img src="<c:url value='/images/04/sofaOff.png' />" alt="" title="" class="sofa${seat.N3}" id="N3" ></td>

		</tr>
		<tr>
			<td><img src="<c:url value='/images/04/sofaOff.png' />" alt="" title="" class="sofa${seat.K4}" id="K4" ></td>
			<td><img src="<c:url value='/images/04/sofaOff.png' />" alt="" title="" class="sofa${seat.L4}" id="L4"></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td><img src="<c:url value='/images/04/sofaOff.png' />" alt="" title="" class="sofa${seat.M4}" id="M4" ></td>
			<td><img src="<c:url value='/images/04/sofaOff.png' />" alt="" title="" class="sofa${seat.N4}" id="N4" ></td>

		</tr>
		<tr>
			<td><img src="<c:url value='/images/04/sofaOff.png' />" alt="" title="" class="sofa${seat.K5}" id="K5" ></td>
			<td><img src="<c:url value='/images/04/sofaOff.png' />" alt="" title="" class="sofa${seat.L5}" id="L5"></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td><img src="<c:url value='/images/04/sofaOff.png' />" alt="" title="" class="sofa${seat.M5}" id="M5" ></td>
			<td><img src="<c:url value='/images/04/sofaOff.png' />" alt="" title="" class="sofa${seat.N5}" id="N5" ></td>

		</tr>
		<tr>
			<td><img src="<c:url value='/images/04/sofaOff.png' />" alt="" title="" class="sofa${seat.K6}" id="K6" ></td>
			<td><img src="<c:url value='/images/04/sofaOff.png' />" alt="" title="" class="sofa${seat.L6}" id="L6"></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td><img src="<c:url value='/images/04/sofaOff.png' />" alt="" title="" class="sofa${seat.M6}" id="M6" ></td>
			<td><img src="<c:url value='/images/04/sofaOff.png' />" alt="" title="" class="sofa${seat.N6}" id="N6" ></td>

		</tr>
		<tr>
			<td><img src="<c:url value='/images/04/sofaOff.png' />" alt="" title="" class="sofa${seat.K7}" id="K7" ></td>
			<td><img src="<c:url value='/images/04/sofaOff.png' />" alt="" title="" class="sofa${seat.L7}" id="L7"></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td><img src="<c:url value='/images/04/sofaOff.png' />" alt="" title="" class="sofa${seat.M7}" id="M7" ></td>
			<td><img src="<c:url value='/images/04/sofaOff.png' />" alt="" title="" class="sofa${seat.N7}" id="N7" ></td>

		</tr>
		<tr>
			<td><img src="<c:url value='/images/04/sofaOff.png' />" alt="" title="" class="sofa${seat.K8}" id="K8" ></td>
			<td><img src="<c:url value='/images/04/sofaOff.png' />" alt="" title="" class="sofa${seat.L8}" id="L8"></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td><img src="<c:url value='/images/04/sofaOff.png' />" alt="" title="" class="sofa${seat.M8}" id="M8" ></td>
			<td><img src="<c:url value='/images/04/sofaOff.png' />" alt="" title="" class="sofa${seat.N8}" id="N8" ></td>

		</tr>
		<tr>
			<td><img src="<c:url value='/images/04/sofaOff.png' />" alt="" title="" class="sofa${seat.K9}" id="K9" ></td>
			<td><img src="<c:url value='/images/04/sofaOff.png' />" alt="" title="" class="sofa${seat.L9}" id="L9"></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td><img src="<c:url value='/images/04/sofaOff.png' />" alt="" title="" class="sofa${seat.M9}" id="M9" ></td>
			<td><img src="<c:url value='/images/04/sofaOff.png' />" alt="" title="" class="sofa${seat.N9}" id="N9" ></td>

		</tr>
		
		<tr>
			<td></td>
			<td><img src="<c:url value='/images/04/sofaOff.png' />" alt="" title="" class="sofa${seat.L10}" id="L10" ></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td><img src="<c:url value='/images/04/sofaOff.png' />" alt="" title="" class="sofa${seat.M10}" id="M10" ></td>
			<td></td>
			
		</tr>
		
		<tr>
			<td></td>
			<td><img src="<c:url value='/images/04/sofaOff.png' />" alt="" title="" class="sofa${seat.L11}" id="L11" ></td>
			<td><img src="<c:url value='/images/04/sofaOff.png' />" alt="" title="" class="sofa${seat.O1}" id="O1" ></td>
			<td><img src="<c:url value='/images/04/sofaOff.png' />" alt="" title="" class="sofa${seat.O2}" id="O2" ></td>
			<td><img src="<c:url value='/images/04/sofaOff.png' />" alt="" title="" class="sofa${seat.O3}" id="O3" ></td>
			<td><img src="<c:url value='/images/04/sofaOff.png' />" alt="" title="" class="sofa${seat.O4}" id="O4" ></td>
			<td><img src="<c:url value='/images/04/sofaOff.png' />" alt="" title="" class="sofa${seat.O5}" id="O5" ></td>
			<td><img src="<c:url value='/images/04/sofaOff.png' />" alt="" title="" class="sofa${seat.O6}" id="O6" ></td>
			<td><img src="<c:url value='/images/04/sofaOff.png' />" alt="" title="" class="sofa${seat.O7}" id="O7" ></td>
			<td><img src="<c:url value='/images/04/sofaOff.png' />" alt="" title="" class="sofa${seat.O8}" id="O8" ></td>
			<td><img src="<c:url value='/images/04/sofaOff.png' />" alt="" title="" class="sofa${seat.O9}" id="O9" ></td>
			<td><img src="<c:url value='/images/04/sofaOff.png' />" alt="" title="" class="sofa${seat.O10}" id="O10" ></td>
			<td><img src="<c:url value='/images/04/sofaOff.png' />" alt="" title="" class="sofa${seat.M11}" id="M11" ></td>
			<td></td>
			
		</tr>
		<tr>
			<td></td>
			<td></td>
			<td><img src="<c:url value='/images/04/sofaOff.png' />" alt="" title="" class="sofa${seat.P1}" id="P1" ></td>
			<td><img src="<c:url value='/images/04/sofaOff.png' />" alt="" title="" class="sofa${seat.P2}" id="P2" ></td>
			<td><img src="<c:url value='/images/04/sofaOff.png' />" alt="" title="" class="sofa${seat.P3}" id="P3" ></td>
			<td><img src="<c:url value='/images/04/sofaOff.png' />" alt="" title="" class="sofa${seat.P4}" id="P4" ></td>
			<td><img src="<c:url value='/images/04/sofaOff.png' />" alt="" title="" class="sofa${seat.P5}" id="P5" ></td>
			<td><img src="<c:url value='/images/04/sofaOff.png' />" alt="" title="" class="sofa${seat.P6}" id="P6" ></td>
			<td><img src="<c:url value='/images/04/sofaOff.png' />" alt="" title="" class="sofa${seat.P7}" id="P7" ></td>
			<td><img src="<c:url value='/images/04/sofaOff.png' />" alt="" title="" class="sofa${seat.P8}" id="P8" ></td>
			<td><img src="<c:url value='/images/04/sofaOff.png' />" alt="" title="" class="sofa${seat.P9}" id="P9" ></td>
			<td><img src="<c:url value='/images/04/sofaOff.png' />" alt="" title="" class="sofa${seat.P10}" id="P10" ></td>
			<td></td>
			<td></td>

		</tr>
	
		<tr>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td><img src="<c:url value='/images/04/sofaOff.png' />" alt="" title="" class="sofa${seat.Q1}" id="Q1" ></td>
			<td><img src="<c:url value='/images/04/sofaOff.png' />" alt="" title="" class="sofa${seat.Q2}" id="Q2" ></td>
			<td><img src="<c:url value='/images/04/sofaOff.png' />" alt="" title="" class="sofa${seat.Q3}" id="Q3" ></td>
			<td><img src="<c:url value='/images/04/sofaOff.png' />" alt="" title="" class="sofa${seat.Q4}" id="Q4" ></td>
			<td><img src="<c:url value='/images/04/sofaOff.png' />" alt="" title="" class="sofa${seat.Q5}" id="Q5" ></td>
			<td><img src="<c:url value='/images/04/sofaOff.png' />" alt="" title="" class="sofa${seat.Q6}" id="Q6" ></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>

		</tr>
		
		
		
	</table>
	
		
	<br>
	<br>
	<table>
		<tr>
			<td><img src="<c:url value='/images/04/sofaOff.png' />" alt="" title="" class="sofademo">空位</td>
			<td><img src="<c:url value='/images/04/sofa.png' />" alt="" title="" class="sofademo">已售出</td>
		</tr>
	</table>
	
	 <Input type='hidden' name='category' value='${category}'>
	</form>
	<br><br><input type="button" id="submit" class="btn btn-outline-info" value="修改座位" onclick="return update()">
</div>

	<div class="col-4"><br><br><br><br><br><br>

					<a id="area1" class="area" href="<c:url value='/04/CMS/seatSearch.ctrl?actno=${seat.actno}&category=${category}'/>"></a>
       				<a id="area2" class="area" href="<c:url value='/04/CMS/seat2Search.ctrl?actno=${seat.actno}&category=${category}'/>"></a>
       				<a id="area3" class="area" href="<c:url value='/04/CMS/seat3Search.ctrl?actno=${seat.actno}&category=${category}'/>"></a>
					<img src="<c:url value='/images/04/CMSseatmap.jpg' />" border="0" usemap="#Map" alt="座位表" id="seatmap" class="map"   /> 
	</div>

</div>
</div>
	
<script src="https://code.jquery.com/jquery-3.5.1.js"
		integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc="
		crossorigin="anonymous"></script>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
 	<script>

 	//將已劃位的位置改為sofa.png
 	 $(".sofa1").attr("src", "<c:url value='/images/04/sofa.png' />");

 	    //點擊更換圖片 利用圖片src的value來判斷 		
 	    $(".sofa,.sofa1").mouseover(function() {
 	 	    //顯示選取框
			$(this).css("border-color", "#FFAC55");
			//顯示已選座位數量
			$("#showseat").text($(this).attr('id'));
 		}).mouseout(function() {
 			//隱藏選取框
 			$(this).css("border-color", "#FFFFFF")
 		}).click(function() {
 			if ($(this).attr("src") == "<c:url value='/images/04/sofaOff.png' />" ) {
 	 			//換成選取座位圖
 				$(this).attr("src", "<c:url value='/images/04/sofa.png' />")		 									
 				$(this).attr('class','sofa1')		 									

 				var id ="hide"+$(this).attr('id');
 				$("#"+id).attr('value','1' );
 				$("#"+id).attr('class','seatselect' );
 				$("#selectnum").text($(".sofa").length);
 				$("#seatnum").val($(".sofa").length);

 			}else {
 	 			//換回空位
 				$(this).attr("src", "<c:url value='/images/04/sofaOff.png' />")
 				var id ="hide"+$(this).attr('id');
 				$("#"+id).remove();
 				$(this).attr('class','sofa')	
 				$("#selectnum").text($(".sofa").length);
 				$("#seatnum").val($(".sofa").length);

 			}
 		});    	


//  	   function update() {
// 			var msg = "確認是否更新?";
// 			if (confirm(msg) == true) {
// 				return true;
// 			} else {
// 				return false;
// 			}
// 		}
 	   
 		function update() {
			swal({
					  title: "是否更新座位?",
					  text: "座位將被更新!",
					  icon: "warning",
					  buttons: true,
					  dangerMode: true,
					})
					.then((orderOK) => {
						  if (orderOK) {
							  swal("座位數量已更新!", 
								    	{icon: "success",});  
							  setTimeout(function(){$("#update").submit(); },3000);
							 			
						  } else {
						    swal("操作已取消!");
						  }
						});
	 		
	 		}

		</script> 




</body>
</html>