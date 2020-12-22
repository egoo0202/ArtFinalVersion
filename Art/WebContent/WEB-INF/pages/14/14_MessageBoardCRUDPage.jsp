<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<% 
   //因為jQuery Ajax的Request為UTF-8(不知道這樣理解是否正確...)
   request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="https://cdn.datatables.net/1.10.22/css/jquery.dataTables.css">


<!-- 此處 JS 為 sweet alert 使用範例 -->
<script type="text/javascript">

function reconfirmOrder(pid){
	swal("提示","確認刪除此留言？", "warning",{
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
	    	swal("提示","該留言已刪除", "success")
	    	setTimeout(function(){window.location="<c:url value='/14/MessageBoardListDelet.ctrl?mNo="+pid+"'/>" ; },2000);
	        break;
	      case "不是":
	        swal("提示","留言未刪除", "info");
	        break;
	      default:
	    	  swal("提示","留言未刪除", "info");
	        break;
	    }
	  });
};




</script>

</head>
<body>
	<div class="container">
		<h1 style="margin-top: 50px; text-align: center;">洋行後台</h1>


		<div style='text-align: center;'>


		<!-- Begin Page Content -->
		<div class="container-fluid">

			<h1 class="h3 mb-2 text-gray-800" >留言管理頁面</h1>

			<div class="card shadow mb-4">
				<div class="card-header py-3">
					<h6 class="m-0 font-weight-bold text-primary">商品留言一覽</h6>
				</div>
				<div class="card-body">
					<div class="table-responsive">

						<table class="table table-bordered" id="dataTable" width="100%"
							cellspacing="0" >
							<thead>
								<tr class="head">
									<th scope="col">留言編號</th>
									<th scope="col">商品編號</th>
									<th scope="col">會員帳號</th>
									<th scope="col">留言時間</th>
									<th scope="col">留言主旨</th>
									<th scope="col">功能</th>
								</tr>
							</thead>
							<tfoot>
								<tr>
									<th scope="col">留言編號</th>
									<th scope="col">商品編號</th>
									<th scope="col">會員帳號</th>
									<th scope="col">留言時間</th>
									<th scope="col">留言主旨</th>
									<th scope="col">功能</th>
								</tr>
							</tfoot>

							<tbody >
								<c:forEach var="mList" varStatus="stat" items="${mList}">
									<tr id="${mList.messageNoAP}" >

										<td class="align-middle" scope="row" id="${mList.messageNoAP}"
											style="text-align: center; cursor: pointer;">${mList.messageNoAP}</td>
										<td class="align-middle" id="${mList.messageNoAP}">${mList.apId}</td>
										<td class="align-middle" style="text-align: center; cursor: pointer;" id="${mList.messageNoAP}">${mList.memberId}</td>
										<td class="align-middle" style="text-align: center; cursor: pointer;" id="${mList.messageNoAP}">${mList.time}</td>
										<td class="align-middle" style="text-align: center; cursor: pointer;" id="${mList.messageNoAP}">${mList.title}</td>
										<td class="align-middle">
											<Input class="btn btn-info btn-sm" type="button"
											name="delete" value="刪除"
											onclick="reconfirmOrder(${mList.messageNoAP})">
										</td>

									</tr>
								</c:forEach>
							</tbody>

						</table>
					</div>


	<!-- Data table -->
	<script src="<c:url value='/js14/testDataTable.js'/>"></script>

</body>
</html>