$(document).ready(function() {
	$('#push').click(function() {
		var apid = $("#productID").val();
		var name = $('input[name=name]');
		var subject = $('input[name=subject]');
		$.ajax({
			method: 'GET',
			url: "/Art/14/saveMessage/" + apid + ".ctrl?name="+ name.val() +"&subjectAP="+subject.val(),
			dataType: 'json',
			success: function(json) {
				console.log(json);
				
			}
		})
	})
})