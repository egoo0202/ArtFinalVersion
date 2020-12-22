<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>註冊成為會員</title>
</head>
<style>
body {
	font-size: 20px;
	color: black;
}

tr {
	text-align: left;
}

.errMsg {
	color: red;
	padding-top: 15px;
	font-size: 22px;
}

fieldset {
	width: 800px;
	margin: 0 auto;
}

.registerForm {
	margin: 0 auto;
}

.goCenter {
	text-align: center;
}

.title {
	font-size: 40px;
	font-weight: 500;
}

#myImage {
	width: 480px;
	margin: 0 auto;
}

.imgTd {
	text-align: center;
}
</style>
<body>
	<!-- start banner Area -->
	<section class="banner-area relative" id="home">
		<div class="overlay overlay-bg"></div>
		<div class="container">
			<div class="row d-flex align-items-center justify-content-center">
				<div class="about-content col-lg-12">
					<h1 class="text-white">Register</h1>
					<p class="text-white link-nav">
						<a href="index.html">Home </a> <span class="lnr lnr-arrow-right"></span>
						<a href="<c:url value='/35/registerEntry' />"> Register</a>
					</p>
				</div>
			</div>
		</div>
	</section>
	<!-- End banner Area -->
	<br>
	<br>
	<fieldset>
		<legend class="goCenter title">請填寫下列資料完成註冊</legend>
		<c:url var="url" value='/35/registerCheck.ctrl' />
		<form:form action="${url}" method="POST" enctype="multipart/form-data"
			modelAttribute="member">
			<table class="registerForm">
				<tr>
					<td colspan="2" class="errMsg">${errMsg}</td>
				</tr>
				<tr>
					<td><form:label path="name">帳號名稱(必填):</form:label></td>
					<td><form:input path="name" /></td>
				</tr>
				<tr>
					<td><form:label path="password">密碼(必填):</form:label></td>
					<td><form:input id="pwd" type="password" path="password" /></td>
				</tr>
				<tr>
					<td><label>再次確認密碼(必填):</label></td>
					<td><input id="pwdSecond" type="password" name="passwordAuth" /></td>
				</tr>
				<tr>
					<td><form:label path="realName">真實姓名(必填):</form:label></td>
					<td><form:input id="realName" path="realName" /></td>
				</tr>
				<tr>
					<td><form:label path="address">地址:</form:label></td>
					<td><form:input id="address" path="address" /></td>
				</tr>
				<tr>
					<td><form:label path="email">E-mail(必填):</form:label></td>
					<td><form:input path="email" /></td>
				</tr>
				<tr>
					<td><form:label path="tel">電話(必填):</form:label></td>
					<td><form:input id="tel" path="tel" /></td>
				</tr>
				<tr>
					<td>
						<p>
							上傳個人大頭照:<br> <input style="padding-top: 10px;" type="file"
								id="imgUpload" name="memberPic" />
						</p>
					</td>
				</tr>
				<tr>
					<td>
						<p>
							<input type="hidden" name="picUrl" value="${picUrlInModel}" />
						</p>
					</td>
				</tr>
				<tr>
					<td class="imgTd" colspan="2"><img id="myImage"
						src="${picUrlInModel}" onerror="this.style.display='none'"
						alt="my image" /></td>
					<!-- 									<img src="Error.src" onerror="this.src='fallback-img.jpg'"/> -->
				</tr>
				<tr>
					<td colspan="2" class="goCenter" style="padding-top: 20px;"><form:button
							class="genric-btn primary radius" value="Send" id='sendData'>送出註冊資料</form:button>
						<button class="genric-btn info radius" id="oneKey"
							type="button">一鍵輸入</button></td>
				</tr>
			</table>
		</form:form>
	</fieldset>
	<script type="text/javascript">

		let oneKey = document.getElementById("oneKey");
	
		oneKey.addEventListener("click", () => {
			document.getElementById("pwd").value="Do!ng123";
			document.getElementById("pwdSecond").value="Do!ng123";
			document.getElementById("realName").value="克里斯多福諾蘭";
			document.getElementById("address").value="新北市汐止區新台五路一號2樓";
			document.getElementById("tel").value="0981554887";
		});

// 		上傳圖片後觸發change事件，執行這邊定義好的功能
		document.getElementById('imgUpload').addEventListener('change', () => {
			  readUrl();
		});
		
// 		js讀檔案方法
		let readUrl = () => {
// 			.files[0]代表首個檔案
// 			console.log(document.getElementById('imgUpload').files[0]);
// 			console.log(document.getElementById('imgUpload').files);
			let imgUpload = document.getElementById('imgUpload');
			if (imgUpload.files && imgUpload.files[0]) {
// 				讀取檔案api
				let reader = new FileReader();	    
			 	reader.onload = function(e) {
					document.getElementById('myImage').src = e.target.result;
// 					console.log(e.target.result);
				}
			 	// convert to base64 string
				reader.readAsDataURL(imgUpload.files[0]);
				document.getElementById('myImage').style.display = "block";
			}
		}

	</script>
</body>
</html>