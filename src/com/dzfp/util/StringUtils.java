package com.dzfp.util;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/***
 * 字符工具
 */
public class StringUtils {

	/***
	 * 查询参数转义
	 * 
	 * @param str
	 * @return
	 */
	public final static String sqlParamEscape(String str) {
		return str.replaceAll("'", "\"");

	}

	/****
	 * 去除尾巴固定字符
	 * 
	 * @param str
	 * @param ge
	 * @return
	 */
	public final static String rtrim(String str, String ge) {
		return NulltoEmpty(str).replaceAll(ge + "*$", "");

	}

	/***
	 * 英文字符集转中文
	 * 
	 * @param str
	 * @return
	 */
	public final static String ascii2GBK(String str) {
		try {
			return new String(str.getBytes("ISO-8859-1"), "GBK");
		} catch (UnsupportedEncodingException e) {
		}
		return null;
	}

	/***
	 * 中文转英文字符集
	 * 
	 * @param str
	 * @return
	 */
	public final static String GBK2ascii(String str) {
		try {
			return new String(str.getBytes("GBK"), "ISO-8859-1");
		} catch (UnsupportedEncodingException e) {
		}
		return null;
	}

	

	/****
	 * 处理JSON 中存在‘null’问题
	 * 
	 * @param obj
	 * @return
	 */
	public final static String NulltoEmpty(Object obj) {
		return isNotNull(obj) ? obj.toString().trim() : "";
	}

	/****
	 * 字符前后空格处理
	 * 
	 * @param obj
	 * @return
	 */
	public final static String spaceTrim(String str) {
		return isNotNull(str) ? str.trim() : null;
	}

	/***
	 * 处理页面提交到后台得参数中的html标记处理
	 * 
	 * @param param
	 * @return
	 */
	public final static String htmlSignDandle(String param) {
		return isNotNull(param) ? param.replaceAll("<", "&lt;").replaceAll(">",
				"&gt;") : "";
	}

	/**
	 * 半角转全角
	 * 
	 * @param input
	 *            String.
	 * @return 全角字符串.
	 */
	public final static String ToSBC(String input) {
		char c[] = input.toCharArray();
		for (int i = 0; i < c.length; i++) {
			if (c[i] == ' ') {
				c[i] = '\u3000';
			} else if (c[i] < '\177') {
				c[i] = (char) (c[i] + 65248);
			}
		}
		return new String(c);
	}

	/**
	 * 全角转半角
	 * 
	 * @param input
	 *            String.
	 * @return 半角字符串
	 */
	public final static String ToDBC(String input) {
		char c[] = input.toCharArray();
		for (int i = 0; i < c.length; i++) {
			if (c[i] == '\u3000') {
				c[i] = ' ';
			} else if (c[i] > '\uFF00' && c[i] < '\uFF5F') {
				c[i] = (char) (c[i] - 65248);

			}
		}
		String returnString = new String(c);
		return returnString;
	}

	/***
	 * CH 移动电话号码验证
	 * 
	 * @param phoneNum
	 * @return true|false
	 */
	public final static boolean isMoblePhone(String phoneNum) {
		return isNotEmpty(phoneNum) && phoneNum.matches("^1[3-9]\\d{9}");
	}

	/***
	 * CH 固定电话验证
	 * 
	 * @param phoneNum
	 * @return true|false
	 */
	public final static boolean isTelPhone(String phoneNum) {
		return isNotEmpty(phoneNum)
				&& phoneNum.matches("^(0[0-9]{2,3}-?)?([2-9][0-9]{6,7})+$");
	}

	/***
	 * email 电子邮件格式验证
	 * 
	 * @param phoneNum
	 * @return true|false
	 */
	public final static boolean isEmail(String email) {
		return isNotEmpty(email)
				&& email.matches("^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$");
	}

	/***
	 * 有效整数验证
	 * 
	 * @param phoneNum
	 * @return true|false
	 */
	public final static boolean isInt(String num) {
		return isNotEmpty(num) && num.matches("^[1-9]+\\d*$");
	}

	/***
	 * 有效浮点数验证
	 * 
	 * @param phoneNum
	 * @return true|false
	 */
	public final static boolean isFloat(String num) {
		return isNotEmpty(num) && num.matches("^[0-9]+\\d*(.?)\\d+$");
	}

	/***
	 * 有效数字验证
	 * 
	 * @param num
	 * @return true|false
	 */
	public final static boolean isNumber(String num) {
		return isNotEmpty(num) && num.matches("^[1-9]+\\d*(.?)\\d+$");
	}

	/***
	 * 只有数字组合
	 * 
	 * @param num
	 * @return true|false
	 */
	public final static boolean isOnlyNum(String num) {
		return isNotEmpty(num) && num.matches("\\d+$");
	}

	/***
	 * 只有数字字母组合
	 * 
	 * @param num
	 * @return true|false
	 */
	public final static boolean isOnlyNumAndLetters(String num) {
		return isNotEmpty(num)
				&& num.matches("^(([A-Za-z]+[0-9]+)+|([0-9]+[A-Za-z]+))+$");
	}

	/****
	 * 空值验证
	 * 
	 * @param Object
	 * @return true|false
	 */
	public final static boolean isNotNull(Object obj) {
		return obj != null;
	}

	/****
	 * 空值验证
	 * 
	 * @param Str
	 * @return true|false
	 */
	public final static boolean isNotEmpty(String str) {
		return isNotNull(str) && str.trim().length() > 0;
	}

	/****
	 * 返回字符长度
	 * 
	 * @param Str
	 *            字符
	 * @return Int
	 */
	public final static int length(String str) {
		return isNotNull(str) ? str.length() : 0;
	}

	/****
	 * 中文字符集
	 * 
	 * @param num
	 * @return true|false
	 */
	public final static boolean isChinese(String num) {
		return isNotEmpty(num) && num.matches("[\u4e00-\u9fa5]+");
	}

	
	

	/***
	 * 字符长度验证
	 * 
	 * @param num
	 * @param minLength
	 *            最小长度
	 * @param maxLength
	 *            最大长度
	 * @return true||false
	 */
	public final static boolean isValidLength(String num, long minLength,
			long maxLength) {
		if (isNotEmpty(num)) {
			final long len = num.length();
			if (len >= minLength && len <= maxLength)
				return true;
		}
		return false;
	}

	/***
	 * 固定字符长度验证
	 * 
	 * @param num
	 * @param length
	 *            固定长度
	 * @return true||false
	 */
	public final boolean isValidLength(String num, long length) {
		return isNotNull(num) && num.length() == length;
	}

	/***
	 * 字符长度验证
	 * 
	 * @param num
	 * @param maxLength
	 *            最大长度
	 * @return true||false
	 */
	public final static boolean isValidMaxLength(String num, long maxLength) {
		return isValidLength(num, 0, maxLength);
	}

	/***
	 * 字符长度验证
	 * 
	 * @param num
	 * @param minLength
	 *            最小长度
	 * @return true||false
	 */
	public final static boolean isValidMinLength(String num, long minLength) {
		return isValidLength(num, minLength, Long.MAX_VALUE);
	}

	/***
	 * 字符转换为日期对象
	 * 
	 * @param source
	 *            日期字符
	 * @param format
	 *            格式
	 * @return Date
	 */
	public final static Date format(String source, String format) {
		Object obj = innerFormat(null, source, format);
		return isNotNull(obj) ? (Date) obj : null;
	}

	/**
	 * 将日期转为字符
	 * 
	 * @param date
	 *            日期对象
	 * @param format
	 *            转换格式【YYYY-MM-DD】
	 * @return String
	 */
	public final static String format(Date date, String format) {
		return innerFormat(date, null, format) + "";
	}

	/**
	 * 日期字符间转换内部实现
	 * 
	 * @param date
	 *            日期对象
	 * @param source
	 *            日期字符
	 * @param format
	 *            格式化字符
	 * @return Object
	 */
	private static Object innerFormat(Date date, String source, String format) {
		SimpleDateFormat fmt = new SimpleDateFormat(
				format == null ? "yyyy-MM-dd" : format);
		if (isNotNull(date))
			return fmt.format(date);
		else if (isNotNull(source))
			try {
				return fmt.parse(source);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		return null;
	}

	/**
	 * 下划线转驼峰字符
	 * 
	 * @param param
	 * @return
	 */
	public static String camelToUnderline(String param) {
		return camelToCharString(param, '_');
	}

	/**
	 * 驼峰字符转 某字符
	 * 
	 * @param param
	 * @param char
	 * @return
	 */
	public static String camelToCharString(String param, char ch) {
		if (!isNotEmpty(param))
			return "";
		int len = param.length();
		StringBuilder sb = new StringBuilder(len);
		for (int i = 0; i < len; i++) {
			char c = param.charAt(i);
			if (Character.isUpperCase(c)) {
				sb.append(ch);
				sb.append(Character.toLowerCase(c));
			} else {
				sb.append(c);
			}
		}
		return sb.toString();
	}

	/**
	 * 下划线转驼峰字符方式一
	 * 
	 * @param param
	 * @return
	 */
	public static String underlineToCamel(String param) {
		return CharStringToCamel2(param, '_');
	}

	/**
	 * 某字符转驼峰字符方式一
	 * 
	 * @param param
	 * @param char
	 * @return
	 */
	public static String CharStringToCamel1(String param, char ch) {
		if (!isNotEmpty(param))
			return "";
		int len = param.length();
		StringBuilder sb = new StringBuilder(len);
		for (int i = 0; i < len; i++) {
			char c = param.charAt(i);
			if (c == ch) {
				if (++i < len) {
					sb.append(Character.toUpperCase(param.charAt(i)));
				}
			} else {
				sb.append(c);
			}
		}
		return sb.toString();
	}

	/**
	 * 某字符转驼峰字符方式一
	 * 
	 * @param param
	 * @param char
	 * @return
	 */
	public static String CharStringToCamel2(String param, char ch) {
		if (!isNotEmpty(param))
			return "";
		StringBuilder sb = new StringBuilder(param);
		Matcher mc = Pattern.compile(ch + "").matcher(param);
		int i = 0;
		while (mc.find()) {
			int position = mc.end() - (i++);
			sb.replace(position - 1, position + 1,
					sb.substring(position, position + 1).toUpperCase());
		}
		return sb.toString();
	}

	/* 
	 * 返回长度为【strLength】的随机数，在前面补0 
	 */  
	public  static String getFixLenthString(int strLength) {  
	      
	    Random rm = new Random();  
	      
	    // 获得随机数  
	    double pross = (1 + rm.nextDouble()) * Math.pow(10, strLength);  
	  
	    // 将获得的获得随机数转化为字符串  
	    String fixLenthString = String.valueOf(pross);  
	  
	    // 返回固定的长度的随机数  
	    return fixLenthString.substring(1, strLength + 1);  
	}  
	
	public static void main(String[] args) {

		/*
		 * String QJstr = "wch"; String QJstr1 = "ｈｅｌｌｏ．．．．８８８８８８"; String
		 * result = ToSBC(QJstr); String result1 = ToDBC(QJstr1);
		 * System.out.println(QJstr + "\n" + result); System.out.println(QJstr1
		 * + "\n" + result1);
		 * System.out.println(StringUtil.isMoblePhone("13668502657"));
		 * System.out.println(StringUtil.isTelPhone("0851-86668888"));
		 * System.out.println(StringUtil.isEmail("0851-sdaf@qq.com"));
		 * System.out.println(StringUtil.isNumber("0851.77"));
		 * System.out.println(StringUtil.isOnlyNumAndLetters("ss22ss44"));
		 * System.out.println(StringUtil.isValidMinLength("ss22ss44", 7));
		 * org.springframework.util.StringUtils.hasLength("ddddd");
		 * System.out.println("--"+("  sadf   ".trim())+"--");
		 * System.out.println(StringUtil.format(new Date(), "yyyy-MM-dd"));
		 * System.out.println(StringUtil.format(StringUtil.format("2015-90-99",
		 * "yyyy-MM-dd"), "yyyy-MM-dd"));
		 * System.out.println(StringUtil.isDateString("20080431"));*
		 */
		// System.out.println(StringUtil.rtrim("2232000","0"));
		/*String[] nmStrings = new String[] { "09.99", "9.99", "900099", "000",
				"sdfe", "89s89sdfdd0" };
		for (String str : nmStrings) {
			if (StringUtil.isFloat(str)) {
				System.out.println(str + "==num");
			} else {
				System.out.println(str + "==no num");
			}
		}*/
		System.out.println(StringUtils.format("2016-02-01","yyyy-MM-DD"));
	}

}
