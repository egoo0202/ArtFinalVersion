<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>更新資料結果</title>
</head>
<body>
<br>
<div class=title align="center">
	<h1>${updateResult}</h1>
</div>
<div class="back" align="right">
	<form action="<c:url value='/35/selectAll.ctrl'/> " method="get">
		<div class="submitButton">
			<input type="submit" class="" name="submit" value="返回租借場地管理頁面"> 
		</div>
	</form>
</div>
	<c:if test="${updateResult.equals('更新成功')}">
		<h1 align="center">以下是更新的資料明細</h1>
		<br>
		<table style="margin-bottom: 0" class="table table-bordered table-hover table-blue">
		<tr>
		<th class="table-secondary">場地名稱</th>
		<th class="table-success">場地所屬單位</th>
		<th class="table-primary">地址</th>
		<th class="table-secondary">場地類型</th>
		<th class="table-primary">鄰近的商圈</th>
		<th class="table-success">鄰近的大眾運輸工具</th>
		<th class="table-primary">場地容納人數上限</th>
		<th class="table-danger">每坪租金</th>
		<th class="table-secondary">場地面積</th>
		<th class="table-success">可供租借時段</th>
		<th class="table-danger">鄰近活動資訊</th>
		<th class="table-success">聯絡資訊</th>
		</tr>
		<tr>
		<td>${eventSpace.name}</td>
		<td>${eventSpace.owner}</td>
		<td>${eventSpace.address}</td>
		<td>${eventSpace.type}</td>
		<td>${eventSpace.shoppingArea}</td>
		<td>${eventSpace.transportation}</td>
		<td>${eventSpace.capacity}</td>
		<td>${eventSpace.unitPrice}</td>
		<td>${eventSpace.area}</td>
		<td>${eventSpace.rentalTime}</td>
		<td>${eventSpace.activityInfo}</td>
		<td>${eventSpace.contactInfo}</td>
		</tr>
		</table>
	</c:if>
</body>
</html>