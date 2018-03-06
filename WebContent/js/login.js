window.onload = function() {
	listener("mid","blur",validateMid) ;
	listener("password","blur",validatePassword) ;
	listener("code","blur",validateCode) ;
	listener("memberForm","submit",function(e){
		if (validateMid() & validatePassword() & validateCode()) {
			this.submit() ;
		} else {
			e.preventDefault() ;
		}
	}) ;
}
function validateMid() {
	return validateEmpty("mid") ;
}
function validatePassword() {
	return validateEmpty("password") ;
}
function validateCode() {
	return validateRegex("code",/\w{4}/) ; ;
}