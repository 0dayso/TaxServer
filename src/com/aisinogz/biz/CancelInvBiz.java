package com.aisinogz.biz;

import org.apache.log4j.Logger;
import org.junit.Test;

import com.aisinogz.response.Response;

public class CancelInvBiz extends CardBizAbstract {
	private static final Logger LOGGER = Logger.getLogger(CancelInvBiz.class);
	private String infoKind;// 发票种类（0：专用发票 2：普通发票11：货物运输业增值税专用发票 12：机动车销售统一发票
	private String infoTypeCode;// 要作废发票的十位代码
	private String infoNumber;// 要作废发票的号码

	public void setInfoKind(String infoKind) {
		this.infoKind = infoKind;
	}

	public void setInfoTypeCode(String infoTypeCode) {
		this.infoTypeCode = infoTypeCode;
	}

	public void setInfoNumber(String infoNumber) {
		this.infoNumber = infoNumber;
	}

	@Override
	protected Response process() throws Exception {
		LOGGER.info("发票作废");
		Response response = new Response();
		setCancelInv();
		call("CancelInv");
		response.setRetCode(getField("RetCode"));
		response.setRetMsg(getField("RetMsg"));
		LOGGER.info("发票作废返回:" + response.getRetMsg());
		return response;
	}

	private void setCancelInv() {
		setField("InfoKind", infoKind);
		setField("InfoTypeCode", infoTypeCode);
		setField("InfoNumber", infoNumber);
	}

	@Test
	public void test1() throws Exception {
		CancelInvBiz cancelInvBiz = new CancelInvBiz();
		cancelInvBiz.setInfoKind("0");
		cancelInvBiz.setInfoTypeCode("5200093140");
		cancelInvBiz.setInfoNumber("11184831");

		cancelInvBiz.handler();
	}

}
