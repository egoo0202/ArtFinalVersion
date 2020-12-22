<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="https://cdn.datatables.net/1.10.22/css/jquery.dataTables.css">

<style>
.head, tfoot {
	text-align: center;
}

table.dataTable tbody td{
 padding-top:8px;
 padding-bottom:8px;
 padding-right:0px;
 padding-left:0px;

 
}
.genric-btn.danger-border {
color:#D05A6E;
border-color: #D05A6E;

}
.genric-btn.danger-border:hover{
color:#fff; 
background:#D05A6E;  
}

.genric-btn.warning:hover{
color:#FFC408;
border-color: #FFC408;

}
.genric-btn.warning {
color:#fff; 
background:#FFC408;  
}

.align-middle{
color: #000000
}
</style>

<!-- 此處 JS 為 sweet alert 使用範例 -->
<script type="text/javascript">

function reconfirmOrder(pid){
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
	    	swal("提示","該訂單已刪除", "success")
	    	setTimeout(function(){window.location="<c:url value='/14/MbOrderListDelet.ctrl?orderListID="+pid+"'/>" ; },2000);
	        break;
	      case "不是":
	        swal("提示","訂單未刪除", "info");
	        break;
	      default:
	    	  swal("提示","訂單未刪除", "info");
	        break;
	    }
	  });
};




</script>

</head>
<body>
	<!-- start banner Area -->
	<section class="banner-area relative" id="home">
		<div class="overlay overlay-bg"></div>
		<div class="container">
			<div class="row d-flex align-items-center justify-content-center">
				<div class="about-content col-lg-12">
					<h1 class="text-white">得藝洋行</h1>
					<p class="text-white link-nav">
						<a href="index.html">首頁 </a> <span class="lnr lnr-arrow-right"></span>
						<a href="<c:url value='/14/shopListController.ctrl' />"> 洋行</a>
						<span class="lnr lnr-arrow-right"></span> <span>訂購紀錄</span>
					</p>
				</div>
			</div>
		</div>
	</section>
	<!-- End banner Area -->
<br>
	<div class="container">
		<h3 style="margin-top: 50px; text-align: center;">已成立訂單一覽</h3><br>

		<!-- Begin Page Content -->
		<div class="container-fluid">


			<div class="card shadow mb-4">
				<div class="card-header py-3">
					<h6 class="m-0 font-weight-bold text-primary">以下為您的訂購紀錄</h6>
				</div>
				<div class="card-body">
					<div class="table-responsive">

						<table class="table table-bordered" id="dataTable" width="100%"
							cellspacing="0">
							<thead>
								<tr class="head">
									<th scope="col">#</th>
									<th scope="col">訂購日期</th>
									<th scope="col">寄件地址</th>
									<th scope="col">其他服務</th>
								</tr>
							</thead>
							<tfoot>
								<tr>
									<th scope="col">#</th>
									<th scope="col">訂購日期</th>
									<th scope="col">寄件地址</th>
									<th scope="col">其他服務</th>
								</tr>
							</tfoot>

							<tbody>
								<c:forEach var="anOrderBean" varStatus="stat" items="${customerOrder}">
									<!--<FORM> -->
									<tr>

										<td class="align-middle" scope="row"
											style="text-align: center;">
										${stat.count}
										</td>
										<td class="align-middle" style="text-align: center;">${anOrderBean.date}</td>
										<td class="align-middle" style="text-align: center;">${anOrderBean.addAP}</td>
										<td class="align-middle" style="text-align: center;">
											<a class="genric-btn info small" style="padding:0px; padding-right:5px;padding-left: 5px"
												href="<c:url value='/14/WriteIssueForm?issueId=${anOrderBean.orderNoAP}' />" title="查看詳情">
												<i class="fas fa-info-circle"></i>
											</a>
											<a class="genric-btn warning small" style="padding:0px; padding-right:5px;padding-left: 5px"
												href="<c:url value='/14/WriteIssueForm?issueId=${anOrderBean.orderNoAP}' />" title="評價並留言">
												<i class="far fa-comments"></i>
											</a>
											<a class="genric-btn danger small" style="padding:0px; padding-right:3px;padding-left: 3px"
												href="<c:url value='/14/WriteIssueForm?issueId=${anOrderBean.orderNoAP}' />" title="退換貨申請">
												<i class="fas fa-retweet"></i>
											</a>
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
</body>
</html>