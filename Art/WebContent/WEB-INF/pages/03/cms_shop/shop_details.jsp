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
					value="返回 藝文商店管理首頁">
			</div>
		</form>
	</div>
	<div class=title>
		<h3 align="center" style="margin-top: 20px; font-weight: bold;">藝文商店詳細資訊</h3>
	</div>

	<div class=content>
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
						<c:forEach items="${acShopsList}" var="acShopsList" varStatus="vs">
							<tr style="color: black;">
								<td>商店編號<span
									style="margin-left: 3px; font-weight: 800; color: rgb(203, 64, 66);">*</span></td>
								<td><textarea class="form-control" readonly="readonly"
										style="background: #FFFFFF; color: black;" rows="1">${acShopsList.shopId}</textarea>
								</td>
							</tr>
							<tr>
								<td colspan="2">&nbsp;</td>
							</tr>
							<!-- ====================================================== -->
							<tr style="color: black;">
								<td>商店名稱<span
									style="margin-left: 3px; font-weight: 800; color: rgb(203, 64, 66);">*</span></td>
								<td><textarea class="form-control" readonly="readonly"
										style="background: #FFFFFF; color: black;" rows="1">${acShopsList.shopName}</textarea>
								</td>
							</tr>
							<tr>
								<td colspan="2">&nbsp;</td>
							</tr>
							<tr style="color: black;">
								<td>代表圖示<span
									style="margin-left: 3px; font-weight: 800; color: rgb(203, 64, 66);">*</span></td>
								<td><textarea class="form-control" readonly="readonly"
										style="background: #FFFFFF; color: black;" rows="1">${acShopsList.image}</textarea>
								</td>
							</tr>
							<tr>
								<td colspan="2">&nbsp;</td>
							</tr>
							<tr style="color: black;">
								<td>商店簡介<span
									style="margin-left: 3px; font-weight: 800; color: rgb(203, 64, 66);">*</span></td>
								<td><textarea class="form-control" readonly="readonly"
										style="background: #FFFFFF; color: black;" rows="5">${acShopsList.intro}</textarea>
								</td>
							</tr>
							<tr>
								<td colspan="2">&nbsp;</td>
							</tr>
							<tr style="color: black;">
								<td>商店地址<span
									style="margin-left: 3px; font-weight: 800; color: rgb(203, 64, 66);">*</span></td>
								<td><textarea class="form-control" readonly="readonly"
										style="background: #FFFFFF; color: black;" rows="1">${acShopsList.address}</textarea>
								</td>
							</tr>
							<tr>
								<td colspan="2">&nbsp;</td>
							</tr>
							<tr style="color: black;">
								<td>營業時間<span
									style="margin-left: 3px; font-weight: 800; color: rgb(203, 64, 66);">*</span></td>
								<td><textarea class="form-control" readonly="readonly"
										style="background: #FFFFFF; color: black;" rows="3">${acShopsList.openTime}</textarea></td>
							</tr>
							<tr>
								<td colspan="2">&nbsp;</td>
							</tr>
							<!-- ====================================================== -->
							<tr style="color: black;">
								<td>連絡電話<span
									style="margin-left: 3px; font-weight: 800; color: rgb(203, 64, 66);">*</span></td>
								<td><textarea class="form-control" readonly="readonly"
										style="background: #FFFFFF; color: black;" rows="1">${acShopsList.phone}</textarea></td>
							</tr>
							<tr>
								<td colspan="2">&nbsp;</td>
							</tr>
							<tr style="color: black;">
								<td>電子郵件<span
									style="margin-left: 3px; font-weight: 800; color: rgb(203, 64, 66);">*</span></td>
								<td><textarea class="form-control" readonly="readonly"
										style="background: #FFFFFF; color: black;" rows="1">${acShopsList.email}</textarea>



								</td>
							</tr>
							<tr>
								<td colspan="2">&nbsp;</td>
							</tr>
							<c:if test="${acShopsList.fax != null}">
								<tr style="color: black;">
									<td>傳真號碼</td>
									<td><textarea class="form-control" readonly="readonly"
											style="background: #FFFFFF; color: black;" rows="1">${acShopsList.fax}</textarea>
									</td>
								</tr>
							</c:if>
							<c:if test="${acShopsList.fax == null}">
								<tr style="color: black;">
									<td>傳真號碼</td>
									<td><textarea class="form-control" readonly="readonly"
											style="background: #FFFFFF; color: black;" rows="1">暫無資料</textarea>
									</td>
								</tr>
							</c:if>

							<tr>
								<td colspan="2">&nbsp;</td>
							</tr>
							<tr style="color: black;">
								<td>Facebook連結</td>
								<td><textarea class="form-control" readonly="readonly"
										style="background: #FFFFFF; color: black;" rows="1">${acShopsList.facebook}</textarea>
								</td>
							</tr>
							<tr>
								<td colspan="2">&nbsp;</td>
							</tr>
							<tr style="color: black;">
								<td>商店網站連結</td>
								<td><textarea class="form-control" readonly="readonly"
										style="background: #FFFFFF; color: black;" rows="1">${acShopsList.website}</textarea>
								</td>
							</tr>
							<tr>
								<td colspan="2">&nbsp;</td>
							</tr>
							<!-- ====================================================== -->
							<tr style="color: black;">
								<td>熱門度</td>
								<td><textarea class="form-control" readonly="readonly"
										style="background: #FFFFFF; color: black;" rows="1">${acShopsList.clicks}</textarea>
								</td>
							</tr>
							<!-- ====================================================== -->
						</c:forEach>
					</c:if>
				</tbody>
			</table>
			<br>
			<c:if test="${acShopsSerachMsg != null}">
				<div align="center" style="font-size: larger">${acShopsSerachMsg}</div>
				<br>
			</c:if>
			<br>
		</div>
	</div>
</div>
<!-- ====================================================== -->


