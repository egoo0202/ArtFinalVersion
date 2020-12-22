<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>my reservation</title>
<style>
/* p, div { */

/* } */
.rs-symbol-color::after {
	content: "※";
	margin-left: 3px;
	font-weight: 800;
	color: rgb(203, 64, 66);
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
					<h1 class="text-white">AAART Shop</h1>
					<p class="text-white link-nav">
						<a href="index.html">首頁 </a> <span class="lnr lnr-arrow-right"></span>
						<a
							href="<c:url value='/03/front/reservation/chooseNumberAndDate' />">
							得藝食堂線上訂位</a>
					</p>
				</div>
			</div>
		</div>
	</section>
	<!-- End banner Area -->
	<div class="container">
		<br>
		<div class=title>
			<h2 align="center" style="margin-top: 20px;">得藝食堂線上訂位</h2>
		</div>
		<br>
		<div class=title>
			<h2 align="center" style="margin-top: 20px; margin-bottom: 30px;">
				<span class="rs-symbol-color"></span>訂位資訊傳輸中&nbsp;請稍後
			</h2>
			<br>
		</div>
		<!--  ===== 轉跳綠界 =====  -->
		<div>${greenPage}</div>
		<!--  ===== 轉跳綠界 =====  -->
		<br> <br> <br>
		<!-- 圖片輪播區塊 -->
		<br> <br> <br>
		<div class=title>
			<h2 align="center" style="margin-top: 20px;">嚴選食材、特製甜點</h2>
		</div>
		<br>
		<!-- Start exibition Area -->
		<div align="center">
			<section class="exibition-area section-gap"
				style="background-color: #FFFFFF; padding-top: 30px; padding-bottom: 30px;"
				id="exhibitions">
				<div class="container">
					<div class="row">
						<div class="active-exibition-carusel">
							<div class="single-exibition item">
								<img class="wrapper-restaurant"
									src="<c:url value='/images/03/shabu01.jpg'/>" alt="">
							</div>
							<div class="single-exibition item">
								<img class="wrapper-restaurant"
									src="<c:url value='/images/03/shabu02.jpg'/>" alt="">
							</div>
							<div class="single-exibition item">
								<img class="wrapper-restaurant"
									src="<c:url value='/images/03/fruit01.jpg'/>" alt="">
							</div>
							<div class="single-exibition item">
								<img class="wrapper-restaurant"
									src="<c:url value='/images/03/fruit02.jpg'/>" alt="">
							</div>
							<div class="single-exibition item">
								<img class="wrapper-restaurant"
									src="<c:url value='/images/03/juice01.jpg'/>" alt="">
							</div>
							<div class="single-exibition item">
								<img class="wrapper-restaurant"
									src="<c:url value='/images/03/dessert01.jpg'/>" alt="">
							</div>
						</div>
					</div>
				</div>
			</section>
		</div>
		<!-- End exibition Area -->
		<!-- 輪播結束 -->

	</div>
</body>
</html>
<!-- ====================================================== -->