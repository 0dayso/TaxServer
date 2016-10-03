package com.aisinogz.biz;

import org.apache.log4j.Logger;
import org.junit.Test;

import com.aisinogz.dev.DevRetCode;
import com.aisinogz.response.OpenCardResponse;
import com.aisinogz.response.Response;

public class OpenCardBiz extends CardBizAbstract {

	private static final Logger LOGGER = Logger.getLogger(OpenCardBiz.class);
	private static boolean isOpenCard = false;
	private static OpenCardResponse openCardResponse = null;

	public static boolean isOpenCard() {
		return isOpenCard;
	}

	@Test
	public void test1() throws Exception {
		OpenCardResponse resp = (OpenCardResponse) handler();
		resp = (OpenCardResponse) handler();
		resp = (OpenCardResponse) handler();
		resp = (OpenCardResponse) handler();
		resp = (OpenCardResponse) handler();
		System.out.println(resp.getRetCode());
		System.out.println(resp.getRetMsg());
		System.out.println(resp.getTaxCode());
		System.out.println(resp.getCorpName());
		System.out.println(resp.getInvLimit());
		System.out.println(resp.getMachineNo());
		System.out.println(resp.getIsInvEmpty());
		System.out.println(resp.getIsRepReached());
		System.out.println(resp.getIsLockReached());
		System.out.println(resp.getCheckCode());
	}

	@Override
	protected Response process() throws Exception {
		if (isOpenCard == false) {
			LOGGER.info("开启金税盘操作");
			call("OpenCard");
			openCardResponse = new OpenCardResponse();
			openCardResponse.setRetCode(getField("RetCode"));
			openCardResponse.setRetMsg(getField("RetMsg"));
			openCardResponse.setInvLimit(getField("InvLimit"));
			openCardResponse.setTaxCode(getField("TaxCode"));
			openCardResponse.setMachineNo(getField("MachineNo"));
			openCardResponse.setIsInvEmpty(getField("IsInvEmpty"));
			openCardResponse.setIsRepReached(getField("IsRepReached"));
			openCardResponse.setIsLockReached(getField("IsLockReached"));
			openCardResponse.setCorpName(getField("CorpName"));
			openCardResponse.setCheckCode(getField("CheckCode"));
			LOGGER.info("开启金税盘返回:" + openCardResponse.getRetMsg());
			if (openCardResponse != null && DevRetCode.OPEN_CARD_SUCCESS.equals(openCardResponse.getRetCode())) {
				isOpenCard = true;
			} else {
				openCardResponse = null;
			}

		}

		return openCardResponse;
	}
}
