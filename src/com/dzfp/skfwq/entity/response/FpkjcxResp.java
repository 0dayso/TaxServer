package com.dzfp.skfwq.entity.response;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

/**
 * 发票开具信息响应报文
 * 
 * @author 陈捷
 *
 */
@XStreamAlias("RESPONSE_FPKJ")
public class FpkjcxResp {

	@XStreamAlias("class")
	@XStreamAsAttribute
	private String cls = "RESPONSE_FPKJ";

	@XStreamAlias("RETURNCODE")
	private String RETURNCODE;

	@XStreamAlias("RETURNMESSAGE")
	private String RETURNMESSAGE;

	@XStreamAlias("HJBHSJE")
	private String HJBHSJE;

	@XStreamAlias("HJSE")
	private String HJSE;

	@XStreamAlias("KPRQ")
	private String KPRQ;

	@XStreamAlias("SSYF")
	private String SSYF;

	@XStreamAlias("FP_DM")
	private String FP_DM;

	@XStreamAlias("FP_HM")
	private String FP_HM;

	@XStreamAlias("XHQDBZ")
	private String XHQDBZ;

	@XStreamAlias("RETCODE")
	private String RETCODE;

	@XStreamAlias("FWMW")
	private String FWMW;

	@XStreamAlias("JYM")
	private String JYM;

	@XStreamAlias("SZQM")
	private String SZQM;

	@XStreamAlias("EWM")
	private String EWM;

	public String getRETURNCODE() {
		return RETURNCODE;
	}

	public void setRETURNCODE(String rETURNCODE) {
		RETURNCODE = rETURNCODE;
	}

	public String getRETURNMESSAGE() {
		return RETURNMESSAGE;
	}

	public void setRETURNMESSAGE(String rETURNMESSAGE) {
		RETURNMESSAGE = rETURNMESSAGE;
	}

	public String getHJBHSJE() {
		return HJBHSJE;
	}

	public void setHJBHSJE(String hJBHSJE) {
		HJBHSJE = hJBHSJE;
	}

	public String getHJSE() {
		return HJSE;
	}

	public void setHJSE(String hJSE) {
		HJSE = hJSE;
	}

	public String getKPRQ() {
		return KPRQ;
	}

	public void setKPRQ(String kPRQ) {
		KPRQ = kPRQ;
	}

	public String getSSYF() {
		return SSYF;
	}

	public void setSSYF(String sSYF) {
		SSYF = sSYF;
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

	public String getXHQDBZ() {
		return XHQDBZ;
	}

	public void setXHQDBZ(String xHQDBZ) {
		XHQDBZ = xHQDBZ;
	}

	public String getRETCODE() {
		return RETCODE;
	}

	public void setRETCODE(String rETCODE) {
		RETCODE = rETCODE;
	}

	public String getFWMW() {
		return FWMW;
	}

	public void setFWMW(String fWMW) {
		FWMW = fWMW;
	}

	public String getJYM() {
		return JYM;
	}

	public void setJYM(String jYM) {
		JYM = jYM;
	}

	public String getSZQM() {
		return SZQM;
	}

	public void setSZQM(String sZQM) {
		SZQM = sZQM;
	}

	public String getEWM() {
		return EWM;
	}

	public void setEWM(String eWM) {
		EWM = eWM;
	}

}
