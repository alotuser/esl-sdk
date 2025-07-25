package com.esl.open.sdk.util;

public class StringUtil {

	public static boolean isBlank(Object o) {
		if (o == null) {
			return true;
		} else {
			return "".equals(trim(o.toString()));
		}
	}

	public static boolean isNotBlank(Object o) {
		return o != null && !"".equals(o) && !"null".equals(o) && !"NULL".equals(o);
	}

	public static String trim(String s) {
		String result = s.replaceAll(" +", "");
		return result;
	}

}
