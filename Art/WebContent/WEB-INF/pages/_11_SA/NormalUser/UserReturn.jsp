<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<script src="https://code.jquery.com/jquery-3.5.1.min.js" integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0=" crossorigin="anonymous"></script>
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.22/css/jquery.dataTables.css">
<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.22/js/jquery.dataTables.js"></script>
<head>
<style>
	.shadowbox {
		width: 15em;
		border: 1px solid #333;
		box-shadow: 8px 8px 5px #444;
		padding: 8px 12px;
		background-image: linear-gradient(180deg, #fff, #ddd 40%, #ccc);
	}
</style>
<script>
$(document).ready( function () {
    $('#table_11').DataTable({
    	language: {
    		search: "在表格中搜尋：",
    		lengthMenu:"每頁顯示 _MENU_ 筆資料",
    		zeroRecords: "没有符合的结果",
    		info: "顯示第 _START_ 至 _END_ 項结果，共 _TOTAL_ 項",
    		infoEmpty: "顯示第 0 至 0 項结果，共 0 項",
    		paginate: {
                first: "首頁",
                previous: "上一頁",
                next: "下一頁",
                last: "末頁"
            },
            infoFiltered: "(已比對 _MAX_ 項結果)",
    	
    	}
        	
    } );
} );
</script>

</head>
 
<!-- table -->

<!-- 黑底起點 -->
<section class="banner-area relative" id="home">	
	<div class="overlay overlay-bg"></div>
	<div class="container">
		<div class="row d-flex align-items-center justify-content-center">
			<div class="about-content col-lg-12">
				<h1 class="text-white">
					查詢結果
				</h1>
				<p class="text-white link-nav"><a href="index.html">Home </a>  <span class="lnr lnr-arrow-right"></span>  <a href='<c:url value="/userStreetArtistPage.ctrl"/>'> 總覽</a></p>
				<h5 align="center" style="color: white;">關鍵字： ${country } / ${classification } / ${theme } </h5>
			</div>											
		</div>
	</div>
</section>
<!-- 黑底終點 -->
<div align="center" style="padding: 25px;">
	<div class="shadowbox" >
		<form action="searchSA3.ctrl" method="POST">
			<span style="text-align: center;display: block;">
				<label>地區：
					<select name="country" style="align:center">
						<option value="*">--</option>
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
				</label>
			</span>
			<span style="text-align: center;display: block;">
				<label>表演分類：<select name="classification">
					<option value="*">--</option>
					<option value="表演藝術">表演藝術</option>
					<option value="創意工藝">創意工藝</option>
					<option value="視覺藝術">視覺藝術</option>
				</select>
				</label>
			</span>
			<span style="text-align: center;display: block;">
				表演項目：
			</span>
			<span style="text-align: center;display: block;">
				<input type="text" name="theme">
			</span>
			<span style="text-align: center;display: block;margin: 5px;">
				<input type="submit" name="submit" value="送出查詢">
			</span>
		</form>
	</div>
</div>
<div style="padding: 50px;">
	<table id="table_11" class="display" align="center">
		<thead>
			<tr>
				<th style="text-align: center;">藝名</th>
				<th style="text-align: center;">表演地區</th>
				<th style="text-align: center;">表演項目</th>
				<th style="text-align: center;">分類</th>
				<th style="text-align: center;">動作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="reUserView" varStatus="stat" items="${reUBeanList_SA}">
			<tr>
				<td style="text-align: center;">${reUserView.name_SA }</td>
				<td style="text-align: center;">${reUserView.country_SA }</td>
				<td style="text-align: center;">${reUserView.theme_SA }</td>
				<td style="text-align: center;">${reUserView.classification_SA }</td>
				<td style="text-align: center;">
					<form action="ToWeb.ctrl">
						<input type="hidden" value="${reUserView.id_SA}"  name="id_SA"/>
						<input type="submit" class="genric-btn primary radius" value="了解更多" id="aaa" style="margin: 1px;"/>
					</form>
					<form action="ToDonate.ctrl">
						<input type="hidden" value="${reUserView.id_SA}"  name="id_SA"/>
						<input type="submit" class="genric-btn primary radius" value="支持他" id="bbb" style="margin: 1px;"/>
					</form>
				</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
</div>