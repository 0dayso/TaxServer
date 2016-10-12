package com.aisinogz.dev;

/**
 * 设备返回代码
 * 
 * @author 陈捷
 *
 */
public class DevRetCode {
	public static final String OPEN_CARD_SUCCESS = "1011";// 开启金税盘成功
	public static final String CLOSE_CARD_SUCCESS = "9000";// 关闭金税盘成功
	public static final String INVOICE_SUCCESS = "4011";// 开票成功
	public static final String INVOICE_VALID_SUCCESS = "4016";// 发票校验通过
	public static final String CANCEL_INV_SUCCESS = "6011";// 发票作废成功
	public static final String GET_INFO_SUCCESS = "3011";// 发票库存查询读取成功；其它为失败
	public static final String QRY_INV_SUCCESS = "7011";// 发票查询成功；其它失败
}
