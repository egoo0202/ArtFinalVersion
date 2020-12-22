<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>填寫新增的資料</title>
<style>
.addForm {
	width: 360px;
	margin: 0 auto;
}
</style>
</head>
<body>
<br>
<br>
<h1 align="center">請填寫場地詳細資訊</h1>
<div class="back" align="center">
	<form action="<c:url value='/35/selectAll.ctrl'/> " method="get">
		<div class="submitButton">
			<input type="submit" class="" name="submit" value="返回租借場地管理"> 
		</div>
	</form>
</div>
<br>
<form action="<c:url value='/35/insertInto.ctrl'/> " method="get" id="addData">
	<div class="form-row">
		<div class="col-md-3 mb-4">
			<label>場地名稱</label>
			<input type="text" class="" name="name" value=""><br>
		</div>
		<div class="col-md-3 mb-4">	
			<label>場地所屬單位</label>
			<input type="text" class="" name="owner" value=""><br>
		</div>
		<div class="col-md-3 mb-4">	
			<label>地址</label> 
			<input type="text" class="" name="address" value=""><br>
		</div>
		<div class="col-md-3 mb-4">			
			<label>場地類型</label> 
			<input type="text" class="" name="type" value=""><br>
		</div>
	</div>
	<div class="form-row">
		<div class="col-md-3 mb-4">	
			<label>鄰近的商圈</label> 
			<input type="text" class="" name="shoppingArea" value=""><br>
		</div>
		<div class="col-md-3 mb-4">	
			<label>鄰近的大眾運輸工具</label> 
			<input type="text" class="" name="transportation" value=""><br>
		</div>
		<div class="col-md-3 mb-4">	
			<label>場地容納人數上限</label> 
			<input type="text" class="" name="capacity" value=""><br> 
		</div>
		<div class="col-md-3 mb-4">	
			<label>每坪租金</label> 
			<input type="text" class="" name="unitPrice" value=""><br> 
		</div>
	</div>
	<div class="form-row">
		<div class="col-md-3 mb-4">	
			<label>場地面積</label> 
			<input type="text" class="" name="area" value=""><br> 
		</div>
		<div class="col-md-3 mb-4">	
			<label>可供租借時段</label> 
			<input type="text" class="" name="rentalTime" value=""><br> 
		</div>
		<div class="col-md-3 mb-4">	
			<label>鄰近活動資訊</label> 
			<input type="text" class="" name="activityInfo" value=""><br> 
		</div>
		<div class="col-md-3 mb-4">	
			<label>聯絡資訊</label> 
			<input type="text" class="" name="contactInfo" value=""><br> 
		</div>
	</div>
	<div id="btnArea" align="center">
		<input type="submit" class="btn btn-info" name="submit" id="submit" value="儲存"/>
	    <input type="reset" class="btn btn-info" name="cancel" id="cancel" value="重填">
	</div>
</form>
</body>
</html>