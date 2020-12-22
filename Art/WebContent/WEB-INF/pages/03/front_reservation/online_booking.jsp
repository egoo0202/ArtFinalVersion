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
	content: "※";
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

.wrapper-restaurant {
	width: 500px;
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
							得藝食堂</a>
					</p>
				</div>
			</div>
		</div>
	</section>
	<!-- End banner Area -->

	<div style="margin-left: 100px; margin-right: 100px;">
		<br>
		<div class=title>
			<h2 align="center" style="margin-top: 20px; margin-bottom: 40px;">得藝食堂</h2>
		</div>
		<div
			style="line-height: 30px; margin-left: 225px; margin-bottom: 35px;">
			<span style="font-size: 21px; font-weight: bold;"><span
				style="font-size: 26px; font-weight: bold; color: #1B9AAA;">得藝食堂&nbsp;</span>為AAART平台旗下經營，以精緻、高品質為經營理念的新品牌日式火鍋專賣店</span><br>
			<span style="font-size: 21px; font-weight: bold;">本店肉品特選日本頂級和牛、美國安格斯牛肉、澳洲羊小排與國產桂丁雞肉</span><br>
			<span style="font-size: 21px; font-weight: bold;">鮮蔬為依產季替換的十多種產地直送新鮮野菜及菇類，每日定時配送、即時處理</span><br>
			<span style="font-size: 21px; font-weight: bold;">湯底為獨家的柴魚昆布高湯，以北海道日高昆布與鹿兒島產柴魚熬煮而成，味道甘甜爽口</span><br>
			<span style="font-size: 21px; font-weight: bold;">甜品提供哈根達斯冰淇淋、GODIVA比利時巧克力、新鮮有機產地直送水果</span>
		</div>
		<div class="row">
			<div class="col-lg-8 col-md-8">
				<div style="width: 800px; font-size: larger; background: #FFFFFF;">
					<br> <br> <br>
					<div style="width: 780px; font-size: larger; background: #FFFFFF;">
						<div class="single-post">
							<img class="img-fluid"
								src="<c:url value='/images/03/shabu01.jpg'/>" alt="">
						</div>
						<div class="single-post">
							<img class="img-fluid"
								src="<c:url value='/images/03/dessert01.jpg'/>" alt="">
						</div>
						<div class="single-post">
							<img class="img-fluid"
								src="<c:url value='/images/03/shabu02.jpg'/>" alt="">
						</div>
					</div>
				</div>
			</div>
			<div class="col-lg-3 col-md-4 mt-sm-30">
				<div align="center" style="width: 500px;">
					<div class="submitButton" align="center"
						style="font-size: 20px; margin-bottom: 20px;">
						<a
							href="<c:url value="/03/front/reservation/chooseNumberAndDate"/>"
							class="genric-btn primary-border circle arrow"><span
							style="font-size: large; font-weight: bold;">立即預約</span> <span
							class="lnr lnr-arrow-right"></span></a>
					</div>
					<br>
					<div class=title></div>
					<table class="display table table-hover table-blue">
						<thead>
							<tr class="head">
								<th scope="col">
									<div class="custom-button" align="left"
										style="font-size: 21px; font-weight: bold; padding-bottom: 20px;">
										<h2 style="color: #1B9AAA;">&emsp;&emsp;用餐價格&nbsp;</h2>
									</div>
									<div style="padding-bottom: 30px;">
										<h3>
											<span style="font-weight: bold; padding-bottom: 30px;">本店全時段
												<span style="font-weight: bold; color: red;">均一價</span>
											</span>
										</h3>
									</div>
									<h3>
										大人&emsp;每位&nbsp;NT$<span
											style="font-size: 30px; font-weight: bold; color: red;">650</span>元
									</h3> <br>
									<h3>
										小孩&emsp;每位&nbsp;NT$<span
											style="font-size: 30px; font-weight: bold; color: red;">350</span>元
									</h3> <br>
									<div align="left">
										<h3>兒童&emsp;&emsp;&emsp;免費</h3>
									</div> <br> <br>
									<h3>
										<span class="rs-symbol-color" style="font-size: 30px;"></span>用餐時間&nbsp;2小時
									</h3> <br>
									<h3>
										<span class="rs-symbol-color" style="font-size: 30px;"></span>不額外收取服務費
									</h3> <br>
								</th>
							</tr>
							<tr class="head">
								<th scope="col">
									<div class="custom-button" align="left"
										style="font-size: 21px; font-weight: bold; padding-bottom: 20px;">
										<h2 style="color: #1B9AAA;">&emsp;&emsp;營業時間&nbsp;</h2>
									</div>

									<h3>週一至週五 平日：中午12點 - 晚間8點</h3> <br>
									<h3>週末及國定 假日：上午9點 - 晚間9點</h3> <br>
								</th>
							</tr>
							<tr class="head">
								<th scope="col">
									<div class="custom-button" align="left"
										style="font-size: 21px; font-weight: bold; padding-bottom: 20px;">
										<h2 style="color: #1B9AAA;">&emsp;&emsp;收費標準&nbsp;</h2>
									</div>
									<h3>130公分以上&nbsp;&nbsp;以大人價格計算</h3> <br>
									<h3>100公分以上&nbsp;&nbsp;以小孩價格計算</h3> <br>
									<h3>100公分以下&nbsp;&nbsp;兒童免費</h3> <br> <br> <br>
									<br> <br> <br> <br> <br> <br> <br>
								</th>
							</tr>
						</thead>
						<tbody></tbody>
						<tfoot></tfoot>
					</table>
				</div>
			</div>
		</div>
	</div>
</body>
<!-- ====================================================== -->
<script>
</script>
</html>
