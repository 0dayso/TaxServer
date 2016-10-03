package com.aisinogz.response;

public class OpenCardResponse extends Response {
	private String invLimit;
	private String taxCode;
	private String machineNo;
	private String isInvEmpty;
	private String isRepReached;
	private String isLockReached;
	private String corpName;
	private String checkCode;

	public String getInvLimit() {
		return invLimit;
	}

	public void setInvLimit(String invLimit) {
		this.invLimit = invLimit;
	}

	public String getTaxCode() {
		return taxCode;
	}

	public void setTaxCode(String taxCode) {
		this.taxCode = taxCode;
	}

	public String getMachineNo() {
		return machineNo;
	}

	public void setMachineNo(String machineNo) {
		this.machineNo = machineNo;
	}

	public String getIsInvEmpty() {
		return isInvEmpty;
	}

	public void setIsInvEmpty(String isInvEmpty) {
		this.isInvEmpty = isInvEmpty;
	}

	public String getIsRepReached() {
		return isRepReached;
	}

	public void setIsRepReached(String isRepReached) {
		this.isRepReached = isRepReached;
	}

	public String getIsLockReached() {
		return isLockReached;
	}

	public void setIsLockReached(String isLockReached) {
		this.isLockReached = isLockReached;
	}

	public String getCorpName() {
		return corpName;
	}

	public void setCorpName(String corpName) {
		this.corpName = corpName;
	}

	public String getCheckCode() {
		return checkCode;
	}

	public void setCheckCode(String checkCode) {
		this.checkCode = checkCode;
	}

}
