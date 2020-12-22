<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">

<!-- Mobile Specific Meta -->
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Meta Description -->
<meta name="description" content="">

<!-- Author Meta -->
<meta name="author" content="">


<!-- Favicon-->
<link rel="icon" href="<c:url value='/frontstyle/img/favicon.ico'/>" type="image/x-icon">

<!-- Meta Keyword -->
<meta name="keywords" content="">

<!-- Site Title -->
<title>得藝的一天</title>

<!-- jQuery CDN minifid-->
<script src="https://code.jquery.com/jquery-3.5.1.min.js"
	integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0="
	crossorigin="anonymous"></script>
<!-- jQuery CDN minifid-->
<!-- <script src="https://code.jquery.com/jquery-3.5.1.min.js" integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0=" crossorigin="anonymous"></script> -->

<!-- sweetAlert CDN -->
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>

<!-- 特殊字體、Icon Kit-->
<script src="https://kit.fontawesome.com/23f780069c.js"
	crossorigin="anonymous"></script>
<link
	href="https://fonts.googleapis.com/css?family=Poppins:100,200,400,300,500,600,700"
	rel="stylesheet">
<!--
CSS
============================================= 
<c:url value='/vendor/fontawesome-free/css/all.min.css'/>

-->
<!-- 	<link rel="stylesheet" href="../pages/frontstyle/css/linearicons.css"> -->
<link rel="stylesheet"
	href="<c:url value='/frontstyle/css/linearicons.css'/>">
<!-- 	<link rel="stylesheet" href="../pages/frontstyle/css/font-awesome.min.css"> -->
<link rel="stylesheet"
	href="<c:url value='/frontstyle/css/font-awesome.min.css'/>">
<!-- 	<link rel="stylesheet" href="../pages/frontstyle/css/bootstrap.css"> -->
<link rel="stylesheet"
	href="<c:url value='/frontstyle/css/bootstrap.css'/>">
<!-- 	<link rel="stylesheet" href="../pages/frontstyle/css/magnific-popup.css"> -->
<link rel="stylesheet"
	href="<c:url value='/frontstyle/css/magnific-popup.css'/>">
<!-- 	<link rel="stylesheet" href="../pages/frontstyle/css/nice-select.css"> -->
<link rel="stylesheet"
	href="<c:url value='/frontstyle/css/nice-select.css'/>">
<!-- 	<link rel="stylesheet" href="../pages/frontstyle/css/animate.min.css"> -->
<link rel="stylesheet"
	href="<c:url value='/frontstyle/css/animate.min.css'/>">
<!-- 	<link rel="stylesheet" href="../pages/frontstyle/css/owl.carousel.css"> -->
<link rel="stylesheet"
	href="<c:url value='/frontstyle/css/owl.carousel.css'/>">
<!-- 	<link rel="stylesheet" href="../pages/frontstyle/css/main.css"> -->
<link rel="stylesheet" href="<c:url value='/frontstyle/css/main.css'/>">

<!-- 	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"> -->

<!-- table -->
<link rel="stylesheet" type="text/css"
	href="https://cdn.datatables.net/1.10.22/css/jquery.dataTables.css">
<style>

/* @import url(https://fonts.googleapis.com/earlyaccess/cwtexfangsong.css); */
html {
	font-size: 26px;
}
</style>
</head>
<body>
	<!-- Page Wrapper -->
	<tiles:insertAttribute name="header" />

	<tiles:insertAttribute name="body" />

	<tiles:insertAttribute name="footer" />

	<!-- table -->
	<script type="text/javascript" charset="utf8"
		src="https://cdn.datatables.net/1.10.22/js/jquery.dataTables.js"></script>



</body>
</html>