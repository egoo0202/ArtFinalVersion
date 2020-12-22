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
		<h3 align="center" style="margin-top: 20px; font-weight: bold;">更新藝文商店</h3>
	</div>

	<div class=content>
		<form method="post" enctype="multipart/form-data"
			action="<c:url value = "/03/cms/shop/updateShop.ctrl"/>">
			<div class="back" align="right">
				<div class="submitButton">
					<input type="submit" class='btn btn-info' name="submit"
						style="font-size: larger" value="更新藝文商店資料">
				</div>
			</div>
			<br>
			<div style="font-size: 25px;">
				<table>
					<thead>
						<tr class="head">
							<th scope="col" width="200px"></th>
							<th scope="col" width="700px"></th>
						</tr>
					</thead>
					<tfoot></tfoot>
					<tbody>
						<c:if test="${acShopsList != null}">
							<c:forEach items="${acShopsList}" var="acShopsList"
								varStatus="vs">
								<!-- ====================================================== -->
								<tr style="display: none;">
									<td>商店編號<span
										style="margin-left: 3px; font-weight: 800; color: rgb(203, 64, 66);">*</span></td>
									<td><input type="hidden" name="shopId"
										class="form-control" value="${acShopsList.shopId}">${acShopsList.shopId}</td>
								</tr>
								<!-- ====================================================== -->
								<tr style="color: black;">
									<td>商店名稱<span
										style="margin-left: 3px; font-weight: 800; color: rgb(203, 64, 66);">*</span></td>
									<td><input type="text" placeholder="請輸入商店名稱 "
										style="color: black;" class="form-control" name="shopName"
										style="color: black;" value="${acShopsList.shopName}"></td>
								</tr>
								<tr>
									<td colspan="2">&nbsp;</td>
								</tr>
								<tr style="color: black;">
									<td>代表圖示<span
										style="margin-left: 3px; font-weight: 800; color: rgb(203, 64, 66);">*</span></td>
									<td><input type="file" class="form-control" name="imageFile"></td>
								</tr>
								<tr>
									<td colspan="2">&nbsp;</td>
								</tr>
								<tr style="color: black;">
									<td>商店簡介<span
										style="margin-left: 3px; font-weight: 800; color: rgb(203, 64, 66);">*</span></td>
									<td><textarea placeholder="請輸入簡介內容" name="intro"
											style="color: black;" rows="5" class="form-control">${acShopsList.intro}</textarea></td>
								</tr>
								<tr>
									<td colspan="2">&nbsp;</td>
								</tr>
								<tr style="color: black;">
									<td>商店地址<span
										style="margin-left: 3px; font-weight: 800; color: rgb(203, 64, 66);">*</span></td>
									<td><input type="text" placeholder="請輸入地址" name="address"
										style="color: black;" value="${acShopsList.address}"
										class="form-control"></td>
								</tr>
								<tr>
									<td colspan="2">&nbsp;</td>
								</tr>
								<tr style="color: black;">
									<td>營業時間<span
										style="margin-left: 3px; font-weight: 800; color: rgb(203, 64, 66);">*</span></td>
									<td><textarea placeholder="請輸入營業時間" name="openTime"
											style="color: black;" rows="3" class="form-control">${acShopsList.openTime}</textarea></td>
								</tr>
								<tr>
									<td colspan="2">&nbsp;</td>
								</tr>
								<!-- ====================================================== -->
								<tr style="color: black;">
									<td>連絡電話<span
										style="margin-left: 3px; font-weight: 800; color: rgb(203, 64, 66);">*</span></td>
									<td><input type="text" placeholder="請輸入連絡電話" name="phone"
										style="color: black;" value="${acShopsList.phone}"
										class="form-control"></td>
								</tr>
								<tr>
									<td colspan="2">&nbsp;</td>
								</tr>
								<tr style="color: black;">
									<td>電子郵件<span
										style="margin-left: 3px; font-weight: 800; color: rgb(203, 64, 66);">*</span></td>
									<td><input type="text" placeholder="請輸入電子郵件" name="email"
										style="color: black;" value="${acShopsList.email}"
										class="form-control"></td>
								</tr>
								<tr>
									<td colspan="2">&nbsp;</td>
								</tr>
								<tr style="color: black;">
									<td>傳真號碼</td>
									<td><input type="text" placeholder="請輸入傳真號碼" name="fax"
										style="color: black;" value="${acShopsList.fax}"
										class="form-control"></td>
								</tr>
								<tr style="color: black;">
									<td colspan="2">&nbsp;</td>
								</tr>
								<tr style="color: black;">
									<td>Facebook連結</td>
									<td><input type="text" placeholder="請輸入facebook 網址"
										style="color: black;" name="facebook"
										value="${acShopsList.facebook}" class="form-control"></td>
								</tr>
								<tr>
									<td colspan="2">&nbsp;</td>
								</tr>
								<tr style="color: black;">
									<td>商店網站連結</td>
									<td><input type="text" placeholder="請輸入網址" name="website"
										style="color: black;" value="${acShopsList.website}"
										class="form-control"></td>
								</tr>
								<tr>
									<td colspan="2">&nbsp;</td>
								</tr>
								<!-- ====================================================== -->
								<tr style="color: black;">
									<td>熱門度</td>
									<td><input type="text" placeholder="請輸入點擊次數" name="clicks"
										style="color: black;" value="${acShopsList.clicks}"
										class="form-control"></td>
								</tr>

								<!-- 不使用 ====================================================== -->
								<tr style="display: none;">
									<td>會員帳號</td>
									<td><input type="hidden" name="memberId" value="1"
										style="color: black;" class="form-control"></td>
								</tr>
								<tr style="display: none;">
									<td>商店縣市名*</td>
									<td><input type="text" placeholder="請輸入縣市名"
										name="cityName" value="${acShopsList.cityName}"
										style="color: black;" class="form-control"></td>
								</tr>
								<tr style="display: none;">
									<td>image<span
										style="margin-left: 3px; font-weight: 800; color: rgb(203, 64, 66);">*</span></td>
									<td><input type="text" placeholder="請輸入圖片網址" name="image"
										style="color: black;" class="form-control"
										value="${acShopsList.image}"></td>
								</tr>
							</c:forEach>
						</c:if>
					</tbody>

				</table>
			</div>
			<br>
			<c:if test="${acShopsSerachMsg != null}">
				<div align="center" style="font-size: larger">${acShopsSerachMsg}</div>
				<br>
			</c:if>
			<div class="back" align="center">
				<div class="submitButton">
					<input type="submit" class='btn btn-info' name="submit"
						style="font-size: larger" value="更新藝文商店資料">
				</div>
			</div>
			<br>
		</form>
	</div>
</div>

<!-- ====================================================== -->
<script>
	$(document).ready(function() {
		$('#03').DataTable({});
	});
</script>
