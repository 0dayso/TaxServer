package com.dzfp.skfwq.entity.request;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

/**
 * 发票开具请求报文
 * 
 * @author 陈捷
 *
 */
@XStreamAlias("REQUEST_FPKJ")
public class FpkjReq {
	@XStreamAlias("class")
	@XStreamAsAttribute
	private String cls = "REQUEST_FPKJ";

	@XStreamAlias("GHFMC")
	private String GHFMC;// 购货方名称

	@XStreamAlias("GHF_NSRSBH")
	private String GHF_NSRSBH;// 购货方纳税人识别号

	@XStreamAlias("FKFKHYH_FKFYHZH")
	private String FKFKHYH_FKFYHZH;// 付款方银行及账号

	@XStreamAlias("FKFDZ_FKFDH")
	private String FKFDZ_FKFDH;// 付款方地址及电话

	@XStreamAlias("XHFKHYH_SKFYHZH")
	private String XHFKHYH_SKFYHZH;// 销货方开户银行及银行账号

	@XStreamAlias("XHFDZ_XHFDH")
	private String XHFDZ_XHFDH;// 销货方地址电话

	@XStreamAlias("FPZL_DM")
	private String FPZL_DM;// 发票种类代码

	@XStreamAlias("YFP_DM")
	private String YFP_DM;// 原发票代码

	@XStreamAlias("YFP_HM")
	private String YFP_HM;// 原发票号码

	@XStreamAlias("BZ")
	private String BZ;// 备注信息

	@XStreamAlias("KPY")
	private String KPY;// 开票人

	@XStreamAlias("FHR")
	private String FHR;// 复核人

	@XStreamAlias("SKY")
	private String SKR;// 收款人

	@XStreamAlias("XHQD")
	private String XHQD;// 清单标识

	@XStreamAlias("FPQQLSH")
	private String FPQQLSH;// 请求流水号

	@XStreamAlias("KPLX")
	private String KPLX;// 开票类型

	@XStreamAlias("JSHJ")
	private String JSHJ;// 价税合计金额

	@XStreamAlias("HJJE")
	private String HJJE;// 合计金额

	@XStreamAlias("HJSE")
	private String HJSE;// 合计税额

	@XStreamAlias("BMB_BBH")
	private String BMB_BBH;// 编码版本号

	@XStreamAlias("FP_KJMXS")
	private Fpkjmxs fpkjmxs;// 发票开具明细

	public String getGHFMC() {
		return GHFMC;
	}

	public void setGHFMC(String gHFMC) {
		GHFMC = gHFMC;
	}

	public String getGHF_NSRSBH() {
		return GHF_NSRSBH;
	}

	public void setGHF_NSRSBH(String gHF_NSRSBH) {
		GHF_NSRSBH = gHF_NSRSBH;
	}

	public String getFKFKHYH_FKFYHZH() {
		return FKFKHYH_FKFYHZH;
	}

	public void setFKFKHYH_FKFYHZH(String fKFKHYH_FKFYHZH) {
		FKFKHYH_FKFYHZH = fKFKHYH_FKFYHZH;
	}

	public String getFKFDZ_FKFDH() {
		return FKFDZ_FKFDH;
	}

	public void setFKFDZ_FKFDH(String fKFDZ_FKFDH) {
		FKFDZ_FKFDH = fKFDZ_FKFDH;
	}

	public String getXHFKHYH_SKFYHZH() {
		return XHFKHYH_SKFYHZH;
	}

	public void setXHFKHYH_SKFYHZH(String xHFKHYH_SKFYHZH) {
		XHFKHYH_SKFYHZH = xHFKHYH_SKFYHZH;
	}

	public String getXHFDZ_XHFDH() {
		return XHFDZ_XHFDH;
	}

	public void setXHFDZ_XHFDH(String xHFDZ_XHFDH) {
		XHFDZ_XHFDH = xHFDZ_XHFDH;
	}

	public String getFPZL_DM() {
		return FPZL_DM;
	}

	public void setFPZL_DM(String fPZL_DM) {
		FPZL_DM = fPZL_DM;
	}

	public String getYFP_DM() {
		return YFP_DM;
	}

	public void setYFP_DM(String yFP_DM) {
		YFP_DM = yFP_DM;
	}

	public String getYFP_HM() {
		return YFP_HM;
	}

	public void setYFP_HM(String yFP_HM) {
		YFP_HM = yFP_HM;
	}

	public String getBZ() {
		return BZ;
	}

	public void setBZ(String bZ) {
		BZ = bZ;
	}

	public String getKPY() {
		return KPY;
	}

	public void setKPY(String kPY) {
		KPY = kPY;
	}

	public String getFHR() {
		return FHR;
	}

	public void setFHR(String fHR) {
		FHR = fHR;
	}

	public String getSKR() {
		return SKR;
	}

	public void setSKR(String sKR) {
		SKR = sKR;
	}

	public String getXHQD() {
		return XHQD;
	}

	public void setXHQD(String xHQD) {
		XHQD = xHQD;
	}

	public String getFPQQLSH() {
		return FPQQLSH;
	}

	public void setFPQQLSH(String fPQQLSH) {
		FPQQLSH = fPQQLSH;
	}

	public String getKPLX() {
		return KPLX;
	}

	public void setKPLX(String kPLX) {
		KPLX = kPLX;
	}

	public String getJSHJ() {
		return JSHJ;
	}

	public void setJSHJ(String jSHJ) {
		JSHJ = jSHJ;
	}

	public String getHJJE() {
		return HJJE;
	}

	public void setHJJE(String hJJE) {
		HJJE = hJJE;
	}

	public String getHJSE() {
		return HJSE;
	}

	public void setHJSE(String hJSE) {
		HJSE = hJSE;
	}

	public Fpkjmxs getFpkjmxs() {
		return fpkjmxs;
	}

	public void setFpkjmxs(Fpkjmxs fpkjmxs) {
		this.fpkjmxs = fpkjmxs;
	}

	public String getBMB_BBH() {
		return BMB_BBH;
	}

	public void setBMB_BBH(String bMB_BBH) {
		BMB_BBH = bMB_BBH;
	}

}
