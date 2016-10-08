package com.aisinogz.biz;

import org.apache.log4j.Logger;
import org.junit.Test;

import com.aisinogz.response.QryInvResponse;
import com.aisinogz.response.Response;

/**
 * 已开发票查询
 * 
 * @author 陈捷
 *
 */
public class QryInvBiz extends CardBizAbstract {
	private static final Logger LOGGER = Logger.getLogger(QryInvBiz.class);
	private String infoBillNumber;// 销售单据编号
	private String infoKind;// 发票种类（0：专用发票 2：普通发票11：货物运输业增值税专用发票 12：机动车销售统一发票）
	private String infoTypeCode;// 要查询发票的十位代码
	private String infoNumber;// 要查询发票的号码

	public void setInfoBillNumber(String infoBillNumber) {
		this.infoBillNumber = infoBillNumber;
	}

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
		LOGGER.info("发票查询");
		setField("InfoKind", infoKind);
		setField("InfoBillNumber", infoBillNumber);
		setField("InfoTypeCode", infoTypeCode);
		setField("InfoNumber", infoNumber);
		call("QryInv");

		QryInvResponse qryInvResponse = new QryInvResponse();
		qryInvResponse.setRetCode(getField("RetCode"));
		qryInvResponse.setRetMsg(getField("RetMsg"));
		qryInvResponse.setInfoKind(getField("InfoKind"));
		qryInvResponse.setInfoTypeCode(getField("InfoTypeCode"));
		qryInvResponse.setInfoNumber(getField("InfoNumber"));
		qryInvResponse.setInfoBillNumber(getField("InfoBillNumber"));
		qryInvResponse.setInfoAmount(getField("InfoAmount"));
		qryInvResponse.setInfoTaxAmount(getField("InfoTaxAmount"));
		// qryInvResponse.setInfoInvDate(getField("InfoInvDate"));
		// qryInvResponse.setPrintFlag(getField("PrintFlag"));
		qryInvResponse.setUploadFlag(getField("UploadFlag"));
		qryInvResponse.setCancelFlag(getField("CancelFlag"));
		qryInvResponse.setInfo(getField("Info"));

		LOGGER.info("发票查询返回:" + qryInvResponse.getRetMsg());
		return qryInvResponse;
	}

	@Test
	public void test1() throws Exception {
		QryInvBiz qryInvBiz = new QryInvBiz();
		qryInvBiz.setInfoKind("0");
		qryInvBiz.setInfoTypeCode("5200093140");
		qryInvBiz.setInfoNumber("11184831");
		QryInvResponse qryInvResponse = (QryInvResponse) qryInvBiz.handler();
		System.out.println(qryInvResponse.getInfoAmount());
		System.out.println(qryInvResponse.getInfoTaxAmount());
		System.out.println(qryInvResponse.getUploadFlag());
		System.out.println(qryInvResponse.getCancelFlag());
		System.out.println(qryInvResponse.getInfo());
	}

}
