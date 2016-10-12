package com.dzfp.entity.comm;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

@XStreamAlias("interface")
public class Interface {

	@XStreamAsAttribute
	@XStreamAlias("xmlns")
	protected String xmlns = "";

	@XStreamAsAttribute
	@XStreamAlias("xmlns:xsi")
	protected String xmlns_xsi = "http://www.w3.org/2001/XMLSchema-instance";

	@XStreamAsAttribute
	@XStreamAlias("xsi:schemaLocation")
	protected String schemaLocation = "http://www.chinatax.gov.cn/tirip/dataspec/interfaces.xsd";

	@XStreamAsAttribute
	@XStreamAlias("version")
	protected String version = "DZFP1.0";

	@XStreamAlias("globalInfo")
	private GlobalInfo globalInfo;

	@XStreamAlias("returnStateInfo")
	private ReturnStateInfo returnStateInfo;

	@XStreamAlias("Data")
	private Data data;

	public GlobalInfo getGlobalInfo() {
		return globalInfo;
	}

	public void setGlobalInfo(GlobalInfo globalInfo) {
		this.globalInfo = globalInfo;
	}

	public ReturnStateInfo getReturnStateInfo() {
		return returnStateInfo;
	}

	public void setReturnStateInfo(ReturnStateInfo returnStateInfo) {
		this.returnStateInfo = returnStateInfo;
	}

	public Data getData() {
		return data;
	}

	public void setData(Data data) {
		this.data = data;
	}

}
