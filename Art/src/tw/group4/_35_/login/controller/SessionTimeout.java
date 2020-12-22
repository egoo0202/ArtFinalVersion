package tw.group4._35_.login.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SessionTimeout {
	
	@GetMapping("/35/sessionTimeout")
	public String sessionTimeout(){
		
		return "35/login/sessionTimeout";
	}
}
