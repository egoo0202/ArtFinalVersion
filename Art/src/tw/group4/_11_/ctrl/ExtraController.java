package tw.group4._11_.ctrl;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.http.HttpException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import tw.group4._11_.model.DonateRecordBean;
import tw.group4._11_.model.GreenFromation;
import tw.group4._11_.model.SentMailService;
import tw.group4._11_.model.UserSABean;
import tw.group4._11_.model.UserSADao;
import tw.group4._11_.model.UserSAService;
import tw.group4._14_.dashboard.dao.DashboardService;
import tw.group4._14_.dashboard.model.EntryClickRate;
import tw.group4._14_.utils.ECPayment;
import tw.group4._35_.login.model.WebsiteMember;
import tw.group4._35_.login.model.WebsiteMemberService;
import tw.group4.util.Hibernate;

@Controller
@SessionAttributes(names = "result2")
public class ExtraController {
	@Autowired
	private UserSADao uDAO;
	@Autowired
	private UserSAService uService;
	@Autowired
	private WebsiteMemberService wDaoService;
	@Autowired
	private SentMailService smService;
	
	@Autowired
	private DashboardService dbService;

	
	@Hibernate
	@RequestMapping(path = "/userStreetArtistPage.ctrl" ,method = RequestMethod.GET)
	public String showingSA(
			@RequestParam(name = "page" , required = false) Integer page,
			@RequestParam(name = "query" ,required = false) String query,
			Model m) {
		
		//
		EntryClickRate ecr = new EntryClickRate();
		ecr.setArtist(1);
		dbService.insert(ecr);
		//
		
		
		
		if (query != "" && query != null) {
			
			if (page == null || page == 0) {
				page =1;
			}
			
			List<UserSABean> querylist = uService.selectQueryAll(page, query);
			int totalPage = uService.getPages(query);
			
			List<Integer> totlePages = new ArrayList<Integer>();
			for (int i = 1; i <= totalPage; i++) {
				totlePages.add(i);
			}
			
			m.addAttribute("BeanList_SA",querylist);
			m.addAttribute("query",query);
			m.addAttribute("PageMum_SA",page);
			m.addAttribute("totalPages_SA",totalPage);
			m.addAttribute("allPages",totlePages);
		}else {
			if (page == null || page == 0) {
				page =1;
			}
			
			List<UserSABean> list = uService.selectPage(page);
			int totalPage = uService.getTotlaPage();
			
			List<Integer> totlePages = new ArrayList<Integer>();
			for (int i = 1; i <= totalPage; i++) {
				totlePages.add(i);
			}
			
			List<Integer> first8Pages = new ArrayList<Integer>();
			for (int i = 1; i <= 15; i++) {
				first8Pages.add(i);
			}
			
			List<Integer> middlePages = new ArrayList<Integer>();
			for (int i = page-7; i <= page+7; i++) {
				middlePages.add(i);
			}
			
			List<Integer> last8Pages = new ArrayList<Integer>();
			for (int i = totalPage-14 ; i <= totalPage; i++) {
				last8Pages.add(i);
			}
			
			m.addAttribute("BeanList_SA",list);
			m.addAttribute("PageMum_SA",page);
			m.addAttribute("totalPages_SA",totalPage);
			m.addAttribute("allPages",totlePages);
			m.addAttribute("first8Pages",first8Pages);
			m.addAttribute("middlePages",middlePages);
			m.addAttribute("last8Pages",last8Pages);
		}
		
		return "_11_SA/NormalUser/Showing_2";
	}
	
	@Hibernate
	@RequestMapping(path = "/searchSA2.ctrl",method = RequestMethod.POST)
	public String searchSA2(@RequestParam(name = "word") String searchSA, Model m) {
		
		List<UserSABean> list= uDAO.search(searchSA);
		
		m.addAttribute("reUBeanList_SA",list);
		
		return "_11_SA/NormalUser/UserReturn";
	}
	
	@Hibernate
	@RequestMapping(path = "/searchSA3.ctrl",method = RequestMethod.POST)
	public String searchSA3(
			@RequestParam(name = "country") String country,
			@RequestParam(name = "classification") String classification,
			@RequestParam(name = "theme") String theme,
			Model m) {
		
		List<UserSABean> list = uDAO.search3(country, classification, theme);
		
		m.addAttribute("reUBeanList_SA",list);
		m.addAttribute("country",country);
		m.addAttribute("classification",classification);
		m.addAttribute("theme",theme);
		
		return "_11_SA/NormalUser/UserReturn";
	}
	
//	連個人網站
	@Hibernate
	@GetMapping(value = "/ToWeb.ctrl")
	public String toOtherWeb(
			@RequestParam("id_SA") String sa,Model m
			) {
		int id_SA2 = Integer.parseInt(sa);
		List<UserSABean> list = uService.selectIdSA(id_SA2);
		
		String mas = uDAO.judgePic(id_SA2);
		
    	m.addAttribute("dataForWeb", list);
		m.addAttribute("msgForWeb",mas);
		System.out.println(mas);
    	return "_11_SA/NormalUser/KnowMore";
	}
	
//	連斗內介面
	@Hibernate
	@GetMapping(value = "/ToDonate.ctrl")
	public String toDonate(
			@RequestParam(name = "id_SA") String id_dn,
			HttpSession session,
			Model m) {
		if (session == null) {
			return "redirect:/userStreetArtistPage.ctrl";
		}
		
		WebsiteMember mb = (WebsiteMember) session.getAttribute("member");
		if (mb == null) {
			return "redirect:/35/loginEntry";
		}
		
		int id = Integer.parseInt(id_dn);
		List<UserSABean> list = uDAO.searchID(id);
		
    	m.addAttribute("streetArtist", list);
		return "_11_SA/NormalUser/DonateSA";
	}
	
	@Hibernate
	@RequestMapping(path ="/doDonate.ctrl")
	public String doDonate(
			@RequestParam(name = "id_SA") String id_SA,
			@RequestParam(name = "sal") String salWeb,
			HttpSession hSession,
			Model m) throws IOException,HttpException{
		int idsa = Integer.parseInt(id_SA);
		Map<String, String> errors = new HashMap<String, String>();
		m.addAttribute("errors", errors);
		
		if (salWeb == null || salWeb.length()==0) {
			errors.put("msg", "please enter a number!!");
		} 
		
		WebsiteMember mb = (WebsiteMember) hSession.getAttribute("member");
		Integer id = mb.getId();
		WebsiteMember selectById = wDaoService.selectById(id);
		
		UserSABean beanSA = uDAO.selectById(idsa);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		
		String name_SA = beanSA.getName_SA();
		String memberName = selectById.getRealName();
		String donateTime = sdf.format(date);
		
		DonateRecordBean record = new DonateRecordBean();
		try {
			int sal = Integer.parseInt(salWeb);
			if (sal <= 0) {
				errors.put("msg", "不可輸入小於零或等於零的數字");
			}
			uDAO.donateToSA(idsa, sal);
			
			record.setName_SA(name_SA);
			record.setDonate_sa(sal);
			record.setName_user(memberName);
			record.setTime(donateTime);
			
			uService.insert(record);
			
//			寄送信件
			smService.processSendMailSA(record);
			
//			綠界
			GreenFromation payment = new GreenFromation();
//			System.out.println("--------------"+donateTime);
//			System.out.println("++++++++++++++++"+sal);
			String greenCheckAll = payment.greenCheck(donateTime, sal);

//			hSession.setAttribute("form", greenCheckAll);
			m.addAttribute("form", greenCheckAll);
//			return "_11_SA/NormalUser/Success";
			return "_11_SA/NormalUser/NewFile";
		} catch (Exception e) {
			errors.put("msg", "請勿輸入數字以外的字串!!");
			e.printStackTrace();
			return "redirect:/userStreetArtistPage.ctrl";
		}
	}
	
	@Hibernate
	@RequestMapping(path ="/showDonateList")
	public String showDonateList(
			HttpSession hSession,
			Model m) {
		if (hSession == null) {
			return "redirect:/userStreetArtistPage.ctrl";
		}
		
		WebsiteMember mb = (WebsiteMember) hSession.getAttribute("member");
		if (mb == null) {
			return "redirect:/35/loginEntry";
		}
		
		Integer id = mb.getId();
		WebsiteMember member = wDaoService.selectById(id);
		
		String username = member.getRealName();
		List<DonateRecordBean> list1 = uService.showList(username);
		
		m.addAttribute("donationList", list1);
		return "_11_SA/NormalUser/ShowHisDonateRecord";
	}
	
	@Hibernate
	@RequestMapping(path ="/showDonateListForAdmin")
	public String showDonateListForAdmin(
			HttpSession hSession,
			Model m) {
		if (hSession == null) {
			return "redirect:/userStreetArtistPage.ctrl";
		}
		
		WebsiteMember mb = (WebsiteMember) hSession.getAttribute("member");
		if (mb == null) {
			return "redirect:/35/loginEntry";
		}
		List<DonateRecordBean> listAdminView = uService.showAllDonateRecord();
		
		m.addAttribute("donationList", listAdminView);
		return "_11_SA/ShowAllDonateRecord";
	}
	
//	@Hibernate
//	@GetMapping(path ="/doDonate.ctrl")
//	public String doDonate(
//			@RequestParam(name = "id_SA") String id_SA,
//			@RequestParam(name = "sal") String salWeb,
//			ServletRequest request,
//			ServletResponse response,
//			Model m) throws IOException, ServletException{
//		
//		HttpServletResponse httpRes = (HttpServletResponse) response;
//		HttpServletRequest httpReq = (HttpServletRequest) request;
//		HttpSession session = httpReq.getSession();
//		
//		
//		
//		int id = Integer.parseInt(id_SA);
//		Map<String, String> errors = new HashMap<String, String>();
//		m.addAttribute("errors", errors);
//		
//		if (salWeb == null || salWeb.length()==0) {
//			errors.put("msg", "please enter a number!!");
//		} 
//		
//		try {
//			int sal = Integer.parseInt(salWeb);
//			if (sal <= 0) {
//				errors.put("msg", "不可輸入小於零或等於零的數字");
//			}
//			uDAO.donateToSA(id, sal);
//		} catch (Exception e) {
//			errors.put("msg", "請勿輸入數字以外的字串!!");
//			e.printStackTrace();
//		}
//		
//		m.addAttribute("name","donate to streetartist!!");
//		return "_11_SA/NormalUser/Success";
//	}
}
