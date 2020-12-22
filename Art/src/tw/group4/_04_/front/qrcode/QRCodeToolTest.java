package tw.group4._04_.front.qrcode;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.zxing.EncodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.WriterException;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import tw.group4._04_.front.qrcode.QRCodeTool;
import tw.group4._04_.front.shopcart.model.Shoppingcart;



@Service
public class QRCodeToolTest {
	
	@Autowired
	ServletContext ctx;
	public void QRCode(Shoppingcart shoppingcart) throws WriterException, IOException, NotFoundException {
		// 二維碼字串
				String qrCodeData = 
						"節目名稱："+shoppingcart.getTITLE()+"電子票券\n\r"
						+ "票種："+shoppingcart.getTICKETCATEGORY()+"\n\r"
						+ "數量："+shoppingcart.getTICKET_NUM()+"\n\r"
						+ "座位編號："+shoppingcart.getSeatstring();
		// 二維碼名稱
//				String filePath = "/images/04/QRcodeOutput/"+shoppingcart.getORDERID()+".png";
//				String filePath = "C:\\iii\\HibernateWorkspace\\Art-AOP\\QRcodeOutput\\"+shoppingcart.getORDERID()+".png";
				String filePath = ctx.getRealPath("/WEB-INF/pages/images/04/QRcodeOutput/"+shoppingcart.getORDERID()+".png");
		// 字元編碼
				String charset = "UTF-8"; // "ISO-8859-1"
				Map hintMap = new HashMap();
				hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
				QRCodeTool.createQRCode(qrCodeData, filePath, charset, hintMap, 200, 200);
				
			}
	public static void main(String[] args) throws WriterException, IOException, NotFoundException {
// 二維碼字串		
		String qrCodeData = "測試";
// 二維碼名稱
		String filePath = "WebContent\\WEB-INF\\pages\\images\\04\\QRcodeOutput/1122.png";
// 字元編碼
		String charset = "UTF-8";  //"ISO-8859-1"
		Map hintMap = new HashMap();
		hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
		QRCodeTool.createQRCode(qrCodeData, filePath, charset, hintMap, 200, 200);
		System.out.println("二維碼影象建立成功!");

		System.out.println("讀取二維碼資料: " + QRCodeTool.readQRCode(filePath, charset, hintMap));
	}

}
