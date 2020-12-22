<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
         <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Vue.js -->
<script src="https://cdn.jsdelivr.net/npm/vue@2.6.12/dist/vue.js"></script>
<style>
.badge {
  padding-left: 9px;
  padding-right: 9px;
  -webkit-border-radius: 9px;
  -moz-border-radius: 9px;
  border-radius: 9px;
}

.label-warning[href],
.badge-warning[href] {
  background-color: #c67605;
}
#lblCartCount {
    font-size: 5px;
    background: #ff0000;
    color: #fff;
    padding: 0 3px;
    vertical-align: top;
    margin-left: -10px; 
}


</style>

<body>


<header id="header" id="home"
		style="font-family: cwTeXFangSong, serif;">

		<div class="container header-top" id="app2">
			<div class="row">
				<div class="col-6 top-head-left">
					<ul>
						<li class="nav-item"><a class=""
						href="<c:url value='/35/personelInfoEntry.ctrl'/>"><img style='display:block; width:30px;height:20px;'
						src="data:image/jpg;base64, ${sessionScope.memberPic}" ></a></li>
						<li><a href="<c:url value='/adminEnterMemberArea'/>">你好！ ${sessionScope.member.getName()}</a></li>
						<li><a href="<c:url value='/userEnterMemberArea'/>">會員專區</a></li>
						<li><a href="<c:url value='/35/logoutProcess'/>">登出</a></li>
					</ul>
				</div>
				<div class="col-6 top-head-right">
					<ul>
						<li><a href="#"><i class="fa fa-facebook"></i></a></li>
						<li><a href="#"><i class="fa fa-twitter"></i></a></li>
						<li><a href="<c:url value='/04/goshoppingcart.ctrl' />"><i class="fas fa-ticket-alt" style="font-size:13px"></i></a>
						<i class='badge badge-warning' id='lblCartCount'><%=pageContext.getSession().getAttribute("shoppingcartnum") %></i></li>
						<li><a href="<c:url value='/14/gotoCart.ctrl' />"><i class="fas fa-shopping-cart" style="font-size:13px"></i></a>
						<i class='badge badge-warning' id='lblCartCount'>  {{shopCart}} </i></li>
					</ul>
				</div>
			</div>
		</div>
		<hr>
		<div class="container">
			<div class="row align-items-center justify-content-between d-flex">
				<div id="logo">
					<a href="<c:url value='/index.html' />"><img
						src="<c:url value='/frontstyle/img/aaart.png'/>" alt="" title="" style='display:block; width:230px;height:40px;'/></a>
				</div>
				<nav id="nav-menu-container">
					<ul class="nav-menu">
						<li class="#"><a href="<c:url value='/index.html' />">首頁</a></li>
							<li class=""><a href="<c:url value='/14/scroller' />">得藝洋行</a>
							<ul>
								<li class="menu-has-children"><a
									style="font-size: 15px; font-weight: 1000;"
									href="<c:url value='/14/scroller?query=配件飾品' />">配件飾品</a>
									<ul>
										<li><a style="font-size: 15px; font-weight: 1000;"
											href="<c:url value='/14/scroller?query=戒指' />">戒指</a></li>
										<li><a style="font-size: 15px; font-weight: 1000;"
											href="<c:url value='/14/scroller?query=耳環' />">耳環</a></li>
										<li><a style="font-size: 15px; font-weight: 1000;"
											href="<c:url value='/14/scroller?query=項鍊' />">項鍊</a></li>
										<li><a style="font-size: 15px; font-weight: 1000;"
											href="<c:url value='/14/scroller?query=眼鏡' />">眼鏡</a></li>
									</ul></li>
								<li><a style="font-size: 15px; font-weight: 1000;"
									href="<c:url value='/14/scroller?query=居家生活' />">居家生活</a>
									<ul>
										<li><a style="font-size: 15px; font-weight: 1000;"
											href="<c:url value='/14/scroller?query=家飾布置' />">家飾布置</a></li>
										<li><a style="font-size: 15px; font-weight: 1000;"
											href="<c:url value='/14/scroller?query=生活用品' />">生活用品</a></li>
										<li><a style="font-size: 15px; font-weight: 1000;"
											href="<c:url value='/14/scroller?query=收納雜貨' />">收納雜貨</a></li>
									</ul></li>
								<li><a style="font-size: 15px; font-weight: 1000;"
									href="<c:url value='/14/scroller?query=文具書籍' />">文具書籍</a>
									<ul>
										<li><a style="font-size: 15px; font-weight: 1000;"
											href="<c:url value='/14/scroller?query=文書用品' />">文書用品</a></li>
										<li><a style="font-size: 15px; font-weight: 1000;"
											href="<c:url value='/14/scroller?query=書籍周邊' />">書籍周邊</a></li>
									</ul></li>
							</ul></li>
						<li><a href="<c:url value='/03/front/reservation/onlineBooking.ctrl' />">得藝食堂</a></li>
						<li><a href="<c:url value='/03/index/shop/index.ctrl' />">找商店</a></li>
						<li><a href="<c:url value='/userStreetArtistPage.ctrl' />">找藝人</a></li>
						<li><a href="<c:url value='/18/cSelectAllFront.ctrl' />">找課程</a></li>
						<li><a href="<c:url value='/35/routePlanningEntry' />">藝同去郊遊</a></li>
						<li><a href="<c:url value='/35/randomRecom.ctrl' />">離我最近的活動</a></li>
						<li><a href="<c:url value='/35/chatRoomEntry' />">客服</a></li>
<!-- 						<li class="menu-has-children"><a href="">Pages</a> -->
<!-- 							<ul> -->
<!-- 								<li><a href="#">Blog Single</a></li> -->
<!-- 								<li><a href="#">Category</a></li> -->
<!-- 								<li><a href="#">Elements</a></li> -->
<!-- 							</ul></li> -->
					</ul>
				</nav>
				<!-- #nav-menu-container -->
			</div>
		</div>
	</header>
	<script>
        var vm2 = new Vue({
        	el:'#app2',
        	data(){
        		return {
            		
					shopCart:0
        		}
	    	},

            	mounted: function(){
      	          var self = this;
      	          $.ajax({
      	              type:"get",
      	              url:"/Art/14/getShopCartSize",    
//       	              contentType: "application/json",
      	              dataType:"text",
      	              success:function(value){
      	              	self.shopCart = value;
      	              	
      	              },
      	              error:function(){
      	                  alert("整組壞光光 at mounted: getShopCartSize");
      	              }
      	          });

      	        
      	      }

        	})

        $(document).ready(function () {
            var self = vm2;
            var clock = setInterval(sum , 3000);
           

            
        })
        
        function sum(){
	  var self = vm2;
	  $.ajax({
          type:"get",
          url:"/Art/14/getShopCartSize",    
//           contentType: "application/json",
          dataType:"text",
          success:function(value){
          	self.shopCart = value;
          	
          },
          error:function(){
              alert("整組壞光光 at topBar: getShopCartSize");
          }
      });
        }
        </script>	
</body>