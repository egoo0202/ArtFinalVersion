<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://unpkg.com/@webcreate/infinite-ajax-scroll/dist/infinite-ajax-scroll.min.js"></script>
<title>Insert title here</title>
</head>
<body>
<h3>測試</h3>
<div class="surface-container">
  <div class="container-a" id="sss">
    <!-- items will be inserted here by javascript -->
  </div>
  <script src="<c:url value='/js14/index.js' />"></script>
<%-- <%@include file="/WEB-INF/pages/14/js14/scrollerJS.jsp" %> --%>
</div>
<script>
function nextHandler(pageIndex) {
	$.ajax({
		type: "get",
		url: "/Art/14/indexShopHot",
		contentType: "application/json",
		dataType: "json",
		success: function(value) {
			alert(value[0].productTitle)
			self.pages = value;
			let frag = document.createDocumentFragment();

			let itemsPerPage = 3;
			let totalPages = Math.ceil(value.length / itemsPerPage);
			let offset = pageIndex * itemsPerPage;

			// walk over the movie items for the current page and add them to the fragment
			for (let i = offset, len = offset + itemsPerPage; i < len; i++) {
				let movie = value[i];
				alert("第"+ i+ "個")
				let item = createMovieItem(movie);

				frag.appendChild(item);
			}

			let hasNextPage = pageIndex < totalPages - 1;

			return $('#sss').append(Array.from(frag.childNodes))
				// indicate that there is a next page to load
				.then(() => hasNextPage);

		},
		error: function() {
			alert("failure at initPageList()");
		}
	});
}

window.ias = new InfiniteAjaxScroll('.container-a', {
	item: '.item',
	next: nextHandler,
	pagination: false,
});
</script>
</body>
</html>