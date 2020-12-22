<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

			<div class="row">
				<c:forEach var='pdList' items='${pList}' varStatus="vs">
				<input type="hidden" id="${pdList.productId}" value="${pdList.productId}"/>
				<input type="hidden" id="${pdList.productId}productTitle" value="${pdList.productTitle}"/>
				<input type="hidden" id="${pdList.productId}productPrice" value="${pdList.productPrice}"/>
				<input type="hidden" id="${pdList.productId}productNum" value="${pdList.productNum}"/>
					<div class="col-lg-3 col-md-6 single-blog">
						<div class="thumb">
							<img class="img-fluid"
								src="${pageContext.servletContext.contextPath}/14/getBlobImage/${pdList.productId}.ctrl"
								alt="" width="250px" height="250px">
						</div>
						<a
							href="${pageContext.servletContext.contextPath}/14/showOneProduct2.ctrl?productID=${pdList.productId}"><h4>${pdList.productTitle}</h4></a>
						<p>
							售價：
							<fmt:formatNumber value="${pdList.productPrice}" type="number" />
							元
						</p>
						<!-- 					<p class="date" style="margin: 0px; margin-bottom:5px">10 Jan 2018</p>  #F596AA -->
						<div>
							<a
								href="#" onclick="tip(${pdList.productId})"
								class="genric-btn danger-border small"
								style="margin: 0px; margin-bottom: 5px" title="加入購物車"> <i
								class="fas fa-cart-plus" style="font-size: 15px"></i></a> 
								<a
								href="${pageContext.servletContext.contextPath}/14/showOneProduct2.ctrl?productID=${pdList.productId}"
								class="genric-btn info-border small"
								style="margin: 0px; margin-bottom: 5px" title="查看詳情"> <i
								class="fas fa-search" style="font-size: 15px"></i></a>
							<div>
								<img class=""
									src="${pageContext.servletContext.contextPath}/14/getStarImage/${pdList.productId}.ctrl"
									alt="" width="100" height="22">
								<div class="meta-bottom d-flex justify-content-between">
<!-- 									<p class="likes"> -->
<!-- 										<span class="lnr lnr-heart"></span> 15 個人喜歡 -->
<!-- 									</p> -->
									<p class="comments" style="text-align:center">
										<span class="lnr lnr-bubble">&nbsp&nbsp</span>${pdList.productMessage} 則此商品的評論
									</p>
								</div>
							</div>

						</div>
					</div>
				</c:forEach>
			</div>
				<c:if test="${totalPages > pageNo}">
					<button class="genric-btn info-border small" id="btnn" class="btnn"onclick="push()">載入更多</button>
				</c:if>
	<!-- End blog Area -->

