<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
$(document).ready( function () {
    $('#table_11').DataTable();
} );
</script>
</head>
<div>
	<span align="center"> 
		<a href="GoCreate.ctrl">新增</a>&nbsp;&nbsp; 
		<a href="GoDel.ctrl">刪除</a>&nbsp;&nbsp;
		<a href="GoSearch.ctrl">查詢</a>&nbsp;&nbsp; 
		<a href="myStreetArtistPage.ctrl">總覽</a>
	</span>
</div>
	<table id="table_11" class="display">
		<thead>
			<tr>
				<th>藝人細項</th>
			</tr>
		</thead>
		
		<tbody>
			<tr class="title">
				<th>編號</th>
				<th>藝名</th>
				<th>來自</th>
				<th>表演項目</th>
				<th>分類</th>
				<th>已被斗內</th>
			</tr>
			<c:forEach var="reFixSA" varStatus="stat" items="${dataForWeb}">
			<tr>
				<td>${reFixSA.id_SA }</td>
				<td>${reFixSA.name_SA }</td>
				<td>${reFixSA.country_SA }</td>
				<td>${reFixSA.theme_SA }</td>
				<td>${reFixSA.classification_SA }</td>
				<td>${Donation } 元</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
</html>