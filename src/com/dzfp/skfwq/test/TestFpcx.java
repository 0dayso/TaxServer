package com.dzfp.skfwq.test;

import junit.framework.TestCase;

import com.aisinogz.util.Base64Helper;
import com.dzfp.entity.comm.Interface;
import com.dzfp.skfwq.factory.usb.IEInvWSFpcx;

/**
 * 已开发票查询接口测试
 * 
 * @author 陈捷
 *
 */
public class TestFpcx extends TestCase {

	/**
	 * 返回的内层报文进行解密
	 */
	public void testDecode() {
		String content = "5peg5rOV5p+l6K+i5Yiw5Y+R56Wo5L+h5oGv";
		System.out.println(Base64Helper.decode(content));
	}

	/**
	 * 发票查询测试
	 */
	public void testFpcx1() {
		// 数据请求流水号（演示）
		// String dataExchangeId = "FPCX" +
		// Long.toString(Calendar.getInstance().getTimeInMillis());
		String dataExchangeId = "FPKJ1475054359786";
		// 内层报文
		String content = "<REQUEST_FPKJXX_FPJGXX_CX class=\"REQUEST_FPKJXX_FPJGXX_CX\"><FPQQLSH>" + dataExchangeId + "</FPQQLSH></REQUEST_FPKJXX_FPJGXX_CX>";
		content="<REQUEST_FPKJXX_FPJGXX_CX><FPZL_DM>0</FPZL_DM><FP_DM>5200093140</FP_DM><FP_HM>11184836</FP_HM></REQUEST_FPKJXX_FPJGXX_CX>";
		// 获取请求报文
		// String reqXml = CommTest.getReqXml("EI.FPKJCX.U.EC.INTRA",
		// dataExchangeId, content);
		Interface iface2 = CommTest.getIface("aaa", "FPKJ1476258034140", content);

		IEInvWSFpcx is = new IEInvWSFpcx();
		is.setIface(iface2);

		/************************************************************/

		// 调用接口，返回响应报文
		String respXml = is.request();
		System.out.println(respXml);
		Interface iface = CommTest.fromXML(respXml);
		if (iface != null && "0000".equals(iface.getReturnStateInfo().getReturnCode())) {
			content = iface.getData().getContent();
			System.out.println(Base64Helper.decode(content));
		}
	}
}
