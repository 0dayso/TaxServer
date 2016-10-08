package com.aisinogz.biz;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.aisinogz.request.Fpmx;
import com.aisinogz.request.InvoiceRequest;
import com.aisinogz.response.InvoiceResponse;
import com.aisinogz.response.Response;
import com.aisinogz.util.Base64Helper;
import com.aisinogz.util.FreeMarkerHelper;

public class InvoiceBiz extends CardBizAbstract {
	private static final Logger LOGGER = Logger.getLogger(InvoiceBiz.class);
	private InvoiceRequest invoiceRequest;
	private String checkEWM;

	public void setCheckEWM(String checkEWM) {
		this.checkEWM = checkEWM;
	}

	public void setInvoiceRequest(InvoiceRequest invoiceRequest) {
		this.invoiceRequest = invoiceRequest;
	}

	@Override
	protected Response process() throws Exception {
		LOGGER.info("0".equals(checkEWM) ? "开具发票" : "校验发票");
		setField("CheckEWM", checkEWM);// 置为1 用于发票校验，0为开票
		// 初始化开票
		call("InvInfoInit");
		// 添加发票头信息
		setInvoiceTitle();
		// 添加商品明细之前，需要把之前的商品明细给清空掉
		call("ClearInvList");
		call("InvListInit");
		// 添加发票明细信息
		setInvoiveDetial();
		// 开票
		call("Invoice");

		InvoiceResponse invoiceResponse = new InvoiceResponse();
		invoiceResponse.setRetCode(getField("RetCode"));
		invoiceResponse.setRetMsg(getField("RetMsg"));
		invoiceResponse.setInfoAmount(getField("InfoAmount"));
		invoiceResponse.setInfoTaxAmount(getField("InfoTaxAmount"));
		invoiceResponse.setInfoDate(getField("InfoDate"));
		invoiceResponse.setInfoMonth(getField("InfoMonth"));
		invoiceResponse.setInfoTypeCode(getField("InfoTypeCode"));
		invoiceResponse.setInfoNumber(getField("InfoNumber"));
		invoiceResponse.setGoodsListFlag(getField("GoodsListFlag"));
		invoiceResponse.setInvStock(getField("InvStock"));
		invoiceResponse.setTaxClock(getField("TaxClock"));
		invoiceResponse.setIsInvEmpty(getField("IsInvEmpty"));
		invoiceResponse.setCancelFlag(getField("CancelFlag"));
		invoiceResponse.setInfo(getField("Info"));

		LOGGER.info(invoiceResponse.getRetMsg());
		return invoiceResponse;
	}

	/**
	 * 设置发票头信息
	 */
	private void setInvoiceTitle() {

		setField("InfoKind", invoiceRequest.getInfoKind());
		setField("SellerAddress", invoiceRequest.getSellerAddress());
		setField("InfoClientName", invoiceRequest.getInfoClientName());
		setField("InfoClientTaxCode", invoiceRequest.getInfoClientTaxCode());
		setField("InfoClientBankAccount", invoiceRequest.getInfoClientBankAccount());
		setField("InfoClientAddressPhone", invoiceRequest.getInfoClientAddressPhone());
		setField("InfoSellerBankAccount", invoiceRequest.getInfoSellerBankAccount());
		setField("InfoSellerAddressPhone", invoiceRequest.getInfoSellerAddressPhone());
		setField("InfoTaxRate", invoiceRequest.getInfoTaxRate());
		setField("InfoNotes", invoiceRequest.getInfoNotes());
		setField("InfoInvoicer", invoiceRequest.getInfoInvoicer());
		setField("InfoChecker", invoiceRequest.getInfoChecker());
		setField("InfoCashier", invoiceRequest.getInfoCashier());
		setField("InfoListName", invoiceRequest.getInfoListName());
		setField("InfoBillNumber", invoiceRequest.getInfoBillNumber());

	}

	/**
	 * 设置发票明细
	 */
	private void setInvoiveDetial() {
		List<Fpmx> listFpmx = invoiceRequest.getListFpmx();
		String batchUploadRet;
		if (listFpmx != null && listFpmx.size() > 0) {
			for (Fpmx fpmx : listFpmx) {
				setField("ListGoodsName", fpmx.getListGoodsName());
				setField("ListTaxItem", fpmx.getListTaxItem());
				setField("ListStandard", fpmx.getListStandard());
				setField("ListUnit", fpmx.getListUnit());
				setField("ListNumber", fpmx.getListNumber());
				setField("ListPrice", fpmx.getListPrice());
				setField("ListAmount", fpmx.getListAmount());
				setField("ListPriceKind", fpmx.getListPriceKind());
				setField("ListTaxAmount", fpmx.getListTaxAmount());

				// 每行都要设置发票信息
				batchUploadRet=batchUpload(getBatchUploadXml(fpmx));
				LOGGER.info(batchUploadRet);
				// 添加商品明细行
				call("AddInvList");
			}
		}
	}

	private String getBatchUploadXml(Fpmx fpmx) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("GoodsNoVer", fpmx.getGoodsNoVer());
		model.put("GoodsTaxNo", fpmx.getGoodsTaxNo());
		model.put("TaxPre", fpmx.getTaxPre());
		model.put("TaxPreCon", fpmx.getTaxPreCon());
		model.put("ZeroTax", fpmx.getZeroTax());
		model.put("CropGoodsNo", fpmx.getCropGoodsNo());
		model.put("TaxDeduction", fpmx.getTaxDeduction());
		String data = FreeMarkerHelper.generate(model, "RequesInvoice.xml");
		data = Base64Helper.encode(data);

		model.clear();
		model.put("ID", "1100");
		model.put("DATA", data);
		String batchUploadXml = FreeMarkerHelper.generate(model, "Request_Common.xml");

		return batchUploadXml;
	}
}
