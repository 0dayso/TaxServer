package com.dzfp.skfwq.entity.request;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

/**
 * 发票开具信息查询请求报文
 * 
 * @author 陈捷
 *
 */
@XStreamAlias("REQUEST_FPKJXX_FPJGXX_CX")
public class FpkjcxReq {

	@XStreamAlias("class")
	@XStreamAsAttribute
	private String cls = "REQUEST_FPKJXX_FPJGXX_CX";

	@XStreamAlias("FPQQLSH")
	private String FPQQLSH;// 发票请求流水号

	@XStreamAlias("FPZL_DM")
	private String FPZL_DM;// 发票种类代码

	@XStreamAlias("FP_DM")
	private String FP_DM;// 发票代码

	@XStreamAlias("FP_HM")
	private String FP_HM;// 发票号码

	public String getFPQQLSH() {
		return FPQQLSH;
	}

	public void setFPQQLSH(String fPQQLSH) {
		FPQQLSH = fPQQLSH;
	}

	public String getCls() {
		return cls;
	}

	public void setCls(String cls) {
		this.cls = cls;
	}

	public String getFPZL_DM() {
		return FPZL_DM;
	}

	public void setFPZL_DM(String fPZL_DM) {
		FPZL_DM = fPZL_DM;
	}

	public String getFP_DM() {
		return FP_DM;
	}

	public void setFP_DM(String fP_DM) {
		FP_DM = fP_DM;
	}

	public String getFP_HM() {
		return FP_HM;
	}

	public void setFP_HM(String fP_HM) {
		FP_HM = fP_HM;
	}

}
