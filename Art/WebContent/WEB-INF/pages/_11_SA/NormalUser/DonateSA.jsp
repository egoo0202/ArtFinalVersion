<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<c:forEach var="userView" varStatus="stat" items="${streetArtist}">
<!-- 黑底起點 -->
<section class="banner-area relative" id="home">	
	<div class="overlay overlay-bg"></div>
	<div class="container">
		<div class="row d-flex align-items-center justify-content-center">
			<div class="about-content col-lg-12">
				<h1 class="text-white">
					Donate介面
				</h1>	
				<p class="text-white link-nav">
					<a href="index.html">Home </a>
					<span class="lnr lnr-arrow-right"></span>
					<a href='<c:url value="/userStreetArtistPage.ctrl"/>'> 總覽</a>
					<span class="lnr lnr-arrow-right"></span>
					為 ${userView.name_SA } 獻上新台幣
				</p>
			</div>											
		</div>
	</div>
</section>
<!-- 黑底終點 -->
<h1 style="filter: glow(color=#3366FF,strength=3); height:10px; color:black; padding:1px;text-align: center;">
	地方街頭藝人<u> ${userView.name_SA } </u>需要您的支持與鼓勵
</h1>
<form action="doDonate.ctrl" method="get">
<table style="border:3px rgb(85, 83, 218) dashed;margin-top: 40px;background-color: rgb(243,235,124);"cellpadding="10" border='1' class="display" align="center">
	<tr>
		<td style="font-size: 24px;">姓名：</td>
		<td style="font-size: 24px;">${userView.name_SA }</td>
	</tr>
		<tr>
			<td style="font-size: 24px;">斗內：</td>
			<td style="font-size: 24px;">
				<input type="hidden" value="${userView.id_SA }" name="id_SA">
				<input type="text" name="sal" placeholder="請輸入金額">元（新台幣）
			</td>
		</tr>
		<tr>
			<td colspan="2" align="center"><input type="submit" name="submit" value="確認並送出"></td>
		</tr>
</table>
</form>
</c:forEach>
<script>
$("#submit").click(function(){
	var don = parseInt($(".sal").text());
	if (don <= 0 ) {
		swal("金額錯誤","不可輸入小於0的數字","error");
        return false;
    }
}); 
</script>