$(document).ready(function() {
	$('#push').click(function() {
		new Vue({
			el: "#message",
			data() {
				return {
					items: ""
				}
			},
			created: function() {
				var self = this;
				var apid = $("#productID").val();
				var name = $('input[name=name]');
				var subject = $('input[name=subject]');
				var data = 'name=' + name.val() +  '&subjectAP=' + subject.val() ;
				$.ajax({
					type: "get",
//					url: "/Art/14/saveMessage/" + apid + ".ctrl?name="+
//						 name.val() + "&subjectAP=" + subject.val(),
					url: "/Art/14/saveMessage/" + apid + ".ctrl",
					contentType: "application/json",
					dataType: "json",
					data: data,
					cache: false,
					success: function(json) {
						self.items = json;
					},
					error:  function() {
						alert("failure");
					}
				});
			}
		})
	})
})