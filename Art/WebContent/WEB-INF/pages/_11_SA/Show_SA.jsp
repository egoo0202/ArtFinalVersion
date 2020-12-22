<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.22/css/jquery.dataTables.css">
<head>
<script>
$(document).ready( function () {
    $('#table11').DataTable({
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
<div align="center">
	<span style="border: outset; background-color: rgb(239, 243, 11);margin: 1px;" > 
		<a href="GoCreate.ctrl">新增</a>&nbsp;&nbsp; 
		<a href="GoDel.ctrl">刪除</a>&nbsp;&nbsp;
		<a href="GoSearch.ctrl">查詢</a>&nbsp;&nbsp; 
		<a href="myStreetArtistPage.ctrl">總覽</a>
	</span>
</div>
<div>
	<table id="table11" class="display">
		<thead class="table-hover">
			<tr>
				<th>編號</th>
				<th class="table-warning">藝名</th>
				<th class="table-success">來自</th>
				<th class="table-danger">表演項目</th>
				<th class="table-info">分類</th>
				<th>操作</th>
			</tr>
		</thead>
	
		<tbody>
			<c:forEach var="searchSA" varStatus="stat" items="${BeanList_SA}">
				<tr>
					<td>${searchSA.id_SA }</td>
					<td><a href='<c:url value="/ToWebBack.ctrl?id_SA=${searchSA.id_SA }" />'>${searchSA.name_SA }</a></td>
					<td>${searchSA.country_SA }</td>
					<td>${searchSA.theme_SA }</td>
					<td>${searchSA.classification_SA }</td>
					<td>
						<form action="delSearch.ctrl" method="POST" id="dataSA">
							<input type="hidden" value="${searchSA.id_SA}"  name="id_SA"/>
						</form>
						<button class="btn btn-outline-info" onclick="return deleteSA()" id="submit">刪除</button>

						<form action="fixSA.ctrl" method="POST">
							<input type="hidden" value="${searchSA.id_SA}"  name="id_SA"/>
							<input type="submit" class="btn btn-outline-info" value="修改" id="button-2"/>
						</form>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
<script>
	function deleteSA() {
		swal({
				  title: "是否確認刪除?",
				  text: "刪除前最後確認!",
				  icon: "warning",
				  buttons: true,
				  dangerMode: true,
				})
				.then((orderOK) => {
					  if (orderOK) {
						  swal("刪除藝人成功!", 
							    	{icon: "success",});  
						  setTimeout(function(){$("#dataSA").submit(); });
						 			
					  } else {
					    swal("操作已取消!");
					  }
					});
			
			}
	</script>