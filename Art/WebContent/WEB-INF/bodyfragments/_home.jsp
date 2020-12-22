 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div style="padding:7% 8% 15% 8%;">
<div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
  <ol class="carousel-indicators">
    <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
    <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
    <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
  </ol>
  <div class="carousel-inner">
    <div class="carousel-item active">
      <img src="<c:url value='/images/slidepic.jpg' />" class="d-block w-100" alt="...">
    </div>
    <div class="carousel-item">
      <img src="<c:url value='/images/slidepic3.jpg' />" class="d-block w-100" alt="...">
    </div>
    <div class="carousel-item">
      <img src="<c:url value='/images/slidepic6.jpg' />" class="d-block w-100" alt="...">
    </div>
    <div class="carousel-item">
      <img src="<c:url value='/images/slidepic7.jpg' />" class="d-block w-100" alt="...">
    </div>
  </div>
  <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
    <span class="sr-only">Previous</span>
  </a>
  <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
    <span class="carousel-control-next-icon" aria-hidden="true"></span>
    <span class="sr-only">Next</span>
  </a>
</div>
</div>