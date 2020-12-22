package tw.group4._35_.websocket.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ChatEntry {
	
	@GetMapping("/35/chatRoomEntry")
	public String chatRoomEntry() {
		return "35/websocket/chatRoom";
	}
	
	@GetMapping("/35/chatCenterEntry")
	public String chatCenterEntry() {
		return "35/websocket/chatCenter";
	}

}
