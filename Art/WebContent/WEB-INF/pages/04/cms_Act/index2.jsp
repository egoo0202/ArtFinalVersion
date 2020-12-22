<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="zh-tw">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>得藝的一天後台管理系統</title>
<style>
.page li {
	display: inline;
}

.no {
	width: 30px;
}

.title {
	width: 550px;
}

.site {
	width: 200px;
}

.date {
	width: 100px;
}

.do {
	width: 100px;
}
</style>
</head>
<body>
<%-- 	<jsp:include page="/fragment/top.jsp" /> --%>
	<div class="container">
		<br>
		<br>
		<h1>後臺管理系統:修改活動資訊</h1>
<%-- 		<form method=GET action="<c:url value='/SearchAll'/>"> --%>
		<form method=GET action="SearchAll.ctrl">
<%-- 			<Input type='hidden' name='page' value='${page}'> --%>
			<input type=TEXT name="searchString" class="" placeholder=""id="search"> 
			<input type=SUBMIT value="查詢" class="btn btn-info" id="searchbut"><br><br>
			</form>
			
			<button type="button" class="btn btn-info" value="button"
				onclick="location.href='insert'">新增活動</button>
				
			<c:set var="totalnum" value="${requestScope.totalnum}" />
			<c:set var="PerPage" value="${requestScope.PerPage}" />
			<c:set var="totalPages" value="${requestScope.totalPages}" />
			<c:set var="beginIndex" value="${requestScope.beginIndex}" />
			<c:set var="endIndex" value="${requestScope.endIndex}" />
			<c:set var="page" value="${requestScope.page}" />
			<c:set var="currentPage" value="${requestScope.key_list.subList(beginIndex,endIndex)}" />

			<p>總筆數:${totalnum} 每頁筆數:${PerPage} 總頁數:${totalPages} 目前在第${page}頁</p>
			<p>TEST總筆數:${total} 每頁筆數:${PerPage} 總頁數:${totalPages} 目前在第${pageNo}頁 pages</p>
			<!-- 頂部按鈕	 -->
			<form method=GET action="Category2.ctrl">
				<br>
				<!-- 隱藏屬性 用來傳遞頁數 -->
				<input type="hidden" name="page" value="">

				<button name="category" type="submit" value="1" class="btn btn-info">音樂</button>
				<button name="category" type="submit" value="2" class="btn btn-info">戲劇</button>
				<button name="category" type="submit" value="3" class="btn btn-info">舞蹈</button>
				<button name="category" type="submit" value="4" class="btn btn-info">親子</button>
				<button name="category" type="submit" value="5" class="btn btn-info">獨立音樂</button>
				<button name="category" type="submit" value="6" class="btn btn-info">展覽</button>
				<button name="category" type="submit" value="7" class="btn btn-info">講座</button>
				<button name="category" type="submit" value="8" class="btn btn-info">電影</button>
				<button name="category" type="submit" value="11"
					class="btn btn-info">綜藝</button>
				<button name="category" type="submit" value="13"
					class="btn btn-info">競賽</button>
				<button name="category" type="submit" value="14"
					class="btn btn-info">徵選</button>
				<button name="category" type="submit" value="15"
					class="btn btn-info">其他</button>
				<button name="category" type="submit" value="16"
					class="btn btn-info">科教</button>
				<button name="category" type="submit" value="17"
					class="btn btn-info">演唱會</button>
				<button name="category" type="submit" value="19"
					class="btn btn-info">研習課程</button>
			</form>

			<table class="table table-bordered">
				<tr>
					<th class="no">編號</th>
					<th class="title">節目名稱</th>
					<th class="site">場地</th>
					<!-- 			<th class="date">日期</th> -->
					<th class="do">操作</th>
				</tr>

				<%--使用JSTL 執行for loop ${show.no}取map內value --%>
				<c:forEach items="${key_list}" var="show" varStatus="idx">
					<tr>
						<!-- 傳送節目資訊 -->
						<td>${show.no}</td>
						<td>${show.title}</td>
						<td>${show.site}</td>

							<td>
						<form name="order" action="<c:url value='/Update'/>" method="get">
								<button name="" type="submit" value="" class="btn btn-info">修改</button>
							<!-- 這些隱藏欄位都會送到後端 -->
							<Input type='hidden' name='actno' value="${show.no}">
							<Input type='hidden' name='page' value='${page}'>
							<Input type='hidden' name='category' value='${category}'>
						</form>
							</td>

						<td>
						<form name="order" action="<c:url value='/Delete'/>" method="get">
								<button name="actno" type="submit" value=${show.no
									} class="btn btn-info" onclick="return del()">刪除</button>
							<!-- 這些隱藏欄位都會送到後端 -->
							<Input type='hidden' name='page' value='${page}'> <Input type='hidden' name='category' value='${category}'>
						</form>
						</td>

						<Input type='hidden' name='page' value='${page}'>
						<Input type='hidden' name='category' value='${category}'>
					</tr>

				</c:forEach>


			</table>
			<br>


			<!-- 頁數區 -->

			<div class="btn-toolbar" role="toolbar"
				aria-label="Toolbar with button groups">
				<div class="btn-group mr-2" role="group" aria-label="First group">
					<ul class="page">
						<button type="button" class="btn btn-secondary"
							onclick="location.href='<c:url value="/AAArtAction?page=1&category=${category}"/>'">首頁</button>
 
						<button type="button" class="btn btn-secondary"
							onclick="location.href='<c:url value="/AAArtAction?page=${page-1>1?page-1:1}&category=${category}"/>'">&laquo;</button>

						<c:forEach begin="1" end="${totalPages}" varStatus="loop">
							<c:set var="active" value="${loop.index==page?'active':''}" />
							<button type="button" class="btn btn-secondary"
								onclick="location.href='<c:url value="/AAArtAction?page=${loop.index}&category=${category}"/>'">${loop.index}</button>
						</c:forEach>
						<button type="button" class="btn btn-secondary"
							onclick="location.href='<c:url value="/AAArtAction?page=${page+1<totalPages?page+1:totalPages}&category=${category}"/>'">&raquo;</button>
						<button type="button" class="btn btn-secondary"
							onclick="location.href='<c:url value="/AAArtAction?page=${totalPages}&category=${category}"/>'">最後頁</button>
				</div>

			</div>
	</div>
	<!-- <script src="js\jquery-3.5.1.min.js"></script> -->
	<script src="https://code.jquery.com/jquery-3.5.1.js"
		integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc="
		crossorigin="anonymous"></script>
	</script>

	<script>
		function del() {
			var msg = "是否刪除?";
			if (confirm(msg) == true) {
				return true;
			} else {
				return false;
			}
		}
	</script>

</body>
</html>