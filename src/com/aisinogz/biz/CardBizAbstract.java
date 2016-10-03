package com.aisinogz.biz;

import org.apache.log4j.Logger;

import com.aisinogz.dev.GoldTaxDev;
import com.aisinogz.response.Response;
import com.aisinogz.util.DispatchUtil;
import com.jacob.com.Dispatch;

public abstract class CardBizAbstract {
	private static final Logger LOGGER = Logger.getLogger(CardBizAbstract.class);

	protected String getField(String fieldName) {
		return DispatchUtil.getField(GoldTaxDev.getGoldTaxCard(), fieldName);
	}

	protected void setField(String fieldName, Object value) {
		DispatchUtil.setField(GoldTaxDev.getGoldTaxCard(), fieldName, value);
	}

	protected void call(String methodName) {
		Dispatch.call(GoldTaxDev.getGoldTaxCard(), methodName);
	}

	protected void put(String fieldName, Object value) {
		Dispatch.put(GoldTaxDev.getGoldTaxCard(), fieldName, value);
	}

	protected void batchUpload(String param) {
		Dispatch.call(GoldTaxDev.getGoldTaxCard(), "BatchUpload", param);
	}

	public Response handler() throws Exception {
		if (GoldTaxDev.isOpenCard() != true) {
			GoldTaxDev.openCard();
			// 金税盘打开成功才能执行下一步操作
			if (GoldTaxDev.isOpenCard() != true) {
				LOGGER.error("开启金税盘失败");
				throw new Exception("开启金税盘失败");
			}
		}

		return process();
	}

	protected abstract Response process() throws Exception;
}
