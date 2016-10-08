package com.aisinogz.biz;

import org.apache.log4j.Logger;
import org.junit.Test;

import com.aisinogz.response.GetInfoResponse;
import com.aisinogz.response.Response;

/**
 * 查询库存发票
 * 
 * @author 陈捷
 *
 */
public class GetInfoBiz extends CardBizAbstract {
	private static final Logger LOGGER = Logger.getLogger(GetInfoBiz.class);
	private String infoKind;

	public void setInfoKind(String infoKind) {
		this.infoKind = infoKind;
	}

	@Override
	protected Response process() throws Exception {
		LOGGER.info("查询库存");
		put("InfoKind", infoKind);
		call("GetInfo");

		GetInfoResponse queryStoreResponse = new GetInfoResponse();
		queryStoreResponse.setRetCode(getField("RetCode"));
		queryStoreResponse.setRetMsg(getField("RetMsg"));
		queryStoreResponse.setInfoTypeCode(getField("InfoTypeCode"));
		queryStoreResponse.setInfoNumber(getField("InfoNumber"));
		queryStoreResponse.setInvStock(getField("InvStock"));
		queryStoreResponse.setTaxClock(getField("TaxClock"));

		LOGGER.info("查询库存返回:" + queryStoreResponse.getRetMsg());
		return queryStoreResponse;
	}

	@Test
	public void test1() throws Exception {
		GetInfoBiz biz = new GetInfoBiz();
		biz.setInfoKind("0");
		GetInfoResponse resp = (GetInfoResponse) biz.handler();
		if (resp != null) {
			System.out.println(resp.getInfoTypeCode());
			System.out.println(resp.getInfoNumber());
			System.out.println(resp.getInvStock());
			System.out.println(resp.getTaxClock());
		}
	}
}
