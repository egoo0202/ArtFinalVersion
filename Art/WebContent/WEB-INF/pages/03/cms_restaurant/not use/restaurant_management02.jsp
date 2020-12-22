<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div>
	<br>
	<div class=title>
		<h1 align="center" style="margin-top: 20px;">得藝食堂 管理系統</h1>
	</div>
	<br>
	<div class="container">
		<div class=content>
			<table id="03A" class="display table table-hover table-blue">
				<thead>
					<tr class="head">
						<th scope="col" colspan="5" class="table-warning"><div
								align="center"
								style="font-size: x-large; font-weight: bold; color: #808080;">營業時間管理</div></th>
					</tr>
				</thead>
				<tfoot></tfoot>
				<tbody>
					<tr class='table-info'>
						<td style="font-size: larger; line-height: 60px;" width="180px"><div
								style="vertical-align: middle; color: #0B1013;">&nbsp;月份查詢</div></td>
						<td style="font-size: larger; line-height: 60px;" width="200px"><div
								style="vertical-align: middle; color: #0B1013;">&nbsp;請選擇年、月</div></td>
						<td style="line-height: 60px; color: #0B1013;" width="225px"><select
							id="year" name="year" class="custom-select"
							style="color: #0B1013; width: 180px" required="required">
								<option selected value="2020">2020年</option>
								<option value="2021">2021年</option>
						</select></td>
						<td style="line-height: 60px;"><select id="month"
							name="month" class="custom-select"
							style="color: #0B1013; width: 180px" required="required">
								<option value="01">1月</option>
								<option value="02">2月</option>
								<option value="03">3月</option>
								<option value="04">4月</option>
								<option value="05">5月</option>
								<option value="06">6月</option>
								<option value="07">7月</option>
								<option value="08">8月</option>
								<option value="09">9月</option>
								<option value="10">10月</option>
								<option value="11">11月</option>
								<option selected value="12">12月</option>
						</select></td>
						<td style="line-height: 60px; vertical-align: middle;">&nbsp;&nbsp;&nbsp;<input
							id="btn" class='btn btn-info' type="button" value="查詢"></td>
					</tr>
					<tr class='table-danger'>
						<td style="font-size: larger; line-height: 60px;">
							<form id="form00">
								<div style="vertical-align: middle; color: #0B1013;">&nbsp;單日查詢</div>
							</form>
						</td>
						<td style="font-size: larger; line-height: 60px;"><div
								style="vertical-align: middle; color: #0B1013;">&nbsp;請選擇日期&nbsp;</div></td>
						<td style="line-height: 60px; color: #0B1013;"><input
							form="form00" type="date" style="color: #0B1013;" name="dateTime"
							id="dateTime" value="2020-12-25" class="custom-select"
							min="2020-12-25" max="2021-01-24" required="required"></td>
						<td style="font-size: larger; line-height: 60px;"><div
								style="vertical-align: middle; color: #0B1013;">&nbsp;</div></td>
						<td style="line-height: 60px; vertical-align: middle;">&nbsp;&nbsp;&nbsp;<input
							form="form00" id="btn02" class='btn btn-info' type="button"
							value="查詢"></td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
	<br>
	<div class=content id="result"></div>
	<br>
</div>
<!-- ====================================================== -->
<script>
	$(document).ready(function() {
		$('#03A').DataTable({});
	});

	window.onload = function() {
		var btn = document.getElementById("btn"); //按鈕的事件處理函數

		btn.onclick = function() {

			var year = document.getElementById("year").value;
			var month = document.getElementById("month").value;

			// 生成頁面顯示的月份資料
			if (month == 01) {
				var newMonth = "1";

			} else if (month == 02) {
				var newMonth = "2";

			} else if (month == 03) {
				var newMonth = "3";

			} else if (month == 04) {
				var newMonth = "4";

			} else if (month == 05) {
				var newMonth = "5";

			} else if (month == 06) {
				var newMonth = "6";

			} else if (month == 07) {
				var newMonth = "7";

			} else if (month == 08) {
				var newMonth = "8";

			} else if (month == 09) {
				var newMonth = "9";

			} else if (month == 10) {
				var newMonth = "10";

			} else if (month == 11) {
				var newMonth = "11";

			} else if (month == 12) {
				var newMonth = "12";

			} else {
				var newMonth = "1";
			}

			// 送出Request
			var xhr = new XMLHttpRequest();

			xhr
					.open(
							"POST",
							"<c:url value='/03/cms/restaurant/searchByYearMonth.ctrl' />",
							true);

			xhr.setRequestHeader("Content-type",
					"application/x-www-form-urlencoded");
			xhr.send("year=" + year + "&month=" + month);

			xhr.onreadystatechange = function() {
				// 向伺服器提出的請求已經收到回應
				if (xhr.readyState == 4 && xhr.status == 200) {
					// status: HTTP通訊協定的狀態碼伺服器，
					// 200表示Server成功的處理請求
					// getResponseHeader: 取得回應內容的MIME Type

					var restaurantList = JSON.parse(xhr.responseText);

					// 假如有預約資料
					if (restaurantList.length > 0) {

						// 插入該月營業時間表已存在
						var content = "<div class='submitButton' align='center' style='font-size: larger; font-weight:bold;'>"
								+ newMonth + "月營業時間表已存在</div><br>";

						// 插入詳情(X)、更新與刪除的按鈕表單
						content += "<div class='submitButton' align='left' style='font-size: larger;'>";

						// 插入排版用的TABLE
						content += "<table><tr>";

						// 排版用的td
						content += "<td>&emsp;</td>";

						// 插入更新的 From 表單
						content += "<td><div><form method='post' action='<c:url value='/03/cms/restaurant/updateRestaurantConfirm.ctrl'/>'> ";
						// 預約編號的迴圈
						for (var i = 0; i < restaurantList.length; i++) {
							content += "<div style='display: none'><Input type='hidden' name='restaurantNo' value=" + restaurantList[i].restaurantNo +"></div>";
						}
						content += "<button name='updateButton' type='submit' class='btn btn-outline-info'>修改"
								+ newMonth
								+ "月營業時間表</button>"
								+ "<div style='display: none'><Input type='hidden' name='newMonth' value=" + newMonth +"></div>"
								+ "</form></div></td>";

						// 排版用的td
						content += "<td>&nbsp;&nbsp;</td>";

						// 插入刪除的 From 表單
						content += "<td><div><form method='post' action='<c:url value='/03/cms/restaurant/deleteRestaurant.ctrl'/>'> ";
						// 預約編號的迴圈
						for (var i = 0; i < restaurantList.length; i++) {
							content += "<div style='display: none'><Input type='hidden' name='restaurantNo' value=" + restaurantList[i].restaurantNo +"></div>";
						}
						content += "<button name='deleteButton' type='submit' class='btn btn-outline-info'>刪除"
								+ newMonth
								+ "月營業時間表</button>"
								+ "<div style='display: none'><Input type='hidden' name='year' value=" + year +"></div>"
								+ "<div style='display: none'><Input type='hidden' name='newMonth' value=" + newMonth +"></div>"
								+ "</form></div></td></tr></table>"
								+ "</div><br>";

						// 插入查詢結果 table
						content += "<table id='03B' class='display table table-bordered table-striped table-blue'>";
						content += "<thead class='table-hover'><tr style='color: #0B1013;'><th class='table-warning'>日期</th><th class='table-success'>當日是否營業</th>";
						content += "<th class='table-danger'>線上訂位人數上限</th><th class='table-info'>可訂位時段</th></tr></thead><tbody style='color: #0B1013; font-size:larger;'>";

						// 迴圈印出預約資料
						for (var i = 0; i < restaurantList.length; i++) {
							if (restaurantList[i].open == 0) {
								var openMsg = "店休日";
								var people = "無法訂位 (店休日)";
							} else {
								var openMsg = "營業日";
								var people = restaurantList[i].maximum + "位";
							}

							content += "<tr><td>" + newMonth + "/"
									+ restaurantList[i].day + "</td>" + "<td>"
									+ openMsg + "</td>" + "<td>" + people
									+ "</td><td>";

							if (restaurantList[i].h09 == -1) {
								content += "<label>09:00</label>&nbsp;"
										+ "&#x2716;&emsp;";
							} else {
								content += "<label>09:00</label>&nbsp;"
										+ "&#x2714;&emsp;";
							}
							if (restaurantList[i].h10 == -1) {
								content += "<label>10:00</label>&nbsp;"
										+ "&#x2716;&emsp;";
							} else {
								content += "<label>10:00</label>&nbsp;"
										+ "&#x2714;&emsp;";
							}
							if (restaurantList[i].h11 == -1) {
								content += "<label>11:00</label>&nbsp;"
										+ "&#x2716;&emsp;";
							} else {
								content += "<label>11:00</label>&nbsp;"
										+ "&#x2714;&emsp;";
							}
							if (restaurantList[i].h12 == -1) {
								content += "<label>12:00</label>&nbsp;"
										+ "&#x2716;<br>";
							} else {
								content += "<label>12:00</label>&nbsp;"
										+ "&#x2714;<br>";
							}
							if (restaurantList[i].h13 == -1) {
								content += "<label>13:00</label>&nbsp;"
										+ "&#x2716;&emsp;";
							} else {
								content += "<label>13:00</label>&nbsp;"
										+ "&#x2714;&emsp;";
							}
							if (restaurantList[i].h14 == -1) {
								content += "<label>14:00</label>&nbsp;"
										+ "&#x2716;&emsp;";
							} else {
								content += "<label>14:00</label>&nbsp;"
										+ "&#x2714;&emsp;";
							}
							if (restaurantList[i].h15 == -1) {
								content += "<label>15:00</label>&nbsp;"
										+ "&#x2716;&emsp;";
							} else {
								content += "<label>15:00</label>&nbsp;"
										+ "&#x2714;&emsp;";
							}
							if (restaurantList[i].h16 == -1) {
								content += "<label>16:00</label>&nbsp;"
										+ "&#x2716;<br>";
							} else {
								content += "<label>16:00</label>&nbsp;"
										+ "&#x2714;<br>";
							}
							if (restaurantList[i].h17 == -1) {
								content += "<label>17:00</label>&nbsp;"
										+ "&#x2716;&emsp;";
							} else {
								content += "<label>17:00</label>&nbsp;"
										+ "&#x2714;&emsp;";
							}
							if (restaurantList[i].h18 == -1) {
								content += "<label>18:00</label>&nbsp;"
										+ "&#x2716;&emsp;";
							} else {
								content += "<label>18:00</label>&nbsp;"
										+ "&#x2714;&emsp;";
							}
							if (restaurantList[i].h19 == -1) {
								content += "<label>19:00</label>&nbsp;"
										+ "&#x2716;&emsp;";
							} else {
								content += "<label>19:00</label>&nbsp;"
										+ "&#x2714;&emsp;";
							}
							if (restaurantList[i].h20 == -1) {
								content += "<label>20:00</label>&nbsp;"
										+ "&#x2716;<br>";
							} else {
								content += "<label>20:00</label>&nbsp;"
										+ "&#x2714;<br>";
							}
							if (restaurantList[i].h21 == -1) {
								content += "<label>21:00</label>&nbsp;"
										+ "&#x2716;";
							} else {
								content += "<label>21:00</label>&nbsp;"
										+ "&#x2714;";
							}

						}
						content += "</td></tr></tbody></table><br>";

						var result = document.getElementById("result");
						result.innerHTML = content;
					} else {
						// 假如沒有該月營業時間表
						// 新增的 From

						var content = "<div class='submitButton' align='center' style='font-size: larger; font-weight:bold;'>查無"
								+ newMonth + "月營業時間表</div><br>"
						content += "<div><form method='post' action='<c:url value='/03/cms/restaurant/createRestaurantConfirm.ctrl'/>' > "
								+ "<div class='submitButton' align='center' style='font-size: larger'> "
								+ "<div style='display: none'>"
								+ "<Input type='hidden' name='year' value=" + year +">"
								+ "<Input type='hidden' name='month' value=" + month +">"
								+ "</div>"
								+ "<button type='submit' class='btn btn-outline-info'>建立"
								+ newMonth
								+ "月營業時間表</button>"
								+ "</div></form></div><br><br>";
						var result = document.getElementById("result");
						result.innerHTML = content;
					}
				}
			}
		}
	}

	// 單日資料
	window.onload = function() {
		var btn02 = document.getElementById("btn02"); //按鈕的事件處理函數

		btn02.onclick = function() {

			var dateTime = document.getElementById("dateTime").value;

			// 送出Request
			var xhr = new XMLHttpRequest();

			xhr
					.open(
							"POST",
							"<c:url value='/03/cms/restaurant/searchByDateTime.ctrl' />",
							true);

			xhr.setRequestHeader("Content-type",
					"application/x-www-form-urlencoded");

			xhr.send("dateTime=" + dateTime);

			xhr.onreadystatechange = function() {
				// 向伺服器提出的請求已經收到回應
				if (xhr.readyState == 4 && xhr.status == 200) {
					// status: HTTP通訊協定的狀態碼伺服器，
					// 200表示Server成功的處理請求
					// getResponseHeader: 取得回應內容的MIME Type

					var restaurantList02 = JSON.parse(xhr.responseText);

					// 假如有預約資料
					if (restaurantList02.length > 0) {

						// 插入查詢結果 table
						content += "<table id='03B' class='display table table-bordered table-striped table-blue'>";
						content += "<thead class='table-hover'><tr style='color: #0B1013;'>";

						content += "<th>日期</th>"
								+ " <th class='table-warning'>營業狀況</th>"
								+ "<th class='table-success'>9點</th>"
								+ "<th class='table-danger'>10點</th>"
								+ "<th class='table-info'>11點</th>"
								+ "<th class='table-warning'>12點</th>"
								+ "<th class='table-success'>13點</th>"
								+ "<th class='table-danger'>14點</th>"
								+ "<th class='table-info'>15點</th>"
								+ "<th class='table-warning'>16點</th>"
								+ "<th class='table-success'>17點</th>"
								+ "<th class='table-danger'>18點</th>"
								+ "<th class='table-info'>19點</th>"
								+ "<th class='table-warning'>20點</th>"
								+ "<th class='table-success'>21點</th>";

						content += "</tr></thead><tbody style='color: #0B1013; font-size:larger;'>";

						// 迴圈印出預約資料
						for (var i = 0; i < restaurantList02.length; i++) {

							if (restaurantList02[i].open == 0) {
								var openMsg = "店休";
							} else {
								var openMsg = "營業";
							}

							if (restaurantList02[i].h09 == -1) {
								var nh09 = "不可訂位";
							} else {
								var nh09 = restaurantList02[i].h09;

							}
							if (restaurantList02[i].h10 == -1) {

								var nh10 = "不可訂位";
							} else {
								var nh10 = restaurantList02[i].h10;

							}
							if (restaurantList02[i].h11 == -1) {

								var nh11 = "不可訂位";
							} else {
								var nh11 = restaurantList02[i].h11;

							}
							if (restaurantList02[i].h12 == -1) {

								var nh12 = "不可訂位";
							} else {
								var nh12 = restaurantList02[i].h12;

							}
							if (restaurantList02[i].h13 == -1) {

								var nh13 = "不可訂位";
							} else {
								var nh13 = restaurantList02[i].h13;

							}
							if (restaurantList02[i].h14 == -1) {

								var nh14 = "不可訂位";
							} else {
								var nh14 = restaurantList02[i].h14;

							}
							if (restaurantList02[i].h15 == -1) {

								var nh15 = "不可訂位";
							} else {
								var nh15 = restaurantList02[i].h15;

							}
							if (restaurantList02[i].h16 == -1) {

								var nh16 = "不可訂位";
							} else {
								var nh16 = restaurantList02[i].h16;

							}
							if (restaurantList02[i].h17 == -1) {

								var nh17 = "不可訂位";
							} else {
								var nh17 = restaurantList02[i].h17;

							}
							if (restaurantList02[i].h18 == -1) {

								var nh18 = "不可訂位";
							} else {
								var nh18 = restaurantList02[i].h18;

							}
							if (restaurantList02[i].h19 == -1) {

								var nh19 = "不可訂位";
							} else {
								var nh19 = restaurantList02[i].h19;

							}
							if (restaurantList02[i].h20 == -1) {
								var nh20 = "不可訂位";
							} else {
								var nh20 = restaurantList02[i].h20;
							}
							if (restaurantList02[i].h21 == -1) {
								var nh21 = "不可訂位";
							} else {
								var nh21 = restaurantList02[i].h21;
							}

							content += "<tr><td>" + restaurantList02[i].month
									+ "/" + restaurantList02[i].day + "</td>"
									+ "<td>" + openMsg + "</td>" + "<td>"
									+ nh09 + "</td>" + "<td>" + nh10 + "</td>"
									+ "<td>" + nh11 + "</td>" + "<td>" + nh12
									+ "</td>" + "<td>" + nh13 + "</td>"
									+ "<td>" + nh14 + "</td>" + "<td>" + nh15
									+ "</td>" + "<td>" + nh16 + "</td>"
									+ "<td>" + nh17 + "</td>" + "<td>" + nh18
									+ "</td>" + "<td>" + nh19 + "</td>"
									+ "<td>" + nh20 + "</td>" + "<td>" + nh21
									+ "</td><td>";
						}
						content += "</td></tr></tbody></table><br>";

						var result = document.getElementById("result");
						result.innerHTML = content;
					} else {
						// 假如沒有該月營業時間表
						// 新增的 From

						var content = "<div class='submitButton' align='center' style='font-size: larger; font-weight:bold;'>查無當日營業時間表</div><br>"

						var result = document.getElementById("result");
						result.innerHTML = content;
					}
				}
			}
		}
	}
</script>