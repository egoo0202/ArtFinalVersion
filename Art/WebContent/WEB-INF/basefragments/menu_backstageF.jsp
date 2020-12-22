<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- Sidebar -->
<ul class="navbar-nav bg-gradient-info sidebar sidebar-dark accordion"
	id="accordionSidebar">

	<!-- Sidebar - Brand -->
	<a
		class="sidebar-brand d-flex align-items-center justify-content-center"
		href="<c:url value='/35/returnHomePageF'/>"> <svg width="1.25em"
			height="1.25em" viewBox="0 0 16 16" class="bi bi-flower2"
			fill="currentColor" xmlns="http://www.w3.org/2000/svg">
  <path fill-rule="evenodd"
				d="M8 16a4 4 0 0 0 4-4 4 4 0 0 0 0-8 4 4 0 0 0-8 0 4 4 0 1 0 0 8 4 4 0 0 0 4 4zm3-12a3 3 0 0 0-6 0c0 .073.01.155.03.247.544.241 1.091.638 1.598 1.084A2.987 2.987 0 0 1 8 5c.494 0 .96.12 1.372.331.507-.446 1.054-.843 1.598-1.084.02-.092.03-.174.03-.247zm-.812 6.052A2.99 2.99 0 0 0 11 8a2.99 2.99 0 0 0-.812-2.052c.215-.18.432-.346.647-.487C11.34 5.131 11.732 5 12 5a3 3 0 1 1 0 6c-.268 0-.66-.13-1.165-.461a6.833 6.833 0 0 1-.647-.487zm-3.56.617a3.001 3.001 0 0 0 2.744 0c.507.446 1.054.842 1.598 1.084.02.091.03.174.03.247a3 3 0 1 1-6 0c0-.073.01-.155.03-.247.544-.242 1.091-.638 1.598-1.084zm-.816-4.721A2.99 2.99 0 0 0 5 8c0 .794.308 1.516.812 2.052a6.83 6.83 0 0 1-.647.487C4.66 10.869 4.268 11 4 11a3 3 0 0 1 0-6c.268 0 .66.13 1.165.461.215.141.432.306.647.487zM8 9a1 1 0 1 1 0-2 1 1 0 0 1 0 2z" />
</svg>

		<div class="sidebar-brand-text mx-3">
			得藝的一天 <sup>後台</sup>
		</div>
	</a>

	<!-- Divider -->
	<hr class="sidebar-divider my-0">

	<!-- Nav Item - Dashboard -->
	<li class="nav-item h5"><a class="nav-link"
		href="<c:url value='/adminEnterBackstage'/>"> <i
			class="fa fa-tachometer" aria-hidden="true"></i> <span
			style="font-size: medium;">主控台</span></a></li>
	<li class="nav-item h5"><a class="nav-link"
		href="<c:url value='/adminLeaveBackstage' />"> <i
			class="fa fa-tachometer" aria-hidden="true"></i> <span
			style="font-size: medium;">返回得藝的一天前台</span></a></li>

	<!-- 	<!-- Divider -->
	<!-- 	<hr class="sidebar-divider"> -->

	<!-- Divider -->
	<hr class="sidebar-divider">

	<!-- Heading -->
	<div class="sidebar-heading">
		<h5>功能列表</h5>
	</div>
	<!-- Nav Item - Utilities Collapse Menu -->
	<li class="nav-item"><a class="nav-link collapsed" href="#"
		data-toggle="collapse" data-target="#collapseUtilities"
		aria-expanded="true" aria-controls="collapseUtilities"> <i
			class="fas fa-users"></i> <span>網站會員資料管理</span>
	</a>
		<div id="collapseUtilities" class="collapse"
			aria-labelledby="headingUtilities" data-parent="#accordionSidebar">
			<div class="bg-white py-2 collapse-inner rounded">
				<h6 class="collapse-header">會員資訊列表:</h6>
				<a class="collapse-item"
					href="<c:url value='/35/memberEntry.ctrl' />">修改會員資訊</a>
			</div>
		</div></li>

	<!-- Nav Item - 一般功能 Menu -->
	<!-- 票務相關 -->
	<li class="nav-item"><a class="nav-link collapsed" href="#"
		data-toggle="collapse" data-target="#collapsePages"
		aria-expanded="true" aria-controls="collapsePages"> <i
			class="fa fa-ticket" aria-hidden="true"></i> <span>票務服務</span>
	</a>
		<div id="collapsePages" class="collapse"
			aria-labelledby="headingPages" data-parent="#accordionSidebar">
			<div class="bg-white py-2 collapse-inner rounded">
				<div class="collapse-divider"></div>
				<h6 class="collapse-header">活動修改:</h6>
				<a class="collapse-item"
					href="<c:url value='/04/CMS/Category.ctrl?category=1' />">活動查詢</a>
				<a class="collapse-item" href="<c:url value='/04/CMS/insert'/>">活動新增</a>
				<a class="collapse-item"
					href="<c:url value='/04/CMS/Category.ctrl?category=1' />">活動下架</a>
				<h6 class="collapse-header">票務修改:</h6>
				<a class="collapse-item"
					href="<c:url value='/04/Cms/SearchOrder.ctrl' />">票券訂單查詢</a> <a
					class="collapse-item"
					href="<c:url value='/04/Cms/SearchOrder.ctrl' />">票券訂單刪除</a>
				<h6 class="collapse-header">座位修改:</h6>
				<a class="collapse-item"
					href="<c:url value='/04/CMS/Category.ctrl?category=1' />">活動座位查詢</a>
				<a class="collapse-item"
					href="<c:url value='/04/CMS/Category.ctrl?category=1' />">座位修改</a>
			</div>
		</div></li>

	<!-- 洋行相關 -->
	<li class="nav-item"><a class="nav-link collapsed" href="#"
		data-toggle="collapse" data-target="#collapsePages2"
		aria-expanded="true" aria-controls="collapsePages"> <i
			class="fas fa-gifts"></i> <span>商城服務</span>
	</a>
		<div id="collapsePages2" class="collapse"
			aria-labelledby="headingPages" data-parent="#accordionSidebar">
			<div class="bg-white py-2 collapse-inner rounded">

				<h6 class="collapse-header">訂單修改:</h6>
				<a class="collapse-item"
					href="<c:url value='/14/ShowAllOrderList.ctrl' />">訂單刪除</a> <a
					class="collapse-item"
					href="<c:url value='/14/ShowAllOrderList.ctrl' />">訂單編輯</a>
				<div class="collapse-divider"></div>

				<h6 class="collapse-header">商品編輯:</h6>
				<a class="collapse-item" href="<c:url value='/14/Create.ctrl' />">商品上架</a>
				<a class="collapse-item" href="<c:url value='/14/CRUD.ctrl' />">商品下架</a>
				<a class="collapse-item" href="<c:url value='/14/CRUD.ctrl' />">修改商品內容</a>

				<h6 class="collapse-header">商城留言板管理:</h6>
				<a class="collapse-item"
					href="<c:url value='/14/ShowAllMessageBoardList.ctrl' />">留言管理</a>
				<a class="collapse-item"
					href="<c:url value='/14/ShowAllMessageBoardList.ctrl' />">留言編輯</a>
				<div class="collapse-divider"></div>
			</div>
		</div></li>

	<!-- 得藝食堂 -->
	<li class="nav-item"><a class="nav-link collapsed" href="#"
		data-toggle="collapse" data-target="#collapsePages3"
		aria-expanded="true" aria-controls="collapsePages"> <i
			class="fas fa-store"></i> <span>得藝食堂服務</span>
	</a>
		<div id="collapsePages3" class="collapse"
			aria-labelledby="headingPages" data-parent="#accordionSidebar">
			<div class="bg-white py-2 collapse-inner rounded">
				<div class="collapse-divider"></div>
				<h6 class="collapse-header">營業相關設定:</h6>
				<a class="collapse-item"
					href="<c:url value='/03/cms/restaurant/restaurantManagement'/>">營業時間管理</a>
				<div class="collapse-divider"></div>
				<h6 class="collapse-header">訂位服務管理:</h6>
				<a class="collapse-item"
					href="<c:url value='/03/cms/reservation/reservationIndex.ctrl'/>">食堂訂位管理</a>
			</div>
		</div></li>

	<!-- 藝文商店服務 -->
	<li class="nav-item"><a class="nav-link collapsed" href="#"
		data-toggle="collapse" data-target="#collapsePages31"
		aria-expanded="true" aria-controls="collapsePages"> <i
			class="fas fa-store"></i> <span>藝文商店服務</span>
	</a>
		<div id="collapsePages31" class="collapse"
			aria-labelledby="headingPages" data-parent="#accordionSidebar">
			<div class="bg-white py-2 collapse-inner rounded">
				<div class="collapse-divider"></div>
				<h6 class="collapse-header">商店管理:</h6>
				<a class="collapse-item"
					href="<c:url value='/03/cms/shop/createConfirm.ctrl'/>">上架藝文商店</a>
				<a class="collapse-item"
					href="<c:url value='/03/cms/shop/index.ctrl'/>">藝文商店管理</a>
			</div>
		</div></li>


	<!-- 吟遊詩人 -->
	<li class="nav-item"><a class="nav-link collapsed" href="#"
		data-toggle="collapse" data-target="#collapsePages4"
		aria-expanded="true" aria-controls="collapsePages"> <i
			class="fas fa-person-booth"></i> <span>街頭藝人服務</span>
	</a>
		<div id="collapsePages4" class="collapse"
			aria-labelledby="headingPages" data-parent="#accordionSidebar">
			<div class="bg-white py-2 collapse-inner rounded">
				<h6 class="collapse-header">尋找藝人:</h6>
				<a class="collapse-item"
					href="<c:url value='/myStreetArtistPage.ctrl'/>">總覽</a> <a
					class="collapse-item" href="<c:url value='/GoSearch.ctrl'/>">搜尋</a>
				<a class="collapse-item" href="<c:url value='/GoCreate.ctrl'/>">藝人上架</a>
				<a class="collapse-item" href="<c:url value='/GoDel.ctrl'/>">藝人下架</a>
				<div class="collapse-divider"></div>

			</div>
		</div></li>

	<!-- 課程功能 -->
	<li class="nav-item"><a class="nav-link collapsed" href="#"
		data-toggle="collapse" data-target="#collapsePages5"
		aria-expanded="true" aria-controls="collapsePages"> <i
			class="fas fa-chalkboard-teacher"></i> <span>藝術課程服務</span>
	</a>
		<div id="collapsePages5" class="collapse"
			aria-labelledby="headingPages" data-parent="#accordionSidebar">
			<div class="bg-white py-2 collapse-inner rounded">
				<!-- 				<h6 class="collapse-header">我要上課:</h6> -->
				<!-- 				<a class="collapse-item" href="#">已購買課程</a> <a class="collapse-item" -->
				<!-- 					href="#">修改已購買課程</a> <a class="collapse-item" href="#">刪除已購買課程</a> -->
				<!-- 				<div class="collapse-divider"></div> -->
				<h6 class="collapse-header">我要開課:</h6>
				<a class="collapse-item" href="<c:url value='/18/cSelectAll.ctrl'/>">課程總覽</a>
				<a class="collapse-item" href="<c:url value='/18/insertData.ctrl'/>">課程上架</a>
				<%-- <a class="collapse-item" href="<c:url value='/18/UpdateData.ctrl'/>">修改課程資料</a> --%>
			</div>
		</div></li>

	<li class="nav-item"><a class="nav-link collapsed" href="#"
		data-toggle="collapse" data-target="#collapsePages6"
		aria-expanded="true" aria-controls="collapseUtilities"> <i
			class="fas fa-fw fa-chart-area"></i> <span>藝文場地管理</span>
	</a>
		<div id="collapsePages6" class="collapse"
			aria-labelledby="headingPages" data-parent="#accordionSidebar">
			<div class="bg-white py-2 collapse-inner rounded">
				<h6 class="collapse-header">場地資訊列表:</h6>
				<a class="collapse-item" href="<c:url value='/35/selectAll.ctrl' />">修改租借場地資訊</a>
			</div>
		</div></li>

	<li class="nav-item"><a class="nav-link"
		href="<c:url value='/14/showAltartCenterCRUD' />"> <i
			class="fas fa-fw fa-table"></i> <span>訊息通知中心</span></a></li>

	<!-- Nav Item - Charts -->
	<li class="nav-item"><a class="nav-link"
		href="<c:url value='/35/chatCenterEntry' />"> <i
			class="fas fa-fw fa-chart-area"></i> <span>客服中心</span></a></li>


	<!-- Divider -->
	<hr class="sidebar-divider d-none d-md-block">

	<!-- Sidebar Toggler (Sidebar) -->
	<div class="text-center d-none d-md-inline">
		<button class="rounded-circle border-0" id="sidebarToggle"></button>
	</div>

</ul>
<!-- End of Sidebar -->