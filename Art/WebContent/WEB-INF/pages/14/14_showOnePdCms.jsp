<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>


<div class="container">
	<div class="card mb-3 "
		style="max-width: 800px; margin: auto; margin-top: 10px;">
		<div class="row no-gutters">
			<div class="col-md-4">
				<img
					src="${pageContext.servletContext.contextPath}/14/getBlobImage/${ap.productId}.ctrl"
					class="card-img" alt="...">
			</div>
			<div class="col-md-8">
				<div class="card-body">
					<FORM ACTION="SubmitProcess.ctrl">
						<h4 class="card-title">${ap.productTitle}</h4>
						<%--                             <p class="card-text">${oneProsuct.productId}</p> --%>

						<p class="card-text">
							<fmt:formatNumber value="${ap.productPrice}" type="number" />
							元
						</p>

						<p class="card-text">
							庫存數:
							<fmt:formatNumber value="${ap.productNum}" type="number" />

						</p>
						
						<p class="card-text">
							商品分類:
							${ap.productType} &nbsp&nbsp
							子分類:
							${ap.productSubType}
						</p>


						<hr>
						<p class="card-text" style="font-size: x-large">
							<small class="text-muted">${ap.productDes}</small>
						</p>

					</form>
				</div>
				
			</div>
		</div>
		</div>
		</div>
			<div class="container" style="text-align: center">
				<button type="button" class="btn btn-info btn-sm" value="" onclick="location.href='<c:url value='/14/CRUD.ctrl' />'">返回列表</button>
			</div>
		<br>