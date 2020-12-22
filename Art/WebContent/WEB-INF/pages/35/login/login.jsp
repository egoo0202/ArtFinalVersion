<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="google-signin-client_id"
	content="373238201778-gmsrplpti0mataeg48g47dm9g6rkeh09.apps.googleusercontent.com">
<title>登入</title>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<script src="https://apis.google.com/js/platform.js" async defer></script>
<style>
body {
	font-size: 20px;
	color: black;
}
tr {
	text-align: left;
}

.authError, .errors {
	color: red;
	padding: 10px;
}

fieldset {
	text-align: center;
	width: 400px;
	margin: 0 auto;
}

/* .pass {
	display: none;
	color: red;
} */
.loginForm {
	margin: 0 auto;
}

.title {
	font-size: 40px;
	font-weight: 500;
}

.label {
	padding-top: 7px;
}
/* .grecaptcha-badge { 
    display: none;
} */
.google {
	padding-top: 20px;
	text-align: center;
	width: 400px;
	margin: 0 auto;
}

.googleLogin {
	width: 30%;
	margin: 0 auto;
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
					<h1 class="text-white">Login</h1>
					<p class="text-white link-nav">
						<a href="index.html">Home </a> <span class="lnr lnr-arrow-right"></span>
						<a href="<c:url value='/35/loginEntry' />"> Login</a>
					</p>
				</div>
			</div>
		</div>
	</section>
	<!-- End banner Area -->
	<br>
	<br>
	<fieldset>
		<legend class="title">請輸入帳號密碼</legend>
		<c:url var="url" value='/35/loginCheck.ctrl' />
		<form:form name="loginForm" action="${url}" method="POST"
			modelAttribute="member">
			<table class="loginForm">
				<tr>
					<td colspan=2 class="authError">${authError}</td>
				</tr>
				<tr>
					<td><form:label class="label" path="name">帳號:</form:label></td>
					<td><form:input id="name" path="name" value="${name}" /></td>
					<td class="errors">${errors.user}</td>
				</tr>
				<tr>
					<td><form:label class="label" path="password">密碼:</form:label></td>
					<td><form:input id="pwd" type="password" path="password"
							value="${password}" /></td>
					<td class="errors">${errors.pwd}</td>
				</tr>
				<tr>
					<td><label class="label">記住密碼:</label></td>
					<td><input id="rm" type="checkbox" name="rememberMe"
						<c:if test='${requestScope.rememberMe==true}'>
					    checked='checked'
              			</c:if>
						value="yes" /></td>
				</tr>
				<!-- 				<tr> -->
				<%-- 					<td style="padding-top: 20px;"><form:button value="Send" --%>
				<%-- 							name ="submitButton" id='sendData' >真的登入按鈕</form:button></td> --%>
				<!-- 				</tr> -->
				<!-- 				<tr> -->
				<!-- 					<td colspan=2 style="padding-top: 20px;"><p class="pass"></p></td> -->
				<!-- 				</tr> -->
			</table>
		</form:form>
		<!-- 		<button class="googleLogin genric-btn info radius">透過Google帳戶登入</button> -->
		<button class="genric-btn primary radius" id="oneKey" type="button">一鍵輸入</button>
		<button class="captcha genric-btn primary radius">登入</button>
		<button class="forgotPwd genric-btn info radius" onclick=forgotPwd()>忘記密碼</button>
	</fieldset>
	<div class="google">
		<div class="g-signin2 googleLogin" data-onsuccess="onSignIn"></div>
		<!-- 		<a class="googleLogout" href="#" onclick="signOut();">Sign Out Test</a> -->
	</div>

	<script
		src="https://www.google.com/recaptcha/api.js?render=6Lc_wOQZAAAAALKDlGGuMLE_iV-rjKJIYMHI9Fj6"></script>
	<script type="text/javascript">

		let oneKey = document.getElementById("oneKey");

		oneKey.addEventListener("click", () => {
			document.getElementById("name").value="GROUP4";
			document.getElementById("pwd").value="Do!ng123";
			document.getElementById("rm").checked="checked";
		});

		let forgotPwd= () => {
			window.location.href="<c:url value='/35/forgotPwd' />";
		}

	      function onSignIn(googleUser) {
	          // 客戶端如果有需要的話可以通過profile來獲取使用者資訊
	          let profile = googleUser.getBasicProfile();
	          // 傳回後臺驗證，並獲取userid
	          let id_token = googleUser.getAuthResponse().id_token;
// 	          console.log("ID Token: " + id_token);
			  fetch("<c:url value='/35/googleLogin' />", {
			  	method: 'POST',
			  	headers: {
			  	      'Content-Type': 'application/json'},
			  	body: id_token
				}).then(response => {
					if (response.ok){
						response.json().then(message => {
// 							console.log(message);
							let name = message.name;
							let email = message.email;
							let realName = message.realName;
							let picUrl = message.memberPicBase64Str;
							if (message.email.includes("@")){
								window.location.href="<c:url value='/35/registerEntry?name="+name+"&email="+email+"&realName="+realName+"&picUrl="+picUrl+"' />";
// 								因為只是要跳轉到註冊畫面，所以確認授權成功後就可以登出了
								signOut();
							}
						});
					}
				} 
			  );
// 	          var xhr = new XMLHttpRequest();
// 	          xhr.open('POST', "<c:url value='/35/googleLogin' />");
// 	          xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
// 	          xhr.onload = function() {
// 	            console.log('Signed in as: ' + xhr.responseText);
// 	          };
// 	          xhr.send('idtokenstr=' + id_token);
	        };

	    	function signOut() {
		    	var auth2 = gapi.auth2.getAuthInstance();
		    	auth2.signOut().then(function () {
		      	console.log('User signed out.');
		    	});
		  	}
	
		const CAPTCHA_CLIENT_SECRET = "6Lc_wOQZAAAAALKDlGGuMLE_iV-rjKJIYMHI9Fj6";
		window.onload = () => {
			
			document.querySelector('.captcha').addEventListener('click', () => {
						
				grecaptcha.execute(CAPTCHA_CLIENT_SECRET, {action: 'login'}).then(function(token) {
// 					console.log('客戶端token:' + token);
					fetch("<c:url value='/35/validate?token=' />" + token, {
						method: 'GET'
					}).then(response => {
						if (response.ok){
							response.json().then(message => {
// 								返回的message是JSONObject型態
// 								取Key對應value用message.score或message["score"]
//                              JSONObject.key，可以抓出key的value
								if (message.score >= 0.7){
									swal({ 
										title: "reCAPTCHA v3評分: "+message.score, 
										text: "評分大於0.8，你不是機器人。點擊按鈕執行登入",
										button: '執行登入',
										timer: 100000
									}).then((result) => {
										if (result) {
											// handle Confirm button click
										    loginForm.submit();
										} else {
											// result.dismiss can be 'cancel', 'overlay', 'esc' or 'timer'
											loginForm.submit();
										}
									});
// 									let pass = document.querySelector('.pass');
// 									pass.style.display = "block";
// 									pass.innerHTML="reCAPTCHA評分: "+message.score+"<br>驗證通過，您不是機器人<br>2秒後執行登入";

// 									let delayInMilliseconds = 1000; //1 second
// 									setTimeout(() => {
// 										 // code to be executed after 1 second
// 										pass.innerHTML="reCAPTCHA評分: "+message.score+"<br>驗證通過，您不是機器人<br>1秒後執行登入";
// 										}, delayInMilliseconds);
// 									setTimeout(() => {
// 										 // code to be executed after 2 second
// 										loginForm.submit();
// 									}, delayInMilliseconds+1000);
								}else {
									swal("你被判定為非人類，禁止登入");
								}
							});
						}
					});			
				});
			});

//			測試程序化登入google評分
// 			for(i=0;i<10;i++){
// 				document.querySelector('.captcha').click();
// 			}

		};
	</script>
</body>
</html>