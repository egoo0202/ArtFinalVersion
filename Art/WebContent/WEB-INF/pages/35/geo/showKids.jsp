<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CSR</title>
<style>
body {
	font-size: 20px;
	color: black;
}
.content, form {
	text-align: center;
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
					<h1 class="text-white">離我最近的活動</h1>
					<p class="text-white link-nav">
						<a href="index.html">Home </a> <span class="lnr lnr-arrow-right"></span>
						<a href="<c:url value='/35/randomRecom.ctrl' />">離我最近的活動</a>
					</p>
				</div>
			</div>
		</div>
	</section>
	<!-- End banner Area -->
	<div class="content">
		<br>
		<h1>
			<c:out value="${kidsLocation}" />
			一共有
			<c:out value="${kidsAmount}" />
			位孩童需要幫助
		</h1>
		<br>
		<h2>請關注需要幫助的孩童</h2>

	</div>
</body>
</html>