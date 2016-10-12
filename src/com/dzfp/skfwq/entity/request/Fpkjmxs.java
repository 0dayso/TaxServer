package com.dzfp.skfwq.entity.request;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

@XStreamAlias("FP_KJMXS")
public class Fpkjmxs {

	@XStreamAlias("class")
	@XStreamAsAttribute
	private String cls = "FP_KJMX;";

	@XStreamAlias("size")
	@XStreamAsAttribute
	private String size;

	@XStreamImplicit
	private List<Fpkjmx> listFpkjmx;


	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public List<Fpkjmx> getListFpkjmx() {
		return listFpkjmx;
	}

	public void setListFpkjmx(List<Fpkjmx> listFpkjmx) {
		this.listFpkjmx = listFpkjmx;
	}

}
