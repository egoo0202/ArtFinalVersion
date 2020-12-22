<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>註冊成功</title>
</head>
<style>
body {
	font-size: 20px;
	color: black;
}
.welcome, .content {
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
	<div class="welcome">
		<h1>${welcome}</h1>
	</div>
	<br>
	<div class="content">
		<h1>您可能會想逛逛的活動</h1>
	</div>
	<br>
	<br>
	<div class="content">
		<c:forEach var="recommend" items="${recommend}">
			<c:set var="addr"
				value="${recommend.city.concat(recommend.district).concat(recommend.address)}" />
			<h3>${recommend.title}</h3>
			<h5>時間: ${recommend.time}</h5>
			<iframe width="100%" height="280" frameborder="0"
				src="https://www.google.com/maps?q=${addr}&output=embed"></iframe>
			<%-- 		${addr}前兩條斜線，中間是使用者位置 --%>
			<%-- 		<a href="https://www.google.com.tw/maps/dir//${addr}">導航網頁版</a> --%>
			<input class="genric-btn primary radius" type="button"
				onclick="navigate(this.id)" id="${addr}" value="幫我導航">
			<div>
				<br>
			</div>
		</c:forEach>
	</div>
	<script type="text/javascript">

	let navigate = addr => {
		fetch("<c:url value='/35/navigate/' />"+addr, {
			method: 'GET'}
		).then(response => {
			if (response.ok){
				response.text().then(message => {	
// 					message就是回傳後轉形成text的回應內容，這時候創元素變數名稱
					let navigateButton = document.getElementById(addr);
					let navigateImg = document.createElement('img');
// 					Button後方插入元素
					navigateButton.insertAdjacentElement("afterend", navigateImg);
// 					插入圖片屬性
					navigateImg.src="data:image/png;base64, " + message;
					navigateImg.style.margin="0 auto";
					navigateImg.style.display = "block";
					navigateImg.style.width = "400px";
					navigateImg.style.height = "400px";					
				});	
			}
// 		.then()沒回傳promise物件成功的結果時，會跳到此catch
		}).catch();
	}

	</script>
</body>
</html>