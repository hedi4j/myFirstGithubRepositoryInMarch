package cn.mldn.test;

import cn.mldn.util.MD5Code;

public class TestPasswordMD5 {
	public static void main(String[] args) {
		System.out.println(new MD5Code().getMD5ofStr("helloworld").length());
	}
}
