<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="content">
	<br>
	<div class=title>
		<h1 align="center" style="margin-top: 20px;">得藝食堂 管理系統</h1>
	</div>
	<div class="back" align="right">
		<form
			action="<c:url value='/03/cms/restaurant/restaurantManagement'/> "
			method="get">
			<div class="submitButton">
				<input type="submit" class='btn btn-outline-info' name="submit"
					value="返回 營業時間管理">
			</div>
		</form>
	</div>
	<div class="content">

		<div align='center' style='font-size: x-large; font-weight: bold;'>${year}年&nbsp;${month}月&nbsp;${day}日營業時間表</div>
		<br> <br>
		<table id="03"
			class="display table table-bordered table-striped table-blue"
			style="color: #0B1013;">
			<thead class="table-hover">
				<tr style="color: #0B1013;">
					<th class='table-warning'>日期</th>
					<th class='table-success'>當日是否營業</th>
					<th class='table-danger'>訂位人數上限</th>
					<th class='table-info'>可訂位時段 (剩餘人數)</th>
				</tr>
			</thead>
			<tfoot></tfoot>
			<tbody style="color: #0B1013; font-size: larger;">
				<c:if test="${restaurantList != null}">
					<c:forEach items="${restaurantList}" var="restaurantList"
						varStatus="vs">
						<tr>
							<td><input type="hidden" name="day"
								value="${restaurantList.day}">${restaurantList.month}/${restaurantList.day}</td>
							<td><c:choose>
									<c:when test="${restaurantList.open == 1}">
										<div style="width: 150px; color: #0B1013;">營業日</div>
									</c:when>
									<c:otherwise>
										<div style="width: 150px; color: #0B1013;">店休日</div>
									</c:otherwise>
								</c:choose></td>
							<td><div style="width: 125px; color: #0B1013;">
									${restaurantList.maximum}位</div></td>
							<td><c:choose>
									<c:when test="${restaurantList.h09 != '-1'}">
										<label>09:00</label>&nbsp;<span
											style="color: #005CAF; font-weight: bold;">剩餘${restaurantList.h09}位</span>
									</c:when>
									<c:otherwise>
										<label>09:00</label>&nbsp;<span
											style="color: red; font-weight: bold;">不可訂位</span>
									</c:otherwise>
								</c:choose> <c:choose>
									<c:when test="${restaurantList.h10 != '-1'}">
										<label>10:00</label>&nbsp;<span
											style="color: #005CAF; font-weight: bold;">剩餘${restaurantList.h10}位</span>
									</c:when>
									<c:otherwise>
										<label>10:00</label>&nbsp;<span
											style="color: red; font-weight: bold;">不可訂位</span>
									</c:otherwise>
								</c:choose> <c:choose>
									<c:when test="${restaurantList.h11 != -1}">
										<label>11:00</label>&nbsp;<span
											style="color: #005CAF; font-weight: bold;">剩餘${restaurantList.h11}位</span>
										<br>
									</c:when>
									<c:otherwise>
										<label>11:00</label>&nbsp;<span
											style="color: red; font-weight: bold;">不可訂位</span>
										<br>
									</c:otherwise>
								</c:choose> <c:choose>
									<c:when test="${restaurantList.h12 != -1}">
										<label>12:00</label>&nbsp;<span
											style="color: #005CAF; font-weight: bold;">剩餘${restaurantList.h12}位</span>
									</c:when>
									<c:otherwise>
										<label>12:00</label>&nbsp;<span
											style="color: red; font-weight: bold;">不可訂位</span>
									</c:otherwise>
								</c:choose> <c:choose>
									<c:when test="${restaurantList.h13 != -1}">
										<label>13:00</label>&nbsp;<span
											style="color: #005CAF; font-weight: bold;">剩餘${restaurantList.h13}位</span>
									</c:when>
									<c:otherwise>
										<label>13:00</label>&nbsp;<span
											style="color: red; font-weight: bold;">不可訂位</span>
									</c:otherwise>
								</c:choose> <c:choose>
									<c:when test="${restaurantList.h14 != -1}">
										<label>14:00</label>&nbsp;<span
											style="color: #005CAF; font-weight: bold;">剩餘${restaurantList.h14}位</span>
										<br>
									</c:when>
									<c:otherwise>
										<label>14:00</label>&nbsp;<span
											style="color: red; font-weight: bold;">不可訂位</span>
										<br>
									</c:otherwise>
								</c:choose> <c:choose>
									<c:when test="${restaurantList.h15 != -1}">
										<label>15:00</label>&nbsp;<span
											style="color: #005CAF; font-weight: bold;">剩餘${restaurantList.h15}位</span>
									</c:when>
									<c:otherwise>
										<label>15:00</label>&nbsp;<span
											style="color: red; font-weight: bold;">不可訂位</span>
									</c:otherwise>
								</c:choose> <c:choose>
									<c:when test="${restaurantList.h16 != -1}">
										<label>16:00</label>&nbsp;<span
											style="color: #005CAF; font-weight: bold;">剩餘${restaurantList.h16}位</span>
									</c:when>
									<c:otherwise>
										<label>16:00</label>&nbsp;<span
											style="color: red; font-weight: bold;">不可訂位</span>
									</c:otherwise>
								</c:choose> <c:choose>
									<c:when test="${restaurantList.h17 != -1}">
										<label>17:00</label>&nbsp;<span
											style="color: #005CAF; font-weight: bold;">剩餘${restaurantList.h17}位</span>
										<br>
									</c:when>
									<c:otherwise>
										<label>17:00</label>&nbsp;<span
											style="color: red; font-weight: bold;">不可訂位</span>
										<br>
									</c:otherwise>
								</c:choose> <c:choose>
									<c:when test="${restaurantList.h18 != -1}">
										<label>18:00</label>&nbsp;<span
											style="color: #005CAF; font-weight: bold;">剩餘${restaurantList.h18}位</span>
									</c:when>
									<c:otherwise>
										<label>18:00</label>&nbsp;<span
											style="color: red; font-weight: bold;">不可訂位</span>
									</c:otherwise>
								</c:choose> <c:choose>
									<c:when test="${restaurantList.h19 != -1}">
										<label>19:00</label>&nbsp;<span
											style="color: #005CAF; font-weight: bold;">剩餘${restaurantList.h19}位</span>
									</c:when>
									<c:otherwise>
										<label>19:00</label>&nbsp;<span
											style="color: red; font-weight: bold;">不可訂位</span>
									</c:otherwise>
								</c:choose> <c:choose>
									<c:when test="${restaurantList.h20 != -1}">
										<label>20:00</label>&nbsp;<span
											style="color: #005CAF; font-weight: bold;">剩餘${restaurantList.h20}位</span>
										<br>
									</c:when>
									<c:otherwise>
										<label>20:00</label>&nbsp;<span
											style="color: red; font-weight: bold;">不可訂位</span>
										<br>
									</c:otherwise>
								</c:choose> <c:choose>
									<c:when test="${restaurantList.h21 != -1}">
										<label>21:00</label>&nbsp;<span
											style="color: #005CAF; font-weight: bold;">剩餘${restaurantList.h21}位</span>
									</c:when>
									<c:otherwise>
										<label>21:00</label>&nbsp;<span
											style="color: red; font-weight: bold;">不可訂位</span>
									</c:otherwise>
								</c:choose></td>
						</tr>
					</c:forEach>
				</c:if>
			</tbody>
		</table>
		<!-- ====================================================== -->
		<br>
	</div>
</div>
<!-- ====================================================== -->
<script>
	function myrefresh() {
		window.location.reload();
	}

	setTimeout('myrefresh()', 30000); //指定30秒刷新一次
</script>
