package tw.group4._04_.back.cmsAct.controller;

import java.text.ParseException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import tw.group4._04_.back.cmsAct.model.ShowBean;

@Controller
public class JSPDirectCMS {
	@RequestMapping(path = "/04/index_back", method = RequestMethod.GET)
	public String processShowDetail( ) {
		
		return "04/cms_Act/index_back";
	}
}
