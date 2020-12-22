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
<form name="order" action="<c:url value='/04/Cms/seatUpdate.ctrl'/>" method="POST" id="updateform">	
	<p id="ticketnum" style="display:none">${sessionScope.shoppingcart.TICKET_NUM}</p>
	<br>
	<h1>前台區座位表</h1>

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
 <input type="hidden" id="hideA1" name="A1" value="${seat.A1}"  />
 <input type="hidden" id="hideA2" name="A2" value="${seat.A2}"  />
 <input type="hidden" id="hideA3" name="A3" value="${seat.A3}"  />
 <input type="hidden" id="hideA4" name="A4" value="${seat.A4}"  />
 <input type="hidden" id="hideA5" name="A5" value="${seat.A5}"  />
 <input type="hidden" id="hideA6" name="A6" value="${seat.A6}"  />
 <input type="hidden" id="hideA7" name="A7" value="${seat.A7}"  />
 <input type="hidden" id="hideA8" name="A8" value="${seat.A8}"  />
 <input type="hidden" id="hideA9" name="A9" value="${seat.A9}"  />
 <input type="hidden" id="hideA10" name="A10" value="${seat.A10}"  />

 <input type="hidden" id="hideB1" name="B1" value="${seat.B1}"  />
 <input type="hidden" id="hideB2" name="B2" value="${seat.B2}"  />
 <input type="hidden" id="hideB3" name="B3" value="${seat.B3}"  />
 <input type="hidden" id="hideB4" name="B4" value="${seat.B4}"  />
 <input type="hidden" id="hideB5" name="B5" value="${seat.B5}"  />
 <input type="hidden" id="hideB6" name="B6" value="${seat.B6}"  />
 <input type="hidden" id="hideB7" name="B7" value="${seat.B7}"  />
 <input type="hidden" id="hideB8" name="B8" value="${seat.B8}"  />
 <input type="hidden" id="hideB9" name="B9" value="${seat.B9}"  />
 <input type="hidden" id="hideB10" name="B10" value="${seat.B10}"  />


 <input type="hidden" id="hideC1" name="C1" value="${seat.C1}"  />
 <input type="hidden" id="hideC2" name="C2" value="${seat.C2}"  />
 <input type="hidden" id="hideC3" name="C3" value="${seat.C3}"  />
 <input type="hidden" id="hideC4" name="C4" value="${seat.C4}"  />
 <input type="hidden" id="hideC5" name="C5" value="${seat.C5}"  />
 <input type="hidden" id="hideC6" name="C6" value="${seat.C6}"  />
 <input type="hidden" id="hideC7" name="C7" value="${seat.C7}"  />
 <input type="hidden" id="hideC8" name="C8" value="${seat.C8}"  />
 <input type="hidden" id="hideC9" name="C9" value="${seat.C9}"  />
 <input type="hidden" id="hideC10" name="C10" value="${seat.C10}"  />

 <input type="hidden" id="hideD1" name="D1" value="${seat.D1}"  />
 <input type="hidden" id="hideD2" name="D2" value="${seat.D2}"  />
 <input type="hidden" id="hideD3" name="D3" value="${seat.D3}"  />
 <input type="hidden" id="hideD4" name="D4" value="${seat.D4}"  />
 <input type="hidden" id="hideD5" name="D5" value="${seat.D5}"  />
 <input type="hidden" id="hideD6" name="D6" value="${seat.D6}"  />
 <input type="hidden" id="hideD7" name="D7" value="${seat.D7}"  />
 <input type="hidden" id="hideD8" name="D8" value="${seat.D8}"  />
 <input type="hidden" id="hideD9" name="D9" value="${seat.D9}"  />
 <input type="hidden" id="hideD10" name="D10" value="${seat.D10}"  />

 <input type="hidden" id="hideE1" name="E1" value="${seat.E1}"  />
 <input type="hidden" id="hideE2" name="E2" value="${seat.E2}"  />
 <input type="hidden" id="hideE3" name="E3" value="${seat.E3}"  />
 <input type="hidden" id="hideE4" name="E4" value="${seat.E4}"  />
 <input type="hidden" id="hideE5" name="E5" value="${seat.E5}"  />
 <input type="hidden" id="hideE6" name="E6" value="${seat.E6}"  />
 <input type="hidden" id="hideE7" name="E7" value="${seat.E7}"  />
 <input type="hidden" id="hideE8" name="E8" value="${seat.E8}"  />
 <input type="hidden" id="hideE9" name="E9" value="${seat.E9}"  />
 <input type="hidden" id="hideE10" name="E10" value="${seat.E10}"  />
</div>

 <Input type='hidden' name='category' value='${category}'>
	</form>


<!-- <div class="row justify-content-center"> -->
	<table>
		
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
	
		
	<br>
	<br>
	<table>
		<tr>
			<td><img src="<c:url value='/images/04/sofaOff.png' />" alt="" title="" class="sofademo">空位</td>
			<td><img src="<c:url value='/images/04/sofa.png' />" alt="" title="" class="sofademo">已售出</td>
		</tr>
	</table>
	
	
	<br><br><input type="button" id="submit" class="btn btn-outline-info" value="修改座位" onclick="update()">
</div>

	<div class="col-4"><br><br><br><br><br><br>

					<a id="area1" class="area" href="<c:url value='/04/CMS/seatSearch.ctrl?actno=${seat.actno}&category=${category}'/>"></a>
       				<a id="area2" class="area" href="<c:url value='/04/CMS/seat2Search.ctrl?actno=${seat.actno}&category=${category}'/>"></a>
       				<a id="area3" class="area" href="<c:url value='/04/CMS/seat3Search.ctrl?actno=${seat.actno}&category=${category}'/>"></a>
					<img src="<c:url value='/images/04/CMSseatmap.jpg' />" border="0" usemap="#Map" alt="座位表" id="seatmap" class="map"   /> 
	</div>

</div>
</div>


	

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
							  setTimeout(function(){$("#updateform").submit(); },2000);
							 			
						  } else {
						    swal("操作已取消!");
						  }
						});
	 		
	 		}

		</script> 




</body>
</html>