<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
<!-- 黑底起點 -->
<section class="banner-area relative" id="home">	
	<div class="overlay overlay-bg"></div>
	<div class="container">
		<div class="row d-flex align-items-center justify-content-center">
			<div class="about-content col-lg-12">
				<h1 class="text-white">
					捐獻紀錄
				</h1>
				<p class="text-white link-nav"><a href="index.html">Home </a>  <span class="lnr lnr-arrow-right"></span>  <a href='<c:url value="/userStreetArtistPage.ctrl"/>'> 總覽</a></p>
			</div>											
		</div>
	</div>
</section>
<!-- 黑底終點 -->
<div style="padding: 50px">
	<h1 align="center">查詢結果</h1>
	<table id="table_11" class="display" align="center">
		<thead>
			<tr>
				<th style="text-align: center;">訂單編號</th>
				<th style="text-align: center;">使用者</th>
				<th style="text-align: center;">對象</th>
				<th style="text-align: center;">斗內金額</th>
				<th style="text-align: center;">時間</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="reUserView" varStatus="stat" items="${donationList}">
			<tr>
				<td style="text-align: center;">${reUserView.id_donation }</td>
				<td style="text-align: center;">${reUserView.name_user }</td>
				<td style="text-align: center;">${reUserView.name_SA }</td>
				<td style="text-align: center;">${reUserView.donate_sa }</td>
				<td style="text-align: center;">${reUserView.time }</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
</div>