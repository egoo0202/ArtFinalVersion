<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	
</style>
</head>
<body>
<h1 align="center" style="color:red;">Success to ${name} !!</h1>
<div align="center">
	<span>
 		<input type="button" onclick="location.href='<c:url value="/myStreetArtistPage.ctrl"/>'" value="回總覽">
 	</span>
 </div>
</body>
</html>