package com.dzfp.entity.comm;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("Data")
public class Data {

	@XStreamAlias("dataDescription")
	private DataDescription dataDescription;

	@XStreamAlias("content")
	private String content;

	public DataDescription getDataDescription() {
		return dataDescription;
	}

	public void setDataDescription(DataDescription dataDescription) {
		this.dataDescription = dataDescription;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
