<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="zh-tw">
<head>
<meta charset="UTF-8">
<title>訂單</title>
<style type="text/css">
form{
display:inline;
}
body {
	color: black;
	font-size:18px;
}}

</style>
</head>
<body>

<!-- start banner Area -->
			<section class="banner-area relative" id="home">	
				<div class="overlay overlay-bg"></div>
				<div class="container">
					<div class="row d-flex align-items-center justify-content-center">
						<div class="about-content col-lg-12">
							<h1 class="text-white">
								AAART Shop
							</h1>	
							<p class="text-white link-nav"><a href="index.html">Home </a>  <span class="lnr lnr-arrow-right"></span>  <a href="<c:url value='/14/shopListController.ctrl' />"> Shop</a></p>
						</div>											
					</div>
				</div>
			</section>
	<!-- End banner Area -->


<div class="container">
<form name="order" action="<c:url value='/04/UpdateOrderlist2.ctrl'/> " method="get">
 <br><br><H1>訂購人資訊</H1>
    <table class= "table table-bordered">
        <tr>
            <td>訂購人姓名
            </td>
            <td>
			<input type="text" value="${requestScope.orderlist.NAME}" name="name"class="single-input"/>
           </td>
        </tr>
        <tr>
            <td>電子郵件
            </td>
            <td>
            <input type="text" value="${requestScope.orderlist.EMAIL}" name="email" class="single-input"/>             
            </td>
        </tr>
        <tr>
            <td>電話
            </td>
            <td>
            <input type="text" value="${requestScope.orderlist.TEL}" name="tel" class="single-input"/>                          
            </td>
        </tr>
        <tr>
            <td>地址
            </td>
            <td>
             <input type="text" value="${requestScope.orderlist.ADDRESS}" name="address" class="single-input"/>            
             <input type="hidden" value="${requestScope.orderlist.ORDERPK}" name="orderPK" class="single-input"/>            
          
            </td>
        </tr>
     </table><br><br> <br>  
     
	<H2>票券資訊</H2>
		<table class="table table-bordered">
		<tr> 
				<td>節目名稱</td>
				<td>票種</td>
				<td>座位</td>
				<td>票價</td>

			</tr>
			<p class="ticketcategry"  style="display:none">${requestScope.orderlist.TICKETCATEGORY}</p>
			<c:forEach items="${requestScope.orderlist.seats}" var="seat">
			<tr> 
				<td class="title">${requestScope.orderlist.TITLE}</td>
				<td >${requestScope.orderlist.TICKETCATEGORY}</td>
				<td >${seat}</td>
				<td class="price"></td>
				
			</tr>
			</c:forEach>
			<tr> 
				<td >總計:</td>
				<td ></td>
				<td ></td>
				<td >NT$${requestScope.orderlist.TOTALPRICE}</td>
			
			</tr>
			
		</table>		
		 						
			 <button type="submit" name="orderid"  value="${requestScope.orderlist.ORDERID}" class="genric-btn success-border radius" onclick="return del()">送出修改</button>
		</form> 
</div>


<script src="https://code.jquery.com/jquery-3.5.1.js"
    integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc=" crossorigin="anonymous">
</script>

<script>
$(document).ready(		
			function() {
					console.log($(".ticketcategry").text());
					if($(".ticketcategry").text()== "全票"){
					$(".price").text("NT$2000")
					}else{
					$(".price").text("NT$1000")
					}					 
				});

    $("#update").click(function () {
    	
    		window.location ="<c:url value='/_04_Orderlist/OrderlistUpdate.jsp'/>" 
    	
    })
    

    function del() {
		var msg = "是否修改訂單";
		if (confirm(msg) == true) {
			return true;
		} else {
			return false;
		}
	}
	
    
    

 </script>	  
	  
	  
</body>

</html>