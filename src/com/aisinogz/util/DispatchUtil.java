package com.aisinogz.util;

import com.jacob.com.Dispatch;
import com.jacob.com.Variant;

public class DispatchUtil {

	public static String getField(Dispatch dispatchTarget, String fieldName) {
		Variant variant = Dispatch.get(dispatchTarget, fieldName);
		if (variant != null) {
			return variant.toString();
		}
		return null;
	}

	public static void setField(Dispatch dispatchTarget, String fieldName, Object value) {
		Dispatch.put(dispatchTarget, fieldName, value);
	}
}
