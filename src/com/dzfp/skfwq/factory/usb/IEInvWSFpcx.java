package com.dzfp.skfwq.factory.usb;

import com.aisinogz.biz.QryInvBiz;
import com.aisinogz.dev.DevRetCode;
import com.aisinogz.response.QryInvResponse;
import com.aisinogz.util.Base64Helper;
import com.dzfp.entity.comm.Data;
import com.dzfp.entity.comm.ReturnStateInfo;
import com.dzfp.skfwq.entity.request.FpkjcxReq;
import com.dzfp.skfwq.factory.IEInvWSUsbAbstract;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

/**
 * 发票查询业务
 * 
 * @author 陈捷
 *
 */
public class IEInvWSFpcx extends IEInvWSUsbAbstract {

	@Override
	public String request() {
		try {
			String retCode = COMM_FAIL_CODE;
			String retMsg = "发票查询失败";
			ReturnStateInfo returnStateInfo = new ReturnStateInfo();
			returnStateInfo.setReturnCode(retCode);
			returnStateInfo.setReturnMessage(retMsg);
			iface.setReturnStateInfo(returnStateInfo);

			FpkjcxReq fpkjcxReq = getFpkjcxReq();
			QryInvBiz qryInvBiz = new QryInvBiz();
			qryInvBiz.setInfoBillNumber(fpkjcxReq.getFPQQLSH());
			qryInvBiz.setInfoKind(fpkjcxReq.getFPZL_DM());
			qryInvBiz.setInfoTypeCode(fpkjcxReq.getFP_DM());
			qryInvBiz.setInfoNumber(fpkjcxReq.getFP_HM());

			QryInvResponse qryInvResponse = (QryInvResponse) qryInvBiz.handler();
			if (qryInvResponse != null) {
				if (DevRetCode.QRY_INV_SUCCESS.equals(qryInvResponse.getRetCode())) {
					retCode = COMM_SUCCESS_CODE;
					retMsg = qryInvResponse.getRetMsg();
					returnStateInfo.setReturnCode(retCode);

					String content = getFpkjcxRespXml(retCode, retMsg, qryInvResponse);
					content = Base64Helper.encode(content);
					Data data = new Data();
					data.setContent(content);
					iface.setData(data);
				}

				returnStateInfo.setReturnMessage(retMsg);
				iface.setReturnStateInfo(returnStateInfo);
			}

			return parserXml(iface);
		} catch (Exception e) {
			e.printStackTrace();
			return getError("操作异常,发票查询失败");
		}
	}

	private String getFpkjcxRespXml(String retCode, String retMsg, QryInvResponse qryInvResponse) {
		StringBuffer sb = new StringBuffer();
		sb.append("<RESPONSE_FPKJ>");
		sb.append("<RETURNCODE>");
		sb.append(retCode);
		sb.append("</RETURNCODE>");

		sb.append("<RETURNMESSAGE>");
		sb.append(retMsg);
		sb.append("</RETURNMESSAGE>");

		sb.append("<FP_DM>");
		sb.append(qryInvResponse.getInfoTypeCode());
		sb.append("</FP_DM>");

		sb.append("<FP_HM>");
		sb.append(qryInvResponse.getInfoNumber());
		sb.append("</FP_HM>");

		sb.append("<HJBHSJE>");
		sb.append(qryInvResponse.getInfoAmount());
		sb.append("</HJBHSJE>");

		sb.append("<HJSE>");
		sb.append(qryInvResponse.getInfoTaxAmount());
		sb.append("</HJSE>");

		sb.append("<KPRQ>");
		sb.append(qryInvResponse.getInfoInvDate());
		sb.append("</KPRQ>");

		sb.append("<FWMW>");
		sb.append(Base64Helper.encode(qryInvResponse.getInfo()));
		sb.append("</FWMW>");

		sb.append("</RESPONSE_FPKJ>");

		return sb.toString();
	}

	/**
	 * 获取发票查询请求
	 * 
	 * @return
	 */
	private FpkjcxReq getFpkjcxReq() {
		String reqContent = iface.getData().getContent();
		reqContent = Base64Helper.decode(reqContent);
		XStream xs = new XStream(new DomDriver());
		xs.autodetectAnnotations(true);
		xs.alias("REQUEST_FPKJXX_FPJGXX_CX", FpkjcxReq.class);

		FpkjcxReq fpkjcxReq = (FpkjcxReq) xs.fromXML(reqContent);
		return fpkjcxReq;
	}

}
