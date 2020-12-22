<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<!-- Vue.js -->
<script src="https://cdn.jsdelivr.net/npm/vue@2.6.12/dist/vue.js"></script>
<title>首頁</title>
<style>
h1, h2 {
	text-align:center;
}

.logo {
	width: 600px;
}

#search {
	width: 400px;
	height: 40px;
 	margin-left: 50px; 
}

#category {
	width: 120pX;
	float:left; 
	height: 30px;
 	margin-left: 150px; 
}

#searchsite {
	width: 120pX;
	height: 30px;
 	float:left; 
}

.textbox-n {
	width: 120pX;
	height: 30px;
	float:left; 
}

.fa-palette {
  color: #1b9aaa;
}
.fa-store-alt{
  color: #1b9aaa;
}
.fa-map-marked-alt{
  color: #1b9aaa;
}
</style>
</head>

<body>

			<!-- start banner Area -->
			<section class="banner-area relative" id="home">
				<div class="overlay overlay-bg"></div>	
				<div class="container">
					<div class="row fullscreen d-flex align-items-center justify-content-center">
						<div class="banner-content col-lg-8">
							<h6 class="text-white">Openning on 25st December, 2020</h6>
							<h1 class="text-white">
									得藝的一天				
							</h1>
							<p class="pt-10 pb-50 text-white" style="font-size: 25px">
								Activity And Art						
							</p>
<%-- 							<a href="<c:url value='/element.controller' />" class="primary-btn text-uppercase">スタート！</a> --%>
				<div class="bodydiv"><br>

<%-- 				<img src="<c:url value='/images/04/logo.jpg'/> " alt="logo" title="logo" class="logo"><br> --%>

				<form method=GET action="<c:url value='/04/SearchTo.ctrl'/>">

					<!-- 隱藏屬性 用來傳遞頁數 -->
					<input type="hidden" name="page" value="1">

					<!--    模糊查詢功能 -->
					<input type=TEXT name="searchString" class=""placeholder="音樂 展覽 舞蹈 台中" id="search"> <input type=SUBMIT value="查詢" class="primary-btn primary radius" id="searchbut"><br>

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
					<input placeholder="開始日查詢" class="textbox-n" type="text"
						onfocus="(this.type='date')" id="startdate" name="startdate">
					<input placeholder="結束日查詢" class="textbox-n" type="text"
						onfocus="(this.type='date')" id="enddate" name="enddate">
				
				</form>
			</div>
						</div>											
					</div>
				</div>					
			</section>
			<!-- End banner Area -->	

			<!-- Start service Area -->
			<section class="service-area pt-100" id="about">
				<div class="container">
					<div class="row">
						<div class="col-lg-4">
							<div class="single-service">
							  <span style="font-size: 50px; font-color:#1b9aaa "><i class="fas fa-palette"></i></span>
							  <h4>藝文活動</h4> 
							  <p>
							  	想搜尋藝文活動嗎？<br>
							  	我們彙整了各大藝文活動售票資訊<br>
							  	歡迎利用我們的售票服務！
							  </p>						 	
							  <div class="overlay" style="text-align:center">
							    <div class="text">
							    	<p>
							    	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;享受生活，就從這裡開始您得藝的一天！&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							    	搜尋藝文活動的全新選擇！
							    	</p>
							    	<a href="<c:url value='/index.html' />" class="text-uppercase primary-btn" style="text-align:center;pedding-left:20px">由此去</a>
							    </div>
							  </div>
							</div>							
						</div>
						<div class="col-lg-4">
							<div class="single-service">
							  <span style="font-size: 50px; font-color:#1b9aaa "><i class="fas fa-map-marked-alt"></i></span>
							  <h4>藝同去郊遊</h4>
							  <p>
							  	想找附近的藝文活動<br>
							  	卻怕迷路嗎？<br>
							  	得藝的一天和您一同去郊遊！
							  </p>						 	
							  <div class="overlay">
							    <div class="text">
							    	<p>
							    	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;享受生活，就從這裡開始您得藝的一天！&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							    	搜尋藝文活動的全新選擇！
							    	</p>
							    	<a href="<c:url value='/35/routePlanningEntry' />" class="text-uppercase primary-btn justify-content-center">由此去</a>
							    </div>
							  </div>
							</div>							
						</div>
						<div class="col-lg-4">
							<div class="single-service">
							  <span style="font-size: 50px"><i class="fas fa-store-alt"></i></i></span>
							  <h4>文創商店名錄</h4> 
							  <p>
							  	逛逛文創商店？<br>
							  	想在書堆中喝杯下午茶？<br>
							  	找我們就對了！
							  </p>						 	
							  <div class="overlay">
							    <div class="text">
							    	<p>
							    	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;享受生活，就從這裡開始您得藝的一天！&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							    	搜尋藝文活動的全新選擇！
							    	</p>
							    	<a href="<c:url value='/03/index/shop/index.ctrl' />" class="text-uppercase primary-btn">由此去</a>
							    </div>
							  </div>
							</div>							
						</div>												
					</div>
				</div>	
			</section>
			<!-- End service Area -->
			
			<!-- Start quote Area -->
			<section class="quote-area section-gap">
				<div class="container">				
					<div class="row">
						<div class="col-lg-6 quote-left">
							<h1>
								<span>藝術</span> 是精神和物質的奮鬥, <br>
								我們的 <span>藝術</span> 應當比現實站更高，<br>
								應當使人 <span>不脫離現實又高於現實</span>.
							</h1>
						</div>
						<div class="col-lg-6 quote-right">
							<p><br>
								經典是這樣一種著作——它不斷引生批判它的種種論說的雲朵，<br>而又不停地將其擺脫，它永遠不會完結它所要敘說的東西。<br>
								就和我們一樣。
							</p>
						</div>
					</div>
				</div>	
			</section>
			<!-- End quote Area -->
<!-- Vue 綁定起點的 div-->
			<!-- Start exibition Area -->

			<!-- End exibition Area -->			
		
			<!-- Start upcoming-event Area -->
			<section class="upcoming-event-area section-gap" id="events">
				<div class="container">
					<div class="row d-flex justify-content-center">
						<div class="menu-content pb-60 col-lg-10">
							<div class="title text-center">
								<h1 class="mb-10">近期熱門活動一覽</h1>
								<p>我們猜想您可能會想參加這些活動</p>
							</div>
						</div>
					</div>						
					<div class="row">
						<div class="col-lg-6 event-left">
							<div class="single-events">
								<img class="img-fluid" src="<c:url value='/frontstyle/img/act_1.jpg'/>" alt="">
								<a href="#"><h4>精選活動 #1</h4></a>
								<h6><span>21st February</span> at Central government museum</h6>
								<p>
									inappropriate behavior is often laughed off as “boys will be boys,” women face higher conduct standards especially.
								</p>
								<a href="#" class="primary-btn text-uppercase">瀏覽詳情</a>
							</div>
							<div class="single-events">
								<img class="img-fluid" src="<c:url value='/frontstyle/img/act_2.jpg'/>" alt="">
								<a href="#"><h4>精選活動 #2</h4></a>
								<h6><span>21st February</span> at Central government museum</h6>
								<p>
									inappropriate behavior is often laughed off as “boys will be boys,” women face higher conduct standards especially.
								</p>
								<a href="#" class="primary-btn text-uppercase">瀏覽詳情</a>
							</div>							
						</div>
						<div class="col-lg-6 event-right">
							<div class="single-events">
								<a href="#"><h4>精選活動 #3</h4></a>
								<h6><span>21st February</span> at Central government museum</h6>
								<p>
									inappropriate behavior is often laughed off as “boys will be boys,” women face higher conduct standards especially.
								</p>
								<a href="#" class="primary-btn text-uppercase">瀏覽詳情</a>
								<img class="img-fluid" src="<c:url value='/frontstyle/img/act_3.jpg'/>" alt="">
							</div>
							<div class="single-events">
								
								<a href="#"><h4>精選活動 #4</h4></a>
								<h6><span>21st February</span> at Central government museum</h6>
								<p>
									inappropriate behavior is often laughed off as “boys will be boys,” women face higher conduct standards especially.
								</p>
								<a href="#" class="primary-btn text-uppercase">瀏覽詳情</a>
								<img class="img-fluid" src="<c:url value='/frontstyle/img/act_4.jpg'/>" alt="">
							</div>							
						</div>
					</div>
				</div>	
			</section>
			<!-- End upcoming-event Area -->
			
			<!-- Start blog Area -->
			<section class="blog-area section-gap" id="blog">
				<div class="container">
					<div class="row d-flex justify-content-center">
						<div class="menu-content pb-70 col-lg-8">
							<div class="title text-center">
								<h1 class="mb-10">熱門藝術課程一覽</h1>
								<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore  et dolore magna aliqua.</p>
							</div>
						</div>
					</div>					
					<div class="row">
						<div class="col-lg-3 col-md-6 single-blog">
							<div class="thumb">
								<img class="img-fluid" src="<c:url value='/frontstyle/img/blog_5.jpg'/>" alt="">								
							</div>
							<p class="date">10 Jan 2018</p>
							<a href="#"><h4>藝術課程 #1</h4></a>
							<p>
								inappropriate behavior ipsum dolor sit amet, consectetur.
							</p>
							<div class="meta-bottom d-flex justify-content-between">
								<p><span class="lnr lnr-heart"></span> 15 Likes</p>
								<p><span class="lnr lnr-bubble"></span> 02 則回應</p>
							</div>									
						</div>
						<div class="col-lg-3 col-md-6 single-blog">
							<div class="thumb">
								<img class="img-fluid" src="<c:url value='/frontstyle/img/blog_2.jpg'/>" alt="">								
							</div>
							<p class="date">10 Jan 2018</p>
							<a href="#"><h4>藝術課程 #2</h4></a>
							<p>
								inappropriate behavior ipsum dolor sit amet, consectetur.
							</p>
							<div class="meta-bottom d-flex justify-content-between">
								<p><span class="lnr lnr-heart"></span> 15 Likes</p>
								<p><span class="lnr lnr-bubble"></span> 02 則回應</p>
							</div>									
						</div>
						<div class="col-lg-3 col-md-6 single-blog">
							<div class="thumb">
								<img class="img-fluid" src="<c:url value='/frontstyle/img/blog_3.jpg'/>" alt="">								
							</div>
							<p class="date">10 Jan 2018</p>
							<a href="#"><h4>藝術課程 #3</h4></a>
							<p>
								inappropriate behavior ipsum dolor sit amet, consectetur.
							</p>
							<div class="meta-bottom d-flex justify-content-between">
								<p><span class="lnr lnr-heart"></span> 15 Likes</p>
								<p><span class="lnr lnr-bubble"></span> 02 則回應</p>
							</div>									
						</div>
						<div class="col-lg-3 col-md-6 single-blog">
							<div class="thumb">
								<img class="img-fluid" src="<c:url value='/frontstyle/img/blog_4.jpg'/>" alt="">								
							</div>
							<p class="date">10 Jan 2018</p>
							<a href="#"><h4>藝術課程 #4</h4></a>
							<p>
								inappropriate behavior ipsum dolor sit amet, consectetur.
							</p>
							<div class="meta-bottom d-flex justify-content-between">
								<p><span class="lnr lnr-heart"></span> 15 Likes</p>
								<p><span class="lnr lnr-bubble"></span> 02 則回應</p>
							</div>									
						</div>							
					</div>
				</div>	
			</section>
			<!-- End blog Area -->
</div>
<!-- Vue 綁定結尾的 div-->
			<!-- Start gallery Area -->
			<section class="gallery-area section-gap" id="gallery">
				<div class="container">
					<div class="row d-flex justify-content-center">
						<div class="menu-content pb-70 col-lg-8">
							<div class="title text-center">
								<h1 class="mb-10 text-white">得藝畫廊</h1>
								<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore  et dolore magna aliqua.</p>
							</div>
						</div>
					</div>						
					<div id="grid-container" class="row">
						<a class="single-gallery" href="img/g1.jpg"><img class="grid-item" src="<c:url value='/frontstyle/img/g1.jpg'/>"></a>
						<a class="single-gallery" href="img/g2.jpg"><img class="grid-item" src="<c:url value='/frontstyle/img/g2.jpg'/>"></a>
						<a class="single-gallery" href="img/g3.jpg"><img class="grid-item" src="<c:url value='/frontstyle/img/g3.jpg'/>"></a>
						<a class="single-gallery" href="img/g4.jpg"><img class="grid-item" src="<c:url value='/frontstyle/img/g4.jpg'/>"></a>
						<a class="single-gallery" href="img/g5.jpg"><img class="grid-item" src="<c:url value='/frontstyle/img/g5.jpg'/>"></a>
						<a class="single-gallery" href="img/g6.jpg"><img class="grid-item" src="<c:url value='/frontstyle/img/g6.jpg'/>"></a>
						<a class="single-gallery" href="img/g7.jpg"><img class="grid-item" src="<c:url value='/frontstyle/img/g7.jpg'/>"></a>
						<a class="single-gallery" href="img/g8.jpg"><img class="grid-item" src="<c:url value='/frontstyle/img/g8.jpg'/>"></a>
						<a class="single-gallery" href="img/g9.jpg"><img class="grid-item" src="<c:url value='/frontstyle/img/g9.jpg'/>"></a>
						<a class="single-gallery" href="img/g10.jpg"><img class="grid-item" src="<c:url value='/frontstyle/img/g10.jpg'/>"></a>
						<a class="single-gallery" href="img/g11.jpg"><img class="grid-item" src="<c:url value='/frontstyle/img/g11.jpg'/>"></a>
						<a class="single-gallery" href="img/g12.jpg"><img class="grid-item" src="<c:url value='/frontstyle/img/g12.jpg'/>"></a>
						<a class="single-gallery" href="img/g4.jpg"><img class="grid-item" src="<c:url value='/frontstyle/img/g4.jpg'/>"></a>
						<a class="single-gallery" href="img/g5.jpg"><img class="grid-item" src="<c:url value='/frontstyle/img/g5.jpg'/>"></a>						
					</div>	
				</div>	
			</section>
			<!-- End gallery Area -->

			<!-- JS 起點 -->

			



</body>
</html>