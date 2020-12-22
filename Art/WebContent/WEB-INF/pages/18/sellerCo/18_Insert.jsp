<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:useBean   id="today"  class="java.util.Date" scope="session"/> 
<script src="https://code.jquery.com/jquery-3.5.1.js" integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc=" crossorigin="anonymous"></script>
<!-- https://code.jquery.com/       jQuery Core 3.5.1 - uncompressed -->

<div class="container">
<h2 style="text-align:center; color:blue; font-weight:bold">請輸入欲新增的課程資訊</h2>
<!-- id需與下方script相同 -->
   <div style="padding-top:20px"><button id="OneBuyer" class="btn btn-outline-success" >一鍵輸入課程資訊</button></div>	
<div><form action="<c:url value="/18/cInsert.ctrl"/>" method="POST"
	enctype="multipart/form-data">
<table>
<tbody>
<tr><td style="padding-top:20px;color:black">課程名稱：<input type="text" class="form-control"
				name="coTitle" id='coTitle' value=""></td></tr>
<tr><td style="padding-top:20px;color:black">課程類型：
<select name="coAct_Type" id='coAct_Type'>
					<option value="" selected disabled>請選擇課程類型</option>
					<option value="語文">語文</option>
					<option value="園藝">園藝</option>
					<option value="風俗信仰">風俗信仰</option>
					<option value="手工製作">手工製作</option>
					<option value="國畫書法">國畫書法</option>
					<option value="運動">運動</option>
					<option value="藝術鑑賞">藝術鑑賞</option>
					<option value="美術">美術</option>
					<option value="戲劇">戲劇</option></select>
<tr><td style="padding-top:20px;color:black">上課地址：<input type="text" class="form-control"
				name="coAct_Location" id='coAct_Location' value=""></td></tr>
<tr><td style="padding-top:20px;color:black">場地名稱：<input type="text" class="form-control"
				name="coLocation_Name" id='coLocation_Name' value=""></td></tr>
<tr><td style="padding-top:20px;color:black">名額：<input type="number" class="form-control"
				name="coNum" id="coNum" value=""></td></tr>
<tr><td style="padding-top:20px;color:black">售價：<input type="number" class="form-control"
				name="coPrice" id='coPrice' value=""></td></tr>
<tr><td style="padding-top:20px;color:black">開始日期：<input type="date" class="form-control"
				name="coAct_Date" id='coAct_Date' value=""></td></tr>
<tr><td style="padding-top:20px;color:black">開始時間：<input type="time" class="form-control"
				name="coAct_Time" id='coAct_Time' value=""></td></tr>
<tr><td style="padding-top:20px;color:black">結束日期：<input type="date" class="form-control"
				name="coEnd_Date" id='coEnd_Date' value=""></td></tr>
<tr><td style="padding-top:20px;color:black">結束時間：<input type="time" class="form-control"
				name="coEnd_Time" id='coEnd_Time' value=""></td></tr>
<tr><td style="padding-top:20px;color:black">簡介說明：<br><textarea name="coAct_Description" id="coAct_Description" rows="4" cols="50"></textarea></td></tr>
<!-- <tr><td style="padding-top:20px;">點擊次數(預設為0)：<input type="number" class="form-control" -->
<!-- 				name="coHot" id="coHot" value="0" disabled></td></tr> -->
<tr><td style="padding-top:20px;padding-bottom:20px;color:black">課程圖片(預覽)：<input type="file" accept="image/*"
				onchange="loadFile(event)" class="form-control" name="coAct_Image">
			<img id="coAct_ImageIs" style="width : 720px; height: 480px;"/></td></tr>
</tbody>
</table>		
	<button type="submit" class="btn btn-primary">送出</button>
</form></div>

</div>

<script>
<!-- $("最上方的id:識別名稱") -->
$("#OneBuyer").click(function(){
	$("#coTitle").val("國畫L2-彩墨山水(中級)");
	$("#coAct_Type").val("國畫書法");
	$("#coAct_Location").val("臺北市中正區中山南路21號");
	$("#coLocation_Name").val("國立中正紀念堂 W314教室");
	$("#coNum").val("50");
	$("#coPrice").val("2400");
	$("#coAct_Date").val("2021-01-21");
	$("#coAct_Time").val("09:00");
	$("#coEnd_Date").val("2021-06-01");
	$("#coEnd_Time").val("12:00");
	$("#coAct_Description").val("山石變化多端，取勢聚合，穿插、用筆、用墨皆表現不同之精神與趣味。山石靜態，因有浮雲流水方顯生命，雲水型態因自然條件不同各有所異，勾、染、留白…各種技法交互運用。");
// 	$("#coHot").val("0");
})


var loadFile = function(event) {
					var coAct_ImageIs = document.getElementById('coAct_ImageIs');
					coAct_ImageIs.src = URL.createObjectURL(event.target.files[0]);
					coAct_ImageIs.onload = function() {
						URL.revokeObjectURL(coAct_ImageIs.src)
					}
				};
</script>