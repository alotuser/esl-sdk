package com.esl.open.sdk.util;

/**
 * *
 * <p>
 * 字符串工具类
 * </p>
 * 
 * @author zdview
 * @since 2025-07-03
 */
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
