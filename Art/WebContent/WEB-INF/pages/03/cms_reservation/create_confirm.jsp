<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="container">
	<br>
	<div class=title>
		<h3 align="center" style="margin-top: 20px;">新增商店預約</h3>
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
		<form method="post"
			action="<c:url value = "/03/cms/reservation/createReservation.ctrl"/>">
			<table id="03A"
				class="display table table-bordered table-hover table-blue">
				<thead>
				</thead>
				<tbody>
					<tr style="display: none">
						<td>會員帳號:</td>
						<td><input type="hidden" name="memberId" value="${memberId}">${memberId}</td>
						<td></td>
					</tr>
					<tr>
						<td>會員姓名:</td>
						<td><input type="hidden" name="memberName"
							value="${memberName}">${memberName}</td>
						<td></td>
					</tr>
					<tr style="display: none">
						<td>商店代號:</td>
						<td><input type="hidden" name="shopId" value="${shopId}">${shopId}</td>
						<td style="width: 200px;"></td>
					</tr>
					<tr>
						<td>商店名稱:</td>
						<td><input type="hidden" name="shopName" value="${shopName}">${shopName}</td>
						<td></td>
					</tr>
					<tr>
						<td>預約日期:</td>
						<td><input type="hidden" name="dateTime" value="${dateTime}">${dateTime}</td>
						<td></td>
					</tr>
			</table>
<!-- 			====================================================== -->
			<br>
			<div style="font-size: large;">當日已被預約時段</div>
			<br>
			<table id="03B"
				class="display table table-bordered table-hover table-blue">
				<thead></thead>
				<tbody>
					<tr class="head">
						<th scope="col">開始時間</th>
						<th scope="col">結束時間</th>
					</tr>
					<c:if test="${reservationList != null}">
						<c:forEach items="${reservationList}" var="reservationList"
							varStatus="vs">
							<tr>
								<td>${reservationList.startTime}</td>
								<td>${reservationList.endTime}</td>
							</tr>
						</c:forEach>
					</c:if>
				</tbody>
			</table>
			<br>
			<div style="font-size: large;">當日預約人數上限: ${maximum}</div>
			<br>
			<c:if test="${note != null}">
				<div style="font-size: larger">店家備註:</div>
				<div style='height: 100px; line-height: 100px;'>${note}</div>
				<br>
			</c:if>
<!-- 			====================================================== -->
			<table id="03C"
				class="display table table-bordered table-hover table-blue">
				<thead></thead>
				<tbody>
					<tr>
						<td>預約人姓名*:</td>
						<td><input type="text" placeholder="請輸入姓名"
							name="customerName"></td>
						<td></td>
					</tr>
					<tr>
						<td>預約人電話*:</td>
						<td><input type="text" placeholder="請輸入電話號碼"
							name="customerPhone"></td>
						<td></td>
					</tr>
					<tr>
						<td>人數:</td>
						<td><input type="number" id="amount" name="amount" step="1"
							min="1" max="${maximum}" placeholder="請選擇人數" required></td>
						<td></td>
					</tr>
<!-- 					====================================================== -->
					<tr>
						<td>預約時段*:</td>
						<td><input type="time" id="startTime" name="startTime"
							min="${startTime}" max="${endTime-1}" required="required"></td>
						<td id="result"></td>
					</tr>
					<tr>
						<td>結束時間:</td>
						<td><input type="text" id="endTime" name="endTime"
							required="required"></td>
						<td></td>
					</tr>
					<tr>
						<td>備註</td>
						<td><textarea placeholder="請輸入附註內容" name="note"
								style="width: 450px; height: 70px;"></textarea></td>
						<td style="width: 200px;"></td>
					</tr>
<!-- 			====================================================== -->
				</tbody>
			</table>
			<br>
			<div class="submitButton" align="center" style="font-size: larger">
				<input type="submit" name="submit" value="預約資料送出">
			</div>
			<br>
		</form>
	</div>
</div>
<!-- ====================================================== -->
<script>
 	$(document).ready(function() {
 		$('#03A').DataTable({});
 		$('#03B').DataTable({});
 		$('#03C').DataTable({});
	});
</script>