package tw.group4._03_.cms.shop.controller;

import java.util.ArrayList;
import java.util.List;

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
public class SearchShop {

	@Autowired
	public CreativeShopService css;

	@Hibernate
	@RequestMapping(path = "/03/cms/shop/searchShopByShopName.ctrl", method = RequestMethod.POST)
	public String searchShopByShopName(@RequestParam(name = "shopName") String shopName, Model m) {

		try {
			List<CreativeShopBean> shopsList = css.selectByShopName(shopName);

			if (shopsList.size() != 0) {
				m.addAttribute("acShopsList", shopsList);

				// 處理圖片資料顯示
				List<String> shopImageList = new ArrayList<String>();

				for (int i = 0; i < shopsList.size(); i++) {

					CreativeShopBean shop = shopsList.get(i);

					// 處理圖片資料的型態資料轉換
					// byte[]透過Base64轉換成String，這樣才能在jsp正常顯示

					byte[] image = shop.getReservation();
					String shopImage = Base64.encodeBase64String(image);

					shopImageList.add(shopImage);
				}

				m.addAttribute("shopImageList", shopImageList);

			} else {
				String acShopsSerachMsg = "查無此商店資料，請重新查詢";
				m.addAttribute("acShopsSerachMsg", acShopsSerachMsg);
			}

		} catch (Exception e) {
			e.printStackTrace();

			String acShopsSerachMsg = "商店資料搜尋失敗";
			m.addAttribute("acShopsSerachMsg", acShopsSerachMsg); // 回傳錯誤訊息
		}
		return "03/cms_shop/search_return";
	}


}
