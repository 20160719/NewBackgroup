package com.myself.util;

import java.util.List;

public class StringUtils extends org.apache.commons.lang.StringUtils {
	
	public static final String STRING_MERGE = "|";

	public static final String STRING_SPLIT = "\\|";

	public static final String STRING_MERGE_COMMA = ",";

	public static final String STRING_SPLIT_COMMA = "\\,";

	private StringUtils() {
		
	}
	
	public static boolean isNotNull(Object obj) {
		return null != obj;
	}
	
	public static boolean isEqual(Integer val1, Integer val2) {
		if(val1 == null || val2 == null) {
			return false;
		} else {
			return val1.intValue() == val2.intValue();
		}
	}
	
	public static boolean isNotBlank(String str) {
		return (!(org.apache.commons.lang.StringUtils
				.isBlank(org.apache.commons.lang.StringUtils.trimToEmpty(str))));
	}

	public static String mergeToStr(List<String> list, String STRING_MERGE) {
		return String.join(STRING_MERGE, list);
	}

	public static String mergeToStr(List<String> list) {
		return String.join(STRING_MERGE, list);
	}

}
