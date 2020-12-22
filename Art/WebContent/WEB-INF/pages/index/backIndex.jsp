<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.9.4/Chart.min.js" crossorigin="anonymous"></script>




</head>
<body>
 
      <!-- Divider -->
      <hr class="sidebar-divider d-none d-md-block">

      <!-- Sidebar Toggler (Sidebar) -->
      <div class="text-center d-none d-md-inline">
        <button class="rounded-circle border-0" id="sidebarToggle"></button>
      </div>

    </ul>
    <!-- End of Sidebar -->

    <!-- Content Wrapper -->
    <div id="content-wrapper" class="d-flex flex-column"  >

      <!-- Main Content -->
      <div id="content">


        <!-- Begin Page Content -->
        <div class="container-fluid"  id="app2">

          <!-- Page Heading -->
          <div class="d-sm-flex align-items-center justify-content-between mb-4">
            <h1 class="h3 mb-0 text-gray-800">數據一覽</h1>
            <a href="#" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm"><i class="fas fa-download fa-sm text-white-50"></i> 下載報表</a>
          </div>

          <!-- Content Row -->
          <div class="row">

            <!-- Earnings (Monthly) Card Example -->
            <div class="col-xl-3 col-md-6 mb-4">
              <div class="card border-left-primary shadow h-100 py-2">
                <div class="card-body">
                  <div class="row no-gutters align-items-center">
                    <div class="col mr-2">
                      <div class="text-xs font-weight-bold text-primary text-uppercase mb-1">洋行營收</div>
                      <div class="h5 mb-0 font-weight-bold text-gray-800">{{text | money }}</div>
                    </div>
                    <div class="col-auto">
                      <i class="fas fa-file-invoice-dollar fa-2x text-gray-300"></i> 
                    </div>
                  </div>
                </div>
              </div>
            </div>

            <!-- Earnings (Monthly) Card Example -->
            <div class="col-xl-3 col-md-6 mb-4">
              <div class="card border-left-success shadow h-100 py-2">
                <div class="card-body">
                  <div class="row no-gutters align-items-center">
                    <div class="col mr-2">
                      <div class="text-xs font-weight-bold text-success text-uppercase mb-1">活動售票收入</div>
                      <div class="h5 mb-0 font-weight-bold text-gray-800">{{ticketSum | money }}</div>
                    </div>
                    <div class="col-auto">
                      <i class="fas fa-dollar-sign fa-2x text-gray-300"></i>
                    </div>
                  </div>
                </div>
              </div>
            </div>

            <!-- Earnings (Monthly) Card Example -->
            <div class="col-xl-3 col-md-6 mb-4">
              <div class="card border-left-info shadow h-100 py-2">
                <div class="card-body">
                  <div class="row no-gutters align-items-center">
                    <div class="col mr-2">
                      <div class="text-xs font-weight-bold text-info text-uppercase mb-1">距離註冊會員數達 100 人還差</div>
                      <div class="row no-gutters align-items-center">
                        <div class="col-auto">
                          <div class="h5 mb-0 mr-3 font-weight-bold text-gray-800">{{100-member}} 位</div>
                        </div>
                        <div class="col">
                          <div class="progress progress-sm mr-2">
                            <div class="progress-bar bg-info" role="progressbar" :style="{width: memberPcen}" aria-valuenow="10" aria-valuemin="0" aria-valuemax="100"></div>
                          </div>
                        </div>
                      </div>
                    </div>
                    <div class="col-auto">
                      <i class="fas fa-users fa-2x text-gray-300"></i>
                    </div>
                  </div>
                </div>
              </div>
            </div>

            <!-- Pending Requests Card Example -->
            <div class="col-xl-3 col-md-6 mb-4">
              <div class="card border-left-warning shadow h-100 py-2">
                <div class="card-body">
                  <div class="row no-gutters align-items-center">
                    <div class="col mr-2">
                      <div class="text-xs font-weight-bold text-warning text-uppercase mb-1">餐廳預約總筆數</div>
                      <div class="h5 mb-0 font-weight-bold text-gray-800">{{ResturantOrder}} 筆</div>
                    </div>
                    <div class="col-auto">
                      <i class="fas fa-comments fa-2x text-gray-300"></i>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>

          <!-- Content Row -->

          <div class="row">

            <!-- Area Chart -->
            <div class="col-xl-7 col-lg-7">
              <div class="card shadow mb-4">
                <!-- Card Header - Dropdown -->
                <div class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
                  <h6 class="m-0 font-weight-bold text-primary">各入口點擊率</h6>
                  <div class="dropdown no-arrow">
                    <a class="dropdown-toggle" href="#" role="button" id="dropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                      <i class="fas fa-ellipsis-v fa-sm fa-fw text-gray-400"></i>
                    </a>
                    <div class="dropdown-menu dropdown-menu-right shadow animated--fade-in" aria-labelledby="dropdownMenuLink">
                      <div class="dropdown-header">請選擇欲察看之區間:</div>
                      <a class="dropdown-item" href="#" id="barNow">本日</a>
                      <a class="dropdown-item" href="#" id="barMonth">本月</a>
                      <div class="dropdown-divider"></div>
                      <a class="dropdown-item" href="#" id="barYear">本年度</a>
                    </div>
                  </div>
                </div>
                <!-- Card Body -->
                <div class="card-body">
                  <div class="chart-area">
<%--                     <canvas id="myAreaChart"></canvas> --%>
                    <canvas id="myChart" width="400" height="150"></canvas>
                  </div>
                </div>
              </div>
            </div>

            <!-- Pie Chart -->
            <div class="col-xl-5 col-lg-6">
              <div class="card shadow mb-4">
                <!-- Card Header - Dropdown -->
                <div class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
                  <h6 class="m-0 font-weight-bold text-primary">各收入來源占比</h6>
                  <div class="dropdown no-arrow">
                    <a class="dropdown-toggle" href="#" role="button" id="dropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                      <i class="fas fa-ellipsis-v fa-sm fa-fw text-gray-400"></i>
                    </a>
                    <div class="dropdown-menu dropdown-menu-right shadow animated--fade-in" aria-labelledby="dropdownMenuLink">
                      <div class="dropdown-header">Dropdown Header:</div>
                      <a class="dropdown-item" href="#">Action</a>
                      <a class="dropdown-item" href="#">Another action</a>
                      <div class="dropdown-divider"></div>
                      <a class="dropdown-item" href="#">Something else here</a>
                    </div>
                  </div>
                </div>
                <!-- Card Body -->
                <div class="card-body">
                  <div class="chart-pie pt-1 pb-5">
                    <canvas id="myDoughnutChart"></canvas>
                  </div>
                </div>
              </div>
            </div>
          </div>

          <!-- Content Row -->
          <div class="row">

            <!-- Content Column -->
            <div class="col-lg-6 mb-4">

              <!-- Project Card Example -->

              <!-- Color System -->

            </div>

            <div class="col-lg-6 mb-4">

              <!-- Illustrations -->

              <!-- Approach -->

            </div>
          </div>

        </div>
        <!-- /.container-fluid -->

      </div>
      <!-- End of Main Content -->

      <!-- Footer -->
      <!-- End of Footer -->

    </div>
    <!-- End of Content Wrapper -->

  <!-- End of Page Wrapper -->

  <!-- Scroll to Top Button-->
  <a class="scroll-to-top rounded" href="#page-top">
    <i class="fas fa-angle-up"></i>
  </a>

  <!-- Logout Modal-->
  <div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
      <div class="modal-content">
        <div class="modal-header">
          <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
          <button class="close" type="button" data-dismiss="modal" aria-label="Close">
            <span aria-hidden="true">×</span>
          </button>
        </div>
        <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
        <div class="modal-footer">
          <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
          <a class="btn btn-primary" href="login.html">Logout</a>
        </div>
      </div>
    </div>
  </div>
  
<script>
//編輯金錢格式，Vue.filter 必須設置在 new Vue 之前
Vue.filter('money',function(num){
    const parts = num.toString().split('.');
    parts[0] = parts[0].replace(/\B(?=(\d{3})+(?!\d))/g, ',');
    return '$' + parts.join('.');
});

</script>


<script>
        var vm = new Vue({
        	el:'#app2',
        	data(){
        		return {
            		
					list:null,
					text:0,
					ticketSum:0,
					member:0,
					memberPcen:'5%',
					ResturantOrder:0	
        		}
	    	},

            	mounted: function(){
      	          var self = this;
//       	          var apid = $("#productID").val();
      	          $.ajax({
      	              type:"get",
      	              url:"/Art/14/showAltartCenter.ctrl",    
      	              contentType: "application/json",
      	              dataType:"json",
      	              success:function(value){
      	              	self.list = value;
      	              	
      	              },
      	              error:function(){
      	                  alert("整組壞光光 at mounted: function()");
      	              }
      	          });

      	        
      	      }

        	})
        </script>

        <!-- End of Topbar -->
  <script>
  $(document).ready(function () {
      var self = vm;
      var clock = setInterval(sum , 7000);
    $.ajax({
      type:"get",
      url:"/Art/14/sum.ctrl",    
//       contentType: "application/json",
      dataType:"text",
      success:function(value){
      	self.text = value;
      	
      },
      error:function(){
          alert("整組壞光光 at /14/sum.ctrl");
      }
    });

    $.ajax({
        type:"get",
        url:"/Art/14/showsumTicketTotal",    
        dataType:"text",
        success:function(value){
        	self.ticketSum = value;
        	
        },
        error:function(){
            alert("整組壞光光 at /14/showsumTicketTotal");
        }
      });

    $.ajax({
        type:"get",
        url:"/Art/14/showResturantOrder",    
        dataType:"text",
        success:function(value){
        	self.ResturantOrder = value;
        	
        },
        error:function(){
            alert("整組壞光光 at /14/showResturantOrder");
        }
      });

    $.ajax({
        type:"get",
        url:"/Art/14/showSumMember",    
        dataType:"text",
        success:function(value){
        	self.member = value;
        	self.memberPcen = value+"%";
        },
        error:function(){
            alert("整組壞光光 at /14/showSumMember");
        }
      });
    
  })
  
  
  function sum(){
// 	  alert('安安');
	  var self = vm;
	    $.ajax({
	      type:"get",
	      url:"/Art/14/sum.ctrl",    
	      dataType:"text",
	      success:function(value){
	      	self.text = value;
	      	
	      },
	      error:function(){
	          alert("整組壞光光 at /14/sum.ctrl");
	      }
	    });

	    $.ajax({
	        type:"get",
	        url:"/Art/14/showsumTicketTotal",    
	        dataType:"text",
	        success:function(value){
	        	self.ticketSum = value;
	        	
	        },
	        error:function(){
	            alert("整組壞光光 at /14/showsumTicketTotal");
	        }
	      });

	    $.ajax({
	        type:"get",
	        url:"/Art/14/showSumMember",    
	        dataType:"text",
	        success:function(value){
	        	self.member = value;
	        	self.memberPcen = value+"%";
	        },
	        error:function(){
	            alert("整組壞光光 at /14/showSumMember");
	        }
	      });

	 var self = vm2;
   	 $.ajax({
             type:"get",
             url:"/Art/14/UnReadSum",    
             dataType:"text",
             success:function(sum){
             	self.unReadSum = sum;
             	
             },
             error:function(){
                 alert("UnReadSum():整組壞光光");
             }
         });

   	$.ajax({
          type:"get",
          url:"/Art/14/showAltartCenter.ctrl",    
          contentType: "application/json",
          dataType:"json",
          success:function(value){
          	self.list = value;
          	
          },
          error:function(){
              alert("整組壞光光 at /14/showAltartCenter.ctrl");
          }
      });

   	$.ajax({
	      type:"get",
	      url:"/Art/14/barChart",    
	      contentType: "application/json",
	      dataType:"json",
	      success:function(value){
//          alert(value);
	        lineChartData = value; //parse the data into JSON

	        var ctx = document.getElementById('myChart').getContext('2d');
			var myChart = new Chart(ctx, {
	    type: 'bar',
	    data: {
	        labels: ['售票系統', '得藝洋行', '得藝食堂','鄰近活動', '路線規劃', '藝術課程', '街頭藝人'],
	        datasets: [{
	            label: '點擊率 (次)',
//	            data: [120, 190, 30, 50, 20, 30],
				 data: lineChartData,
	           backgroundColor: [
	                'rgba(245, 148, 169, 0.2)',
	                'rgba(69, 191, 189, 0.2)',
	                'rgba(253, 181, 93, 0.2)',
	                'rgba(54, 162, 235, 0.2)',
	                'rgba(82, 82, 163, 0.2)',
	                'rgba(77, 83, 96, 0.2)'
	            ],
	            borderColor: [
	                'rgba(245, 148, 169, 1)',
	                'rgba(69, 191, 189, 1)',
	                'rgba(253, 181, 93, 1)',
	                'rgba(54, 162, 235, 1)',
	                'rgba(82, 82, 163, 1)',
	                'rgba(77, 83, 96, 1)'
	            ],
	            borderWidth: 1
	        }]
	    },
	    options: {
	        scales: {
	            yAxes: [{
	                ticks: {
	                    beginAtZero: true
	                }
	            }]
	        }
	    }
	});



	      	
	      },
	      error:function(){
	          alert("整組壞光光 at barchar.js");
	      }
	    });


    $.ajax({
	      type:"get",
	      url:"/Art/14/pieChart",    
	      contentType: "application/json",
	      dataType:"json",
	      success:function(value){
//           alert(value);
	        lineChartData = value; //parse the data into JSON

var ctx = document.getElementById('myDoughnutChart').getContext('2d');
var myDoughnutChart = new Chart(ctx, {
  type: 'doughnut',
  data: {
      datasets: [{
          data:lineChartData,
//data: [
//             0,
//             0,
//             0,
//             0,
//             0,
//           ],
          backgroundColor: [
            "#F596AA",
            "#46BFBD",
            "#9999CC",
            "#4D5360",
            "#FDB55D"
          ],
          label: 'Dataset 1'
      }],
      labels: [
        "售票",
        "商城",
        "課程",
        "贊助",
        "餐廳"
      ]
  },
  options: {
      responsive: true,
      legend: {
          position: 'top',
      },
      
      animation: {
          animateScale: true,
          animateRotate: true
      }
  }
});
	      	
	      },
	      error:function(){
	          alert("整組壞光光");
	      }
	    });

	
    

	  }
  
  </script>
   <!-- Charts Data JS -->
<script src="<c:url value='/vendor/chart.js/Chart.min.js'/>"></script>
<%-- <script src="<c:url value='/js/demo/chart-area-demo.js'/>"></script> --%>
<%-- <script src="<c:url value='/js/demo/chart-pie-demo.js'/>"></script>  --%>
<script src="<c:url value='/js14/barChart.js'/>"></script> 
<%-- <script src="<c:url value='/js14/pieChart.js'/>"></script>  --%>

<script>
$(document).ready(function () {
	 $.ajax({
	      type:"get",
	      url:"/Art/14/barChart",    
	      contentType: "application/json",
	      dataType:"json",
	      success:function(value){
//            alert(value);
	        lineChartData = value; //parse the data into JSON

	        var ctx = document.getElementById('myChart').getContext('2d');
			var myChart = new Chart(ctx, {
	    type: 'bar',
	    data: {
	        labels: ['售票系統', '得藝洋行', '得藝食堂', '鄰近活動', '路線規劃', '藝術課程', '街頭藝人'],
	        datasets: [{
	            label: '點擊率 (次)',
//	            data: [120, 190, 30, 50, 20, 30],
				 data: lineChartData,
	           backgroundColor: [
	                'rgba(245, 148, 169, 0.2)',
	                'rgba(69, 191, 189, 0.2)',
	                'rgba(253, 181, 93, 0.2)',
	                'rgba(54, 162, 235, 0.2)',
	                'rgba(82, 82, 163, 0.2)',
	                'rgba(77, 83, 96, 0.2)'
	            ],
	            borderColor: [
	                'rgba(245, 148, 169, 1)',
	                'rgba(69, 191, 189, 1)',
	                'rgba(253, 181, 93, 1)',
	                'rgba(54, 162, 235, 1)',
	                'rgba(82, 82, 163, 1)',
	                'rgba(77, 83, 96, 1)'
	            ],
	            borderWidth: 1
	        }]
	    },
	    options: {
	        scales: {
	            yAxes: [{
	                ticks: {
	                    beginAtZero: true
	                }
	            }]
	        }
	    }
	});



	      	
	      },
	      error:function(){
	          alert("整組壞光光 at barchar.js");
	      }
	    });

	
})

$(document).ready(function () {
	 $.ajax({
	      type:"get",
	      url:"/Art/14/pieChart",    
	      contentType: "application/json",
	      dataType:"json",
	      success:function(value){
//             alert(value);
	        lineChartData = value; //parse the data into JSON

var ctx = document.getElementById('myDoughnutChart').getContext('2d');
var myDoughnutChart = new Chart(ctx, {
    type: 'doughnut',
    data: {
        datasets: [{
            data:lineChartData,
// data: [
//               0,
//               0,
//               0,
//               0,
//               0,
//             ],
            backgroundColor: [
              "#F596AA",
              "#46BFBD",
              "#9999CC",
              "#4D5360",
              "#FDB55D",
            ],
            label: 'Dataset 1'
        }],
        labels: [
          "售票",
          "商城",
          "課程",
          "贊助",
          "餐廳"
        ]
    },
    options: {
        responsive: true,
        legend: {
            position: 'top',
        },
        
        animation: {
            animateScale: true,
            animateRotate: true
        }
    }
});
	      	
	      },
	      error:function(){
	          alert("整組壞光光");
	      }
	    });

	
})


</script>

</body>
</html>