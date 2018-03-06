package cn.mldn.exception.login;

import cn.mldn.exception.ProjectException;

@SuppressWarnings("serial")
public class LoginException extends ProjectException {

	public LoginException(String msg) {
		super(msg);
	}

}
