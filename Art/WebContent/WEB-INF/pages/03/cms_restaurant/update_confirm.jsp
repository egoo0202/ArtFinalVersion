<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="content">
	<br>
	<div class=title>
		<h1 align="center" style="margin-top: 20px; ">得藝食堂 管理系統</h1>
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
		<form method="post"
			action="<c:url value = "/03/cms/restaurant/updateRestaurant.ctrl"/>">
			<div align='center' style='font-size: x-large; font-weight: bold;'>${year}年&nbsp;${newMonth}月營業時間表</div>
			<br>
			<div align='center' style='font-size: x-large; font-weight: bold;'>
				<input type="submit" class='btn btn-outline-info' name="submit"
					value="修改${newMonth}月營業時間表">
			</div>
			<br>
			<table id="03"
				class="display table table-bordered table-striped table-blue" style="color: #0B1013;">
				<thead class="table-hover">
					<tr style="color: #0B1013;">
						<th style="display: none">日</th>
						<th class='table-warning'>日期</th>
						<th class='table-success'>當日是否營業</th>
						<th class='table-danger'>訂位人數上限</th>
						<th class='table-info'>可訂位時段</th>
					</tr>
				</thead>
				<tfoot></tfoot>
				<tbody style="color: #0B1013; font-size:larger;">
					<c:forEach items="${restaurantList}" var="restaurantList"
						varStatus="vs">
						<tr>
							<td style="display: none">${restaurantList.month}</td>
							<td><input type="hidden" name="day"
								value="${restaurantList.day}">${restaurantList.month}/${restaurantList.day}</td>
							<td><c:choose>
									<c:when test="${restaurantList.open == 1}">
										<div style="width: 150px; ">
											<select name="open" class="custom-select" style="color: #0B1013;">
												<option value="1" selected>營業日</option>
												<option value="0">店休日</option>
											</select>
										</div>
									</c:when>
									<c:otherwise>
										<div style="width: 150px;">
											<select name="open" class="custom-select" style="color: #0B1013;">
												<option value="1">營業日</option>
												<option value="0" selected>店休日</option>
											</select>
										</div>
									</c:otherwise>
								</c:choose></td>
							<td><div style="width: 125px;">
									<select name="maximum" class="custom-select" style="color: #0B1013;">
										<option value="${restaurantList.maximum}" selected>${restaurantList.maximum}位</option>
										<option value="1">1位</option>
										<option value="2">2位</option>
										<option value="3">3位</option>
										<option value="4">4位</option>
										<option value="5">5位</option>
										<option value="6">6位</option>
										<option value="7">7位</option>
										<option value="8">8位</option>
										<option value="9">9位</option>
										<option value="10">10位</option>
										<option value="11">11位</option>
										<option value="12">12位</option>
										<option value="13">13位</option>
										<option value="14">14位</option>
										<option value="15">15位</option>
										<option value="16">16位</option>
										<option value="17">17位</option>
										<option value="18">18位</option>
										<option value="19">19位</option>
										<option value="20">20位</option>
										<option value="21">21位</option>
										<option value="22">22位</option>
										<option value="23">23位</option>
										<option value="24">24位</option>
										<option value="25">25位</option>
										<option value="26">26位</option>
										<option value="27">27位</option>
										<option value="28">28位</option>
										<option value="29">29位</option>
										<option value="30">30位</option>
										<option value="31">31位</option>
										<option value="32">32位</option>
										<option value="33">33位</option>
										<option value="34">34位</option>
										<option value="35">35位</option>
										<option value="36">36位</option>
										<option value="37">37位</option>
										<option value="38">38位</option>
										<option value="39">39位</option>
										<option value="40">40位</option>
										<option value="41">41位</option>
										<option value="42">42位</option>
										<option value="43">43位</option>
										<option value="44">44位</option>
										<option value="45">45位</option>
										<option value="46">46位</option>
										<option value="47">47位</option>
										<option value="48">48位</option>
										<option value="49">49位</option>
										<option value="50">50位</option>
									</select>
								</div></td>
							<td><c:choose>
									<c:when test="${restaurantList.h09 == '-1'}">
										<label>09:00</label>
										<select name="oh09" class="custom-select" style="width: 120px">
											<option value="1">&#x2714;</option>
											<option value="0" selected>&#x2716;</option>
										</select>
									</c:when>
									<c:otherwise>
										<label>09:00</label>
										<select name="oh09" class="custom-select" style="width: 120px">
											<option value="1" selected>&#x2714;</option>
											<option value="0">&#x2716;</option>
										</select>
									</c:otherwise>
								</c:choose> <c:choose>
									<c:when test="${restaurantList.h10 != '-1'}">
										<label>10:00</label>
										<select name="oh10" class="custom-select" style="width: 120px">
											<option value="1" selected>&#x2714;</option>
											<option value="0">&#x2716;</option>
										</select>
									</c:when>
									<c:otherwise>
										<label>10:00</label>
										<select name="oh10" class="custom-select" style="width: 120px">
											<option value="1">&#x2714;</option>
											<option value="0" selected>&#x2716;</option>
										</select>
									</c:otherwise>
								</c:choose> <c:choose>
									<c:when test="${restaurantList.h11 != -1}">
										<label>11:00</label>
										<select name="oh11" class="custom-select" style="width: 120px">
											<option value="1" selected>&#x2714;</option>
											<option value="0">&#x2716;</option>
										</select>
									</c:when>
									<c:otherwise>
										<label>11:00</label>
										<select name="oh11" class="custom-select" style="width: 120px">
											<option value="1">&#x2714;</option>
											<option value="0" selected>&#x2716;</option>
										</select>
									</c:otherwise>
								</c:choose> <br> <c:choose>
									<c:when test="${restaurantList.h12 != -1}">
										<label>12:00</label>
										<select name="oh12" class="custom-select" style="width: 120px">
											<option value="1" selected>&#x2714;</option>
											<option value="0">&#x2716;</option>
										</select>
									</c:when>
									<c:otherwise>
										<label>12:00</label>
										<select name="oh12" class="custom-select" style="width: 120px">
											<option value="1">&#x2714;</option>
											<option value="0" selected>&#x2716;</option>
										</select>
									</c:otherwise>
								</c:choose> <c:choose>
									<c:when test="${restaurantList.h13 != -1}">
										<label>13:00</label>
										<select name="oh13" class="custom-select" style="width: 120px">
											<option value="1" selected>&#x2714;</option>
											<option value="0">&#x2716;</option>
										</select>
									</c:when>
									<c:otherwise>
										<label>13:00</label>
										<select name="oh13" class="custom-select" style="width: 120px">
											<option value="1">&#x2714;</option>
											<option value="0" selected>&#x2716;</option>
										</select>
									</c:otherwise>
								</c:choose> <c:choose>
									<c:when test="${restaurantList.h14 != -1}">
										<label>14:00</label>
										<select name="oh14" class="custom-select" style="width: 120px">
											<option value="1" selected>&#x2714;</option>
											<option value="0">&#x2716;</option>
										</select>
									</c:when>
									<c:otherwise>
										<label>14:00</label>
										<select name="oh14" class="custom-select" style="width: 120px">
											<option value="1">&#x2714;</option>
											<option value="0" selected>&#x2716;</option>
										</select>
									</c:otherwise>
								</c:choose> <br> <c:choose>
									<c:when test="${restaurantList.h15 != -1}">
										<label>15:00</label>
										<select name="oh15" class="custom-select" style="width: 120px">
											<option value="1" selected>&#x2714;</option>
											<option value="0">&#x2716;</option>
										</select>
									</c:when>
									<c:otherwise>
										<label>15:00</label>
										<select name="oh15" class="custom-select" style="width: 120px">
											<option value="1">&#x2714;</option>
											<option value="0" selected>&#x2716;</option>
										</select>
									</c:otherwise>
								</c:choose> <c:choose>
									<c:when test="${restaurantList.h16 != -1}">
										<label>16:00</label>
										<select name="oh16" class="custom-select" style="width: 120px">
											<option value="1" selected>&#x2714;</option>
											<option value="0">&#x2716;</option>
										</select>
									</c:when>
									<c:otherwise>
										<label>16:00</label>
										<select name="oh16" class="custom-select" style="width: 120px">
											<option value="1">&#x2714;</option>
											<option value="0" selected>&#x2716;</option>
										</select>
									</c:otherwise>
								</c:choose> <c:choose>
									<c:when test="${restaurantList.h17 != -1}">
										<label>17:00</label>
										<select name="oh17" class="custom-select" style="width: 120px">
											<option value="1" selected>&#x2714;</option>
											<option value="0">&#x2716;</option>
										</select>
									</c:when>
									<c:otherwise>
										<label>17:00</label>
										<select name="oh17" class="custom-select" style="width: 120px">
											<option value="1">&#x2714;</option>
											<option value="0" selected>&#x2716;</option>
										</select>
									</c:otherwise>
								</c:choose> <br> <c:choose>
									<c:when test="${restaurantList.h18 != -1}">
										<label>18:00</label>
										<select name="oh18" class="custom-select" style="width: 120px">
											<option value="1" selected>&#x2714;</option>
											<option value="0">&#x2716;</option>
										</select>
									</c:when>
									<c:otherwise>
										<label>18:00</label>
										<select name="oh18" class="custom-select" style="width: 120px">
											<option value="1">&#x2714;</option>
											<option value="0" selected>&#x2716;</option>
										</select>
									</c:otherwise>
								</c:choose> <c:choose>
									<c:when test="${restaurantList.h19 != -1}">
										<label>19:00</label>
										<select name="oh19" class="custom-select" style="width: 120px">
											<option value="1" selected>&#x2714;</option>
											<option value="0">&#x2716;</option>
										</select>
									</c:when>
									<c:otherwise>
										<label>19:00</label>
										<select name="oh19" class="custom-select" style="width: 120px">
											<option value="1">&#x2714;</option>
											<option value="0" selected>&#x2716;</option>
										</select>
									</c:otherwise>
								</c:choose> <c:choose>
									<c:when test="${restaurantList.h20 != -1}">
										<label>20:00</label>
										<select name="oh20" class="custom-select" style="width: 120px">
											<option value="1" selected>&#x2714;</option>
											<option value="0">&#x2716;</option>
										</select>
									</c:when>
									<c:otherwise>
										<label>20:00</label>
										<select name="oh20" class="custom-select" style="width: 120px">
											<option value="1">&#x2714;</option>
											<option value="0" selected>&#x2716;</option>
										</select>
									</c:otherwise>
								</c:choose> <br> <c:choose>
									<c:when test="${restaurantList.h21 != -1}">
										<label>21:00</label>
										<select name="oh21" class="custom-select" style="width: 120px">
											<option value="1" selected>&#x2714;</option>
											<option value="0">&#x2716;</option>
										</select>
									</c:when>
									<c:otherwise>
										<label>21:00</label>
										<select name="oh21" class="custom-select" style="width: 120px">
											<option value="1">&#x2714;</option>
											<option value="0" selected>&#x2716;</option>
										</select>
									</c:otherwise>
								</c:choose></td>
							<td style="display: none"><input type="hidden"
								name="restaurantNo" value="${restaurantList.restaurantNo}">
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<!-- ====================================================== -->
			<div style="display: none">
				<input type="hidden" name="newMonth" value="${newMonth}">
			</div>
			<br>
			<div align='center' style='font-size: x-large; font-weight: bold;'>
				<input type="submit" class='btn btn-outline-info' name="submit"
					value="修改${newMonth}月營業時間表">
			</div>
			<br>
		</form>
	</div>
</div>
<!-- ====================================================== -->
