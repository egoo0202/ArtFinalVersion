<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="zh-tw">
<head>
<meta charset="UTF-8">
<title>訂單</title>
<style type="text/css">
.do{
width: 120px;
}
.do2{
width: 100px;
}

</style>
</head>
<body>
<div class="container">


 <br><br><H1>所有訂單</H1>
 <form method=GET action="<c:url value='/04/Cms/SearchOneOrder.ctrl'/>">
  <div class="form-row align-items-center">
    <div class="col-sm-3 my-1">
 <input type=TEXT name="orderid"  class="form-control" placeholder=""id=""> 
    </div>  
    <div class="col-sm-3 my-1">
      <input type=SUBMIT value="訂單編號查詢" class="btn btn-info" id="searchbut">
    </div>
  </div>
</form>
	<table class="table table-bordered">
			<tr>
				<th class=""></th>
				<th class="">訂單編號</th>
				<th class="">節目名稱</th>
				<th class="">票券種類</th>
				<th class="">訂購數量</th>
				<th class="">總金額</th>
				<th class="">付款狀況</th>
				<th class="do">操作</th>
				<th class="do2"></th>
			</tr>

			<%--使用JSTL 執行for loop ${show.no}取map內value --%>
			<c:forEach items="${requestScope.orderlists}" var="orderlist" varStatus="idx">
				<tr>
					<form name="order" action="<c:url value='/04/Cms/OrderlistDetail.ctrl'/> " method="get"> 
<!-- 					傳送訂單資訊 -->					
						<td><input type=SUBMIT value="訂單詳細" class="btn btn-info"></td>
						<Input type='hidden' name='orderid' value='${orderlist.ORDERID}'>
			 	  	</form> 
			 	  	
					<td>${orderlist.ORDERID}</td>
					<td>${orderlist.TITLE}</td>
					<td>${orderlist.TICKETCATEGORY}</td>
					<td>${orderlist.TICKET_NUM}</td>
					<td>${orderlist.TOTALPRICE}</td>
					<td>${orderlist.STATUS}</td>
					<td>
						<form name="order" action="<c:url value='/04/Cms/OrderlistStatus.ctrl'/> " id="submitform" method="get"> 	
						<input type="hidden" name="orderpk" value="${orderlist.ORDERPK}">					
						<input type="hidden" name="orderid" value="${orderlist.ORDERID}">					
						</form> 
						<button type="button" name="orderid" class="btn btn-info" onclick="submit(${orderlist.ORDERPK},${orderlist.ORDERID})">辦理退票</button>
					</td>
					<td>						
						<button type="submit" name="orderid" class="btn btn-info" onclick="del(${orderlist.ORDERID})">刪除</button>
					</td>

			
			
					</tr>

			</c:forEach>


		</table>
</div>

 <script src="https://code.jquery.com/jquery-3.5.1.js"
    integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc=" crossorigin="anonymous"></script>
</script>    
    
    
    <script>

    </script>	  
    	<script>
// 		function del() {
// 			var msg = "是否取消?";
// 			if (confirm(msg) == true) {
// 				return true;
// 			} else {
// 				return false;
// 			}
// 		}
     function submit(pk,id) {
			swal({
					  title: "是否同意退票?",
					  text: "申請將通過!",
					  icon: "warning",
					  buttons: true,
					  dangerMode: true,
					})
					.then((orderOK) => {
						  if (orderOK) {
							  swal("已同意申請!", 
								    	{icon: "success",});  
							  setTimeout(function(){window.location="<c:url value='/04/Cms/OrderlistStatus.ctrl?orderpk="+pk+"&orderid="+id+"' />"; },2000);				
						  } else {
						    swal("操作已取消!");
						  }
						});
	 		
	 		}
     function del(id) {
			swal({
					  title: "是否刪除訂單?",
					  text: "刪除為不可逆，請謹慎操作!",
					  icon: "warning",
					  buttons: true,
					  dangerMode: true,
					})
					.then((orderOK) => {
						  if (orderOK) {
							  swal("已刪除訂單!", 
								    	{icon: "success",});  
							  setTimeout(function(){window.location="<c:url value='/04/Cms/DeleteOrderlist.ctrl?orderid="+id+"' />"; },2000);				
						  } else {
						    swal("操作已取消!");
						  }
						});
	 		
	 		}
	</script>
	  
	  
</body>

</html>