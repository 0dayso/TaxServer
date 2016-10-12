package com.dzfp.skfwq.test;

import java.util.Calendar;

import org.junit.Test;

import junit.framework.TestCase;

import com.aisinogz.util.Base64Helper;
import com.dzfp.entity.comm.Interface;
import com.dzfp.skfwq.factory.usb.IEInvWSKccx;

/**
 * 库存查询接口测试
 * 
 * @author 陈捷
 *
 */
public class TestKccx extends TestCase {

	/**
	 * 返回的内层报文解密
	 */
	public void test2() {
		String content = "PFJFU1BPTlNFX0NPTU1PTl9GUEtDQ1ggY2xhc3M9IlJFU1BPTlNFX0NPTU1PTl9GUEtDQ1giPg0KCTxTWUZQRlM+Mjg8L1NZRlBGUz4NCgk8UkVUVVJOQ09ERT4wMDAwPC9SRVRVUk5DT0RFPg0KCTxSRVRVUk5NU0c+5p+l6K+i5oiQ5YqfPC9SRVRVUk5NU0c+DQo8L1JFU1BPTlNFX0NPTU1PTl9GUEtDQ1g+";
		System.out.println(Base64Helper.decode(content));
	}

	/**
	 * 
	 */
	@Test
	public void testKccx1() {
		// 内层请求报文
		String content = "<REQUEST_COMMON_FPKCCX><NSRSBH>520100670739963</NSRSBH><FPZL_DM>0</FPZL_DM></REQUEST_COMMON_FPKCCX>";
		// 数据请求流水号（演示）
		String dataExchangeId = "KCCX" + Long.toString(Calendar.getInstance().getTimeInMillis());

		Interface iface2 = CommTest.getIface("KCCX", dataExchangeId, content);

		IEInvWSKccx is = new IEInvWSKccx();
		is.setIface(iface2);
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
