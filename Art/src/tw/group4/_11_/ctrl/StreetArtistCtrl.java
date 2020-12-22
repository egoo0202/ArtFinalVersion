package tw.group4._11_.ctrl;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import tw.group4._11_.model.StreetArtistBean;
import tw.group4._11_.model.StreetArtistBeanDAO;
import tw.group4._11_.model.StreetArtistBeanService;
import tw.group4.util.Hibernate;

@Controller
@SessionAttributes(names = {"result"})
public class StreetArtistCtrl {
	@Autowired
	private StreetArtistBeanDAO sDao;
	@Autowired
	private StreetArtistBeanService sService;
//	總覽
	@Hibernate
	@RequestMapping(path = "/myStreetArtistPage.ctrl" ,method = RequestMethod.GET)
	public String showingSA(Model m) {
		
		List<StreetArtistBean> list = sDao.selectAll();
		
		m.addAttribute("BeanList_SA",list);
		
		return "_11_SA/Show_SA";
	}
//	C
	@Hibernate
	@RequestMapping(path = "/GoCreate.ctrl")
	public String goCreate(Model m) {
		StreetArtistBean streetArtist = new StreetArtistBean();
    	m.addAttribute("streetArtist", streetArtist);
		return "_11_SA/NewSA";
	}
	
	@Hibernate
	@RequestMapping(path = "/createSA.ctrl",method = RequestMethod.POST)
	public String createeSA(@RequestParam(name = "NAME_SA") String name,
							@RequestParam(name = "COUNTRY_SA") String country,
							@RequestParam(name = "THEME_SA") String theme,
							@RequestParam(name = "CLASSIFICATION_SA") String classification,Model m) {
		Map<String, String> errors = new HashMap<String, String>();
		m.addAttribute("errors", errors);
		
		if(name==null || name.length()==0) {
			errors.put("name", "name is required !");
    	}
		if(country==null || country.length()==0) {
			errors.put("country", "country is required !");
    	}
		if(theme==null || theme.length()==0) {
			errors.put("theme", "theme is required !");
    	}
		if(classification==null || classification.length()==0) {
			errors.put("classification", "classification is required !");
    	}
		StreetArtistBean sBean = new StreetArtistBean();
		
		sBean.setName_SA(name);
		sBean.setCountry_SA(country);
		sBean.setTheme_SA(theme);
		sBean.setClassification_SA(classification);
		
		sDao.insert(sBean);
		
		m.addAttribute("name","create Street Artist");
		return "_11_SA/Success";
	}
//	R
	@Hibernate
	@RequestMapping(path = "/GoDel.ctrl")
	public String goDel(Model m) {
		StreetArtistBean streetArtist = new StreetArtistBean();
    	m.addAttribute("streetArtist", streetArtist);
		return "_11_SA/DelSA";
	}
//	照ID刪
	@Hibernate
	@RequestMapping(path = "/delSA.ctrl",method = RequestMethod.POST)
	public String deleteSA(@ModelAttribute("streetArtist") StreetArtistBean delSA, BindingResult result, Model m) {
		if(result.hasErrors()) {
			m.addAttribute("result","delete Street Artist");
    		return "_11_SA/Error";
    	}
		
		sDao.delete(delSA.getId_SA());
		
		m.addAttribute("name","delete Street Artist");
		return "_11_SA/Success";
	}
//	一鍵刪除
	@Hibernate
	@RequestMapping(path = "/delSearch.ctrl",method = RequestMethod.POST)
	public String deleteSearch(String id_SA, Model m) {
		int id_SAnum =Integer.parseInt(id_SA);
		sDao.delete(id_SAnum);
		
		m.addAttribute("name","delete Street Artist");
		return "_11_SA/Success";
	}
//	U
	@Hibernate
	@RequestMapping(path = "/fixSA.ctrl",method = RequestMethod.POST)
	public String fixSA(
			@RequestParam(name = "id_SA") String id_SA, Model m) {
		int id_SAint = Integer.parseInt(id_SA);
		List<StreetArtistBean> list = sDao.searchID(id_SAint);
		
		m.addAttribute("WantToFix",list);
		return "_11_SA/FixSA";
//多傳一個變數裝id_SASA
	}
	
	@Hibernate
	@RequestMapping(path = "/fixingSA.ctrl",method = RequestMethod.POST)
	public String  FixingSA(@RequestParam(name = "ID_SA") int id,
							@RequestParam(name = "NAME_SA") String name,
							@RequestParam(name = "COUNTRY_SA") String country,
							@RequestParam(name = "THEME_SA") String theme,
							@RequestParam(name = "CLASSIFICATION_SA") String classification,Model m) {
		Map<String, String> errors = new HashMap<String, String>();
		m.addAttribute("errors", errors);
		
		if(name==null || name.length()==0) {
			errors.put("name", "name is required !");
    	}
		if(country==null || country.length()==0) {
			errors.put("country", "country is required !");
    	}
		if(theme==null || theme.length()==0) {
			errors.put("theme", "theme is required !");
    	}
		if(classification==null || classification.length()==0) {
			errors.put("classification", "classification is required !");
    	}
		
		sDao.update(id, name, country, theme, classification);
		
		m.addAttribute("name","fix Street Artist");
		return "_11_SA/Success";
	}
//	D
	@Hibernate
	@RequestMapping(path = "/GoSearch.ctrl")
	public String goSearch(Model m) {
		StreetArtistBean streetArtist = new StreetArtistBean();
    	m.addAttribute("streetArtist", streetArtist);
		return "_11_SA/SearchSA";
	}
	
	@Hibernate
	@RequestMapping(path = "/searchSA.ctrl",method = RequestMethod.POST)
	public String searchSA(@RequestParam(name = "word") String searchSA, Model m) {
		
		List<StreetArtistBean> list= sDao.search(searchSA);
		
		m.addAttribute("reBeanList_SA",list);
		
		return "_11_SA/SearchReturn";
	}
	
	@Hibernate
	@GetMapping(value = "/ToWebBack.ctrl")
	public String toOtherWeb(
			@RequestParam("id_SA") Integer sa,Model m
			) {
		List<StreetArtistBean> list = sService.searchID(sa);
		int sal = sService.showSal(sa);
		
    	m.addAttribute("dataForWeb", list);
		m.addAttribute("Donation",sal);
    	return "_11_SA/AdViewSA";
	}
}
