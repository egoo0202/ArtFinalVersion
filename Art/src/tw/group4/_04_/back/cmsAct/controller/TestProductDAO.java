package tw.group4._04_.back.cmsAct.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import tw.group4._04_.back.cmsAct.model.ShowBean;
import tw.group4._04_.back.cmsAct.model.ShowBeanService;

@Controller
public class TestProductDAO {


		@Autowired
		private ShowBean showBean;
		
		@Autowired
		private ShowBeanService showBeanService;
		
		@RequestMapping(path = "/Category3.ctrl", method = RequestMethod.GET)
		public String processCategorySearch2(int category, String p, Model model) {
		int pageNo=1;
//		String category =5;

		List<Map> list = new ArrayList<Map>();

		List<ShowBean> showList = showBeanService.selectAll3(pageNo,category);

		for (ShowBean showBean : showList) {
//			String categoryString = Integer.toString(showBean.getACT_CATEGORY());

			int noint = showBean.getACT_NO();
			String titleString = showBean.getACT_TITLE();
			String siteString = showBean.getACT_LOCATION_NAME();

//			if (category.equals(categoryString)) {

				Map map = new HashMap();
				map.put("no", noint);
				map.put("title", titleString);
				map.put("site", siteString);
				// 存入map集合中
				System.out.println(map);
				list.add(map);// 將map集合放入list集合
//					System.out.println("放入集合");

//			}
		}
		return p;
		}
}
