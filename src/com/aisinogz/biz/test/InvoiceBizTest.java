package com.aisinogz.biz.test;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import com.aisinogz.biz.InvoiceBiz;
import com.aisinogz.request.Fpmx;
import com.aisinogz.request.InvoiceRequest;

public class InvoiceBizTest extends TestCase {

	public InvoiceRequest getInvoiceRequest() {
		InvoiceRequest req = new InvoiceRequest();
		req.setInfoKind("0");
		req.setSellerAddress("");
		req.setInfoClientName("陈捷");
		req.setInfoClientTaxCode("350000000000000000");
		req.setInfoClientBankAccount("6212262000000000000");
		req.setInfoClientAddressPhone("花果园W区0851-86816661");
		req.setInfoSellerBankAccount("6222022400000000000");
		req.setInfoSellerAddressPhone("博泰华庭0851-86888888");
		req.setInfoTaxRate("17");
		req.setInfoNotes("这个是备注信息");
		req.setInfoInvoicer("航信");
		req.setInfoChecker("陈捷");
		req.setInfoCashier("阿捷");
		req.setInfoListName("");
		req.setInfoBillNumber("XSD201610022201");

		return req;
	}

	public List<Fpmx> getListFpmx() {
		List<Fpmx> listFpmx = new ArrayList<Fpmx>();
		Fpmx fpmx = new Fpmx();
		fpmx.setListGoodsName("软件测试");
		fpmx.setListTaxItem("0101");
		fpmx.setListStandard("1*1");
		fpmx.setListUnit("次");
		fpmx.setListNumber("1");
		fpmx.setListPrice("1");
		fpmx.setListAmount("1");
		fpmx.setListPriceKind("1");
		fpmx.setListTaxAmount("0.17");

		// 额外添加的batchuploadxml的属性
		fpmx.setGoodsNoVer("");
		fpmx.setGoodsTaxNo("");
		fpmx.setTaxPre("");
		fpmx.setTaxPreCon("");
		fpmx.setZeroTax("");
		fpmx.setCropGoodsNo("");
		fpmx.setTaxDeduction("");

		listFpmx.add(fpmx);
		return listFpmx;
	}

	public void test1() throws Exception {
		InvoiceRequest req = getInvoiceRequest();
		List<Fpmx> listFpmx = getListFpmx();
		req.setListFpmx(listFpmx);

		InvoiceBiz invoiceBiz = new InvoiceBiz();
		invoiceBiz.setInvoiceRequest(req);
		invoiceBiz.setCheckEWM("1");
		invoiceBiz.handler();
	}
}
