package tw.group4._14_.front.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;

import tw.group4._14_.back.ARTProduct;
import tw.group4._14_.back.dao.ProductBeanDAOService;
import tw.group4._14_.dashboard.dao.DashboardService;
import tw.group4._14_.dashboard.model.EntryClickRate;
import tw.group4._14_.front.model.MessageBoardAP;
import tw.group4._14_.front.model.ShoppingCartAP;
import tw.group4._14_.front.model.dao.MBRecordDAOService;
import tw.group4._14_.front.model.dao.MessageBoardAPService;
import tw.group4._14_.index.dao.IndexDaoService;
import tw.group4._35_.login.model.WebsiteMember;
import tw.group4.util.Hibernate;

@Controller
public class ControllerAPShop {

	@Autowired
	private ProductBeanDAOService pDaoservice;

	@Autowired
	ServletContext ctx;

	@Autowired
	private MessageBoardAPService pMBDao;

	@Autowired
	private MBRecordDAOService mbrService;
	
	@Autowired
	private DashboardService dbService;
	
	@Autowired
	private IndexDaoService iService;
	
	//開啟 AJAX 測試的大門 => 先不要 //TODO: Pagination 未完成
	@RequestMapping(path = "/14/newProduct", method = RequestMethod.GET)
	public String newProduct(Model m, HttpSession session,
			@RequestParam(name = "pageNo", required = false) Integer pageNo) {
		
//		return "14/14_NewIndex";
		return "14/Index";
	}
	
	@RequestMapping(path = "/14/templateTest", method = RequestMethod.GET)
	public String templateTest(Model m, HttpSession session,
			@RequestParam(name = "pageNo", required = false) Integer pageNo) {
		
//		return "14/14_NewIndex";
		return "14/Table";
	}
	

	@Hibernate
	@RequestMapping(path = "/14/shopListController.ctrl", method = RequestMethod.GET)
	public String creatShopList(Model m, @RequestParam(name = "pageNo", required = false) Integer pageNo,
			@RequestParam(name = "query", required = false) String query, HttpSession session) {

		EntryClickRate ecr = new EntryClickRate();
		ecr.setShop(1);
		dbService.insert(ecr);
		
		ShoppingCartAP carList = (ShoppingCartAP) session.getAttribute("carList");

		// 判斷購物車不存在時的導向
		if (carList == null) {
			carList = new ShoppingCartAP();
			session.setAttribute("carList", carList);
		}

		// 有無參數判斷
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

			m.addAttribute("queryList", queryList);
			m.addAttribute("query", query);
			m.addAttribute("totalPages", totalPage);
			m.addAttribute("pages", totalPages);
			m.addAttribute("pageNo", pageNo);

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

		Map<String, ARTProduct> cartAP = carList.getCartAP();
		int size = cartAP.size();
		session.setAttribute("carSize", size);
//		m.addAttribute("carSize", size);
//		return IdentityFilter.loginID+"14/14_index";
		return "14/14_NewIndex";
//		return new ModelAndView("14/14_NewIndex");
	}

	// 不用了
	@Hibernate
	@RequestMapping(path = "/14/showOneProduct.ctrl", method = RequestMethod.GET)
	public String showOneProduct(Model m, @RequestParam(name = "pageNo", required = false) Integer pageNo,
			@RequestParam(name = "query", required = false) String query,
			@RequestParam(name = "productID") String productID, @RequestParam(name = "orderPrice") String orderPrice,
			@RequestParam(name = "orderImg") String orderImg, @RequestParam(name = "orderNum") int orderNum,
			@RequestParam(name = "orderDes") String orderDes, @RequestParam(name = "orderTitle") String orderTitle) {

		ARTProduct product = new ARTProduct();

		product.setProductId(productID);
		product.setProductTitle(orderTitle);
		product.setProductNum(orderNum);
		product.setProductPrice(orderPrice);
		product.setProductDes(orderDes);
		product.setProductImg(orderImg);

		List<Integer> stockNum = new ArrayList<Integer>();
		for (int i = 1; i <= orderNum; i++) {
			stockNum.add(i);
		}

		m.addAttribute("stockNum", stockNum);
		m.addAttribute("oneProsuct", product);
		m.addAttribute("query", query);
		return "14/14_showOnePdF";

	}

	@Hibernate
	@RequestMapping(path = "/14/showOneProduct2.ctrl", method = RequestMethod.GET)
	public String showOneProduct2(Model m, @RequestParam(name = "pageNo", required = false) Integer pageNo,
			@RequestParam(name = "query", required = false) String query, HttpSession session,
			@RequestParam(name = "productID") String productID) {

		ARTProduct ap = pDaoservice.select(productID);

		Long count = pMBDao.countMessageNum(Integer.parseInt(productID));

		List<MessageBoardAP> list = pMBDao.selectPdBoardAPs(Integer.parseInt(productID));

//		WebsiteMember mb = (WebsiteMember) session.getAttribute("member");
//		if (mb == null) {
//			return "redirect:/35/loginEntry";
//
//		}
//		
//		Integer mid = mb.getId();
//		
//		
//		int result = mbrService.selectMessage(mid,Integer.parseInt(productID));

		m.addAttribute("oneProsuct", ap);
		m.addAttribute("query", query);
		m.addAttribute("mseeageList", list);
		m.addAttribute("mseeageCount", count);

		return "14/14_showOnePdF";
	}

	@Hibernate
	@RequestMapping(path = "/14/SubmitProcess.ctrl", method = RequestMethod.GET)
	public String SubmitProcess(Model m, HttpSession session, HttpServletRequest request,
			@RequestParam(name = "carSize", required = false) Integer carSize,
			@RequestParam(name = "query", required = false) String query,
			@RequestParam(name = "pageNo", required = false) Integer pageNo,
			@RequestParam(name = "productID") String productID, @RequestParam(name = "orderPrice") String orderPrice,
			@RequestParam(name = "orderImg", required = false) String orderImg, @RequestParam(name = "orderNum") int orderNum,
			@RequestParam(name = "orderTitle") String orderTitle) {

		ShoppingCartAP carList = (ShoppingCartAP) session.getAttribute("carList");

		if (carList == null) {
			carList = new ShoppingCartAP();
			session.setAttribute("carList", carList);
		}

		ARTProduct product = new ARTProduct();

		product.setProductId(productID);
		product.setProductTitle(orderTitle);
		product.setProductNum(orderNum);
		product.setProductPrice(orderPrice);
		product.setProductImg(orderImg);

		synchronized (this) {

			carList.addToCarAP(productID, product);

		}

		Map<String, ARTProduct> cartAP = carList.getCartAP();
		Set set = cartAP.keySet();
		for (Iterator iter = set.iterator(); iter.hasNext();) {
			String key = (String) iter.next();
			ARTProduct value = (ARTProduct) cartAP.get(key);
			System.out.println(key + "====" + value);
		}

		System.out.println("------cartAP.size()------" + cartAP.size());
//		session.setAttribute("carList", carList);

		return "redirect:/14/shopListController.ctrl";
	}

	@Hibernate
	@RequestMapping(path = "/14/gotoCart.ctrl")
	public String gotoCart(Model m,HttpSession session) {

		ShoppingCartAP carList = (ShoppingCartAP) session.getAttribute("carList");
		if (carList == null) {

//			return "redirect:/14/shopListController.ctrl";
			return "redirect:/14/shopListController.ctrl";
		} else {

			int sum = 0;
			Map<String, ARTProduct> cartAP = carList.getCartAP();
			
			Set<String> keySet = cartAP.keySet();
			
			
			for (String i : keySet) {
				ARTProduct pi = cartAP.get(i);
				sum += (pi.getProductNum()*Integer.parseInt(pi.getProductPrice()));
			}
			
			WebsiteMember mb = (WebsiteMember) session.getAttribute("member");
			
			
			if (mb.getHome() != 0) {
				
				List<ARTProduct> selectShopHomeHot = iService.selectShopHomeHot();
				m.addAttribute("query", selectShopHomeHot);
				
			}else {
				
				List<ARTProduct> selectShopHot = iService.selectShopHot();
				m.addAttribute("query", selectShopHot);
			}
			
			m.addAttribute("sum", sum);

			
			return "14/14_OrderConfirm1";

		}

	}

	@Hibernate
	@RequestMapping(path = "/14/getBlobImage/{pdid}.ctrl")
	@ResponseBody
	public ResponseEntity<byte[]> getBlobImage(@PathVariable(name = "pdid") String pdId) {
		ResponseEntity<byte[]> re = null;
		ARTProduct pd = pDaoservice.select(pdId);

//		byte[] byt = pd.getProductImgBlob();
		String mimeType = ctx.getMimeType("ThisIsFake.jpg");
		MediaType mediaType = MediaType.valueOf(mimeType);
		HttpHeaders headers = new HttpHeaders();

		try {
//			ByteArrayOutputStream baos = new ByteArrayOutputStream();
//			InputStream is = blob.getBinaryStream();
//			byte[] b = new byte[81920];
//			int len = 0;
//			while ((len = is.read(b)) != -1) {
//				baos.write(byt, 0, len);
//			}
			headers.setContentType(mediaType);
			headers.setCacheControl(CacheControl.noCache().getHeaderValue()); // 設定取消 cache
//			re = new ResponseEntity<byte[]>(baos.toByteArray(), headers, HttpStatus.OK);
			re = new ResponseEntity<byte[]>(pd.getProductImgBlob(), headers, HttpStatus.OK);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return re;

	}

//	@SuppressWarnings("resource")
	@Hibernate
	@RequestMapping(path = "/14/getStarImage/{pdid}.ctrl")
	@ResponseBody
	public ResponseEntity<byte[]> getStarImage(@PathVariable(name = "pdid") String pdId) throws IOException {

		ResponseEntity<byte[]> re = null;
		ARTProduct pd = pDaoservice.select(pdId);

		String mimeType = ctx.getMimeType("ThisIsFake.jpg");
		MediaType mediaType = MediaType.valueOf(mimeType);
		HttpHeaders headers = new HttpHeaders();

		Integer productRater = pd.getProductRater();
		Integer productScore = pd.getProductScore();

		if (productScore == null) {
			productScore = 1;
		}

		if (productRater == null) {
			productRater = 1;
		}

		int starScore = (int) (productScore / productRater);

		InputStream inputStream = null;
		byte[] readAllBytes = null;

		if (starScore < 2) {

			inputStream = new FileInputStream(ctx.getRealPath("/WEB-INF/pages/images/star_1.jpg"));
			readAllBytes = inputStream.readAllBytes();

		} else if (starScore < 3) {
			inputStream = new FileInputStream(ctx.getRealPath("/WEB-INF/pages/images/star_2.jpg"));
			readAllBytes = inputStream.readAllBytes();

		} else if (starScore < 4) {

			inputStream = new FileInputStream(ctx.getRealPath("/WEB-INF/pages/images/star_3.jpg"));
			readAllBytes = inputStream.readAllBytes();

		} else if (starScore < 5) {

			inputStream = new FileInputStream(ctx.getRealPath("/WEB-INF/pages/images/star_4.jpg"));
			readAllBytes = inputStream.readAllBytes();

		} else {

			inputStream = new FileInputStream(ctx.getRealPath("/WEB-INF/pages/images/star_5.jpg"));
			readAllBytes = inputStream.readAllBytes();

		}

		try {
			headers.setContentType(mediaType);
			headers.setCacheControl(CacheControl.noCache().getHeaderValue()); // 設定取消 cache
			re = new ResponseEntity<byte[]>(readAllBytes, headers, HttpStatus.OK);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return re;

	}

	//AJAX 路徑
	@Hibernate
	@RequestMapping(path = "/14/initShopListAP", method = RequestMethod.GET, produces = "application/text; charset=utf-8")
	@ResponseBody
	public String creatJsonShopList(Model m,HttpSession session, @RequestParam(name = "pageNo", required = false) Integer pageNo) {

		ShoppingCartAP carList = (ShoppingCartAP) session.getAttribute("carList");

		// 判斷購物車不存在時的導向
		if (carList == null) {
			carList = new ShoppingCartAP();
			session.setAttribute("carList", carList);
		}

		if (pageNo == null || pageNo == 0) {
			pageNo = 1;
		}
		
		
		List<ARTProduct> selectAll = pDaoservice.selectNoImg();

		for (ARTProduct aProduct : selectAll) {
			aProduct.getProductId();
		}
		
		Map<String, ARTProduct> cartAP = carList.getCartAP();
		int size = cartAP.size();
		session.setAttribute("carSize", size);

		Gson gson = new Gson();

		String json = gson.toJson(selectAll);

		return json;


	}
	@Hibernate
	@RequestMapping(path = "/14/initPages", method = RequestMethod.GET, produces = "application/text; charset=utf-8")
	@ResponseBody
	public String creatJsonPages(HttpSession session) {
		int totalPage = pDaoservice.getTotalPages();

		List<Integer> totalPages = new ArrayList<Integer>();
		for (int i = 1; i <= totalPage; i++) {
			totalPages.add(i);
		}
		
		Gson gson = new Gson();

		String json = gson.toJson(totalPage);

		return json;
		
	}
	
	//未完待續
	@Hibernate
	@RequestMapping(path = "/14/creatJsonChangPage", method = RequestMethod.GET, produces = "application/text; charset=utf-8")
	@ResponseBody
	public String creatJsonChangPage(HttpSession session, @RequestParam(name = "pageNo", required = false) Integer pageNo,
			@RequestParam(name = "query", required = false) String query) {

		
		//TODO : query, currentPage, hasNext, hasPre, totalPages & another productListController
		
		ShoppingCartAP carList = (ShoppingCartAP) session.getAttribute("carList");

		// 判斷購物車不存在時的導向
		if (carList == null) {
			carList = new ShoppingCartAP();
			session.setAttribute("carList", carList);
		}

		// 有無參數判斷
		if (query != "" && query != null) {

			// 有參數起始
			if (pageNo == null || pageNo == 0) {
				pageNo = 1;
			}

			List<ARTProduct> queryList = pDaoservice.selectQueryAll(pageNo, query);

			
			Map<String, ARTProduct> cartAP = carList.getCartAP();
			int size = cartAP.size();
			session.setAttribute("carSize", size);
			
			Gson gson = new Gson();

			String json = gson.toJson(queryList);

			return json;

			// 有參數終了
		} else {

			// 無參數起始點
			if (pageNo == null || pageNo == 0) {
				pageNo = 1;
			}

			List<ARTProduct> pList = pDaoservice.selectAll(pageNo);

			Map<String, ARTProduct> cartAP = carList.getCartAP();
			int size = cartAP.size();
			session.setAttribute("carSize", size);

			Gson gson = new Gson();

			String json = gson.toJson(pList);

			return json;
		}

	}
	

	@Hibernate
	@RequestMapping(path = "/14/SubmitProcessAjax", method = RequestMethod.GET)
	@ResponseBody
	public String SubmitProcessaAjax(Model m, HttpSession session, HttpServletRequest request,
			@RequestParam(name = "carSize", required = false) Integer carSize,
			@RequestParam(name = "query", required = false) String query,
			@RequestParam(name = "pageNo", required = false) Integer pageNo,
			@RequestParam(name = "productID") String productID, 
			@RequestParam(name = "orderPrice") String orderPrice,
			@RequestParam(name = "orderStock", required = false) String pdStock, 
			@RequestParam(name = "orderNum") int orderNum,
			@RequestParam(name = "orderTitle") String orderTitle) {

		ShoppingCartAP carList = (ShoppingCartAP) session.getAttribute("carList");

		if (carList == null) {
			carList = new ShoppingCartAP();
			session.setAttribute("carList", carList);
		}

		ARTProduct product = new ARTProduct();

		product.setProductId(productID);
		product.setProductTitle(orderTitle);
		product.setProductNum(orderNum);
		product.setProductPrice(orderPrice);
		product.setProductImg(pdStock);
		synchronized (this) {

			carList.addToCarAP(productID, product);

		}

		Map<String, ARTProduct> cartAP = carList.getCartAP();
		Set set = cartAP.keySet();
		for (Iterator iter = set.iterator(); iter.hasNext();) {
			String key = (String) iter.next();
			ARTProduct value = (ARTProduct) cartAP.get(key);
			System.out.println(key + "====" + value);
		}

		System.out.println("------cartAP.size()------" + cartAP.size());
//		session.setAttribute("carList", carList);
		int size = cartAP.size();
		session.setAttribute("carSize", size);
		return "sucess";
	}
	
	@Hibernate
	@RequestMapping(path = "/14/getShopCartSize", method = RequestMethod.GET)
	@ResponseBody
	public int getShopCartSize(Model m, HttpSession session, HttpServletRequest request) {
		ShoppingCartAP carList = (ShoppingCartAP) session.getAttribute("carList");

		if (carList == null) {
			carList = new ShoppingCartAP();
			session.setAttribute("carList", carList);
		}
		Map<String, ARTProduct> cartAP = carList.getCartAP();
		int size = cartAP.size();
		return size;
	}
	
}
