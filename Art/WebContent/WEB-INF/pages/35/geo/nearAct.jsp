<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>最近活動搜尋結果</title>
<style>
body {
	font-size: 20px;
	color: black;
}
.title {
	text-align: center;
}

h1 {
	padding: 20px 25px;
}

#iframeDiv {
	display: none;
	margin: 0 auto;
}
#iframeDivInner {
	text-align: center;
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
					<h1 class="text-white">離我最近的活動</h1>
					<p class="text-white link-nav">
						<a href="index.html">Home </a> <span class="lnr lnr-arrow-right"></span>
						<a href="<c:url value='/35/randomRecom.ctrl' />">離我最近的活動</a>
					</p>
				</div>
			</div>
		</div>
	</section>
	<!-- End banner Area -->
	<br>
	<div class=title>
		<h1>鄰近${userLocation}的藝文活動</h1>
	</div>
	<br>
	<div id="iframeDiv">
		<div id="iframeDivInner">
			<iframe id="iframe" width="100%" height="350" frameborder="0" src=""></iframe>
			<!-- 			<input id="" type="button" onclick="navigate(this.id)" value="幫我導航"> -->
		</div>
	</div>
	<table id="35"
		class="display table table-bordered table-hover table-blue">
		<thead>
			<tr class="">
				<th class="table-primary">活動名稱</th>
				<th class="table-warning">活動地點離${userLocation}幾公里遠</th>
				<th class="table-success">活動時間</th>
				<th class="table-secondary">縣市</th>
				<th class="table-secondary">鄉鎮市區</th>
				<th class="table-info">里</th>
				<th class="table-info">地址</th>
				<th class="table-primary">周邊詳情</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="nearAct" items="${nearActList}">
				<tr>
					<td class="">${nearAct.title}</td>
					<td class="">${nearAct.distance}</td>
					<td class="">${nearAct.time}</td>
					<td class="">${nearAct.city}</td>
					<td class="">${nearAct.district}</td>
					<td class="">${nearAct.village}</td>
					<td class="">${nearAct.address}</td>
					<td class=""><input class="genric-btn primary radius"
						type="button"
						id="${nearAct.city.concat(nearAct.district).concat(nearAct.address)}"
						value="查看地圖" onclick="seeMap(this.id)"></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	</div>
	<script>
		$(document).ready(function() {
			$('#35').DataTable({
				"order": [[ 1, "asc" ]],
				scrollX: true,
				scrollY : 600,
				"language" : {
					"search" : "搜尋:",
					"lengthMenu" : "每頁展示 _MENU_ 個項目",
					"zeroRecords" : "抱歉，查無搜尋結果",
					"info" : "展示第 _PAGE_ 頁，總計 _PAGES_ 頁",
					"infoEmpty" : "沒有紀錄",
					"infoFiltered" : "(一共搜出 _MAX_ 筆活動資料)",
					"paginate" : {
						"first" : "第一頁",
						"last" : "最後一頁",
						"next" : "下一頁",
						"previous" : "前一頁"
					}
				}
			});
		});

		let seeMap = address => {
			
		    let nvImg = document.getElementById("navigateImg");
		    let nvButton = document.getElementById("navigateButton");
		    if (nvImg !=null) {
		    	nvImg.parentNode.removeChild(nvImg);
			}
		    if (nvButton !=null) {
		    	nvButton.parentNode.removeChild(nvButton);
			}
			
			let iframeDivInner = document.getElementById("iframeDivInner");
			let iframeDiv = document.getElementById("iframeDiv");
			let iframe = document.getElementById("iframe");
			iframeDiv.style.display="block";
			iframe.src="https://www.google.com/maps?q="+address+"&output=embed";

			let inputButton = document.createElement("input");
			inputButton.type = "button";
// 			console.log(address);
			inputButton.name = address;
			inputButton.id = "navigateButton";
			inputButton.value = "幫我導航";

			iframeDivInner.insertAdjacentElement("beforeend", inputButton);
			inputButton.className = "genric-btn primary radius";

		let navigateButton = document.getElementById("navigateButton");

//	 	宣告一個匿名的箭頭函式
//	 	若箭頭函式只有單一參數，參數的括號可省略，無參數要保留括號
		navigateButton.onclick = () => {
			let addr = navigateButton.name;
//	 		fetch()回傳的是promise物件，下面寫一個promise物件範例
//	 		let p = new Promise((resolve, reject) => {
//	 			let a = 2;
//	 			if(a==2){
//	 				傳入的resolve是函示名
//	 				resolve()
//	 			}else {
//	 				傳入的reject是函示名
//	 				reject()
//	 			}			
//	 		});
			fetch("<c:url value='/35/navigate/' />"+addr, {
				method: 'GET'}
//	 		then()框框內的參數response是上一步fetch()執行之回傳值
//	 		response帶入成為then()中箭頭函式之參數
//	 		橫槓內代表成功時之處理
//	 		----------------------------------------
			).then(response => {
//	 			因為fetch就算不是200也會回傳成功的結果，所以要加這步驟判斷
//	 			等同response==200
				if (response.ok){
//	 				response回傳的是stream物件，所以需要.text()/.json()/.blob()方法取資料
//	 				response.header可以取header內容
//	 				response.text()回傳的是promise物件，所以要再.then()一次處理成功時回傳的值
//	 				message帶入成為then()中箭頭函式之參數
					response.text().then(message => {	
//	 					message就是回傳後轉形成text的回應內容，這時候創元素變數名稱
						let navigateImg = document.createElement('img');
//	 					Button後方插入元素
						navigateButton.insertAdjacentElement("afterend", navigateImg);
//	 					插入圖片屬性
						navigateImg.src="data:image/png;base64, " + message;
						navigateImg.style.margin="0 auto";
						navigateImg.style.display = "block";
						navigateImg.style.width = "400px";
						navigateImg.style.height = "400px";	
						navigateImg.id = "navigateImg";	
//				 	第二層.then()沒回傳promise物件成功的結果時，會跳到此catch						
					}).catch();	
				}
//	 		第一層.then()沒回傳promise物件成功的結果時，會跳到此catch
			}).catch();
		
		}
		}
	</script>
</body>
</html>