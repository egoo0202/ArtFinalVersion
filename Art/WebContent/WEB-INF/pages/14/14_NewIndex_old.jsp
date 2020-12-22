<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>



<script src="https://code.jquery.com/jquery-3.5.1.min.js"
        integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0=" crossorigin="anonymous"></script>

 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>


<body>


	<!-- start banner Area -->
			<section class="banner-area relative" id="home">	
				<div class="overlay overlay-bg"></div>
				<div class="container">
					<div class="row d-flex align-items-center justify-content-center">
						<div class="about-content col-lg-12">
							<h1 class="text-white">
								得藝洋行
							</h1>	
							<p class="text-white link-nav"><a href="index.html">首頁 </a>  <span class="lnr lnr-arrow-right"></span>  <a href="<c:url value='/14/shopListController.ctrl' />"> 洋行</a></p>
						</div>											
					</div>
				</div>
			</section>
	<!-- End banner Area -->	

	
	<c:choose>
    <c:when test='${! empty queryList }'>
	<section class="upcoming-exibition-area section-gap justify-content-center" style="padding: 0px; padding-top:20px">
				<div class="container">

					<div class="row d-flex justify-content-center">
						<div class="menu-content col-lg-8" >
							<div class="title text-center">
								<h2 class="mb-2">"All the products are a piece of art."</h2>
								<p>得藝的一天，從下單開始</p>
							</div>
						</div>
					</div>
			<div class="row d-flex justify-content-center" style="text-align: center;">
				<div class="default-select mb-10" id="default-select">
<!-- 					<select  onchange="self.location.href=options[selectedIndex].value"> -->
<!-- 						<option value="http://www.baidu.com" disabled selected>商品分類</option> -->
<!-- 						<option value="http://localhost:8080/Art/14/shopListController.ctrl?query=cook">Spanish</option> -->
<!-- 						<option value="1">Arabic</option> -->
<!-- 						<option value="1">Portuguise</option> -->
<!-- 						<option value="1">Bengali</option> -->
<!-- 					</select> -->
					
					<select id="queryType">
						<option value="" disabled selected>商品分類</option>
						<option value="cook">餐具</option>
						<option value="deco">飾品</option>
						<option value="pen">文具</option>
					</select>
				</div>
				
			</div>
			<br>
			
			<div style="text-align: center;">
				<FORM ACTION="gotoCart.ctrl">
                <input type="hidden" name="method" value="order"/>
                <input type="submit" style="margin-left: 10px;" class="genric-btn primary-border small" name="check" value="前往結帳頁面">
                </FORM>
			</div>
			<hr>
										
					<div class="row justify-content-center">
			<c:forEach var='query' items='${queryList}' varStatus="vs">
						<div class="col-lg-4 col-md-6 single-exhibition justify-content-center" >
							<div class="thumb justify-content-center">
								<img class="img-fluid" src="${pageContext.servletContext.contextPath}/14/getBlobImage/${query.productId}.ctrl" alt="" width="250" height="250">						
							</div>
							<div class="thumb justify-content-center">
								<img class="img-fluid" src="${pageContext.servletContext.contextPath}/14/getStarImage/${query.productId}.ctrl" alt="" width="100" height="20">						
							</div>
							<a href="#"><h4>${query.productTitle}</h4></a>
							<div class="meta-bottom d-flex justify-content-start">
								<p class="price">售價：
                                <fmt:formatNumber value="${query.productPrice}" type="number" /> 元</p>
							</div>									
							<p>
								<button class="genric-btn primary-border small" type="button" onclick="location.href='<c:url value='/14/showOneProduct2.ctrl?productID=${query.productId}' />'" >瀏覽商品 </button>
							</p>
						</div>
            </c:forEach>
					</div>
		
					</div>
			</section>
       </c:when>
		<c:otherwise>	
			<section class="upcoming-exibition-area section-gap justify-content-center" style="padding: 0px; padding-top:20px">
				<div class="container">
					<div class="row d-flex justify-content-center">
						<div class="menu-content col-lg-8">
							<div class="title text-center">
								<h2 class="mb-2">"All the products are a piece of art."</h2>
								<p>得藝的一天，從下單開始</p>
							</div>
						</div>
					</div>
			<div class="row d-flex justify-content-center" style="text-align: center;">
				<div class="default-select mb-10" id="default-select">
					<select id="queryType">
						<option value="" disabled selected>商品分類</option>
						<option value="cook">餐具</option>
						<option value="deco">飾品</option>
						<option value="pen">文具</option>
					</select>
				</div>
			</div>
				<br>
				
				<div style="text-align: center;">
				<FORM ACTION="gotoCart.ctrl">
                <input type="hidden" name="method" >
                <input type="submit" style="margin-left: 10px;" class="genric-btn primary-border small" name="check" value="前往結帳頁面">
                </FORM>
                </div>
				
			
			<hr>
										
					<div class="row justify-content-center">
			<c:forEach var='pdList' items='${pList}' varStatus="vs">
						<div class="col-lg-4 col-md-6 single-exhibition justify-content-center">
							<div class="thumb justify-content-center">
								<img class="img-fluid" src="${pageContext.servletContext.contextPath}/14/getBlobImage/${pdList.productId}.ctrl" alt="" width="250" height="250">						
							</div>
							<div class="thumb justify-content-center">
								<img class="img-fluid" src="${pageContext.servletContext.contextPath}/14/getStarImage/${pdList.productId}.ctrl" alt="" width="80" height="15">						
							</div>
							<a href="#"><h4>${pdList.productTitle}</h4></a>
							<div class="meta-bottom d-flex justify-content-start">
								<p class="price">售價：
                                <fmt:formatNumber value="${pdList.productPrice}" type="number" /> 元</p>
							</div>									
							<p>
								<button class="genric-btn primary-border small" type="button" onclick="location.href='<c:url value='/14/showOneProduct2.ctrl?productID=${pdList.productId}' />'" >瀏覽商品 </button>
<%-- 								<button class="genric-btn primary-border small" type="button" onclick="location.href='<c:url value='/14/showOneProduct2.ctrl?productID=${pdList.productId}' />'" >加入購物車 </button> --%>
							</p>
						</div>
            </c:forEach>
					</div>
		
					</div>
			</section>
		</c:otherwise>
       </c:choose>
	<!-- End Shopping List -->			
			
	<!-- Start Pages setting -->
			<div class="container">
			<div style="margin-left: 500px;">第 ${pageNo} 頁 // 共${totalPages} 頁</div>
				<div class="row justify-content-md-center">



					<nav aria-label="Page navigation example" style="margin: auto;">
						<ul class="pagination" style="margin: auto;">
							<li class="page-item" style="margin: auto;"><c:if
									test="${pageNo > 1}">
									<a class="page-link"
										href="<c:url value='/14/shopListController.ctrl?pageNo=${pageNo-1}&query=${query}' />"
										aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
									</a>
								</c:if></li>
							<c:forEach var='page' items='${pages}'>
								<li class="page-item"><a class="page-link"
									href="<c:url value='/14/shopListController.ctrl?pageNo=${page}&query=${query}' />">${page}</a></li>
							</c:forEach>
							<c:if test="${pageNo != totalPages}">
								<li class="page-item"><a class="page-link"
									href="<c:url value='/14/shopListController.ctrl?pageNo=${pageNo+1}&query=${query}' />"
									aria-label="Next"> <span aria-hidden="true">&raquo;</span>
								</a></li>
							</c:if>
						</ul>
					</nav>
				</div>
			</div>
	<!-- End Pages setting -->
	</section>
	<!-- End blog Area -->
	
<script>
$(function(){
    $("#queryType").change(function() {
        var query = $("#queryType").val();
    	window.location.href="<c:url value='/14/shopListController.ctrl?query="+query+"'/>" ;   
    })
})
</script>

	
</html>