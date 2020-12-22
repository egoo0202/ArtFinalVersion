package tw.group4._35_.login.controller;

import java.util.List;
import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import tw.group4._35_.login.model.WebsiteMember;
import tw.group4._35_.login.model.WebsiteMemberService;
import tw.group4.util.Hibernate;

@Controller
public class MemberEntry {
	
	@Autowired
	private WebsiteMemberService service;
	
	@Hibernate
	@GetMapping("/35/memberEntry.ctrl")
	public String memberEntry(Model m){
		
		List<WebsiteMember> list = service.selectAllMembersBase64Str();
		m.addAttribute("membersList", list);
		
		return "35/login/memberManagement";
	}
	
	@Hibernate
	@GetMapping("/35/personelInfoEntry.ctrl")
	public String personelInfoEntry(Model m, HttpServletRequest request){
		
		HttpSession session = request.getSession();
		List<WebsiteMember> list = null;
		if(Objects.nonNull(session.getAttribute("member"))) {
			WebsiteMember member = (WebsiteMember)session.getAttribute("member");
			list = service.selectSingleMemberBase64Str(member.getName());
		}
		m.addAttribute("membersList", list);
		
		return "35/login/personelInfoManagement";
	}

	@Hibernate
	@GetMapping("/35/memberOutput")
	public String pdfview(Model m){
		
		List<WebsiteMember> list = service.selectAllMembers();
		m.addAttribute("memberOutput", list);
		
		return "memberOutput";
	}
}
