<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="zh-tw">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>查詢結果</title>
<style>
.page li {
	display: inline;
}

.date {
	width: 250px;
}

.title {
	width: 700px;
}

.site {
	width: 300px;
}

.buy {
	width: 50px;
}





</style>
</head>
<body>
	<%-- 	<jsp:include page="/fragment/top.jsp" /> --%>
	<!-- start banner Area -->
			<section class="banner-area relative" id="home">	
				<div class="overlay overlay-bg"></div>
				<div class="container">
					<div class="row d-flex align-items-center justify-content-center">
						<div class="about-content col-lg-12">
							<h1 class="text-white">
								AAART Ticket
							</h1>	
							<p class="text-white link-nav"><a href="<c:url value='/index.html' />">Home </a>  <span class="lnr lnr-arrow-right"></span>  <a href=""> Search</a></p>
						</div>											
					</div>
				</div>
			</section>
	<!-- End banner Area -->
	
	<div class="container">
		<!-- 頂部按鈕	 -->
		<form method=GET action="<c:url value='/04/SearchTo.ctrl?'/>">
			<br>
<!-- 			隱藏屬性 用來傳遞頁數 -->
			<input type="hidden" name="page" value=""> <input
				type="hidden" name="searchsite" value=""> <input type="hidden"
				name="startdate" value=""> <input type="hidden"
				name="enddate" value=""> <input type="hidden"
				name="searchString" value="">

			<button name="category" type="submit" value="1" class="genric-btn primary radius">音樂</button>
			<button name="category" type="submit" value="2" class="genric-btn primary radius">戲劇</button>
			<button name="category" type="submit" value="3" class="genric-btn primary radius">舞蹈</button>
			<button name="category" type="submit" value="4" class="genric-btn primary radius">親子</button>
			<button name="category" type="submit" value="5" class="genric-btn primary radius">獨立音樂</button>
			<button name="category" type="submit" value="6" class="genric-btn primary radius">展覽</button>
			<button name="category" type="submit" value="7" class="genric-btn primary radius">講座</button>
			<button name="category" type="submit" value="8" class="genric-btn primary radius">電影</button>
			<button name="category" type="submit" value="11" class="genric-btn primary radius">綜藝</button>
<!-- 			<button name="category" type="submit" value="13" class="genric-btn primary radius">競賽</button> -->
<!-- 			<button name="category" type="submit" value="14" class="genric-btn primary radius">徵選</button> -->
			<button name="category" type="submit" value="15" class="genric-btn primary radius">其他</button>
<!-- 			<button name="category" type="submit" value="16" class="genric-btn primary radius">科教</button> -->
			<button name="category" type="submit" value="17" class="genric-btn primary radius">演唱會</button>
<!-- 			<button name="category" type="submit" value="19" class="genric-btn primary radius">研習課程</button> -->
		</form>
		
<%-- 		<li><a href="<c:url value='/04/goshoppingcart.ctrl' />"><i class="fas fa-ticket-alt" style="font-size:13px"></i></a> --%>
<%-- 		<li><a href="<c:url value='/04/goshoppingcart.ctrl' />"><i class="fas fa-headphones-alt" style="font-size:50px"></i></a> --%>
		
		
		<c:set var="totalnum" value="${requestScope.totalnum}" />
		<c:set var="PerPage" value="${requestScope.PerPage}" />
		<c:set var="totalPages" value="${requestScope.totalPages}" />
		<c:set var="beginIndex" value="${requestScope.beginIndex}" />
		<c:set var="endIndex" value="${requestScope.endIndex}" />
		<c:set var="page" value="${requestScope.page}" />
		<c:set var="currentPage"
			value="${requestScope.key_list.subList(beginIndex,endIndex)}" />

		<br><br>
		<p>搜尋結果<br>總筆數:${totalnum} 每頁筆數:${PerPage} 總頁數:${totalPages} 目前位於第${page}頁</p>

		<table class="table table-bordered">
			<tr>
				<th class="date">日期</th>
				<th class="title">節目名稱</th>
				<th class="site">場地</th>
				<th class="buy">購買</th>
			</tr>

			<%--使用JSTL 執行for loop ${show.no}取map內value --%>
			<c:forEach items="${currentPage}" var="show" varStatus="idx">
				<tr>
<!-- 					傳送訂單資訊 -->
					<form method="GET" action="<c:url value='/04/showDetail.ctrl'/>">
					<td>${show.startdate}~ ${show.enddate}</td>
					<td>${show.title}</td>
					<td>${show.site}</td>
					<td><input type=SUBMIT value="購買" class="genric-btn success-border radius"></td>
<!-- 					這些隱藏欄位都會送到後端 -->
<%-- 					<Input type='hidden' name='title' value='${show.title}'> --%>
					<Input type='hidden' name='actid' value='${show.no}'>


					</form>
					</tr>

			</c:forEach>


		</table>
		<br>

		<!-- 頁數區 -->
		<div class="d-flex justify-content-center">
		<div class="btn-toolbar" role="toolbar"
			aria-label="Toolbar with button groups">
			<div class="btn-group mr-2" role="group" aria-label="First group">
				<ul class="page">
					<button type="button" class="genric-btn info"
						onclick="location.href='<c:url value="/04/SearchTo.ctrl?page=1&searchString=${searchString}&category=${category}&searchsite=${searchsite}&startdate=${startdate}&enddate=${enddate}"/>'">首頁</button>

					<button type="button" class="genric-btn info"
						onclick="location.href='<c:url value="/04/SearchTo.ctrl?page=${page-1>1?page-1:1}&searchString=${searchString}&category=${category}&searchsite=${searchsite}&startdate=${startdate}&enddate=${enddate}"/>'">&laquo;</button>

					<c:forEach begin="1" end="${totalPages}" varStatus="loop">
						<c:set var="active" value="${loop.index==page?'active':''}" />
						<button type="button" class="genric-btn info"
							onclick="location.href='<c:url value="/04/SearchTo.ctrl?page=${loop.index}&searchString=${searchString}&category=${category}&searchsite=${searchsite}&startdate=${startdate}&enddate=${enddate}"/>'">${loop.index}</button>
					</c:forEach>
					<button type="button" class="genric-btn info"
						onclick="location.href='<c:url value="/04/SearchTo.ctrl?page=${page-1>1?page-1:1}&searchString=${searchString}&category=${category}&searchsite=${searchsite}&startdate=${startdate}&enddate=${enddate}"/>'">&raquo;</button>
					<button type="button" class="genric-btn info"
						onclick="location.href='<c:url value="/04/SearchTo.ctrl?page=${totalPages}&searchString=${searchString}&category=${category}&searchsite=${searchsite}&startdate=${startdate}&enddate=${enddate}"/>'">最後頁</button>
			</div>


		</div>
		</div>
	</div>


</body>
</html>