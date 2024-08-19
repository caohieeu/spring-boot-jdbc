package com.javaweb.utils;

import java.lang.reflect.Array;
import java.util.Map;

public class MapUtil {
	@SuppressWarnings("unlikely-arg-type")
	public static <T> T getObject(Map<String, Object> params, String key, Class<T> tClass) {
		Object obj = params.getOrDefault(key, null);
		if(obj != null) {
			if(tClass.equals(Double.class)) {
				obj = obj != "" ? Double.valueOf(obj.toString()) : null;
			}
			else if(tClass.equals(Long.class)) {
				obj = obj != "" ?Long.valueOf(obj.toString()) : null;
			}
			else if(tClass.equals(Integer.class)) {
				obj = obj != "" ?Integer.valueOf(obj.toString()) : null;
			}
			else if(tClass.equals(String.class)) {
				obj = obj.toString();
			}
			return tClass.cast(obj);
		}
		return null;
	}
}
