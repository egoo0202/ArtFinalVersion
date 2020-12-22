package tw.group4._03_.cms.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import tw.group4._03_.cms.shop.model.CreativeShopService;
import tw.group4.util.Hibernate;

@Controller
public class DeleteShop {

	@Autowired
	public CreativeShopService css;

	@Hibernate
	@RequestMapping(path = "/03/cms/shop/deleteShop.ctrl", method = RequestMethod.POST)
	public String deleteShop(@RequestParam(name = "shopId") String shopId, Model m) {

		try {
			int id = Integer.parseInt(shopId);
			css.delete(id);

			String acShopsDeleteMsg = "商店資料刪除成功";
			m.addAttribute("acShopsDeleteMsg", acShopsDeleteMsg);

		} catch (Exception e) {
			e.printStackTrace();
			String acShopsDeleteMsg = "商店資料刪除失敗";
			m.addAttribute("acShopsDeleteMsg", acShopsDeleteMsg); // 回傳錯誤訊息
		}
		return "03/cms_shop/delete_return";
	}

//	@RequestMapping(path = "/03/cms/shop/deleteShopByShopId.ctrl", method = RequestMethod.POST)
//	public String deleteShopByShopId(@RequestParam(name = "shopId") String shopId, Model m) {
//
//		try {
//			int id = Integer.parseInt(shopId);
//
//			List<CreativeShopBean> shopsList = css.selectByShopId(id);
//
//			if (shopsList.size() != 0) {
//				m.addAttribute("acShopsList", shopsList);
//			} else {
//				String acShopsSerachMsg = "查無此商店資料，請重新查詢";
//				m.addAttribute("acShopsSerachMsg", acShopsSerachMsg); // 回傳錯誤訊息
//			}
//
//		} catch (Exception e) {
//			e.printStackTrace();
//
//			String acShopsSerachMsg = "商店資料搜尋出錯，請重新查詢";
//			m.addAttribute("acShopsSerachMsg", acShopsSerachMsg); // 回傳錯誤訊息
//		}
//		return "03/cms_shop/delete_confirm";
//	}
//
//	@RequestMapping(path = "/03/cms/shop/deleteShopByShopName.ctrl", method = RequestMethod.POST)
//	private String deleteShopByShopName(@RequestParam(name = "shopName") String shopName, Model m) {
//
//		try {
//			List<CreativeShopBean> shopsList = css.selectByShopName(shopName);
//
//			if (shopsList.size() != 0) {
//				m.addAttribute("acShopsList", shopsList);
//			} else {
//				String acShopsSerachMsg = "查無此商店資料，請重新查詢";
//				m.addAttribute("acShopsSerachMsg", acShopsSerachMsg); // 回傳錯誤訊息
//			}
//
//		} catch (Exception e) {
//			e.printStackTrace();
//			String acShopsSerachMsg = "商店資料搜尋出錯，請重新查詢";
//			m.addAttribute("acShopsSerachMsg", acShopsSerachMsg); // 回傳錯誤訊息
//		}
//		return "03/cms_shop/delete_confirm";
//	}

}
