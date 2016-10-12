package com.dzfp.entity.comm;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

@XStreamAlias("COMMON_NODES")
public class CommonNodes {
	
	@XStreamAsAttribute
	@XStreamAlias("class")
	private String cls="COMMON_NODE;";
	
	@XStreamAsAttribute
	@XStreamAlias("size")
	private String size;
	
	@XStreamImplicit
	private List<CommonNode> CommonNode;

	public List<CommonNode> getCommonNode() {
		return CommonNode;
	}

	public void setCommonNode(List<CommonNode> commonNode) {
		this.CommonNode = commonNode;
		this.size = String.valueOf(commonNode.size());
	}

	public String getSize() {
		return size;
	}

	
	
	

}
