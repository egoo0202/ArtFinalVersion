<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- 	<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.22/css/jquery.dataTables.css"> -->

<style>
th {
	text-align: center;
}
</style>

<script type="text/javascript">


function reconfirmOrder(pid,page){
	swal("提示","確認刪除？", "warning",{
	    buttons: {
	      danger: {
	          text: "是",
	          visible: true
	        },
	      "不是": true,
//	      "是": true
	      
	    },
	  })
	  .then((value) => {
	    switch (value) {
	      case "danger":
	    	swal("提示","商品已刪除", "success")
	    	setTimeout(function(){window.location="<c:url value='/14/deleteProduct.ctrl?productid="+pid+"&pageNo="+page+"' />" ; },2000);
	        break;
	      case "不是":
	        swal("提示","商品未刪除", "info");
	        break;
	      default:
	    	  swal("提示","商品未刪除", "info");
	        break;
	    }
	  });
};

</script>

</head>
<body>


	<div class="container">
		<h1 style="margin-top: 50px; text-align: center;">洋行後台</h1>

		<button type="button" class="btn btn-info btn-sm" value="新增商品"
			onclick="location.href='<c:url value='/14/Create.ctrl' />'">新增</button>


		<button type="button" class="btn btn-info btn-sm" value="全部商品"
			onclick="location.href='<c:url value='/CRUD.controller' />'">前往新天地</button>


		<div style='text-align: center;'>

			<c:if test='${not empty OrderErrorMessage}'>
				<h3>
					<font color='red'>${OrderErrorMessage}</font>
				</h3>
				<c:remove var="OrderErrorMessage" />
				<c:remove var="SuccessMessage" />
			</c:if>

		</div>
		<div style='text-align: center;'>
			<c:if test='${not empty SuccessMessage}'>
				<h3>
					<font color='#1b9aaa'>${SuccessMessage}</font>
				</h3>
				<c:remove var="SuccessMessage" />
				<c:remove var="OrderErrorMessage" />
			</c:if>
		</div>

		<br>
		<!-- Begin Page Content -->
		<div class="container-fluid">

			<!-- Page Heading -->
			<h1 class="h3 mb-2 text-gray-800">Tables</h1>
			<p class="mb-4">
				DataTables is a third party plugin that is used to generate the demo
				table below. For more information about DataTables, please visit the
				<a target="_blank" href="https://datatables.net">official
					DataTables documentation</a>.
			</p>

			<!-- DataTales Example -->
			<div class="card shadow mb-4">
				<div class="card-header py-3">
					<h6 class="m-0 font-weight-bold text-primary">DataTables
						Example</h6>
				</div>
				<div class="card-body">
					<div class="table-responsive">
						<table id="myTable" class="table table-bordered" width="100%"
							cellspacing="0">
							<thead>
								<tr>
									<th>商品序號</th>
									<th>商品名稱</th>
									<th>售價</th>
									<th>庫存</th>
									<th>功能列</th>
								</tr>
							</thead>
							<tfoot>
								<tr>
									<th>商品序號</th>
									<th>商品名稱</th>
									<th>售價</th>
									<th>庫存</th>
									<th>功能列</th>
								</tr>
							</tfoot>
								<tbody>
							<c:forEach var="searchAP" varStatus="stat" items="${pList}">
									<tr>
										<td>${searchAP.productId}</td>
										<td>${searchAP.productTitle}</td>
										<td>${searchAP.productPrice}</td>
										<td>${searchAP.productNum}</td>
										<td>
											1
										</td>
									</tr>
							</c:forEach>
								</tbody>
						</table>
					</div>
				</div>
			</div>

		</div>
	</div>

	<%-- 	<div style="margin-left: 500px;">第 ${pageNo} 頁 // 共 ${totalPages} --%>
	<!-- 		頁</div> -->
	<!-- 	<div class="container"> -->
	<!-- 		<div class="row justify-content-md-center"> -->

	<!-- 			<nav aria-label="Page navigation example" style="margin: auto;"> -->
	<!-- 				<ul class="pagination" style="margin: auto;"> -->
	<%-- 					<li class="page-item" style="margin: auto;"><c:if --%>
	<%-- 							test="${pageNo > 1}"> --%>
	<!-- 							<a class="page-link" -->
	<%-- 								href="<c:url value='/14/CRUD.ctrl?pageNo=${pageNo-1}' />" --%>
	<!-- 								aria-label="Previous"> <span aria-hidden="true">&laquo;</span> -->
	<!-- 							</a> -->
	<%-- 						</c:if></li> --%>
	<%-- 					<c:forEach var='page' items='${pages}'> --%>
	<!-- 						<li class="page-item"><a class="page-link" -->
	<%-- 							href="<c:url value='/14/CRUD.ctrl?pageNo=${page}' />">${page}</a></li> --%>
	<%-- 					</c:forEach> --%>
	<%-- 					<c:if test="${pageNo != totalPages}"> --%>
	<!-- 						<li class="page-item"><a class="page-link" -->
	<%-- 							href="<c:url value='/14/CRUD.ctrl?pageNo=${pageNo+1}' />" --%>
	<!-- 							aria-label="Next"> <span aria-hidden="true">&raquo;</span> -->
	<!-- 						</a></li> -->
	<%-- 					</c:if> --%>
	<!-- 				</ul> -->
	<!-- 			</nav> -->
	<!-- 		</div> -->
	<!-- 	</div> -->


	<!--   <script src="../vendor/datatables/jquery.dataTables.min.js"></script> -->
<!-- 	<script src="https://code.jquery.com/jquery-3.5.1.min.js" -->
<!-- 		integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0=" -->
<!-- 		crossorigin="anonymous"></script> -->

<!-- 	<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.22/js/jquery.dataTables.js"></script> -->
<%-- 	<script src="<c:url value='/vendor/datatables/jquery.dataTables.min.js' />"></script> --%>
<%-- 	<script src="<c:url value='/vendor/datatables/dataTables.bootstrap4.min.js' />"></script> --%>
	<script>
$(document).ready( function () {
    $('#myTable').DataTable({

    	
    } );
} );
</script>
</body>
</html>