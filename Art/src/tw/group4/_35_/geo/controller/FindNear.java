package tw.group4._35_.geo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import tw.group4._35_.geo.model.InterfacePositionService;
import tw.group4._35_.geo.model.Position;
import tw.group4.util.Hibernate;

@Controller
public class FindNear {
	
	@Autowired
	private InterfacePositionService ptService;
	
	@Hibernate
	@RequestMapping(path = "/35/findNear.ctrl", method = RequestMethod.GET)
    public String findNear(@RequestParam(name = "userLocation") String userLocation, Model m) {
		
		List<Position> list = ptService.selectNearActs(userLocation);//傳使用者地點進去service計算和活動距離
		m.addAttribute("userLocation", userLocation);
		m.addAttribute("nearActList", list);
		return "35/geo/nearAct";
	}

}
