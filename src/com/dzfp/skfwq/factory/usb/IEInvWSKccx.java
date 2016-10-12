package com.dzfp.skfwq.factory.usb;

import org.apache.commons.lang.StringUtils;

import com.aisinogz.biz.GetInfoBiz;
import com.aisinogz.dev.DevRetCode;
import com.aisinogz.response.GetInfoResponse;
import com.aisinogz.util.Base64Helper;
import com.dzfp.entity.comm.Data;
import com.dzfp.entity.comm.ReturnStateInfo;
import com.dzfp.skfwq.entity.request.FpkccxReq;
import com.dzfp.skfwq.entity.response.FpkccxResp;
import com.dzfp.skfwq.factory.IEInvWSUsbAbstract;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

/**
 * 库存查询业务
 * 
 * @author 陈捷
 *
 */
public class IEInvWSKccx extends IEInvWSUsbAbstract {

	@Override
	public String request() {
		try {
			String retCode = COMM_FAIL_CODE;
			String retMsg = "库存查询失败";
			ReturnStateInfo returnStateInfo = new ReturnStateInfo();
			returnStateInfo.setReturnCode(retCode);
			returnStateInfo.setReturnMessage(Base64Helper.encode(retMsg));
			iface.setReturnStateInfo(returnStateInfo);

			String reqContent = iface.getData().getContent();
			reqContent = Base64Helper.decode(reqContent);
			FpkccxReq fpkccxReq = getFpkccxReq(reqContent);// (FpkccxReq)
															// fromXML(FpkccxReq.class,
															// "REQUEST_COMMON_FPKCCX",
															// reqContent);

			String infoKind = fpkccxReq.getFPZL_DM();
			GetInfoBiz getInfoBiz = new GetInfoBiz();

			getInfoBiz.setInfoKind(infoKind);
			GetInfoResponse getInfoResponse = (GetInfoResponse) getInfoBiz.handler();
			if (getInfoResponse != null) {
				if (DevRetCode.GET_INFO_SUCCESS.equals(getInfoResponse.getRetCode())) {
					retCode = COMM_SUCCESS_CODE;
					retMsg = getInfoResponse.getRetMsg();
					FpkccxResp fpkccxResp = convertFpkccxResp(retCode, retMsg, getInfoResponse);
					String content = parserXmlByObject(fpkccxResp, "RESPONSE_COMMON_FPKCCX");
					content = Base64Helper.encode(content);
					Data data = new Data();
					data.setContent(content);
					iface.setData(data);
					returnStateInfo.setReturnCode(COMM_SUCCESS_CODE);
				} else {
					returnStateInfo.setReturnCode(getInfoResponse.getRetCode());
				}

				returnStateInfo.setReturnMessage(getInfoResponse.getRetMsg());
				iface.setReturnStateInfo(returnStateInfo);
			}

			return parserXml(iface);
		} catch (Exception e) {
			e.printStackTrace();
			return getError("操作异常，库存查询失败");
		}
	}

	private FpkccxReq getFpkccxReq(String reqContent) {
		if (!StringUtils.isNotEmpty(reqContent)) {
			reqContent = getError("报文内容不能为空!");
		}

		try {
			XStream xs = new XStream(new DomDriver());
			xs.autodetectAnnotations(true);
			xs.alias("REQUEST_COMMON_FPKCCX", FpkccxReq.class);
			xs.aliasAttribute("cls", "class");
			return (FpkccxReq) xs.fromXML(reqContent);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	private FpkccxResp convertFpkccxResp(String retCode, String retMsg, GetInfoResponse getInfoResponse) {
		FpkccxResp fpkccxResp = new FpkccxResp();
		fpkccxResp.setRETURNCODE(retCode);
		fpkccxResp.setRETURNMSG(retMsg);
		fpkccxResp.setSYFPFS(getInfoResponse.getInvStock());
		fpkccxResp.setFP_DM(getInfoResponse.getInfoTypeCode());
		fpkccxResp.setFP_HM(getInfoResponse.getInfoNumber());
		return fpkccxResp;
	}
}
