package cn.mldn.exception.login;

@SuppressWarnings("serial")
public class MemberLockedException extends LoginException {

	public MemberLockedException(String msg) {
		super(msg);
	}

}
