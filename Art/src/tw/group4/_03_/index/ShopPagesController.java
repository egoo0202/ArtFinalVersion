package tw.group4._03_.index;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import tw.group4._03_.cms.shop.model.CreativeShopBean;
import tw.group4._03_.cms.shop.model.CreativeShopService;
import tw.group4.util.Hibernate;

@Controller
public class ShopPagesController {

	@Autowired
	public CreativeShopService css;

	@Hibernate
	@RequestMapping(path = "/03/index/shop/index.ctrl", method = RequestMethod.GET)
	public String redirectToShopIndex(HttpSession session, Model m) {

		try {
			List<CreativeShopBean> shopListbyId = css.select16OrderByShopId();

			// 處理圖片顯示 Id
			// 將圖片存入 base64Image
			for (int i = 0; i < shopListbyId.size(); i++) {

				CreativeShopBean shop = shopListbyId.get(i);

				// 處理圖片資料的型態資料轉換
				// byte[]透過Base64轉換成String，這樣才能在jsp正常顯示

				byte[] image = shop.getReservation();
				String shopImage = Base64.encodeBase64String(image);

				shop.setBase64Image(shopImage);

			}

			m.addAttribute("shopListbyId", shopListbyId);

			// =======================

			List<CreativeShopBean> shopListbyPopularity = css.select16OrderByPopularity();

			// 處理圖片顯示 Popularity
			// 將圖片存入 base64Image
			for (int i = 0; i < shopListbyPopularity.size(); i++) {

				CreativeShopBean shop = shopListbyPopularity.get(i);

				// 處理圖片資料的型態資料轉換
				// byte[]透過Base64轉換成String，這樣才能在jsp正常顯示

				byte[] image = shop.getReservation();
				String shopImage = Base64.encodeBase64String(image);

				shop.setBase64Image(shopImage);
			}

			m.addAttribute("shopListbyPopularity", shopListbyPopularity);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "03/index_shop/index";
	}

	@Hibernate
	@RequestMapping(path = "/03/index/shop/searchShopByName.ctrl", method = RequestMethod.POST)
	public String searchShopByShopName(@RequestParam(name = "shopName") String shopName, Model m) {

		try {
			List<CreativeShopBean> shopsList = css.selectByShopName(shopName);

			if (shopsList.size() != 0) {

				// 處理圖片顯示 Popularity
				// 將圖片存入 base64Image
				for (int i = 0; i < shopsList.size(); i++) {

					CreativeShopBean shop = shopsList.get(i);

					// 處理圖片資料的型態資料轉換
					// byte[]透過Base64轉換成String，這樣才能在jsp正常顯示
					byte[] image = shop.getReservation();
					String shopImage = Base64.encodeBase64String(image);

					shop.setBase64Image(shopImage);
				}

				m.addAttribute("shopsList", shopsList);

			} else {
				String acShopsSerachMsg = "很抱歉，查無商店資料，請嘗試使用其他名稱搜尋";
				m.addAttribute("acShopsSerachMsg", acShopsSerachMsg);
			}
			
		} catch (Exception e) {
			e.printStackTrace();

			String acShopsSerachMsg = "商店資料搜尋失敗";
			System.out.println(acShopsSerachMsg);
		}
		return "03/index_shop/search_shop";
	}

	@Hibernate
	@RequestMapping(path = "/03/index/shop/shopDetails.ctrl", method = RequestMethod.GET)
	public String redirectToShopDetails(@RequestParam(name = "shopId") String shopId, Model m) {

		try {
			int id = Integer.parseInt(shopId);
			CreativeShopBean shop = css.select(id);

			// 處理圖片顯示
			byte[] image = shop.getReservation();
			String shopImage = Base64.encodeBase64String(image);

			shop.setBase64Image(shopImage);
			
			m.addAttribute("shop", shop);
		} catch (Exception e) {
			e.printStackTrace();

			String acShopsSerachMsg = "搜尋出錯，請嘗試重新載入";
			m.addAttribute("acShopsSerachMsg", acShopsSerachMsg); // 回傳錯誤訊息
		}
		return "03/index_shop/shop_details";
	}

//	@Hibernate
//	@RequestMapping(path = "/03/index/shop/searchShopByName.ctrl", method = RequestMethod.POST)
//	public String searchShopByShopName(@RequestParam(name = "shopName") String shopName, Model m) {
//
//		try {
//
//			List<CreativeShopBean> shopsList = css.selectByShopName(shopName);
//
//			if (shopsList.size() != 0) {
//				m.addAttribute("shopsList", shopsList);
//
//				List<String> shopImageList = new ArrayList<String>();
//
//				for (int i = 0; i < shopsList.size(); i++) {
//
//					CreativeShopBean shop = shopsList.get(i);
//
//					// 處理圖片資料的型態資料轉換
//					// byte[]透過Base64轉換成String，這樣才能在jsp正常顯示
//					byte[] image = shop.getReservation();
//					String shopImage = Base64.encodeBase64String(image);
//
//					shopImageList.add(shopImage);
//				}
//
//				m.addAttribute("shopImageList", shopImageList);
//
//			} else {
//				String acShopsSerachMsg = "很抱歉，查無商店資料，請嘗試使用其他名稱搜尋";
//				m.addAttribute("acShopsSerachMsg", acShopsSerachMsg);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//
//			String acShopsSerachMsg = "商店資料搜尋失敗";
//			System.out.println(acShopsSerachMsg);
//		}
//		return "03/index_shop/search_shop";
//	}

}
