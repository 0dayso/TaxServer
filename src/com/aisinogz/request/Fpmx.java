package com.aisinogz.request;

/**
 * 发票明细
 * 
 * @author 陈捷
 *
 */
public class Fpmx {

	private String listGoodsName;// 商品或劳务名称
	private String listTaxItem;// 税目，4 位数字，商品所属类别
	private String listStandard;// 规格型号
	private String listUnit;// 计量单位
	private String listNumber;// 数量
	private String listPrice;// 单价
	private String listAmount;// 金额,数量、单价和金额如果设置了其中两项，另一项可以不传(为0)，由接口软件计算，如传入则应符合计算关系；当已设置金额时，数量和单价可以同时不传（为0）
	private String listPriceKind;// 含税价标志，单价和金额的种类， 0 为不含税价，1 为含税价
	private String listTaxAmount;// 税额，可以不传（为0），由接口软件计算，如传入则应符合计算关系

	// 额外的batchupload需要的xml
	private String goodsNoVer;// 编码版本号
	private String goodsTaxNo;// 税收分类编码
	private String taxPre;// 是否享受政策优惠，0不享受，1享受
	private String taxPreCon;// 享受优惠政策内容
	private String zeroTax;// 零税率标识，空：非零税率，1免税，2不征收，3普通零税率
	private String cropGoodsNo;// 企业自编码
	private String taxDeduction;// 扣除额，该字段可为空

	public String getListGoodsName() {
		return listGoodsName;
	}

	public void setListGoodsName(String listGoodsName) {
		this.listGoodsName = listGoodsName;
	}

	public String getListTaxItem() {
		return listTaxItem;
	}

	public void setListTaxItem(String listTaxItem) {
		this.listTaxItem = listTaxItem;
	}

	public String getListStandard() {
		return listStandard;
	}

	public void setListStandard(String listStandard) {
		this.listStandard = listStandard;
	}

	public String getListUnit() {
		return listUnit;
	}

	public void setListUnit(String listUnit) {
		this.listUnit = listUnit;
	}

	public String getListNumber() {
		return listNumber;
	}

	public void setListNumber(String listNumber) {
		this.listNumber = listNumber;
	}

	public String getListPrice() {
		return listPrice;
	}

	public void setListPrice(String listPrice) {
		this.listPrice = listPrice;
	}

	public String getListAmount() {
		return listAmount;
	}

	public void setListAmount(String listAmount) {
		this.listAmount = listAmount;
	}

	public String getListPriceKind() {
		return listPriceKind;
	}

	public void setListPriceKind(String listPriceKind) {
		this.listPriceKind = listPriceKind;
	}

	public String getListTaxAmount() {
		return listTaxAmount;
	}

	public void setListTaxAmount(String listTaxAmount) {
		this.listTaxAmount = listTaxAmount;
	}

	public String getGoodsNoVer() {
		return goodsNoVer;
	}

	public void setGoodsNoVer(String goodsNoVer) {
		this.goodsNoVer = goodsNoVer;
	}

	public String getGoodsTaxNo() {
		return goodsTaxNo;
	}

	public void setGoodsTaxNo(String goodsTaxNo) {
		this.goodsTaxNo = goodsTaxNo;
	}

	public String getTaxPre() {
		return taxPre;
	}

	public void setTaxPre(String taxPre) {
		this.taxPre = taxPre;
	}

	public String getTaxPreCon() {
		return taxPreCon;
	}

	public void setTaxPreCon(String taxPreCon) {
		this.taxPreCon = taxPreCon;
	}

	public String getZeroTax() {
		return zeroTax;
	}

	public void setZeroTax(String zeroTax) {
		this.zeroTax = zeroTax;
	}

	public String getCropGoodsNo() {
		return cropGoodsNo;
	}

	public void setCropGoodsNo(String cropGoodsNo) {
		this.cropGoodsNo = cropGoodsNo;
	}

	public String getTaxDeduction() {
		return taxDeduction;
	}

	public void setTaxDeduction(String taxDeduction) {
		this.taxDeduction = taxDeduction;
	}

}
