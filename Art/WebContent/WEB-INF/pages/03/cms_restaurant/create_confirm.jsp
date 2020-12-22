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
			<div class="submitButton" >
				<input type="submit" class='btn btn-outline-info' name="submit" value="返回 營業時間管理">
			</div>
		</form>
	</div>
	<div>
		<form method="post"
			action="<c:url value = "/03/cms/restaurant/createRestaurant.ctrl"/>">
			<div align='center' style='font-size: x-large; font-weight:bold;'>${year}年&nbsp;${newMonth}月營業時間表</div>
			<br>
			<div align='center' style='font-size: x-large; font-weight:bold;'>
				<input type="submit" class='btn btn-outline-info' name="submit" value="建立${newMonth}月營業時間表" >
			</div>
			<br>
			<table id="03A" style="margin-bottom: 0px" 
				class="display table table-bordered table-striped table-blue">
				<thead class="table-hover">
					<tr style="color: #0B1013;">
						<th style="display: none">日</th>
						<th class='table-warning'>日期</th>
						<th class='table-success'>當日是否營業</th>
						<th class='table-danger'>訂位人數上限</th>
						<th class='table-info'>可訂位時段</th>
					</tr>
				</thead>
				<tbody style="color: #0B1013; font-size:larger;">
					<c:forEach items="${dayList}" var="dayList" varStatus="vs">
						<tr>
							<td style="display: none"><input type="hidden">${dayList}</td>
							<td><input type="hidden" name="day" value="${dayList}">${newMonth}/${dayList}</td>
							<td>
								<div style="width: 150px">
									<select name="open" class="custom-select" style="color: #0B1013; ">
										<option value="1" selected>營業日</option>
										<option value="0">店休日</option>
									</select>
								</div>
							</td>
							<td><div style="width: 125px">
									<select name="maximum" class="custom-select" style="color: #0B1013;">
										<option value="1" selected>1位</option>
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
										<option value="15" selected>15位</option>
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
							<td><label>09:00</label> 
							<select name="h09" class="custom-select" style="width: 120px">
									<option value="1" selected>&#x2714;</option>
									<option value="0">&#x2716;</option>
							</select> 
							<label>10:00</label> <select name="h10" class="custom-select"
								style="width: 120px">
									<option value="1" selected>&#x2714;</option>
									<option value="0">&#x2716;</option>
							</select> <label>11:00</label> <select name="h11" class="custom-select"
								style="width: 120px">
									<option value="1" selected>&#x2714;</option>
									<option value="0">&#x2716;</option>
							</select> <br> <label>12:00</label> <select name="h12"
								class="custom-select" style="width: 120px">
									<option value="1" selected>&#x2714;</option>
									<option value="0">&#x2716;</option>
							</select> <label>13:00</label> <select name="h13" class="custom-select"
								style="width: 120px">
									<option value="1" selected>&#x2714;</option>
									<option value="0">&#x2716;</option>
							</select> <label>14:00</label> <select name="h14" class="custom-select"
								style="width: 120px">
									<option value="1" selected>&#x2714;</option>
									<option value="0">&#x2716;</option>
							</select> <br> <label>15:00</label> <select name="h15"
								class="custom-select" style="width: 120px">
									<option value="1" selected>&#x2714;</option>
									<option value="0">&#x2716;</option>
							</select> <label>16:00</label> <select name="h16" class="custom-select"
								style="width: 120px">
									<option value="1" selected>&#x2714;</option>
									<option value="0">&#x2716;</option>
							</select> <label>17:00</label> <select name="h17" class="custom-select"
								style="width: 120px">
									<option value="1" selected>&#x2714;</option>
									<option value="0">&#x2716;</option>
							</select> <br> <label>18:00</label> <select name="h18"
								class="custom-select" style="width: 120px">
									<option value="1" selected>&#x2714;</option>
									<option value="0">&#x2716;</option>
							</select> <label>19:00</label> <select name="h19" class="custom-select"
								style="width: 120px">
									<option value="1" selected>&#x2714;</option>
									<option value="0">&#x2716;</option>
							</select> <label>20:00</label> <select name="h20" class="custom-select"
								style="width: 120px">
									<option value="1" selected>&#x2714;</option>
									<option value="0">&#x2716;</option>
							</select> <br> <label>21:00</label> <select name="h21"
								class="custom-select" style="width: 120px">
									<option value="1" selected>&#x2714;</option>
									<option value="0">&#x2716;</option>
							</select></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<div style="display: none">
				<input type="hidden" name="year" value="${year}">
			</div>
			<div style="display: none">
				<input type="hidden" name="month" value="${month}">
				<input type="hidden" name="newMonth" value="${newMonth}">
			</div>
			<!-- ====================================================== -->
			<br>
			<div align='center' style='font-size: x-large; font-weight:bold;'>
				<input type="submit" class='btn btn-outline-info' name="submit" value="建立${newMonth}月營業時間表" >
			</div>
			<br>
		</form>
	</div>
</div>
<!-- ====================================================== -->





