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
<form name="order" action="<c:url value='/04/Cms/seat2Update.ctrl'/>" method="POST" id="updateform">	
	<p id="ticketnum" style="display:none">${sessionScope.shoppingcart.TICKET_NUM}</p>
	<br>
	<h1>藍區座位表</h1>

	<input type="hidden" value="${seat.actno}" id="actno" name="actno"/>

	<table>
	<tr>
		<td>座位資訊</td>
		<td id="showseat" ></td>
	</tr>
	<tr>
		<td>開放購買座位數量</td>
		<td id="selectnum"></td>
		<input type="hidden" id="seatnum" name="seatnum" value=""  />
	</tr>

	</table>


 <div id="seat">
 <input type="hidden" id="hideF1" name="F1" value="${seat.F1}"  />
 <input type="hidden" id="hideF2" name="F2" value="${seat.F2}"  />
 <input type="hidden" id="hideF3" name="F3" value="${seat.F3}"  />
 <input type="hidden" id="hideF4" name="F4" value="${seat.F4}"  />
 <input type="hidden" id="hideF5" name="F5" value="${seat.F5}"  />
 <input type="hidden" id="hideF6" name="F6" value="${seat.F6}"  />
 <input type="hidden" id="hideF7" name="F7" value="${seat.F7}"  />
 <input type="hidden" id="hideF8" name="F8" value="${seat.F8}"  />
 <input type="hidden" id="hideF9" name="F9" value="${seat.F9}"  />
 <input type="hidden" id="hideF10" name="F10" value="${seat.F10}"  />

 <input type="hidden" id="hideG1" name="G1" value="${seat.G1}"  />
 <input type="hidden" id="hideG2" name="G2" value="${seat.G2}"  />
 <input type="hidden" id="hideG3" name="G3" value="${seat.G3}"  />
 <input type="hidden" id="hideG4" name="G4" value="${seat.G4}"  />
 <input type="hidden" id="hideG5" name="G5" value="${seat.G5}"  />
 <input type="hidden" id="hideG6" name="G6" value="${seat.G6}"  />
 <input type="hidden" id="hideG7" name="G7" value="${seat.G7}"  />
 <input type="hidden" id="hideG8" name="G8" value="${seat.G8}"  />
 <input type="hidden" id="hideG9" name="G9" value="${seat.G9}"  />
 <input type="hidden" id="hideG10" name="G10" value="${seat.G10}"  />


 <input type="hidden" id="hideH1" name="H1" value="${seat.H1}"  />
 <input type="hidden" id="hideH2" name="H2" value="${seat.H2}"  />
 <input type="hidden" id="hideH3" name="H3" value="${seat.H3}"  />
 <input type="hidden" id="hideH4" name="H4" value="${seat.H4}"  />
 <input type="hidden" id="hideH5" name="H5" value="${seat.H5}"  />
 <input type="hidden" id="hideH6" name="H6" value="${seat.H6}"  />
 <input type="hidden" id="hideH7" name="H7" value="${seat.H7}"  />
 <input type="hidden" id="hideH8" name="H8" value="${seat.H8}"  />
 <input type="hidden" id="hideH9" name="H9" value="${seat.H9}"  />
 <input type="hidden" id="hideH10" name="H10" value="${seat.H10}"  />

 <input type="hidden" id="hideI1" name="I1" value="${seat.I1}"  />
 <input type="hidden" id="hideI2" name="I2" value="${seat.I2}"  />
 <input type="hidden" id="hideI3" name="I3" value="${seat.I3}"  />
 <input type="hidden" id="hideI4" name="I4" value="${seat.I4}"  />
 <input type="hidden" id="hideI5" name="I5" value="${seat.I5}"  />
 <input type="hidden" id="hideI6" name="I6" value="${seat.I6}"  />
 <input type="hidden" id="hideI7" name="I7" value="${seat.I7}"  />
 <input type="hidden" id="hideI8" name="I8" value="${seat.I8}"  />
 <input type="hidden" id="hideI9" name="I9" value="${seat.I9}"  />
 <input type="hidden" id="hideI10" name="I10" value="${seat.I10}"  />

 <input type="hidden" id="hideJ1" name="J1" value="${seat.J1}"  />
 <input type="hidden" id="hideJ2" name="J2" value="${seat.J2}"  />
 <input type="hidden" id="hideJ3" name="J3" value="${seat.J3}"  />
 <input type="hidden" id="hideJ4" name="J4" value="${seat.J4}"  />
 <input type="hidden" id="hideJ5" name="J5" value="${seat.J5}"  />
 <input type="hidden" id="hideJ6" name="J6" value="${seat.J6}"  />
 <input type="hidden" id="hideJ7" name="J7" value="${seat.J7}"  />
 <input type="hidden" id="hideJ8" name="J8" value="${seat.J8}"  />
 <input type="hidden" id="hideJ9" name="J9" value="${seat.J9}"  />
 <input type="hidden" id="hideJ10" name="J10" value="${seat.J10}"  />
</div>




<!-- <div class="row justify-content-center"> -->
	<table>
		
		<tr>
			<td><img src="<c:url value='/images/04/sofaOff.png' />" alt="" title="" class="sofa${seat.F1}" id="F1" ></td>
			<td><img src="<c:url value='/images/04/sofaOff.png' />" alt="" title="" class="sofa${seat.F2}" id="F2"></td>
			<td><img src="<c:url value='/images/04/sofaOff.png' />" alt="" title="" class="sofa${seat.F3}" id="F3" ></td>
			<td><img src="<c:url value='/images/04/sofaOff.png' />" alt="" title="" class="sofa${seat.F4}" id="F4" ></td>
			<td><img src="<c:url value='/images/04/sofaOff.png' />" alt="" title="" class="sofa${seat.F5}" id="F5" ></td>
			<td><img src="<c:url value='/images/04/sofaOff.png' />" alt="" title="" class="sofa${seat.F6}" id="F6" ></td>
			<td><img src="<c:url value='/images/04/sofaOff.png' />" alt="" title="" class="sofa${seat.F7}" id="F7" ></td>
			<td><img src="<c:url value='/images/04/sofaOff.png' />" alt="" title="" class="sofa${seat.F8}" id="F8" ></td>
			<td><img src="<c:url value='/images/04/sofaOff.png' />" alt="" title="" class="sofa${seat.F9}" id="F9" ></td>
			<td><img src="<c:url value='/images/04/sofaOff.png' />" alt="" title="" class="sofa${seat.F10}" id="F10" ></td>

		</tr>
		<tr>
			<td><img src="<c:url value='/images/04/sofaOff.png' />" alt="" title="" class="sofa${seat.G1}" id="G1" ></td>
			<td><img src="<c:url value='/images/04/sofaOff.png' />" alt="" title="" class="sofa${seat.G2}" id="G2" ></td>
			<td><img src="<c:url value='/images/04/sofaOff.png' />" alt="" title="" class="sofa${seat.G3}" id="G3" ></td>
			<td><img src="<c:url value='/images/04/sofaOff.png' />" alt="" title="" class="sofa${seat.G4}" id="G4" ></td>
			<td><img src="<c:url value='/images/04/sofaOff.png' />" alt="" title="" class="sofa${seat.G5}" id="G5" ></td>
			<td><img src="<c:url value='/images/04/sofaOff.png' />" alt="" title="" class="sofa${seat.G6}" id="G6" ></td>
			<td><img src="<c:url value='/images/04/sofaOff.png' />" alt="" title="" class="sofa${seat.G7}" id="G7" ></td>
			<td><img src="<c:url value='/images/04/sofaOff.png' />" alt="" title="" class="sofa${seat.G8}" id="G8" ></td>
			<td><img src="<c:url value='/images/04/sofaOff.png' />" alt="" title="" class="sofa${seat.G9}" id="G9" ></td>
			<td><img src="<c:url value='/images/04/sofaOff.png' />" alt="" title="" class="sofa${seat.G10}" id="G10" ></td>

		</tr>
		<tr>
			<td><img src="<c:url value='/images/04/sofaOff.png' />" alt="" title="" class="sofa${seat.H1}" id="H1" ></td>
			<td><img src="<c:url value='/images/04/sofaOff.png' />" alt="" title="" class="sofa${seat.H2}" id="H2" ></td>
			<td><img src="<c:url value='/images/04/sofaOff.png' />" alt="" title="" class="sofa${seat.H3}" id="H3" ></td>
			<td><img src="<c:url value='/images/04/sofaOff.png' />" alt="" title="" class="sofa${seat.H4}" id="H4" ></td>
			<td><img src="<c:url value='/images/04/sofaOff.png' />" alt="" title="" class="sofa${seat.H5}" id="H5" ></td>
			<td><img src="<c:url value='/images/04/sofaOff.png' />" alt="" title="" class="sofa${seat.H6}" id="H6" ></td>
			<td><img src="<c:url value='/images/04/sofaOff.png' />" alt="" title="" class="sofa${seat.H7}" id="H7" ></td>
			<td><img src="<c:url value='/images/04/sofaOff.png' />" alt="" title="" class="sofa${seat.H8}" id="H8" ></td>
			<td><img src="<c:url value='/images/04/sofaOff.png' />" alt="" title="" class="sofa${seat.H9}" id="H9" ></td>
			<td><img src="<c:url value='/images/04/sofaOff.png' />" alt="" title="" class="sofa${seat.H10}" id="H10" ></td>

		</tr>
		<tr>
			<td><img src="<c:url value='/images/04/sofaOff.png' />" alt="" title="" class="sofa${seat.I1}" id="I1" ></td>
			<td><img src="<c:url value='/images/04/sofaOff.png' />" alt="" title="" class="sofa${seat.I2}" id="I2" ></td>
			<td><img src="<c:url value='/images/04/sofaOff.png' />" alt="" title="" class="sofa${seat.I3}" id="I3" ></td>
			<td><img src="<c:url value='/images/04/sofaOff.png' />" alt="" title="" class="sofa${seat.I4}" id="I4" ></td>
			<td><img src="<c:url value='/images/04/sofaOff.png' />" alt="" title="" class="sofa${seat.I5}" id="I5" ></td>
			<td><img src="<c:url value='/images/04/sofaOff.png' />" alt="" title="" class="sofa${seat.I6}" id="I6" ></td>
			<td><img src="<c:url value='/images/04/sofaOff.png' />" alt="" title="" class="sofa${seat.I7}" id="I7" ></td>
			<td><img src="<c:url value='/images/04/sofaOff.png' />" alt="" title="" class="sofa${seat.I8}" id="I8" ></td>
			<td><img src="<c:url value='/images/04/sofaOff.png' />" alt="" title="" class="sofa${seat.I9}" id="I9" ></td>
			<td><img src="<c:url value='/images/04/sofaOff.png' />" alt="" title="" class="sofa${seat.I10}" id="I10" ></td>

		</tr>
		
		<tr>
			<td><img src="<c:url value='/images/04/sofaOff.png' />" alt="" title="" class="sofa${seat.J1}" id="J1" ></td>
			<td><img src="<c:url value='/images/04/sofaOff.png' />" alt="" title="" class="sofa${seat.J2}" id="J2" ></td>
			<td><img src="<c:url value='/images/04/sofaOff.png' />" alt="" title="" class="sofa${seat.J3}" id="J3" ></td>
			<td><img src="<c:url value='/images/04/sofaOff.png' />" alt="" title="" class="sofa${seat.J4}" id="J4" ></td>
			<td><img src="<c:url value='/images/04/sofaOff.png' />" alt="" title="" class="sofa${seat.J5}" id="J5" ></td>
			<td><img src="<c:url value='/images/04/sofaOff.png' />" alt="" title="" class="sofa${seat.J6}" id="J6" ></td>
			<td><img src="<c:url value='/images/04/sofaOff.png' />" alt="" title="" class="sofa${seat.J7}" id="J7" ></td>
			<td><img src="<c:url value='/images/04/sofaOff.png' />" alt="" title="" class="sofa${seat.J8}" id="J8" ></td>
			<td><img src="<c:url value='/images/04/sofaOff.png' />" alt="" title="" class="sofa${seat.J9}" id="J9" ></td>
			<td><img src="<c:url value='/images/04/sofaOff.png' />" alt="" title="" class="sofa${seat.J10}" id="J10" ></td>
			
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
							  setTimeout(function(){$("#updateform").submit(); },3000);
							 			
						  } else {
						    swal("操作已取消!");
						  }
						});
	 		
	 		}

		</script> 




</body>
</html>