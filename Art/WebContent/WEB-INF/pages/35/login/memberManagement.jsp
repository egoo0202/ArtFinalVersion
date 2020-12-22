<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>會員資訊管理</title>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<style>
body {
	font-size: 20px;
	color: black;
}

.post {
	display: none;
}

#result {
	color: red;
}

.comfirmAdd, #analysis {
	margin: 12px 15px;
}

.comfirmPost {
	text-align: center;
}

div.container {
	width: 50%;
}

.pdf, .xlsx, .add {
	display: inline;
}

.option {
	text-align: right;
}
</style>
</head>
<body>
	<br>
	<div class="title">
		<h1 align="center">會員資料列表</h1>
	</div>
	<div class="option">
		<div class="pdf">
			<br> <input id="analysis" class="btn btn-info" type="button"
				value="輸出會員報表 (.pdf)" onclick="outputPDF()">
		</div>
		<div class="xlsx">
			<input id="analysis" class="btn btn-info" type="button"
				value="輸出會員報表 (.xlsx)" onclick="outputXLSX()">
		</div>
		<div class="add" align="right">
			<input class="btn btn-info comfirmAdd" type="button" value="新增會員資料"
				onclick="add()">
			<div class="post">
				<table class="display table">
					<thead>
						<tr>
							<th class="table-secondary">帳號</th>
							<th class="table-secondary">真實姓名</th>
							<th class="table-warning">地址</th>
							<th class="table-warning">E-mail</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td class=""><input type="text" id="add.name"></td>
							<td class=""><input type="text" id="add.realName"></td>
							<td class=""><input type="text" id="add.address"></td>
							<td class=""><input type="text" id="add.email"></td>
						</tr>
					</tbody>
				</table>
				<div class="infoTable">
					<table class="display table">
						<thead>
							<tr>
								<th class="table-warning">電話</th>
								<th class="table-warning">會員類型</th>
								<th class="table-secondary">偏好</th>
								<th class="table-secondary">購買上限</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td class=""><input type="text" id="add.tel"></td>
								<td class=""><input type="text" id="add.memberType"></td>
								<td class=""><input type="text" id="add.preference"></td>
								<td class=""><input type="text" id="add.purchaseLimit"></td>
							</tr>
							<tr class="comfirmPost">
								<td colspan="4"><input class="btn btn-info" type="button"
									value="確認新增" onclick="post()"></td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
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
					<th class="table-info">帳號</th>
					<th class="table-info">真實姓名</th>
					<th class="table-info">地址</th>
					<th class="table-info">E-mail</th>
					<th class="table-secondary">電話</th>
					<th class="table-secondary">會員類型</th>
					<th class="table-secondary">個人照片</th>
					<th class="table-secondary">偏好</th>
					<th class="table-info">註冊日期</th>
					<th class="table-info">購買上限</th>
					<th class="table-info">會員狀態</th>
					<th class="table-secondary">修改會員資訊</th>
					<th class="table-secondary">停權此會員</th>
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
							href="<c:url value=''/>"><img
								style='display: block; width: 100px; height: 75px;'
								src="data:image/jpg;base64, ${list.memberPicBase64Str}"></a></td>
						<td class="" id="${list.name}.preference">${list.preference}</td>
						<td class="" id="${list.name}.registerTime">${list.registerTime}</td>
						<td class="" id="${list.name}.purchaseLimit">${list.purchaseLimit}</td>
						<td class="" id="${list.name}.status">${list.status}</td>
						<td class="update">
							<div>
								<input class="btn btn-info" type="button" value="修改"
									id="${list.name}" onclick="put(this.id)">
							</div>
						</td>
						<td class="delete">
							<div>
								<input class="btn btn-info" type="button" value="停權"
									id="${list.name}" onclick="del(this.id)">
							</div>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<script>
		let outputPDF = () => {
			window.location = "<c:url value='/35/memberOutput.pdf' />";
		}
		
		let outputXLSX = () => {
			window.location = "<c:url value='/35/memberOutput.xlsx' />";
		}
	
        $(document).ready(function () {
            $('#35').DataTable({
            	scrollX: true,
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
            let status = document.getElementById(name + ".status").innerText;

            let jsonMember = {
                "name": name,
                "realName": realName,
                "address": address,
                "email": email,
                "tel": tel,
                "memberType": memberType,
                "preference": preference,
                "purchaseLimit": purchaseLimit,
                "status": status
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
            swal({title: "確定停權會員: " + name + " ?",
            	  buttons: {
            		  	  cancel: {
            			    text: "否定",
            			    value: null,
            			    visible: true,
            			    className: "",
            			    closeModal: true,
            			  },
            			  confirm: {
            			    text: "是的",
            			    value: true,
            			    visible: true,
            			    className: "",
            			    closeModal: true
            			  }
            		  	}
            }).then((result)=> {
//                 console.log(result);
	            if (result) {
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

	            }
        	});
        }

    </script>
</body>
</html>