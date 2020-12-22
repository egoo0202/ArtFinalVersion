//$(document).ready(function () {
//	 $.ajax({
//	      type:"get",
//	      url:"/Art/14/barChart",    
//	      contentType: "application/json",
//	      dataType:"json",
//	      success:function(value){
////             alert(value);
//	        lineChartData = value; //parse the data into JSON
//
//	        var ctx = document.getElementById('myChart').getContext('2d');
//			var myChart = new Chart(ctx, {
//	    type: 'bar',
//	    data: {
//	        labels: ['售票系統', '得藝洋行', '得藝食堂', '路線規劃', '藝術課程', '街頭藝人'],
//	        datasets: [{
//	            label: '點擊率 (次)',
//// 	            data: [120, 190, 30, 50, 20, 30],
//				 data: lineChartData,
//	           backgroundColor: [
//	                'rgba(245, 148, 169, 0.2)',
//	                'rgba(69, 191, 189, 0.2)',
//	                'rgba(253, 181, 93, 0.2)',
//	                'rgba(54, 162, 235, 0.2)',
//	                'rgba(82, 82, 163, 0.2)',
//	                'rgba(77, 83, 96, 0.2)'
//	            ],
//	            borderColor: [
//	                'rgba(245, 148, 169, 1)',
//	                'rgba(69, 191, 189, 1)',
//	                'rgba(253, 181, 93, 1)',
//	                'rgba(54, 162, 235, 1)',
//	                'rgba(82, 82, 163, 1)',
//	                'rgba(77, 83, 96, 1)'
//	            ],
//	            borderWidth: 1
//	        }]
//	    },
//	    options: {
//	        scales: {
//	            yAxes: [{
//	                ticks: {
//	                    beginAtZero: true
//	                }
//	            }]
//	        }
//	    }
//	});
//
//
//
//	      	
//	      },
//	      error:function(){
//	          alert("整組壞光光 at barchar.js");
//	      }
//	    });
//
//	
//})


//這是註解嗎
//這是本日的設置

$("#barNow").click(function(event){
	event.preventDefault();

  $.ajax({
	      type:"get",
	      url:"/Art/14/barChart",    
	      contentType: "application/json",
	      dataType:"json",
	      success:function(value){
//             alert(value);
	        lineChartData = value; //parse the data into JSON

	        var ctx = document.getElementById('myChart').getContext('2d');
			var myChart = new Chart(ctx, {
	    type: 'bar',
	    data: {
	        labels: ['售票系統', '得藝洋行', '得藝食堂', '路線規劃', '藝術課程', '街頭藝人'],
	        datasets: [{
	            label: '點擊率 (次)',
// 	            data: [120, 190, 30, 50, 20, 30],
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


//本月的設置
$("#barMonth").click(function(event){
	event.preventDefault();

  

	        var ctx = document.getElementById('myChart').getContext('2d');
			var myChart = new Chart(ctx, {
	    type: 'bar',
	    data: {
	        labels: ['售票系統', '得藝洋行', '得藝食堂', '路線規劃', '藝術課程', '街頭藝人'],
	        datasets: [{
	            label: '點擊率 (次)',
 	            data: [190, 150, 130, 150, 120, 130],
//				 data: lineChartData,
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


})



//本年度的設置
$("#barYear").click(function(event){
		event.preventDefault();


	    var ctx = document.getElementById('myChart').getContext('2d');
		var myChart = new Chart(ctx, {
	    type: 'bar',
	    data: {
	        labels: ['售票系統', '得藝洋行', '得藝食堂', '路線規劃', '藝術課程', '街頭藝人'],
	        datasets: [{
	            label: '點擊率 (次)',
 	            data: [1940, 1720, 1737, 1820, 1720, 1845],
//				 data: lineChartData,
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

	

})