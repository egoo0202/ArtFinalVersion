package tw.group4._03_.cms.reservation.model;

import java.util.Random;
import java.util.UUID;

import ecpay.payment.integration.AllInOne;
import ecpay.payment.integration.domain.AioCheckOutALL;
import ecpay.payment.integration.domain.InvoiceObj;

public class GreenPayDAO {
	
	public String greenPayPage(String date, String price, String paymentInfo) {
		
		AllInOne aio = new AllInOne("");
		
		AioCheckOutALL obj = new AioCheckOutALL();
		InvoiceObj invoiceObj = new InvoiceObj();
		UUID uid = UUID.randomUUID();
		obj.setMerchantTradeNo(uid.toString().replaceAll("-", "").substring(0,20));
//		obj.setMerchantTradeNo("testCompany0004");
		obj.setMerchantTradeDate(date);
		obj.setTotalAmount(price);
		obj.setTradeDesc("得藝食堂訂位付款測試");
		obj.setItemName(paymentInfo); //要列舉出所有商品名稱與價錢，需使用 # 字號分隔每項商品，目前懶惰還沒使用
		obj.setReturnURL("http://211.23.128.214:5000"); //設定付款成功之參數要在這邊新增接收參數之外網
		obj.setClientBackURL("http://localhost:8080/Art/03/front/reservation/myReservation.ctrl");//
		obj.setNeedExtraPaidInfo("N");
		invoiceObj.setRelateNumber(radomshopname()); //商店名稱設定欄位，改為隨機
//		invoiceObj.setRelateNumber(uid.toString().replaceAll("-", "").substring(0, 20)); //商店名稱設定欄位，太常用同一個名稱會壞掉
		invoiceObj.setCustomerID("112233");
		invoiceObj.setCarruerType("1");
		invoiceObj.setTaxType("1");
		invoiceObj.setCarruerNum("");
		invoiceObj.setDonation("0");
		invoiceObj.setLoveCode("X112233");
		invoiceObj.setPrint("0");
		invoiceObj.setCustomerName("Louie");
		invoiceObj.setCustomerAddr("桃園市中壢區中央大學");
		invoiceObj.setCustomerPhone("0956266757");
		invoiceObj.setDelayDay("1");
		invoiceObj.setInvType("07");
		invoiceObj.setInvoiceItemName("測試");
		invoiceObj.setInvoiceItemCount("1");
		invoiceObj.setInvoiceItemWord("組");
		invoiceObj.setInvoiceItemPrice("2000");
		invoiceObj.setInvoiceItemTaxType("1");
		
		String form = aio.aioCheckOut(obj, invoiceObj);
		
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
