package com.dzfp.skfwq.factory.usb;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.aisinogz.biz.InvoiceBiz;
import com.aisinogz.dev.DevRetCode;
import com.aisinogz.request.Fpmx;
import com.aisinogz.request.InvoiceRequest;
import com.aisinogz.response.InvoiceResponse;
import com.aisinogz.util.Base64Helper;
import com.dzfp.entity.comm.Data;
import com.dzfp.entity.comm.ReturnStateInfo;
import com.dzfp.skfwq.entity.request.FpkjReq;
import com.dzfp.skfwq.entity.request.Fpkjmx;
import com.dzfp.skfwq.entity.response.FpkjResp;
import com.dzfp.skfwq.factory.IEInvWSUsbAbstract;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

/**
 * 发票开具业务
 * 
 * @author 陈捷
 *
 */
public class IEInvWSFpkj extends IEInvWSUsbAbstract {
	private static final Logger LOGGER = Logger.getLogger(IEInvWSFpkj.class);

	@Override
	public String request() {
		LOGGER.info("发票开具");
		try {
			String retCode = COMM_FAIL_CODE;
			String retMsg = "发票开具失败";
			ReturnStateInfo returnStateInfo = new ReturnStateInfo();
			returnStateInfo.setReturnCode(retCode);
			returnStateInfo.setReturnMessage(Base64Helper.encode(retMsg));
			iface.setReturnStateInfo(returnStateInfo);

			// 将iface的data节点下的content解析成发票开具实体
			FpkjReq fpkjReq = getFpkjReq();
			InvoiceRequest invoiceRequest = convertInvoiceRequest(fpkjReq);
			InvoiceBiz invoiceBiz = new InvoiceBiz();
			invoiceBiz.setInvoiceRequest(invoiceRequest);
			invoiceBiz.setCheckEWM("0");// 状态0,：开票，1发票校验
			InvoiceResponse invoiceResponse = (InvoiceResponse) invoiceBiz.handler();
			if (invoiceResponse != null) {
				if (DevRetCode.INVOICE_SUCCESS.equals(invoiceResponse.getRetCode())) {
					FpkjResp fpkjResp = convertFpkjResp(retCode, retMsg, invoiceResponse);
					fpkjResp.setRETURNCODE(COMM_SUCCESS_CODE);
					fpkjResp.setRETURNMESSAGE(invoiceResponse.getRetMsg());
					String content = parserXmlByObject(fpkjResp, "RESPONSE_FPKJ");
					LOGGER.info("开票成功，内层报文:" + content);
					content = Base64Helper.encode(content);
					Data data = new Data();
					data.setContent(content);
					iface.setData(data);
					returnStateInfo.setReturnCode(COMM_SUCCESS_CODE);
					returnStateInfo.setReturnMessage(invoiceResponse.getRetMsg());
				} else {
					returnStateInfo.setReturnCode(invoiceResponse.getRetCode());
				}
				returnStateInfo.setReturnMessage(invoiceResponse.getRetMsg());
				iface.setReturnStateInfo(returnStateInfo);
			}

			return parserXml(iface);
		} catch (Exception e) {
			e.printStackTrace();
			return parserXml(iface);
		}
	}

	/**
	 * 转换开票信息为标准接口内层返回报文
	 * 
	 * @param retCode
	 * @param retMsg
	 * @param invoiceResponse
	 * @return
	 */
	private FpkjResp convertFpkjResp(String retCode, String retMsg, InvoiceResponse invoiceResponse) {
		FpkjResp fpkjResp = new FpkjResp();
		fpkjResp.setRETCODE(retCode);
		fpkjResp.setRETURNMESSAGE(retMsg);
		fpkjResp.setHJBHSJE(invoiceResponse.getInfoAmount());
		fpkjResp.setHJSE(invoiceResponse.getInfoTaxAmount());
		fpkjResp.setKPRQ(invoiceResponse.getInfoDate());
		fpkjResp.setSSYF(invoiceResponse.getInfoMonth());
		fpkjResp.setFP_DM(invoiceResponse.getInfoTypeCode());
		fpkjResp.setFP_HM(invoiceResponse.getInfoNumber());
		fpkjResp.setXHQDBZ(invoiceResponse.getGoodsListFlag());
		fpkjResp.setRETCODE(invoiceResponse.getInvStock());// 底层代码：发票剩余份数
		fpkjResp.setFWMW(Base64Helper.encode(invoiceResponse.getInfo()));// 防伪密文：发票其他信息

		return fpkjResp;
	}

	private InvoiceRequest convertInvoiceRequest(FpkjReq fpkjReq) {
		InvoiceRequest invoiceRequest = new InvoiceRequest();
		invoiceRequest.setInfoKind(fpkjReq.getFPZL_DM());
		invoiceRequest.setSellerAddress(fpkjReq.getXHFDZ_XHFDH());
		invoiceRequest.setInfoClientName(fpkjReq.getGHFMC());
		invoiceRequest.setInfoClientTaxCode(fpkjReq.getGHF_NSRSBH());
		invoiceRequest.setInfoClientBankAccount(fpkjReq.getFKFKHYH_FKFYHZH());
		invoiceRequest.setInfoClientAddressPhone(fpkjReq.getFKFDZ_FKFDH());
		invoiceRequest.setInfoSellerBankAccount(fpkjReq.getXHFKHYH_SKFYHZH());
		invoiceRequest.setInfoSellerAddressPhone(fpkjReq.getXHFDZ_XHFDH());
		// private String infoTaxRate;// 税率，（已授权的税率，17%传17）
		invoiceRequest.setInfoNotes(fpkjReq.getBZ());
		invoiceRequest.setInfoInvoicer(fpkjReq.getKPY());
		invoiceRequest.setInfoChecker(fpkjReq.getFHR());
		invoiceRequest.setInfoCashier(fpkjReq.getSKR());
		invoiceRequest.setInfoListName(fpkjReq.getXHQD());
		invoiceRequest.setInfoBillNumber(fpkjReq.getFPQQLSH());
		List<Fpmx> listFpmx = new ArrayList<Fpmx>();
		List<Fpkjmx> listFpkjmx = fpkjReq.getFpkjmxs().getListFpkjmx();
		boolean isSetInfoTaxRate = false;

		for (Fpkjmx fpkjmx : listFpkjmx) {
			Fpmx fpmx = convertFpmx(fpkjReq.getBMB_BBH(), fpkjmx);
			listFpmx.add(fpmx);
			if (isSetInfoTaxRate == false) {
				// 设置税率,电子发票webcom的标准接口的税率0.17代表17%，在组件接口中，17才代表17%
				Double spsl = Double.valueOf(fpkjmx.getSL());
				spsl = spsl * 100.0;
				invoiceRequest.setInfoTaxRate(spsl.toString());
				LOGGER.info("发票税率:" + invoiceRequest.getInfoTaxRate());

				isSetInfoTaxRate = true;
			}
		}

		invoiceRequest.setListFpmx(listFpmx);

		return invoiceRequest;
	}

	/**
	 * 转换发票明细
	 * 
	 * @param BMB_BBH
	 * @param fpkjmx
	 * @return
	 */
	private Fpmx convertFpmx(String BMB_BBH, Fpkjmx fpkjmx) {
		Fpmx fpmx = new Fpmx();
		fpmx.setListGoodsName(fpkjmx.getSPMC());
		fpmx.setListTaxItem(fpkjmx.getSM());
		fpmx.setListStandard(fpkjmx.getGGXH());
		fpmx.setListUnit(fpkjmx.getJLDW());
		fpmx.setListNumber(fpkjmx.getSPSL());
		fpmx.setListPrice(fpkjmx.getSPDJ());
		fpmx.setListAmount(fpkjmx.getSPJE());
		fpmx.setListPriceKind(fpkjmx.getHSJBZ());
		fpmx.setListTaxAmount(fpkjmx.getSE());

		// 额外的batchupload需要的xml
		fpmx.setGoodsNoVer(BMB_BBH);
		fpmx.setGoodsTaxNo(fpkjmx.getSPBM());
		fpmx.setTaxPre(fpkjmx.getYHZCBS());
		// private String taxPreCon;// 享受优惠政策内容
		fpmx.setZeroTax(fpkjmx.getLSLBS());
		fpmx.setCropGoodsNo(fpkjmx.getZXBM());
		// private String taxDeduction;// 扣除额，该字段可为空

		return fpmx;
	}

	/**
	 * 获取发票开具请求内部报文
	 * 
	 * @return
	 */
	private FpkjReq getFpkjReq() {
		String content = iface.getData().getContent();
		content = Base64Helper.decode(content);
		XStream xs = new XStream(new DomDriver());
		xs.autodetectAnnotations(true);
		xs.alias("REQUEST_FPKJ", FpkjReq.class);
		xs.aliasAttribute("cls", "class");

		FpkjReq fpkjReq = (FpkjReq) xs.fromXML(content);

		return fpkjReq;
	}

}
