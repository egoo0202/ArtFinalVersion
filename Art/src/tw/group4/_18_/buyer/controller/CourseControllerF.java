package tw.group4._18_.buyer.controller;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import tw.group4._18_.buyer.DAO.CourseBeanServiceMainFront;
import tw.group4._18_.buyer.model.CourseCartCo;
import tw.group4._18_.buyer.model.CourseFront;
import tw.group4.util.Hibernate;

@Controller
public class CourseControllerF {
	
	@Autowired
	private CourseBeanServiceMainFront cBeanServiceF;
	
	
	//放入購物車
	@Hibernate
	@RequestMapping(path = "/18/CoSubmit.ctrl", method = RequestMethod.GET)
	public String CoSubmit(Model m, HttpSession session, HttpServletRequest request,
			@RequestParam(name = "cartSize", required = false) Integer cartSize,
			@RequestParam(name = "query", required = false) String query,
			@RequestParam(name = "pageNo", required = false) Integer pageNo, @RequestParam(name = "coId") String coId,
			@RequestParam(name = "orderTitle") String orderTitle, @RequestParam(name = "orderNum") int orderNum,
			@RequestParam(name = "orderPrice") int orderPrice, @RequestParam(name = "orderAct_Date") String orderAct_Date,
			@RequestParam(name = "orderAct_Time") String orderAct_Time
		 //	@RequestParam(name = "coAct_ImageStr") String coAct_ImageStr
			) {

		
		CourseCartCo ccc = (CourseCartCo) session.getAttribute("ccc"); //*

		if (ccc == null) {
			ccc = new CourseCartCo();
			session.setAttribute("ccc", ccc);
		}

		CourseFront cos = cBeanServiceF.selectF(coId);
			
		
		CourseFront co = new CourseFront();

		co.setCoId(coId);
		co.setCoTitle(orderTitle);
		co.setCoNum(orderNum);
		co.setCoPrice(orderPrice);
		co.setCoAct_Date(orderAct_Date);
		co.setCoAct_Time(orderAct_Time);
		co.setCoAct_ImageStr(cos.getCoAct_ImageStr());

		synchronized (this) { // synchronized鎖定，對象鎖，只能依序訪問；若不同則可同時訪問

			ccc.addToCoCart(coId, co);

		}

		// Map<K, V>
		Map<String, CourseFront> cartco = ccc.getCartCo();  //*
		Set set = cartco.keySet(); // 獲取Map集合中所有鍵存到set集合，之後透過Iterator取出
		for (Iterator iterator = set.iterator(); iterator.hasNext();) {
			String ke = (String) iterator.next();
			CourseFront va = (CourseFront) cartco.get(ke);
			System.out.println(ke + "===" + va);
		}

		// iterator()方法可以傳回一個Iterator物件，這個物件會收集List或Set物件內部資料，並有 hasNext()、next()方法可以使用
		// next()獲取下一個元素並取出返回
		// hasNext()檢查是否還有下一個元素
		// remove()刪除上次返回的元素

		System.out.println("---cartco.size()---" + cartco.size());

		return "18/buyerCo/18_Order";  // jsp
	}
	
	
	//前往填寫訂單
	@Hibernate
	@RequestMapping(path = "/18/toCoCart.ctrl") // 網址
	public String toCoCart(HttpSession session) {
		
		CourseCartCo ccc = (CourseCartCo) session.getAttribute("ccc");
		
		if (ccc == null) { // null則回首頁
//			return "redirect:/18/cSelectAllFront.ctrl";
			return "18/buyerCo/18_Order"; // jsp名字
		} else {
			return "18/buyerCo/18_Order"; // jsp名字
		}
	}
	
	
}
