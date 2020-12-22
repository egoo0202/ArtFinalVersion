<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>


	<script src="https://unpkg.com/vue/dist/vue.js"></script>

</head>


<body>

	<!-- start banner Area -->
	<section class="banner-area relative" id="home">
		<div class="overlay overlay-bg"></div>
		<div class="container">
			<div class="row d-flex align-items-center justify-content-center">
				<div class="about-content col-lg-12">
					<h1 class="text-white">得藝洋行</h1>
					<p class="text-white link-nav">
						<a href="index.html">首頁 </a> <span class="lnr lnr-arrow-right"></span>
						<a href="<c:url value='/14/shopListController.ctrl' />"> 洋行</a>
					</p>
				</div>
			</div>
		</div>
	</section>
	<!-- End banner Area -->

	<div id="app">
			<section class="upcoming-exibition-area section-gap justify-content-center" style="padding: 0px; padding-top: 20px">
				
				<div class="container">

					<div class="row d-flex justify-content-center">
						<div class="menu-content col-lg-8">
							<div class="title text-center">
								<h2 class="mb-2">"All the products are a piece of art."</h2>
								<p>得藝的一天，從下單開始</p>
							</div>
						</div>
					</div>
					<div class="row d-flex justify-content-center"
						style="text-align: center;">

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
							<input type="hidden" name="method" value="order" /> <input
								type="submit" style="margin-left: 10px;"
								class="genric-btn primary-border small" name="check"
								value="前往結帳頁面">
						</FORM>
					</div>
					<hr>
					<div class="row justify-content-center" >
							<div class="col-lg-4 col-md-6 single-exhibition justify-content-center"  v-for="item in items">
								<div class="thumb justify-content-center">
									<img class="img-fluid"
										:src="'${pageContext.servletContext.contextPath}/14/getBlobImage/' + item.productId +'.ctrl'"
										alt="" width="250" height="250">
<!-- 										<img v-bind:src="'/media/avatars/' + joke.avatar" />  -->
								</div>
								<div class="thumb justify-content-center">
									<img class="img-fluid"
										src=""
										alt="" width="100" height="20">
								</div>
								<a href="#"><h4>{{item.productTitle}}</h4></a>
								<div class="meta-bottom d-flex justify-content-start">
									<p class="price">
										售價：{{item.productTitle}}
										<fmt:formatNumber value="" type="number" />
										元
									</p>
								</div>
								<p>                                                       
								<a :href="'${pageContext.servletContext.contextPath}/14/showOneProduct2.ctrl?productID=' + item.productId" >瀏覽商品 </a>
							</p>
							</div>
					</div>
			</section>
	<!-- End Shopping List -->

	<!-- Start Pages setting -->
	<div class="container">
			<div style="margin-left: 500px;">第${pageNo}頁 // 共{{pages}}頁</div>
				<div class="row justify-content-md-center">



					<nav aria-label="Page navigation example" style="margin: auto;">
						<ul class="pagination" style="margin: auto;">
<%-- 							<li class="page-item" style="margin: auto;"><c:if --%>
<%-- 									test="${pageNo > 1}"> --%>
<!-- 									<a class="page-link" -->
<%-- 										href="<c:url value='/14/shopListController.ctrl?pageNo=${pageNo-1}&query=${query}' />" --%>
<!-- 										aria-label="Previous"> <span aria-hidden="true">&laquo;</span> -->
<!-- 									</a> -->
<%-- 								</c:if></li> --%>
								<div v-for="page in pages">
								<li class="page-item"><a class="page-link"
									href="#">{{page}}</a></li>
								</div>
							<c:if test="${pageNo != totalPages}">
								<li class="page-item"><a class="page-link"
									href="'${pageContext.servletContext.contextPath}/14/creatJsonChangPage?pageNo=' + page"
									aria-label="Next"> <span aria-hidden="true">&raquo;</span>
								</a></li>
							</c:if>
						</ul>
					</nav>
				</div>
			</div>
	<!-- End Pages setting -->
	</div>
	<!-- End blog Area -->

	<script>
$(function(){
    $("#queryType").change(function() {
        var query = $("#queryType").val();
    	window.location.href="<c:url value='/14/shopListController.ctrl?query="+query+"'/>" ;   
    })
})


var vm = new Vue({
 		el: "#app",
 		data() {
 			return {
 				items: null,
 				pages: null
 			}
 		},
 		
 		created: function(){
	          
 			this.initPageList();
 			this.initProductList();
	          
	      },

	      methods:{
	    	  initProductList: function() {
	    		  var self = this;
		          $.ajax({
		              type:"get",
		              url:"/Art/14/initShopListAP",    
		              contentType: "application/json",
		              dataType: "json",
		              success:function(value){
		              	self.items = value;
		              },
		              error:function(){
		                  alert("failure at initProductList()");
		              }
		          });
	    	  },

	      	initPageList: function() {
	      		var self = this;
	      		 $.ajax({
		              type:"get",
		              url:"/Art/14/initPages",    
		              contentType: "application/json",
		              dataType: "json",
		              success:function(value){
		            	  
		              	self.pages = value;
		              },
		              error:function(){
		                  alert("failure at initPageList()");
		              }
		          });
		      	}
	      }
       })


</script>
</html>