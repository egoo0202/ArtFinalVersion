package tw.group4._14_.back.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import tw.group4._14_.front.model.MessageBoardAP;
import tw.group4._14_.front.model.dao.MBRecordDAOService;
import tw.group4._14_.front.model.dao.MessageBoardAPService;
import tw.group4.util.Hibernate;

@Controller
public class CRUDControllerMessageBoard {

	@Autowired
	private MessageBoardAPService mbService;
	
	@Autowired
	private MBRecordDAOService mcService;
	
	//AJAX
	
	@RequestMapping(path = "/14/intoMessageCRUD.ctrl")
	public String intoMessageCRUD() {

	return "14/14_MessageBoardCRUD";
	
	}

	
	//AJAX
	@Hibernate
	@RequestMapping(path = "/14/ShowAllMessageBoardListV.ctrl")
	@ResponseBody
	public String showAllMessageBoardListV() {

		List<MessageBoardAP> list = mbService.selectAllPdBoardAPs();

		Gson gson = new Gson();

		String json = gson.toJson(list);

		return json;
	}
	@Hibernate
	@RequestMapping(path = "/14/selectMessageContent/{pdataId}.ctrl" , method = RequestMethod.POST, produces = "application/text; charset=utf-8")
	@ResponseBody
	public String sselectMessageContent(@PathVariable(name = "pdataId") int pdataId ) {

		MessageBoardAP selectMessage = mbService.selectMessage(pdataId);
		
		String content = selectMessage.getContent();

		

		return content;
	}
	
	@Hibernate
	@RequestMapping(path = "/14/ShowMessageDetile.ctrl")
	@ResponseBody
	public String ShowMessageDetile() {

		List<MessageBoardAP> list = mbService.selectAllPdBoardAPs();

		Gson gson = new Gson();

		String json = gson.toJson(list);

		return json;
	}

	@Hibernate
	@RequestMapping(path = "/14/ShowAllMessageBoardList.ctrl")
	public String showAllMessageBoardList(Model m) {
		
		List<MessageBoardAP> list = mbService.selectAllPdBoardAPs();
		
		m.addAttribute("mList", list);
		
		return "14/14_MessageBoardCRUDPage";
	}
	
	@Hibernate
	@RequestMapping(path = "/14/MessageBoardListDelet.ctrl")
	public String MessageBoardListDelet(@RequestParam(name = "mNo") int mNo) {

		mbService.deleteMessage(mNo);

		return "redirect:/14/ShowAllMessageBoardList.ctrl";
	}
	@Hibernate
	@RequestMapping(path = "/14/ShowOneMessage.ctrl")
	public String ShowOneMessage(@RequestParam(name = "mNo") int mNo) {

		mbService.selectMessage(mNo);

		return "redirect:/14/ShowAllMessageBoardList.ctrl";
	}
	
	@Hibernate
	@RequestMapping(path = "/14/sumMessage/{apid}")
	@ResponseBody
	public int sumMessage(@PathVariable(name = "apid") int apid) {

		int sumMessage = mcService.sumMessage(apid);

		return sumMessage;
	}

}
