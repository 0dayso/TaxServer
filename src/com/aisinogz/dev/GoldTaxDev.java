package com.aisinogz.dev;

import org.apache.log4j.Logger;

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.Dispatch;

public class GoldTaxDev {
	private static final Logger LOGGER = Logger.getLogger(GoldTaxDev.class);
	private static ActiveXComponent goldTaxCard = null;

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

}
