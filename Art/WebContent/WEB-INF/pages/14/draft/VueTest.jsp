<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>



<script src="https://cdn.jsdelivr.net/npm/vue@2.6.12"></script>
<!-- import CSS -->
<link rel="stylesheet" href="https://unpkg.com/element-ui/lib/theme-chalk/index.css">
</head>

<body>
 <!-- import Vue before Element -->
  <script src="https://unpkg.com/vue/dist/vue.js"></script>
  <!-- import JavaScript -->
  <script src="https://unpkg.com/element-ui/lib/index.js"></script>

<!-- start banner Area -->
			<section class="banner-area relative" id="home">	
				<div class="overlay overlay-bg"></div>
				<div class="container">
					<div class="row d-flex align-items-center justify-content-center">
						<div class="about-content col-lg-12">
							<h1 class="text-white">
								AAART Shop
							</h1>	
							<p class="text-white link-nav"><a href="index.html">Home </a>  <span class="lnr lnr-arrow-right"></span>  <a href="<c:url value='/14/shopListController.ctrl' />"> Shop</a></p>
						</div>											
					</div>
				</div>
			</section>
	<!-- End banner Area -->	

<div id="app">
    <el-button @click="visible = true">Button</el-button>
    <el-dialog :visible.sync="visible" title="Hello world">
      <p>Try Element</p>
    </el-dialog>
    
  </div>
  
 <h1>恭喜你來到這裡</h1>
 <h3>${a}</h3>
<div id="appp">
<ul v-for="item in items">
<li>
<el-rate
  v-model="item.productScore" 
  disabled
  show-score
  text-color="#ff9900"
  v-bind:score-template=value>
</el-rate>
</li>
</ul>  
</div>
 
 
 


  
<!-- <div id = "data"> -->
      
<!--          <ul> -->
<!--             <template v-for="item in items"> -->
<!--                 <li>PlateNumb: {{ item.productTitle }}, RouteUID: {{ item.productScore }}</li> -->
<!--             </template> -->
<!--         </ul> -->
 
<!-- </div> -->
  
</body>

  <script>
//     new Vue({
//       el: '#app',
//       data: function() {
//         return { visible: false }
//       }
//     })
  </script>
  
  
  
<script>
var appp = new Vue({
    el: '#appp',
    data() {
        return {
        	items: ""
        }
      },
      mounted: function(){
          var self = this;
          var apid = $("#productID").val();
          $.ajax({
              type:"get",
              url:"/Art/14/jsonTest/10.ctrl",    
              contentType: "application/json",
              dataType:"json",
              success:function(json){
              	self.items = json;
              },
              error:function(){
                  alert("failure");
              }
          });
      }


      
  })
 
$(document).ready(function () {
	
    var loading = false;
    
    $(window).scroll(function () {
    	
        if ((($(window).scrollTop() + $(window).height()) + 250) >= $(document).height()) {
            if (loading == false) {
                loading = true;
                // 			$('#loadingBar').css("display","block");
                $.get("${pageContext.servletContext.contextPath}/14/trytrysee", function (loaded) {
                    $('body').append(loaded);
                    // 				$('#loadingBar').css("display","none");
                    loading = false;
                });

            }

        }

    })



})
 
</script>


<script>
//         new Vue({
//             el: "#data",
//             data(){
//                 return {
//                     items: ""
//                 }
//             },
//             created: function(){
//                 var self = this;
//                 $.ajax({
//                     type:"get",
//                     url:"/Art/14/jsonTest/10.ctrl",    
//                     contentType: "application/json",
//                     dataType:"json",
//                     success:function(json){
//                     	self.items = json;
//                     },
//                     error:function(){
//                         alert("failure");
//                     }
//                 });
//             }
//         })
</script>


<script>
//  $.ajax({
//    method: 'GET',
//    url: '/Art/14/jsonTest/10.ctrl',
//    dataType: 'json',
//    success: function(json) {
//      console.log(json);
//      console.log(json[0].productScore);
//   }
//  });
 </script>




</html>