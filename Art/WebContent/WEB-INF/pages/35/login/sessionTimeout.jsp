<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新的登入階段</title>
</head>
<style>
body {
	font-size: 20px;
	color: black;
}
.welcome {
	text-align: center;
}
</style>
<body>
	<!-- start banner Area -->
	<section class="banner-area relative" id="home">
		<div class="overlay overlay-bg"></div>
		<div class="container">
			<div class="row d-flex align-items-center justify-content-center">
				<div class="about-content col-lg-12">
					<h1 class="text-white">新的登入階段</h1>
					<p class="text-white link-nav">
						<a href="index.html">Home</a> <span
							class="lnr lnr-arrow-right"></span> <a href="<c:url value='/' />">新的登入階段
						</a>
					</p>
				</div>
			</div>
		</div>
	</section>
	<!-- End banner Area -->
	<div class="welcome">
		<br>
		<h1>開啟新的登入階段，請重新登入</h1>
		<br>
<!-- 		<h2>猜您想知道為什麼會逾期</h2> -->
<%-- 		<h2>因為session裡面沒有${sessionTimeoutToken}屬性</h2> --%>
	</div>
</body>
</html>