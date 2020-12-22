package tw.group4._35_.csr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import tw.group4._35_.csr.model.FoundingService;
import tw.group4.util.Hibernate;

@Controller
public class Founding {
	
	@Autowired
	FoundingService fdService;
	
	@Hibernate
	@RequestMapping(path = "/35/founding.ctrl", method = RequestMethod.GET)
	public String founding(@RequestParam(name = "kidsLocation") String kidsLocation, Model m) {
		
		int kidsAmount = fdService.getKidAmount(kidsLocation);
		m.addAttribute("kidsAmount", kidsAmount);
		m.addAttribute("kidsLocation", kidsLocation);
		return "35/geo/showKids";
	}

}
