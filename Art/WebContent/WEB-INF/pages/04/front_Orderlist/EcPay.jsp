<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>得藝的一天感謝您的蒞臨</title>
<style>
div {
	text-align:center;
}
p{
	font-size:28px;
}
</style>
</head>
<body style="background:#FFFFFF;">
<c:set var="funcName" value="END" scope="session"/>
<!-- start banner Area -->
<section class="banner-area relative" id="home">
	<div class="overlay overlay-bg"></div>
	<div class="container">
		<div class="row d-flex align-items-center justify-content-center">
			<div class="about-content col-lg-12">
				<h1 class="text-white">AAART Shop</h1>
				<p class="text-white link-nav">
					<a href="index.html">Home </a> <span class="lnr lnr-arrow-right"></span>
					<a href="<c:url value='/14/shopListController.ctrl' />"> Shop</a> <span
						class="lnr lnr-arrow-right"></span> <span>${oneProsuct.productTitle}</span>
				</p>
			</div>
		</div>
	</div>
</section>
<!-- End banner Area -->
<div>
${form}
</div>
</body>
</html>