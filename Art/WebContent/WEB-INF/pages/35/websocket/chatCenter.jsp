<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Chat WebSocket</title>
<%-- <link href="<c:url value='/webjars/bootstrap/css/bootstrap.min.css' />" rel="stylesheet"> --%>
<%-- <script src="<c:url value='/webjars/jquery/jquery.min.js' />"></script> --%>
<script src="<c:url value='/webjars/sockjs-client/sockjs.min.js' />"></script>
<script src="<c:url value='/webjars/stomp-websocket/stomp.min.js' />"></script>
<style>
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
	background: green;
}

#myForm {
	display: none;
}

#response {
	min-height: 50px;
	font-size: 16px;
	color: black;
}

.contacts {
	width: 100%;
}
</style>
<script type="text/javascript">
	//頁面載入就先切連線
	window.onload = "disconnect()";
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
			stompClient.subscribe("/topic/messages", function(response) {
				// 				console.log(response);
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
		// 		console.log(stompClient);
		let jsonStringifyObj = JSON.stringify({
			'from' : from,
			'text' : text
		});
		stompClient.send("/app/chat", {}, jsonStringifyObj);
	}

	// 	秀出發送的訊息
	function showMessageOutput(messageOutput) {
		// 		console.log(messageOutput.text);
		let response = document.getElementById('response');
		let p = document.createElement('p');
		if (messageOutput.from=="管理員") {
			p.style.color="red";
		}
		p.style.wordWrap = 'break-word';
		p.appendChild(document.createTextNode(messageOutput.from + ": "
				+ messageOutput.text + " (" + messageOutput.time + ")"));
		response.appendChild(p);
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
	<div id="memberRealName" style="display: none">${sessionScope.member.realName}</div>
	<div>
		<img class="contacts" src="<c:url value='/images/contacts.JPG' />">
	</div>
	<button class="start-chat btn btn-info" onclick="connect()">進入客服系統</button>
	<div class="chat-popup" id="myForm">
		<div class="form-container">
			<h1>客服系統</h1>
			<label for="msg"><b>對話訊息</b></label>
			<div>
				<!-- 				websocket連線開關已經更改為和浮動視窗開關綁定，但是暫時不能刪掉下面這個隱藏div，因為js碼中有call到它 -->
				<div style="display: none;">
					<button id="connect" onclick="connect();">Connect</button>
					<button id="disconnect" disabled="disabled" onclick="disconnect();">
						Disconnect</button>
				</div>
				<div id="conversationDiv">
					<p id="response"></p>
					<textarea id="text" placeholder="輸入你想說的話吧.." name="msg" required></textarea>
				</div>
			</div>
			<button type="button" class="btn" onclick="sendMessage();">送出訊息</button>
			<button type="button" class="btn cancel" onclick="disconnect()">離開對話</button>
		</div>
	</div>
</body>
</html>
