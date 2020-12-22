<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>註冊成為會員</title>
</head>
<style>
body {
	font-size: 20px;
	color: black;
}
tr {
	text-align: left;
}

.emailMsg {
	color: red;
	padding-bottom: 15px;
	padding-top: 30px;
	font-size: 22px;
}

fieldset {
	width: 800px;
	margin: 0 auto;
}

.registerForm {
	margin: 0 auto;
}

.goCenter {
	text-align: center;
}

.title {
	font-size: 40px;
	font-weight: 500;
}
</style>
<body>
	<!-- start banner Area -->
	<section class="banner-area relative" id="home">
		<div class="overlay overlay-bg"></div>
		<div class="container">
			<div class="row d-flex align-items-center justify-content-center">
				<div class="about-content col-lg-12">
					<h1 class="text-white">Register</h1>
					<p class="text-white link-nav">
						<a href="index.html">Home </a> <span class="lnr lnr-arrow-right"></span>
						<a href="<c:url value='/35/registerEntry' />"> Register</a>
					</p>
				</div>
			</div>
		</div>
	</section>
	<!-- End banner Area -->
	<br>
	<br>
	<fieldset>
		<legend class="goCenter title">得藝的一天，即將開始</legend>
			<table class="registerForm">
				<tr>
					<td colspan="2" class="emailMsg">${emailMsg}</td>
				</tr>
			</table>
	</fieldset>
</body>
</html>