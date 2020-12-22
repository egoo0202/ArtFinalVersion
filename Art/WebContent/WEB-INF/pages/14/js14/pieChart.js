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
            ],
            label: 'Dataset 1'
        }],
        labels: [
          "售票",
          "商城",
          "課程",
          "贊助"
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


