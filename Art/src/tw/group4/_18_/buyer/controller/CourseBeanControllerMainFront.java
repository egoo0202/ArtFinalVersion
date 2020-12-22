package tw.group4._18_.buyer.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import tw.group4._14_.dashboard.dao.DashboardService;
import tw.group4._14_.dashboard.model.EntryClickRate;
import tw.group4._18_.buyer.DAO.CourseBeanDAOMainFront;
import tw.group4._18_.buyer.DAO.CourseBeanServiceMainFront;
import tw.group4._18_.buyer.model.CourseCartCo;
import tw.group4._18_.buyer.model.CourseFront;
import tw.group4.util.Hibernate;

@Controller
public class CourseBeanControllerMainFront {

	@Autowired
	private CourseBeanDAOMainFront cBeanDAOMF;

	@Autowired
	private CourseBeanServiceMainFront cBeanServiceF;
	
	@Autowired
	private DashboardService dbService;

	// 主頁面
	@Hibernate
	@RequestMapping(path = "/18/cSelectAllFront.ctrl", method = RequestMethod.GET) // 網址
	public String processActionSelectAllF(Model m, HttpSession session) {
				
		//
		EntryClickRate ecr = new EntryClickRate();
		ecr.setCourse(1);
		dbService.insert(ecr);
		//
		
		List<CourseFront> selectAllF = cBeanServiceF.selectAllF();
		m.addAttribute("cListF", selectAllF);
		
		return "18/buyerCo/18_CustomerSelectAll"; // jsp名字
	}

	// 單一課程詳細
	@Hibernate
	@RequestMapping(path = "/18/cCourseDetail.ctrl") // 網址
	public String courseDetail(Model m, @RequestParam(name = "coId") String coId) {
		// name = "輸入值"
		CourseFront cos = cBeanServiceF.selectF(coId);
		cos.setCoHot(cos.getCoHot() + 1 ); // 點擊次數的欄位+1
		m.addAttribute("cfd", cos);

		return "18/buyerCo/18_CourseDetail"; // jsp名字
	}

	
	// 關鍵字查詢
	@Hibernate
	@RequestMapping(path = "/18/searchByWord.ctrl", method = RequestMethod.GET) // form action
	public String processSearchByWord(Model m, String searchWord) {  //name=searchWord
		List<CourseFront> list = cBeanServiceF.searchByWord(searchWord);
		m.addAttribute("psbw", list);

		return "18/buyerCo/18_SearchResultWord"; // jsp名字
	}

	
	// 分類查詢
	@Hibernate
	@RequestMapping(path = "/18/searchByType.ctrl", method = RequestMethod.GET) // form action
	public String processSearchByType(Model m, String searchType) {  // name=searchType
		List<CourseFront> list = cBeanServiceF.searchByType(searchType);
		m.addAttribute("psbt", list);

		return "18/buyerCo/18_SearchResultType"; // jsp名字
	}
	
	
	

}
