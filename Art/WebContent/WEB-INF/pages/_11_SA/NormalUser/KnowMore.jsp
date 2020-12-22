<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<style>
	body{
		background:"./pic/bkc.png";
	}
	.bor{
		background-color: white;
		width: 550px;
		height: 730px;
		border: rgb(11, 73, 134) dashed 2px;
		border-radius: 50px;
		background-color: white;
		margin: 50px auto; 
	}
	.aaa{
		width: 300px;
		height: 220px;
		padding: 0px;
		margin: auto;
	}
</style>
	<c:forEach var="userView" varStatus="stat" items="${dataForWeb}">
<!-- 黑底起點 -->
<section class="banner-area relative" id="home">	
	<div class="overlay overlay-bg"></div>
	<div class="container">
		<div class="row d-flex align-items-center justify-content-center">
			<div class="about-content col-lg-12">
				<h1 class="text-white">
					${userView.name_SA }
				</h1>	
				<p class="text-white link-nav">
					<a href="index.html">Home </a>
					<span class="lnr lnr-arrow-right"></span>
					<a href='<c:url value="/userStreetArtistPage.ctrl"/>'> 總覽</a>
					<span class="lnr lnr-arrow-right"></span>
					${userView.name_SA }
				</p>
			</div>
		</div>
	</div>
</section>
<!-- 黑底終點 -->
<div>
	<article class="bor">
		<h2 align="center" style="color: red;">藝人資訊</h2>
		<div class="aaa">
        	<figure>
        		<!-- 再想想怎麼導入其他網站 -->
        		<a href="https://zh.wikipedia.org/wiki/%E9%AD%94%E8%A1%93">
            		<img src="data:image/jpg;base64, ${userView.pic2_SA}" alt="網路不穩" title="${mas}" width="300" height="auto" align="middle">
            	</a>
            	<!-- <figcaption>目前暫定可以寫字</figcaption> -->
        	</figure>
		</div>
		<table align="center"  style="border:3px #cccccc solid;margin: 20px" cellpadding="10" border='1'>
			<tr>
				<td style="border-right: ">藝名</td>
				<td>${userView.name_SA }</td>
			</tr>
			<tr>
				<td>來自</td>
				<td>${userView.country_SA }</td>
			</tr>
			<tr>
				<td>表演項目</td>
				<td>${userView.theme_SA }</td>
			</tr>
			<tr>
				<td>分類</td>
				<td>${userView.classification_SA }</td>
			</tr>
			<tr>
				<td>喜歡的話支持一下吧！</td>
				<td>
					<form action="ToDonate.ctrl">
						<input type="hidden" value="${userView.id_SA}"  name="id_SA"/>
						<input type="submit" class="genric-btn primary radius" name="submit" value="支持他" id="bbb"/>
					</form>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					魔術（英語：Magic Trick），是一門獨特的藝術表演形式，通過特殊的手法及道具等，使觀眾覺得不可思議。廣義的定義為泛指各種以專業技巧或知識展示出讓人覺得歡笑、不可思議的藝術的活動。魔術的技巧並不包含特異功能的成份。魔術亦可定義為「在滿足物質不滅定律及能量守恆定律的條件之下，呈現出違反經驗法則的表演」。	
				</td>
			</tr>
			<tr>
				<td colspan="2">
					留言板：
				</td>
			</tr>
		</table>
	</article>
</div>
	</c:forEach>