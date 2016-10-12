package com.dzfp.skfwq.entity.request;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("FP_KJMX")
public class Fpkjmx {

	@XStreamAlias("SPMC")
	private String SPMC;// 商品名称

	@XStreamAlias("SM")
	private String SM;// 税目

	@XStreamAlias("SL")
	private String SL;// 税率

	@XStreamAlias("GGXH")
	private String GGXH;// 规格型号

	@XStreamAlias("JLDW")
	private String JLDW;// 计量单位

	@XStreamAlias("SPSL")
	private String SPSL;// 商品数量

	@XStreamAlias("SPDJ")
	private String SPDJ;// 商品单价

	@XStreamAlias("SPJE")
	private String SPJE;// 商品金额

	@XStreamAlias("FPHXZ")
	private String FPHXZ;// 发票行性质

	@XStreamAlias("HSJBZ")
	private String HSJBZ;// 含税价标志

	@XStreamAlias("SE")
	private String SE;// 税额

	@XStreamAlias("SPBM")
	private String SPBM;// 商品编码

	@XStreamAlias("ZXBM")
	private String ZXBM;// 自行编码

	@XStreamAlias("YHZCBS")
	private String YHZCBS;// 优惠政策标识

	@XStreamAlias("LSLBS")
	private String LSLBS;// 零税率标志

	@XStreamAlias("ZZSTSGL")
	private String ZZSTSGL;// 增值税特殊管理

	public String getSPMC() {
		return SPMC;
	}

	public void setSPMC(String sPMC) {
		SPMC = sPMC;
	}

	public String getSM() {
		return SM;
	}

	public void setSM(String sM) {
		SM = sM;
	}

	public String getSL() {
		return SL;
	}

	public void setSL(String sL) {
		SL = sL;
	}

	public String getGGXH() {
		return GGXH;
	}

	public void setGGXH(String gGXH) {
		GGXH = gGXH;
	}

	public String getJLDW() {
		return JLDW;
	}

	public void setJLDW(String jLDW) {
		JLDW = jLDW;
	}

	public String getSPSL() {
		return SPSL;
	}

	public void setSPSL(String sPSL) {
		SPSL = sPSL;
	}

	public String getSPDJ() {
		return SPDJ;
	}

	public void setSPDJ(String sPDJ) {
		SPDJ = sPDJ;
	}

	public String getSPJE() {
		return SPJE;
	}

	public void setSPJE(String sPJE) {
		SPJE = sPJE;
	}

	public String getFPHXZ() {
		return FPHXZ;
	}

	public void setFPHXZ(String fPHXZ) {
		FPHXZ = fPHXZ;
	}

	public String getHSJBZ() {
		return HSJBZ;
	}

	public void setHSJBZ(String hSJBZ) {
		HSJBZ = hSJBZ;
	}

	public String getSE() {
		return SE;
	}

	public void setSE(String sE) {
		SE = sE;
	}

	public String getSPBM() {
		return SPBM;
	}

	public void setSPBM(String sPBM) {
		SPBM = sPBM;
	}

	public String getZXBM() {
		return ZXBM;
	}

	public void setZXBM(String zXBM) {
		ZXBM = zXBM;
	}

	public String getYHZCBS() {
		return YHZCBS;
	}

	public void setYHZCBS(String yHZCBS) {
		YHZCBS = yHZCBS;
	}

	public String getLSLBS() {
		return LSLBS;
	}

	public void setLSLBS(String lSLBS) {
		LSLBS = lSLBS;
	}

	public String getZZSTSGL() {
		return ZZSTSGL;
	}

	public void setZZSTSGL(String zZSTSGL) {
		ZZSTSGL = zZSTSGL;
	}

}
