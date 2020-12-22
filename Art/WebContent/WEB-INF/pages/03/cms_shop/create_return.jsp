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
	<br>
	<div class=content>
		<c:if test="${acShopsCreateMsg != null}">
			<div align="center">
				<h3 style="font-weight: bold;">
					藝文商店資料<span style="color: #E83015;">建立成功 </span>
				</h3>
			</div>
			<br>
		</c:if>
		<div align="center">
			<h4>將於5秒後自動返回 藝文商店管理</h4>
		</div>
	</div>
	<br> <br>
</div>
<!-- ====================================================== -->
<script>
	//計時器
	timer = setTimeout('redirect()', 5 * 1000);

	function redirect() {
		//指定跳轉頁面
		window.location.href = "<c:url value='/03/cms/shop/index.ctrl'/>";
	}
</script>