package tw.group4._35_.login.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ForgotPwd {
	
	@GetMapping("/35/forgotPwd")
	public String forgotPwd() {
		return "35/login/forgotPwd";
	}
	
	@GetMapping("/35/resetPwd")
	public String resetPwd() {
		return "35/login/goCheckNewPwd";
	}

}
