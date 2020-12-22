<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="zh-tw">
<head>
<meta charset="UTF-8">
<title>訂單</title>
<style type="text/css">
.paystatus {
	width: 100px;
}
.do {
	width: 200px;
}
body {
	color: black;
	font-size:18px;
}}
</style>
</head>
<body>

	<!-- start banner Area -->
	<section class="banner-area relative" id="home">
		<div class="overlay overlay-bg"></div>
		<div class="container">
			<div class="row d-flex align-items-center justify-content-center">
				<div class="about-content col-lg-12">
					<h1 class="text-white">AAART Ticket</h1>
					<p class="text-white link-nav">
						<a href="index.html">Home </a> <span class="lnr lnr-arrow-right"></span>
						<a href="<c:url value='/04/SearchOrder.ctrl' />"> Orderlist</a>
					</p>
				</div>
			</div>
		</div>
	</section>
	<!-- End banner Area -->


	<div class="container">
		<br>
		<br>
		<H1>所有訂單</H1>
		<table class="table table-bordered">
			<tr>
				<th class=""></th>
				<th class="">訂單編號</th>
				<th class="">節目名稱</th>
				<th class="">票券種類</th>
				<th class="">訂購數量</th>
				<th class="">總金額</th>
				<th class="paystatus">付款狀況</th>
				<th class="do">操作</th>
			</tr>

			<%--使用JSTL 執行for loop ${show.no}取map內value --%>
			<c:forEach items="${requestScope.list}" var="orderlist"
				varStatus="idx">
				<tr>
					<form name="order"
						action="<c:url value='/04/OrderlistDetail.ctrl'/> " method="get">
						<!-- 					傳送訂單資訊 -->
						<td><input type=SUBMIT value="訂單詳細"
							class="genric-btn success radius"></td> <Input
							type='hidden' name='orderid' value='${orderlist.ORDERID}'>
					</form>

					<td>${orderlist.ORDERID}</td>
					<td>${orderlist.TITLE}</td>
					<td>${orderlist.TICKETCATEGORY}</td>
					<td>${orderlist.TICKET_NUM}</td>
					<td>${orderlist.TOTALPRICE}</td>
					<td>${orderlist.STATUS}</td>
<!-- 					<td> -->
<!-- 						<form name="order" -->
<%-- 							action="<c:url value='/04/DeleteOrderlist.ctrl'/> " method="get"> --%>
<%-- 							<button type="submit" name="orderid" value="${orderlist.ORDERID}" --%>
<!-- 								class="genric-btn success-border radius" onclick="return del()">取消訂單</button> -->
<!-- 						</form> -->
<!-- 					</td> -->
					<td>
						<form id="submitform" name="order" action="<c:url value='/04/WriteIssueForm'/>" method="get">
							<input type="hidden" name="issueId" value="${orderlist.ORDERID}" >
						</form>
						<button type="button" id="submit" class="genric-btn success radius" onclick="applyfor(${orderlist.ORDERID})">申請退票</button>
					</td>



				</tr>

			</c:forEach>


		</table>
		</form>
	</div>


	<script>
		function del() {
			var msg = "確定申請退票?";
			if (confirm(msg) == true) {
				return true;
			} else {
				return false;
			}
		}
		
// 		$("#submit").click(function() {
			function applyfor(issueId) {
			swal({
					  title: "是否申請退票票券?",
					  text: "將填寫申請單!",
					  icon: "warning",
					  buttons: true,
					  dangerMode: true,
					})
					.then((orderOK) => {
						  if (orderOK) {
								window.location="<c:url value='/04/WriteIssueForm?issueId="+issueId+"' />"; 

// 							  $("#submitform").submit();					
						  } else {
						    swal("申請已取消!");
						  }
						});

	 		};

	</script>


</body>

</html>