<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>可租借場地清單</title>
</head>
<body>
	<br>
	<div class="title">
		<h1 align="center">目前開放租借的場地如下</h1>
	</div>
	<br>
	<div class="addData" align="right">
		<form action="<c:url value='/35/addData'/> " method="get">
			<div class="submitButton">
				<input type="submit" class="" name="submit" value="新增場地資料">
			</div>
		</form>
	</div>
	<div class="deleteResult" align="center">
		<h2>${deleteResult}</h2>
		<br>
	</div>
	<div class="select" align="center">
		<form action="<c:url value='/35/select.ctrl'/> " method="get">
			<div class="submitButton">
				<label>輸入場地名稱查詢</label> 
				<input type="text" name="select" value="">
				<input type="submit" name="submit" value="送出"> 
				<input type="reset" name="reset" value="清除">
			</div>
		</form>
	</div>
	<br>
	<div class="content">
		<table id="35"
			class="display table table-bordered table-hover table-blue">
			<thead>
				<tr class="">
					<th class="table-secondary">場地名稱</th>
					<th class="table-warning">場地所屬單位</th>
					<th class="table-light">地址</th>
					<th class="table-secondary">場地類型</th>
					<th class="table-success">鄰近的商圈</th>
					<th class="table-danger">鄰近的大眾運輸工具</th>
					<th class="table-primary">場地容納人數上限</th>
					<th class="table-info">每坪租金</th>
					<th class="table-danger">場地面積</th>
					<th class="table-primary">可供租借時段</th>
					<th class="table-info">鄰近活動資訊</th>
					<th class="table-success">聯絡資訊</th>
					<th class="table-info">修改場地資訊</th>
					<th class="table-success">刪除此筆場地</th>
				</tr>
			</thead>
			<tbody>
				<c:set var="counter" value="0" />
				<c:forEach var="list" items="${eventSpaceList}">
					<c:set var="counter" value="${counter+1}" />
					<tr>
						<td class="">${list.name}</td>
						<td class="">${list.owner}</td>
						<td class="">${list.address}</td>
						<td class="">${list.type}</td>
						<td class="">${list.shoppingArea}</td>
						<td class="">${list.transportation}</td>
						<td class="">${list.capacity}</td>
						<td class="">${list.unitPrice}</td>
						<td class="">${list.area}</td>
						<td class="">${list.rentalTime}</td>
						<td class="">${list.activityInfo}</td>
						<td class="">${list.contactInfo}</td>
						<td class="update">
							<form action="<c:url value='/35/editEventSpace'/> " method="get">
								<div class="submitButton">
									<input type="hidden" name="id" value="${list.id}"> <input
										type="hidden" name="name" value="${list.name}"> <input
										type="hidden" name="owner" value="${list.owner}"> <input
										type="hidden" name="address" value="${list.address}">
									<input type="hidden" name="type" value="${list.type}">
									<input type="hidden" name="shoppingArea"
										value="${list.shoppingArea}"> <input type="hidden"
										name="transportation" value="${list.transportation}">
									<input type="hidden" name="capacity" value="${list.capacity}">
									<input type="hidden" name="unitPrice" value="${list.unitPrice}">
									<input type="hidden" name="area" value="${list.area}">
									<input type="hidden" name="rentalTime"
										value="${list.rentalTime}"> <input type="hidden"
										name="activityInfo" value="${list.activityInfo}"> <input
										type="hidden" name="contactInfo" value="${list.contactInfo}">
									<input class="genric-btn primary radius" type="submit" name="submit" value="修改">
								</div>
							</form>
						</td>
						<td class="delete">
							<form action="<c:url value='/35/delete.ctrl'/> " method="GET">
								<div class="submitButton">
									<input type="hidden" name="name" value="${list.name}">
									<input class="genric-btn primary radius" type="submit" name="submit" value="刪除">
								</div>
							</form>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
<script>
$(document).ready( function () {
    $('#35').DataTable( {
        scrollY: 400,
        "language": {
        	"search": "搜尋:",
            "lengthMenu": "每頁展示 _MENU_ 個項目",
            "zeroRecords": "抱歉，查無搜尋結果",
            "info": "展示第 _PAGE_ 頁，總計 _PAGES_ 頁",
            "infoEmpty": "沒有紀錄",
            "infoFiltered": "(filtered from _MAX_ total records)",
            "paginate": {
                "first":      "第一頁",
                "last":       "最後一頁",
                "next":       "下一頁",
                "previous":   "前一頁"
            }
        }
    } );
});
</script>
</body>
</html>