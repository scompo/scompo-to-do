 $(window).load(function() {

	log.enableAll();

	$("#registerButton").unbind();
	$("#registerButton").bind("click", onClickRegister);

});

function onClickRegister() {

	$.ajax({
		method : "POST",
		url : "/api/v1/users",
		contentType : "application/json",
		data :JSON.stringify({
			login : $("#login").val(),
			name : $("#username").val(),
			password : $("#password").val()
		})
	}).done(function(res) {

		self.location = "/home";
	});
}