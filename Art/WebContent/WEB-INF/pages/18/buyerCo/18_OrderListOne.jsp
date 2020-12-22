<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!-- start banner Area -->
<section class="banner-area relative" id="home">
	<div class="overlay overlay-bg"></div>
	<div class="container">
		<div class="row d-flex align-items-center justify-content-center">
			<div class="about-content col-lg-12">
				<h1 class="text-white">訂單</h1>
				<p class="text-white link-nav">
					<a href="index.html">首頁</a> 
					<span class="lnr lnr-arrow-right"></span>
					<a href="<c:url value='/18/coOrderList.ctrl' />">訂單一覽</a>
					<span class="lnr lnr-arrow-right"></span>
					<a href="<c:url value='/18/coOrderListOne.ctrl?orderNoCo=${cooo.orderNoCo}' />">單筆訂單</a>
				</p>
			</div>
		</div>
	</div>
</section>
<!-- End banner Area -->
<div class="container" style="font-size:20px">
<div style="text-align:center;font-size:48px;font-weight:bold;color:#51A8DD;margin:30px">單筆訂單</div>

<table class="table table-bordered" style="border:2px solid">
<tr>
<td colspan="7">
<table>
<tr>
  <td>訂單編號：${cooo.orderNoCo}</td>
  <td>下單日期：${cooo.date}</td>
  <td>地址：${cooo.customerAddress}</td>
</tr>
</table>
</td>
</tr>
<tr style="text-align: center">
            <th id='borderA' width="50px" ></th>
			<th id='borderA' width="100px">課程名稱</th>
			<th id='borderA' width="100px">開課日期</th>
			<th id='borderA' width="100px">開課時間</th>
			<th id='borderA' width="70px">單價</th>
			<th id='borderA' width="50px">數量</th>
			<th id='borderA' width="100px">總價</th>
</tr>
		<c:set var="subtotal" value="0" />
		<c:forEach var="olone" varStatus="stat" items="${cooo.courseOrderItems}"> 
		<!-- 因為有兩層所以要選到courseOrderItems層
		cooo.courseOrderItems 在CourseOrderController #130 + CourseOrders #46 -->
			<tr id='borderA' bgColor="FFFFFF" height='30' style="text-align: center">
				<td id='borderA'>${stat.count}</td>
				<td id='borderA'><a href="<c:url value='/18/cCourseDetail.ctrl?coId=${olone.orderIdCo}' />"style="color:#1B813E;font-weight:bold">${olone.courseTitle}</a></td>
				<td id='borderA'>${olone.courseAct_Date}</td>
				<td id='borderA'>${olone.courseAct_Time}</td>
				<td id='borderA'>${olone.coursePrice}</td>
				<td id='borderA'>${olone.courseNum}</td>
				<td id='borderA'>${olone.coursePrice * olone.courseNum}</td>
				
				<c:set var="total"
					value="${ total + olone.coursePrice * olone.courseNum }" />
			</tr>
		</c:forEach>
		<tr height='30' style="text-align: center;font-weight:bold">
			<TD id='borderA' colspan="4">&nbsp;</TD>
			<TD id='borderA' width="60px" colspan="2"><b>合 計</b></TD>
			<TD id='borderA' width="100px">
			   <fmt:formatNumber value="${total}" pattern="#,###,###" />元</TD>
		
	</TABLE>
</div>