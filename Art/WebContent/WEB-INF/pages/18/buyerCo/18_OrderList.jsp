<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- start banner Area -->
<section class="banner-area relative" id="home">
	<div class="overlay overlay-bg"></div>
	<div class="container">
		<div class="row d-flex align-items-center justify-content-center">
			<div class="about-content col-lg-12">
				<h1 class="text-white">訂單一覽</h1>
				<p class="text-white link-nav">
					<a href="index.html">首頁</a> 
					<span class="lnr lnr-arrow-right"></span>
					<a href="<c:url value='/18/coOrderList.ctrl' />">訂單一覽</a>
				</p>
			</div>
		</div>
	</div>
</section>
<!-- End banner Area -->

<div class="container" style="font-size: 20px">
<div style="text-align:center;font-size:48px;font-weight:bold;color:#51A8DD;margin:30px">訂單一覽</div>
<table class="table table-bordered">
	<thead>
		<tr style="text-align:center;font-size:28px;color:#81C7D4;margin:30px">
			<th>訂單編號</th>
<!-- 			<th>訂購人</th> -->
			<th>下單日期</th>
			<th>總價</th>
<!-- 			<th>收件地址</th> -->
		</tr> 
		<c:forEach varStatus="stat" var="orderListCo" items="${col}">
			<tr>
				<td style="text-align:center">
				<a href='<c:url value='/18/coOrderListOne.ctrl?orderNoCo=${orderListCo.orderNoCo}' />'style="color:#1B813E;font-weight:bold">${orderListCo.orderNoCo}</a></td>
				<td>${orderListCo.date}</td>
				<td>${orderListCo.totalAmount}</td>
<%-- 				<td>${orderListCo.customerAddress}</td> --%>
			</tr>
		</c:forEach>
		<tr height='36' id='borderA'>
			<td id='borderA' style="text-align:center;font-size:32px" colspan="3">
			<a href="<c:url value='/18/cSelectAllFront.ctrl' />" style="color:#6F3381;font-weight:bold">回首頁</a></td>
		</tr>
</table>
</div>
