package com.dzfp.entity.comm;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("COMMON_NODE")
public class CommonNode {
	
	@XStreamAlias("NAME")
	private String NAME;
	
	@XStreamAlias("VALUE")
	private String VALUE;

	public String getNAME() {
		return NAME;
	}

	public void setNAME(String nAME) {
		NAME = nAME;
	}

	public String getVALUE() {
		return VALUE;
	}

	public void setVALUE(String vALUE) {
		VALUE = vALUE;
	}
	
	

}
