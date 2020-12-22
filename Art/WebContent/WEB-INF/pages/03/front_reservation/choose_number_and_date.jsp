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
.fa-palette {
	color: #1b9aaa;
}

.fa-store-alt {
	color: #1b9aaa;
}

.fa-map-marked-alt {
	color: #1b9aaa;
}

.wrapper-restaurant {
	width: 330px;
	height: 200px;
	overflow: hidden;
	margin: 0 auto;
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
			<h3 align="center" style="margin-top: 20px;">請選擇用餐人數與日期</h3>
		</div>
		<br>
		<div class=content style="font-size: larger;">
			<form method="post"
				action="<c:url value="/03/front/reservation/chooseTime.ctrl"/>">
				<table id="03" class="display table table-hover table-blue">
					<thead>
						<tr class="head">
							<th scope="col" colspan="4"
								style="font-size: 24px; color: #0B1013; background-color: #FAD689">用餐人數</th>
							<th scope="col" colspan="1"
								style="font-size: 24px; color: #0B1013; background-color: #A5DEE4">用餐日期</th>
						</tr>
					</thead>
					<tbody>
						<tr class="table-secondary">
							<td style="font-size: 22px; color: #0B1013; font-weight: bold;  vertical-align: middle;">請選擇大人人數:</td>
							<td>
								<div>
									<select id="adultsNum" name="adultsNum" class="form-control" 
										style="font-size: 22px; height: 50px; line-height: 50px;"
										required="required">
										<option value="1">1位大人</option>
										<option value="2">2位大人</option>
										<option value="3">3位大人</option>
										<option value="4">4位大人</option>
										<option value="5">5位大人</option>
									</select>
								</div>
							</td>
							<td style="font-size: 22px; color: #0B1013; font-weight: bold;  vertical-align: middle;">請選擇小孩人數:</td>
							<td>
								<div>
									<select id="childrenNum" name="childrenNum"
										class="form-control"
										style="font-size: 22px; line-height: 50px; height: 50px"
										required="required">
										<option value="0">0位小孩</option>
										<option value="1">1位小孩</option>
										<option value="2">2位小孩</option>
										<option value="3">3位小孩</option>
										<option value="4">4位小孩</option>
										<option value="5">5位小孩</option>
									</select>
								</div>
							</td>
							<td><div><input type="date"
								style="font-size: 21px; line-height: 30px;  vertical-align: middle;" name="dateTime"
								id="dateTime" value="2020-12-25" class="form-control"
								min="2020-12-25" max="2021-01-24" required="required"></div></td>
						</tr>
					</tbody>
				</table>
				<br>
				<div class="submitButton" align="center"
					style="font-size: 24px; font-weight: bold;  vertical-align: middle;">
					<input type="submit" name="submit"
						style="font-size: 24px; font-weight: bold;"
						class="genric-btn primary-border radius" value="下一步，選擇用餐時段">
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