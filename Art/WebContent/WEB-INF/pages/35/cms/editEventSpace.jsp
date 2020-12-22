<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>更新租借場地資訊</title>
</head>
<body>
<br>
<br>
<h1 align="center">請確認修改資訊</h1>
<div class="back" align="center">
	<form action="<c:url value='/35/selectAll.ctrl'/> " method="get">
		<div class="submitButton">
			<input type="submit" class="" name="submit" value="返回租借場地管理"> 
		</div>
	</form>
</div>
<br>
<form action="<c:url value='/35/update.ctrl'/> " method="get" id="editData">
	<div class="form-row">
		<div class="col-md-3 mb-4">
			<input type="hidden" class="" name="id" value="${list.get(0)}">
			<label>場地名稱</label>
			<input type="text" class="" name="name" value="${list.get(1)}"><br>
		</div>
		<div class="col-md-3 mb-4">	
			<label>場地所屬單位</label>
			<input type="text" class="" name="owner" value="${list.get(2)}"><br>
		</div>
		<div class="col-md-3 mb-4">	
			<label>地址</label> 
			<input type="text" class="" name="address" value="${list.get(3)}"><br>
		</div>
		<div class="col-md-3 mb-4">			
			<label>場地類型</label> 
			<input type="text" class="" name="type" value="${list.get(4)}"><br>
		</div>
	</div>
	<div class="form-row">
		<div class="col-md-3 mb-4">	
			<label>鄰近的商圈</label> 
			<input type="text" class="" name="shoppingArea" value="${list.get(5)}"><br>
		</div>
		<div class="col-md-3 mb-4">	
			<label>鄰近的大眾運輸工具</label> 
			<input type="text" class="" name="transportation" value="${list.get(6)}"><br>
		</div>
		<div class="col-md-3 mb-4">	
			<label>場地容納人數上限</label> 
			<input type="text" class="" name="capacity" value="${list.get(7)}"><br> 
		</div>
		<div class="col-md-3 mb-4">	
			<label>每坪租金</label> 
			<input type="text" class="" name="unitPrice" value="${list.get(8)}"><br> 
		</div>
	</div>
	<div class="form-row">
		<div class="col-md-3 mb-4">	
			<label>場地面積</label> 
			<input type="text" class="" name="area" value="${list.get(9)}"><br> 
		</div>
		<div class="col-md-3 mb-4">	
			<label>可供租借時段</label> 
			<input type="text" class="" name="rentalTime" value="${list.get(10)}"><br> 
		</div>
		<div class="col-md-3 mb-4">	
			<label>鄰近活動資訊</label> 
			<input type="text" class="" name="activityInfo" value="${list.get(11)}"><br> 
		</div>
		<div class="col-md-3 mb-4">	
			<label>聯絡資訊</label> 
			<input type="text" class="" name="contactInfo" value="${list.get(12)}"><br> 
		</div>
	</div>
	<div id="btnArea" align="center">
		<input type="submit" class="btn btn-info" name="submit" id="submit" value="儲存"/>
	    <input type="reset" class="btn btn-info" name="cancel" id="cancel" value="重填">
	</div>
</form>
</body>
</html>