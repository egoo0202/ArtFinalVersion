<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>
<%@ taglib prefix="fn"  uri="http://java.sun.com/jsp/jstl/functions"  %>
<%@page import="java.util.Objects"%>
<%@ page import="java.util.List" %>
<%@ page import="java.sql.*" %>
<jsp:useBean   id="today"  class="java.util.Date" scope="session"/> 
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style>
        table{
            margin: auto;
            margin-top: 50px;
        }
    
        table, th, td {
            
      border: 1px solid black;
      border-collapse: collapse;
      padding: 10px;
    }
    </style>

    <script type="text/javascript">
    
    function cancelOrder() {
    	if (confirm("確定取消此份訂單 ? ") ) {
    		// 接收此資料的Servlet會使用 finalDecision 參數的值
    		document.forms[0].action="<c:url value='/14/AbortCart.ctrl' />";
    		document.forms[0].method="POST";
    		document.forms[0].submit();
    		return;
    	} else {
    		return;
    	}
    }
    
    
    function reconfirmOrder() {
    	var sa = document.getElementById('ShippingAddress').value;
    	var name = document.getElementById('name').value;
    	var ph = document.getElementById('phone').value;
    	var mail = document.getElementById('email').value;
    	if  (sa === "" || name==="" || ph==="" || mail==="") {
    		window.alert ('姓名、電話、地址和 email 欄位不能空白！');
    		return ; 
    	}
    	if (confirm("確定送出此份訂單 ? ") ) {
    		// 接收此資料的Servlet會使用 finalDecision 參數的值
//     		document.forms[0].action="<c:url value='/14/ProcessOrder.ctrl?Address="+sa+"&BNO="+name+"&InvoiceTitle="+ph+"'/>";
    		document.forms[0].action="<c:url value='/14/ProcessOrder.ctrl'/>";
    		document.forms[0].method="POST";
    		document.forms[0].submit();
    		return;
    	} else {
    		return;
    	}
    }
    
    </script>

</head>
<body>

<!-- start banner Area -->
	<section class="banner-area relative" id="home">
		<div class="overlay overlay-bg"></div>
		<div class="container">
			<div class="row d-flex align-items-center justify-content-center">
				<div class="about-content col-lg-12">
					<h1 class="text-white">AAART Shop</h1>
					<p class="text-white link-nav">
						<a href="index.html">Home </a> <span class="lnr lnr-arrow-right"></span>
						<a href="<c:url value='/14/shopListController.ctrl' />"> Shop</a>
						<span class="lnr lnr-arrow-right"></span> <span>訂單資訊確認</span>
					</p>
				</div>
			</div>
		</div>
	</section>
<!-- End banner Area -->

<div class="container-md">
<h3 style="text-align: center;margin-top: 80px;">請確認訂單資訊</h3>
<FORM >
    <table>
        <tr>
            <th><label>收件人姓名：</label>
                <input type="text" name="ShippingName" id='name' value="${mb.realName}">
            </th>
            <th><label>聯絡電話：</label>
                <input type="text" name="ShippingTel" id='phone' value="${mb.tel}">
            </th>
            <th>訂單日期：<fmt:formatDate  value="${today}" pattern="yyyy-MM-dd"/></th>
            
        </tr>
        <tr>
            <td colspan='3' >E-mail：<input id='email' name="email" type="text" value="${mb.email}" style="width: 500px;" ></td>
            
        </tr>
        <tr>
            <td colspan='3' >收件地址：<input id='ShippingAddress' name="Address" type="text" value="${mb.address}" style="width: 500px;" ></td>
            
        </tr>
        <tr>
            <td colspan='3'>統一編號：<input name="BNO" type="text" id="BNO" style="width: 500px;" value="05076416"></td>
            
        </tr>
        <tr>
            <td colspan='3' >發票抬頭：<input name="InvoiceTitle" type="text" id="InvoiceTitle" value="財團法人資訊工業策進會" style="width: 500px;"></td>
            
        </tr>
    </table>

    <table>
        <tr>
            <th>名稱</th>
            <th>數量</th>
            <th>價格</th>
            <th>小計</th>
        </tr>
        <c:forEach varStatus="vs" var="anEntry" items="${carList.cartAP}">
        <tr>
            <td>${anEntry.value.productTitle}</td>
            <td>${anEntry.value.productPrice} $NTD</td>
            <td>${anEntry.value.productNum}</td>
            <td>${anEntry.value.productPrice * anEntry.value.productNum}</td>
        </tr>
        </c:forEach>
        <tr>
        
        <td colspan="4">總計：${carList.subtotal}</td>
    </tr>
    </table>
   <input type="hidden" name="finalDecision"  value="">   
   <div class="container" style="text-align: center;margin-top: 30px;">
   <input type="button" name="OrderBtn"  value="確定送出" onclick="reconfirmOrder();">
   <input type="button" name="CancelBtn" value="取消訂單" onclick="cancelOrder();">
<!--    <input type="button" name="btn" id="btn" value="一鍵填入" > -->
   </div>
    </FORM>
	</div>

</body>
</html>