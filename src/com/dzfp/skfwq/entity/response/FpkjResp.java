package com.dzfp.skfwq.entity.response;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 发票开具响应报文
 * 
 * @author 陈捷
 *
 */
@XStreamAlias("RESPONSE_FPKJ")
public class FpkjResp {

	@XStreamAlias("RETURNCODE")
	private String RETURNCODE;// 0000 成功 ，其他失败

	@XStreamAlias("RETURNMESSAGE")
	private String RETURNMESSAGE;// 开票成功，必填项

	@XStreamAlias("HJBHSJE")
	private String HJBHSJE;// 默认为 0，小数点后 ，小数点后 ，小数点后 ，小数点后 2位， 以元为单位精确到分

	@XStreamAlias("HJSE")
	private String HJSE;// 默认为 0，小数点后 ，小数点后 ，小数点后 ，小数点后 2位， 以元为单位精确到分

	@XStreamAlias("KPRQ")
	private String KPRQ;// YYYYMMDDHHMMSS成功必填

	@XStreamAlias("SSYF")
	private String SSYF;// 格式 MM开票成功，必填项

	@XStreamAlias("FP_DM")
	private String FP_DM;// 开票成功，必填

	@XStreamAlias("FP_HM")
	private String FP_HM;// 开票成功，必填

	@XStreamAlias("XHQDBZ")
	private String XHQDBZ;//

	@XStreamAlias("RETCODE")
	private String RETCODE;// 4011 成功，其他失败

	@XStreamAlias("FWMW")
	private String FWMW;// 开票成功，必填项

	@XStreamAlias("JYM")
	private String JYM;// 开票成功，必填项

	@XStreamAlias("SZQM")
	private String SZQM;//

	@XStreamAlias("EWM")
	private String EWM;// 开票成功，必填项

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
