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
.ellipsis {
	/* 行數設定 */
	overflow: hidden;
	text-overflow: ellipsis;
	display: -webkit-box;
	-webkit-line-clamp: 5;
	-webkit-box-orient: vertical;
	white-space: normal;
}

.p1 {
	white-space: pre-wrap;
	font-size: 21px;
	font-weight: bold;
}

.p2 {
	white-space: pre-wrap;
	font-size: 18px;
	font-weight: bold;
}

.a1 {
	padding: 20px 20px 20px 20px;
	background: #f9f9ff;
	border-left: 2px solid #1b9aaa;
}

.rs-symbol-color::after {
	content: "*";
	margin-left: 3px;
	font-weight: 800;
	color: rgb(203, 64, 66);
	margin-left: 3px;
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
						<a href="<c:url value='/03/index/shop/index.ctrl' />">藝文商店</a>
					</p>
				</div>
			</div>
		</div>
	</section>
	<!-- End banner Area -->

	<!-- Start blog-posts Area -->
	<div class="container">
		<br> <br>
		<div class="content">
			<div class="mb-10" align="center">
				<h2>藝文商店</h2>
			</div>
		</div>
		<br> <br>
		<div class="row">

			<!-- left block -->
			<div class="col-lg-8 post-list blog-post-list">
				<div class="single-post">
					<h1 style="color: #1B9AAA; padding-left: 20px;">${shop.shopName}</h1>
					<div class="content-wrap" style="padding: 20px 20px 20px 20px;">

<%-- 						<img src="${shop.image}" alt="" style="padding-bottom: 30px;"> --%>
						<img src="data:image/jpg;base64,${shop.base64Image}"  alt="" style="padding-bottom: 30px;">
						
						<p class="p1">${shop.intro}</p>

					</div>
					<div class="bottom-meta">
						<div class="user-details row align-items-center">
							<div class="comment-wrap col-lg-6 col-sm-6"
								style="font-size: 18px;">
								<ul>
									<li><a href="#"><span class="lnr lnr-heart"></span>
											&nbsp;${shop.clicks}&nbsp;likes</a></li>
								</ul>
							</div>
							<div class="social-wrap col-lg-6" style="font-size: 22px;">
								<ul>
									<li><a href="${shop.facebook}"><i class="fa"><img
												src="<c:url value='/images/03/Facebook.png'/>"></i></a></li>
									<li>&nbsp;</li>
									<li><a href="${shop.website}"><i class="fa"><img
												src="<c:url value='/images/03/WebPage.png'/>"></i></a></li>
									<li>&nbsp;</li>
									<li>&nbsp;</li>
								</ul>

							</div>
						</div>
					</div>
				</div>
			</div>

			<!-- right block -->
			<div class="col-lg-4 sidebar">

				<div class="single-widget search-widget">
					<form class="example" method="post"
						action="<c:url value = "/03/index/shop/searchShopByName.ctrl"/>"
						style="margin: auto; max-width: 300px">
						<input type="text" name="shopName" placeholder="請輸入藝文商店名稱">
						<button type="submit">
							<i class="fa fa-search"></i>
						</button>
					</form>
				</div>

				<!-- 營業資訊 -->
				<h3 style="color: #1B9AAA; padding-bottom: 10px;" align="center">營業資訊</h3>
				<div class="single-widget protfolio-widget"
					style="padding: 20px 10px 10px 25px;">
					<div align="left">
						<span class="p1" style="color: #1B9AAA; padding-bottom: 20px">營業時間</span><br>
						<p class="p2">${shop.openTime}</p>

						<span class="p1" style="color: #1B9AAA; padding-bottom: 20px">地址</span><br>
						<p class="p2">${shop.address}</p>

						<span class="p1" style="color: #1B9AAA; padding-bottom: 20px">連絡電話</span><br>
						<p class="p2">${shop.phone}</p>

						<c:if test="${shop.fax != null}">
							<span class="p1" style="color: #1B9AAA; padding-bottom: 20px">傳真號碼</span>
							<br>
							<p class="p2">${shop.fax}</p>
						</c:if>

						<c:if test="${shop.email != null}">
							<span class="p1" style="color: #1B9AAA; padding-bottom: 20px">電子郵件</span>
							<br>
							<p class="p2">${shop.email}</p>
						</c:if>
						<span> <a href="${shop.facebook}"><i class="fa"><img
									src="<c:url value='/images/03/Facebook.png'/>"></i></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a
							href="${shop.website}"><i class="fa"><img
									src="<c:url value='/images/03/WebPage.png'/>"></i></a></span>



					</div>
				</div>

				<!-- 插入google 地圖 -->
				<h3 style="color: #1B9AAA; padding-bottom: 10px;" align="center">地圖</h3>
				<div class="single-widget protfolio-widget"
					style="padding: 10px 10px 10px 10px;">
					<iframe width="100%" height="320px" frameborder="0"
						src="https://www.google.com/maps?q=${shop.address}&output=embed">
					</iframe>
					<%-- 					<iframe width="100%" height="250" frameborder="0" src="https://www.google.com/maps?q=${site}&output=embed"></iframe> --%>

				</div>

				<!-- 商店網站-->
				<c:if test="${shop.website != null}">
					<h3 style="color: #1B9AAA; padding-bottom: 10px;" align="center">商店網站</h3>
					<div class="single-widget protfolio-widget"
						style="padding: 10px 10px 10px 10px;">
						<iframe width="100%" height="320px" frameborder="0"
							src="${shop.website}"> </iframe>
					</div>
				</c:if>


			</div>
		</div>
	</div>
	<!-- End blog-posts Area -->




</body>
<!-- ====================================================== -->
<script>
	$(document).ready(function() {
		$('#03').DataTable({});
	});
</script>
</html>