<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://unpkg.com/@webcreate/infinite-ajax-scroll/dist/infinite-ajax-scroll.min.js"></script>
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
					<a href="index.html">Home </a> <span class="lnr lnr-arrow-right"></span>
					<a href="<c:url value='/14/shopListController.ctrl' />"> Shop</a> <span
						class="lnr lnr-arrow-right"></span> <span>${oneProsuct.productTitle}</span>
				</p>
			</div>
		</div>
	</div>
</section>
<!-- End banner Area -->
<button class="genric-btn primary radius" onclick="getStar()">Primary</button>

<script type="text/javascript">
// $(document).ready(function () {
//     var loading = false;
//     $(window).scroll(function () {
//         if ((($(window).scrollTop() + $(window).height()) + 50) >= $(document).height()) {
//             if (loading == false) {
//                 loading = true;
//                 // 			$('#loadingBar').css("display","block");
//                 $.get("${pageContext.servletContext.contextPath}/14/trytrysee", function (loaded) {
//                     $('body').append(loaded);
//                     // 				$('#loadingBar').css("display","none");
//                     loading = false;
//                 });

//             }

//         }

//     })



// })
	




</script>
</body>
</html>