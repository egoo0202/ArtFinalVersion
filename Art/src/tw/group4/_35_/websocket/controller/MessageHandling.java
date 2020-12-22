package tw.group4._35_.websocket.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

import tw.group4._35_.websocket.model.SendedMessage;
import tw.group4.util.Hibernate;
import tw.group4._35_.geo.model.Position;
import tw.group4._35_.geo.model.PositionService;
import tw.group4._35_.websocket.model.NearActsInfo;
import tw.group4._35_.websocket.model.OutputMessage;

@Controller
public class MessageHandling {
	
	@Autowired PositionService ptService;
	
//	@MessageMapping類似@RequestMapping
//	這邊找session跟http找session不一樣，要用simp系列，而且要手動寫方法監聽http的資訊，太麻煩故棄用
	@MessageMapping("/chat")
	@SendTo("/topic/messages")
	public OutputMessage send(Message<SendedMessage> message, SimpMessageHeaderAccessor headerAccessor) throws Exception {
		
		SendedMessage m = message.getPayload();
		String from = null;
		String sessionId = headerAccessor.getSessionId();
		if (m.getFrom().equals("")) {
			from = "訪客"+sessionId.charAt(0)+sessionId.charAt(2)+sessionId.charAt(3)+sessionId.charAt(5);
		}else {
			from = m.getFrom();
		}
		String time = new SimpleDateFormat("HH:mm:ss"+" 秒").format(new Date());
	    
		return new OutputMessage(from, m.getText(), time);
	}
	
//	@MessageMapping類似@RequestMapping
//	這邊找session跟http找session不一樣，要用simp系列，而且要手動寫方法監聽http的資訊，太麻煩故棄用
	@MessageMapping("/askRandomNearActs")
	@SendTo("/topic/randomNearActsInfo")
	@Hibernate
	public NearActsInfo ask(Message<SendedMessage> message, SimpMessageHeaderAccessor headerAccessor) throws Exception {
		
		SendedMessage m = message.getPayload();
		
		String from = null;
		String sessionId = headerAccessor.getSessionId();
		if (m.getFrom().equals("")) {
			from = "訪客"+sessionId.charAt(0)+sessionId.charAt(2)+sessionId.charAt(3)+sessionId.charAt(5);
		}else {
			from = m.getFrom();
		}
		
		String userLocation = m.getText();
		List<Position> list = ptService.recommendNearActsList(userLocation, "15");

		return new NearActsInfo(from, "，推薦您以下活動", list);
		
	}
}
