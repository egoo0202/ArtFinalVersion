package tw.group4._14_.index.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;

import oracle.net.aso.m;
import oracle.security.o3logon.a;
import tw.group4._14_.back.ARTProduct;
import tw.group4._14_.back.dao.AlertsService;
import tw.group4._14_.back.dao.ProductBeanDAOService;
import tw.group4._14_.dashboard.dao.DashboardService;
import tw.group4._14_.dashboard.model.EntryClickRate;
import tw.group4._14_.front.model.dao.MBRecordDAOService;
import tw.group4._14_.index.dao.IndexDaoService;
import tw.group4.util.Hibernate;

@Controller
public class IndexController {

	@Autowired
	private IndexDaoService iService;

	@Autowired
	public AlertsService altService;

	@Autowired
	private ProductBeanDAOService pDaoservice;
	
	@Autowired
	private MBRecordDAOService mService;
	
	@Autowired
	private DashboardService dbService;

	@RequestMapping("/14/gototrytrysee")
	public String gototrytrysee(HttpServletRequest request, HttpServletResponse response, Model model) {

		return "14/draft/trytrysee";
	}

	@Hibernate
	@RequestMapping("/14/scroller")
	public String gotoscroller(HttpServletRequest request, HttpServletResponse response, Model m, @RequestParam(name = "pageNo", required = false) Integer pageNo,
			@RequestParam(name = "query", required = false) String query) {
		
		EntryClickRate ecr = new EntryClickRate();
		ecr.setShop(1);
		dbService.insert(ecr);
		
		
		if (query != "" && query != null) {

			// 有參數起始
			if (pageNo == null || pageNo == 0) {
				pageNo = 1;
			}

			List<ARTProduct> queryList = pDaoservice.selectQueryAll(pageNo, query);

			int totalPage = pDaoservice.getQueryPages(query);

			List<Integer> totalPages = new ArrayList<Integer>();
			for (int i = 1; i <= totalPage; i++) {
				totalPages.add(i);
			}

//			m.addAttribute("queryList", queryList);
//			m.addAttribute("query", query);
//			m.addAttribute("totalPages", totalPage);
//			m.addAttribute("pages", totalPages);
//			m.addAttribute("pageNo", pageNo);
			
			m.addAttribute("pList", queryList);
			m.addAttribute("pageNo", pageNo);
			m.addAttribute("totalPages", totalPage);
			m.addAttribute("pages", totalPages);
			m.addAttribute("query", query);

			// 有參數終了
		} else {

			// 無參數起始點
			if (pageNo == null || pageNo == 0) {
				pageNo = 1;
			}

			List<ARTProduct> pList = pDaoservice.selectAll(pageNo);
			int totalPage = pDaoservice.getTotalPages();

			List<Integer> totalPages = new ArrayList<Integer>();
			for (int i = 1; i <= totalPage; i++) {
				totalPages.add(i);
			}

			m.addAttribute("pList", pList);
			m.addAttribute("pageNo", pageNo);
			m.addAttribute("totalPages", totalPage);
			m.addAttribute("pages", totalPages);

		}

		
	

	return"14/draft/ElementScroller";

}

	// 實驗 AJAX 商品頁面
	@Hibernate
	@RequestMapping("/14/getSubView")
	@ResponseBody
	public ModelAndView trytrysee(HttpServletRequest request, HttpServletResponse response, Model m, @RequestParam(name = "pageNo", required = false) Integer pageNo,
			@RequestParam(name = "query", required = false) String query) {

		
		
		if (query != "" && query != null) {

			// 有參數起始
			if (pageNo == null || pageNo == 0) {
				pageNo = 1;
			}

			List<ARTProduct> queryList = pDaoservice.selectQueryAll(pageNo, query);

			int totalPage = pDaoservice.getQueryPages(query);

			List<Integer> totalPages = new ArrayList<Integer>();
			for (int i = 1; i <= totalPage; i++) {
				totalPages.add(i);
			}

//			m.addAttribute("queryList", queryList);
//			m.addAttribute("query", query);
//			m.addAttribute("totalPages", totalPage);
//			m.addAttribute("pages", totalPages);
//			m.addAttribute("pageNo", pageNo);
			
			m.addAttribute("pList", queryList);
			m.addAttribute("pageNo", pageNo);
			m.addAttribute("totalPages", totalPage);
			m.addAttribute("pages", totalPages);

			// 有參數終了
		} else {

			// 無參數起始點
			if (pageNo == null || pageNo == 0) {
				pageNo = 1;
			}

			List<ARTProduct> pList = pDaoservice.selectAll(pageNo);
			int totalPage = pDaoservice.getTotalPages();

			List<Integer> totalPages = new ArrayList<Integer>();
			for (int i = 1; i <= totalPage; i++) {
				totalPages.add(i);
			}

			m.addAttribute("pList", pList);
			m.addAttribute("pageNo", pageNo);
			m.addAttribute("totalPages", totalPage);
			m.addAttribute("pages", totalPages);

		}

	return new ModelAndView("14/subView") ;
	}

	// 傳給首頁熱門的前 9 筆商城商品
	@Hibernate
	@RequestMapping(path = "/14/indexShopHot", produces = "application/text; charset=utf-8")
	@ResponseBody
	public String indexShopHot() {

		List<ARTProduct> list = iService.selectShopHot();
		Gson gson = new Gson();

		String json = gson.toJson(list);

		return json;
	}

}
