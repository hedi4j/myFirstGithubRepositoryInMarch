package cn.mldn.test;

import java.util.concurrent.TimeUnit;

public class TimeLockDemo {
	public static void main(String[] args) {
		System.out.println(TimeUnit.HOURS.convert(14777818L, TimeUnit.MILLISECONDS));
	}
}
