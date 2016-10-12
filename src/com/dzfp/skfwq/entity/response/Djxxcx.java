package com.dzfp.skfwq.entity.response;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 登记信息查询
 * 
 * @author 陈捷
 *
 */
@XStreamAlias("COMMON_DJXXCX")
public class Djxxcx {

	@XStreamAlias("NSRSBH")
	private String NSRSBH;// 纳税人识别号

	@XStreamAlias("NSRMC")
	private String NSRMC;// 纳税人名称

	@XStreamAlias("SWJGDM")
	private String SWJGDM;// 税务机构代码

	@XStreamAlias("SWJGMC")
	private String SWJGMC;// 税务机构名称

	@XStreamAlias("JQBH")
	private String JQBH;// 机器编号

	@XStreamAlias("DQSZ")
	private String DQSZ;// 当前时钟

	public String getNSRSBH() {
		return NSRSBH;
	}

	public void setNSRSBH(String nSRSBH) {
		NSRSBH = nSRSBH;
	}

	public String getNSRMC() {
		return NSRMC;
	}

	public void setNSRMC(String nSRMC) {
		NSRMC = nSRMC;
	}

	public String getSWJGDM() {
		return SWJGDM;
	}

	public void setSWJGDM(String sWJGDM) {
		SWJGDM = sWJGDM;
	}

	public String getSWJGMC() {
		return SWJGMC;
	}

	public void setSWJGMC(String sWJGMC) {
		SWJGMC = sWJGMC;
	}

	public String getJQBH() {
		return JQBH;
	}

	public void setJQBH(String jQBH) {
		JQBH = jQBH;
	}

	public String getDQSZ() {
		return DQSZ;
	}

	public void setDQSZ(String dQSZ) {
		DQSZ = dQSZ;
	}

}
