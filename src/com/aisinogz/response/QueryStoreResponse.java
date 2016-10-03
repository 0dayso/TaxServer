package com.aisinogz.response;

public class QueryStoreResponse extends Response {
	private String infoTypeCode;
	private String infoNumber;
	private String invStock;
	private String taxClock;

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

}
