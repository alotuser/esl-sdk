package com.esl.open.sdk.util;

import java.lang.reflect.Field;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.esl.open.sdk.domain.SystemParam;

import cn.hutool.json.JSONUtil;

public class ConvertUtil {

	public static Map<String, String> convertToMap(Object object) throws Exception {
		if (object == null) {
			return Collections.emptyMap();
		} else {
			Map<String, String> resultMap = new HashMap();
			Field[] fields = object.getClass().getDeclaredFields();
			if (fields != null && fields.length != 0) {
				for (Field field : fields) {
					field.setAccessible(true);
					Class typeClazz = field.getType();
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

	public static Map<String, String> convertSystemParamsToMap(SystemParam systemParam) {
		Map<String, String> resultMap = new HashMap();
		resultMap.put("timestamp", String.valueOf(System.currentTimeMillis() / 1000L));
		resultMap.put("app_id", systemParam.getAppId());
		resultMap.put("appSecret", systemParam.getAppSecret());
		return resultMap;
	}


}
