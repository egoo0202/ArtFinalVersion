<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>訂單成立</title>
<style type="text/css">
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
							<h1 class="text-white">
								AAART Shop
							</h1>	
							<p class="text-white link-nav"><a href="index.html">Home </a>  <span class="lnr lnr-arrow-right"></span>  <a href="<c:url value='/14/shopListController.ctrl' />"> Shop</a></p>
						</div>											
					</div>
				</div>
			</section>
	<!-- End banner Area -->
	
<div class="container">
<br><br><H1 class="text-center">訂單已成立</H1>
<P class="text-center">詳細訂單資訊已傳送至${sessionScope.email}</P>
<P class="text-center">訂單編號為${sessionScope.orderlistID}</P>
</div>
</body>
</html>