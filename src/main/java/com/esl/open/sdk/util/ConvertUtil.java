package com.esl.open.sdk.util;

import java.lang.reflect.Field;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.esl.open.sdk.domain.SystemParam;

import cn.hutool.json.JSONUtil;

/**
 * * *
 * <p>
 * 转换工具类
 * </p>
 * 
 * @author zdview
 * @since 2025-07-03
 */
public class ConvertUtil {
	/**
	 * 将对象转换为Map
	 * 
	 * @param object 待转换对象
	 * @return 转换后Map
	 * @throws Exception 反射异常
	 */
	public static Map<String, String> convertToMap(Object object) throws Exception {
		if (object == null) {
			return Collections.emptyMap();
		} else {
			Map<String, String> resultMap = new HashMap<String, String>();
			Field[] fields = object.getClass().getDeclaredFields();
			if (fields != null && fields.length != 0) {
				for (Field field : fields) {
					field.setAccessible(true);
					Class<?> typeClazz = field.getType();
					String key = field.getName();
					String val = null;
					if (List.class.isAssignableFrom(typeClazz)) {
						val = JSONUtil.toJsonStr(field.get(object));
					} else {
						val = String.valueOf(field.get(object));
					}

					if (val != null && !"".equals(val) && !"null".equals(val) && !"NULL".equals(val)) {
						resultMap.put(key, val);
					}
				}

				return resultMap;
			} else {
				return Collections.emptyMap();
			}
		}
	}

	/**
	 * 转换系统参数为Map
	 * 
	 * @param systemParam 系统参数
	 * @return 参数Map
	 */
	public static Map<String, String> convertSystemParamsToMap(SystemParam systemParam) {
		Map<String, String> resultMap = new HashMap<String, String>();
		resultMap.put(SystemParam.TIMESTAMP, String.valueOf(System.currentTimeMillis() / 1000L));
		resultMap.put(SystemParam.APP_ID, systemParam.getAppId());
		resultMap.put(SystemParam.APP_SECRET, systemParam.getAppSecret());
		return resultMap;
	}


}
