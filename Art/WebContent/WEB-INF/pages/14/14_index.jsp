<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<%@ page import="tw.group4._14_.*"%>
<%@ page import="java.nio.charset.StandardCharsets"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>

    <head>
        <meta charset="UTF-8">
             
 
        <title>得藝洋行</title>
        
        
        <style>
@import url(https://fonts.googleapis.com/earlyaccess/cwtexfangsong.css);
 @import url('https://fonts.googleapis.com/css2?family=Amatic+SC&display=swap');

.fa, .fas {
      font-weight: 900;
}

        .pagination > li > a
{
    background-color: white;
    color: #5A4181;
}

.pagination > li > a:focus,
.pagination > li > a:hover,
.pagination > li > span:focus,
.pagination > li > span:hover
{
    color: #1b9aaa;
    background-color: #eee;
    border-color: #ddd;
}

.pagination > .active > a
{
    color: white;
    background-color: #5A4181 !Important;
    border: solid 1px #5A4181 !Important;
}

.pagination > .active > a:hover
{
    background-color: #5A4181 !Important;
    border: solid 1px #5A4181;
}


p,div{
font-family:cwTeXFangSong, serif;
}

 
        </style>
    </head>

    <body>
    
 


    <div class="container" style="background-color:  #f5f1e3;">
        <div class="jumbotron" style="background-color: #dddbcb;">
            <h1 class="display-4" style="font-family:cwTeXFangSong, serif; text-align: center;">得藝洋行</h1>
            <h3 class="lead" style="text-align: center;" >"All the products are a piece of art."</h3>
            <hr class="my-4">
            <h4 style="font-family:cwTeXFangSong, serif; text-align: center;">得藝的一天，從下單開始</h4>
            <br><br>
            
            <form  ACTION="shopListController.ctrl">
            <div style="text-align: center;"><input type="text" name="searchName" style="text-align: center;" placeholder="你一天的開始"><button type="submit" class="btn btn-outline-dark btn-sm" > <svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-search" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
  			<path fill-rule="evenodd" d="M10.442 10.442a1 1 0 0 1 1.415 0l3.85 3.85a1 1 0 0 1-1.414 1.415l-3.85-3.85a1 1 0 0 1 0-1.415z"/>
 			<path fill-rule="evenodd" d="M6.5 12a5.5 5.5 0 1 0 0-11 5.5 5.5 0 0 0 0 11zM13 6.5a6.5 6.5 0 1 1-13 0 6.5 6.5 0 0 1 13 0z"/>
			</svg></button></div>
			</form>
        </div>

       <div class="container">
            <div class="row justify-content-md-center">
            <div class="btn-toolbar mb-3" role="toolbar" aria-label="Toolbar with button groups">
                <div class="btn-group" role="group" aria-label="Button group with nested dropdown">
                    <button type="button" class="btn btn-info" value="全部商品" onclick="location.href='<c:url value='/14/shopListController.ctrl' />'">全部商品</button>
                    <div class="btn-group" role="group">
                        <button id="btnGroupDrop1" type="button" class=" btn btn-info dropdown-toggle"
                            data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            書寫用品
                        </button>
                        <div class="dropdown-menu" aria-labelledby="btnGroupDrop1">
                            <a class="dropdown-item" href="<c:url value='/14/shopListController.ctrl?query=pen' />">鋼筆</a>
                            <a class="dropdown-item" href="<c:url value='/14/shopListController.ctrl?query=ink' />">墨水</a>
                        </div>
                    </div>

                    <div class="btn-group" role="group">
                        <button id="btnGroupDrop1" type="button" class="btn btn-info dropdown-toggle"
                            data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            生活用品
                        </button>
                        <div class="dropdown-menu" aria-labelledby="btnGroupDrop1">
                            <a class="dropdown-item" href="<c:url value='/14/shopListController.ctrl?query=home' />">家飾布置</a>
                            <a class="dropdown-item" href="<c:url value='/14/shopListController.ctrl?query=cook' />">精選器皿</a>
                            <a class="dropdown-item" href="<c:url value='/14/shopListController.ctrl?query=deco' />">飾品小物</a>
                        </div>
                    </div>
                </div>
                <c:if test="${ funcName != 'ORD' }">
       			 <button type="button" style="margin-left: 10px;" class="btn btn-outline-info" value="全部商品" onclick="location.href='<c:url value='/14/showOrderList.ctrl' />'"> 訂單查詢 </button>
				</c:if>
                <FORM ACTION="gotoCart.ctrl">
                <input type="hidden" name="method" value="order"/>
                <input type="submit" style="margin-left: 10px;" class="btn btn-outline-info" name="check" value="前往結帳頁面">
                </FORM>
                <button type="button" style="margin-left: 10px;" class="btn btn-outline-light" value="全部商品"  onclick="location.href='14_CRUDPage.jsp'"> 商品管理 </button>
           </div>     
            </div>
        </div>
        <br>
        <%if(pageContext.getRequest().getAttribute("carSize")==null){
           	pageContext.getRequest().setAttribute("carSize", 0);
           } %>
    
    
<%--     <div><span>購物車項目筆數： </span><span name="carSize"><%=pageContext.getRequest().getAttribute("carSize") %></span></div> --%>
    <div><span>購物車項目數： </span><span name="carSize"><%=pageContext.getSession().getAttribute("carSize") %></span></div>
    
		
    <c:choose>
    <c:when test='${! empty queryList }'>
    
        <div class="row row-cols-1 row-cols-md-3 ">
        
                <c:forEach var='query' items='${queryList}' varStatus="vs">
    			<FORM ACTION="showOneProduct.ctrl" name="method" value="selectItem">
    			<input type="hidden" name="query" value="${query}"/>
    			<input type="hidden" name="method" value="selectItem"/>
                    <div class="col mb-4">
                        <div class="card h-100">
<%--                             <img src="${query.productImg}" class="card-img-top" alt="..."> --%>
                            <img src="${pageContext.servletContext.contextPath}/14/getBlobImage/${query.productId}.ctrl" class="card-img-top" alt="...">
                            <div class="card-body">
                                <h5 class="card-title">${query.productTitle}</h5>
                                <p class="card-text">售價：
                                <fmt:formatNumber value="${query.productPrice}" type="number" /> 元</p>

                                <input type="hidden" name="productID" value="${query.productId}"/>
                                <input type="hidden" name="orderPrice" value="${query.productPrice}"/>
                                <input type="hidden" name="orderImg" value="${query.productImg}"/>
                                <input type="hidden" name="orderNum" value="${query.productNum}"/>
                                <input type="hidden" name="orderDes" value="${query.productDes}"/>
                               <button class="btn btn-outline-secondary btn-sm" type="submit" name="orderTitle" value="${query.productTitle}" >瀏覽商品 </button>
                            </div>
                        </div>
                    </div>
                    </FORM>
               </c:forEach>
       </div>
       </c:when>
       <c:otherwise>
       <div class="row row-cols-1 row-cols-md-3">
       
                <c:forEach var='pdList' items='${pList}' varStatus="vs">
                <FORM ACTION="showOneProduct.ctrl" name="method" value="selectItem">
                <input type="hidden" name="method" value="selectItem"/>
                    <div class="col mb-4">
                        <div class="card">
<%--                             <img src="${pdList.productImg}" class="card-img-top" alt="..."> --%>
                            <img src="${pageContext.servletContext.contextPath}/14/getBlobImage/${pdList.productId}.ctrl" class="card-img-top" alt="壞了">
                            <div class="card-body">
                                <h5 class="card-title">${pdList.productTitle}</h5>
                                <p class="card-text">售價：
                                <fmt:formatNumber value="${pdList.productPrice}" type="number" /> 元</p>

                                <input type="hidden" name="query" value="${query}"/>
                                <input type="hidden" name="productID" value="${pdList.productId}"/>
                                <input type="hidden" name="orderPrice" value="${pdList.productPrice}"/>
                                <input type="hidden" name="orderImg" value="${pdList.productImg}"/>
                                <input type="hidden" name="orderNum" value="${pdList.productNum}"/>
                                <input type="hidden" name="orderDes" value="${pdList.productDes}"/>
                               <button class="btn btn-outline-secondary btn-sm" type="submit" name="orderTitle" value="${pdList.productTitle}" >瀏覽商品 </button>
                            </div>
                        </div>
                    </div>
                    </form>
               </c:forEach>
       </div>
       </c:otherwise>
       </c:choose>
       
       <div style="margin-left: 500px;">第 ${pageNo} 頁 // 共 ${totalPages} 頁</div>
 <div class="container">
       <div class="row justify-content-md-center">
       


<nav aria-label="Page navigation example" style="margin: auto;">
  <ul class="pagination" style="margin: auto;">
    <li class="page-item" style="margin: auto;">
    <c:if test="${pageNo > 1}">
      <a class="page-link" href="<c:url value='/14/shopListController.ctrl?pageNo=${pageNo-1}&query=${query}' />" aria-label="Previous">
        <span aria-hidden="true">&laquo;</span>
      </a>
      </c:if>
    </li>
    <c:forEach var='page' items='${pages}'>
    <li class="page-item"><a class="page-link" href="<c:url value='/14/shopListController.ctrl?pageNo=${page}&query=${query}' />">${page}</a></li>
    </c:forEach>
    <c:if test="${pageNo != totalPages}">
    <li class="page-item">
      <a class="page-link" href="<c:url value='/14/shopListController.ctrl?pageNo=${pageNo+1}&query=${query}' />" aria-label="Next">
        <span aria-hidden="true">&raquo;</span>
      </a>
    </li>
    </c:if>	
  </ul>
</nav>
</div>
</div>
       
    </body>

</html>