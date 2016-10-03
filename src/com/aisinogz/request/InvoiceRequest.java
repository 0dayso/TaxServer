package com.aisinogz.request;

import java.util.List;

public class InvoiceRequest {

	private String infoKind;// 发票类型
	private String sellerAddress;// 当infoKind=2(普通发票)时：若赋值为“1”表示农产品销售发票，若赋值为“2”表示农产品收购发票，其它表示增值税普通发票
	private String infoClientName;// 购方名称
	private String infoClientTaxCode;// 购方税号
	private String infoClientBankAccount;// 购方开户行及账号
	private String infoClientAddressPhone;// 购方地址电话
	private String infoSellerBankAccount;// 销方开户行及账号
	private String infoSellerAddressPhone;// 销方地址电话
	private String infoTaxRate;// 税率，（已授权的税率，17%传17）
	private String infoNotes;// 备注
	private String infoInvoicer;// 开票人
	private String infoChecker;// 复核人，可为空
	private String infoCashier;// 收款人，可为空
	private String infoListName;// 如不为空，则开具销货清单
	private String infoBillNumber;// 销售单据编号，可为空
	private List<Fpmx> listFpmx;// 发票明细

	public String getInfoKind() {
		return infoKind;
	}

	public void setInfoKind(String infoKind) {
		this.infoKind = infoKind;
	}

	public String getSellerAddress() {
		return sellerAddress;
	}

	public void setSellerAddress(String sellerAddress) {
		this.sellerAddress = sellerAddress;
	}

	public String getInfoClientName() {
		return infoClientName;
	}

	public void setInfoClientName(String infoClientName) {
		this.infoClientName = infoClientName;
	}

	public String getInfoClientTaxCode() {
		return infoClientTaxCode;
	}

	public void setInfoClientTaxCode(String infoClientTaxCode) {
		this.infoClientTaxCode = infoClientTaxCode;
	}

	public String getInfoClientBankAccount() {
		return infoClientBankAccount;
	}

	public void setInfoClientBankAccount(String infoClientBankAccount) {
		this.infoClientBankAccount = infoClientBankAccount;
	}

	public String getInfoClientAddressPhone() {
		return infoClientAddressPhone;
	}

	public void setInfoClientAddressPhone(String infoClientAddressPhone) {
		this.infoClientAddressPhone = infoClientAddressPhone;
	}

	public String getInfoSellerBankAccount() {
		return infoSellerBankAccount;
	}

	public void setInfoSellerBankAccount(String infoSellerBankAccount) {
		this.infoSellerBankAccount = infoSellerBankAccount;
	}

	public String getInfoSellerAddressPhone() {
		return infoSellerAddressPhone;
	}

	public void setInfoSellerAddressPhone(String infoSellerAddressPhone) {
		this.infoSellerAddressPhone = infoSellerAddressPhone;
	}

	public String getInfoTaxRate() {
		return infoTaxRate;
	}

	public void setInfoTaxRate(String infoTaxRate) {
		this.infoTaxRate = infoTaxRate;
	}

	public String getInfoNotes() {
		return infoNotes;
	}

	public void setInfoNotes(String infoNotes) {
		this.infoNotes = infoNotes;
	}

	public String getInfoInvoicer() {
		return infoInvoicer;
	}

	public void setInfoInvoicer(String infoInvoicer) {
		this.infoInvoicer = infoInvoicer;
	}

	public String getInfoChecker() {
		return infoChecker;
	}

	public void setInfoChecker(String infoChecker) {
		this.infoChecker = infoChecker;
	}

	public String getInfoCashier() {
		return infoCashier;
	}

	public void setInfoCashier(String infoCashier) {
		this.infoCashier = infoCashier;
	}

	public String getInfoListName() {
		return infoListName;
	}

	public void setInfoListName(String infoListName) {
		this.infoListName = infoListName;
	}

	public String getInfoBillNumber() {
		return infoBillNumber;
	}

	public void setInfoBillNumber(String infoBillNumber) {
		this.infoBillNumber = infoBillNumber;
	}

	public List<Fpmx> getListFpmx() {
		return listFpmx;
	}

	public void setListFpmx(List<Fpmx> listFpmx) {
		this.listFpmx = listFpmx;
	}

}
