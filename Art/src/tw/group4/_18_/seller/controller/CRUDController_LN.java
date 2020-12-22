package tw.group4._18_.seller.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import tw.group4._18_.seller.model.CourseBeanService;
import tw.group4._18_.seller.model.Course;
import tw.group4.util.Hibernate;

@Controller
@SessionAttributes({"type"})
public class CRUDController_LN {
	
	@Autowired
	private CourseBeanService cBeanService;
	
	// 主頁面
	@Hibernate
	@RequestMapping(path = "/18/cSelectAll.ctrl" ,method = RequestMethod.GET) //網址
	public String processActionSelectAll(@ModelAttribute("Update")String update, @ModelAttribute("Delete")String delete, 
		@ModelAttribute("Insert")String insert,  Model m) {  //傳到18_SelectAll最上端接值，String後沒用到
		
		List<Course> selectAll = cBeanService.selectAll();
		m.addAttribute("cList", selectAll);
		
		return "18/sellerCo/18_SelectAll"; //欲跳之jsp名字
	}
	
	
	// 單一課程詳細
		@Hibernate
		@RequestMapping(path = "/18/cCourseDetailB.ctrl") // 網址
		public String courseDetail(Model m, @RequestParam(name = "coId") String coId) {
			// name = "輸入值"
			Course cos = cBeanService.selectB(coId);
//			cos.setCoHot(cos.getCoHot() + 1 ); // 點擊次數的欄位+1(前台使用就好)
			m.addAttribute("cfd", cos);

			return "18/sellerCo/18_CourseDetailB"; // jsp名字
		}
	

	// 新增
	@Hibernate
	@RequestMapping(path = "/18/cInsert.ctrl" ,method = RequestMethod.POST)
	public String processActionInsert(Model m, @RequestParam(name = "coTitle")String coTitle, @RequestParam(name = "coAct_Type")String coAct_Type, 
			@RequestParam(name = "coAct_Location")String coAct_Location, @RequestParam(name = "coLocation_Name")String coLocation_Name, 
			@RequestParam(name = "coNum")int coNum, @RequestParam(name = "coPrice")int coPrice, @RequestParam(name = "coAct_Date")String coAct_Date, @RequestParam(name = "coAct_Time")String coAct_Time, 
			@RequestParam(name = "coEnd_Date")String coEnd_Date, @RequestParam(name = "coEnd_Time")String coEnd_Time, @RequestParam(name = "coAct_Description")String coAct_Description,  
			@RequestParam(name = "coHot",defaultValue = "0")Integer coHot, @RequestParam(name = "coAct_Image")MultipartFile coAct_Image)	{  
		    //name = "輸入值"
				
		Course co = new Course();
//		co.setCoId(coId);
		co.setCoTitle(coTitle);
		co.setCoAct_Type(coAct_Type);
		co.setCoAct_Location(coAct_Location);
		co.setCoLocation_Name(coLocation_Name);
		co.setCoNum(coNum);
		co.setCoPrice(coPrice);
		co.setCoAct_Date(coAct_Date);
		co.setCoAct_Time(coAct_Time);
		co.setCoEnd_Date(coEnd_Date);
		co.setCoEnd_Time(coEnd_Time);
		co.setCoAct_Description(coAct_Description);
		co.setCoHot(coHot);
		try {
			co.setCoAct_Image(coAct_Image.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
//		co.setCoAct_ImageStr(coAct_ImageStr);
		
		Course cbs = cBeanService.insert(co);
		
		
		System.out.println(cbs.getCoAct_Time());
		m.addAttribute("successLN", "新增課程成功");
		return "redirect:/18/cSelectAll.ctrl"; //欲跳之網址
	}
	
	@Hibernate
	@RequestMapping(path="/18/insertData.ctrl") //網址
	public String processActionInsert2() {
		return "18/sellerCo/18_Insert";  //jsp名字
		
	}
	
	
	//刪除
	@Hibernate
	@RequestMapping(path = "/18/cDelete.ctrl", method = RequestMethod.GET)
	public String processActionDelete(Model m, @RequestParam(name= "coId")String coId) {  //name = "輸入值"
		boolean result = cBeanService.delete(coId);
		System.out.println("+++++++++++++++++++++++++++++"+result);
		Course co = cBeanService.select(coId); // 要用select，用selectB會報錯NullPointerException
		m.addAttribute("co", co); 
		m.addAttribute("coId", coId);
		
		if (result) {
			m.addAttribute("Delete", "刪除課程成功");			
		} else {			
			m.addAttribute("Delete", "刪除課程失敗");			
		}
		return "redirect:/18/cSelectAll.ctrl"; //欲跳之網址
		
	}
	
//	@Hibernate
//	@RequestMapping(path = "/18/DeleteData.ctrl")  //網址
//	public String processActionDelete2(Model m, @RequestParam(name = "coId")String coId) {
//		m.addAttribute("coId", coId);
//		return "18/sellerCo/18_Delete";  //jsp名字
//	}
	
	
	// 修改
	@Hibernate
	@RequestMapping(path = "/18/cUpdate.ctrl", method = RequestMethod.POST)
	public String processActionUpdate(Model m, @RequestParam(name = "coId")String coId, @RequestParam(name = "coTitle")String coTitle, @RequestParam(name = "coAct_Type")String coAct_Type, 
			@RequestParam(name = "coAct_Location")String coAct_Location, @RequestParam(name = "coLocation_Name")String coLocation_Name, @RequestParam(name = "coNum")int coNum, @RequestParam(name = "coPrice")int coPrice, 
			@RequestParam(name = "coAct_Date")String coAct_Date, @RequestParam(name = "coAct_Time")String coAct_Time, @RequestParam(name = "coEnd_Date")String coEnd_Date, 
			@RequestParam(name = "coEnd_Time")String coEnd_Time, @RequestParam(name = "coAct_Description")String coAct_Description, @RequestParam(name = "coHot")int coHot, @RequestParam(name = "coAct_Image") MultipartFile coAct_Image) {

		byte [] byt2= null;
		try {
			byt2 = coAct_Image.getBytes();
			
			// 判斷是否有coAct_Image 沒有則存入原來的圖
			if(byt2.length == 0) {
				Course course =cBeanService.selectB(coId);
				byte [] oldbyt2 = course.getCoAct_Image();
				System.err.println(byt2.length);
				boolean result = cBeanService.update(coId, coTitle, coAct_Type, coAct_Location, coLocation_Name, coNum, coPrice, coAct_Date, coAct_Time, coEnd_Date, coEnd_Time, coAct_Description, coHot, oldbyt2);
				if (result) {
					m.addAttribute("Update", "修改課程成功");			
				} else {			
					m.addAttribute("Update", "修改課程失敗");
				}
				System.out.println("存入舊圖");
			} else {
				cBeanService.update(coId, coTitle, coAct_Type, coAct_Location, coLocation_Name, coNum, coPrice, coAct_Date, coAct_Time, coEnd_Date, coEnd_Time, coAct_Description, coHot, byt2);
				System.out.println("存入新圖");
			}
			
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
//		boolean result = cBeanService.update(coId, coTitle, coAct_Type, coAct_Location, coLocation_Name, coNum, coPrice, coAct_Date, coAct_Time, coEnd_Date, coEnd_Time, coAct_Description, coHot, byt2);
		
	
		
		return "redirect:/18/cSelectAll.ctrl"; //欲跳之網址
	}
	
	@Hibernate
	@RequestMapping(path = "/18/UpdateData.ctrl", method = RequestMethod.GET) //網址
	public String processActionUpdate2(Model m, @RequestParam(name = "coId")String coId) {  //name = "輸入值"
				
		Course co = cBeanService.selectB(coId);
		String coAct_Type = co.getCoAct_Type();
		
//		cBeanService.update(id, title, price);
		m.addAttribute("co", co);
//		m.addAttribute("coTitle", coTitle);
//		m.addAttribute("coAct_Type", coAct_Type);
//		m.addAttribute("coAct_Location", coAct_Location);
//		m.addAttribute("coLocation_Name", coLocation_Name);
//		m.addAttribute("coNum", coNum);
//		m.addAttribute("coPrice", coPrice);
//		m.addAttribute("coAct_Date", coAct_Date);
//		m.addAttribute("coAct_Time", coAct_Time);
//		m.addAttribute("coEnd_Date", coEnd_Date);
//		m.addAttribute("coEnd_Time", coEnd_Time);
//		m.addAttribute("coAct_Description", coAct_Description);
//		m.addAttribute("coHot", coHot);
////		m.addAttribute("coAct_Image", coAct_Image);
		
		if (coAct_Type.equals("語文")) {
			m.addAttribute("type", "1");
		}
		if (coAct_Type.equals("園藝")) {
			m.addAttribute("type", "2");
		}
		if (coAct_Type.equals("風俗信仰")) {
			m.addAttribute("type", "3");
		}
		if (coAct_Type.equals("手工製作")) {
			m.addAttribute("type", "4");
		}
		if (coAct_Type.equals("國畫書法")) {
			m.addAttribute("type", "5");
		}
		if (coAct_Type.equals("運動")) {
			m.addAttribute("type", "6");
		}
		if (coAct_Type.equals("藝術鑑賞")) {
			m.addAttribute("type", "7");
		}
		if (coAct_Type.equals("美術")) {
			m.addAttribute("type", "8");
		}
		if (coAct_Type.equals("戲劇")) {
			m.addAttribute("type", "9");
		}
		
		return "18/sellerCo/18_Update";  //jsp名字
	}
	
	
	
		
		// 關鍵字查詢
		@Hibernate
		@RequestMapping(path = "/18/searchByWordB.ctrl", method = RequestMethod.GET) // form action
		public String processSearchByWord(Model m, String searchWordB) {  //name=searchWord
			List<Course> list = cBeanService.searchByWord(searchWordB);
			m.addAttribute("psbwB", list);

			return "18/sellerCo/18_SearchResultWordB"; // jsp名字
		}

		
		// 分類查詢
		@Hibernate
		@RequestMapping(path = "/18/searchByTypeB.ctrl", method = RequestMethod.GET) // form action
		public String processSearchByType(Model m, String searchTypeB) {  // name=searchType
			List<Course> list = cBeanService.searchByType(searchTypeB);
			m.addAttribute("psbtB", list);

			return "18/sellerCo/18_SearchResultTypeB"; // jsp名字
		}

}
