package tw.group4._03_.cms.shop.controller;

import java.util.List;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import tw.group4._03_.cms.shop.model.CreativeShopBean;
import tw.group4._03_.cms.shop.model.CreativeShopService;
import tw.group4._03_.cms.util.CustomizedTypeConversion;
import tw.group4._04_.back.cmsAct.model.ShowBean;
import tw.group4.util.Hibernate;

@Controller
public class UpdateShop {

	@Autowired
	public CreativeShopService css;

	@Hibernate
	@RequestMapping(path = "/03/cms/shop/updateShopByShopId.ctrl", method = RequestMethod.POST)
	public String updateShopByShopId(@RequestParam(name = "shopId") String shopId, Model m) {

		try {
			int id = Integer.parseInt(shopId);
			List<CreativeShopBean> shopsList = css.selectByShopId(id);

//			CreativeShopBean a = shopsList.get(0);
//			System.out.println(a);

			if (shopsList.size() != 0) {

				CreativeShopBean shop = shopsList.get(0);

//				處理圖片資料的型態資料轉換
				// byte[]透過Base64轉換成String，這樣才能在jsp正常顯示
				byte[] oldImage = shop.getReservation();
				String shopImage = Base64.encodeBase64String(oldImage);

				m.addAttribute("shopImage", shopImage);
				m.addAttribute("acShopsList", shopsList);
				
			} else {
				String acShopsSerachMsg = "查無此商店資料，請重新查詢";
				m.addAttribute("acShopsSerachMsg", acShopsSerachMsg);
			}
			
		} catch (Exception e) {
			e.printStackTrace();

			String acShopsSerachMsg = "查無此商店編號";
			m.addAttribute("acShopsSerachMsg", acShopsSerachMsg); // 回傳錯誤訊息
		}
		return "03/cms_shop/update_confirm";

	}

	@Hibernate
	@RequestMapping(path = "/03/cms/shop/updateShop.ctrl", method = RequestMethod.POST)
	public String updateShop(@RequestParam(name = "shopId") String shopId,
			@RequestParam(name = "shopName") String shopName, @RequestParam(name = "memberId") String memberId,
			@RequestParam(name = "image") String image, @RequestParam(name = "intro") String intro,

			@RequestParam(name = "cityName") String cityName, @RequestParam(name = "address") String address,
			@RequestParam(name = "openTime") String openTime, @RequestParam(name = "phone") String phone,
			@RequestParam(name = "fax") String fax,

			@RequestParam(name = "email") String email, @RequestParam(name = "facebook") String facebook,
			@RequestParam(name = "website") String website, @RequestParam(name = "clicks") String clicks,
			@RequestParam(name = "imageFile") MultipartFile imageFile,

			Model m) {
		try {

			int intShopId = Integer.parseInt(shopId);
			int intMemberId = 1;
			int intClicks = CustomizedTypeConversion.customizedParseInt(clicks);

			CreativeShopBean shop = css.select(intShopId);

			// 判斷是否有新圖片檔
			byte[] newImage = imageFile.getBytes();

			if (newImage.length == 0) {
				// 執行更新
				css.update(intShopId, shopName, intMemberId, image, intro, cityName, address, openTime, phone, fax,
						email, facebook, website, intClicks, shop.getReservation());

			} else {
				// 有新圖片執行更新
				// 執行更新
				css.update(intShopId, shopName, intMemberId, image, intro, cityName, address, openTime, phone, fax,
						email, facebook, website, intClicks, newImage);
			}
			
			String acShopsUpdateMsg = "商店資料更新成功";
			m.addAttribute("acShopsUpdateMsg", acShopsUpdateMsg);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "03/cms_shop/update_return";
	}

}
