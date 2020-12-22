<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 <%request.setCharacterEncoding("UTF-8");%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="zh-tw">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>h65456購物車</title>
    <style>
        td {
            width: 100px;
        }

       .halfnum {
            width: 30px;
        }
        .adultnum {
            width: 30px;
        }
    </style>
</head>

<body>
<form name="order2" action="<c:url value='/_04_Orderlist/OrderlistServlet'/> " method="get">

<%-- 	<jsp:include page="/fragment/top.jsp" /> --%>
<%-- <c:set var="add" value="${param.add}" scope="session"/>  --%>
    <H1>購物車</H1>
 

      <table border="1">  
        
        <tr>
            <td>節目名稱</td>
            <td>票種</td>
            <td>數量</td>
            <td>價格</td>
            <td>總價</td>
            <td>操作</td>
        </tr>
       
        <%--使用JSTL 執行for loop ${show.no}取map內value --%>
        <c:forEach items="${cartlist}" var="show" varStatus="idx">
        <tr>
       <!-- 傳送訂單資訊 -->
       <form name="order" action="" method="get">
		<tr>
            <td>${show.title}</td>
            <td>全票</td>
             <td>
                <input type="button" value="-" name="minus" class="minus" id="minus">
                <!-- <P name="orderNum" id="orderNum" class="orderNum"></P> -->
                <input type="text" name="adultnum" id="adultnum" class="adultnum" value="${show.adultnum}" >
                <input type="button" value="+" name="plus" class="plus" id="plus">
            </td>
           <td name="price" class="price" id="price" >1000</td>
            <td><input type="text" name="total1" id="total1" class="total1"value="${show.total1}" readonly="readonly" /></td>
<%--             <td name="total1" id="total1" class="total1">${show.total1}</td> --%>
            <td ><input type="button" value="刪除" name="submit" class="submit" id="submit"></td>
         </tr>
         <tr>
            <td>${show.title}</td>
            <td>半票</td>
            <td>
                <input type="button" value="-" name="minus2" class="minus2" id="minus2">
                <!-- <P name="orderNum" id="orderNum" class="orderNum"></P> -->
                <input type="text" name="halfnum" id="halfnum" class="halfnum" value="${show.halfnum}" >
                <input type="button" value="+" name="plus2" class="plus2" id="plus2">
            </td>
            
            <td name="price" class="price" id="price" >500</td>
            <td><input type="text" name="total2" id="total2" class="total2"value="${show.total2}" readonly="readonly" /></td>
<%--             <td name="total2" id="total2" class="total2">${show.total2}</td> --%>
            <td ><input type="button" value="刪除" name="submit" class="submit" id="submit"></td>

        </tr>
			</form>
			
			
		</c:forEach>
<tr><td>總計</td><td></td><td></td><td></td><td><input type="text" name="total3" id="total3" class="total3"value="0" readonly="readonly" /></td><tr>
   </table>     
          <input type="submit" value="111繼續購票" name="1" class="1" id="1">  
          </form>
   		<form name="order" action="<c:url value='/_04_ShopCart/ClearCart'/>" method="POST">
          <input type="submit" value="全部清除" name="clear" class="clear" id="clear"> 
    	 </form>
         
    
<!-- <script src="js\jquery-3.5.1.min.js"></script> -->
 <script src="https://code.jquery.com/jquery-3.5.1.js"
    integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc=" crossorigin="anonymous"></script>
</script>
    <script>
        //全票
        $(document).ready(function(){
        	/* 價格顯示 */

        	/* $("select").change(function(){
        		  $("#price").text("500");
        		}); */

        	
        	var count =0 ;
        $("#adultnum").val(count);
        $("#plus").click(function () {
        	//設定數量上限為5
        	if (count < 5) {
        		count++;
            } else if (count=5 ) {
            	count = 5;
            	alert("最多訂購五張");
            }
        $("#adultnum").val(count);
        $("#total1").val(count*parseInt(1000))
        $("#total3").val(count*parseInt(1000)+count2*parseInt(500))
        }) 
        $("#minus").click(function () {
        	//設定數量下限0
        	if (count >0) {
        		count--;
            } else if (count=0 ) {
            	count = 0;
            }
        $("#adultnum").val(count);
        $("#total1").val(count*parseInt(1000))
		$("#total3").val(count*parseInt(1000)+count2*parseInt(500))
        return count;
        }) 
         var count2 = 0;
        $("#halfnum").val(count2);
        $("#plus2").click(function () {
        	if (count2 < 5) {
        		count2++;
            } else if (count2=5 ) {
            	count2 = 5;
            	alert("最多訂購五張");
            }
        $("#halfnum").val(count2);  
        $("#total2").val(count2*parseInt(500))
       	$("#total3").val(count*parseInt(1000)+count2*parseInt(500))
        }) 
        $("#minus2").click(function () {
        	if (count2 >0) {
        		count2--;
            } else if (count2=0 ) {
            	count2 = 0;
            }
        $("#halfnum").val(count2);
        $("#total2").val(count2*parseInt(500)) 
        $("#total3").val(count*parseInt(1000)+count2*parseInt(500))
        }) 

    }) 
    //半票

    </script>
</body>

</html>