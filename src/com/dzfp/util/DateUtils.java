package com.dzfp.util;

import java.math.BigInteger;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

/**
 * 日期工具
 * 
 * @author 陈捷
 *
 */
@SuppressWarnings("unused")
public class DateUtils {

	public static final String STYLE_COMPLETE = "yyyy-MM-dd HH:mm:ss";
	public static final String STYLE_ONLY_DATE = "yyyy-MM-dd";

	public static void main(String[] args) {
		String a = "2014-06-26 11:43:52.0";
		String b[] = a.split("\\.");
		String c = b[0];
		String cl = c.replace("-", "");
		String cl1 = cl.replace(" ", "");
		String cl2 = cl1.replace(":", "");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String ndate = sdf.format(new Date());

		BigInteger bj1 = new BigInteger(cl2);
		BigInteger bj2 = new BigInteger(ndate);

		int z = bj2.compareTo(bj1); // bj2>bj1 z=1 bj2=bj1 z=0 bj2<bj1 z=-1

	}

	public static Long getTimeInMillis(String dateTime) throws ParseException {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date date = df.parse(dateTime);
		Calendar dayStart = Calendar.getInstance();
		dayStart.setTime(date);
		return dayStart.getTime().getTime();
	}

	/**
	 * 日期转换工具 将日期类型转换为字符串类型的日期
	 * 
	 * @param dt 日期类型
	 * @return 格式化成'年-月-日'类型的字符串
	 */
	public static String formatDate(Date dt) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(dt);
	}

	/**
	 * 根据formatModel来格式日期类型格式
	 * 
	 * @param dt 日期类型
	 * @param formatModel 格式类型，如yyyy-MM-dd HH:mm:ss
	 * @return 字符串日期格式化类型
	 */
	public static String formatDate(Date dt, String formatModel) {
		SimpleDateFormat sdf = new SimpleDateFormat(formatModel);
		return sdf.format(dt);
	}

	/**
	 * 日期格式化成"yyyy-MM-dd HH:mm:ss"
	 * 
	 * @param dt
	 * @return
	 */
	public static String getYyyyMMddHHmmss(Date dt) {
		return DateUtils.formatDate(dt, STYLE_COMPLETE);
	}

	/**
	 * 日期格式化成"yyyy-MM-dd"
	 * 
	 * @param dt
	 * @return
	 */
	public static String getYyyyMMdd(Date dt) {
		return DateUtils.formatDate(dt, STYLE_ONLY_DATE);
	}

	@Test
	public void test() {
		System.out.println(DateUtils.getYyyyMMddHHmmss(new Date()));
	}

	/**
	 * 将日期格式话成年月日的格式
	 * 
	 * @param dt 日期类型
	 * @return yyyyMMdd 日期类型字符串
	 */
	public static String formatDateAsyyyymmdd(Date dt) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		return sdf.format(dt);
	}

	/**
	 * 将日期格式转换成时分秒毫秒格式
	 * 
	 * @param dt
	 * @return
	 */
	public static String formatTimeAshhmiss(Date dt) {
		SimpleDateFormat sdf = new SimpleDateFormat("HHmmssSSSS");
		return sdf.format(dt);
	}

	/**
	 * 根据输入的时间戳获取当天最小的时间戳（23:59:59）
	 * 
	 * @param timestamp 时间戳
	 * @return
	 */
	public static Long getMinTimeInMillis(Long timestamp) {
		Calendar cal = Calendar.getInstance();
		Calendar calMin = Calendar.getInstance();
		calMin.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
		return calMin.getTimeInMillis();
	}

	/**
	 * 根据输入的时间戳获取当天最大的时间戳（23:59:59）
	 * 
	 * @param timestamp 时间戳
	 * @return
	 */
	public static Long getMaxTimeInMillis(Long timestamp) {
		Calendar cal = Calendar.getInstance();
		Calendar calMax = Calendar.getInstance();
		calMax.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH), 23, 59, 59);
		return calMax.getTimeInMillis();
	}

}
