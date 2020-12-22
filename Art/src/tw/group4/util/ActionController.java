package tw.group4.util;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
//下面annotaion把"result"識別字串升級成session等級變數
@SessionAttributes(names= {"result"})
public class ActionController {
	
	@RequestMapping(path = "/action.controller", method = RequestMethod.GET)
	public String processAction(Model m) {
		m.addAttribute("result","happy day");
		return "resultPage";
	}
	
	@RequestMapping(path="/myaction.controller")
	public String processAction2(Model m) {
		m.addAttribute("result","wonderful hour");
		return "resultPage";
	}
	
	@RequestMapping(path="/element.controller")
	public String processAction3(Model m) {
		m.addAttribute("result","wonderful hour");
		return "index/ElementList";
	}
	
}
