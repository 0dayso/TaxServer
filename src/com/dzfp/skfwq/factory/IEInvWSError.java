package com.dzfp.skfwq.factory;

import com.aisinogz.util.Base64Helper;
import com.dzfp.entity.comm.Interface;
import com.dzfp.entity.comm.ReturnStateInfo;

/**
 * 错误提示消息
 * 
 * @author 陈捷
 *
 */
public class IEInvWSError extends IEInvWSAbstract {
	private String errorMessage;

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	@Override
	public String request() {
		Interface iface2 = new Interface();
		ReturnStateInfo returnStateInfo = new ReturnStateInfo();
		returnStateInfo.setReturnCode("9999");
		returnStateInfo.setReturnMessage(Base64Helper.encode(errorMessage));
		iface2.setReturnStateInfo(returnStateInfo);
		return parserXml(iface2);
	}

}
