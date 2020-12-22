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
td {
	font-size: 20px;
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
		</div>
		<p>加上輪播圖片</p>
		<div class=title>
			<h3 align="center" style="margin-top: 20px;">請選擇用餐時段</h3>
		</div>
		<br>
		<div class="title">
			<table id="03A" class="display table table-hover table-blue">
				<thead>
					<tr class="head">
						<th scope="col" width="150px">
							<div class="custom-button" style="background-color: #FAD689">用餐人數</div>
						</th>
						<th scope="col" style="font-size: larger;" width="150px">
							<div class="custom-button"
								style="background-color: #FFFFFF; font-weight: normal;">
								${amount}&nbsp;位</div>
						</th>
						<!-- #================= -->
						<th scope="col" width="150px">
							<div class="custom-button" style="background-color: #A5DEE4">用餐日期</div>
						</th>
						<th scope="col" style="font-size: larger;" width="200px">
							<div class="custom-button"
								style="background-color: #FFFFFF; font-weight: normal;">
								${dateTime}</div>
						</th>
						<!-- #================= -->
						<th scope="col" width="150px">
							<div class="custom-button" style="background-color: #F596AA">用餐時段</div>
						</th>
						<!-- #================= -->
						<th scope="col" style="font-size: larger;">
							<div class="custom-button"
								style="background-color: #FFFFFF; font-weight: normal;">
								<span id="moment">尚未選擇</span><span id="result"></span>
							</div>
						</th>
					</tr>
				</thead>
				<tbody></tbody>
				<tfoot></tfoot>
			</table>
			<c:if test="${reservationErrorMsg == null}">
				<div class=title>
					<h3 align="center" style="margin-top: 20px;">用餐時段</h3>
				</div>
			</c:if>
			<c:if test="${reservationErrorMsg != null}">
				<div class=title style="font-size: larger">
					<h3 align="center" style="margin-top: 20px;">本日非營業時間&nbsp;&nbsp;造成不便之處敬請見諒</h3>
				</div>
			</c:if>
			<br>
			<div class="container">
				<table id="03B" class="display table table-hover table-blue">
					<thead>
					</thead>
					<tfoot></tfoot>
					<tbody>
						<tr>
							<td><c:if test="${H09 != null}">
									<button id="t09" class="genric-btn primary radius"
										style="line-height: 30px; width: 168px;">
										<span style="font-size: 20px;">9:00</span><br> <span>剩餘&nbsp;${H09}個座位</span>
									</button>
								</c:if> <c:if test="${H09Full != null}">
									<button class="genric-btn info-border radius"
										style="line-height: 30px; width: 168px;">
										<span style="font-size: 20px;">9:00</span><br> <span>${H09Full}</span>
									</button>
								</c:if> <c:if test="${H09Over != null}">
									<button class="genric-btn info radius"
										style="line-height: 30px; width: 168px;">
										<span style="font-size: 20px;">9:00</span><br> <span>${H09Over}</span>
									</button>
								</c:if> <c:if test="${H09Close != null}">
									<button class="genric-btn danger-border radius"
										style="line-height: 30px; width: 168px;">
										<span style="font-size: 20px;">09:00</span><br> <span>${H09Close}</span>
									</button>
								</c:if> <!-- ====================================================== -->
								<c:if test="${H10 != null}">
									<button id="t10" class="genric-btn primary radius"
										style="line-height: 30px; width: 168px;">
										<span style="font-size: 20px;">10:00</span><br> <span>剩餘&nbsp;${H10}個座位</span>
									</button>
								</c:if> <c:if test="${H10Full != null}">
									<button class="genric-btn info-border radius"
										style="line-height: 30px; width: 168px;">
										<span style="font-size: 20px;">10:00</span><br> <span>${H10Full}</span>
									</button>
								</c:if> <c:if test="${H10Over != null}">
									<button class="genric-btn info radius"
										style="line-height: 30px; width: 168px;">
										<span style="font-size: 20px;">10:00</span><br> <span>${H10Over}</span>
									</button>
								</c:if> <c:if test="${H10Close != null}">
									<button class="genric-btn danger-border radius"
										style="line-height: 30px; width: 168px;">
										<span style="font-size: 20px;">10:00</span><br> <span>${H10Close}</span>
									</button>
								</c:if> <!-- ====================================================== -->
								<c:if test="${H11 != null}">
									<button id="t11" class="genric-btn primary radius"
										style="line-height: 30px; width: 168px;">
										<span style="font-size: 20px;">11:00</span><br> <span>剩餘&nbsp;${H11}個座位</span>
									</button>
								</c:if> <c:if test="${H11Full != null}">
									<button class="genric-btn info-border radius"
										style="line-height: 30px; width: 168px;">
										<span style="font-size: 20px;">11:00</span><br> <span>${H11Full}</span>
									</button>
								</c:if> <c:if test="${H11Over != null}">
									<button class="genric-btn info radius"
										style="line-height: 30px; width: 168px;">
										<span style="font-size: 20px;">11:00</span><br> <span>${H11Over}</span>
									</button>
								</c:if> <c:if test="${H11Close != null}">
									<button class="genric-btn danger-border radius"
										style="line-height: 30px; width: 168px;">
										<span style="font-size: 20px;">11:00</span><br> <span>${H11Close}</span>
									</button>
								</c:if> <!-- ====================================================== -->
								<c:if test="${H12 != null}">
									<button id="t12" class="genric-btn primary radius"
										style="line-height: 30px; width: 168px;">
										<span style="font-size: 20px;">12:00</span><br> <span>剩餘&nbsp;${H12}個座位</span>
									</button>
								</c:if> <c:if test="${H12Full != null}">
									<button class="genric-btn info-border radius"
										style="line-height: 30px; width: 168px;">
										<span style="font-size: 20px;">12:00</span><br> <span>${H12Full}</span>
									</button>
								</c:if> <c:if test="${H12Over != null}">
									<button class="genric-btn info radius"
										style="line-height: 30px; width: 168px;">
										<span style="font-size: 20px;">12:00</span><br> <span>${H12Over}</span>
									</button>
								</c:if> <c:if test="${H12Close != null}">
									<button class="genric-btn danger-border radius"
										style="line-height: 30px; width: 168px;">
										<span style="font-size: 20px;">12:00</span><br> <span>${H12Close}</span>
									</button>
								</c:if> <!-- ====================================================== -->
								<c:if test="${H13 != null}">
									<button id="t13" class="genric-btn primary radius"
										style="line-height: 30px; width: 168px;">
										<span style="font-size: 20px;">13:00</span><br> <span>剩餘&nbsp;${H13}個座位</span>
									</button>
								</c:if> <c:if test="${H13Full != null}">
									<button class="genric-btn info-border radius"
										style="line-height: 30px; width: 168px;">
										<span style="font-size: 20px;">13:00</span><br> <span>${H13Full}</span>
									</button>
								</c:if> <c:if test="${H13Over != null}">
									<button class="genric-btn info radius"
										style="line-height: 30px; width: 168px;">
										<span style="font-size: 20px;">13:00</span><br> <span>${H13Over}</span>
									</button>
								</c:if> <c:if test="${H13Close != null}">
									<button class="genric-btn danger-border radius"
										style="line-height: 30px; width: 168px;">
										<span style="font-size: 20px;">13:00</span><br> <span>${H13Close}</span>
									</button>
								</c:if> <!-- ====================================================== -->
								<c:if test="${H14 != null}">
									<button id="t14" class="genric-btn primary radius"
										style="line-height: 30px; width: 168px;">
										<span style="font-size: 20px;">14:00</span><br> <span>剩餘&nbsp;${H14}個座位</span>
									</button>
								</c:if> <c:if test="${H14Full != null}">
									<button class="genric-btn info-border radius"
										style="line-height: 30px; width: 168px;">
										<span style="font-size: 20px;">14:00</span><br> <span>${H14Full}</span>
									</button>
								</c:if> <c:if test="${H14Over != null}">
									<button class="genric-btn info radius"
										style="line-height: 30px; width: 168px;">
										<span style="font-size: 20px;">14:00</span><br> <span>${H14Over}</span>
									</button>
								</c:if> <c:if test="${H14Close != null}">
									<button class="genric-btn danger-border radius"
										style="line-height: 30px; width: 168px;">
										<span style="font-size: 20px;">14:00</span><br> <span>${H14Close}</span>
									</button>
								</c:if></td>
						</tr>
						<!-- ====================================================== -->
						<tr>
							<td><c:if test="${H15 != null}">
									<button id="t15" class="genric-btn primary radius"
										style="line-height: 30px; width: 168px;">
										<span style="font-size: 20px;">15:00</span><br> <span>剩餘&nbsp;${H15}個座位</span>
									</button>
								</c:if> <c:if test="${H15Full != null}">
									<button class="genric-btn info-border radius"
										style="line-height: 30px; width: 168px;">
										<span style="font-size: 20px;">15:00</span><br> <span>${H15Full}</span>
									</button>
								</c:if> <c:if test="${H15Over != null}">
									<button class="genric-btn info radius"
										style="line-height: 30px; width: 168px;">
										<span style="font-size: 20px;">15:00</span><br> <span>${H15Over}</span>
									</button>
								</c:if> <c:if test="${H15Close != null}">
									<button class="genric-btn danger-border radius"
										style="line-height: 30px; width: 168px;">
										<span style="font-size: 20px;">15:00</span><br> <span>${H15Close}</span>
									</button>
								</c:if> <!-- ====================================================== -->
								<c:if test="${H16 != null}">
									<button id="t16" class="genric-btn primary radius"
										style="line-height: 30px; width: 168px;">
										<span style="font-size: 20px;">16:00</span><br> <span>剩餘&nbsp;${H16}個座位</span>
									</button>
								</c:if> <c:if test="${H16Full != null}">
									<button class="genric-btn info-border radius"
										style="line-height: 30px; width: 168px;">
										<span style="font-size: 20px;">16:00</span><br> <span>${H16Full}</span>
									</button>
								</c:if> <c:if test="${H16Over != null}">
									<button class="genric-btn info radius"
										style="line-height: 30px; width: 168px;">
										<span style="font-size: 20px;">16:00</span><br> <span>${H16Over}</span>
									</button>
								</c:if> <c:if test="${H16Close != null}">
									<button class="genric-btn danger-border radius"
										style="line-height: 30px; width: 168px;">
										<span style="font-size: 20px;">16:00</span><br> <span>${H16Close}</span>
									</button>
								</c:if> <!-- ====================================================== -->
								<c:if test="${H17 != null}">
									<button id="t17" class="genric-btn primary radius"
										style="line-height: 30px; width: 168px;">
										<span style="font-size: 20px;">17:00</span><br> <span>剩餘&nbsp;${H17}個座位</span>
									</button>
								</c:if> <c:if test="${H17Full != null}">
									<button class="genric-btn info-border radius"
										style="line-height: 30px; width: 168px;">
										<span style="font-size: 20px;">17:00</span><br> <span>${H17Full}</span>
									</button>
								</c:if> <c:if test="${H17Over != null}">
									<button class="genric-btn info radius"
										style="line-height: 30px; width: 168px;">
										<span style="font-size: 20px;">17:00</span><br> <span>${H17Over}</span>
									</button>
								</c:if> <c:if test="${H17Close != null}">
									<button class="genric-btn danger-border radius"
										style="line-height: 30px; width: 168px;">
										<span style="font-size: 20px;">17:00</span><br> <span>${H17Close}</span>
									</button>
								</c:if> <!-- ====================================================== -->
								<c:if test="${H18 != null}">
									<button id="t18" class="genric-btn primary radius"
										style="line-height: 30px; width: 168px;">
										<span style="font-size: 20px;">18:00</span><br> <span>剩餘&nbsp;${H18}個座位</span>
									</button>
								</c:if> <c:if test="${H18Full != null}">
									<button class="genric-btn info-border radius"
										style="line-height: 30px; width: 168px;">
										<span style="font-size: 20px;">18:00</span><br> <span>${H18Full}</span>
									</button>
								</c:if> <c:if test="${H18Over != null}">
									<button class="genric-btn info radius"
										style="line-height: 30px; width: 168px;">
										<span style="font-size: 20px;">18:00</span><br> <span>${H18Over}</span>
									</button>
								</c:if> <c:if test="${H18Close != null}">
									<button class="genric-btn danger-border radius"
										style="line-height: 30px; width: 168px;">
										<span style="font-size: 20px;">18:00</span><br> <span>${H18Close}</span>
									</button>
								</c:if> <!-- ====================================================== -->
								<c:if test="${H19 != null}">
									<button id="t19" class="genric-btn primary radius"
										style="line-height: 30px; width: 168px;">
										<span style="font-size: 20px;">19:00</span><br> <span>剩餘&nbsp;${H19}個座位</span>
									</button>
								</c:if> <c:if test="${H19Full != null}">
									<button class="genric-btn info-border radius"
										style="line-height: 30px; width: 168px;">
										<span style="font-size: 20px;">19:00</span><br> <span>${H19Full}</span>
									</button>
								</c:if> <c:if test="${H19Over != null}">
									<button class="genric-btn info radius"
										style="line-height: 30px; width: 168px;">
										<span style="font-size: 20px;">19:00</span><br> <span>${H19Over}</span>
									</button>
								</c:if> <c:if test="${H19Close != null}">
									<button class="genric-btn danger-border radius"
										style="line-height: 30px; width: 168px;">
										<span style="font-size: 20px;">19:00</span><br> <span>${H19Close}</span>
									</button>
								</c:if> <!-- ====================================================== -->
								<c:if test="${H20 != null}">
									<button id="t20" class="genric-btn primary radius"
										style="line-height: 30px; width: 168px;">
										<span style="font-size: 20px;">20:00</span><br> <span>剩餘&nbsp;${H20}個座位</span>
									</button>
								</c:if> <c:if test="${H20Full != null}">
									<button class="genric-btn info-border radius"
										style="line-height: 30px; width: 168px;">
										<span style="font-size: 20px;">20:00</span><br> <span>${H20Full}</span>
									</button>
								</c:if> <c:if test="${H20Over != null}">
									<button class="genric-btn info radius"
										style="line-height: 30px; width: 168px;">
										<span style="font-size: 20px;">20:00</span><br> <span>${H20Over}</span>
									</button>
								</c:if> <c:if test="${H20Close != null}">
									<button class="genric-btn danger-border radius"
										style="line-height: 30px; width: 168px;">
										<span style="font-size: 20px;">20:00</span><br> <span>${H20Close}</span>
									</button>
								</c:if> <!-- ====================================================== -->
							</td>
						</tr>
						<!-- ====================================================== -->
						<tr>
							<td><c:if test="${H21 != null}">
									<button id="t21" class="genric-btn primary radius"
										style="line-height: 30px; width: 168px;">
										<span style="font-size: 20px;">21:00</span><br> <span>剩餘&nbsp;${H21}個座位</span>
									</button>
								</c:if> <c:if test="${H21Full != null}">
									<button class="genric-btn info-border radius"
										style="line-height: 30px; width: 168px;">
										<span style="font-size: 20px;">21:00</span><br> <span>${H21Full}</span>
									</button>
								</c:if> <c:if test="${H21Over != null}">
									<button class="genric-btn info radius"
										style="line-height: 30px; width: 168px;">
										<span style="font-size: 20px;">21:00</span><br> <span>${H21Over}</span>
									</button>
								</c:if> <c:if test="${H21Close != null}">
									<button class="genric-btn danger-border radius"
										style="line-height: 30px; width: 168px;">
										<span style="font-size: 20px;">21:00</span><br> <span>${H21Close}</span>
									</button>
								</c:if> <!-- ====================================================== -->
							</td>
						</tr>
					</tbody>
				</table>
				<!-- ====================================================== -->
				<br>
				<form method="post"
					action="<c:url value = "/03/front/reservation/createReservationConfirm.ctrl"/>">
					<div style="display: none">
						<input type="hidden" name="adultsNum" value="${adultsNum}">
						<input type="hidden" name="childrenNum" value="${childrenNum}">
						<input type="hidden" name="dateTime" value="${dateTime}">
						<input type="hidden" name="amount" value="${amount}"> <input
							type="hidden" name="year" value="${restaurant.year}"> <input
							type="hidden" name="month" value="${restaurant.month}"> <input
							type="hidden" name="day" value="${restaurant.day}">
					</div>
					<div style="display: none">
						<input type="hidden" id="gainTime" name="time" value="">
					</div>
					<br>
					<c:if test="${reservationErrorMsg == null}">
						<div class="submitButton" align="center" style="font-size: larger">
							<input type="submit" name="submit" value="下一步，填寫聯絡資訊">
						</div>
					</c:if>
					<br>
				</form>
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
	<script>
		$("#t09").click(function() {
			$("#moment").hide();
			var mealtime = "09:00";
			$("#result").text("9:00");
			$("#gainTime").val(mealtime);
		});
		$("#t10").click(function() {
			$("#moment").hide();
			var mealtime = "10:00";
			$("#result").text(mealtime);
			$("#gainTime").val(mealtime);
		});
		$("#t11").click(function() {
			$("#moment").hide();
			var mealtime = "11:00";
			$("#result").text(mealtime);
			$("#gainTime").val(mealtime);
		});
		$("#t12").click(function() {
			$("#moment").hide();
			var mealtime = "12:00";
			$("#result").text(mealtime);
			$("#gainTime").val(mealtime);
		});
		$("#t13").click(function() {
			$("#moment").hide();
			var mealtime = "13:00";
			$("#result").text(mealtime);
			$("#gainTime").val(mealtime);
		});
		$("#t14").click(function() {
			$("#moment").hide();
			var mealtime = "14:00";
			$("#result").text(mealtime);
			$("#gainTime").val(mealtime);
		});
		$("#t15").click(function() {
			$("#moment").hide();
			var mealtime = "15:00";
			$("#result").text(mealtime);
			$("#gainTime").val(mealtime);
		});
		$("#t16").click(function() {
			$("#moment").hide();
			var mealtime = "16:00";
			$("#result").text(mealtime);
			$("#gainTime").val(mealtime);
		});
		$("#t17").click(function() {
			$("#moment").hide();
			var mealtime = "17:00";
			$("#result").text(mealtime);
			$("#gainTime").val(mealtime);
		});
		$("#t18").click(function() {
			$("#moment").hide();
			var mealtime = "18:00";
			$("#result").text(mealtime);
			$("#gainTime").val(mealtime);
		});
		$("#t19").click(function() {
			$("#moment").hide();
			var mealtime = "19:00";
			$("#result").text(mealtime);
			$("#gainTime").val(mealtime);
		});
		$("#t20").click(function() {
			$("#moment").hide();
			var mealtime = "20:00";
			$("#result").text(mealtime);
			$("#gainTime").val(mealtime);
		});
		$("#t21").click(function() {
			$("#moment").hide();
			var mealtime = "21:00";
			$("#result").text(mealtime);
			$("#gainTime").val(mealtime);
		});
	</script>
</body>
<!-- ====================================================== -->
</html>