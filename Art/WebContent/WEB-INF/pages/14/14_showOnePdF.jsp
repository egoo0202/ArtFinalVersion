<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.scontainer {
	/*             width: 500px; */
	margin: auto;
	/*             margin-top: 30px; */
}

.uul {
	margin: 0px;
}

.ii {
	display: inline-block;
	font-size: 5px;
	color: gray;
	padding: 3px;
}

.hovers {
	color: sandybrown;
}

.clicked {
	color: rgb(255, 138, 36);
}
</style>


</head>
<script src="https://cdn.ckeditor.com/4.15.1/basic/ckeditor.js"></script>
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@10"></script>

<!-- import Vue before Element -->
<script src="https://unpkg.com/vue/dist/vue.js"></script>

<!-- 引入样式 -->
<!-- <link rel="stylesheet" href="https://unpkg.com/element-ui/lib/theme-chalk/index.css"> -->
<!-- 引入组件库 -->
<!-- <script src="https://unpkg.com/element-ui/lib/index.js"></script> -->
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>

<!-- import JavaScript -->
<script src="https://unpkg.com/element-ui/lib/index.js"></script>
<link rel="stylesheet"
	href="https://unpkg.com/element-ui/lib/theme-chalk/index.css">

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


<body>

	<div class="container" style="margin-top: 100px">
		<div class="row justify-content-md-center">
			<div class="btn-toolbar mb-3" role="toolbar"
				aria-label="Toolbar with button groups">
				<div class="btn-group btn-group-sm" role="group"
					aria-label="Button group with nested dropdown">
					<button type="button" class="genric-btn primary-border small"
						value="全部商品"
						onclick="location.href='<c:url value='/14/shopListController.ctrl' />'">全部商品</button>
					<div class="btn-group" role="group">
						<button id="btnGroupDrop1" type="button"
							class=" genric-btn primary-border small dropdown-toggle"
							data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
							書寫用品</button>
						<div class="dropdown-menu" aria-labelledby="btnGroupDrop1">
							<a class="dropdown-item"
								href="<c:url value='/14/shopListController.ctrl?query=pen' />">鋼筆</a>
							<a class="dropdown-item"
								href="<c:url value='/14/shopListController.ctrl?query=ink' />">墨水</a>
						</div>
					</div>

					<div class="btn-group  btn-group-sm" role="group">
						<button id="btnGroupDrop1" type="button"
							class="genric-btn primary-border small dropdown-toggle"
							data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
							生活用品</button>
						<div class="dropdown-menu" aria-labelledby="btnGroupDrop1">
							<a class="dropdown-item"
								href="<c:url value='/14/shopListController.ctrl?query=home' />">家飾布置</a>
							<a class="dropdown-item"
								href="<c:url value='/14/shopListController.ctrl?query=cook' />">精選器皿</a>
							<a class="dropdown-item"
								href="<c:url value='/14/shopListController.ctrl?query=deco' />">飾品小物</a>
						</div>
					</div>
				</div>
				<c:if test="${ funcName != 'ORD' }">
					<button type="button" style="margin-left: 10px;"
						class="genric-btn primary-border small" value="全部商品"
						onclick="location.href='<c:url value='/14/shopListController.ctrl' />'">
						訂單查詢</button>
				</c:if>
				<FORM ACTION="./ProductArray">
					<input type="hidden" name="method" value="order" /> <input
						type="submit" style="margin-left: 10px;"
						class="genric-btn primary-border small" name="check"
						value="前往結帳頁面">
				</FORM>
			</div>
		</div>
	</div>
	<br>



	<div class="container">
		<div class="card mb-3 "
			style="max-width: 800px; margin: auto; margin-top: 10px;">
			<div class="row no-gutters">
				<div class="col-md-4">
					<img
						src="${pageContext.servletContext.contextPath}/14/getBlobImage/${oneProsuct.productId}.ctrl"
						class="card-img" alt="...">
				</div>
				<div class="col-md-8">
					<div class="card-body">
						<FORM ACTION="SubmitProcess.ctrl">
							<h4 class="card-title">${oneProsuct.productTitle}</h4>
							<%--                             <p class="card-text">${oneProsuct.productId}</p> --%>

							<p class="card-text">
								<fmt:formatNumber value="${oneProsuct.productPrice}"
									type="number" />
								元
							</p>
							<div id="star">
								<el-rate v-model="value" disabled show-score
									text-color="#ff9900" score-template="{value}"> </el-rate>
							</div>

							<span>請輸入數量： <input type="number" min="1"
								max="${oneProsuct.productNum}" name="orderNum" id="orderNum" value="1">
							</span>

							<hr>
							<p class="card-text" style="font-size: x-large">
								<small class="text-muted">${oneProsuct.productDes}</small>
							</p>
							<input type="hidden" name="productTitle" id="productTitle" value="${oneProsuct.productTitle}" /> 
							<input type="hidden" name="productID" id="productID" value="${oneProsuct.productId}" /> 
							<input type="hidden" name="orderPrice" id="orderPrice" value="${oneProsuct.productPrice}" /> 
							<input	type="hidden" name="orderStock" id="orderStock" value="${oneProsuct.productNum}" />
							<%--<input type="hidden" name="orderNum" value="${num}" />--%>
							<input type="hidden" name="orderDes"
								value="${oneProsuct.productDes}" /> <input type="hidden"
								name="orderDes" value="${oneProsuct.productDes}" />
							<div>
								<button type="button" name="" id="btn-submit" onclick="tip()"
									value="${oneProsuct.productTitle}" class="genric-btn info" >加入購物車</button>
							</div>
						</form>
					</div>
				</div>

			</div>

			<hr>

			<!-- Start Message Board -->
			<div class="container" id="app">

				<!-- Start comment Message Board -->
				<section class="comment-sec-area pt-80 pb-80">
					<div class="container">
						<div class="row flex-column" id="fade">
							<div class="typography" id="fade">
								<h4>商品評論</h4>
								<h6>共 ${mseeageCount} 則評論</h6>
							</div>

							<br>
							<c:forEach var='mList' items='${mseeageList}' varStatus="vs">
								<div class="comment-list">
									<div class="single-comment justify-content-between d-flex">
										<div class="user justify-content-between d-flex">
											<div class="thumb">
												<img style='width: 100px; height: 100px;'
													src="${mList.subjectAP}" alt="">
											</div>
											<div class="desc">
												<h5>
													<a href="#">會員暱稱：${mList.fakename}</a>
												</h5>
												<h5>主旨：${mList.title}</h5>
												<p class="date" style="margin: 0px">${mList.time}</p>
												<div class="thumb justify-content-center">
													<img class=""
														src="${pageContext.servletContext.contextPath}/14/getStarImageMB/${mList.score}.ctrl"
														alt="" width="80" height="20">
												</div>
												<p class="comment">${mList.content}</p>
											</div>
										</div>
										<div class="reply-btn">
											<button class="genric-btn danger" onclick="report(${mList.messageNoAP})">檢舉這則評論</button> <br>

											<c:if test="${mList.memberId == sessionScope.member.id}">
												<button class="genric-btn info" onclick="edit(${mList.messageNoAP})">修改我的評論</button>
											</c:if>
										</div>
									</div>
								</div>

							</c:forEach>
						</div>

						<!-- End comment Message Board -->

						<!-- Start Vue.js AJAX Message Board -->

						<div class="row flex-column">
							<br>
							<div>
								<div class="typography">
									<h4 v-if="len">商品評論</h4>
									<h6 v-if="len">共 {{len}} 則評論</h6>
								</div>
								<div v-for="item in items">
									<!-- 							<p>PlateNumb: <span>{{item.memberId}}</span>, RouteUID: <span>{{item.subjectAP}}</span></p> -->
									<div class="comment-list">
										<div class="single-comment justify-content-between d-flex">
											<div class="user justify-content-between d-flex">
												<div class="thumb">
													<img style='width: 100px; height: 100px;'
														:src="item.subjectAP" alt="">
												</div>
												<div class="desc">
													<h5>
														<a href="#">會員暱稱：{{item.fakename}}</a>
													</h5>
													<h5>主旨：{{item.title}}</h5>
													<p class="date" style="margin: 0px">{{item.time}}</p>
													<div class="thumb justify-content-center">
														<img class="img-fluid" :src="item.scoreString" alt=""
															width="100" height="20">
													</div>
														<p>{{item.content}}</p>
<!-- 													<p style="white-space: pre-wrap" v-html="item.content"></p> -->
												</div>
											</div>
											<div class="reply-btn">
												<button class="genric-btn danger" @click="reportV(item.messageNoAP)">檢舉這則評論</button> <br>

												<button v-if="item.memberId === memberId" class="genric-btn info" @click="editV(item.messageNoAP)">修改我的評論</button>
<!-- 												<template v-if="item.memberId === memberId"> -->
<!--   												<el-button type="button" class="genric-btn info" @click="open(item.messageNoAP)">修改評論</el-button> -->
<!-- 												</template> -->
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>

						<!-- End Vue.js AJAX Message Board -->

					</div>
				</section>
				<!-- End Message Board -->


				<!-- Start Message Box -->
				<div v-if="loginOK===1">
					<section class="commentform-area pt-80" id="messageBoard">
						<div class="container">
							<h5 class="pb-50">給點回應嗎？</h5>
							<div>幫商品打個分數吧？</div>
							<div class="scontainer">
								<ul id="uul">
									<li class="ii"><i class="fa fa-star fa-fw"></i></li>
									<li class="ii"><i class="fa fa-star fa-fw"></i></li>
									<li class="ii"><i class="fa fa-star fa-fw"></i></li>
									<li class="ii"><i class="fa fa-star fa-fw"></i></li>
									<li class="ii"><i class="fa fa-star fa-fw"></i></li>
								</ul>
								<div class="divRatiing"></div>
							</div>
							<br>
							<div class="row flex-row d-flex">

								<div class="col-lg-4 col-md-6">
									<input name="name" placeholder="請輸入您的姓名"
										onfocus="this.placeholder = ''"
										onblur="this.placeholder = '請輸入您的姓名'" id="fakeName"
										class="common-input mb-20 form-control" required=""
										type="text"> <input name="email" id="mail"
										placeholder="請輸入您的  E-mail" onfocus="this.placeholder = ''"
										onblur="this.placeholder = '請輸入您的  E-mail'"
										class="common-input mb-20 form-control" required=""
										type="email"> <input name="subject"
										placeholder="請輸入主旨" onfocus="this.placeholder = ''"
										onblur="this.placeholder = '請輸入主旨'" id="inn"
										class="common-input mb-20 form-control" required=""
										type="text">

								</div>
								<div class="col-lg-8 col-md-6">
									<textarea class="form-control mb-10" name="" id="textAre"
										placeholder="請給這項商品一點建議吧？" onfocus="this.placeholder = ''"
										onblur="this.placeholder = '請給這項商品一點建議吧？'" required=""></textarea>
									<button class="genric-btn primary-border small mt-10" onclick="push()">發表回應</button>
									<button class="genric-btn primary-border small mt-10" id="btn">DEMO</button>
								</div>
							</div>
						</div>
					</section>


				</div>
				<div style="text-align: center;" v-else>
					<br>
					<h3>購買商品以撰寫評論</h3>
					<br>
				</div>
			</div>
			<!-- End Message Box -->


		</div>
	</div>

	<!-- 星星 -->
	<script src="<c:url value='/js14/testJS.js'/>"></script>


	<script>
//          CKEDITOR.replace( 'editor1' );

         var vm = new Vue({
 			el: "#app",
 			data() {
 				return {
 					items: null,
 					len: null,
 					loginOK: false,
 					memberId: null
 				}
 			},
			created: function(){
	          var self = this;
	          var apid = $("#productID").val();
	          $.ajax({
	              type:"get",
	              url:"/Art/14/MBloginCheck/"+apid+".ctrl",    
//	              contentType: "application/json",
//	              dataType:"text",
	              success:function(value){
	              	self.loginOK = value;
	              	memberCheck();
	              },
	              error:function(){
	                  alert("failure");
	              }
	          });
	      },

	      methods: {

	    	   editV: function(mbid) {
	    		   edit(mbid);
	        	},

	      reportV: function(mbid) {
   		   report(mbid);
       	}

// 	    	  open: function(mbid) {
// 	              this.$prompt('請輸入欲修改的內文', '提示', {
// 	                  confirmButtonText: '確定',
// 	                  cancelButtonText: '取消',
// 	                }).then(({ value }) => {
// 	                  this.$message({
// 	                    type: 'success',
// 	                    message: '更改的內文為: ' + value
// 	                  });
// 	                    aa(mbid, value);
// 	                }).catch(() => {
// 	                  this.$message({
// 	                    type: 'info',
// 	                    message: '取消输入'
// 	                  });       
// 	                });
// 	              }


        	 }
         })
         
         function push() {
				var self = vm;
				var apid = $("#productID").val();
				var name = $('input[name=name]');
				var title = $('input[name=subject]');
				var rate = $(".clicked").length;
// 				var editor = CKEDITOR.instances.editor1.getData();
// 				var editor = $('input[name=text]');
				var editor = $('#textAre').val();

// 				var data = 'name=' + name.val() +  '&subjectAP=' + subject.val() + '&editor=' + editor + '&rate=' + rate;
 				var data = 'name=' + name.val() +  '&editor=' + editor + '&rate=' + rate + '&title='+ title.val() ;
//  				alert(editor);
				$.ajax({
				type: "get",
//				url: "/Art/14/saveMessage/" + apid + ".ctrl?name="+
//					 name.val() + "&subjectAP=" + subject.val(),
				url: "/Art/14/saveMessage/" + apid + ".ctrl",
				contentType: "application/json",
				dataType: "json",
				data: data,
				cache: false,
				success: function(json) {
					var arr = Object.keys(json);
					var len = arr.length;
					self.items = json;
					self.len = len;
					$('#fade').fadeOut('slow');
					$('#messageBoard').fadeOut('slow');
					getStar();
					
				},
				error:  function() {
					alert("failure");
				}
				});
			}

         function aa(mbid, value) {
        	 var self = vm;
        	 var apid = $("#productID").val();
             var data= 'mbid='+mbid+'&content='+value+'&apid='+apid
        	 $.ajax({
 				type: "get",
 				url: "/Art/14/editMessage",
 				contentType: "application/json",
 				dataType: "json",
 				data: data,
 				cache: false,
 				success: function(json) {
 					var arr = Object.keys(json);
 					var len = arr.length;
 					self.items = json;
 					self.len = len;
 					$('#fade').fadeOut('slow');
 					$('#messageBoard').fadeOut('slow');
 					getStar();
 					
 				},
 				error:  function() {
 					alert("failure");
 				}
 				});
             }
         
         function memberCheck() {
        	 var self = vm;
        	 $.ajax({
	              type:"get",
	              url:"/Art/14/getMemberId.ctrl",    
	              dataType:"text",
	              success:function(memberId){
	              	self.memberId = memberId;
	              	
	              },
	              error:function(){
	                  alert("failure");
	              }
	          });
         }

         function edit(mbid) {
        	 swal({
        		 title: "修改留言內文",
        		  text: "請輸入您要修改的文字：",
        		  content: "input",
        		  showCancelButton: true,
        		  closeOnConfirm: false,
        		  animation: "slide-from-top",
        		  inputPlaceholder: "說點什麼嗎？"
        		}).then(
        		function(inputValue){
        		  if (inputValue == false) return false;

        		  if (inputValue == "") {
        		    swal("不能空白喔!");
        		    return false
        		  }

        		  swal("感謝您的留言!", "您的留言為: " + inputValue, "success");
        		  aa(mbid, inputValue);
        		});
             }
         
      </script>

	<script>
var star = new Vue({
		el: "#star",
		data() {
			return {
				value: null
				
			}
		},
		created: function(){
	          var self = this;
	          var apid = $("#productID").val();
	          $.ajax({
	              type:"get",
	              url:"/Art/14/jsonTest/"+apid+".ctrl",    
// 	              contentType: "application/json",
// 	              dataType:"text",
	              success:function(value){
	              	self.value = value;
	              	
	              },
	              error:function(){
	                  alert("failure");
	              }
	          });
	      }

 })

function getStar(){
    var self = star;
    var apid = $("#productID").val();
    $.ajax({
        type:"get",
        url:"/Art/14/jsonTest/"+apid+".ctrl",    
//         contentType: "application/json",
        dataType:"text",
        success:function(value){
        	self.value = value;
        },
        error:function(){
            alert("failure");
        }
    });
}

function report(mid){
	var midd= mid
	swal("提示","確認檢舉？", "warning",{
	    buttons: {
	      danger: {
	          text: "是"
// 	          ,visible: true
	        },
	      "不是": true,
//	      "是": true
	      
	    },
	  })
	  .then((value) => {
	    switch (value) {
	      case "danger":
	    	swal("提示","您已檢舉此留言，留言將交由我們管理人員審查", "success")
	    	setTimeout(function(){bb(mid)},2000);
	        break;
	      case "不是":
	        swal("提示","什麼事情也沒發生", "info");
	        break;
	      default:
	    	  swal("提示","什麼事情也沒發生", "info");
	        break;
	    }
	  });
	
}


function bb(mbid) {
	 $.ajax({
		type: "get",
		url: "/Art/14/reportMessage/"+mbid,
		cache: false,
		dataType:"text",
		success: function(json) {
// 			alert(json);
			
		},
		error:  function() {
			alert("failure");
		}
		});
    }

</script>


<script>


$(function(){
	  var Name1 = "買到賺到欸";
	  var Name2 = '好東西。'
	  var Name3 = '花枝'
	  var Name4 = 'whatSquid@abcd.com'
   
$("#btn").click(function() {
	  document.getElementById("textAre").innerHTML= Name1;
	  document.getElementById("inn").value= Name2;
	  document.getElementById("fakeName").value= Name3;
	  document.getElementById("mail").value= Name4;
  });
});

function tip(){
	var pdId = $("#productID").val();
	var pdTile = $("#productTitle").val();
	var pdPrice = $("#orderPrice").val();
	var pdStock = $("#orderStock").val();
	var pdNum = $("#orderNum").val();
	
	 swal("已將商品加入購物車",{
         buttons: false,
         timer: 2000,
       });

	 $.ajax({
			type: "get",
			url: "/Art/14/SubmitProcessAjax?productID="+pdId+"&orderPrice="+pdPrice+"&orderNum="+pdNum+"&orderTitle="+pdTile+"&orderStock="+pdStock,
			cache: false,
			dataType:"text",
			success: function(json) {
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