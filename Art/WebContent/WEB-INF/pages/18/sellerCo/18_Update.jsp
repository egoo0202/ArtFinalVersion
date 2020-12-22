<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="container">
<form action="<c:url value="/18/cUpdate.ctrl"/>" method="POST" enctype="multipart/form-data">
<table style="font-size: 22px">
<tbody>
<tr><td style="padding-top:20px; color:black">課程編號：<input type="text" class="form-control"
				name="coId" value="${co.coId}"></td></tr>
<tr><td style="padding-top:20px; color:black">課程名稱：<input type="text" class="form-control"
				name="coTitle" value="${co.coTitle}"></td></tr>
<tr><td style="padding-top:20px; color:black">課程類型：
<select name="coAct_Type" id="coAct_Type">
					<option value="" disabled>請選擇課程類型</option>
					<option value="語文">語文</option>
					<option value="園藝">園藝</option>
					<option value="風俗信仰">風俗信仰</option>
					<option value="手工製作">手工製作</option>
					<option value="國畫書法">國畫書法</option>
					<option value="運動">運動</option>
					<option value="藝術鑑賞">藝術鑑賞</option>
					<option value="美術">美術</option>
					<option value="戲劇">戲劇</option>
				</select></td></tr>
<tr><td style="padding-top:20px; color:black">上課地址：<input type="text" class="form-control"
				name="coAct_Location" value="${co.coAct_Location}"></td></tr>
<tr><td style="padding-top:20px; color:black">場地名稱：<input type="text" class="form-control"
				name="coLocation_Name" value="${co.coLocation_Name}"></td></tr>
<tr><td style="padding-top:20px; color:black">名額：<input type="number" class="form-control"
				name="coNum" value="${co.coNum}"></td></tr>
<tr><td style="padding-top:20px; color:black">售價：<input type="number" class="form-control"
				name="coPrice" value="${co.coPrice}"></td></tr>
<tr><td style="padding-top:20px; color:black">開始日期：<input type="date" class="form-control"
				name="coAct_Date" value="${co.coAct_Date}"></td></tr>
<tr><td style="padding-top:20px; color:black">開始時間：<input type="time" class="form-control"
				name="coAct_Time" value="${co.coAct_Time}"></td></tr>
<tr><td style="padding-top:20px; color:black">結束日期：<input type="date" class="form-control"
				name="coEnd_Date" value="${co.coEnd_Date}"></td></tr>
<tr><td style="padding-top:20px; color:black">結束時間：<input type="time" class="form-control"
				name="coEnd_Time" value="${co.coEnd_Time}"></td></tr>
<tr><td style="padding-top:20px; color:black">簡介說明：</td></tr>
<tr><td><textarea id="te" name="coAct_Description" rows="5" cols="100">${co.coAct_Description}</textarea></td></tr>
<tr><td style="padding-top:20px; color:black">點擊次數：<input type="number" class="form-control"
				name="coHot" value="${co.coHot}"></td></tr>
<tr><td style="padding-top:20px; color:black">圖片上傳：<input type="file" accept="image/*"
				onchange="loadFile(event)" class="form-control" name="coAct_Image"></td></tr>
<tr><td style="padding-top:20px;padding-bottom:20px; color:black">圖片預覽：
<img id="output" style='display: block; width: 640px; height: 360px;'src="data:image/jpg;base64, ${co.coAct_ImageStr}"></td></tr>
</tbody>
</table>	

<!-- 		<div class="form-group"> -->
<!-- 			<label>圖片上傳</label> <input type="file" accept="image/*" -->
<!-- 				onchange="loadFile(event)" class="form-control" name="coAct_Image"> -->
<!-- 		</div> -->
		
<!-- 		<div> -->
<!-- 		    <label>圖片預覽</label> -->
<%-- 		    <img id="output" style='display: block; width: 640px; height: 360px;'src="data:image/jpg;base64, ${co.coAct_ImageStr}"> --%>
<!-- 		</div> -->
	

	<button type="submit" class="btn btn-primary">送出</button>
</form>
	<div style="padding-top:20px"><a href="<c:url value='/18/cSelectAll.ctrl' />"><button class='btn btn-info'>放棄修改，回課程總覽</button></a></div>
</div>	

<input type="hidden" id="type" value="${type}"/>

<script>
				var loadFile = function(event) {
					var output = document.getElementById('output');
					output.src = URL.createObjectURL(event.target.files[0]);
					output.onload = function() {
						URL.revokeObjectURL(output.src)
					}
				};

				
				var index = $('#type').val();
				console.log("index"+index);
				$("#coAct_Type")[0].selectedIndex = index; 
</script>