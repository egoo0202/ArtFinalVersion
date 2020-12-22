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
<div align="center">
	<span style="border: outset; background-color: rgb(239, 243, 11);margin: 1px;" > 
		<a href="GoCreate.ctrl">新增</a>&nbsp;&nbsp; 
		<a href="GoDel.ctrl">刪除</a>&nbsp;&nbsp;
		<a href="GoSearch.ctrl">查詢</a>&nbsp;&nbsp; 
		<a href="myStreetArtistPage.ctrl">總覽</a>
	</span>
</div>
	<table id="table_11" class="display" style="background-color: rgb(73, 229, 240);border-radius: 25px;margin-top: 10px;">
		<thead>
			<tr>
				<th>欲修改欄位</th>
			</tr>
		</thead>
		
		<tbody>
			<tr class="title">
				<th class="column1">編號</th>
				<th class="column2">藝名</th>
				<th class="column3">表演地區</th>
				<th class="column4">表演項目</th>
				<th class="column5">分類</th>
			</tr>
			<c:forEach var="reFixSA" varStatus="stat" items="${WantToFix}">
			<tr>
				<td class="column1">${reFixSA.id_SA }</td>
				<td class="column2">${reFixSA.name_SA }</td>
				<td class="column3">${reFixSA.country_SA }</td>
				<td class="column4">${reFixSA.theme_SA }</td>
				<td class="column5">${reFixSA.classification_SA }</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	<table id="table_11" class="display">
		<thead>
			<tr>
				<th>改成……</th>
			</tr>
		</thead>
		
		<tbody>
			<tr>
				<th>編號</th>
				<th>藝名</th>
				<th>表演地區</th>
				<th>表演項目</th>
				<th>分類</th>
			</tr>
			<form action="fixingSA.ctrl" method="post" id="fixData">
			<tr>
				<c:forEach var="reFixSA" varStatus="stat" items="${WantToFix}">
					<td>${reFixSA.id_SA }
						<input type="hidden" value="${reFixSA.id_SA }" name="ID_SA">
					</td>
				</c:forEach>
					<td><input type="text" name="NAME_SA" placeholder="範例：王大明" value="范閑"></td>
					<td>
						<select name="COUNTRY_SA" >
							<option value="臺北市">臺北市</option>
							<option value="新北市">新北市</option>
							<option value="桃園市">桃園市</option>
							<option value="臺中市">臺中市</option>
							<option value="臺南市">臺南市</option>
							<option value="高雄市">高雄市</option>
							<option value="新竹縣">新竹縣</option>
							<option value="苗栗縣">苗栗縣</option>
							<option value="彰化縣">彰化縣</option>
							<option value="南投縣">南投縣</option>
							<option value="雲林縣">雲林縣</option>
							<option value="嘉義縣">嘉義縣</option>
							<option value="屏東縣">屏東縣</option>
							<option value="宜蘭縣">宜蘭縣</option>
							<option value="花蓮縣">花蓮縣</option>
							<option value="臺東縣">臺東縣</option>
							<option value="澎湖縣">澎湖縣</option>
							<option value="金門縣">金門縣</option>
							<option value="連江縣">連江縣</option>
						</select>
					</td>
					<td>
						<input type="text" name="THEME_SA" placeholder="範例：吉他演奏" value="雜耍特技">
					</td>
					<td>
						<select name="CLASSIFICATION_SA" >
							<option value="表演藝術">表演藝術</option>
							<option value="創意工藝">創意工藝</option>
							<option value="視覺藝術">視覺藝術</option>
						</select>
					</td>
			</tr>
			</form>
			<tr>
				<button class="btn btn-outline-info" onclick="return fix()" id="submit">確認修改</button>
			</tr>
		</tbody>
	</table>
<script>
function fix() {
	swal({
			  title: "是否確認修改?",
			  text: "修改前最後確認!",
			  icon: "warning",
			  buttons: true,
			  dangerMode: true,
			})
			.then((orderOK) => {
				  if (orderOK) {
					  swal("成功修改藝人資訊!", 
						    	{icon: "success",});  
					  setTimeout(function(){$("#fixData").submit(); });
					 			
				  } else {
				    swal("操作已取消!");
				  }
				});
		
		}
</script>
</html>