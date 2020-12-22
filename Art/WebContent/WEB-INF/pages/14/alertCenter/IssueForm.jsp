<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- start banner Area -->
	<section class="banner-area relative" id="home">
		<div class="overlay overlay-bg"></div>
		<div class="container">
			<div class="row d-flex align-items-center justify-content-center">
				<div class="about-content col-lg-12">
					<h1 class="text-white">會員申訴表單</h1>
					<p class="text-white link-nav">
						<a href="index.html">回首頁 </a>

					</p>
				</div>
			</div>
		</div>
	</section>
	<!-- End banner Area -->

	<!-- start form Area -->
	<div class="container">
		<div class="section-top-border">
			<div class="col-lg-8 col-md-8">
				<h3 class="mb-30">請填寫問題詳情</h3>
				<h5 class="mb-30">請填寫表單最下方之問題詳情，我們會盡快為您服務 :)</h5>
				<form action="ShopAPAlerts" method="POST">
				<div class="form-row" style="font-size:14px;">
					<div class="form-group col-md-6">
						<label for="inputEmail4">您的會員編號</label> <input type="text" name="memberId"
							class="form-control" id="inputEmail4" value="${al.memberId}" disabled 
							style="font-size:14px; padding: 0px; padding-left:10px; cursor: no-drop;">
					</div>
					<div class="form-group col-md-6">
						<label for="inputEmail4">您的會員帳號</label> <input type="text" name="memberName"
							class="form-control" id="inputEmail4" value="${al.memberName }" disabled 
							style="font-size:14px; padding: 0px; padding-left:10px; cursor: no-drop;">
					</div>
				</div>
				
					<div class="form-row" style="font-size:14px;">
					<div class="form-group col-md-6">
						<label for="inputEmail4">您的訂單編號</label> <input type="text" name="issueId"
							class="form-control" id="inputEmail4" value="${al.issueId}" disabled
							style="font-size:14px; padding: 0px; padding-left:10px; cursor: no-drop;">
					</div>
					<div class="form-group col-md-6">
						<label for="inputEmail4">您的申訴分類</label> <input type="text" name="issue"
							class="form-control" id="inputEmail4" value="得藝洋行商品退換貨" disabled 
							style="font-size:14px; padding: 0px; padding-left:10px; cursor: no-drop;">
					</div>
				</div>
					<div class="mt-10">
						<label for="fname">請填寫問題詳情:</label>
						<textarea class="single-textarea" name="description" id="description"
							placeholder="請詳細描述您的問題" onfocus="this.placeholder = ''"
							onblur="this.placeholder = '請詳細描述您的問題'" required></textarea>
					</div>
					<button class="genric-btn primary-border small" type="submit" id="submit">確認送出 </button>
					<button class="genric-btn primary-border small" type="button" id="btn">一鍵完成 </button>
				</form>
			</div>
		</div>
	</div>
	<script> 
    $(function(){
    	  var Name1 = "買來的每個東西都有瑕疵";
		  var Name2 = '我想要退貨'
         
      $("#btn").click(function() {
    	  document.getElementById("description").innerHTML= Name1 + "\r\n" + Name2;
        });
      });

    

    $("#submit").click(function(){

   	 $("input").prop("disabled",false);

    });

    </script>
</body>
</html>