package com.dzfp.skfwq.entity.response;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

/**
 * 发票库存查询响应报文
 * 
 * @author 陈捷
 *
 */
@XStreamAlias("RESPONSE_COMMON_FPKCCX")
public class FpkccxResp {

	@XStreamAsAttribute
	@XStreamAlias("class")
	private String cls = "RESPONSE_COMMON_FPKCCX;";

	@XStreamAlias("SYFPFS")
	private String SYFPFS;// 剩余发票份数

	@XStreamAlias("RETURNCODE")
	private String RETURNCODE;

	@XStreamAlias("RETURNMSG")
	private String RETURNMSG;

	@XStreamAlias("FP_DM")
	private String FP_DM;// 开票成功，必填

	@XStreamAlias("FP_HM")
	private String FP_HM;// 开票成功，必填

	public String getSYFPFS() {
		return SYFPFS;
	}

	public void setSYFPFS(String sYFPFS) {
		SYFPFS = sYFPFS;
	}

	public String getRETURNCODE() {
		return RETURNCODE;
	}

	public void setRETURNCODE(String rETURNCODE) {
		RETURNCODE = rETURNCODE;
	}

	public String getRETURNMSG() {
		return RETURNMSG;
	}

	public void setRETURNMSG(String rETURNMSG) {
		RETURNMSG = rETURNMSG;
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
