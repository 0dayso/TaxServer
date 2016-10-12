package com.dzfp.skfwq.factory.usb;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.junit.Test;

import com.aisinogz.dev.GoldTaxDev;
import com.aisinogz.response.OpenCardResponse;
import com.aisinogz.util.Base64Helper;
import com.dzfp.entity.comm.Data;
import com.dzfp.entity.comm.Interface;
import com.dzfp.entity.comm.ReturnStateInfo;
import com.dzfp.skfwq.entity.response.Djxxcx;
import com.dzfp.skfwq.entity.response.DjxxcxResp;
import com.dzfp.skfwq.factory.IEInvWSUsbAbstract;
import com.dzfp.skfwq.test.CommTest;

/**
 * 登记信息查询
 * 
 * @author 陈捷
 *
 */
public class IEInvWSDjxxcx extends IEInvWSUsbAbstract {
	private static final Logger LOGGER = Logger.getLogger(IEInvWSDjxxcx.class);

	@Override
	public String request() {
		LOGGER.info("登记信息查询");
		try {

			// 查询之前检查一下金税盘是否已经打开
			if (GoldTaxDev.isOpenCard() == false) {
				GoldTaxDev.openCard();
			}

			ReturnStateInfo returnStateInfo = new ReturnStateInfo();
			String retCode = COMM_FAIL_CODE;
			String retMsg = "登记信息查询失败";
			returnStateInfo.setReturnCode(retCode);
			returnStateInfo.setReturnMessage(Base64Helper.encode(retMsg));
			iface.setReturnStateInfo(returnStateInfo);

			if (GoldTaxDev.isOpenCard() && GoldTaxDev.getOpenCardResponse() != null) {
				OpenCardResponse openCardResponse = GoldTaxDev.getOpenCardResponse();
				// 如果读取到税号，则默认读取成功了
				if (StringUtils.isNotEmpty(openCardResponse.getTaxCode())) {
					retCode = COMM_SUCCESS_CODE;
					retMsg = "登记信息查询成功";
					returnStateInfo.setReturnCode(retCode);
					returnStateInfo.setReturnMessage(Base64Helper.encode(retMsg));
				}

				DjxxcxResp djxxcxResp = new DjxxcxResp();
				djxxcxResp.setRETURNCODE(retCode);
				djxxcxResp.setRETURNMSG(retMsg);
				Djxxcx djxxcx = new Djxxcx();
				djxxcx.setDQSZ("");
				djxxcx.setJQBH(openCardResponse.getMachineNo());
				djxxcx.setNSRMC(openCardResponse.getCorpName());
				djxxcx.setNSRSBH(openCardResponse.getTaxCode());
				djxxcx.setSWJGDM("");
				djxxcx.setSWJGMC("");
				LOGGER.info("登记信息查询成功,纳税人名称:" + djxxcx.getNSRMC() + ",纳税人识别号:" + djxxcx.getNSRSBH());

				List<Djxxcx> listDjxxcxs = new ArrayList<Djxxcx>();
				listDjxxcxs.add(djxxcx);
				djxxcxResp.setListDjxxcxs(listDjxxcxs);
				String content = parserXmlByObject(djxxcxResp, "RESPONSE_COMMON_DJXXCX");
				Data data = new Data();
				data.setContent(Base64Helper.encode(content));
				iface.setData(data);
				iface.setReturnStateInfo(returnStateInfo);
			}

			if (COMM_FAIL_CODE.equals(retCode)) {
				LOGGER.info("登记信息查询失败");
			}

			String responseXml = parserXml(iface);
			return responseXml;
		} catch (Exception e) {
			e.printStackTrace();
			return getError("操作异常" + e.getMessage());
		}
	}

	@Test
	public void testparserDjxxcxResp() {
		DjxxcxResp djxxcxResp = new DjxxcxResp();
		djxxcxResp.setRETURNCODE("0000");
		djxxcxResp.setRETURNMSG("成功");
		Djxxcx djxxcx = new Djxxcx();
		djxxcx.setDQSZ("");
		djxxcx.setJQBH("1");
		djxxcx.setNSRMC("陈捷");
		djxxcx.setNSRSBH("识别号");
		djxxcx.setSWJGDM("南明局");
		djxxcx.setSWJGMC("1520103");

		List<Djxxcx> listDjxxcxs = new ArrayList<Djxxcx>();
		listDjxxcxs.add(djxxcx);
		djxxcxResp.setListDjxxcxs(listDjxxcxs);

		String content = parserXmlByObject(djxxcxResp, "RESPONSE_COMMON_DJXXCX");
		System.out.println(content);
	}

	@Test
	public void testrequest() throws Exception {
		GoldTaxDev.openCard();
		IEInvWSDjxxcx ws = new IEInvWSDjxxcx();
		Interface iface = CommTest.getIface("PI.DJXXCX", "000111", "");
		ws.setIface(iface);
		String content = ws.request();
		System.out.println(content);
	}

	@Test
	public void testenc() {
		String str = "PFJFU1BPTlNFX0NPTU1PTl9ESlhYQ1g+CiAgPENPTU1PTl9ESlhYQ1hTPgogICAgPENPTU1PTl9ESlhYQ1g+CiAgICAgIDxOU1JTQkg+NTIwMTAwOTk5OTk5MDAyPC9OU1JTQkg+CiAgICAgIDxOU1JNQz7oiKrkv6Hln7norq3kvIHkuJo8L05TUk1DPgogICAgICA8U1dKR0RNPjwvU1dKR0RNPgogICAgICA8U1dKR01DPjwvU1dKR01DPgogICAgICA8SlFCSD4yPC9KUUJIPgogICAgICA8RFFTWj48L0RRU1o+CiAgICA8L0NPTU1PTl9ESlhYQ1g+CiAgPC9DT01NT05fREpYWENYUz4KICA8UkVUVVJOQ09ERT4wMDAwPC9SRVRVUk5DT0RFPgogIDxSRVRVUk5NU0c+55m76K6w5L+h5oGv5p+l6K+i5oiQ5YqfPC9SRVRVUk5NU0c+CjwvUkVTUE9OU0VfQ09NTU9OX0RKWFhDWD4=";
		System.out.println(Base64Helper.decode(str));
	}

}
