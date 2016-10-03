package com.aisinogz.dev;

import org.apache.log4j.Logger;

import com.aisinogz.response.OpenCardResponse;
import com.aisinogz.response.Response;
import com.aisinogz.util.DispatchUtil;
import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.Dispatch;

public class GoldTaxDev {
	private static final Logger LOGGER = Logger.getLogger(GoldTaxDev.class);
	private static ActiveXComponent goldTaxCard = null;
	private static boolean isOpenCard = false;
	private static OpenCardResponse openCardResponse = null;

	public static boolean isOpenCard() {
		return isOpenCard;
	}

	public static OpenCardResponse getOpenCardResponse() {
		return openCardResponse;
	}

	private GoldTaxDev() {

	}

	public static ActiveXComponent getGoldTaxCard() {
		if (goldTaxCard == null) {
			init();
		}

		return goldTaxCard;
	}

	/**
	 * 金税设备初始化
	 */
	private static void init() {
		try {
			LOGGER.debug("初始化组件接口");
			goldTaxCard = new ActiveXComponent("TaxCardX.GoldTax");
			Dispatch.put(goldTaxCard, "CertPassWord", "88888888");
		} catch (Exception e) {
			e.printStackTrace();
			goldTaxCard = null;
			LOGGER.error("初始化组件接口失败", e);
		}
	}

	public static void openCard() throws Exception {
		if (isOpenCard == false) {
			LOGGER.info("开启金税盘操作");
			Dispatch.call(goldTaxCard, "OpenCard");
			openCardResponse = new OpenCardResponse();
			openCardResponse.setRetCode(DispatchUtil.getField(goldTaxCard, "RetCode"));
			openCardResponse.setRetMsg(DispatchUtil.getField(goldTaxCard, ("RetMsg")));
			openCardResponse.setInvLimit(DispatchUtil.getField(goldTaxCard, ("InvLimit")));
			openCardResponse.setTaxCode(DispatchUtil.getField(goldTaxCard, ("TaxCode")));
			openCardResponse.setMachineNo(DispatchUtil.getField(goldTaxCard, ("MachineNo")));
			openCardResponse.setIsInvEmpty(DispatchUtil.getField(goldTaxCard, ("IsInvEmpty")));
			openCardResponse.setIsRepReached(DispatchUtil.getField(goldTaxCard, ("IsRepReached")));
			openCardResponse.setIsLockReached(DispatchUtil.getField(goldTaxCard, ("IsLockReached")));
			openCardResponse.setCorpName(DispatchUtil.getField(goldTaxCard, ("CorpName")));
			openCardResponse.setCheckCode(DispatchUtil.getField(goldTaxCard, ("CheckCode")));
			LOGGER.info("开启金税盘返回:" + openCardResponse.getRetMsg());

			if (openCardResponse != null && DevRetCode.OPEN_CARD_SUCCESS.equals(openCardResponse.getRetCode())) {
				isOpenCard = true;
			} else {
				openCardResponse = null;
			}
		}
	}

	public static void closeCard() {
		LOGGER.info("关闭金税盘");
		Dispatch.call(goldTaxCard, "CloseCard");
		Response response = new Response();
		response.setRetCode(DispatchUtil.getField(goldTaxCard, "RetCode"));
		response.setRetMsg(DispatchUtil.getField(goldTaxCard, "RetMsg"));
		LOGGER.info("关闭金税卡返回:" + response.getRetMsg());
		if (DevRetCode.CLOSE_CARD_SUCCESS.equals(response.getRetCode())) {
			// 关闭成功后，销毁对象
			isOpenCard = false;
			openCardResponse = null;
			goldTaxCard = null;
		}
	}

}
