<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	response.setHeader("Cache-Control", "no-cache"); //Forces caches to obtain a new copy of the page from the origin server 
response.setHeader("Cache-Control", "no-store"); //Directs caches not to store the page under any circumstance 
response.setDateHeader("Expires", 0); //Causes the proxy cache to see the page as "stale" 
response.setHeader("Pragma", "no-cache"); //HTTP 1.0 backward compatibility
%>
<jsp:useBean id="today" class="java.util.Date" scope="session" />

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>CheckOrderPage</title>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<!-- import Vue before Element -->
<script src="https://unpkg.com/vue/dist/vue.js"></script>
<script type="text/javascript">

function confirmDelete(n) {
	if (confirm("確定刪除此項商品 ? ") ) {
		document.forms[0].action="<c:url value='/14/productListDelet.ctrl?productIdAP=" + n +"' />" ;
		document.forms[0].method="POST";
		document.forms[0].submit();
	} else {
	
	}
}

function modify(key, qty, index) {
	var x = "newQty" + index;
	var newQty = document.getElementById(x).value;
	if  (newQty < 0 ) {
		window.alert ('數量不能小於 0');
		return ; 
	}
	if  (newQty == 0 ) {
		window.alert ("請執行刪除功能來刪除此項商品");
		document.getElementById(x).value = qty;
		return ; 
	}
	if  (newQty == qty ) {
		window.alert ("新、舊數量相同，不必修改");
		return ; 
	}
	if (confirm("確定將此商品的數量由" + qty + " 改為 " + newQty + " ? ") ) {
		console.log("key= "+key);
		document.forms[0].action="<c:url value='/14/productListModify.ctrl?productIdAP=" + key + "&newQty=" + newQty +"' />" ;
		document.forms[0].method="POST";
		document.forms[0].submit();
	} else {
		document.getElementById(x).value = qty;
	}
}


function Checkout(qty) {
	if (qty == 0)  {
		alert("無購買任何商品，不需結帳");
		return false;
	}
	if (confirm("再次確認訂單內容 ? ") ) {
		return true;
	} else {
		return false;
	}
}

// function Abort() {
// 	if (confirm("確定清空購物車? ") ) {
// 		return true;
// 	} else {
// 		return false;
// 	}
// }


function abort() {
swal({
	  title: "你確定嗎？",
	  text: "你確定要將購物車中的商品全部刪除嗎？",
	  icon: "warning",
	  buttons: true,
	  dangerMode: true,
	})
	.then((willDelete) => {
	  if (willDelete) {
	    swal("你已將購物車中商品全數刪除")
	      
	      setTimeout(function(){window.location.href="<c:url value='/14/AbortCart.ctrl' />" ;},2000);

	    
	  } else {
	    swal("購物車商品未被刪除");
	  }
	});
}



</script>
<style>
.genric-btn.danger {
	color: #fff;
	background: #D05A6E;
}

.genric-btn.danger :hover {
	color: #D05A6E;
	border-color: #D05A6E;
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
					<h1 class="text-white">得藝洋行</h1>
					<p class="text-white link-nav">
						<a href="index.html">首頁 </a> <span class="lnr lnr-arrow-right"></span>
						<a href="<c:url value='/14/shopListController.ctrl' />"> 洋行</a> <span
							class="lnr lnr-arrow-right"></span> <span>結帳頁面</span>
					</p>
				</div>
			</div>
		</div>
	</section>
	<!-- End banner Area -->
	<br>
	<br>

	<!--Section: Block Content-->
	<section>

		<!--Grid row-->
		<div class="container" id="app">
			<div class="row">

				<!--Grid column-->
				<div class="col-lg-8">

					<!-- Card -->
					<div class="mb-3">
						<div class="pt-4 wish-list">

							<h5 class="mb-4">
								購物車 (<span>{{len}}</span> 樣物品)
							</h5>
							<!-- 一樣商品起點 -->
							<%-- 		<c:forEach varStatus="vs" var="anEntry" items="${carList.cartAP}"> --%>
							<div class="row mb-4" v-for="(item,index) in items">
								<div class="col-md-5 col-lg-3 col-xl-3">
									<div class="">
										<img class="img-fluid"
											:src="'${pageContext.servletContext.contextPath}/14/getBlobImage/' + item.productId +'.ctrl'"
											alt="Sample"> <a href="#"> </a>
									</div>
								</div>
								<div class="col-md-7 col-lg-9 col-xl-9">
									<div>
										<div class="d-flex justify-content-between">
											<div>
												<h5>{{item.productTitle}}</h5>
												<input type="hidden" name="pdStock" :id="index + 'pdStock'" :value="item.productImg"/>
<!-- 												<p class="mb-3 text-muted text-uppercase small">Shirt - -->
<!-- 													blue</p> -->
<!-- 												<p class="mb-2 text-muted text-uppercase small">Color: -->
<!-- 													blue</p> -->
												<h5 v-if="item.productNum > item.productImg" class="mb-3 text-muted text-uppercase small" 
												style="color:red !important">下單數量大於商品庫存數量<br>庫存為: {{item.productImg}}</h5>
<br><br><br><br><br>
											</div>
											<div>
												<div
													class="def-number-input number-input safari_only mb-0 w-100">
<!-- 													<button -->
<!-- 														onclick="this.parentNode.querySelector('input[type=number]').stepDown()" -->
<!-- 														class="minus decrease" style="border: none"> -->
<!-- 														<i class="fas fa-caret-down"></i> -->
<!-- 													</button> -->
													<input class="quantity" min="1" :id="index" name="quantity"
														:value="item.productNum" type="number"
														@change="modify(index,item.productId)">
<!-- 													<button -->
<!-- 														onclick="this.parentNode.querySelector('input[type=number]').stepUp()" -->
<!-- 														class="plus increase" style="border: none"> -->
<!-- 														<i class="fas fa-caret-up"></i> -->
<!-- 													</button> -->
												</div>
												<small id="passwordHelpBlock"
													class="form-text text-muted text-center">
													單價：{{item.productPrice|money}} </small>
											</div>
										</div>
										<div class="d-flex justify-content-between align-items-center">
											<div>
												<a href="" type="button" class="card-link-secondary small text-uppercase mr-3" @click="del(item.productId)">
													<i class="fas fa-trash-alt mr-1"></i> 從購物車移除 </a> 
<!-- 													<a href="#!" type="button" -->
<!-- 													class="card-link-secondary small text-uppercase"><i -->
<!-- 													class="fas fa-heart mr-1"></i> 移至收藏清單 </a> -->
											</div>
											<p class="mb-0">
												<span><strong id="summary">小計：{{item.productPrice*item.productNum|money}}元</strong></span>
											</p class="mb-0">
										</div>
									</div>
								</div>
							</div>
							<hr class="mb-4">
							<%--           </c:forEach> --%>
							<!-- 一樣商品結尾 -->


							<p class="text-primary mb-0">
								<i class="fas fa-info-circle mr-1"></i> 將商品加入購物車不等於購買，心動不如馬上結帳。
							</p>

						</div>
					</div>
					<!-- Card -->

					<!-- Card -->
					<div class="mb-3">
						<div class="pt-4">

							<h5 class="mb-4">猜你喜歡 !!</h5>
					<div class="row justify-content-center">
			<c:forEach var='query' items='${query}' varStatus="vs">
				<input type="hidden" id="${vs.count}productId" value="${query.productId}"/>
				<input type="hidden" id="${vs.count}productTitle" value="${query.productTitle}"/>
				<input type="hidden" id="${vs.count}productPrice" value="${query.productPrice}"/>
				<input type="hidden" id="${vs.count}productNum" value="${query.productNum}"/>
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
							<a
								href="#" onclick="tip(${vs.count})"
								class="genric-btn danger-border small"
								style="margin: 0px; margin-bottom: 5px" title="加入購物車"> <i
								class="fas fa-cart-plus" style="font-size: 15px"></i></a> 
								<a
								href="${pageContext.servletContext.contextPath}/14/showOneProduct2.ctrl?productID=${query.productId}"
								class="genric-btn info-border small"
								style="margin: 0px; margin-bottom: 5px" title="查看詳情"> <i
								class="fas fa-search" style="font-size: 15px"></i></a>							</p>
						</div>
            </c:forEach>
					</div>
							<p class="mb-0"></p>
						</div>
					</div>
					<!-- Card -->

					<!-- Card -->
					<div class="mb-3">
						<div class="pt-4">

							<h5 class="mb-4">我們接受以下付款方式</h5>

							<img class="mr-2" width="45px"
								src="https://mdbootstrap.com/wp-content/plugins/woocommerce-gateway-stripe/assets/images/visa.svg"
								alt="Visa"> <img class="mr-2" width="45px"
								src="https://mdbootstrap.com/wp-content/plugins/woocommerce-gateway-stripe/assets/images/amex.svg"
								alt="American Express"> <img class="mr-2" width="45px"
								src="https://mdbootstrap.com/wp-content/plugins/woocommerce-gateway-stripe/assets/images/mastercard.svg"
								alt="Mastercard"> <img class="mr-2" width="45px"
								src="https://mdbootstrap.com/wp-content/plugins/woocommerce/includes/gateways/paypal/assets/images/paypal.png"
								alt="PayPal acceptance mark">
						</div>
					</div>
					<!-- Card -->

				</div>
				<!--Grid column-->

				<!--Grid column-->
				<div class="col-lg-4">

					<!-- Card -->
					<div class="mb-3">
						<div class="pt-4">

							<h5 class="mb-3">購物明細</h5>

							<ul class="list-group list-group-flush">
								<li v-for="item in items"
									class="list-group-item d-flex justify-content-between align-items-center border-0 px-0 pb-0">
									{{item.productTitle}} <span>{{item.productPrice*item.productNum|money}}</span>
								</li>
<!-- 								<li -->
<!-- 									class="list-group-item d-flex justify-content-between align-items-center px-0"> -->
<!-- 									Shipping <span>Gratis</span> -->
<!-- 								</li> -->
								<li
									class="list-group-item d-flex justify-content-between align-items-center border-0 px-0 mb-3">
									<div>
										<strong>總金額</strong> <strong>
											<p class="mb-0">(含稅)</p>
										</strong>
									</div> <span><strong>{{sum|money}}</strong></span>
								</li>
							</ul>

<!-- 							<button type="button" class="genric-btn danger" onclick="abort()">前往結帳</button> -->
							<a v-if="buyOK" class="genric-btn danger"  href="<c:url value='/14/SubmitAPCart.ctrl' />"
								onClick="return Checkout(${carList.subtotal});">送出訂單</a>
							<h4 v-else style="color:red"> 下單數量大於庫存，<br>請檢查並修改各商品數量</h4>

						</div>
					</div>
					<!-- Card -->

					<!-- Card -->
					<div class="mb-3">
						<div class="pt-4">

							<a class="dark-grey-text d-flex justify-content-between"
								data-toggle="collapse" href="#collapseExample"
								aria-expanded="false" aria-controls="collapseExample">
								輸入優惠代碼 (非必填) <span><i class="fas fa-chevron-down pt-1"></i></span>
							</a>

							<div class="collapse" id="collapseExample">
								<div class="mt-3">
									<div class="md-form md-outline mb-0">
										<input type="text" id="discount-code"
											class="font-weight-light" placeholder="請輸入六碼優惠碼">
									</div>
								</div>
							</div>
						</div>
					</div>
					<!-- Card -->

				</div>
				<!--Grid column-->

			</div>
		</div>
		<!-- Grid row -->

	</section>
	<!--Section: Block Content-->
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
				len: null,
				buyOK: true,
				sum:null,
				memberId: null
			}
		},
		created: function(){
			
			var self = this;
	          $.ajax({
	              type:"get",
	              url:"/Art/14/orderConfirm",    
	              contentType: "application/json",
	              dataType:"json",
	              success:function(value){
	            	var arr = Object.keys(value);
	            	self.len = arr.length;
	              	self.items = value;
	              	productSum();
	              },
	              error:function(){
	                  alert("failure");
	              }
	          });
	      },	

  methods: {

	   modify: function(index,productIdAP) {
		   var self = this;
		   var newQty = document.getElementById(index).value;
		   var stockQty = document.getElementById(index+'pdStock').value;
		   var stockQtyInt=parseInt(stockQty);
		   if(newQty > stockQtyInt){
				self.buyOK = false;
			}else{
					self.buyOK = true;
					}
// 		   alert(newQty)
		   $.ajax({
	              type:"get",
	              url:"/Art/14/productListModify?productIdAP="+productIdAP+"&newQty="+newQty,    
	              contentType: "application/json",
	              dataType:"json",
	              success:function(value){
	            	var arr = Object.keys(value);
	            	self.len = arr.length;
	              	self.items = value;
	              	
	              	productSum();
	              },
	              error:function(){
	                  alert("failure at");
	              }
	          });
    	},

    	del: function(productIdAP) {
   
 		   var self = this;
//  		   alert(newQty)
 		   $.ajax({
 	              type:"get",
 	              url:"/Art//14/productListDeleteAjax?productIdAP="+productIdAP,    
 	              contentType: "application/json",
 	              dataType:"json",
 	              success:function(value){
 	            	var arr = Object.keys(value);
 	            	self.len = arr.length;
 	              	self.items = value;
 	              	productSum();
 	              },
 	              error:function(){
 	                  alert("failure at");
 	              }
 	          });
     	},

  }
})

function update(){
	var self = vm;
    $.ajax({
        type:"get",
        url:"/Art/14/orderConfirm",    
        contentType: "application/json",
        dataType:"json",
        success:function(value){
      	var arr = Object.keys(value);
      	self.len = arr.length;
        	self.items = value;
        	productSum();
        },
        error:function(){
            alert("failure");
        }
    });

	
}



function productSum() {
	 var self = vm;
	 $.ajax({
         type:"get",
         url:"/Art/14/getCartSum",    
         dataType:"text",
         success:function(sum){
         	self.sum = sum;
         	
         },
         error:function(){
             alert("failure at sum");
         }
     });
}

function tip(index){
//		alert(index)
	event.preventDefault();
	var productID = document.getElementById(index+'productId').value;
	var orderTitle = document.getElementById(index+'productTitle').value;
	var orderPrice = document.getElementById(index+'productPrice').value;
	var orderStock = document.getElementById(index+'productNum').value;
	var pdNum = 1;
	
	 swal("已將商品加入購物車",{
         buttons: false,
         timer: 2000,
       });

	 $.ajax({
			type: "get",
			url: "/Art/14/SubmitProcessAjax?productID="+productID+"&orderPrice="+orderPrice+"&orderNum="+pdNum+"&orderTitle="+orderTitle+"&orderStock="+orderStock,
			cache: false,
			dataType:"text",
			success: function(json) {
				update();
// 	 			alert(json);
				
			},
			error:  function() {
				alert("failure");
			}
			});

	
}
</script>

</body>
</html>