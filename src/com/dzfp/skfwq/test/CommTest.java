package com.dzfp.skfwq.test;

import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.aisinogz.util.Base64Helper;
import com.dzfp.entity.comm.Data;
import com.dzfp.entity.comm.DataDescription;
import com.dzfp.entity.comm.GlobalInfo;
import com.dzfp.entity.comm.Interface;
import com.dzfp.entity.comm.ReturnStateInfo;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.CompactWriter;
import com.thoughtworks.xstream.io.xml.DomDriver;

/**
 * 报文测试工具
 * 
 * @author 陈捷
 *
 */
public class CommTest {

	public static Interface getIface(String interfaceCode, String dataExchangeId, String reqContentXml) {
		Interface iface = new Interface();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		String reqTime = sdf.format(new Date());

		GlobalInfo globalInfo = new GlobalInfo();
		globalInfo.setAppId("AA0DDF541B152FBA");// 这个是固定值，统一传
		globalInfo.setInterfaceCode(interfaceCode);// 调用接口
		globalInfo.setUserName("520100670739963");// 企业税号
		globalInfo.setPassWord("");// 此项不填，传空字符串
		globalInfo.setRequestCode("");// 此项不填，传空字符串

		globalInfo.setRequestTime(reqTime);// 请求发送时间，格式为yyyy-MM-dd HH:mm:ss
		globalInfo.setResponseCode("");// 此项不填，传空字符串
		globalInfo.setDataExchangeId(dataExchangeId);// 数据请求流水号
		globalInfo.setFjh("");// 此项不填，传空字符串
		globalInfo.setJqbh("");// 此项不填，传空字符串

		iface.setGlobalInfo(globalInfo);

		ReturnStateInfo returnStateInfo = new ReturnStateInfo();
		returnStateInfo.setReturnCode("");// 此项不填，传空字符串
		returnStateInfo.setReturnMessage("");// 此项不填，传空字符串

		iface.setReturnStateInfo(returnStateInfo);

		Data data = new Data();

		String content = Base64Helper.encode(reqContentXml);// 内层报文需要使用Base64加密后再传输
		data.setContent(content);

		DataDescription dataDescription = new DataDescription();
		dataDescription.setCodeType("0");// 此项固定填0
		dataDescription.setEncryptCode("0");// 此项固定填0
		dataDescription.setZipCode("0");// 此项固定填0

		data.setDataDescription(dataDescription);

		iface.setData(data);

		return iface;
	}

	/**
	 * 获取请求报文
	 * 
	 * @param interfaceCode 接口编码
	 * @param dataExchangeId 数据请求流水号（此项唯一）
	 * @param reqContentXml 内层报文
	 * @return
	 */
	public static String getReqXml(String interfaceCode, String dataExchangeId, String reqContentXml) {
		Interface iface = getIface(interfaceCode, dataExchangeId, reqContentXml);
		XStream xStream = new XStream(new DomDriver());
		xStream.autodetectAnnotations(true);
		StringWriter writer = new StringWriter();
		xStream.marshal(iface, new CompactWriter(writer));
		String reqXml = writer.toString();

		// 测试输出报文
		System.out.println("-----------测试输出请求报文-------------");
		System.out.println(reqXml);
		return reqXml;
	}

	public static Interface fromXML(String xml) {
		try {
			XStream xs = new XStream(new DomDriver());
			xs.autodetectAnnotations(true);
			xs.alias("interface", Interface.class);
			xs.aliasAttribute("cls", "class");
			return (Interface) xs.fromXML(xml);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
