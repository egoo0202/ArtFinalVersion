<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>search shop</title>
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

.border-color-change {
	border-style: solid;
	border-color: #FFFFFF;
	border-width: 5px;
	padding-top: 10px;
	padding-right: 10px;
	padding-bottom: 10px;
	padding-left: 10px;
	padding-top: 10px;
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
	<div class="container">
		<br> <br>
		<div class="content">
			<div class="mb-10" align="center">
				<h2>藝文商店</h2>
			</div>
		</div>
		<br>
		<c:if test="${acShopsSerachMsg != null}">
			<div align="center" style="font-size: larger">${acShopsSerachMsg}</div>
		</c:if>
		<c:if test="${shopsList != null}">
			<div>
				<form method="post"
					action="<c:url value = "/03/index/shop/searchShopByName.ctrl"/>">
					<div class="submitButton" align="center"
						style="font-size: larger; font-weight: bold;">
						<table>
							<tr>
								<td><input type="text" class="single-input" name="shopName"
									placeholder="請輸入藝文商店名稱" style="width: 300px"></td>
								<td>&nbsp;</td>
								<td><input class="genric-btn primary radius" type="submit"
									style="font-size: 18px;" name="submit" value="搜尋"></td>
							</tr>
						</table>
					</div>
				</form>
			</div>
			<br>
			<br>
			<div class="row d-flex justify-content-center">
				<div class="row">
					<c:forEach items="${shopsList}" var="shop" varStatus="vs">
						<a
							href="<c:url value='/03/index/shop/shopDetails.ctrl?shopId=${shop.shopId}'/> ">
							<div class="col-lg-3 col-md-6 single-blog">
								<div class="border-color-change">
									<div class="thumb">
<%-- 										<img class="img-fluid" src="${shop.image}"> --%>
										<img class="img-fluid" src="data:image/jpg;base64,${shop.base64Image}">
									</div>
									<br> <a
										href="<c:url value='/03/index/shop/shopDetails.ctrl?shopId=${shop.shopId}'/> "><h4>${shop.shopName}</h4></a>
									<p class="ellipsis">${shop.intro}</p>
									<span class="lnr lnr-heart"></span> ${shop.clicks} Likes
								</div>
							</div>
						</a>
					</c:forEach>
				</div>
			</div>
		</c:if>
	</div>
</body>

<!-- ====================================================== -->
<script>
	$('.border-color-change').on('mouseover', function(e) {
		$(this).css('border-color', '#1B9AAA');
	});
	$('.border-color-change').on('mouseout', function(e) {
		$(this).css('border-color', '#FFFFFF');
		;
	});

	
	// 	$(".genric-btn primary radius").click(function() {
	// 		$("#moment").remove();
	// 		$("#result").text($(this).val());
	// 		$("#gainTime").val(value);
	// 	});
</script>
</html>