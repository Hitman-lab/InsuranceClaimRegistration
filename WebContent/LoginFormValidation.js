function validate() {

	var usr_name = /^[A-Za-z]+$/;
	var usr_pass = /^[A-Z]{1}[a-zA-z0-9@$%*#_-]/

	var userName = document.getElementById('username');
	var password = document.getElementById('pass');
	var usr_msg = document.getElementById('user_check');
	var user_passw_msg = document.getElementById('user_pass');

	if (userName.value == '') {
		usr_msg.innerHTML = "* Username Required";
		document.loginForm.user_name.focus();
		return false;
	} else {

		if (userName.value.match(usr_name)) {
			usr_msg.innerHTML = "";
		} else {
			document.loginForm.user_name.focus();
			usr_msg.innerHTML = "* Username Must be Letters";
			return false;
		}
	}

	if (password.value == '') {
		user_passw_msg.innerHTML  = "* Password Required";
		document.loginForm.pass.focus();
		return false;
	}

	if (password.value.match(usr_pass)) {
		user_passw_msg.innerHTML = "";
	} else {
		document.loginForm.pass.focus();
		user_passw_msg.innerHTML = "* First Letter Should be Capital and alphanumeric";
		return false;
	}
	return true;
}