<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- start banner Area -->
<section class="banner-area relative" id="home">
	<div class="overlay overlay-bg"></div>
	<div class="container">
		<div class="row d-flex align-items-center justify-content-center">
			<div class="about-content col-lg-12">
				<h1 class="text-white">課程個別詳細介紹</h1>
				<p class="text-white link-nav">
					<a href="index.html">首頁</a> <span class="lnr lnr-arrow-right"></span>
					<a href="<c:url value='/18/cSelectAllFront.ctrl' />">課程總覽</a> <span
						class="lnr lnr-arrow-right"></span> 
					<span>${cfd.coTitle}</span>
				</p>
			</div>
		</div>
	</div>
</section>
<!-- End banner Area -->

<div class="container" style="font-size: 18px">
<div>
<form action="<c:url value="/18/CoSubmit.ctrl"/>">
	<div style="padding-top:25px">
		<img class="img-fluid" src="data:image/jpg;base64, ${cfd.coAct_ImageStr}">
		<div class="col-lg-4 sidebar" style="float:right; border-style:double">
							<div class="single-widget tags-widget"> <!-- style="border-style:double" 沒效果-->
								<h4 class="title" style="color:blue">課程分類快速尋找</h4>
								 <ul>
								 	<li style="font-size:medium;color:back"><a href="<c:url value='/18/searchByType.ctrl?searchType=語文' />">語文</a></li>
								 	<li style="font-size:large;color:back"><a href="<c:url value='/18/searchByType.ctrl?searchType=園藝' />">園藝</a></li>
								 	<li style="font-size:medium;color:back"><a href="<c:url value='/18/searchByType.ctrl?searchType=風俗信仰' />">風俗信仰</a></li>
								 	<li style="font-size:xx-large;color:back"><a href="<c:url value='/18/searchByType.ctrl?searchType=手工製作' />">手工製作</a></li>
								 	<li style="font-size:x-large;color:back"><a href="<c:url value='/18/searchByType.ctrl?searchType=國畫書法' />">國畫書法</a></li>
								 	<li style="font-size:large;color:back"><a href="<c:url value='/18/searchByType.ctrl?searchType=運動' />">運動</a></li>
								 	<li style="font-size:x-large;color:back"><a href="<c:url value='/18/searchByType.ctrl?searchType=藝術鑑賞' />">藝術鑑賞</a></li>
								 	<li style="font-size:xx-large;color:back"><a href="<c:url value='/18/searchByType.ctrl?searchType=美術' />">美術</a></li>
								 	<li style="font-size:medium;color:back"><a href="<c:url value='/18/searchByType.ctrl?searchType=戲劇' />">戲劇</a></li>
								 </ul>
							</div>	
						</div>
	</div>
	
<table>
<thead><tr><th style="padding-top:50px;"><font size="12px" color="SeaGreen"><b>NO.${cfd.coId}    ${cfd.coTitle}</b></font></th></tr></thead>
<tbody>
<tr><td style="padding-top:30px;"><font size="5px" color="black">類別：<a href="<c:url value='/18/searchByType.ctrl?searchType=${cfd.coAct_Type}' />">${cfd.coAct_Type}</a></font></td></tr>
<tr><td style="padding-top:60px;"><font size="5px" color="black">課程售價：${cfd.coPrice}</font></td></tr>
<tr><td style="padding-top:20px;"><font size="5px" color="black">剩餘名額：${cfd.coNum}</font></td></tr>
<tr><td style="padding-top:20px;"><font size="5px" color="black">請選擇數量<input type="number" min="1" max="${cfd.coNum}" name="orderNum" value="1"></font></td></tr>
<tr><td style="padding-top:60px;"><font size="5px" color="black">上課地點：${cfd.coAct_Location}  ${cfd.coLocation_Name}</font></td></tr>
<tr><td style="padding-top:20px;"><font size="5px" color="black">請選擇開課日期<select name="orderAct_Date">
                    <option disabled>開課日期</option>
					<option>${cfd.coAct_Date}</option>
					<option>${cfd.coEnd_Date}</option>
                    </select> </font></td></tr>
<tr><td style="padding-top:20px;"><font size="5px" color="black">開始時間：${cfd.coAct_Date} ${cfd.coAct_Time}</font></td></tr>
<tr><td style="padding-top:5px;"><font size="5px" color="black">結束時間：${cfd.coEnd_Date} ${cfd.coEnd_Time}</font></td></tr>
<tr><td style="padding-top:60px;"><font size="5px" color="black">課程簡介：<br>
${cfd.coAct_Description}</font></td></tr>
<tr><td style="padding-top:75px;"><font size="5px" color="black">查看次數：${cfd.coHot}</font></td></tr>
</tbody></table>

		<input type="hidden" name="coId" value="${cfd.coId}"/>
		<input type="hidden" name="orderTitle" value="${cfd.coTitle}"/>
		<input type="hidden" name="orderPrice" value="${cfd.coPrice}"/>
		<!--<input type="hidden" name="orderAct_Date" value="${cfd.coAct_Date}"/>-->
		<input type="hidden" name="orderAct_Time" value="${cfd.coAct_Time}"/>
		<!-- <input type="hidden" name="coAct_ImageStr" value="${cfd.coAct_ImageStr}"/>-->
		<div style="padding-top:40px; text-align:center"><button type="submit" name="coTitle"  class="genric-btn danger radius large" style="font-size:20px" value="${cfd.coTitle}">放入購物車</button></div>
</form>
<div style="padding-top:20px"><a href="<c:url value='/18/cSelectAllFront.ctrl' /> ">
	    <button class='btn btn-info radius'>返回課程總覽</button></a></div>
	    
</div>
</div>				
					