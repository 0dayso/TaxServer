package com.pi.skfwq.service.impl;

import javax.jws.WebService;

import org.apache.commons.lang.StringUtils;

import com.dzfp.skfwq.factory.IEInvWSAbstract;
import com.dzfp.skfwq.factory.IEInvWSError;
import com.dzfp.skfwq.factory.IEInvWSFactory;
import com.dzfp.util.BeanUtil;
import com.pi.skfwq.service.IPInvWebService;

@WebService(endpointInterface = "com.pi.skfwq.service.IPInvWebService", serviceName = "pInvWebService", targetNamespace = "http://skfwq.pi.com")
public class IPInvWebServiceImpl implements IPInvWebService {

	@Override
	public String process(String requestXml) {
		if (!StringUtils.isNotEmpty(requestXml)) {
			IEInvWSError iEInvWSError = new IEInvWSError();
			iEInvWSError.setErrorMessage("报文不能为空");
			return iEInvWSError.request();
		}
		IEInvWSFactory factory = (IEInvWSFactory) BeanUtil.getBean("iEInvWSFactory");
		IEInvWSAbstract iEInvWS = factory.createIEInvWS(requestXml);
		String responseXml = iEInvWS.request();
		return responseXml;
	}

}
