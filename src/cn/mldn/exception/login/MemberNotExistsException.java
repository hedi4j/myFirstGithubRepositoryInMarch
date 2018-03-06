package cn.mldn.exception.login;

@SuppressWarnings("serial")
public class MemberNotExistsException extends LoginException {

	public MemberNotExistsException(String msg) {
		super(msg);
	}

}
