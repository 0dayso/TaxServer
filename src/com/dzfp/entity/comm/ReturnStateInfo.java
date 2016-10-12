package com.dzfp.entity.comm;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("returnStateInfo")
public class ReturnStateInfo {

	@XStreamAlias("returnCode")
	private String returnCode;

	@XStreamAlias("returnMessage")
	private String returnMessage;

	public String getReturnCode() {
		return returnCode;
	}

	public void setReturnCode(String returnCode) {
		this.returnCode = returnCode;
	}

	public String getReturnMessage() {
		return returnMessage;
	}

	public void setReturnMessage(String returnMessage) {
		this.returnMessage = returnMessage;
	}

}
