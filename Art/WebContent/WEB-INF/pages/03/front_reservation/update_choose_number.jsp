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
							href="<c:url value='/03/front/reservation/myReservation.ctrl' />">
							得藝食堂訂位紀錄</a>
					</p>
				</div>
			</div>
		</div>
	</section>
	<!-- End banner Area -->
	<div class="container">
		<br>
		<div class=title>
			<h1 align="center" style="margin-top: 20px;">得藝食堂線上訂位</h1>
		</div>
		<br>
		<div class=title>
			<h2 align="center" style="margin-top: 20px;">修改用餐人數</h2>
		</div>
		<br>
		<div class=title>
			<h3 align="center" style="margin-top: 15px;">
				您所預定的用餐時段&nbsp;<span style="color: #005CAF">${restaurant.year}年&nbsp;${restaurant.month}月&nbsp;${restaurant.day}日
					&nbsp;${moment}&nbsp;</span>目前還剩下&nbsp;<span style="color: #CB4042">${remainingNum}</span>個座位
			</h3>
		</div>
		<br>
		<div class=content style="font-size: larger;">
			<form method="post"
				action="<c:url value="/03/front/reservation/updateAmountExecute.ctrl"/>">
				<table id="03" class="display table table-hover table-blue">
					<thead>
						<tr class="head">
							<th scope="col" colspan="4" class="table-info"
								style="font-size: 22px; color: #0B1013;"><div
									align="center">您預定的用餐人數:&nbsp;<span style="color: #CB4042;">
									${reservation.adultsNum}</span>&nbsp;位大人&nbsp;<span style="color: #CB4042;">${reservation.childrenNum}</span>&nbsp;位小孩</div></th>
						</tr>
						<tr class="head">
							<th scope="col" colspan="4" class="table-danger"
								style="font-size: 22px; color: #0B1013;">新的用餐人數</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td style="font-size: 22px; color: #0B1013;">請選擇大人人數:</td>
							<td>
								<div class="row d-flex justify-content-center">
									<div class="default-select">
										<select id="newAdultsNum" name="newAdultsNum"
											required="required">
											<option value="1">1位大人</option>
											<option value="2">2位大人</option>
											<option value="3">3位大人</option>
											<option value="4">4位大人</option>
											<option value="5">5位大人</option>
										</select>
									</div>
								</div>
							</td>
							<td style="font-size: 22px; color: #0B1013;">請選擇小孩人數:</td>
							<td>
								<div class="row d-flex justify-content-center">
									<div class="default-select">
										<select id="newChildrenNum" name="newChildrenNum"
											required="required">
											<option value="0">0位小孩</option>
											<option value="1">1位小孩</option>
											<option value="2">2位小孩</option>
											<option value="3">3位小孩</option>
											<option value="4">4位小孩</option>
											<option value="5">5位小孩</option>
										</select>
									</div>
								</div>
							</td>
						</tr>
					</tbody>
				</table>
				<div style="display: none">
					<!-- 訂位單號的資訊 -->
					<input type="hidden" name="reservationNo"
						value="${reservation.reservationNo}">
					<!-- 剩餘座位數與中文用餐時間 -->
					<input type="hidden" name="moment" value="${moment}"> <input
						type="hidden" name="remainingNum" value="${remainingNum}">
				</div>
				<br>
				<div class="submitButton" align="center" style="font-size: larger">
					<input type="submit" name="submit" value="修改用餐人數">
				</div>
				<br>
			</form>
		</div>

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
<!-- ====================================================== -->
<script>
	
</script>
</html>