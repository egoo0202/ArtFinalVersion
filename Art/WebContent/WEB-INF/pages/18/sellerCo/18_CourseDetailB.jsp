<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>

<div class="container">
<div>
<img style='display: block; width: 640px; height: 360px;'src="data:image/jpg;base64, ${cfd.coAct_ImageStr}">
</div>
<table>
<thead><tr><th><font size="12px" color="SeaGreen"><b>NO.${cfd.coId}    ${cfd.coTitle}</b></font></th></tr></thead>
<tbody>
<%-- <tr><td>NO. ${cfd.coId}   ${cfd.coTitle}</td></tr> --%>
<tr><td style="padding-top:30px;"><font size="5" color="black">類別：<a href="<c:url value='/18/searchByTypeB.ctrl?searchTypeB=${cfd.coAct_Type}' />">${cfd.coAct_Type}</a></font></td></tr>
<tr><td style="padding-top:60px;"><font size="5" color="black">課程售價：${cfd.coPrice}</font></td></tr>
<tr><td style="padding-top:20px;"><font size="5" color="black">剩餘名額：${cfd.coNum}</font></td></tr>
<tr><td style="padding-top:60px;"><font size="5" color="black">上課地點：${cfd.coAct_Location} ${cfd.coLocation_Name}</font></td></tr>
<tr><td style="padding-top:5px;"><font size="5" color="black">開始時間：${cfd.coAct_Date} ${cfd.coAct_Time}</font></td></tr>
<tr><td><font size="5px" color="black">結束時間：${cfd.coEnd_Date} ${cfd.coEnd_Time}</font></td></tr>
<tr><td style="padding-top:60px;"><font size="5" color="black">課程簡介：<br>
${cfd.coAct_Description}</font></td></tr>
<tr><td style="padding-top:75px;"><font size="5" color="black">查看次數：${cfd.coHot}</font></td></tr>
</tbody>
</table>
<br>
<button class="btn btn-info" onclick="location.href='<c:url value='/18/cSelectAll.ctrl' />'"><font size="5">回課程總覽</font></button>
<button class="btn btn-warning" onclick="location.href='<c:url value='/18/UpdateData.ctrl?coId=${cfd.coId}' />'"><font size="5">修改本課程</font></button>
<button class="btn btn-danger" onclick="delSA(${cfd.coId})"><font size="5">刪除本課程</font></button>
<%-- <input type="button" name="delete" value="刪除本課程" class="btn btn-danger" style="font-size:20px" onclick="delSA(${cfd.coId})"> --%>
</div>	
				  
<script type="text/javascript">			
function delSA(coId){
	swal("您確定要刪除本課程嗎？","", "warning",{
	    buttons: {
	      danger: {
	          text: "是"
	        },
	      "否": true,
	    },
	  })

		.then((value) => {
		switch (value) {
		case "danger":
	    	swal("刪除課程成功","", "success")
	    	setTimeout(function(){window.location="<c:url value='/18/cDelete.ctrl?coId="+coId+"'/>" ; },2000);
	        break;
	      case "不是":
	        swal("取消刪除","", "info");
	        break;
	      default:
	    	  swal("課程未被刪除","", "info");
	        break;
		}
		});
};
</script>
					
		