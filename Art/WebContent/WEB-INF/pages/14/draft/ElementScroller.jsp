<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- Vue.js -->
<script src="https://cdn.jsdelivr.net/npm/vue@2.6.12/dist/vue.js"></script>
<!-- 引入样式 -->
<link rel="stylesheet"
	href="https://unpkg.com/element-ui/lib/theme-chalk/index.css">
<!-- 引入组件库 -->
<script src="https://unpkg.com/element-ui/lib/index.js"></script>

<style>
#gotop {
	position: fixed;
	z-index: 90;
	right: 30px;
	bottom: 31px;
	display: none;
	width: 50px;
	height: 50px;
	color: #fff;
	background: #000000;
	opacity: 0.5;
	line-height: 50px;
	border-radius: 50%;
	transition: all 0.5s;
	text-align: center;
	box-shadow: 0 2px 5px 0 rgba(0, 0, 0, 0.16), 0 2px 10px 0
		rgba(0, 0, 0, 0.12);
}

.genric-btn.danger-border {
	color: #D05A6E;
	border-color: #D05A6E;
}

.genric-btn.danger-border:hover {
	color: #fff;
	background: #D05A6E;
}

p.likes:hover {
	color: #D05A6E;
	cursor: pointer;
}

p.comments:hover {
	color: #0099CC;
	cursor: pointer;
}

.img-fluid {
	max-width: 100%;
	height: 250px;
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
						<a href="<c:url value='/14/shopListController.ctrl' />"> 洋行</a>
					</p>
				</div>
			</div>
		</div>
	</section>
	<!-- End banner Area -->
	<!-- Start blog Area -->
	<br>
	<br>
	<section class="blog-area " id="blog" style="background-color: #ffff"
		style="padding: 10px; padding-top:20px">
		<div class="container" id="app">
			<div class="row d-flex justify-content-center">
				<div class="menu-content col-lg-8">
					<div class="title text-center">
						<h1 class="mb-10">"All the products are a piece of art."</h1>
						<p>得藝的一天，從下單開始</p>
					</div>
				</div>
			</div>
			<div class="row">
				<c:forEach var='pdList' items='${pList}' varStatus="vs">
				<input type="hidden" id="${pdList.productId}" value="${pdList.productId}"/>
				<input type="hidden" id="${pdList.productId}productTitle" value="${pdList.productTitle}"/>
				<input type="hidden" id="${pdList.productId}productPrice" value="${pdList.productPrice}"/>
				<input type="hidden" id="${pdList.productId}productNum" value="${pdList.productNum}"/>
					<div class="col-lg-3 col-md-6 single-blog">
						<div class="thumb">
							<img class="img-fluid"
								src="${pageContext.servletContext.contextPath}/14/getBlobImage/${pdList.productId}.ctrl"
								alt="" width="250px" height="250px">
						</div>
						<a
							href="${pageContext.servletContext.contextPath}/14/showOneProduct2.ctrl?productID=${pdList.productId}"><h4>${pdList.productTitle}</h4></a>
						<p>
							售價：
							<fmt:formatNumber value="${pdList.productPrice}" type="number" />
							元
						</p>
						<!-- 					<p class="date" style="margin: 0px; margin-bottom:5px">10 Jan 2018</p>  #F596AA -->
						<div>
							<a
								href="#" onclick="tip(${pdList.productId})"
								class="genric-btn danger-border small"
								style="margin: 0px; margin-bottom: 5px" title="加入購物車"> <i
								class="fas fa-cart-plus" style="font-size: 15px"></i></a> 
								<a
								href="${pageContext.servletContext.contextPath}/14/showOneProduct2.ctrl?productID=${pdList.productId}"
								class="genric-btn info-border small"
								style="margin: 0px; margin-bottom: 5px" title="查看詳情"> <i
								class="fas fa-search" style="font-size: 15px"></i></a>
							<div>
								<img class=""
									src="${pageContext.servletContext.contextPath}/14/getStarImage/${pdList.productId}.ctrl"
									alt="" width="100" height="22">
								<div class="meta-bottom d-flex justify-content-between">
<!-- 									<p class="likes"> -->
<!-- 										<span class="lnr lnr-heart"></span> 15 個人喜歡 -->
<!-- 									</p> -->
									<p class="comments" style="text-align:center">
										<span class="lnr lnr-bubble">&nbsp&nbsp</span>${pdList.productMessage} 則此商品的評論
									</p>
								</div>
							</div>

						</div>
					</div>
				</c:forEach>
			</div>
				<div class="end" id="end"></div>
			<div class="container">

<!-- 				<div> -->
<%-- 					<b class="down">hi${totalPages}一些字 ${pageNo}</b> --%>
<!-- 				</div> -->
				<c:if test="${totalPages > pageNo}">
					<button id="btn" onclick="push()" class="genric-btn info-border small" style="text-align:center">載入更多</button>
				</c:if>
<!-- 				<button id="btn" onclick="add()">add!!</button> -->
				<input type="hidden" value="2" name="pageNo" id="pageNo" /> <input
					type="hidden" value="${query}" name="query" id="query" />

			</div>
			<a
				href="https://www.blogger.com/blogger.g?blogID=2031514508322140995#"
				id="gotop"> <i class="fas fa-chevron-up"></i>
			</a>


			<script>
				// var flag = false;
				// var last=$("body").height()-$(window).height()
				// var pageNo= $("#pageNo").val();
				// var index =  parseInt(pageNo)+1	
				// if($(window).scrollTop() < last){
				// // if($(document).scrollTop() < last){

				// 	flag= true;
				// }

				// $(window).scroll(function(){

				//     if($(window).scrollTop() >= last){
				//     	if(flag = true){

				//     $(".down").hide()
				//     $(".end").append("<br> <b>新的字串</b>.");

				//         $.ajax({
				//             type:"get",
				//             url:"/Art/14/getSubView?pageNo="+pageNo,
				//             dataType : 'html',   
				//             success:function(page){
				// //             	alert(page)
				//             	$("#end").append(page);
				//             	document.getElementById("pageNo").value= index;
				// //             	 $(".end").append('<br>page');
				// //             	 document.write(page);
				// //             	 document.getElementById('end').innerHTML = page

				//             },
				//             error:function(){
				//                 alert("failure");
				//             }
				//         });
				//     }

				//     }
				// })

				$(function() {
					/* 按下GoTop按鈕時的事件 */
					$('#gotop').click(function() {
						$('html,body').animate({
							scrollTop : 0
						}, 'slow'); /* 返回到最頂上 */
						return false;
					});

					/* 偵測卷軸滑動時，往下滑超過400px就讓GoTop按鈕出現 */
					$(window).scroll(function() {
						//     	alert('up')
						if ($(this).scrollTop() > 400) {
							$('#gotop').fadeIn();
						} else {
							$('#gotop').fadeOut();
						}
					});
				});

				function push() {
					$("#btnn").fadeOut()
					$("#btn").fadeOut()
					var pageNo = $("#pageNo").val();
// 					alert(pageNo)
					var query = $('input[name=query]').val();
					var index = parseInt(pageNo) + 1
					$.ajax({
						type : "get",
						url : "/Art/14/getSubView?pageNo=" + pageNo + "&query="+ query,
						dataType : 'html',
						success : function(page) {
							//             	alert(page)

							$("#end").append(page);
							//       	$("#end").hide().append(page).fadeIn('slow');
							//       	$('#end').fadeIn('slow');
							//       	alert('pageNo'+ pageNo)
							//       	alert(index)
							document.getElementById("pageNo").value = index;
							//       	document.getElementById("pageNo").innerHTML = '<input type="hidden" value="2" name="pageNo" id="pageNo"/>'
							//         $("#pageNo").attr(value,2)
							//             	 document.write(page);
							//             	 document.getElementById('end').innerHTML = page

						},
						error : function() {
							alert("failure");
						}
					});
				}

				function add() {
					alert('a')

				}

				function tip(index){
					alert(index)
					event.preventDefault();
					var productID = document.getElementById(index).value;
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
//				 	 			alert(json);
								
							},
							error:  function() {
								alert("failure");
							}
							});

					
				}


			</script>
</body>
</html>