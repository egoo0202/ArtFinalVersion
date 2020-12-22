<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="container">
	<br>
	<div class=title>
		<h3 align="center" style="margin-top: 20px;">刪除商店預約</h3>
	</div>
	<div class="back" align="right">
		<form action="<c:url value='/03/cms/reservation/index'/> "
			method="get">
			<div class="submitButton">
				<input type="submit" class="" name="submit" value="返回 商店預約管理">
			</div>
		</form>
	</div>
	<br>
	<div class=content>
		<table id="03"
			class="display table table-bordered table-hover table-blue">
			<thead></thead>
			<tbody>
				<tr class="head">
				</tr>
				<c:if test="${reservationList != null}">
					<c:forEach items="${reservationList}" var="reservationList"
						varStatus="vs">
						<tr>
							<td>預約編號:</td>
							<td>${reservationList.reservationNo}</td>
						</tr>
						<tr>
							<td>會員帳號:</td>
							<td>${reservationList.memberId}</td>
						</tr>
						<tr>
							<td>會員姓名:</td>
							<td>${reservationList.memberName}</td>
						</tr>
						<tr>
							<td>預約日期</td>
							<td>${reservationList.dateTime}</td>
						</tr>
						<tr>
							<td>商店名稱:</td>
							<td>${reservationList.shopName}</td>
						</tr>
						<!-- ======================= -->
						<tr>
							<td>預約人姓名:</td>
							<td>${reservationList.customerName}</td>
						</tr>
						<tr>
							<td>預約人電話:</td>
							<td>${reservationList.customerPhone}</td>
						</tr>
						<tr>
							<td>人數:</td>
							<td>${reservationList.amount}</td>
						</tr>
						<tr>
							<td>附註:</td>
							<td><textarea placeholder="請輸入附註內容" name="note"
									style="width: 450px; height: 70px;" required="required">${reservationList.note}</textarea></td>
						</tr>
					</c:forEach>
				</c:if>
			</tbody>
		</table>
		<br>
		<div class="submitButton" align="center" style="font-size: larger">
			<form method="post"
				action="<c:url value="/03/cms/reservation/deleteReservation.ctrl"/>">
				<button name="deleteButton" type="submit"
					value="${reservationList.reservationNo}">刪除預約</button>
				<Input type="hidden" name="reservationNo"
					value="${reservationList.reservationNo}">
			</form>
		</div>
		<br>
		<c:if test="${reservationSerachMsg != null}">
			<div align="center" style="font-size: larger">${reservationSerachMsg}</div>
		</c:if>
	</div>
</div>
<!-- ====================================================== -->

<script>
	$(document).ready(function() {
		$('#03').DataTable({});
	});
</script>