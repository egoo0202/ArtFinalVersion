var oTable;
$(document).ready(function() {
    oTable = $('#dataTable').dataTable({ //這的dataTable不能换成DataTable，原因不清楚，但就是大坑
       language: {
    		search: "在表格中搜尋：",
    		lengthMenu:"每頁顯示 _MENU_ 筆資料",
    		zeroRecords: "没有符合的结果",
    		info: "顯示第 _START_ 至 _END_ 項结果，共 _TOTAL_ 項",
    		infoEmpty: "顯示第 0 至 0 項结果，共 0 項",
    		paginate: {
                first: "首頁",
                previous: "上一頁",
                next: "下一頁",
                last: "末頁"
            },
            infoFiltered: "(已比對 _MAX_ 項結果)",
    	
    	}
    });

    $('.align-middle').click(function () { 
    	//alert('a'); 
        var nTr = $(this).parents('tr')[0];  
        if (oTable.fnIsOpen(nTr))//判断是否已打開              
        {  
        /* This row is already open - close it */  
            $(this).addClass("row-details-close").removeClass("row-details-open");  
                    oTable.fnClose( nTr );  
        }else{  
            /* Open this row */                  
            $(this).addClass("row-details-open").removeClass("row-details-close");  
            // 调用方法顯示详细信息 data_id為自定義属性 存放配置ID  
            fnFormatDetails(nTr,$(this).attr("id"));  
        }  
    });  
});

function fnFormatDetails(nTr,pdataId){
	$.ajax({ 
        type:'post',         
        url:"/Art/14/selectMessageContent/"+pdataId+".ctrl", 
//		contentType: "application/x-www-form-urlencoded;charset=UTF-8",
//        data:pdataId, 
        dataType:"text", 
        success:function (content){                              
             var str = "留言內容：<br>"+content;
                oTable.fnOpen( nTr, str ); 
             
        }, 
        error: function(){//請求錯誤時的處理 
            oTable.fnOpen( nTr,'整組壞光光' ); 
        } 
    });
} 