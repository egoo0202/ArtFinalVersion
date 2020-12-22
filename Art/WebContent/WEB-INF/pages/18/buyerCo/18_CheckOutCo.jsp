<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>  
<jsp:useBean   id="today"  class="java.util.Date" scope="session"/> 
<script src="https://code.jquery.com/jquery-3.5.1.js" integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc=" crossorigin="anonymous"></script>
<!-- https://code.jquery.com/       jQuery Core 3.5.1 - uncompressed -->

<!-- start banner Area -->
<section class="banner-area relative" id="home">
	<div class="overlay overlay-bg"></div>
	<div class="container">
		<div class="row d-flex align-items-center justify-content-center">
			<div class="about-content col-lg-12">
				<h1 class="text-white">確認訂單</h1>
				<p class="text-white link-nav">
					<a href="index.html">首頁</a>
				    <span class="lnr lnr-arrow-right"></span>
					<a href="<c:url value='/18/cSelectAllFront.ctrl' />">課程總覽</a>
					<span class="lnr lnr-arrow-right"></span>
					<a href="<c:url value='/18/toCoCart.ctrl' />">購物車</a>
					<span class="lnr lnr-arrow-right"></span>
					<a href="<c:url value='/18/SubmitCartCo.ctrl' />">填寫訂單詳細資訊</a>
				</p>
			</div>
		</div>
	</div>
</section>
<!-- End banner Area -->


<style>
trReverse { display: block; float: left; }
thReverse, tdReverse { display: block; border: 1px solid black; }

trReverse>*:not(:first-child) { border-top: 0; }
trReverse:not(:first-child)>* { border-left:0; }
</style>


<div class="container" style="font-size: 20px">
<div style="text-align: center;margin-top: 50px;font-weight:bold; font-size: 54px; color:#6F3381">訂單詳細</div>
<br>
<br>
<div>
<FORM >
<div>
    <table style="float:left;margin-top:30px;height: 375px;display:inline-block;vertical-align: top">
        <tr><td style="text-align:center;font-weight:bold;color:#81C7D4;font-size:36px">收件人資訊</td></tr>
        <!-- name:收到的     id:識別名稱     value:預設填入的值 -->
        <tr><td style="text-align: right;font-weight:bold;color:#1B813E;line-height: 30px"><label style="display:inline-block">姓名：</label></td>
            <td style="text-align: left"><input type="text" name="Name" id='coName' value="${mb.realName}"></td></tr>
        <tr><td style="text-align: right;font-weight:bold;color:#1B813E;line-height: 30px"><label style="display:inline-block">電話：</label></td>
            <td style="text-align: left"><input type="text" name="Phone" id='coPhone' value="${mb.tel}"></td></tr>
        <tr><td style="text-align: right;font-weight:bold;color:#1B813E;line-height: 30px">購買日期：</td>
            <td style="text-align: left;font-weight:bold"><fmt:formatDate pattern="yyyy-MM-dd" value="${today}" /></td></tr>
        <tr><td style="text-align: right;font-weight:bold;color:#1B813E;line-height: 30px"><label style="display:inline-block">E-mail：</label></td>
        	<td style="text-align: left"><input id='email' name="email" type="text" value="${mb.email}" style="width: 400px;" ></td></tr>
        <tr><td style="text-align: right;font-weight:bold;color:#1B813E;line-height: 30px"><label style="display:inline-block">地址：</label></td>
        	<td style="text-align: left"><input name="customerAddress" id='coCustomerAddress' type="text" value="${mb.address}" style="width: 400px" ></td></tr>
        <tr><td style="text-align: right;font-weight:bold;color:#1B813E;line-height: 30px">意見(選填)：</td>
        	<td style="text-align: left"><input name="coComment" id='coComment' type="text" style="width: 400px; height:100px"></td></tr>
        
    </table>
</div>
<div>
    <table style="float:right;margin-top:30px;height:375px;display:inline-block;vertical-align: top"cellpadding="10" >
		<tr><th colspan="4" style="text-align:center;font-weight:bold;color:#81C7D4;font-size:36px">購買課程一覽</th></tr>
        <tr class="trReverse" style="text-align:center;font-weight:bold;font-size:22px">
            <th class="thReverse">課程名稱</th>
            <th class="thReverse">價格</th>
            <th class="thReverse">人數</th>
            <th class="thReverse">小計</th>
        </tr>
        <c:forEach varStatus="vs" var="orderCo" items="${ccc.cartCo}"> <!-- 兩層 ccc.cartCo 在 CourseControllerF #43 #71 -->
        <tr class="trReverse">
            <td class="tdReverse" style="font-weight:bold;color:#1B813E">
            <a href="<c:url value='/18/cCourseDetail.ctrl?coId=${orderCo.value.coId}' />"style="color:#1B813E">${orderCo.value.coTitle}</a></td>
            <td class="tdReverse">${orderCo.value.coPrice} 元</td>
            <td class="tdReverse">${orderCo.value.coNum} 人</td>
            <td class="tdReverse" style="font-weight:bold">${orderCo.value.coPrice * orderCo.value.coNum} 元</td>
        </tr>
        </c:forEach>
        <tr>
        
 	 	<td colspan="4" style="font-weight:bold;text-align:right">總計： ${ccc.total} 元</td>
    </tr>
    </table>
    </div>
    </FORM>
    </div>
    
	</div>
	
   <div class="container" style="text-align: center; font-size: 20px">
   <input type="hidden" name="finalDecision"  value="">  
   <input type="button" class="genric-btn success radius large" style="font-weight:bold;font-size:32px; color:black" name="OrderBtn"  value="送出本訂單" onclick="confirmOrderCo();">   
<!-- 			↑原本的彈出視窗  ；  SweetAlert↓   -->   
<!--    <input type="button" class="genric-btn success radius" style="font-weight:bold;font-size:32px; color:black" name="OrderBtn"  value="送出本訂單" onclick="submitSAF2();">    -->
   <br>
   <br>
   <br>
   <input type="button" class="genric-btn info circle" style="font-size:32px; color:black" value="返回課程總覽繼續選購" onclick="location.href='<c:url value='/18/cSelectAllFront.ctrl' />'">
   <br>
   <br>
   <br>
   <br>
   <br>
   <!-- id需與下方script相同 -->
   <div>
   <button id="OrderDetailComment" class="genric-btn primary-border radius">一鍵輸入買家意見</button>
   <button id="OrderDetailMail" class="genric-btn primary-border radius">一鍵輸入測試用信箱</button></div>
   
   </div>

<script type="text/javascript">  

// function submitSAF2(customerAddress,email){
// 	swal("您確定要送出訂單嗎？","", "warning",{
// 	    buttons: {
// 	      danger: {
// 	          text: "是"
// 	        },
// 	      "否": true,
// 	    },
// 	  })

// 		.then((value4) => {
// 		switch (value4) {
// 		case "danger":
// 	    	swal("成功送出訂單","", "success")
// 	    	setTimeout(function(){window.location="<c:url value='/18/ProcessOrderCo.ctrl?customerAddress="+customerAddress+"&email="+email+"' />" ; },2000);
// 	        break;
// 	      case "不是":
// 	        swal("已取消","", "info");
// 	        break;
// 	      default:
// 	    	  swal("未送出","", "info");
// 	        break;
// 		}
// 		});
// };
     
</script>   
<script>
<!-- $("最上方的id:識別名稱") -->
$("#OrderDetailComment").click(function(){
	$("#coComment").val("已報名，感謝。");
})

$("#OrderDetailMail").click(function(){
	$("#email").val("aaartgroup4@gmail.com");
})

// <!-- 使用var宣告變數，可用範圍以function為界 -->
function confirmOrderCo(){
	if (confirm("您確定要送出 ? ") ) {
		document.forms[0].action="<c:url value='/18/ProcessOrderCo.ctrl'/>";
		document.forms[0].method="POST";
		document.forms[0].submit();
		return;
	} else {
		return;
	}
}

</script>