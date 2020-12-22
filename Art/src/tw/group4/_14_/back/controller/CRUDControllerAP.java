package tw.group4._14_.back.controller;


import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import tw.group4._14_.back.ARTProduct;
import tw.group4._14_.back.dao.ProductBeanDAOService;
import tw.group4._14_.front.model.OrderListBeamAP;
import tw.group4._14_.init.ImageProcess;
import tw.group4.util.Hibernate;


@Lazy
@Controller
//@SessionAttributes(names = {"pageNo"})
public class CRUDControllerAP {

	@Autowired
	@Qualifier("ProductBeanDAOService")
	private ProductBeanDAOService pDaoservice;
	
	@Autowired
	private HttpServletRequest request;
	
	@Autowired
	ServletContext ctx;
	
	@Hibernate
	@RequestMapping(path = "/14/CRUDNoDataTable.ctrl", method = RequestMethod.GET) //不用 DataTable 時使用此方法
	public String processAction(Model m, @RequestParam(name = "pageNo" ,required = false) Integer pageNo) {
		
			if (pageNo == null||pageNo ==0) {
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
			
			return "14/14_CRUDPage";
	}
	
	@Hibernate
	@RequestMapping(path = "/14/CRUD.ctrl", method = RequestMethod.GET) //DataTable 版
	public String processAction23(Model m) {
		
//			System.out.println(pDaoservice);
			List<ARTProduct> pList = pDaoservice.selectNoPage();
			
			m.addAttribute("pList", pList);
			
			return "14/14_CRUDPage";
	}
	
	@Hibernate
	@RequestMapping(path = "/14/deleteProduct.ctrl", method = RequestMethod.GET) //刪除商品
	public String processDelete(Model m, @RequestParam(name = "pageNo" ,required = false) Integer pageNo, 
			@RequestParam(name = "productId" ,required = true)String productid)
			 {

		boolean result = pDaoservice.delete(productid);
		if (result != false) {
			m.addAttribute("SuccessMessage", "編號 " + productid + " 的商品已刪除！");

		} else {
			m.addAttribute("OrderErrorMessage", "刪除失敗，請再次確認此商品狀態！");
		}
		
		if (pageNo == null||pageNo ==0) {
			pageNo = 1;
		}

		List<ARTProduct> pList = pDaoservice.selectAll(pageNo);
		
			int totalPage = pDaoservice.getTotalPages();
			List<Integer> totalPages = new ArrayList<Integer>();
			for (int i = 1; i <= totalPage; i++) {
				totalPages.add(i);
			}
			
			return  "redirect:/14/CRUD.ctrl";

	}
	
	@Hibernate
	@RequestMapping(path = "/14/updateProduct.ctrl", method = RequestMethod.GET) //[舊版] 修改商品
	public String processUpdate(Model m, @RequestParam(name = "pageNo" ,required = false) Integer pageNo,
			@RequestParam(name = "productid") String productid )
			 {
//		System.out.println("productid"+productid);
//		System.out.println(pDaoservice);
		ARTProduct ap = pDaoservice.select(productid);
		m.addAttribute("ap", ap);

//		return "14/14_UpdatePage";
		return "14/14_Update";
		

	}
	@Hibernate
	@RequestMapping(path = "/14/updateDoneProduct.ctrl", method = RequestMethod.POST) //修改商品
	public String processUpdateDone(Model m, @RequestParam(name = "pageNo",required = false) Integer pageNo, 
			@RequestParam(name = "APNUM") Integer apNum, @RequestParam(name = "APPRICE") String apPrice,
			@RequestParam(name = "APTITLE") String apTitle, @RequestParam(name = "productid") String productid, @RequestParam(name = "APDES") String APDES,
			@RequestParam(name = "myFiles" ) MultipartFile mFile) throws IOException {
		
		byte[] bytes = null;
		System.out.println("------------"+mFile.getBytes().length+"----------------");
		if(mFile.getBytes().length == 0) {
			ARTProduct originArtProduct = pDaoservice.select(productid);
			bytes = originArtProduct.getProductImgBlob();
			
		}else {
			
			try {
				bytes = mFile.getBytes();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
		
		pDaoservice.update(productid, apTitle, apPrice, apNum, bytes, APDES);

		return  "redirect:/14/CRUD.ctrl";

	}
	
	//FORM:FORM 難用的東西
	@Hibernate
	@RequestMapping(path = "/14/updateFormDone.ctrl", method = RequestMethod.POST) //想不開
	public String processUpdateFormDone(@ModelAttribute("ap") ARTProduct ap, BindingResult result, Model m) {
		if(ap.getProductImgBlob() == null) {
			ARTProduct originArtProduct = pDaoservice.select(ap.getProductId());
			ap.setProductImg(originArtProduct.getProductImg());
			ap.setProductImgBlob(originArtProduct.getProductImgBlob());
		}
		System.out.println(ap.getProductImgBlob().length);
		try {
		ImageProcess.writeFile("C:\\新增資料夾\\tets.jpg", ap.getProductImgBlob());
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		pDaoservice.updateProduct(ap);
		
		return  "redirect:/14/CRUD.ctrl";
	}
	
	
	@Hibernate
	@RequestMapping(path = "/14/createProduct.ctrl", method = RequestMethod.POST) // 新增商品
	public String processCreate(Model m, @RequestParam(name = "pageNo" ,required = false) Integer pageNo,
			@RequestParam(name = "APNUM") Integer apNum,@RequestParam(name = "APPRICE") String apPrice, 
			@RequestParam(name = "APTITLE") String apTitle, @RequestParam(name = "APTYPE",required = false) String apType, @RequestParam(name = "APTYPE2",required = false) String apSubType,
			@RequestParam(name = "APDES",required = false) String apDes, @RequestParam(name = "myFiles") MultipartFile mFile)  {

//		String fileName = mFile.getOriginalFilename();
//		String fileTempDirPath = request.getSession().getServletContext().getRealPath("/") + "UploadTempDir\\";
		
//		File dirPath = new File(fileTempDirPath);
//		if(!dirPath.exists()) {
//			boolean status = dirPath.mkdirs();
//			System.out.println("status:" + status);
//		}
		
		
//		String fileSavePath = fileTempDirPath + fileName;
//		File saveFile = new File(fileSavePath);
//		try {
//			mFile.transferTo(saveFile);
//			System.out.println("fileSavePath"+fileSavePath);
//		} catch (IllegalStateException | IOException e1) {
//			e1.printStackTrace();
//		}
		
	
//		Blob blob = null;
//		byte[] img = null;
//		try {
////			blob = ImageProcess.fileToBlob(fileSavePath);
//			img = ImageProcess.fileToByte(fileSavePath);
//		} catch (IOException | SQLException e) {
//			e.printStackTrace();
//		}
	
		
//		int num = Integer.parseInt(apNum);
		
//		apDes.replaceAll("(\r\n|\n)", "<br />");
		apDes.replace("\\r\\n | /\n | \r\n/g","<br>");
		
		ARTProduct pd = new ARTProduct();
		pd.setProductTitle(apTitle);
		pd.setProductPrice(apPrice);
		pd.setProductNum(apNum);
		pd.setProductType(apType); 
		pd.setProductSubType(apSubType);
		pd.setProductDes(apDes);
		pd.setProductScore(1);
		pd.setProductRater(1);
		pd.setProductMessage(0);
//		pd.setProductImgBlob(blob);
		try {
			pd.setProductImgBlob(mFile.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}

		pDaoservice.insert(pd);
		
		m.addAttribute("SuccessMessage", "商品新增成功！");

		return "redirect:/14/CRUD.ctrl";

	}
	@Hibernate
	@RequestMapping(path="/14/showOneProductCMS.ctrl") //列出單項商品
	public String processDetial(Model m, @RequestParam(name = "pageNo" ,required = false) Integer pageNo,
			@RequestParam(name = "productid") String apNum) {
		ARTProduct ap = pDaoservice.select(apNum);
		m.addAttribute("ap",ap);
		return "14/14_showOnePdCms";
		
		
	}
	
	
	@RequestMapping(path="/14/Create.ctrl")
	public String processAction2(Model m) {
		return "14/14_Create";
	}
	
	//刪除會員訂單之類的東西從以下開始
	
}
