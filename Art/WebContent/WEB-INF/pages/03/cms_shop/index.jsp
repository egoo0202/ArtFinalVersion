<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="container">
	<br>
	<div class=title>
		<h1 align="center" style="margin-top: 20px;">藝文商店 管理系統</h1>
	</div>
	<div class="back" align="right">
		<form action="<c:url value='/03/cms/shop/index.ctrl'/> " method="get">
			<div class="submitButton">
				<input type="submit" class='btn btn-outline-info' name="submit"
					value="返回 藝文商店管理">
			</div>
		</form>
	</div>
	<div class=title>
		<h3 align="center" style="margin-top: 20px;font-weight: bold;">藝文商店管理</h3>
	</div>
	<!-- 	<div class=content> -->
	<!-- 		<form method="post" -->
	<%-- 			action="<c:url value="/03/cms/shop/searchShopByShopName.ctrl"/>"> --%>
	<!-- 			<div class="submitButton"> -->
	<!-- 				藝文商店查詢: <input type="text" placeholder="請輸入藝文商店名稱 " name="shopName"><input -->
	<!-- 					type="submit" name="submit" value="查詢"> -->
	<!-- 			</div> -->
	<!-- 			<br> -->
	<!-- 		</form> -->
	<!-- 	</div> -->
	<br>
	<div class=content>
		<table id="03"
			class="display table table-bordered table-hover table-blue">
			<thead>
				<tr class="head">
					<th scope="col" width="100px" class='table-warning'>商店代號</th>
					<th scope="col" width="100px" class='table-success'>商店名稱</th>
					<th scope="col" width="100px" class='table-danger'>商店地址</th>
					<th scope="col" width="100px" class='table-info'>連絡電話</th>
					<th scope="col" width="100px" class='table-warning'>詳細資訊</th>
					<!-- ===================== -->
					<th scope="col" width="80px" class='table-success'>更新</th>
					<th scope="col" width="80px" class='table-danger'>刪除</th>
				</tr>
			</thead>
			<tfoot>
			</tfoot>
			<tbody>
				<c:if test="${acShopsList != null}">
					<c:forEach items="${acShopsList}" var="acShopsList" varStatus="vs">
						<tr>
							<td style="color: black;">${acShopsList.shopId}</td>
							<td style="color: black;">${acShopsList.shopName}</td>
							<td style="color: black;">${acShopsList.address}</td>
							<td style="color: black;">${acShopsList.phone}</td>
							<td>
								<form method="post"
									action="<c:url value="/03/cms/shop/shopDetails.ctrl"/>">
									<button name="updateButton" type="submit" class='btn btn-info'
										value="${acShopsList.shopId}">詳細資訊</button>
									<Input type="hidden" name="shopId"
										value="${acShopsList.shopId}">
								</form>
							</td>
							<!-- ======================= -->
							<td>
								<form method="post"
									action="<c:url value="/03/cms/shop/updateShopByShopId.ctrl"/>">
									<button name="updateButton" type="submit" class='btn btn-info'
										value="${acShopsList.shopId}">更新</button>
									<Input type="hidden" name="shopId"
										value="${acShopsList.shopId}">
								</form>
							</td>
							<td>
								<form method="post"
									action="<c:url value="/03/cms/shop/deleteShop.ctrl"/>">
									<button name="deleteButton" type="submit" class='btn btn-info'
										value="${acShopsList.shopId}">刪除</button>
									<Input type="hidden" name="shopId"
										value="${acShopsList.shopId}">
								</form>
							</td>
						</tr>
					</c:forEach>
				</c:if>
			</tbody>
		</table>
		<br>
		<c:if test="${acShopsSerachMsg != null}">
			<div align="center" style="font-size: larger">${acShopsSerachMsg}</div>
		</c:if>
	</div>
</div>
<!-- ====================================================== -->
<script>
	$(document).ready(function() {
		$('#03').DataTable({
			scrollY : 800,
			"language" : {
				"search" : "搜尋商店:",
				"lengthMenu" : "每頁 _MENU_ 間藝文商店",
				"zeroRecords" : "抱歉，查無商店資料",
				"info" : "第 _PAGE_ 頁，總計 _PAGES_ 頁",
				"infoEmpty" : "沒有商店資料",
				"infoFiltered" : "(filtered from _MAX_ total records)",
				"paginate" : {
					"first" : "第一頁",
					"last" : "最後一頁",
					"next" : "下一頁",
					"previous" : "前一頁"
				}
			}
		});
	});
</script>