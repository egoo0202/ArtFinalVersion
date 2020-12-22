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

body {
	color: black;
}

.col-sm-3 {
	background-color: #c8c8b4;
}

.col-lg-4  single-blog {
	background-color: #f5f5dc;
}
#search {
	width: 150px;	
}

</style>
</head>
<body>

	<!-- start banner Area -->
	<section class="banner-area relative" id="home">
		<div class="overlay overlay-bg"></div>
		<div class="container">
			<div class="row d-flex align-items-center justify-content-center">
				<div class="about-content col-lg-12">
					<h1 class="text-white">AAART Ticket</h1>
					<p class="text-white link-nav">
						<a href="<c:url value='/index.html' />">Home </a> <span
							class="lnr lnr-arrow-right"></span> <a href=""> Search</a>
					</p>
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
				type="hidden" name="searchsite" value=""> <input
				type="hidden" name="startdate" value=""> <input
				type="hidden" name="enddate" value=""> <input type="hidden"
				name="searchString" value="">

			<button name="category" type="submit" value="1"
				class="genric-btn primary radius">音樂</button>
			<button name="category" type="submit" value="2"
				class="genric-btn primary radius">戲劇</button>
			<button name="category" type="submit" value="3"
				class="genric-btn primary radius">舞蹈</button>
			<button name="category" type="submit" value="4"
				class="genric-btn primary radius">親子</button>
			<button name="category" type="submit" value="5"
				class="genric-btn primary radius">獨立音樂</button>
			<button name="category" type="submit" value="6"
				class="genric-btn primary radius">展覽</button>
			<button name="category" type="submit" value="7"
				class="genric-btn primary radius">講座</button>
			<button name="category" type="submit" value="8"
				class="genric-btn primary radius">電影</button>
			<button name="category" type="submit" value="11"
				class="genric-btn primary radius">綜藝</button>
			<!-- 			<button name="category" type="submit" value="13" class="genric-btn primary radius">競賽</button> -->
			<!-- 			<button name="category" type="submit" value="14" class="genric-btn primary radius">徵選</button> -->
			<button name="category" type="submit" value="15"
				class="genric-btn primary radius">其他</button>
			<!-- 			<button name="category" type="submit" value="16" class="genric-btn primary radius">科教</button> -->
			<button name="category" type="submit" value="17"
				class="genric-btn primary radius">演唱會</button>
			<!-- 			<button name="category" type="submit" value="19" class="genric-btn primary radius">研習課程</button> -->
		</form>
		<br> <br>
		<div class="row">
			<div class="col-sm-3">
				<br> <br>

				<div class="single-element-widget">
					<h3 class="mb-30">關鍵字查詢</h3>
<%-- 					<form method=GET action="<c:url value='/04/SearchTo.ctrl'/>"> --%>
					<div class="switch-wrap d-flex justify-content-between">
						<!--    模糊查詢功能 -->
						<input type=TEXT name="searchString" class="single-input" id="search"> 
						<input type=button value="查詢" class="genric-btn primary-border small" id="searchbut">
					</div>
<%-- 					</form> --%>
					<br>
					<h3 class="mb-30">條件篩選</h3>
					<div class="switch-wrap d-flex justify-content-between">
						<p>01. Sample Switch</p>
						<div class="primary-switch">
							<input type="checkbox" id="default-switch"> <label
								for="default-switch"></label>
						</div>
					</div>
					<div class="switch-wrap d-flex justify-content-between">
						<p>02. Primary Color Switch</p>
						<div class="primary-switch">
							<input type="checkbox" id="primary-switch" checked> <label
								for="primary-switch"></label>
						</div>
					</div>
					<div class="switch-wrap d-flex justify-content-between">
						<p>03. Confirm Color Switch</p>
						<div class="confirm-switch">
							<input type="checkbox" id="confirm-switch" checked> <label
								for="confirm-switch"></label>
						</div>
					</div>
				</div>
				<div class="single-element-widget mt-30">
					<h3 class="mb-30">活動分類</h3>
					<div class="default-select" id="default-select"">
						<select id="category" class="current" name="category">
							<option value="" selected>分類查詢</option>
							<option value="1">音樂</option>
							<option value="2">戲劇</option>
							<option value="3">舞蹈</option>
							<option value="4">親子</option>
							<option value="5">獨立音樂</option>
							<option value="6">展覽</option>
							<option value="7">講座</option>
							<option value="8">電影</option>
							<option value="11">綜藝</option>
							<!-- 							<option value="13">競賽</option> -->
							<!-- 							<option value="14">徵選</option> -->
							<option value="15">其他</option>
							<!-- 							<option value="16">科教</option> -->
							<option value="17">演唱會</option>
							<!-- 							<option value="19">研習課程</option> -->
						</select>
					</div>
				</div>
				<div class="single-element-widget mt-30">
					<h3 class="mb-30">地區分類</h3>
					<div class="default-select" id="default-select"">
						<select id="searchsite" class="" name="searchsite">
							<option value="" selected>地區查詢</option>
							<option value="">==北部地區==</option>
							<option value="基隆">基隆</option>
							<option value="台北">台北</option>
							<option value="新北">新北</option>
							<option value="桃園">桃園</option>
							<option value="新竹">新竹</option>
							<option value="">==中部地區==</option>
							<option value="苗栗">苗栗</option>
							<option value="台中">台中</option>
							<option value="彰化">彰化</option>
							<option value="南投">南投</option>
							<option value="雲林">雲林</option>
							<option value="">==南部地區==</option>
							<option value="嘉義">嘉義</option>
							<option value="南投">南投</option>
							<option value="高雄">高雄</option>
							<option value="屏東">屏東</option>
							<option value="">==東部地區==</option>
							<option value="宜蘭">宜蘭</option>
							<option value="花蓮">花蓮</option>
							<option value="台東">台東</option>
						</select>
					</div>
				</div>
				<div class="single-element-widget mt-30">
					<h3 class="mb-30">Checkboxes</h3>
					<div class="switch-wrap d-flex justify-content-between">
						<p>01. Sample Checkbox</p>
						<div class="primary-checkbox">
							<input type="checkbox" id="default-checkbox"> <label
								for="default-checkbox"></label>
						</div>
					</div>
					<div class="switch-wrap d-flex justify-content-between">
						<p>02. Primary Color Checkbox</p>
						<div class="primary-checkbox">
							<input type="checkbox" id="primary-checkbox" checked> <label
								for="primary-checkbox"></label>
						</div>
					</div>
					<div class="switch-wrap d-flex justify-content-between">
						<p>03. Confirm Color Checkbox</p>
						<div class="confirm-checkbox">
							<input type="checkbox" id="confirm-checkbox"> <label
								for="confirm-checkbox"></label>
						</div>
					</div>
					<div class="switch-wrap d-flex justify-content-between">
						<p>04. Disabled Checkbox</p>
						<div class="disabled-checkbox">
							<input type="checkbox" id="disabled-checkbox" disabled> <label
								for="disabled-checkbox"></label>
						</div>
					</div>
					<div class="switch-wrap d-flex justify-content-between">
						<p>05. Disabled Checkbox active</p>
						<div class="disabled-checkbox">
							<input type="checkbox" id="disabled-checkbox-active" checked
								disabled> <label for="disabled-checkbox-active"></label>
						</div>
					</div>
				</div>
				<div class="single-element-widget mt-30">
					<h3 class="mb-30">Radios</h3>
					<div class="switch-wrap d-flex justify-content-between">
						<p>01. Sample radio</p>
						<div class="primary-radio">
							<input type="checkbox" id="default-radio"> <label
								for="default-radio"></label>
						</div>
					</div>
					<div class="switch-wrap d-flex justify-content-between">
						<p>02. Primary Color radio</p>
						<div class="primary-radio">
							<input type="checkbox" id="primary-radio" checked> <label
								for="primary-radio"></label>
						</div>
					</div>
					<div class="switch-wrap d-flex justify-content-between">
						<p>03. Confirm Color radio</p>
						<div class="confirm-radio">
							<input type="checkbox" id="confirm-radio" checked> <label
								for="confirm-radio"></label>
						</div>
					</div>
					<div class="switch-wrap d-flex justify-content-between">
						<p>04. Disabled radio</p>
						<div class="disabled-radio">
							<input type="checkbox" id="disabled-radio" disabled> <label
								for="disabled-radio"></label>
						</div>
					</div>
					<div class="switch-wrap d-flex justify-content-between">
						<p>05. Disabled radio active</p>
						<div class="disabled-radio">
							<input type="checkbox" id="disabled-radio-active" checked
								disabled> <label for="disabled-radio-active"></label>
						</div>
					</div>
				</div>
				<br>
				<div class="row justify-content-center">
					<button name="category" type="submit" value=""
						class="genric-btn primary radius">清除條件</button>
				</div>
			</div>






























			<div class="col-sm-9">


				<c:set var="totalnum" value="${requestScope.totalnum}" />
				<c:set var="PerPage" value="${requestScope.PerPage}" />
				<c:set var="totalPages" value="${requestScope.totalPages}" />
				<c:set var="beginIndex" value="${requestScope.beginIndex}" />
				<c:set var="endIndex" value="${requestScope.endIndex}" />
				<c:set var="page" value="${requestScope.page}" />
				<c:set var="currentPage"
					value="${requestScope.key_list.subList(beginIndex,endIndex)}" />

				<p>
					搜尋結果<br>總筆數:${totalnum} 每頁筆數:${PerPage} 總頁數:${totalPages}
					目前位於第${page}頁
				</p>


					<div class="container">
						<div class="row" id="row">

							<!-- 					<div class="col-lg-4 event-left"> -->
<%-- 				<c:forEach items="${currentPage}" var="show" varStatus="idx"> --%>
<!-- 							<div class="col-lg-4  single-blog"> -->

<!-- 								<div class="thumb"> -->
<%-- 									<a href="<c:url value='/04/showDetail.ctrl?actid=${show.no}'/>"> --%>
<!-- 										<img style='display: block; width: 300px;' -->
<%-- 										src="data:image/jpg;base64,${show.photo}" class="actimg"> --%>
<!-- 									</a> -->
<!-- 								</div> -->
<!-- 							</div> -->
<!-- 							<div class="col-lg-8 event-left"> -->
<!-- 								<div class="single-events"> -->
<%-- 									<a href="<c:url value='/04/showDetail.ctrl?actid=${show.no}'/>"><h3>${show.title}</h3></a> --%>
<!-- 									<h4> -->
<%-- 										<span>${show.startdate}~ ${show.enddate}</span> --%>
<!-- 									</h4> -->
<%-- 									<p>${show.site}</p> --%>
<%-- 									<p>${show.description}</p> --%>
<!-- 									<div class="row justify-content-end"> -->
<%-- 										<form method="GET" --%>
<%-- 											action="<c:url value='/04/showDetail.ctrl'/>"> --%>
<%-- 											<Input type='hidden' name='actid' value='${show.no}'> --%>
<!-- 											<input type=SUBMIT value="查看詳情" -->
<!-- 												class="primary-btn text-uppercase"> -->
<%-- 										</form> --%>
<!-- 									</div> -->
<!-- 								</div> -->
<!-- 							</div> -->
<!-- 						</div> -->
<!-- 					</div> -->
<!-- 					<br> -->
<%-- 				</c:forEach> --%>
			</div>
		</div>

		<br>

		<!-- 頁數區 -->
		<div class="d-flex justify-content-center">
			<div class="btn-toolbar" role="toolbar"
				aria-label="Toolbar with button groups">
				<div class="btn-group mr-2" role="group" aria-label="First group">
					<ul class="page">
						<button type="button" class="genric-btn primary-border small"
							onclick="location.href='<c:url value="/04/SearchTo.ctrl?page=1&searchString=${searchString}&category=${category}&searchsite=${searchsite}&startdate=${startdate}&enddate=${enddate}"/>'">首頁</button>

						<button type="button" class="genric-btn primary-border small"
							onclick="location.href='<c:url value="/04/SearchTo.ctrl?page=${page-1>1?page-1:1}&searchString=${searchString}&category=${category}&searchsite=${searchsite}&startdate=${startdate}&enddate=${enddate}"/>'">&laquo;</button>

						<c:forEach begin="1" end="${totalPages}" varStatus="loop">
							<c:set var="active" value="${loop.index==page?'active':''}" />
							<button type="button" class="genric-btn primary-border small"
								onclick="location.href='<c:url value="/04/SearchTo.ctrl?page=${loop.index}&searchString=${searchString}&category=${category}&searchsite=${searchsite}&startdate=${startdate}&enddate=${enddate}"/>'">${loop.index}</button>
						</c:forEach>
						<button type="button" class="genric-btn primary-border small"
							onclick="location.href='<c:url value="/04/SearchTo.ctrl?page=${page-1>1?page-1:1}&searchString=${searchString}&category=${category}&searchsite=${searchsite}&startdate=${startdate}&enddate=${enddate}"/>'">&raquo;</button>
						<button type="button" class="genric-btn primary-border small"
							onclick="location.href='<c:url value="/04/SearchTo.ctrl?page=${totalPages}&searchString=${searchString}&category=${category}&searchsite=${searchsite}&startdate=${startdate}&enddate=${enddate}"/>'">最後頁</button>
				</div>


			</div>
		</div>
	</div>
<script>	

$("#searchbut").click(function(){
	var searchString=$("#search").val();
		 alert(searchString);
   	 $.ajax({
			type: "get",
			url: "/Art/04/Searchajax",
			contentType: "application/json",
			dataType: "json",
			data: {"searchString":searchString},
			cache: false,
			success: function(json) {
				$.each(json, function( index, show ) {
				$("#row").append(
						"<div class='row'>"
						+"<div class='col-lg-4  single-blog'>"
						+"<div class='thumb'>"
							+"<a href='<c:url value='/04/showDetail.ctrl?actid="+show.ACT_NO+"'/>'>"
								+"<img style='display: block; width: 300px;'src='data:image/jpg;base64,"+show.PHOTOBASE64+"' class='actimg'>"
							+"</a>"
						+"</div>"
					+"</div>"
					+"<div class='col-lg-8 event-left'>"
						+"<div class='single-events'>"
							+"<a href='<c:url value='/04/showDetail.ctrl?actid="+show.ACT_NO+"'/>'><h3>"+show.ACT_TITLE+"</h3></a>"
							+"<h4>"
								+"<span>"+show.ACT_STARTDATE+"~"+show.ACT_ENDDATE+"</span>"
							+"</h4>"
							+"<p>"+show.ACT_LOCATION_NAME+"</p>"
							+"<p>"+show.ACT_DESCRIPTION+"</p>"
							+"<div class='row justify-content-end'>"
								+"<form method='GET'action='<c:url value='/04/showDetail.ctrl'/>'>"
									+"<Input type='hidden' name='actid' value='"+show.ACT_NO+"'>"
									+"<input type=SUBMIT value='查看詳情' class='primary-btn text-uppercase'>"
								+"</form>"
							+"</div>"
						+"</div>"
					+"</div>"
					+"<br>"
				);
					});
								
			},
			error:  function() {
				alert("failure");
			}
			});	


});
	
</script>


</body>
</html>