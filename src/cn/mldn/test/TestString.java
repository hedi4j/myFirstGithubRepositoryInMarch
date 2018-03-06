package cn.mldn.test;

import cn.mldn.util.enctype.PasswordUtil;

public class TestString {
	public static void main(String[] args) {
		System.out.println(PasswordUtil.encoderString("hello"));
		System.out.println(PasswordUtil.decoderString("WVVkV2MySkhPRDA9"));
	}
}
