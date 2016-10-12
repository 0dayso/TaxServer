package com.dzfp.skfwq.factory;

import org.apache.commons.lang.StringUtils;

import com.dzfp.entity.comm.Interface;
import com.dzfp.util.BeanUtil;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public abstract class IEInvWSAbstract {
	protected Interface iface;
	protected static String COMM_SUCCESS_CODE = "0000";// 公共成功代码
	protected static String COMM_FAIL_CODE = "9999";// 公共错误代码

	public void setIface(Interface iface) {
		this.iface = iface;
	}

	/**
	 * 将相应报文解析成Java实体
	 * 
	 * @param responseXml
	 * @return
	 */
	protected String parserXml(Interface respIface) {
		try {
			XStream xs = new XStream(new DomDriver());
			xs.autodetectAnnotations(true);
			xs.alias("interface", Interface.class);
			xs.aliasAttribute("cls", "class");
			String respXml = xs.toXML(respIface);
			return respXml;
		} catch (Exception e) {
			return getError("解析报文错误");
		}
	}

	/**
	 * 报文内容解析成实体
	 * 
	 * @param xml
	 * @return
	 */
	protected Interface fromXML(String xml) {
		if (!StringUtils.isNotEmpty(xml)) {
			xml = getError("报文内容不能为空!");
		}

		try {
			XStream xs = new XStream(new DomDriver());
			xs.autodetectAnnotations(true);
			xs.alias("interface", Interface.class);
			xs.aliasAttribute("cls", "class");
			return (Interface) xs.fromXML(xml);
		} catch (Exception e) {
			e.printStackTrace();
			XStream xs = new XStream(new DomDriver());
			xs.autodetectAnnotations(true);
			xs.alias("interface", Interface.class);
			xs.aliasAttribute("cls", "class");
			xml = getError("报文解析异常");
			return (Interface) xs.fromXML(xml);
		}
	}

	/**
	 * 根据对象类型，XML别名来获取对象
	 * 
	 * @param obj
	 * @param aliasName
	 * @param xml
	 * @return
	 */
	@Deprecated
	protected Object fromXML1(Object obj, String aliasName, String xml) {
		if (!StringUtils.isNotEmpty(xml)) {
			xml = getError("报文内容不能为空!");
		}
		try {
			XStream xs = new XStream(new DomDriver());
			xs.autodetectAnnotations(true);
			xs.alias(aliasName, obj.getClass());
			xs.aliasAttribute("cls", "class");
			Object retObj = xs.fromXML(xml);
			return retObj;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 发送请求
	 * 
	 * @return 相应报文xml
	 */
	public abstract String request();

	/**
	 * 获取错误消息
	 * 
	 * @param errorMessage 错误信息
	 * @return
	 */
	protected String getError(String errorMessage) {
		IEInvWSError iEInvWSError = (IEInvWSError) BeanUtil.getBean("iEInvWSError");
		// 错误内容需要进行加密
		iEInvWSError.setErrorMessage(errorMessage);
		return iEInvWSError.request();
	}

	protected String parserXmlByObject(Object obj, String aliasName) {
		try {
			XStream xs = new XStream(new DomDriver());
			xs.autodetectAnnotations(true);
			xs.alias(aliasName, obj.getClass());
			xs.aliasAttribute("cls", "class");
			String respXml = xs.toXML(obj);
			return respXml.replace("__", "_");
		} catch (Exception e) {
			return getError("解析报文错误");
		}
	}

}
