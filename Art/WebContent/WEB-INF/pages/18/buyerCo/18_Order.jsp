<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>  
<!-- sweetalert記得加上面這行 -->

<!-- start banner Area -->
<section class="banner-area relative" id="home">
	<div class="overlay overlay-bg"></div>
	<div class="container">
		<div class="row d-flex align-items-center justify-content-center">
			<div class="about-content col-lg-12">
				<h1 class="text-white">確認您所購買的商品</h1>
				<p class="text-white link-nav">
					<a href="index.html">首頁</a>
				    <span class="lnr lnr-arrow-right"></span>
					<a href="<c:url value='/18/cSelectAllFront.ctrl' />">課程總覽</a>
					<span class="lnr lnr-arrow-right"></span>
					<a href="<c:url value='/18/toCoCart.ctrl' />">購物車</a>
				</p>
			</div>
		</div>
	</div>
</section>
<!-- End banner Area -->

<div class="container" style="font-size: 20px; color:black; text-align:center; padding-top:20px">
<table id="cTableF" class="table table-bordered table-hover" width="100%"
	cellspacing="0"  style="border:8px">
<thead style="background-color:MediumSlateBlue; color:white">
	<tr style="font-size: 20px">
		<th rowspan="2">課程圖片</th>
		<th rowspan="2">編號</th>
		<th rowspan="2">課程名稱</th>
		<th>人數</th>
		<th>售價</th>
		<th rowspan="2">開課時間</th>
		<th rowspan="2">刪除課程</th>
	</tr>
	<tr>	
        <th style="font-size: 24px" colspan="2">小計</th>       
    </tr>
</thead>    
<!--
varStatus是c:forEach，jstl循環標簽的一個屬性，varStatus屬性。
就拿varStatus=“status”來說，事實上定義了一個status名的對象作為varStatus的綁定值。
該綁定值也就是status封裝了當前遍歷的狀態，比如，可以從該對象上查看是遍歷到了第幾個元素：${status.count}，
status.index 輸出行號，從0開始。

var:String型別，用來指定一個變數的名稱，此變數將用來表示某個元素(字串.JavaBean.Key+Value組成的Entry等，或是註標的值
varStatus:定義一個變數，此變數本身為一個JSP準備的物件具有四個屬性，可表示迴圈執行的狀態
items:Object型別、多元素的集合，數據來源-->

	<c:forEach var="orderCo" varStatus="stat" items="${ccc.cartCo}"> <!-- 兩層 ccc.cartCo 在 CourseControllerF #43 #71 -->
		<tr>
		<!--如果是HashMap，var後需要加上  .value 。List則不用-->
			<td rowspan="2"><img style='display: block; width: 192px; height: 108px;'
				src="data:image/jpg;base64, ${orderCo.value.coAct_ImageStr}"></td>
			<td rowspan="2">${orderCo.value.coId}</td>
			<td rowspan="2" style="font-size: 24px;font-weight:bold"><a href="<c:url value='/18/cCourseDetail.ctrl?coId=${orderCo.value.coId}' />"style="color:#1B813E">${orderCo.value.coTitle}</a></td>
			<td>${orderCo.value.coNum}</td>
			<td><fmt:formatNumber value="${orderCo.value.coPrice}" type="number" />元</td>
			<!-- fmt:formatNumber日期、 數字、貨幣格式化
				type:參數有三種，分別是number(數字)，currency(貨幣)及percent(百分比) -->
			<td rowspan="2" >${orderCo.value.coAct_Date}</td>	
			<td rowspan="2">
<%-- 			<input type="button" value="刪除本課程" onclick="confirmDelete(${orderCo.value.coId})"> --%>
<!-- 			↑原本的彈出視窗  ；  SweetAlert↓ -->
			<button class="genric-btn danger-border circle" onclick="delSAF(${orderCo.value.coId})">刪除</button>
<%-- 			要有裡面的(${orderCo.value.coId})才能準確抓到coId --%>
			</td>
		</tr>
		<tr>
			<td colspan="2" style="font-weight:bold"><fmt:formatNumber value="${orderCo.value.coNum * orderCo.value.coPrice}"
					type="number" />元</td>
		</tr>
	</c:forEach>
	
	<tr style="font-size:28px;font-weight:bold">
	    <td>
<%-- 	    <input type="button" value="清空購物車" class="genric-btn danger radius large" onclick="confirmDeleteALL(${orderCo.value.coId})"> --%>
<!-- 			↑原本的彈出視窗  ；  SweetAlert↓   -->
			<button class="genric-btn danger circle" onclick="delSAFALL()">清空購物車</button>
			</td>
		<td colspan="2"><a href="<c:url value='/18/cSelectAllFront.ctrl' />"><button class="genric-btn info circle">繼續購買其他課程</button></a></td>
		<td colspan="3">總計：<fmt:formatNumber value="${ccc.total}"
				type="number" />元
		</td>
		<td colspan="3">
<%-- 	<a href="<c:url value='/18/SubmitCartCo.ctrl' />" onClick="return Checkout(${carList.subtotal});">送出</a></td> --%>
<!-- 			↑原本的彈出視窗  ；  SweetAlert↓   -->			
		<button class="genric-btn success radius" onclick="submitSAF();" style="font-size: 20px; color:black; font-weight:bold">送出</button>
		</td>
    </tr>
	
</table>
</div>

<script type="text/javascript">
//  (coId)對應上方的(${orderCo.value.coId}))
function delSAF(coId){
	swal("您確定要刪除本課程嗎？","", "warning",{
	    buttons: {
	      danger: {
	          text: "是"
	        },
	      "否": true,
	    },
	  })

		.then((value1) => {
		switch (value1) {
		case "danger":
	    	swal("已刪除本課程","", "success")
	    	setTimeout(function(){window.location="<c:url value='/18/cdeleteCartList.ctrl?coId="+coId+"'/>" ; },2000);
	        break;
	      case "不是":
	        swal("已取消","", "info");
	        break;
	      default:
	    	  swal("課程未被刪除","", "info");
	        break;
		}
		});
};

// 這邊就不用，也就是()對應上方的()
function delSAFALL(){
	swal("您確定要刪除所有已選擇的課程嗎？","", "warning",{
	    buttons: {
	      danger: {
	          text: "是"
	        },
	      "否": true,
	    },
	  })

		.then((value2) => {
		switch (value2) {
		case "danger":
	    	swal("成功刪除所有已選擇的課程","", "success")
	    	setTimeout(function(){window.location="<c:url value='/18/cdeleteCartListAll.ctrl'/>" ; },2000);
	        break;
	      case "不是":
	        swal("已取消","", "info");
	        break;
	      default:
	    	  swal("課程未被刪除","", "info");
	        break;
		}
		});
};


function submitSAF(){
	swal("您確定要送出嗎？","", "warning",{
	    buttons: {
	      danger: {
	          text: "是"
	        },
	      "否": true,
	    },
	  })

		.then((value3) => {
		switch (value3) {
		case "danger":
	    	swal("成功送出","請前往填寫詳細資訊", "success")
	    	setTimeout(function(){window.location="<c:url value='/18/SubmitCartCo.ctrl'/>" ; },2000);
	        break;
	      case "不是":
	        swal("已取消","", "info");
	        break;
	      default:
	    	  swal("未送出","", "info");
	        break;
		}
		});
};
</script> 

<script>
// function confirmDeleteALL(n) {  //n=${orderCo.value.coId}
// 	if (confirm("您確定要清空購物車 ? ") ) {
// 		document.forms[0].action="<c:url value='/18/cdeleteCartListAll.ctrl?coId=" + n +"' />"  
// 		//獲取當前頁面第一個表單
// 		document.forms[0].method="POST";
// 		document.forms[0].submit();  //提交
// 	} else {
	
// 	}
// }


// function confirmDelete(n) {  //n=${orderCo.value.coId}
// 	if (confirm("您確定要刪除 ? ") ) {
// 		document.forms[0].action="<c:url value='/18/cdeleteCartList.ctrl?coId=" + n +"' />"  
// 		//獲取當前頁面第一個表單
// 		document.forms[0].method="POST";
// 		document.forms[0].submit();  //提交
// 	} else {
	
// 	}
// }
</script>

