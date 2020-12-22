<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="zh-tw">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>首頁</title>
<!-- <link rel="stylesheet" -->
<!-- 	href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" -->
<!-- 	integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" -->
<!-- 	crossorigin="anonymous"> -->
<!-- <link rel="stylesheet" -->
<!-- 	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" -->
<!-- 	integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" -->
<!-- 	crossorigin="anonymous"> -->
<!-- <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" -->
<!-- 	integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" -->
<!-- 	crossorigin="anonymous"></script> -->
<!-- <script -->
<!-- 	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" -->
<!-- 	integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" -->
<!-- 	crossorigin="anonymous"></script> -->
<!-- <script -->
<!-- 	src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" -->
<!-- 	integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" -->
<!-- 	crossorigin="anonymous"></script> -->

<style>
.logo {
	width: 600px;
}

#search {
	width: 400px;
	height: 30px;
	margin-left: 50px;
}

#category {
	width: 120pX;
	float:left;
	margin-left: 50px;
}

#searchsite {
	width: 120pX;
	float:left;
}

.textbox-n {
	width: 100pX;
}

.bodydiv {
	height: 300px;
	margin-left: 300px;
	margin-top: 100px;
}

.footer {
	height: 100PX;
	background-color: #1B9AAA;
}

#searchbut {
	/*         float:right; */
	
}
</style>
</head>
<BODY>
	<c:set var="funcName" value="IND" scope="session" />

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
		<form method=GET action="<c:url value='/04/SearchTo.ctrl'/>">
			<br>
			<!-- 隱藏屬性 用來傳遞頁數 -->
			<input type="hidden" name="page" value=""> 
			<input type="hidden" name="searchsite" value=""> 
			<input type="hidden"name="startdate" value=""> 
			<input type="hidden"name="enddate" value=""> 
			<input type="hidden"name="searchString" value="">

			<button name="category" type="submit" value="1" class="genric-btn primary radius">音樂</button>
			<button name="category" type="submit" value="2" class="genric-btn primary radius">戲劇</button>
			<button name="category" type="submit" value="3" class="genric-btn primary radius">舞蹈</button>
			<button name="category" type="submit" value="4" class="genric-btn primary radius">親子</button>
			<button name="category" type="submit" value="5" class="genric-btn primary radius">獨立音樂</button>
			<button name="category" type="submit" value="6" class="genric-btn primary radius">展覽</button>
			<button name="category" type="submit" value="7" class="genric-btn primary radius">講座</button>
			<button name="category" type="submit" value="8" class="genric-btn primary radius">電影</button>
			<button name="category" type="submit" value="11" class="genric-btn primary radius">綜藝</button>
			<button name="category" type="submit" value="13" class="genric-btn primary radius">競賽</button>
			<button name="category" type="submit" value="14" class="genric-btn primary radius">徵選</button>
			<button name="category" type="submit" value="15" class="genric-btn primary radius">其他</button>
			<button name="category" type="submit" value="16" class="genric-btn primary radius">科教</button>
			<button name="category" type="submit" value="17" class="genric-btn primary radius">演唱會</button>
			<button name="category" type="submit" value="19" class="genric-btn primary radius">研習課程</button>


		</form>


		<div class="form-group">
			<div class="bodydiv">

				<img src="<c:url value='/images/04/logo.jpg'/> " alt="logo" title="logo" class="logo"><br>

				<form method=GET action="<c:url value='/04/SearchTo.ctrl'/>">

					<!-- 隱藏屬性 用來傳遞頁數 -->
					<input type="hidden" name="page" value="1">

					<!--    模糊查詢功能 -->
					<input type=TEXT name="searchString" class=""
						placeholder="音樂 展覽 舞蹈 台中" id="search"> <input type=SUBMIT
						value="查詢" class="btn btn-info" id="searchbut"><br>
					<br> <select id="category" class="current" name="category">
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
						<option value="13">競賽</option>
						<option value="14">徵選</option>
						<option value="15">其他</option>
						<option value="16">科教</option>
						<option value="17">演唱會</option>
						<option value="19">研習課程</option>
					</select> 
					<select id="searchsite" class="" name="searchsite">
						<option value="" selected>地區查詢</option>
						<optgroup label="==北部地區==">
						<option value="基隆">基隆</option>
						<option value="台北">台北</option>
						<option value="新北">新北</option>
						<option value="桃園">桃園</option>
						<option value="新竹">新竹</option>
						</optgroup>
						<optgroup label="==中部地區==">
						<option value="苗栗">苗栗</option>
						<option value="台中">台中</option>
						<option value="彰化">彰化</option>
						<option value="南投">南投</option>
						<option value="雲林">雲林</option>
						</optgroup>
						<optgroup label="==南部地區==">						
						<option value="嘉義">嘉義</option>
						<option value="南投">南投</option>
						<option value="高雄">高雄</option>
						<option value="屏東">屏東</option>
						</optgroup>
						<optgroup label="==東部地區==">						
						<option value="宜蘭">宜蘭</option>
						<option value="花蓮">花蓮</option>
						<option value="台東">台東</option>
						</optgroup>

					</select> 
					<input placeholder="開始日查詢" class="textbox-n" type="text"
						onfocus="(this.type='date')" id="startdate" name="startdate">
					<input placeholder="結束日查詢" class="textbox-n" type="text"
						onfocus="(this.type='date')" id="enddate" name="enddate">
				
				</form>
			</div>
		</div>

		<div id="carouselExampleIndicators" class="carousel slide"
			data-ride="carousel">
			<ol class="carousel-indicators">
				<li data-target="#carouselExampleIndicators" data-slide-to="0"
					class="active"></li>
				<li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
				<li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
			</ol>
			<div class="carousel-inner">
				<div class="carousel-item active">
					<img src="<c:url value='/images/04/slidepic.jpg'/>" class="d-block w-100" alt="...">
				</div>
				<div class="carousel-item">
					<img src="<c:url value='/images/04/slidepic3.jpg'/>" class="d-block w-100" alt="...">
				</div>
				<div class="carousel-item">
					<img src="<c:url value='/images/04/slidepic6.jpg'/>" class="d-block w-100" alt="...">
				</div>
				<div class="carousel-item">
					<img src="<c:url value='/images/04/slidepic7.jpg'/>" class="d-block w-100" alt="...">
				</div>
			</div>
			<a class="carousel-control-prev" href="#carouselExampleIndicators"
				role="button" data-slide="prev"> <span
				class="carousel-control-prev-icon" aria-hidden="true"></span> <span
				class="sr-only">Previous</span>
			</a> <a class="carousel-control-next" href="#carouselExampleIndicators"
				role="button" data-slide="next"> <span
				class="carousel-control-next-icon" aria-hidden="true"></span> <span
				class="sr-only">Next</span>
			</a>
		</div>
		<br>

		<!-- Content here -->
	</div>
















<!-- 	<footer id="footer" class="footer"> -->
<!-- 		<p class="text-center"> -->
<!-- 			連絡資訊<br> 客服信箱: AAART@gmailcom.tw 客服專線: -->
<!-- 			0800-000-000(零八零零-控控控-控控控)<br> line LINE客服: @AAART <br> -->
<!-- 			服務時間: Mon-Fri 9:30am–8:00pm Sat.11:00am-7:00pm -->
<!-- 		<p> -->
<!-- 	</footer> -->
</BODY>
</HTML>