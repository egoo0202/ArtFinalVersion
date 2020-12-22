<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>查看個人資訊</title>
<style>
body {
	font-size: 20px;
	color: black;
}
.post {
	display: none;
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
					<h1 class="text-white">查看個人資訊</h1>
					<p class="text-white link-nav">
						<a href="index.html">Home </a> <span class="lnr lnr-arrow-right"></span>
						<a href="<c:url value='/35/personelInfoEntry.ctrl' />">查看個人資訊</a>
					</p>
				</div>
			</div>
		</div>
	</section>
	<!-- End banner Area -->
	<br>
	<div class="title">
		<h1 align="center">會員資料</h1>
	</div>
	<br>
	<div align="center">
		<h2 id="result"></h2>
		<br>
	</div>
	<br>
	<div class="content">
		<table id="35"
			class="display table table-bordered table-hover table-blue">
			<thead>
				<tr class="">
					<th class="table-secondary">帳號</th>
					<th class="table-success">真實姓名</th>
					<th class="table-warning">地址</th>
					<th class="table-light">E-mail</th>
					<th class="table-secondary">電話</th>
					<th class="table-success">會員類型</th>
					<th class="table-danger">個人照片 (點擊照片更新)</th>
					<th class="table-primary">偏好</th>
					<th class="table-info">註冊日期</th>
					<th class="table-danger">購買上限</th>
					<th class="table-info">修改會員資訊</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="list" items="${membersList}">
					<tr>
						<td class="" id="${list.name}.name">${list.name}</td>
						<td class="" id="${list.name}.realName">${list.realName}</td>
						<td class="" id="${list.name}.address">${list.address}</td>
						<td class="" id="${list.name}.email">${list.email}</td>
						<td class="" id="${list.name}.tel">${list.tel}</td>
						<td class="" id="${list.name}.memberType">${list.memberType}</td>
						<td class="" id="${list.name}.memberPic"><a class=""
						href="<c:url value=''/>"><img style='display:block; width:80px;height:60px;'
						src="data:image/jpg;base64, ${list.memberPicBase64Str}" ></a></td>
						<td class="" id="${list.name}.preference">${list.preference}</td>
						<td class="" id="${list.name}.registerTime">${list.registerTime}</td>
						<td class="" id="${list.name}.purchaseLimit">${list.purchaseLimit}</td>
						<td class="update">
							<div>
								<input class="genric-btn primary radius" type="button" value="修改" id="${list.name}"
									onclick="put(this.id)">
							</div>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
    <script>
        $(document).ready(function () {
            $('#35').DataTable({
                "language": {
                    "search": "搜尋:",
                    "lengthMenu": "每頁展示 _MENU_ 個項目",
                    "zeroRecords": "抱歉，查無搜尋結果",
                    "info": "展示第 _PAGE_ 頁，總計 _PAGES_ 頁",
                    "infoEmpty": "沒有紀錄",
                    "infoFiltered" : "(一共搜出 _MAX_ 筆資料)",
                    "paginate": {
                        "first": "第一頁",
                        "last": "最後一頁",
                        "next": "下一頁",
                        "previous": "前一頁"
                    }
                }
            });
        });

        // 新增
        let postDiv = document.querySelector(".post");

        let add = () => {
            postDiv.style.display = "block";
        }

        let post = () => {
            
            let name = document.getElementById("add.name").value;
	        let realName = document.getElementById("add.realName").value;
	        let email = document.getElementById("add.email").value;
	        let tel = document.getElementById("add.tel").value;

            if (name == ""||realName == ""||email == ""||tel == ""){

            	document.getElementById("result").innerText = "帳號、真實姓名、E-mail或電話不可為空";

            }else{
             
	            let address = document.getElementById("add.address").value;
	            let memberType = document.getElementById("add.memberType").value;
	            let preference = document.getElementById("add.preference").value;
	            let purchaseLimit = document.getElementById("add.purchaseLimit").value;
	            let jsonMember = {
	                "name": name,
	                "realName": realName,
	                "address": address,
	                "email": email,
	                "tel": tel,
	                "memberType": memberType,
	                "preference": preference,
	                "purchaseLimit": purchaseLimit,
	                "status": "valid"
	            }
	            postDiv.style.display = "none";
	            fetch("<c:url value='/35/members.ctrl' />", {
	                method: "post",
	                headers: {
	                    'Content-Type': 'application/json; charset=UTF-8'
	                },
	                //物件變json
	                body: JSON.stringify(jsonMember)
	            }
	            ).then(
	                response => {
	                    if (response.ok) {
	                        response.json().then(
	                            object => {
	                                
	                                if (object.hasOwnProperty('success')) {
	                            		window.location.reload();
	                                    document.getElementById("result").innerText = "新增成功";
	                                } else {
	                                    document.getElementById("result").innerText = "新增失敗";
	                                }
	
	                            }
	                        ).catch();
	                    }
	                    
	                    document.getElementById("result").innerText = "新增失敗";
	    
	                }
	            ).catch();
            }
        }

        function status(response) {
            if (response.status >= 200 && response.status < 300) {
                return Promise.resolve(response)
            } else {
                return Promise.reject(new Error(response.statusText))
            }
        }

        function json(response) {
            return response.json()
        }

        // 更新
        let put = (name) => {

            let realName = document.getElementById(name + ".realName").innerText;
            let address = document.getElementById(name + ".address").innerText;
            let email = document.getElementById(name + ".email").innerText;
            let tel = document.getElementById(name + ".tel").innerText;
            let memberType = document.getElementById(name + ".memberType").innerText;
            let preference = document.getElementById(name + ".preference").innerText;
            let purchaseLimit = document.getElementById(name + ".purchaseLimit").innerText;

            let jsonMember = {
                "name": name,
                "realName": realName,
                "address": address,
                "email": email,
                "tel": tel,
                "memberType": memberType,
                "preference": preference,
                "purchaseLimit": purchaseLimit,
                "status": "valid"
            }

            let url = "<c:url value='/35/members/" + name + ".ctrl' />"
            fetch(url,
                {
                    method: "put",
                    headers: {
                        'Content-Type': 'application/json; charset=UTF-8'
                    },
                    body: JSON.stringify(jsonMember)
                })
                .then(status)
                .then(json)
                .then(function (data) {
                    console.log(data);
                }).catch(function (error) {
                    console.log('fetch過程出錯', error);
                });
        }

        // 刪除
        let del = (name) => {
            let desision = confirm("確定刪除會員: " + name + " ?");
            if (desision) {
                let url = "<c:url value='/35/members/" + name + ".ctrl' />"

                fetch(url, { method: "delete" })
                    .then(status)
                    .then(json)
                    .then(function (data) {

                        if (data.hasOwnProperty('success')) {
                        	window.location.reload();
                            document.getElementById("result").innerText = data.success;
                        } else {
                            document.getElementById("result").innerText = data.fail;
                        }
          
                    }).catch(function (error) {
                        console.log('fetch過程出錯', error);
                    });
            } else {
                return false;
            }
        }

    </script>
</body>
</html>