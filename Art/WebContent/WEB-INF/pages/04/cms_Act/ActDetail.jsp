<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
p{
/*  自動換行  */
white-space:pre-wrap;
}
#demo{
width: 400px;
}
#actid{
width: 200px;
}
</style>
</head>

<body>

		<br>
		<br>
	
<div class="container">
<div class="form-group">
	<h1>活動修改</h1>
			
			<table class="table table-bordered">

					<input type="hidden" name="actno" value="${requestScope.actno}">
					<input type="hidden" name="page" value="${requestScope.page}">
					<input type="hidden" name="searchString" value="${requestScope.searchString}">
				<tr>
				
					<td id="actid" >編號</td>
					<td>${requestScope.actno}</td>
				</tr>
				<tr>			
					<td>標題</td>
					<td>${requestScope.title}</td>
				</tr>
				<tr>
					<td>分類</td>
					<td>${requestScope.category}</td>
				</tr>
				<tr>
					<td>縣市名</td>
					<td>${requestScope.location}</td>
				</tr>
				<tr>
					<td>地點</td>
					<td>${requestScope.locationName}</td>
				</tr>
				<tr>
					<td>主辦單位</td>
					<td>${requestScope.mainunit}</td>
				</tr>
				<tr>
					<td>演出單位</td>
					<td>${requestScope.showunit}</td>
				</tr>
				<tr>
					<td>活動開始日</td>
					<td>${requestScope.startdate}</td>
				</tr>
				<tr>
					<td>活動結束日</td>
					<td>${requestScope.enddate}</td>
				</tr>
				<tr>
					<td>活動描述</td>
					<td>${requestScope.description}</td>
				</tr>
				<tr>
					<td>活動圖片</td>
					<td><img id="demo" style='display:block;width:400px;' src="data:image/jpg;base64,${photo}" >					
					</td>
				</tr>

				
			</table>

			<form name="order" action="<c:url value='/04/CMS/Update1.ctrl'/>"method="get">
				<button name="" type="submit" value=""class="btn btn-outline-info">修改</button>
								<!-- 這些隱藏欄位都會送到後端 -->
				<Input type='hidden' name='actno' value="${requestScope.actno}"> 
			</form>
	</div>
	</div>
	</form>
	
	
    <script>
	
	</script>
</body>
</html>