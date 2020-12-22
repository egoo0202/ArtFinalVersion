<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="zh-tw">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>購物車</title>
<link rel="stylesheet"
	href="<c:url value='/frontstyle/css/processbar.css' />">
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

#1 {
	float: right;
}

form {
	display: inline;
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
					<div class="progress-bar" style="width: 100%;"></div>
				</div>
				<a href="" class="bs-wizard-dot"></a>
				<div class="bs-wizard-info text-center">區域/張數</div>
			</div>

			<div class="col-lg-3 bs-wizard-step complet">
				<!-- complete -->
				<div class="text-center bs-wizard-stepnum">Step 2</div>
				<div class="progress">
					<div class="progress-bar" style="width: 100%;"></div>
				</div>
				<a href="" class="bs-wizard-dot"></a>
				<div class="bs-wizard-info text-center">劃位</div>
			</div>

			<div class="col-lg-3 bs-wizard-step active">
				<!-- complete -->
				<div class="text-center bs-wizard-stepnum">Step 3</div>
				<div class="progress">
					<div class="progress-bar" style="width: 50%;"></div>
				</div>
				<a href="#" class="bs-wizard-dot"></a>
				<div class="bs-wizard-info text-center">購票確認</div>
			</div>

			<div class="col-lg-3 bs-wizard-step disabled">
				<!-- active -->
				<div class="text-center bs-wizard-stepnum">Step 4</div>
				<div class="progress">
					<div class="progress-bar"></div>
				</div>
				<a href="#" class="bs-wizard-dot"></a>
				<div class="bs-wizard-info text-center">完成訂購</div>
			</div>
		</div>







		<form id="order" name="order2"
			action="<c:url value='/04/shoppingcart2.ctrl'/> " method="get">
			<H1>訂購人資訊</H1>
			<table class="table table-bordered">


				<tr>
					<td>訂購人姓名</td>
					<td><input type="text" name="name" id="name"
						value="${sessionScope.shoppingcart.NAME}" required="required"
						class="single-input"></td>
				</tr>
				<tr>
					<td>電子郵件</td>
					<td><input type="email" name="email" id="email"
						value="${sessionScope.shoppingcart.EMAIL}" required="required"
						class="single-input"></td>
				</tr>
				<tr>
					<td>電話</td>
					<td><input type="text" name="tel" id="tel"
						value="${sessionScope.shoppingcart.TEL}" required="required"
						class="single-input"></td>
				</tr>
				<tr>
					<td>地址</td>
					<td><input type="text" name="add" id="add"
						value="${sessionScope.shoppingcart.ADDRESS}" required="required"
						class="single-input"></td>
				</tr>
			</table>
			<br> <br> <br>
		</form>


		<H2>訂購票券</H2>
		<table class="table table-bordered">
			<tr>
				<td>節目名稱</td>
				<td>票種</td>
				<td>座位</td>
				<td>票價</td>
				<td>操作</td>

			</tr>
			<p class="ticketcategry" style="display: none">${sessionScope.shoppingcart.TICKETCATEGORY}</p>
			<c:forEach items="${sessionScope.shoppingcart.seats}" var="seat">

				<tr>
					<td class="title">${sessionScope.shoppingcart.TITLE}</td>
					<td>${sessionScope.shoppingcart.TICKETCATEGORY}</td>
					<td>${seat}</td>
					<td class="price"></td>
					<td >
						<form name="order" action="<c:url value='/04/delectTicket.ctrl'/> " method="get">
							<input type="hidden" value="${seat}" id="seat" name="seat">
							<button name="seat" type="button" value="${seat}"
								class="genric-btn success-border radius">刪除</button>
							<%-- 						<button name="seat" type="button" value="${seat}" --%>
							<!-- 								class="genric-btn success-border radius"onclick="return del()">刪除</button> -->
						</form>
					</td>
				</tr>
			</c:forEach>

		</table>
		<input type="submit" value="全部清除" name="clear"
			class="genric-btn primary-border radius" id="clear"> 
		<input
			type="submit" value="繼續購票" name="1"
			class="genric-btn primary-border radius" id="1" form="order">

		<input type="button" value="DEMO" name=""
			class="genric-btn primary-border radius" id="DEMO">

	</div>

	<script src="https://code.jquery.com/jquery-3.5.1.js"
		integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc="
		crossorigin="anonymous"></script>
	<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
	<script>
		$(document).ready(function() {
			if ($(".ticketcategry").text() == "全票") {
				$(".price").text("NT$2000")
			} else {
				$(".price").text("NT$1000")
			}
		});

// 		function del() {
// 			var msg = "是否刪除?";
// 			if (confirm(msg) == true) {
// 				return true;
// 			} else {
// 				return false;
// 			}
// 		}
//     var button =".genric-btn success-border radius";
	$("button").click(function() {
		var form = $(this).parents('form');
		swal({
				  title: "是否刪除票券?",
				  text: "票券即將刪除!",
				  icon: "warning",
				  buttons: true,
				  dangerMode: true,
				})
				.then((orderOK) => {
					  if (orderOK) {
					form.submit();					
					  } else {
					    swal("刪除已取消!");
					  }
					});

 		});

		$("#clear").click(function() {

			swal({
				  title: "是否清除購物車??",
				  text: "購物車即將刪除!",
				  icon: "warning",
				  buttons: true,
				  dangerMode: true,
				})
				.then((orderOK) => {
					  if (orderOK) {
					  window.location = "<c:url value='/04/delectCart.ctrl'/>"
					  } else {
					    swal("刪除已取消!");
					  }
					});
		});
		
		$("#DEMO").click(function() {
				$("#name").val("大中天");
				$("#email").val("aaartgroup4@gmail.com");
				$("#tel").val("0912345678");
				$("#add").val("100台北市中正區重慶南路一段122號");
	});
	</script>


</body>

</html>