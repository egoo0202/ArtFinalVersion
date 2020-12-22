<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>查詢離我最近的活動</title>
<script src="<c:url value='/webjars/sockjs-client/sockjs.min.js' />"></script>
<script src="<c:url value='/webjars/stomp-websocket/stomp.min.js' />"></script>
<style>
body {
	font-size: 20px;
	color: black;
}

.content {
	text-align: center;
}
{
box-sizing


:

 

border-box


;
}

/* Button used to open the chat form - fixed at the bottom of the page */
.open-button {
	background-color: #555;
	color: white;
	padding: 16px 20px;
	border: none;
	cursor: pointer;
	opacity: 0.8;
	position: fixed;
	bottom: 23px;
	right: 28px;
	width: 280px;
}

/* The popup chat - hidden by default */
.form-popup {
	display: none;
	position: fixed;
	bottom: 0;
	right: 15px;
	border: 3px solid #f1f1f1;
	z-index: 9;
}

/* Add styles to the form container */
.form-container {
	max-width: 300px;
	padding: 10px;
	background-color: white;
}

/* Full-width textarea */
.form-container textarea {
	width: 100%;
	padding: 15px;
	margin: 5px 0 22px 0;
	border: none;
	background: #f1f1f1;
	resize: none;
	min-height: 90px;
}

/* When the textarea gets focus, do something */
.form-container textarea:focus {
	background-color: #ddd;
	outline: none;
}

/* Set a style for the submit/login button */
.form-container .btn {
	background-color: #4CAF50;
	color: white;
	padding: 16px 20px;
	border: none;
	cursor: pointer;
	width: 100%;
	margin-bottom: 10px;
	opacity: 0.8;
}

/* Add a red background color to the cancel button */
.form-container .cancel {
	background-color: red;
}

/* Add some hover effects to buttons */
.form-container .btn:hover, .open-button:hover {
	opacity: 1;
}

.start-chat, .chat-popup {
	position: fixed;
	bottom: 10px;
	right: 10px;
	z-index: 9999;
	font-size: 22px;
}

.chat-popup {
	border: 2px navy solid; linear-gradient (left,#000,#FFF);
	max-height: 730px;
	overflow: auto;
}

#myForm {
	display: none;
}

#response {
	min-height: 50px;
	font-size:16px;
	color: black;
}
</style>
<script type="text/javascript">

// 頁面載入就先切連線
window.onload="disconnect()";

// 	基礎設定
let stompClient = null;

function setConnected(connected) {
	//將id = connect 按鈕屬性改為disabled
	document.getElementById('connect').disabled = connected;
	//將id = disconnect 按鈕屬性改為disabled
	document.getElementById('disconnect').disabled = !connected;
	//當連接上Websocket id = conversation 顯示
	document.getElementById('conversationDiv').style.visibility = connected ? 'visible'
			: 'hidden';
	//將chatRoom內容清空
	document.getElementById('response').innerHTML = '';
}

// 	開啟連線
function connect() {
	document.getElementById("myForm").style.display = "block";
	//建立一個socket物件 名稱為:/chatroom
	let socket = new SockJS("<c:url value='/chatroom' />");
	stompClient = Stomp.over(socket);
	stompClient.connect({}, function(frame) {
		setConnected(true);
		console.log('Connected: ' + frame);
		// 			設定訂閱的方法
		stompClient.subscribe("/topic/randomNearActsInfo", function(response) {
//				console.log(response);
			// 				轉成json再responseMessage轉
			showMessageOutput(JSON.parse(response.body));
		});
	});
}

// 	斷開連線
function disconnect() {
	document.getElementById("myForm").style.display = "none";
	if (stompClient != null) {
		stompClient.disconnect();
	}
	setConnected(false);
	console.log("Disconnected");
}

// 	發送訊息並JSON.stringify轉換
function sendMessage() {
	let from = document.getElementById('memberRealName').innerText;
	let text = document.getElementById('text').value;
//		console.log(stompClient);
	let jsonStringifyObj = JSON.stringify({
		'from' : from,
		'text' : text
	});
	stompClient.send("/app/askRandomNearActs", {}, jsonStringifyObj);
}

// 	秀出發送的訊息
function showMessageOutput(messageOutput) {
		console.log(messageOutput.introText);
	let response = document.getElementById('response');
	let p = document.createElement('p');
	let a1 = document.createElement('a');
	let a2 = document.createElement('a');
	let a3 = document.createElement('a');
	p.style.wordWrap = 'break-word';
	a1.style.wordWrap = 'break-word';
	a1.href="https://www.google.com/search?q="+messageOutput.list[0].title;
	a1.style.display="block";
	a1.target="_blank";
	a2.style.wordWrap = 'break-word';
	a2.href="https://www.google.com/search?q="+messageOutput.list[1].title;
	a2.style.display="block";
	a2.target="_blank";
	a3.style.wordWrap = 'break-word';
	a3.href="https://www.google.com/search?q="+messageOutput.list[2].title;
	a3.style.display="block";
	a3.target="_blank";
	a3.style.marginBottom="20px";
	p.appendChild(document.createTextNode(messageOutput.from + messageOutput.introText));
	a1.appendChild(document.createTextNode("1. "+messageOutput.list[0].title));
	a2.appendChild(document.createTextNode("2. "+messageOutput.list[1].title));
	a3.appendChild(document.createTextNode("3. "+messageOutput.list[2].title));
	response.appendChild(p);
	response.appendChild(a1);
	response.appendChild(a2);
	response.appendChild(a3);
	updateScroll();
}

// 	滾輪自動滾到最底下
// 	let scrolled = false;
function updateScroll() {
	// 		if(!scrolled){
	let element = document.getElementById("myForm");
	element.scrollTop = element.scrollHeight;
	// 		}
}

// 	使用者移動時不要自動滾
// 	document.getElementById("myForm").on('scroll', function(){
// 	    scrolled=true;
// 	});
</script>
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
	<div class="content">
		<h1>我目前的位置</h1>
		<br>
		<form action="<c:url value='/35/findNear.ctrl'/> " method="get">
			<div class="searchBox">
				<input id="userLocation" type="text" name="userLocation" value="">
			</div>
			<BR>
			<div class="submitButton">
				<input class="genric-btn primary radius" type="submit" name="submit"
					value="確認送出">
				<button class="genric-btn info radius" id="oneKey" type="button">一鍵輸入</button>
			</div>
		</form>
	</div>
	<br>
	<br>
	<div class="content">
		<h1>猜您喜歡</h1>
	</div>
	<br>
	<div class="content">
		<c:forEach var="recommend" items="${recommend}">
			<c:set var="addr"
				value="${recommend.city.concat(recommend.district).concat(recommend.address)}" />
			<h3>${recommend.title}</h3>
			<h5>時間: ${recommend.time}</h5>
			<iframe width="100%" height="280" frameborder="0"
				src="https://www.google.com/maps?q=${addr}&output=embed"></iframe>
			<%-- 		${addr}前兩條斜線，中間是使用者位置 --%>
			<%-- 		<a href="https://www.google.com.tw/maps/dir//${addr}">導航網頁版</a> --%>
			<input class="genric-btn primary radius" type="button"
				onclick="navigate(this.id)" id="${addr}" value="幫我導航">
			<div>
				<br>
			</div>
		</c:forEach>
	</div>
	<br>
	<div class="content">
		<h1>台灣孩童的藝文指數</h1>
		<br>
		<form action="<c:url value='/35/founding.ctrl'/> " method="get">
			<div class="searchBox">
				<input type="text" class="" name="kidsLocation" value="">
			</div>
			<br>
			<div class="submitButton">
				<input class="genric-btn primary radius" type="submit" name="submit"
					value="好奇嗎？點下去就對了">
			</div>
		</form>
	</div>
	<div id="memberRealName" style="display: none">${sessionScope.member.realName}</div>
	<button class="start-chat genric-btn info radius" onclick="connect()">今天，我想來點</button>
	<div class="chat-popup" id="myForm">
		<div class="form-container">
			<h1>輸入地點</h1>
			<label for="msg"><b>隨機推薦您附近的三個活動</b></label>
			<div>
				<!-- 				websocket連線開關已經更改為和浮動視窗開關綁定，但是暫時不能刪掉下面這個隱藏div，因為js碼中有call到它 -->
				<div style="display: none;">
					<button id="connect" onclick="connect();">Connect</button>
					<button id="disconnect" disabled="disabled" onclick="disconnect();">
						Disconnect</button>
				</div>
				<div id="conversationDiv">
					<p id="response"></p>
					<textarea id="text" placeholder="輸入你想找的地點吧" name="msg" required></textarea>
				</div>
			</div>
			<button type="button" class="btn" onclick="sendMessage();">送出訊息</button>
			<button type="button" class="btn cancel" onclick="disconnect()">離開對話</button>
		</div>
	</div>
	<script type="text/javascript">
		function getRandomInt(max) {
			return Math.floor(Math.random() * Math.floor(max));
		}
		
		let oneKey = document.getElementById("oneKey");
		
		oneKey.addEventListener("click", () => {
			if(getRandomInt(3)==0){
				document.getElementById("userLocation").value="台南";
			}else if(getRandomInt(3)==1) {
				document.getElementById("userLocation").value="資策會";
			}else {
				document.getElementById("userLocation").value="西門町";
			}
		});

// 	宣告一個名為navigete的箭頭函式，傳入參數是addr
// 	let navigate命名是為了button onclick 要有function名稱
// 	若箭頭函式只有單一參數，參數的括號可省略
	let navigate = addr => {
// 		fetch()回傳的是promise物件，下面寫一個promise物件範例
// 		let p = new Promise((resolve, reject) => {
// 			let a = 2;
// 			if(a==2){
// 				傳入的resolve是函示名
// 				resolve()
// 			}else {
// 				傳入的reject是函示名
// 				reject()
// 			}			
// 		});
		fetch("<c:url value='/35/navigate/' />"+addr, {
			method: 'GET'}
// 		then()框框內的參數response是上一步fetch()執行之回傳值
// 		response帶入成為then()中箭頭函式之參數
// 		橫槓內代表成功時之處理
// 		----------------------------------------
		).then(response => {
// 			因為fetch就算不是200也會回傳成功的結果，所以要加這步驟判斷
// 			等同response==200
			if (response.ok){
// 				response回傳的是stream物件，所以需要.text()/.json()/.blob()方法取資料
// 				response.header可以取header內容
// 				response.text()回傳的是promise物件，所以要再.then()一次處理成功時回傳的值
// 				message帶入成為then()中箭頭函式之參數
				response.text().then(message => {	
// 					message就是回傳後轉形成text的回應內容，這時候創元素變數名稱
					let navigateButton = document.getElementById(addr);
					let navigateImg = document.createElement('img');
// 					Button後方插入元素
					navigateButton.insertAdjacentElement("afterend", navigateImg);
// 					插入圖片屬性
					navigateImg.src="data:image/png;base64, " + message;
					navigateImg.style.margin="0 auto";
					navigateImg.style.display = "block";
					navigateImg.style.width = "400px";
					navigateImg.style.height = "400px";	
//			 	第二層.then()沒回傳promise物件成功的結果時，會跳到此catch						
				}).catch();	
			}
// 		第一層.then()沒回傳promise物件成功的結果時，會跳到此catch
		}).catch();
	}

	</script>
</body>
</html>