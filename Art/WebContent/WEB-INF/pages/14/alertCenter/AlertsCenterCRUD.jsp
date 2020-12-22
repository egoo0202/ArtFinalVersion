<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>

</head>
<body>

	<style>
.head, tfoot {
	text-align: center;
}
</style>

</head>
<body>
	<div class="container">
		<!-- 		<h1 style="margin-top: 50px; text-align: center;">申訴訊息管理頁面</h1> -->
		<br>
		<br>
		<!-- Begin Page Content -->
		<div class="container-fluid">

			<h1 class="h3 mb-2 text-gray-800">會員申訴管理頁面</h1>
			<p class="mb-4">
				想學習如何使用，請訪問 <a target="_blank" href="https://datatables.net">official
					DataTables documentation</a>.
			</p>

			<div class="card shadow mb-4">
				<div class="card-header py-3">
					<h6 class="m-0 font-weight-bold text-primary">會員申訴一覽</h6>
				</div>
				<div class="card-body">
					<div class="table-responsive">

						<table class="table table-bordered" id="dataTable" width="100%"
							cellspacing="0">
							<thead>
								<tr class="head">
									<th scope="col">申訴編號</th>
									<th scope="col">會員編號</th>
									<th scope="col">申訴時間</th>
									<th scope="col">申訴類別</th>
									<th scope="col">處理狀態</th>
									<th scope="col">功能</th>
								</tr>
							</thead>
							<tfoot>
								<tr>
									<th scope="col">申訴編號</th>
									<th scope="col">會員編號</th>
									<th scope="col">申訴時間</th>
									<th scope="col">申訴類別</th>
									<th scope="col">處理狀態</th>
									<th scope="col">功能</th>
								</tr>
							</tfoot>

							<tbody>
								<c:forEach var="searchList" varStatus="stat" items="${list}">
									<!--<FORM> -->
									<tr>

										<td class="align-middle" scope="row"
											style="text-align: center;">${searchList.aleartNo}</td>
										<td class="align-middle" style="text-align: center;">${searchList.memberId}</td>
										<td class="align-middle" style="text-align: center;">${searchList.time}</td>
										<td class="align-middle" style="text-align: center;">${searchList.issue}</td>
										<c:choose>
											<c:when test="${searchList.status=='1'}">
												<td class="align-middle" style="text-align: center;">
													<b style="color: red">未處理</b></td>
											</c:when>
											<c:otherwise>
												<td class="align-middle" style="text-align: center;">
														<div style="color: green">已處理</div></td>
											</c:otherwise>
										</c:choose>
										<td class="align-middle">
											<Input class="btn btn-info btn-sm" type="button"
											name="delete" value="刪除"
											onclick="reconfirmOrder(${searchList.aleartNo})">
											<button type="button" class="btn btn-info btn-sm" value="詳情"
												onclick="location.href='<c:url value='/14/ShowCustomerIssue?alertNo=${searchList.aleartNo}' />'">詳情</button>
										</td>

									</tr>
									<!--</FORM> -->
								</c:forEach>
							</tbody>

						</table>
					</div>


					<script>
$(document).ready( function () {
    $('#dataTable').DataTable({

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

<script>

function reconfirmOrder(pid,page){
	swal("提示","確認刪除？", "warning",{
	    buttons: {
	      danger: {
	          text: "是"
// 	          ,visible: true
	        },
	      "不是": true,
//	      "是": true
	      
	    },
	  })
	  .then((value) => {
	    switch (value) {
	      case "danger":
	    	swal("提示","該申訴已刪除", "success")
	    	setTimeout(function(){window.location="<c:url value='/14/deleteProduct.ctrl?productId="+pid+"'/>" ; },2000);
	        break;
	      case "不是":
	        swal("提示","該申訴未刪除", "info");
	        break;
	      default:
	    	  swal("提示","該申訴未刪除", "info");
	        break;
	    }
	  });
};

</script>
</body>
</html>
