<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="container">
	<br>
	<div class=title>
		<h1 align="center" style="margin-top: 20px;">藝文商店 管理系統</h1>
	</div>
	<div class="back" align="right">
		<form action="<c:url value='/03/cms/shop/createConfirm.ctrl'/> " method="get">
			<div class="submitButton">
				<input type="submit" class='btn btn-outline-info' name="submit"
					value="返回 上架藝文商店">
			</div>
		</form>
	</div>
	<div class=title>
		<h3 align="center" style="margin-top: 20px; font-weight: bold;">上架藝文商店</h3>
	</div>

	<div class=content>
		<form method="post" enctype="multipart/form-data"
			action="<c:url value = "/03/cms/shop/createShop.ctrl"/>">
			<div class="back" align="right">
				<div class="submitButton">
					<input type="submit" class='btn btn-info' name="submit"
						style="font-size: larger" value="建立藝文商店資料">
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
						<tr style="color: black;">
							<td>商店名稱<span style="margin-left: 3px; font-weight: 800; color: rgb(203, 64, 66);">*</span></td>
							<td><input type="text" placeholder="請輸入商店名稱 " style="color: black;"
								name="shopName" class="form-control"></td>
						</tr>

						<tr>
							<td colspan="2">&nbsp;</td>
						</tr>

						<tr style="color: black;">
							<td>代表圖示<span style="margin-left: 3px; font-weight: 800; color: rgb(203, 64, 66);">*</span></td>
							<td><input type="file" class="form-control" name="imageFile"></td>
						</tr>

						<tr>
							<td colspan="2">&nbsp;</td>
						</tr>

						<tr style="color: black;">
							<td>商店簡介<span style="margin-left: 3px; font-weight: 800; color: rgb(203, 64, 66);">*</span></td>
							<td><textarea placeholder="請輸入簡介內容" name="intro" rows="5" style="color: black;"
									class="form-control"></textarea></td>
						</tr>

						<tr>
							<td colspan="2">&nbsp;</td>
						</tr>

						<tr style="color: black;">
							<td>商店地址<span style="margin-left: 3px; font-weight: 800; color: rgb(203, 64, 66);">*</span></td>
							<td><input type="text" placeholder="請輸入地址" name="address" style="color: black;"
								class="form-control"></td>
						</tr>

						<tr>
							<td colspan="2">&nbsp;</td>
						</tr>

						<tr style="color: black;">
							<td>營業時間<span style="margin-left: 3px; font-weight: 800; color: rgb(203, 64, 66);">*</span></td>
							<td><textarea placeholder="請輸入營業時間" name="openTime" rows="3" style="color: black;"
									class="form-control"></textarea></td>
						</tr>
						<tr>
							<td colspan="2">&nbsp;</td>
						</tr>
						<!-- ====================================================== -->
						<tr style="color: black;">
							<td>連絡電話<span style="margin-left: 3px; font-weight: 800; color: rgb(203, 64, 66);">*</span></td>
							<td><input type="text" placeholder="請輸入連絡電話" name="phone" style="color: black;"
								class="form-control"></td>
						</tr>

						<tr>
							<td colspan="2">&nbsp;</td>
						</tr>

						<tr style="color: black;">
							<td>電子郵件</td>
							<td><input type="text" placeholder="請輸入電子郵件" name="email" style="color: black;"
								class="form-control"></td>
						</tr>

						<tr>
							<td colspan="2">&nbsp;</td>
						</tr>

						<tr style="color: black;">
							<td>傳真號碼</td>
							<td><input type="text" placeholder="請輸入傳真號碼" name="fax" style="color: black;"
								class="form-control"></td>
						</tr>

						<tr>
							<td colspan="2">&nbsp;</td>
						</tr>

						<tr style="color: black;">
							<td>Facebook網址</td>
							<td><input type="text" placeholder="請輸入facebook 網址" style="color: black;"
								class="form-control" name="facebook"></td>
						</tr>

						<tr>
							<td colspan="2">&nbsp;</td>
						</tr>

						<tr style="color: black;">
							<td>商店網站網址</td>
							<td><input type="text" placeholder="請輸入網址" name="website" style="color: black;"
								class="form-control"></td>
						</tr>

						<tr>
							<td colspan="2">&nbsp;</td>
						</tr>
						<!-- ====================================================== -->
						
						<tr style="color: black;">
							<td>熱門度</td>
							<td><input type="text" name="clicks" value="0" style="color: black;"
								class="form-control"></td>
						</tr>
						
						<!-- 不使用 ====================================================== -->
						<tr style="display: none">
							<td>會員帳號</td>
							<td><input type="hidden" name="memberId" value="1"></td>
						</tr>
						<tr style="display: none;">
							<td>縣市名*</td>
							<td><input type="text" placeholder="請輸入縣市名" name="cityName" style="color: black;"
								value="台北市" class="form-control"></td>
						</tr>
						<tr style="color: black;">
							<td>Image<span style="margin-left: 3px; font-weight: 800; color: rgb(203, 64, 66);">*</span></td>
							<td><input type="text" placeholder="請輸入圖片網址" name="image" style="color: black;" value="http://cloud.culture.tw/e_upload_ccacloud/ccacloud/image/A0/B0/C0/D2/E309/F143/19ca9b05-7c06-43b7-8bf1-b1558133eeb5.jpg"
								class="form-control"></td>
						</tr>
					</tbody>
				</table>
			</div>
			<br>
			<div class="back" align="center">
				<div class="submitButton">
					<input type="submit" class='btn btn-info' name="submit"
						style="font-size: larger" value="建立藝文商店資料">
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