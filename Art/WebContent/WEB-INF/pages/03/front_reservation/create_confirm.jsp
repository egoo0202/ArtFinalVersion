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

.rs-symbol-color::after {
	content: "*";
	margin-left: 3px;
	font-weight: 800;
	color: rgb(203, 64, 66);
}

.custom-button {
	display: inline-block;
	outline: none;
	line-height: 40px;
	padding: 0 10px;
	text-align: center;
	text-decoration: none;
	font-weight: bold;
	cursor: pointer;
	border-radius: 5px;
	font-size: larger;
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
			<h2 align="center" style="margin-top: 20px; margin-bottom: 20px">輪播廣告</h2>
		</div>
		<div class=title>
			<h3 align="center" style="margin-top: 20px; margin-bottom: 20px">請填寫聯絡資訊</h3>
		</div>
		<div class="row">
			<div class="col-lg-3 col-md-4 mt-sm-30">
				<div align="center">
					<div class=title>
						<h3 align="center" style="margin-bottom: 15px">用餐人數與時間</h3>
					</div>
					<table class="display table table-hover table-blue">
						<thead>
							<tr class="head">
								<th scope="col">
									<div class="custom-button" style="background-color: #FAD689">用餐人數</div>
								</th>
							</tr>
							<tr>
								<th scope="col" style="font-size: larger;">
									<div class="custom-button"
										style="background-color: #FFFFFF; font-weight: normal;">
										${amount}&nbsp;位</div>
								</th>
							</tr>
							<tr>
								<!-- #================= -->
								<th scope="col">
									<div class="custom-button" style="background-color: #A5DEE4">用餐日期</div>
								</th>
							</tr>
							<tr>
								<th scope="col" style="font-size: larger;">
									<div class="custom-button"
										style="background-color: #FFFFFF; font-weight: normal;">
										${dateTime}</div>
								</th>
							</tr>
							<tr>
								<!-- #================= -->
								<th scope="col">
									<div class="custom-button" style="background-color: #F596AA">用餐時段</div>
								</th>
								<!-- #================= -->
							</tr>
							<tr>
								<th scope="col" style="font-size: larger;">
									<div class="custom-button"
										style="background-color: #FFFFFF; font-weight: normal;">
										${time}</div>
								</th>
							</tr>
						</thead>
						<tbody></tbody>
						<tfoot></tfoot>
					</table>
				</div>
			</div>
			<div class="col-lg-8 col-md-8">
				<div class="container" style="width: 700px; font-size: larger;">
					<form method="post"
						action="<c:url value = "/03/front/reservation/createReservation.ctrl"/>">
						<table id="03A" class="display table table-hover table-blue">
							<thead>
							</thead>
							<tfoot></tfoot>
							<tbody>
								<tr>
									<td class='table-warning'><div class="rs-symbol-color"
											style="font-size: larger; font-weight: bold;">訂位人姓名</div></td>
								</tr>
								<tr>
									<td><input type="text" name="customerName"
										required="required" placeholder="請輸入姓名"></td>
								</tr>
								<!-- # ================== -->
								<tr>
									<td class='table-info'>
										<div class="rs-symbol-color"
											style="font-size: larger; font-weight: bold;">訂位人稱呼</div>
									</td>
								</tr>
								<tr>
									<td><div>
											<input type="radio" name="gender" value="1" checked>
											<label>先生</label> <input type="radio" name="gender" value="0">
											<label>小姐</label> <input type="radio" name="gender" value="2">
											<label>其他</label>
										</div></td>
								</tr>
								<!-- # ================== -->
								<tr>
									<td class='table-danger'>
										<div style="font-size: larger; font-weight: bold;"
											class="rs-symbol-color">連絡電話</div>
									</td>
								</tr>
								<tr>
									<td><input type="text" name="customerPhone"
										required="required" placeholder="請輸入手機號碼"></td>
								</tr>
								<!-- # ================== -->
								<tr>
									<td class='table-success'>
										<div style="font-size: larger; font-weight: bold;">Email</div>
									</td>
								</tr>
								<tr>
									<td><input type="text" name="email" required="required"
										placeholder="請輸入 Email"></td>
								</tr>
								<!-- # ================== -->
								<tr>
									<td class='table-warning'>
										<div style="font-size: larger; font-weight: bold;">用餐目的</div>
								</tr>
								<tr>
									<td><div>
											<input type="radio" name="purpose" value="1" checked>
											<label>不填寫&emsp;&nbsp;</label> <input type="radio"
												name="purpose" value="2"> <label>約會&nbsp;&emsp;&emsp;</label>
											<input type="radio" name="purpose" value="3"> <label>慶生</label>
										</div></td>
								</tr>
								<tr>
									<td><div>
											<input type="radio" name="purpose" value="4"> <label>家庭聚餐&nbsp;</label>
											<input type="radio" name="purpose" value="5"> <label>朋友聚餐&nbsp;</label>
											<input type="radio" name="purpose" value="6"> <label>商務聚餐</label>
										</div></td>
								</tr>
								<!-- # ================== -->
								<tr>
									<td class='table-info'>
										<div style="font-size: larger; font-weight: bold;">備註</div>
								</tr>
								<tr>
									<td><textarea name="note"
											style="width: 620px; height: 65px;"
											placeholder="有任何特殊要求嗎? （例如兒童座椅、食物過敏或長者行動不便）這些都可以告訴我們"></textarea></td>
								</tr>
								<!-- # ================== -->
						</table>
						<!-- ====================================================== -->
						<div class="submitButton" align="center" style="font-size: larger; padding-left: 180px; ">
							<input type="submit" name="submit" value="完成訂位">
						</div>
						<div style="display: none;">
							<input type="hidden" name="adultsNum" value="${adultsNum}">
							<input type="hidden" name="childrenNum" value="${childrenNum}">
							<input type="hidden" name="amount" value="${amount}"> <input
								type="hidden" name="dateTime" value="${dateTime}"> <input
								type="hidden" name="time" value="${time}">
						</div>
						<br>
					</form>
					<div align="center" style="font-size: larger">${reservationCreateMsg}</div>
				</div>
			</div>
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
	<!-- ====================================================== -->
</body>
</html>
