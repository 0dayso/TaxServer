package com.dzfp.skfwq.factory;

import org.apache.commons.lang.StringUtils;

import com.dzfp.entity.comm.GlobalInfo;
import com.dzfp.entity.comm.Interface;
import com.dzfp.util.BeanUtil;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

/**
 * 发票业务处理Factory
 * 
 * @author 陈捷
 *
 */
public class IEInvWSFactory {
	private IEInvWSAbstract ieInvWS;

	public IEInvWSAbstract createIEInvWS(String requestXml) {
		XStream xs = new XStream(new DomDriver());
		xs.autodetectAnnotations(true);
		xs.alias("interface", Interface.class);
		xs.aliasAttribute("cls", "class");
		try {
			Interface iface = (Interface) xs.fromXML(requestXml);
			GlobalInfo globalInfo = iface.getGlobalInfo();
			if (globalInfo == null) {
				return getError("解析报文错误，globalInfo节点内容不合法");
			}

			String interfaceCode = globalInfo.getInterfaceCode();
			if (!StringUtils.isNotEmpty(interfaceCode)) {
				return getError("解析报文错误,interfaceCode不能为空");
			}

			// 登记信息查询
			if (IEInvWSCode.INTERFACE_CODE_DJXXCX.equals(interfaceCode)) {
				ieInvWS = (IEInvWSAbstract) BeanUtil.getBean("iEInvWSDjxxcx");
				ieInvWS.setIface(iface);
				return ieInvWS;
			}

			// 发票开具
			if (IEInvWSCode.INTERFACE_CODE_FPKJ.equals(interfaceCode)) {
				ieInvWS = (IEInvWSAbstract) BeanUtil.getBean("iEInvWSFpkj");
				ieInvWS.setIface(iface);
				return ieInvWS;
			}

			// 库存查询
			if (IEInvWSCode.INTERFACE_CODE_KCCX.equals(interfaceCode)) {
				ieInvWS = (IEInvWSAbstract) BeanUtil.getBean("iEInvWSKccx");
				ieInvWS.setIface(iface);
				return ieInvWS;
			}

			// 发票（已开）查询
			if (IEInvWSCode.INTERFACE_CODE_FPKJCX.equals(interfaceCode)) {
				ieInvWS = (IEInvWSAbstract) BeanUtil.getBean("iEInvWSFpcx");
				ieInvWS.setIface(iface);
				return ieInvWS;
			}


			return getError("请求报文interfaceCode不合法");
		} catch (Exception e) {
			return getError("解析报文错误,报文内容不合法");
		}

	}

	private IEInvWSAbstract getError(String errorMessage) {
		IEInvWSError iEInvWSError = (IEInvWSError) BeanUtil.getBean("iEInvWSError");
		iEInvWSError.setErrorMessage(errorMessage);
		return iEInvWSError;
	}

}
