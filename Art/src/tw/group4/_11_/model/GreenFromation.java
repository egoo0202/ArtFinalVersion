package tw.group4._11_.model;

import java.util.Random;
import java.util.UUID;

import ecpay.payment.integration.AllInOne;
import ecpay.payment.integration.domain.AioCheckOutALL;
import ecpay.payment.integration.domain.InvoiceObj;

public class GreenFromation {
	
	public String greenCheck(String date , int donate) {
		AllInOne aaa = new AllInOne("");
		
		AioCheckOutALL obj = new AioCheckOutALL();
		InvoiceObj invoiceObj = new InvoiceObj();
		UUID uid = UUID.randomUUID();
		
		obj.setMerchantTradeNo(uid.toString().replaceAll("-", "").substring(0,20));
//		obj.setMerchantTradeNo("testCompany0004");
		obj.setMerchantTradeDate(date);
		obj.setTotalAmount(Integer.toString(donate));
		obj.setTradeDesc("test Donation");
		obj.setItemName("捐款"); //要列舉出所有商品名稱與價錢，需使用 # 字號分隔每項商品，目前懶惰還沒使用
		obj.setReturnURL("http://211.23.128.214:5000"); //設定付款成功之參數要在這邊新增接收參數之外網
		obj.setClientBackURL("http://localhost:8080/Art/userStreetArtistPage.ctrl");//
		obj.setNeedExtraPaidInfo("N");
		invoiceObj.setRelateNumber(radomshopname()); //商店名稱設定欄位，改為隨機
//		invoiceObj.setRelateNumber(uid.toString().replaceAll("-", "").substring(0, 20)); //商店名稱設定欄位，太常用同一個名稱會壞掉
		invoiceObj.setCustomerID("878787");
		invoiceObj.setCarruerType("1");
		invoiceObj.setTaxType("1");
		invoiceObj.setCarruerNum("");
		invoiceObj.setDonation("0");
		invoiceObj.setLoveCode("X802541");
		invoiceObj.setPrint("0");
		invoiceObj.setCustomerName("Jack");
		invoiceObj.setCustomerAddr("桃園市中壢區中央大學宵夜街");
		invoiceObj.setCustomerPhone("0985632194");
		invoiceObj.setDelayDay("1");
		invoiceObj.setInvType("07");
		invoiceObj.setInvoiceItemName("測試");
		invoiceObj.setInvoiceItemCount("1");
		invoiceObj.setInvoiceItemWord("次");
		invoiceObj.setInvoiceItemPrice("50");
		invoiceObj.setInvoiceItemTaxType("1");
		
		String form = aaa.aioCheckOut(obj, invoiceObj);
		
		return form;
	}
	
	public String radomshopname() {

		String result = "";
		Random random = new Random();
		for (int i = 0; i < 5; i++) {
			result += random.nextInt(10);
		}
		return  "test"+result;
	}
}
