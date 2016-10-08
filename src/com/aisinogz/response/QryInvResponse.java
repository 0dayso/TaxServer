package com.aisinogz.response;

/**
 * 发票查询响应信息
 * 
 * @author 陈捷
 *
 */
public class QryInvResponse extends Response {
	private String infoKind;// 发票种类（0 专用发票；2 普通发票；11 货物运输业增值税专用发票；12 机动车销售统一发票）
	private String infoTypeCode;// 发票代码
	private String infoNumber;// 发票号码
	private String infoBillNumber;// 销售单据编号
	private String infoAmount;// 合计不含税金额
	private String infoTaxAmount;// 合计税额
	private String infoInvDate;// 开票日期
	private String printFlag;// 打印标志（0：已打印，1：未打印）
	private String uploadFlag;// 发票报送状态（0：未报送，1：已报送，2 报送失败，3 报送中，4 验签失败）
	private String cancelFlag;// 作废标志（0：未作废，1：已作废）
	private String info;// 除上述属性之外的其它明细

	public String getInfoKind() {
		return infoKind;
	}

	public void setInfoKind(String infoKind) {
		this.infoKind = infoKind;
	}

	public String getInfoTypeCode() {
		return infoTypeCode;
	}

	public void setInfoTypeCode(String infoTypeCode) {
		this.infoTypeCode = infoTypeCode;
	}

	public String getInfoNumber() {
		return infoNumber;
	}

	public void setInfoNumber(String infoNumber) {
		this.infoNumber = infoNumber;
	}

	public String getInfoBillNumber() {
		return infoBillNumber;
	}

	public void setInfoBillNumber(String infoBillNumber) {
		this.infoBillNumber = infoBillNumber;
	}

	public String getInfoAmount() {
		return infoAmount;
	}

	public void setInfoAmount(String infoAmount) {
		this.infoAmount = infoAmount;
	}

	public String getInfoTaxAmount() {
		return infoTaxAmount;
	}

	public void setInfoTaxAmount(String infoTaxAmount) {
		this.infoTaxAmount = infoTaxAmount;
	}

	public String getInfoInvDate() {
		return infoInvDate;
	}

	public void setInfoInvDate(String infoInvDate) {
		this.infoInvDate = infoInvDate;
	}

	public String getPrintFlag() {
		return printFlag;
	}

	public void setPrintFlag(String printFlag) {
		this.printFlag = printFlag;
	}

	public String getUploadFlag() {
		return uploadFlag;
	}

	public void setUploadFlag(String uploadFlag) {
		this.uploadFlag = uploadFlag;
	}

	public String getCancelFlag() {
		return cancelFlag;
	}

	public void setCancelFlag(String cancelFlag) {
		this.cancelFlag = cancelFlag;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

}
