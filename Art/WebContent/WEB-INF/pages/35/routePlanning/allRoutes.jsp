<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
<title>藝文路線規劃</title>
<!-- leaflet.js -->
<link rel="stylesheet"
	href="https://unpkg.com/leaflet@1.7.1/dist/leaflet.css"
	integrity="sha512-xodZBNTC5n17Xt2atTPuE1HxjVMSvLVW9ocqUKLsCC5CXdbqCmblAshOMAS6/keqq/sMZMZ19scR4PsZChSR7A=="
	crossorigin="" />
<script src="https://unpkg.com/leaflet@1.7.1/dist/leaflet.js"
	integrity="sha512-XQoYMqMTK8LvdxXYG3nZ448hOEQiglfqkJs1NOQV44cWnUrBc8PkAOcXy20w0vlaXaVUearIOBhiXZ5V3ynxwA=="
	crossorigin=""></script>
<!-- leaflet.js draw -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/leaflet.draw/0.4.2/leaflet.draw.css" />
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/leaflet.draw/0.4.2/leaflet.draw.js"></script>
<!-- lealet.js MarkerCluster 暫時用不到 -->
<!-- <link -->
<!-- 	href="https://unpkg.com/leaflet.markercluster@1.4.1/dist/MarkerCluster.css"></link> -->
<!-- <link rel="stylesheet" -->
<!-- 	href="https://unpkg.com/leaflet.markercluster@1.4.1/dist/MarkerCluster.Default.css" /> -->
<!-- <script -->
<!-- 	src="https://unpkg.com/leaflet.markercluster@1.4.1/dist/leaflet.markercluster.js"></script> -->
<!-- leaflet.js routing machine -->
<link rel="stylesheet"
	href="https://unpkg.com/leaflet-routing-machine@3.2.12/dist/leaflet-routing-machine.css" />
<script
	src="https://unpkg.com/leaflet-routing-machine@3.2.12/dist/leaflet-routing-machine.js"></script>
<!-- geocoder -->
<link rel="stylesheet"
	href="https://unpkg.com/leaflet-control-geocoder/dist/Control.Geocoder.css" />
<script
	src="https://unpkg.com/leaflet-control-geocoder/dist/Control.Geocoder.js"></script>
<!-- graphhopper -->
<script
	src="http://www.liedman.net/lrm-graphhopper/dist/lrm-graphhopper-1.2.0.min.js"></script>
<!-- fontawesome 暫時用不到-->
<!-- <script src="https://kit.fontawesome.com/0f0e9f356e.js" -->
<!-- 	crossorigin="anonymous"></script> -->
<style>
body {
	font-size: 23px;
	color: black;
}

html, body {
	height: 100%;
	padding: 0;
	margin: 0;
}

/* 高度要設定固定高否則無法顯示地圖 */
#artMap {
	height: 610px;
	width: 100%;
}

#header {
	z-index: 9999;
}

.askLocation {
	width: 100%;
	margin: 0 auto;
}

.sendRoute {
	width: 800px;
	margin: 0 auto;
}

.selectCategory {
	width: 100px;
	margin: 0 auto;
}

#actRating {
	width: 40px;
}

.askLocationInner, .sendRouteInner {
	/* 下列有水平置中效果 */
	text-align: center;
}

.marker-pin {
	text-align: center;
}

.marker-pin h6 {
	color: navy;
	font-family: SimSun;
	/* 	-webkit-text-stroke: 0.3px white; */
}

.askLocation {
	display: inline;
	float: right;
	width: 45%;
	margin-top: 50px;
}

.mapArea {
	display: inline;
	float: left;
	width: 55%;
}

.myJourney {
	display: none;
}

#myJourneyResult {
	color: red;
	font-weight: 900;
	display: none;
}

.showPins {
	margin: 40px 0;
}

.searchBox1 {
	padding-bottom: 10px;
}

.searchBox1 h1, .searchBox2l h3, .searchBox2r h3 {
	padding-bottom: 5px;
}

.searchBox2l {
	float: left;
	width: 50%;
	height: 90px;
}

.searchBox2r {
	float: right;
	width: 50%;
	height: 90px;
}

.oneKey {
	clear: both;
	padding-bottom: 20px;
	font-size: 16px;
}

#oneKey2 {
	font-size: 16px;
}

/* 圖資的對比與亮度 */
.leaflet-tile-pane {
	/* 	filter: grayscale(0.1) contrast(1) brightness(1);  */
	filter: contrast(1) brightness(1);
}

.tableDiv {
	overflow: scroll;
	max-height: 332px;
	padding: 15px 0;
}

#myJourneyTable, #pinsTbody tr {
	/*  	table-layout: fixed;  */
	word-break: keep-all;
	border: 1px solid #778FA8;
}

#pinsTbody tr:hover {
	background: #D3D3D3;
}

#myJourneyTable thead {
	background: #778FA8;
	color: white;
}

#naviButton {
	margin-bottom: 15px;
}

#a1UpperDiv, #a2UpperDiv {
	border-radius: 5px;
	background: #D1E9E9;
	padding: 10px 0;
	margin: 40px 150px;
	font-size: 32px;
	font-weignt: 300;
	box-shadow: 1px 1px 2px 2px;
}

#a1UpperDiv:hover, #a2UpperDiv:hover {
	background: #5CADAD;
}

.newImg {
	margin-top: 70px;
}

.newImg img {
	border-radius: 5px;
	width: 85%;
	opacity: 0.6;
}

#a1, #a2 {
	font-weight: 800;
}

#actName, #actTime, #actNotes {
	width: 400px;
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
					<h1 class="text-white">藝文路線規劃</h1>
					<p class="text-white link-nav">
						<a href="index.html">Home </a> <span class="lnr lnr-arrow-right"></span>
						<a href="<c:url value='/35/routePlanningEntry' />">藝文路線規劃</a>
					</p>
				</div>
			</div>
		</div>
	</section>
	<!-- End banner Area -->
<!-- 詢問使用者位置 -->
	<div class="askLocation">
		<div class="askLocationInner">
			<div id="a1UpperDiv">
				<a id="a1" onClick="div_none(this.id);" class="title">地圖搜尋藝文活動</a>
			</div>
			<div style="display: none;" class="a1">
				<div class="searchBox1">
					<h2>想尋找哪個地方的活動</h2>
					<input type="text" id="userLocation">
				</div>
				<div class="searchBox2">
					<div class="searchBox2l">
						<h3>顯示幾公里內的活動</h3>
						<input type="text" id="userDistance" size="6">
					</div>
					<div class="searchBox2r">
						<h3>偏好的藝文活動類型</h3>
						<select id="actCategory" class="selectCategory">
							<option>請選擇</option>
							<option>所有</option>
							<option>音樂</option>
							<option>戲劇</option>
							<option>舞蹈</option>
							<option>親子</option>
							<!-- 					<option>獨立音樂</option> -->
							<option>展覽</option>
							<option>講座</option>
							<option>電影</option>
							<option>綜藝</option>
							<option>競賽</option>
							<option>徵選</option>
							<option>其他</option>
							<option>未知分類</option>
							<!-- 					<option>演唱會</option> -->
							<option>研習課程</option>
						</select>
					</div>
				</div>
				<div class="oneKey">
					<button class="genric-btn info radius" id="oneKey" type="button">一鍵輸入</button>
				</div>
				<div class="editPinArea">
					<input id="editPinButton" class="genric-btn primary radius"
						type="button" value="標記我想去的地方">
					<div class="myJourney">
						<div>
							<label>活動名稱</label> <input id="actName" type="text">
						</div>
						<div>
							<label>活動時間</label> <input id="actTime" type="text">
						</div>
						<div>
							<label>備註事項</label>
							<textarea id="actNotes"></textarea>
						</div>
						<div>
							<label>感興趣程度</label> <select id="actRating"
								style="display: inline;">
								<option>5</option>
								<option>4</option>
								<option>3</option>
								<option>2</option>
								<option>1</option>
							</select>
							<button class="genric-btn info radius" id="oneKey2" type="button">一鍵輸入</button>
							<input id="savePinButton" class="genric-btn primary radius"
								type="button" value="儲存">
						</div>
					</div>
					<div>
						<p id="myJourneyResult"></p>
					</div>
				</div>
			</div>
			<div id="a2UpperDiv">
				<a id="a2" onClick=redirectMyJourney() class="title">顯示我的旅程資訊</a>
			</div>
			<div style="display: none;" class="a2">
				<div>
					<button id="naviButton" class="genric-btn info radius"
						onclick=navigatMyJourney()>顯示導航路線</button>
				</div>
				<div class="tableDiv">
					<table id="myJourneyTable" class="display">
						<thead>
							<tr>
								<th>活動名稱</th>
								<th id="addToNaviTitle">加入導航</th>
								<th>活動時間</th>
								<th>備註事項</th>
								<th>感興趣程度</th>
								<th>修改</th>
								<th>刪除</th>
							</tr>
						</thead>
						<tbody id="pinsTbody">
						</tbody>
					</table>
				</div>
			</div>
			<!-- 			<div> -->
			<!-- 				<a id="a3" onClick="div_none(this.id);" class="title">標題</a> -->
			<!-- 			</div> -->
			<!-- 			<div style="display: none;" class="a3">內容</div> -->
			<div class="newImg"></div>
		</div>
	</div>

	<!-- 地圖以及資料顯示按鈕本體 -->
	<div class="container my-5 mapArea">
		<div id="artMap"></div>
	</div>
	<div style="clear: both;"></div>

	<script type="text/javascript">

	let redirectMyJourney = () => {
		window.location.href="<c:url value='/35/myJourneyEntry' />";
	}

// 	$(document).ready( function () {
// 	    $('#myJourneyTable').DataTable({
// 	    	"ordering": false,
// 	        scrollY:     300,
// 	        scroller:    true
// 		});
// 	} );

// 	點擊顯示隱藏div
	function div_none(theclass){
		let allPageTags = new Array();
		allPageTags = document.getElementsByTagName("div");
		for (i=0; i<allPageTags.length;i++){
			if(allPageTags[i].className == theclass){
				let obj = allPageTags[i];
				if(obj.style.display == "none"){
					obj.style.display = "";
				}else{
					obj.style.display = "none";
				}
			}
		}
	}

// 	隨機顯示一鍵輸入內容
// 	function getRandomInt(max) {
// 		return Math.floor(Math.random() * Math.floor(max));
// 	}
	
	let oneKey = document.getElementById("oneKey");
	let counterForKey = 0;
	oneKey.addEventListener("click", () => {
		counterForKey++;
		if (counterForKey % 5 == 1){
			document.getElementById("userLocation").value="台北車站";
			document.getElementById("userDistance").value="2";
		}else if(counterForKey % 5 == 2){
			document.getElementById("userLocation").value="資策會";
			document.getElementById("userDistance").value="13";
			document.getElementById("actCategory").value="請選擇";
		}else if(counterForKey % 5 == 3){
			document.getElementById("userLocation").value="成功大學";
			document.getElementById("userDistance").value="3";
			document.getElementById("actCategory").value="請選擇";	
		}else if(counterForKey % 5 == 4){
			document.getElementById("userLocation").value="高雄車站";
			document.getElementById("userDistance").value="9";
			document.getElementById("actCategory").value="請選擇";
		}else if(counterForKey % 5 == 0){
			document.getElementById("userLocation").value="宜蘭";
			document.getElementById("userDistance").value="25";
			document.getElementById("actCategory").value="請選擇";
		}else {
			document.getElementById("userLocation").value="花蓮";
			document.getElementById("userDistance").value="35";
			document.getElementById("actCategory").value="請選擇";
		}
	});

	let oneKey2 = document.getElementById("oneKey2");
	let counterForKey2 = 0;
	oneKey2.addEventListener("click", () => {
		counterForKey2++;
		if(counterForKey2 % 9 == 1){
			document.getElementById("actName").value="七週年小驚喜";
			document.getElementById("actTime").value="2020/12/26";
			document.getElementById("actNotes").value="久違的與女友約會，這個活動種類看起來她會喜歡，到時候要記得搶票";
		}else if(counterForKey2 % 9 == 2) {
			document.getElementById("actName").value="新北塞車城";
			document.getElementById("actTime").value="2020/12/19";
			document.getElementById("actNotes").value="新北塞車城，有喜歡的歌手會來，必去！";
		}else if(counterForKey2 % 9 == 3) {
			document.getElementById("actName").value="慶祝生日活動的好地方";
			document.getElementById("actTime").value="2021/02/02";
			document.getElementById("actNotes").value="這邊附近友好餐廳，有喜歡的歌手會駐唱，必去！";
		}else if(counterForKey2 % 9 == 4) {
			document.getElementById("actName").value="這是一個很酷的活動";
			document.getElementById("actTime").value="2020/12/28";
			document.getElementById("actNotes").value="這邊有好多酷東西，對不起了錢錢，但是我真的需要這個酷東西！";
		}else if(counterForKey2 % 9 == 5) {
			document.getElementById("actName").value="超好看的藝術展";
			document.getElementById("actTime").value="2021/01/15";
			document.getElementById("actNotes").value="有超稀有的藝術品，和文創市集，帶女友去挖寶！";
		}else if(counterForKey2 % 9 == 6) {
			document.getElementById("actName").value="硬地搖滾音樂";
			document.getElementById("actTime").value="2021/01/31";
			document.getElementById("actNotes").value="聚集了好多我喜歡的獨立樂團，啊啊啊啊嘶！";
		}else if(counterForKey2 % 9 == 7) {
			document.getElementById("actName").value="母校校慶";
			document.getElementById("actTime").value="2021/03/18";
			document.getElementById("actNotes").value="好久沒回去母校晃晃了，找女友一起去！";
		}else if(counterForKey2 % 9 == 8) {
			document.getElementById("actName").value="台北電影節開幕影片";
			document.getElementById("actTime").value="2021/02/05";
			document.getElementById("actNotes").value="有很多新進的優質國片，其中不乏令人刮目相看的新銳導演的作品！";
		}else if(counterForKey2 % 9 == 0) {
			document.getElementById("actName").value="福隆抓海膽";
			document.getElementById("actTime").value="2021/07/02";
			document.getElementById("actNotes").value="夏天到了，該去和朋友消暑一夏！";
		}else {
			document.getElementById("actName").value="鐵道部歷史展覽";
			document.getElementById("actTime").value="2020/12/30";
			document.getElementById("actNotes").value="鐵道部終於整修完成了，就在台北車站旁邊而已！";
		}
	});
	
// 	初始化地圖參數，這個動作只要做一遍
    let leafletMap = L.map(document.getElementById('artMap'), {
        center: [23.773, 120.959], // 中心點
        zoom: 8, // 縮放層級
        zoomSnap: 0.5, //縮放的細膩程度
        crs: L.CRS.EPSG3857, // 座標系統
        downloadable: true,
        attributionControl: false,
    });
// 	定義不同類型的圖層
    let osm = L.tileLayer(
            'https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png',
            {
                attribution: '&copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors'
            })

// 	預設顯示圖層
    osm.addTo(leafletMap);
    
    let mapbox = L.tileLayer('https://api.tiles.mapbox.com/v4/{id}/{z}/{x}/{y}.png?access_token=pk.eyJ1IjoibWFwYm94IiwiYSI6ImNpejY4NXVycTA2emYycXBndHRqcmZ3N3gifQ.rJcFIG214AriISLbB6B5aw', {
                    maxZoom: 18,
                    id: 'mapbox.streets'
                });

    let googleStreets = L.tileLayer('http://{s}.google.com/vt/lyrs=m&x={x}&y={y}&z={z}',{
        maxZoom: 20,
        subdomains:['mt0','mt1','mt2','mt3']
    });

    let googleHybrid = L.tileLayer('http://{s}.google.com/vt/lyrs=s,h&x={x}&y={y}&z={z}',{
        maxZoom: 20,
        subdomains:['mt0','mt1','mt2','mt3']
    });

    let googleSat = L.tileLayer('http://{s}.google.com/vt/lyrs=s&x={x}&y={y}&z={z}',{
        maxZoom: 20,
        subdomains:['mt0','mt1','mt2','mt3']
    });

    let googleTerrain = L.tileLayer('http://{s}.google.com/vt/lyrs=p&x={x}&y={y}&z={z}',{
        maxZoom: 20,
        subdomains:['mt0','mt1','mt2','mt3']
    });

//     定義兩個 dictionary
    let baseLayers = {
    	'OpenStreetMap': osm,
    	'Mapbox' : mapbox,
    	'Google 街道': googleStreets,
    	'Google 混合': googleHybrid,
    	'Google 衛星': googleSat,
    	'Google 地形': googleTerrain
    };

    let overlays = {

    };

	//接著把圖層控制的功能（L.control.layers）加入地圖中：   
	L.control.layers(baseLayers, overlays, {collapsed: true, position: 'topleft'}).addTo(leafletMap);
	
	//加入比例尺
    L.control.scale({
        position: 'bottomleft'
    }).addTo(leafletMap);
    
    //設定圖釘樣式
	//紅色圖釘
    let redIcon = new L.Icon(
        {
            iconUrl: 'https://raw.githubusercontent.com/pointhi/leaflet-color-markers/master/img/marker-icon-red.png',
            shadowUrl: 'https://cdnjs.cloudflare.com/ajax/libs/leaflet/0.7.7/images/marker-shadow.png',
            iconSize: [25, 41],
            iconAnchor: [12, 41],
            popupAnchor: [1, -34],
            shadowSize: [41, 41]
        });
    
    //藍色圖釘
    let blueIcon = new L.Icon(
        {
            iconUrl: 'https://raw.githubusercontent.com/pointhi/leaflet-color-markers/master/img/marker-icon-blue.png',
//             shadowUrl: 'https://cdnjs.cloudflare.com/ajax/libs/leaflet/0.7.7/images/marker-shadow.png',
            iconSize: [25, 41],
            iconAnchor: [12, 41],
            popupAnchor: [1, -34],
//             shadowSize: [41, 41]
        });

// 	綠色圖釘
    let greenIcon = new L.Icon({
    	  iconUrl: 'https://raw.githubusercontent.com/pointhi/leaflet-color-markers/master/img/marker-icon-green.png',
    	  shadowUrl: 'https://cdnjs.cloudflare.com/ajax/libs/leaflet/0.7.7/images/marker-shadow.png',
    	  iconSize: [25, 41],
    	  iconAnchor: [12, 41],
    	  popupAnchor: [1, -34],
    	  shadowSize: [41, 41]
    });
    
// 	金色圖釘
    let goldIcon = new L.Icon({
    	  iconUrl: 'https://raw.githubusercontent.com/pointhi/leaflet-color-markers/master/img/marker-icon-gold.png',
    	  shadowUrl: 'https://cdnjs.cloudflare.com/ajax/libs/leaflet/0.7.7/images/marker-shadow.png',
    	  iconSize: [25, 41],
    	  iconAnchor: [12, 41],
    	  popupAnchor: [1, -34],
    	  shadowSize: [41, 41]
    });
    
// 	黃色圖釘
    let yellowIcon = new L.Icon({
    	  iconUrl: 'https://raw.githubusercontent.com/pointhi/leaflet-color-markers/master/img/marker-icon-yellow.png',
    	  shadowUrl: 'https://cdnjs.cloudflare.com/ajax/libs/leaflet/0.7.7/images/marker-shadow.png',
    	  iconSize: [25, 41],
    	  iconAnchor: [12, 41],
    	  popupAnchor: [1, -34],
    	  shadowSize: [41, 41]
    });
    
// 	橘色圖釘
    let orangeIcon = new L.Icon({
    	  iconUrl: 'https://raw.githubusercontent.com/pointhi/leaflet-color-markers/master/img/marker-icon-orange.png',
    	  shadowUrl: 'https://cdnjs.cloudflare.com/ajax/libs/leaflet/0.7.7/images/marker-shadow.png',
    	  iconSize: [25, 41],
    	  iconAnchor: [12, 41],
    	  popupAnchor: [1, -34],
    	  shadowSize: [41, 41]
    });
    
// 	灰色圖釘
    let greyIcon = new L.Icon({
    	  iconUrl: 'https://raw.githubusercontent.com/pointhi/leaflet-color-markers/master/img/marker-icon-grey.png',
    	  shadowUrl: 'https://cdnjs.cloudflare.com/ajax/libs/leaflet/0.7.7/images/marker-shadow.png',
    	  iconSize: [25, 41],
    	  iconAnchor: [12, 41],
    	  popupAnchor: [1, -34],
    	  shadowSize: [41, 41]
    });

	let title = null;
    
    //定義好fetch會固定用到的方法
    let status = response => {
        if (response.status >= 200 && response.status < 300) {
            return Promise.resolve(response)
        } else {
            return Promise.reject(new Error(response.statusText))
        }
    }

    let json = response => {
        return response.json()
    }

//  定義後面map會用到的變數
	let userLat;
	let userLon;
	let nearActsArray;
// 	先設定markerGroup/markerRed，為了判斷是否有先前查詢遺留的圖層
	let markerGroup = null;
	let markerRed = null;
	let routing = null;
	
// 	定義觸發查詢後，所執行的ajax處理
	document.getElementById("actCategory").addEventListener("change", processLocation = () => {

// 		如果有先前查詢產生的圖層就移除
	    if (markerGroup !== null) {
	        leafletMap.removeLayer(markerGroup);
	    }

	    if (markerRed !== null) {
	    	leafletMap.removeLayer(markerRed);
		}

	    if (drawingLayer !== null) {
	    	leafletMap.removeLayer(drawingLayer);
		}

		if (routing !== null) {
			leafletMap.removeControl(routing);
		}
	    
		let actCategory = document.getElementById("actCategory").value;
		let userLocation = document.getElementById("userLocation").value;
		let userDistance = document.getElementById("userDistance").value;
        let url = "<c:url value='/35/routePlanning/"+userLocation+"/"+userDistance+"/"+actCategory+".ctrl' />";

        fetch(url, {
        	method: "get"
        })
        	.then(status)
        	.then(json)
        	.then(data => {
//             	data中有兩個key
//             	"userCoords" Map型態
//             	"nearActs" List型態
// 				console.log(data);

            	userLat = data.userCoords.lat;
            	userLon = data.userCoords.lon;
            	nearActsArray = data.nearActs;

//				設定地圖中心
            	leafletMap.setView([userLat, userLon], 15 - userDistance/10);
// 				繪製查詢中心點圖釘
		        markerRed = L.marker([data.userCoords.lat, data.userCoords.lon], {
		            icon: redIcon
		        })
		        .bindPopup("<b>"+userLocation+"</b>"+
				"<br>詳細資訊: "+"<a href=\"https://www.google.com/search?q="+userLocation+"\" target=\"_blank\">點擊查看</a>"+
				"<br>文化部查詢相關活動: "+"<a href=\"https://www.moc.gov.tw/searchall_5.html?q="+userLocation+"\" target=\"_blank\">點擊查看</a>")
		        .addTo(leafletMap);
// 		        Popup直接顯示出來
// 		        markerRed.openPopup();
            	
// 				為了避免活動們的空圖釘結果導致下一次搜尋出來的圖釘被刪
				if(data.nearActs[0].no === null){
					return;
				}
				
//             	繪製活動們的圖釘
				let markerArray=[];
// 				positionArray用於檢查活動位置是否重複
// 				重複就不要繪製圖釘上去
				let positionArray=[];
        		for (let i in data.nearActs) {

					let positionObj = {
						lat: data.nearActs[i].latitude,
						lon: data.nearActs[i].longitude
					};

// 					檢查array內obj的經緯度值是否皆相同
					objCheck = (obj) => {
						return (obj.lat === data.nearActs[i].latitude) && (obj.lon === data.nearActs[i].longitude);
					}

					if (positionArray.some(objCheck)){
						continue;
					}else {
						positionArray.push(positionObj);
						
	        			let actsIcon;
//	 					如果搜尋距離小於多少，改用帶標題圖標，且動態變更圖標題名稱
						if (userDistance < 10){
							actsIcon = new L.divIcon({
		        		    	className: 'custom-div-icon',
		        		            html: "<div class='marker-pin'><h6>"+data.nearActs[i].title.substring(0, 12)+"</h6><img src='https://raw.githubusercontent.com/pointhi/leaflet-color-markers/master/img/marker-icon-blue.png'></div>",
		        		            iconSize: [60, 84],
		        		            iconAnchor: [15, 42]
		        		    });
						}else {
							actsIcon = blueIcon;
						}

// 						轉換null值的函式
						let transformNull = (str) => {
							if (str === null){
								str="無資訊";
							}

							return str;
						}
						
						let actsMarker = L.marker([data.nearActs[i].latitude, data.nearActs[i].longitude], {
	    		            icon: actsIcon
	    		        })
	        			.bindPopup("<b>"+data.nearActs[i].title
	    	        			+"</b><br>地址: "+data.nearActs[i].city+data.nearActs[i].district+data.nearActs[i].address
								+"<br>活動地點: "+transformNull(data.nearActs[i].locationName)   	        			
								+"<br>主辦單位: "+transformNull(data.nearActs[i].mainUnit)	    	        			
								+"<br>展演單位: "+transformNull(data.nearActs[i].showUnit)   	        			
								+"<br>時間: "+data.nearActs[i].time
	                			+"<br>活動詳細資訊: "+"<a href=\"https://www.google.com/search?q="+data.nearActs[i].title+"\" target=\"_blank\">點擊查看</a>");

						markerArray.push(actsMarker);
					}

            	}
//         		
				markerGroup = L.layerGroup(markerArray).addTo(leafletMap);
			})	
	});

// 	啟用事件綁定方法二: 定義完方法後綁定事件
// 	document.getElementById("actCategory").addEventListener("change", processLocation);

	let loc = document.getElementById("userLocation");
	let dis = document.getElementById("userDistance");
	loc.addEventListener("change", processLocation);
	dis.addEventListener("change", processLocation);
	
	//從這之後是編輯圖釘資訊，定義後續取圖標位置的按鈕要用的變數
	
	//綁定點擊地圖事件後，要執行的動作
// 	leafletMap.on('click', onMapClick);	
// 	function onMapClick(e){
// 		L.popup()
// 		.setLatLng(e.latlng)
// 		.setContent("經緯度: " + e.latlng.toString())
// 		.openOn(leafletMap)
		
//         console.log("要用的資料之單純經緯度" + e.latlng.toString());
// 	}

    //設定drawItem圖層
    let drawItem = new L.FeatureGroup();
    leafletMap.addLayer(drawItem);

    //draw的控制選項
    let option = {
        draw: {
            polyline: false,
        	polygon: false,
        	rectangle: false,
        	circle: false
        },
        position: 'bottomright',
        collapsed: true,
        edit: {
            featureGroup: drawItem
        }
    };
    
	//新增drawControl
    let drawControl = new L.Control.Draw(option);
    leafletMap.addControl(drawControl);

    let counter = 0;
    let siteObj = null;
	//let data = new Map();
    leafletMap.on('draw:created', onMapDraw);
    let drawingLayer = null; //之後要裝載手動放上去圖釘的圖層
   	function onMapDraw(e) {
        counter++;
        drawingLayer = e.layer;
        drawItem.addLayer(drawingLayer);
		//Json
        let shape = drawingLayer.toGeoJSON();
		//轉字串
        let shape_for_db = JSON.stringify(shape);
        // 				console.log("1: "+arguments);
        // 				console.log("2: "+layer);
        // 				console.log("3: "+shape);
//         console.log("要用的資料: " + shape_for_db);
        siteObj = {
                lat: shape.geometry.coordinates[1],
                lon: shape.geometry.coordinates[0]
                }
//         data.set(counter, JSON.stringify(shape));
    }

// 	這邊開始是編輯我的圖釘行程
	let myJourney = document.querySelector(".myJourney");
	let editResult = document.getElementById("myJourneyResult");
	let edit = document.getElementById("editPinButton");
	let save = document.getElementById("savePinButton");

	let name = document.getElementById("actName");
	let time = document.getElementById("actTime");
	let notes = document.getElementById("actNotes");
	let rating = document.getElementById("actRating");

	let editSiteObj = () => {
		edit.style.display="none";
		editResult.style.display="none";
		myJourney.style.display="block";
		name.value="";
		time.value="";
		notes.value="";
		rating.value="5";

	}
	
	edit.addEventListener("click", editSiteObj);

// 	定義儲存圖釘資訊後要做的事
	let previousPin;
	let saveSiteObj = (e) => {
		edit.style.display="";
		myJourney.style.display="none";

// 		清除先前圖層
	    if (markerGroup !== null) {
	        leafletMap.removeLayer(markerGroup);
	    }

	    if (markerRed !== null) {
	    	leafletMap.removeLayer(markerRed);
		}
		
	    if (drawingLayer !== null) {
	    	leafletMap.removeLayer(drawingLayer);
		}
		
		if (routing !== null) {
			leafletMap.removeControl(routing);
		}

// 		移除drawingLayer的藍色圖釘，變成紅色圖釘
        drawItem.removeLayer(drawingLayer);

        let url = "<c:url value='/35/myJourney' />";
		previousPin ={
				"name": name.value,
				"time": time.value,
				"notes": notes.value,
				"rating": actRating.value,
				"lat": siteObj.lat,
				"lon": siteObj.lon
				}
        fetch(url, {
            method: "post",
            headers: {
                'Content-Type': 'application/json; charset=UTF-8'
            },
            body: JSON.stringify(previousPin)
        })
            .then(status)
            .then(json)
            .then(data => {
				editResult.style.display = "block";
				if (data.result=="successful"){
					editResult.innerText = "新增成功";
				}else {
					editResult.innerText = "新增失敗";
				}
            })

        let positionArray =[]
       	positionArray[0]=previousPin.lat;
       	positionArray[1]=previousPin.lon;
//		設定地圖中心
    	leafletMap.setView(positionArray, 15);
//		繪製查詢中心點圖釘
        markerRed = L.marker(positionArray, {
            icon: redIcon
        })
        .bindPopup("<b>"+previousPin.name+"</b>"+
		"<br>時間: "+previousPin.time+
        "<br>備註: "+previousPin.notes+
        "<br>感興趣程度: "+previousPin.rating+
		"<br>活動詳細資訊: "+"<a href=\"https://www.google.com/search?q="+previousPin.name+"\" target=\"_blank\">點擊查看</a>"+
		"<br>文化部查詢相關活動: "+"<a href=\"https://www.moc.gov.tw/searchall_5.html?q="+previousPin.name+"\" target=\"_blank\">點擊查看</a>")
        .addTo(leafletMap);

//	    Popup直接顯示出來
	    markerRed.openPopup();
	}
	
	save.addEventListener("click", saveSiteObj);

// 	開關編輯旅程區域時的判斷
// 	let showJourney = document.getElementById("a2");
// 	let clickCounter = 0;
// 	showJourney.addEventListener("click", getMyJourneyCheck = () => {
// 		clickCounter++;
// 		if (clickCounter % 2 == 1 ){
// 			getMyJourney();
// //			清空routingArray，避免殘存過去紀錄
// 			routingArray = [];
// 		}else {
// 			let pinsTbody = document.getElementById("pinsTbody");
//             while(pinsTbody.firstChild) { 
//             	pinsTbody.removeChild(pinsTbody.firstChild); 
//             } 
// // 			或者是document.getElementById("pinsTbody").innerHTML="";
// 		}
// 	});

// 	宣告導航點
	let routingArray = [];
// 	定義查詢我的圖釘資訊
    let getMyJourney = () => {
// 		如果有先前查詢產生的圖層就移除
	    if (markerGroup !== null) {
	        leafletMap.removeLayer(markerGroup);
	    }

	    if (markerRed !== null) {
	    	leafletMap.removeLayer(markerRed);
		}

	    if (drawingLayer !== null) {
	    	leafletMap.removeLayer(drawingLayer);
		}
		
		if (routing !== null) {
			leafletMap.removeControl(routing);
		}
        
    	let url = "<c:url value='/35/myJourney' />";

         fetch(url, {
             method: "get"
         })
             .then(status)
             .then(json)
             .then(data => {
 				
 				let markerArray =[];
 				for (let i in data) {
					//處理資料表部分
					let pinsTbody = document.getElementById("pinsTbody");
// 					插入一列
					let row = pinsTbody.insertRow(0);
					row.id="row"+data[i].id;
// 					一列插入六個cell(td)
					let cell0 = row.insertCell(0);
					let cell1 = row.insertCell(1);
					let cell2 = row.insertCell(2);
					let cell3 = row.insertCell(3);
					let cell4 = row.insertCell(4);
					let cell5 = row.insertCell(5);
					let cell6 = row.insertCell(6);
// 					設定每個cell(td)顯示的內容
					cell0.innerHTML = "<a>"+data[i].name+"</a>";
					let pinName = cell0.getElementsByTagName('a')[0]
					pinName.onclick = () => {
						leafletMap.flyTo([data[i].lat, data[i].lon], 12, {
// 				            animate: true,
				            duration: 2.5
				          });
					};
					cell1.innerHTML = "<button id=navi"+data[i].id+">導航</button>";
					let pinNavi = cell1.getElementsByTagName('button')[0];
					pinNavi.className="genric-btn primary radius";
					pinNavi.onclick = () => {
						pinNavi.className="genric-btn info radius";
						pinNavi.textContent="已新增";
						let naviLocation = {
								lat: data[i].lat,
								lon: data[i].lon
								}
						routingArray.push(naviLocation);
					}
					cell2.innerHTML = data[i].time;
					cell3.innerHTML = data[i].notes;
					cell4.innerHTML = data[i].rating;
					cell5.innerHTML = "<button id=update"+data[i].id+">修改</button>";
					cell5.getElementsByTagName('button')[0].className="genric-btn primary radius";
					cell5.getElementsByTagName('button')[0].onclick=pinUpdate;
					cell6.innerHTML = "<button id=delete"+data[i].id+">刪除</button>";
					cell6.getElementsByTagName('button')[0].className="genric-btn primary radius";
					cell6.getElementsByTagName('button')[0].onclick=pinDelete;

					//處理圖釘部分
					let myJourneyIcon;
					if (data[i].rating == 5) {
        	 			myJourneyIcon = greenIcon;
					}else if (data[i].rating == 4) {
						myJourneyIcon = goldIcon;
					}else if (data[i].rating == 3) {
						myJourneyIcon = yellowIcon;
					}else if (data[i].rating == 2) {
						myJourneyIcon = orangeIcon;
					}else {
						myJourneyIcon = greyIcon;
					}
					
					let myJourneyMarker = L.marker([data[i].lat, data[i].lon], {
			            icon: myJourneyIcon
			        })
	    			.bindPopup("<b>"+data[i].name
							+"</b><br>時間: "+data[i].time
							+"<br>備註: "+data[i].notes
							+"<br>感興趣程度: "+data[i].rating	        			
	            			+"<br>活動詳細資訊: "+"<a href=\"https://www.google.com/search?q="+data[i].name+"\" target=\"_blank\">點擊查看</a>"
	            			+"<br>文化部查詢相關活動: "+"<a href=\"https://www.moc.gov.tw/searchall_5.html?q="+data[i].name+"\" target=\"_blank\">點擊查看</a>");

					myJourneyMarker.openPopup();
					markerArray.push(myJourneyMarker);
 				}
				//加入圖釘群組
 				markerGroup = L.layerGroup(markerArray).addTo(leafletMap);
				//設定地圖中心
 		    	leafletMap.setView([23.773, 120.959], 8);
				
             });

    }

//  顯示導航路徑的方法
	let navigatMyJourney = () => {
		
		if (routing !== null) {
			leafletMap.removeControl(routing);
		}
		
	    //導航路徑加到地圖上
	    let latLngArray=[];
	    for (i in routingArray){
			let obj = L.latLng(routingArray[i].lat, routingArray[i].lon);
	    	latLngArray.push(obj);   
		}
		routing = L.Routing.control({
			waypoints : latLngArray,
			routeWhileDragging: true,
			geocoder: L.Control.Geocoder.nominatim(),
			router: L.Routing.graphHopper('f4d3349a-97ed-4ad7-b677-c00a4bdd230c', {
		    	urlParameters: 
			    	{
		            	vehicle: 'car',
		            	locale:'zh-TW'
		          	}
		      	})
		}).addTo(leafletMap);
		//設定地圖中心
	    leafletMap.setView([(routingArray[0].lat + routingArray[routingArray.length - 1].lat)/2, (routingArray[0].lon + routingArray[routingArray.length - 1].lon)/2], 10);

	}

	let pinDelete = (e) => {
		swal({ 
			title: "確認刪除？", 
			text: "刪除圖釘後，資訊無法恢復",
		    buttons: {
		        confirm : "刪除",
		        cancel : "取消"
		    },
		    dangerMode: true,
			timer: 100000
		}).then((result) => {
			if (result) {
				// handle Confirm button click
//		 		console.log("執行刪除");
//		 		console.log(e.target.id);
				let id = (e.target.id).substring(6);
//		 		console.log(id);
		    	let url = "<c:url value='/35/myJourney/"+id+"' />";

		        fetch(url, {
		            method: "delete"
		        })
		            .then(status)
		            .then(json)
		            .then(data => {
//		                 console.log(data);
						showJourney.click(); 
						showJourney.click();
		            });
			} else {
				// result.dismiss can be 'cancel', 'overlay', 'esc' or 'timer'
			}
		});
	}

// 	先變化欄位成為自由修改
	let pinUpdate = (e) => {
// 		console.log(e.target.id);
// 		1.同列資料的id值要抓住
		let id = (e.target.id).substring(6);
// 		2.處理其他要更新的欄位，抓出同列tr下所有td的value
		let updateRow = document.getElementById("row"+id);
// 		console.log(updateRow.children[0]);
		updateRow.children[0].innerHTML="<input type='text' value='"+updateRow.children[0].children[0].innerText+"'>";
		updateRow.children[2].innerHTML="<input type='text' value='"+updateRow.children[2].innerText+"'>";
		updateRow.children[3].innerHTML="<input type='text' value='"+updateRow.children[3].innerText+"'>";
		updateRow.children[4].innerHTML="<select><option>5</option><option>4</option><option>3</option><option>2</option><option>1</option></select>";
		updateRow.children[5].children[0].innerText="確認更新";
		updateRow.children[5].children[0].className="genric-btn info radius";
		updateRow.children[5].children[0].onclick=executeUpdate;
// 		console.log(id);
	}

// 	真正fetch執行更新的方法
	let executeUpdate = (e) => {
// 		1.同列資料的id值要抓住
		let id = (e.target.id).substring(6);
// 		2.處理其他要更新的欄位，抓出同列tr下所有td的value
		let updateRow = document.getElementById("row"+id);
// 		console.log(updateRow.children[0].children[0].value);
// 		console.log(updateRow.children[2].children[0].value);
// 		console.log(updateRow.children[3].children[0].value);
// 		console.log(updateRow.children[4].children[0].value);
		let name = updateRow.children[0].children[0].value;
		let time = updateRow.children[2].children[0].value;
		let notes = updateRow.children[3].children[0].value;
		let rating = updateRow.children[4].children[0].value;
		
    	let url = "<c:url value='/35/myJourney/' />";

		let updatedData = {
				"id" : id,
				"name" : name,
				"time" : time,
				"notes" : notes,
				"rating" : rating
				};
		
        fetch(url, {
            method: "put",
            headers: {
                'Content-Type': 'application/json; charset=UTF-8'
            },
            body: JSON.stringify(updatedData)
        })
            .then(status)
            .then(json)
            .then(data => {
//                 console.log(data);
				showJourney.click(); 
				showJourney.click();
            });
	}

	// unsplash 上的圖片
		let url = "<c:url value='/images/myJourney.JPG' />";
		fetch(url)
		  .then((response) => {
		    return response.blob();
		  })
		  .then((imageBlob) => {
// 			console.log(imageBlob);
		    let img = document.createElement('IMG')
		    document.querySelector('.newImg').appendChild(img);
		    // 將 blog 物件轉為 url
		    img.src = URL.createObjectURL(imageBlob);
		  })
		  
	function createButton(label, container) {
	    let btn = L.DomUtil.create('button', '', container);
	    btn.setAttribute('type', 'button');
	    btn.innerHTML = label;
	    return btn;
	}

// 	更改導航起點終點的按鈕，放到全域
	let startBtn;
	let destBtn;
	leafletMap.on('click', function(e) {

		if (routing !== null){
		    let container = L.DomUtil.create('div'),
		        startBtn = createButton('設定導航起點', container),
		        destBtn = createButton('設定導航終點', container);
		    container.children[0].style.display="block";
		    container.children[0].style.marginBottom="8px";
		    container.children[0].style.background="#D1E9E9";
		    container.children[1].style.background="#D1E9E9";
		    container.children[0].style.borderRadius="8px";
		    container.children[1].style.borderRadius="8px";
		
		    L.popup()
		        .setContent(container)
		        .setLatLng(e.latlng)
		        .openOn(leafletMap);
		    
			L.DomEvent.on(startBtn, 'click', function() {
				routing.spliceWaypoints(0, 1, e.latlng);
				leafletMap.closePopup();
			});
			    
			L.DomEvent.on(destBtn, 'click', function() {
				routing.spliceWaypoints(routing.getWaypoints().length - 1, 1, e.latlng);
				leafletMap.closePopup();
			});
		}
	
	});

//  導航路徑原始參考
//  let routingControl = (data) => {
     
//		if (routing !== null) {
//			leafletMap.removeControl(routing);
//		}
		
//	    //導航路徑
//		routing = L.Routing.control({
//			waypoints : [ L.latLng(data[0].lat, data[0].lon), L.latLng(data[1].lat, data[1].lon) ]
//		}).addTo(leafletMap);
 	
//  }
    
	//		下方已經棄用
    // 		IIFEs(Immediately Invoked Functions Expressions)
    // 		第一個括號內是expression，JavaScript會以 expression 的方式來讀取這段函式
    // 		在這種情況下，這個 function 會被建立，但是不會被存在任何變數當中
    // 		在這個expression的最後加上括號 ()，代表執行這段expression
//     (function () {
	
//         var leafletMap = L.map(document.getElementById('artMap'), {
//             center: [24, 121], // 中心點
//             zoom: 10, // 縮放層級
//             crs: L.CRS.EPSG3857, // 座標系統
//             downloadable: true,
//             attributionControl: false,
//         });
		
        //			標記+按下去顯示說明文字，若有.openPopup()這個屬性，會直接顯示文字，無需點按
//         let markerBlue = L.marker([23.6, 121]).addTo(leafletMap).bindPopup(
//             "<b>Title</b><br>Description");
        // 			markerBlue.openPopup();

        // 			leafletMap.on('draw:created', function(e) {
        // 				let layer = e.layer;
        // 				let shape = layer.toGeoJSON();
        // 				let shape_for_db = JSON.stringify(shape);
        // 			});

//     })();
	</script>
</body>
</html>