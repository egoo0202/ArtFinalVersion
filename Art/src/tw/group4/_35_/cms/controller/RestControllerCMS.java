package tw.group4._35_.cms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import tw.group4._35_.cms.model.EventSpace;
import tw.group4._35_.cms.model.InterfaceEventSpaceService;
import tw.group4.util.Hibernate;

//這是改半套的RestController
//還沒用Ajax前無法@ResponseBody直接回應，@PathVariable也很難用
//因為JSP html內的form action無法用put和delete，必須寫在js code
//若用@RestController，回應方法不用再加上@ResponseBody
@Controller
@RequestMapping("/35/")
public class RestControllerCMS {
	
	@Autowired
	InterfaceEventSpaceService esService;
	
	@Hibernate
	@GetMapping("selectAll.ctrl")
	public String selectAll(@ModelAttribute("deleteResult") String deleteResult, Model m) {
		
		InterfaceEventSpaceService service = esService;
		List<EventSpace> list = service.selectAll();
		m.addAttribute("eventSpaceList",list);
		
		return "35/cms/eventSpaceList";
	}
	
	@Hibernate
	@GetMapping("select.ctrl")
	public String eventSpaceSelect(@RequestParam(name="select") String name, Model m) {
		
		InterfaceEventSpaceService service = esService;
		List<EventSpace> list = service.select(name);
		
		m.addAttribute("eventSpaceList", list);
		
		return "35/cms/eventSpaceSelectResult";
	}

}
