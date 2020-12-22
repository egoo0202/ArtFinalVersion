<%@page import="tw.group4._04_.front.shopcart.model.Shoppingcart"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="zh-tw">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>節目內容</title>
<style>
td {
	width: 100px;
}

.halfnum {
	width: 30px;
}

.adultnum {
	width: 30px;
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

body {
	color: black;
	font-size:18px;
}
.all{
/* 	background-color: #c8c8b4; */

}
.flip{
background-color: #E0E0E0;
}
.table table-bordered{
}
#detail{
background-color: #E0E0E0;
}
.col-sm-3{
background-color: #E0E0E0;
}
.H3bar{
background-color: #ADADAD;
}
#buy{
align:center;
width: 250px;
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
							<p class="text-white link-nav"><a href="<c:url value='/index.html' />">Home </a>  <span class="lnr lnr-arrow-right"></span>  <a href=""> Search</a><span class="lnr lnr-arrow-right"></span><a href=""> Detail</a></p>
						</div>											
					</div>
				</div>
			</section>
	<!-- End banner Area -->

<div class="container">

 
		<form name="order" action="<c:url value='/04/seatmap'/>" method="get">
<%-- 		<form name="order" action="<c:url value='/04/booking.ctrl'/>" method="get"> --%>

		<!-- 用param.取，相當於request.getParameter-->
		<c:set var="actid" value="${actid}" scope="session"/>
		<c:set var="title" value="${title}" scope="session" />
		<c:set var="site" value="${site}" scope="session" />
		<c:set var="description" value="${description}" scope="session" />
<div class="row">
			<div class="col-sm-3">

			<br>
			<h3 >主辦單位</h3><br>

			<p>&nbsp;&nbsp; ${mainunit}</p><br><br>
			<h3>活動地點</h3><br>
			<p>&nbsp; ${site}</p><br><br>		
			<h3>活動日期</h3><br>
			<p>&nbsp; ${startdate} ~ ${enddate}</p>	
			
			<div class="row justify-content-center">
			<br><br><input type="submit" class="genric-btn primary-border radius" value="立即購票" id="buy">
				</div><br><br>
			
			
			</div>
			<div class="col-sm-9">
			
		<br><H1>${title}</H1>	
		<div id="detail" >


		</div>

		
		
		<br><h3>節目簡介</h3><br>
		<P>${description}</P><br><br>
		
		<div class="text-center">
		<img style='display:block;width:800px;' src="data:image/jpg;base64,${photo}" >
		</div>
		
		<br><br><iframe width="100%" height="250" frameborder="0" src="https://www.google.com/maps?q=${site}&output=embed"></iframe>

</div>
		<p></p><br>
		<H2>票券資訊</H2>
		<table class="table table-bordered">
		<tr> 
				<td>節目名稱</td>
				<td>票種</td>
				<td>座位</td>
				<td>票價</td>
				
				

			</tr>
			<tr> 
				<td class="title">${title}</td>
				<td>半票</td>
				<td>自行劃位</td>
				<td>NT$1000</td>
		
				
			</tr>
						<tr> 
				<td class="title">${title}</td>
				<td>全票</td>
				<td>自行劃位</td>
				<td>NT$2000</td>
				
			</tr>
		</table>
		
				<br><br><input type="submit" class="genric-btn primary-border radius" value="立即購票">

		</form>
<!-- 			<br><br><p class="flip">進場須知</p> -->
<!-- 			<div class="panel" style="display:none;"> -->
<!-- 				<p>★ 均可入場，一人一票</p> -->
<!-- 			</div> -->
</div>
</div>


			<!-- Start blog Area -->
			<section class="blog-area section-gap" id="blog">
				<div class="container">
					<h1 class="mb-10">相似活動</h1>
					<div class="row" id="likeact">
					</div>
				</div>	
			</section>
		<!-- End blog Area -->
		
<script> 
$(document).ready(function(){
$(".flip").click(function(){
$(".panel").slideToggle("slow");
});
});
</script>

<script>	

$(document).ready(function(){

   	 $.ajax({
			type: "get",
			url: "/Art/04/Searchlike",
			contentType: "application/json",
			dataType: "json",
// 			data: data,
			cache: false,
			success: function(json) {
				$.each(json, function( index, value ) {
				$("#likeact").append(
				"<div class='col-lg-3 col-md-6 single-blog'>"
				+"<div class='thumb'>"
				+"<img class='img-fluid' style='display:block;width:200px;' src='data:image/jpg;base64,"+value.PHOTOBASE64+"'>"							
				+"</div>"
				+"<p>"+value.ACT_STARTDATE+"</p>"
				+"<a href='<c:url value='/04/showDetail.ctrl?actid="+value.ACT_NO+"'/>'><h4>"+value.ACT_TITLE+"</h4></a>"
// 				+"<p></p><div class='meta-bottom d-flex justify-content-between'><p><span class='lnr lnr-heart'></span> 15 Likes</p><p><span class='lnr lnr-bubble'></span> 02 則回應</p></div>"								
				+"</div>");
					});
								
			},
			error:  function() {
				alert("failure");
			}
			});	

	});

	
</script>

</body>

</html>