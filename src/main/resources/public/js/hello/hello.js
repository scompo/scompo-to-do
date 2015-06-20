$(document).on('pageinit', function() {
	
	$.ajax({
		url : "/api/v1/hello"
	}).done(function(res) {
		$("#helloRestResult").text(res);
	});
});