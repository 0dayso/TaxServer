package com.dzfp.util;

public class PathUtil {

	private static String rootPath = null;

	public static String getRootPath() {
		if (StringUtils.isNotEmpty(rootPath)) {
			return rootPath;
		}
		rootPath = PathUtil.class.getClassLoader().getResource("").getPath();
		rootPath = rootPath.substring(1);
		return rootPath;
	}
}
