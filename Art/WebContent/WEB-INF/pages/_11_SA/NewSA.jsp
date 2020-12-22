<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>NEW Street Artist</title>
<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.22/js/jquery.dataTables.js"></script>
</head>
<div align="center">
	<span style="border: outset; background-color: rgb(239, 243, 11);margin: 1px;" > 
		<a href="GoCreate.ctrl">新增</a>&nbsp;&nbsp; 
		<a href="GoDel.ctrl">刪除</a>&nbsp;&nbsp;
		<a href="GoSearch.ctrl">查詢</a>&nbsp;&nbsp; 
		<a href="myStreetArtistPage.ctrl">總覽</a>
	</span>
</div>
<table style="background-color: rgb(73, 229, 240);border-radius: 25px;margin-top: 10px;" align="center">
	<tbody>
		<form action="createSA.ctrl" method="post" id="create">
		<tr>
			<td colspan="2" align="center" style="font-size: 20px;color: red;">新增藝人</td>
		</tr>
		<tr>
			<td>姓名：</td>
			<td><input type="text" name="NAME_SA" placeholder="範例：王小明">${errors.name }<br/></td>
		</tr>
		<tr>
			<td>表演地區：</td>
			<td>
				<select name="COUNTRY_SA" >
					<option value="臺北市">臺北市</option>
					<option value="新北市">新北市</option>
					<option value="桃園市">桃園市</option>
					<option value="臺中市">臺中市</option>
					<option value="臺南市">臺南市</option>
					<option value="高雄市">高雄市</option>
					<option value="新竹縣">新竹縣</option>
					<option value="苗栗縣">苗栗縣</option>
					<option value="彰化縣">彰化縣</option>
					<option value="南投縣">南投縣</option>
					<option value="雲林縣">雲林縣</option>
					<option value="嘉義縣">嘉義縣</option>
					<option value="屏東縣">屏東縣</option>
					<option value="宜蘭縣">宜蘭縣</option>
					<option value="花蓮縣">花蓮縣</option>
					<option value="臺東縣">臺東縣</option>
					<option value="澎湖縣">澎湖縣</option>
					<option value="金門縣">金門縣</option>
					<option value="連江縣">連江縣</option>
				</select>${errors.country }<br/>
			</td>
		</tr>
		<tr>
			<td>表演項目：</td>
			<td>
				<input type="text" name="THEME_SA" placeholder="範例：吉他演奏" value="魔術表演">${errors.theme }<br/>
			</td>
		</tr>
		<tr>
			<td>
				分類：
			</td>
			<td>
				<select name="CLASSIFICATION_SA" >
					<option value="表演藝術">表演藝術</option>
					<option value="創意工藝">創意工藝</option>
					<option value="視覺藝術">視覺藝術</option>
				</select>${errors.classification }<br/>
			</td>
		</tr>
		</form>
		<tr>
			<td align="center" colspan="2">
			<button class="btn btn-outline-info" onclick="return create()" id="submit">確認新增</button>
		</tr>
	</tbody>
</table>
<script>
function create() {
	swal({
			  title: "是否確認新增?",
			  text: "新增最後確認!",
			  icon: "warning",
			  buttons: true,
			  dangerMode: true,
			})
			.then((orderOK) => {
				  if (orderOK) {
					  swal("新增藝人成功!", 
						    	{icon: "success",});  
					  setTimeout(function(){$("#create").submit(); });
					 			
				  } else {
				    swal("操作已取消!");
				  }
				});
		
		}
</script>
</html>