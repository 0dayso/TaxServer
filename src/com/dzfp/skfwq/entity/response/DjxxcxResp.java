package com.dzfp.skfwq.entity.response;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 登记信息查询响应报文
 * 
 * @author 陈捷
 *
 */
@XStreamAlias("RESPONSE_COMMON_DJXXCX")
public class DjxxcxResp {

	@XStreamAlias("COMMON_DJXXCXS")
	private List<Djxxcx> listDjxxcxs;

	@XStreamAlias("RETURNCODE")
	private String RETURNCODE;

	@XStreamAlias("RETURNMSG")
	private String RETURNMSG;

	public List<Djxxcx> getListDjxxcxs() {
		return listDjxxcxs;
	}

	public void setListDjxxcxs(List<Djxxcx> listDjxxcxs) {
		this.listDjxxcxs = listDjxxcxs;
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

}
