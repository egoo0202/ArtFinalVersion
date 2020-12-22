<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<!-- Vue.js -->
<script src="https://cdn.jsdelivr.net/npm/vue@2.6.12/dist/vue.js"></script>

<!-- TOOLTIP & POPOVER -->
<script src="https://unpkg.com/@popperjs/core@2"></script>

<!-- Element UI 不要理它-->
<script src="https://unpkg.com/element-ui/lib/index.js"></script>
<link rel="stylesheet" href="https://unpkg.com/element-ui/lib/theme-chalk/index.css">

<style>
#gotop {
    position:fixed;
    z-index:90;
    right:30px;
    bottom:31px;
    display:none;
    width:50px;
    height:50px;
    color:#fff;
    background:#000000;
    opacity: 0.5;
    line-height:50px;
    border-radius:50%;
    transition:all 0.5s;
    text-align: center;
    box-shadow: 0 2px 5px 0 rgba(0,0,0,0.16), 0 2px 10px 0 rgba(0,0,0,0.12);
}

.genric-btn.danger-border {
color:#D05A6E;
border-color: #D05A6E;

}
.genric-btn.danger-border:hover{
color:#fff; 
background:#D05A6E;  
}

p.likes:hover{
color:#D05A6E;
cursor: pointer;
}

p.comments:hover{
color:#0099CC;
cursor: pointer;
}

</style>
<script>
$(function () {
	  $('[data-toggle="tooltip"]').tooltip()
	})
</script>
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
	<!-- Start blog Area -->
	<br><br>
	<section class="blog-area " id="blog" style="background-color:#ffff" style="padding: 10px; padding-top:20px">
		<div class="container" id="app">
			<div class="row d-flex justify-content-center">
				<div class="menu-content col-lg-8">
					<div class="title text-center">
						<h1 class="mb-10">Latest From Our Blog</h1>
						<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit,
							sed do eiusmod tempor incididunt ut labore et dolore magna
							aliqua.</p>
					</div>
				</div>
			</div>
			<template>
			<div class="block"  style="width:300px">
    			<span class="demonstration">按價錢搜尋</span>
    			<el-slider
     			 v-model="value2"
			      :step="10"
 			     show-stops>
 			   </el-slider>
			  </div>
			</template>
			
			<div class="row">
				<div class="col-lg-3 col-md-6 single-blog" v-for="item in items">
					<div class="thumb">
						<img class="img-fluid" :src="'${pageContext.servletContext.contextPath}/14/getBlobImage/' + item.productId +'.ctrl'" 
						alt="" width="250px" height="250px">
					</div>
					<a :href="'${pageContext.servletContext.contextPath}/14/showOneProduct2.ctrl?productID=' + item.productId"><h4>{{item.productTitle}}</h4></a>
					<p>售價：{{item.productPrice | money}}</p>
<!-- 					<p class="date" style="margin: 0px; margin-bottom:5px">10 Jan 2018</p>  #F596AA -->
					<div>
						<a :href="'${pageContext.servletContext.contextPath}/14/showOneProduct2.ctrl?productID=' + item.productId" 
						    class="genric-btn danger-border small" style="margin: 0px; margin-bottom:5px" title="加入購物車">
						    <i class="fas fa-cart-plus" style="font-size:15px"></i></a>
						<a :href="'${pageContext.servletContext.contextPath}/14/showOneProduct2.ctrl?productID=' + item.productId" 
						    class="genric-btn info-border small" style="margin: 0px; margin-bottom:5px" title="查看詳情" >
						    <i class="fas fa-search" style="font-size:15px"></i></a>
					<div>
					<img class="img-fluid" :src="'${pageContext.servletContext.contextPath}/14/getStarImage/' + item.productId +'.ctrl'"  alt="" width="100" height="20">
					<div class="meta-bottom d-flex justify-content-between">
						<p class="likes">
							<span class="lnr lnr-heart"></span> 15  個人喜歡
						</p>
						<p class="comments">
							<span class="lnr lnr-bubble"></span> 2 則此商品的評論
						</p>
					</div>
				</div>

			</div>
		</div>
		</div>
	</section>
	<!-- End blog Area -->
	<a href="https://www.blogger.com/blogger.g?blogID=2031514508322140995#" id="gotop" >
   <i class="fas fa-chevron-up"></i>
   </a>
<script>

//編輯金錢格式，Vue.filter 必須設置在 new Vue 之前
Vue.filter('money',function(num){
  const parts = num.toString().split('.');
  parts[0] = parts[0].replace(/\B(?=(\d{3})+(?!\d))/g, ',');
  return '$' + parts.join('.');
});

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
		              url:"${pageContext.servletContext.contextPath}/14/initShopListAP",    
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


$(function() {
    /* 按下GoTop按鈕時的事件 */
    $('#gotop').click(function(){
        $('html,body').animate({ scrollTop: 0 }, 'slow');   /* 返回到最頂上 */
        return false;
    });
    
    /* 偵測卷軸滑動時，往下滑超過400px就讓GoTop按鈕出現 */
    $(window).scroll(function() {
        if ( $(this).scrollTop() > 400){
            $('#gotop').fadeIn();
        } else {
            $('#gotop').fadeOut();
        }
    });
});
</script>
</body>
</html>