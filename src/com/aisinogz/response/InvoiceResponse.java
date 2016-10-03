package com.aisinogz.response;

public class InvoiceResponse extends Response {

	private String infoAmount;// 合计不含税金额
	private String infoTaxAmount;// 合计税额
	private String infoDate;// 开票日期
	private String infoMonth;// 所属月份
	private String infoTypeCode;// 发票十位代码
	private String infoNumber;// 发票号码
	private String goodsListFlag;// 销货清单标志，0–非清单，1–清单票
	private String invStock;// 发票剩余份数
	private String taxClock;// 金税盘时钟
	private String isInvEmpty;// 无票标志，1 为金税盘无可开发票，0 为有票
	private String cancelFlag;// 作废标志：0 正常；1 作废
	private String info;// 发票其它信息

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

	public String getInfoDate() {
		return infoDate;
	}

	public void setInfoDate(String infoDate) {
		this.infoDate = infoDate;
	}

	public String getInfoMonth() {
		return infoMonth;
	}

	public void setInfoMonth(String infoMonth) {
		this.infoMonth = infoMonth;
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

	public String getGoodsListFlag() {
		return goodsListFlag;
	}

	public void setGoodsListFlag(String goodsListFlag) {
		this.goodsListFlag = goodsListFlag;
	}

	public String getInvStock() {
		return invStock;
	}

	public void setInvStock(String invStock) {
		this.invStock = invStock;
	}

	public String getTaxClock() {
		return taxClock;
	}

	public void setTaxClock(String taxClock) {
		this.taxClock = taxClock;
	}

	public String getIsInvEmpty() {
		return isInvEmpty;
	}

	public void setIsInvEmpty(String isInvEmpty) {
		this.isInvEmpty = isInvEmpty;
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
