package cn.mldn.exception.login;

@SuppressWarnings("serial")
public class PasswordValidateException extends LoginException {

	public PasswordValidateException(String msg) {
		super(msg);
	}

}
