package tw.group4._35_.cms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import tw.group4._35_.cms.model.InterfaceEventSpaceService;
import tw.group4.util.Hibernate;

@Controller
public class Delete {
	
	@Autowired
	InterfaceEventSpaceService esService;
	
	@Hibernate
	@RequestMapping(path = "/35/delete.ctrl", method = RequestMethod.GET)
	public String delete(@RequestParam(name = "name")String name, Model m) {
		
		InterfaceEventSpaceService service = esService;
		
		if(service.delete(name)) {
			m.addAttribute("deleteResult", name+"刪除成功");
		}else {
			m.addAttribute("deleteResult", "刪除失敗");
		}
		
		return "redirect:/35/selectAll.ctrl";
	}
}
