
function createMovieItem(movieData) {
	const template = `<div class="item">
    <a href="#" class="item__link" target="_blank">
      <div class="item__img"><img class="item__img__img" src="#" onerror="this.src='https://placehold.co/185x278'" width="185" height="278"/></div>
      <h1 class="item__title">${movieData.productTitle}</h1>
      <div class="item__year">${movieData.productPrice}</div>
      <div class="item__rating" title="IMDB Rating">${movieData.productPrice}</div>
    </a>
  </div>
  `;

	let item = document.createElement('div');
	item.innerHTML = template.trim();

	return item.firstChild;
}

//function nextHandler(pageIndex) {
//	//  return fetch("/Art/14/indexShopHot")
//	//    .then(response => response.json())
//	//    .then((data) => {
//	//      let frag = document.createDocumentFragment();
//	//
//	//      let itemsPerPage = 8;
//	//      let totalPages = Math.ceil(data.length / itemsPerPage);
//	//      let offset = pageIndex * itemsPerPage;
//	//
//	//      // walk over the movie items for the current page and add them to the fragment
//	//      for (let i = offset, len = offset + itemsPerPage; i < len; i++) {
//	//        let movie = data[i];
//	//
//	//        let item = createMovieItem(movie);
//	//
//	//        frag.appendChild(item);
//	//      }
//	//
//	//      let hasNextPage = pageIndex < totalPages - 1;
//	//
//	//      return this.append(Array.from(frag.childNodes))
//	//        // indicate that there is a next page to load
//	//        .then(() => hasNextPage);
//	//    });
//	$.ajax({
//		type: "get",
//		url: "/Art/14/indexShopHot",
//		contentType: "application/json",
//		dataType: "json",
//		success: function(value) {
//			alert('12')
//			self.pages = value;
//			let frag = document.createDocumentFragment();
//
//			let itemsPerPage = 8;
//			let totalPages = Math.ceil(value.length / itemsPerPage);
//			let offset = pageIndex * itemsPerPage;
//
//			// walk over the movie items for the current page and add them to the fragment
//			for (let i = offset, len = offset + itemsPerPage; i < len; i++) {
//				let movie = value[i];
//
//				let item = createMovieItem(movie);
//
//				frag.appendChild(item);
//			}
//
//			let hasNextPage = pageIndex < totalPages - 1;
//
//			return this.append(Array.from(frag.childNodes))
//				// indicate that there is a next page to load
//				.then(() => hasNextPage);
//
//		},
//		error: function() {
//			alert("failure at initPageList()");
//		}
//	});
//}
//
//window.ias = new InfiniteAjaxScroll('.container-a', {
//	item: '.item',
//	next: nextHandler,
//	pagination: false,
//});
