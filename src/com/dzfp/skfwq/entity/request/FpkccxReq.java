package com.dzfp.skfwq.entity.request;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

/**
 * 发票库存查询请求报文
 * 
 * @author 陈捷
 *
 */
@XStreamAlias("REQUEST_COMMON_FPKCCX")
public class FpkccxReq {

	@XStreamAsAttribute
	@XStreamAlias("class")
	private String cls = "REQUEST_COMMON_FPKCCX";

	@XStreamAlias("NSRSBH")
	private String NSRSBH;

	@XStreamAlias("FPZL_DM")
	private String FPZL_DM;

	public String getCls() {
		return cls;
	}

	public void setCls(String cls) {
		this.cls = cls;
	}

	public String getNSRSBH() {
		return NSRSBH;
	}

	public void setNSRSBH(String nSRSBH) {
		NSRSBH = nSRSBH;
	}

	public String getFPZL_DM() {
		return FPZL_DM;
	}

	public void setFPZL_DM(String fPZL_DM) {
		FPZL_DM = fPZL_DM;
	}

}
