<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<div align="center">
	<span style="border: outset; background-color: rgb(239, 243, 11);margin: 1px;" > 
		<a href="GoCreate.ctrl">新增</a>&nbsp;&nbsp; 
		<a href="GoDel.ctrl">刪除</a>&nbsp;&nbsp;
		<a href="GoSearch.ctrl">查詢</a>&nbsp;&nbsp; 
		<a href="myStreetArtistPage.ctrl">總覽</a>
	</span>
</div>
<form action="searchSA.ctrl" method="POST">
	<table>
		<thead>
			<tr>
				<th>查找藝人（樂器或分類）</th>
			</tr>
		</thead>
		
		<tbody>
			<tr><td colspan="2" align="center" style="color:red">想找啥？我幫你</td></tr>
			<tr>
		        <td>請隨意輸入：<input type="text" name="word" ></td>
		    </tr>
		    <tr>
		    	<td colspan="2" align="center"><input type="submit" name="submit" value="送出"></td>
		    </tr>
		</tbody>
	</table>
</form>
</html>