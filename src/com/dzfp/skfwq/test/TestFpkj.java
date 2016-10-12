package com.dzfp.skfwq.test;

import java.io.StringWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import junit.framework.TestCase;

import com.aisinogz.util.Base64Helper;
import com.dzfp.entity.comm.Interface;
import com.dzfp.skfwq.entity.request.FpkjReq;
import com.dzfp.skfwq.entity.request.Fpkjmx;
import com.dzfp.skfwq.entity.request.Fpkjmxs;
import com.dzfp.skfwq.factory.usb.IEInvWSFpkj;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.CompactWriter;
import com.thoughtworks.xstream.io.xml.DomDriver;

/**
 * 发票开具接口测试
 * 
 * @author 陈捷
 *
 */
public class TestFpkj extends TestCase {

	/**
	 * 返回的内层报文进行解析
	 */
	public void testDecode() {
		String content = "PFJFU1BPTlNFX0ZQS0o+CiAgPFJFVFVSTkNPREU+MDAwMDwvUkVUVVJOQ09ERT4KICA8UkVUVVJOTUVTU0FHRT40MDExLeW8gOelqOaIkOWKn1swMDAwLF08L1JFVFVSTk1FU1NBR0U+CiAgPEhKQkhTSkU+MC42NjwvSEpCSFNKRT4KICA8SEpTRT4wLjE3PC9ISlNFPgogIDxLUFJRPlR1ZSBPY3QgMTEgMTg6NTQ6NDMgQ1NUIDIwMTY8L0tQUlE+CiAgPFNTWUY+MTA8L1NTWUY+CiAgPEZQX0RNPjUyMDAwOTMxNDA8L0ZQX0RNPgogIDxGUF9ITT4xMTE4NDgzNTwvRlBfSE0+CiAgPFhIUURCWj4xPC9YSFFEQlo+CiAgPFJFVENPREU+MTY1PC9SRVRDT0RFPgogIDxGV01XPlBEOTRiV3dnZG1WeWMybHZiajBpTVM0d0lpQmxibU52WkdsdVp6MGlSMEpMSWo4K1BFbE9SazgrUEZOWVNENDFQQzlUV0VnK1BGTlpTRDQwT0RjMFBDOVRXVWcrUEM5SlRrWlBQZz09PC9GV01XPgo8L1JFU1BPTlNFX0ZQS0o+";
		System.out.println(Base64Helper.decode(content));
	}

	/**
	 * 测试发票开具
	 */
	public void testFpkj() {

		// 接口编码
		String interfaceCode = "EI.FPKJ.U.EC.INTRA";
		// 数据请求流水号（演示）
		String dataExchangeId = "FPKJ" + Long.toString(Calendar.getInstance().getTimeInMillis());
		// String dataExchangeId = "FPKJ1474965839676";
		// 获取发票开具内层报文
		String content = getFpkjXmlFromEntiy(dataExchangeId);

		Interface iface2 = CommTest.getIface(interfaceCode, dataExchangeId, content);
		IEInvWSFpkj is = new IEInvWSFpkj();
		is.setIface(iface2);

		// 调用接口，返回响应报文
		String respXml="";
		try {
			respXml = is.request();
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println(respXml);
		Interface iface = CommTest.fromXML(respXml);
		if (iface != null) {
			System.out.println("------------------------------");
			if ("0000".equals(iface.getReturnStateInfo().getReturnCode())) {
				content = iface.getData().getContent();
				System.out.println(Base64Helper.decode(content));
			} else {
				content = iface.getReturnStateInfo().getReturnMessage();
				System.out.println(Base64Helper.decode(content));
			}

		}
	}

	/**
	 * 获取发票开具内层报文
	 * 
	 * @param 请求流水号
	 * @return
	 */
	public String getFpkjXmlFromEntiy(String dataExchangeId) {
		Fpkjmxs fpkjmxs = new Fpkjmxs();
		List<Fpkjmx> listFpkjmx = new ArrayList<Fpkjmx>();

		BigDecimal jshj = new BigDecimal("0.00"), hjje = new BigDecimal("0.00"), hjse = new BigDecimal("0.00");
		jshj.setScale(2);
		hjje.setScale(2);
		hjse.setScale(2);
		Fpkjmx fpkjmx = new Fpkjmx();
		fpkjmx.setSPMC("软件测试服务");
		fpkjmx.setSM("4003");
		fpkjmx.setSL("0.17");
		fpkjmx.setGGXH("1*1");
		fpkjmx.setJLDW("次");
		fpkjmx.setSPSL("1");
		fpkjmx.setSPDJ("0.83");
		fpkjmx.setSPJE("0.83");
		fpkjmx.setFPHXZ("0");
		fpkjmx.setHSJBZ("1");
		fpkjmx.setSE("0.17");
		fpkjmx.setSPBM("001");
		fpkjmx.setZXBM("001");
		fpkjmx.setYHZCBS("0");
		fpkjmx.setLSLBS("0");
		fpkjmx.setZZSTSGL("0");

		hjje = hjje.add(new BigDecimal(fpkjmx.getSPJE()));
		hjse = hjse.add(new BigDecimal(fpkjmx.getSE()));
		listFpkjmx.add(fpkjmx);

		jshj = jshj.add(hjje).add(hjse);
		fpkjmxs.setListFpkjmx(listFpkjmx);
		fpkjmxs.setSize(Integer.toString(listFpkjmx.size()));

		FpkjReq fpkj = new FpkjReq();
		fpkj.setGHFMC("陈捷");
		fpkj.setGHF_NSRSBH("350000000000000000");
		fpkj.setFKFKHYH_FKFYHZH("");
		fpkj.setFKFDZ_FKFDH("花果园W区0851-86818888");
		fpkj.setXHFKHYH_SKFYHZH("");
		fpkj.setXHFDZ_XHFDH("贵阳市云岩区京玖大厦");
		fpkj.setFPZL_DM("0");
		fpkj.setYFP_DM("");// 开具蓝票不需要填，此项传空字符串
		fpkj.setYFP_HM("");// 开具蓝票不需要填，此项传空字符串
		fpkj.setBZ("备注：测试软件重装");
		fpkj.setKPY("航信");
		fpkj.setSKR("航信");
		fpkj.setFHR("航信");
		fpkj.setXHQD("0");
		fpkj.setFPQQLSH(dataExchangeId);
		fpkj.setKPLX("0");

		fpkj.setJSHJ(jshj.toString());
		fpkj.setHJJE(hjje.toString());
		fpkj.setHJSE(hjse.toString());
		fpkj.setBMB_BBH("");// 此项不填，传空字符串

		fpkj.setFpkjmxs(fpkjmxs);

		XStream xs = new XStream(new DomDriver());
		xs.autodetectAnnotations(true);

		StringWriter sw = new StringWriter();
		xs.marshal(fpkj, new CompactWriter(sw));
		return sw.toString().replace("__", "_");
	}

	/**
	 * 获取开具发票的xml
	 * 
	 * @return
	 */
	public static String getFpkjXml() {
		StringBuffer sb = new StringBuffer();

		sb.append("<REQUEST_FPKJ class=\"REQUEST_FPKJ\">");
		sb.append("<GHFMC>陈捷</GHFMC>");
		sb.append("<GHF_NSRSBH>350182198901304359</GHF_NSRSBH>");
		sb.append("<FKFKHYH_FKFYHZH></FKFKHYH_FKFYHZH>");
		sb.append("<FKFDZ_FKFDH>花果园W区0851-86818888</FKFDZ_FKFDH>");

		sb.append("<XHFKHYH_SKFYHZH></XHFKHYH_SKFYHZH>");
		sb.append("<XHFDZ_XHFDH>贵阳市云岩区博泰华庭0851-86816661</XHFDZ_XHFDH>");
		sb.append("<FPZL_DM>0</FPZL_DM>");//
		sb.append("<YFP_DM></YFP_DM>");//
		sb.append("<YFP_HM></YFP_HM>");//

		sb.append("<BZ>备注信息：0851-86810001</BZ>");
		sb.append("<KPR>航信</KPR>");
		sb.append("<FHR>航信</FHR>");
		sb.append("<SKR>航信</SKR>");
		sb.append("<XHQD>1</XHQD>");// 如不为空，则开具销货清单此发票 如不为空，则开具销货清单此发票

		sb.append("<FPQQLSH>AI2016091320590001</FPQQLSH>");
		sb.append("<KPLX>0</KPLX>");// 0蓝票 ，1红票 。
		sb.append("<JSHJ>1.00</JSHJ>");
		sb.append("<HJJE>0.94</HJJE>");
		sb.append("<HJSE>0.06</HJSE>");

		sb.append("<BMB_BBH></BMB_BBH>");// 商品编码版本号，为空则是非商品编码版本
		sb.append("<FP_KJMXS class=\"FP_KJMX;\" size=\"1\">");
		sb.append("<FP_KJMX>");
		sb.append("<SPMC>软件测试服务</SPMC>");
		sb.append("<SM>商业（6%)</SM>");// 税目

		sb.append("<SL>0.06</SL>");
		sb.append("<GGXH>1*1</GGXH>");
		sb.append("<JLDW>次</JLDW>");
		sb.append("<SPSL>1</SPSL>");
		sb.append("<SPDJ>0.94</SPDJ>");

		sb.append("<SPJE>0.94</SPJE>");
		sb.append("<FPHXZ>0</FPHXZ>");// 0 正常
		sb.append("<HSJBZ>1</HSJBZ>");//
		sb.append("<SE>0.06</SE>");
		// sb.append("<SPBM>4003</SPBM>");//
		sb.append("<SPBM>001</SPBM>");//

		sb.append("<ZXBM>001</ZXBM>");
		sb.append("<YHZCBS>0</YHZCBS>");//
		sb.append("<LSLBS>0</LSLBS>");//
		sb.append("<ZZSTSGL>0</ZZSTSGL>");//
		sb.append("</FP_KJMX>");

		sb.append("</FP_KJMXS>");
		sb.append("</REQUEST_FPKJ>");

		return sb.toString();

	}
}
