<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="google-signin-client_id"
	content="373238201778-gmsrplpti0mataeg48g47dm9g6rkeh09.apps.googleusercontent.com">
<title>忘記密碼</title>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<style>
body {
	font-size: 20px;
	color: black;
}
tr {
	text-align: left;
}

.errors {
	color: red;
	padding: 10px;
}

fieldset {
	text-align: center;
	width: 400px;
	margin: 0 auto;
	padding: 30px 0;
}

.forgotForm {
	margin: 0 auto;
}

.title {
	font-size: 40px;
	font-weight: 500;
}

.label {
	padding-top: 7px;
}

.forgotPwd {
	margin-top: 15px;
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
					<h1 class="text-white">忘記密碼</h1>
					<p class="text-white link-nav">
						<a href="index.html">Home </a> <span class="lnr lnr-arrow-right"></span>
						<a href="<c:url value='/35/forgotPwd' />">  忘記密碼</a>
					</p>
				</div>
			</div>
		</div>
	</section>
	<!-- End banner Area -->
	<br>
	<br>
	<fieldset>
		<legend class="title">忘記密碼</legend>
			<table class="forgotForm">
				<tr>
					<td><label class="label">帳號:</label></td>
					<td><input type="text" id="user" /></td>
					<td class="errors">${errors.user}</td>
				</tr>
				<tr>
					<td><label class="label">E-mail:</label></td>
					<td><input type="text" id="email"
							value="${password}" /></td>
					<td class="errors">${errors.emial}</td>
				</tr>
			</table>
		<!-- 		<button class="googleLogin genric-btn info radius">透過Google帳戶登入</button> -->
		<button class="forgotPwd genric-btn info radius" onclick=resetPwd()>重設密碼</button>
<!-- 		<button class="captcha genric-btn primary radius">登入</button> -->
	</fieldset>
	<!-- 	<div class="newImg"></div> -->

	<script
		src="https://www.google.com/recaptcha/api.js?render=6Lc_wOQZAAAAALKDlGGuMLE_iV-rjKJIYMHI9Fj6"></script>
	<script type="text/javascript">

		let resetPwd= () => {
			window.location.href="<c:url value='/35/resetPwd' />";
		}
	</script>
</body>
</html>