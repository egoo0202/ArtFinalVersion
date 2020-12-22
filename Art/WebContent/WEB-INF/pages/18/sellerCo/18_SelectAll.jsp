<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>  
<!-- sweetalert記得加上面這行 -->

<style>
.thSA-S {
	width: 50px;
}

.thSA-M {
	width: 100px;
}

.thSA-L {
	width: 150px;
}

</style>



<div class="container">
	<h2 style="color: red">${Update}</h2>
	<h2 style="color: red">${Delete}</h2>
	<!-- 接processActionSelectAll傳來的值 -->


	<div>
		<form action="<c:url value="/18/searchByWordB.ctrl"/>">
			<p style="text-align: center; display: block; font-size: 20px; color:black">
				課程名稱關鍵字查詢： <input type="text" name="searchWordB" id=searchw>
				<input type="submit" name="searchByWordsubmit" value="送出" class="btn btn-info btn-lg">
			</p>
		</form>
	</div>

	<button id="flower" class="btn btn-outline-success">一鍵輸入欲查詢之關鍵字</button>


	<div>
		<form action="<c:url value="/18/searchByTypeB.ctrl"/>">
<!-- 			<p style="text-align: center; display: block; color:black">請選擇分類： -->
				<p style="text-align: center; font-size: 22px; padding-top:5px;">
				<button type="submit" name="searchTypeB" value="語文"
					class="btn btn-primary btn-lg">語文</button>
				<button type="submit" name="searchTypeB" value="園藝"
					class="btn btn-primary btn-lg">園藝</button>
				<button type="submit" name="searchTypeB" value="風俗信仰"
					class="btn btn-primary btn-lg">風俗信仰</button>
				<button type="submit" name="searchTypeB" value="手工製作"
					class="btn btn-primary btn-lg">手工製作</button>
				<button type="submit" name="searchTypeB" value="國畫書法"
					class="btn btn-primary btn-lg">國畫書法</button>
				<button type="submit" name="searchTypeB" value="運動"
					class="btn btn-primary btn-lg">運動</button>
				<button type="submit" name="searchTypeB" value="藝術鑑賞"
					class="btn btn-primary btn-lg">藝術鑑賞</button>
				<button type="submit" name="searchTypeB" value="美術"
					class="btn btn-primary btn-lg">美術</button>
				<button type="submit" name="searchTypeB" value="戲劇"
					class="btn btn-primary btn-lg">戲劇</button>
			</p>
		</form>
	</div>

	<table id="cTable" class="table table-hover table-bordered" style="font-size:18px">
		<thead class="thead-dark">
			<tr class="">
				<th class="thSA-S">編號</th>
				<th class="thSA-L">名稱</th>
				<th class="thSA-M">類型</th>
				<th class="thSA-L">場地名稱</th>
				<th class="thSA-S">剩餘名額</th>
				<th class="thSA-S">售價</th>
				<th class="thSA-S">開始日期</th>
				<th class="thSA-S">結束日期</th>
				<th class="thSA-S">查看次數</th>
				<th class="thSA-M">課程詳細</th>
				<th class="thSA-M">編輯課程</th>
			</tr>
		</thead>
		<tfoot class="thead-dark">
			<tr>
				<th class="thSA-S">編號</th>
				<th class="thSA-L">名稱</th>
				<th class="thSA-M">類型</th>
				<th class="thSA-L">場地名稱</th>
				<th class="thSA-S">剩餘名額</th>
				<th class="thSA-S">售價</th>
				<th class="thSA-S">開始日期</th>
				<th class="thSA-S">結束日期</th>
				<th class="thSA-S">查看次數</th>
				<th class="thSA-M">課程詳細</th>
				<th class="thSA-M">編輯課程</th>
			</tr>
		</tfoot>
		<tbody>
			<c:forEach var="cSelectAllList" varStatus="stat" items="${cList}">
				<tr>
					<td style="color: black">${cSelectAllList.coId}</td>
					<td style="color: black">${cSelectAllList.coTitle}</td>
					<td style="color: black" id="selectTYPE">${cSelectAllList.coAct_Type}</td>

					<td style="color: black">${cSelectAllList.coLocation_Name}</td>
					<td style="color: black">${cSelectAllList.coNum}</td>
					<td style="color: black">${cSelectAllList.coPrice}</td>
					<td style="color: black">${cSelectAllList.coAct_Date}</td>
					<td style="color: black">${cSelectAllList.coEnd_Date}</td>
					<td style="color: black">${cSelectAllList.coHot}</td>
			<%-- 	<td><img style='display:block; width:64px;height:36px;' src="data:image/jpg;base64, ${cSelectAllList.coAct_ImageStr}" ></td> --%>
					<td><a
						href="<c:url value='/18/cCourseDetailB.ctrl?coId=${cSelectAllList.coId}' /> ">
							<input type="submit" value='詳細' class="btn btn-outline-info btn-lg" />
					</a></td>
					<td>
					<button class="btn btn-outline-warning btn-lg" value="全部商品"
							onclick="location.href='<c:url value='/18/UpdateData.ctrl?coId=${cSelectAllList.coId}' />'">修改</button>
<%-- 					<form action="<c:url value="/18/UpdateData.ctrl"/>"> --%>
<!-- 						<input type="submit" name="button" value="修改" -->
<!-- 							class="btn btn-outline-warning"> <input type="hidden" -->
<%-- 							name="coId" value="${cSelectAllList.coId}"> <input --%>
<%-- 							type="hidden" name="coTitle" value="${cSelectAllList.coTitle}"> --%>
<!-- 							<input type="hidden" name="coAct_Type" -->
<%-- 							value="${cSelectAllList.coAct_Type}"> <input --%>
<!-- 							type="hidden" name="coAct_Location" -->
<%-- 							value="${cSelectAllList.coAct_Location}"> <input --%>
<!-- 							type="hidden" name="coLocation_Name" -->
<%-- 							value="${cSelectAllList.coLocation_Name}"> <input --%>
<%-- 							type="hidden" name="coNum" value="${cSelectAllList.coNum}"> --%>
<!-- 							<input type="hidden" name="coPrice" -->
<%-- 							value="${cSelectAllList.coPrice}"> <input type="hidden" --%>
<%-- 							name="coAct_Date" value="${cSelectAllList.coAct_Date}"> <input --%>
<!-- 							type="hidden" name="coAct_Time" -->
<%-- 							value="${cSelectAllList.coAct_Time}"> <input --%>
<!-- 							type="hidden" name="coEnd_Date" -->
<%-- 							value="${cSelectAllList.coEnd_Date}"> <input --%>
<!-- 							type="hidden" name="coEnd_Time" -->
<%-- 							value="${cSelectAllList.coEnd_Time}"> <input --%>
<!-- 							type="hidden" name="coAct_Description" -->
<%-- 							value="${cSelectAllList.coAct_Description}"> <input --%>
<%-- 							type="hidden" name="coHot" value="${cSelectAllList.coHot}"> --%>
<!-- 							<input type="hidden" name="coAct_Image" -->
<%-- 							value="${cSelectAllList.coAct_Image}"> --%>
<!-- 					</form> -->
 					<button class="btn btn-outline-danger btn-lg" onclick="delSA(${cSelectAllList.coId})">刪除</button>
<!-- 					<input type="button" name="delete" value="刪除" -->
<%-- 						class="btn btn-outline-danger" onclick="delSA(${cSelectAllList.coId})"> --%> 
<!-- 						兩種寫法都可以 -->

<%-- 					<form action="<c:url value="/18/cDelete.ctrl"/>"> --%>
<%-- 					<input type="hidden" name="coId" value="${cSelectAllList.coId}"> --%>
<!-- 					<input type="hidden" name="coTitle" -->
<%-- 						value="${cSelectAllList.coTitle}"> --%>
<!-- 					<input type="hidden" name="coAct_Type" -->
<%-- 						value="${cSelectAllList.coAct_Type}"> --%>
<!-- 					<input type="hidden" name="coAct_Location" -->
<%-- 						value="${cSelectAllList.coAct_Location}"> --%>
<!-- 					<input type="hidden" name="coLocation_Name" -->
<%-- 						value="${cSelectAllList.coLocation_Name}"> --%>
<%-- 					<input type="hidden" name="coNum" value="${cSelectAllList.coNum}"> --%>
<!-- 					<input type="hidden" name="coPrice" -->
<%-- 						value="${cSelectAllList.coPrice}"> --%>
<!-- 					<input type="hidden" name="coAct_Date" -->
<%-- 						value="${cSelectAllList.coAct_Date}"> --%>
<!-- 					<input type="hidden" name="coAct_Time" -->
<%-- 						value="${cSelectAllList.coAct_Time}"> --%>
<!-- 					<input type="hidden" name="coEnd_Date" -->
<%-- 						value="${cSelectAllList.coEnd_Date}"> --%>
<!-- 					<input type="hidden" name="coEnd_Time" -->
<%-- 						value="${cSelectAllList.coEnd_Time}"> --%>
<!-- 					<input type="hidden" name="coAct_Description" -->
<%-- 						value="${cSelectAllList.coAct_Description}"> --%>
<%-- 					<input type="hidden" name="coHot" value="${cSelectAllList.coHot}"> --%>
<!-- 					<input type="hidden" name="coAct_Image" -->
<%-- 						value="${cSelectAllList.coAct_Image}"> --%>
<!-- 					</form> -->
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>

<script>
$(document).ready( function () {
    $('#cTable').DataTable({
    	language: {
    		search: "在本表格中搜尋：",
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


$("#flower").click(function(){
	$("#searchw").val("花");
})

if($("#selectTYPE").text()=="語文"){
	$("#selectTYPE").attr("title")="0"
}

if($("#selectTYPE").text()=="園藝"){
	$("#selectTYPE").attr("title")="1"
}


</script>


<script type="text/javascript">
// 	swal({
// 		  title: "提示","您確定要刪除?",
// 		  text: "刪除後將無法復原",
// 		  icon: "warning",
// 		  buttons: true,
// 		  dangerMode: true,
// 		})
function delSA(coId){
	swal("您確定要刪除本課程嗎？","", "warning",{
	    buttons: {
	      danger: {
	          text: "是"
	        },
	      "否": true,
	    },
	  })

		.then((value) => {
		switch (value) {
		case "danger":
	    	swal("刪除課程成功","", "success")
	    	setTimeout(function(){window.location="<c:url value='/18/cDelete.ctrl?coId="+coId+"'/>" ; },2000);
	        break;
	      case "不是":
	        swal("取消刪除","", "info");
	        break;
	      default:
	    	  swal("課程未被刪除","", "info");
	        break;
		}
		});
};
</script>



