<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DEL</title>
</head>
<div align="center">
	<span style="border: outset; background-color: rgb(239, 243, 11);margin: 1px;" > 
		<a href="GoCreate.ctrl">新增</a>&nbsp;&nbsp; 
		<a href="GoDel.ctrl">刪除</a>&nbsp;&nbsp;
		<a href="GoSearch.ctrl">查詢</a>&nbsp;&nbsp; 
		<a href="myStreetArtistPage.ctrl">總覽</a>
	</span>
</div>
	<table>
	
	<tbody>
		<form:form action="delSA.ctrl" method="POST"
			modelAttribute="streetArtist">
			<tr>
				<td colspan="2" align="center" style="color: red">說說看，你討厭誰？</td>
			</tr>
			<tr>
				<td><form:label path="id_SA">請給我編號：</form:label></td>
				<td><form:input path="id_SA" /></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><form:button value="Send">刪除</form:button></td>
			</tr>
		</form:form>
	</tbody>
	</table>
</html>