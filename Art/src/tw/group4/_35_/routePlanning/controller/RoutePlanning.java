package tw.group4._35_.routePlanning.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tw.group4._35_.geo.model.Position;
import tw.group4._35_.geo.model.PositionService;
import tw.group4._35_.login.model.WebsiteMember;
import tw.group4._35_.routePlanning.model.MyJourney;
import tw.group4._35_.routePlanning.model.MyJourneyService;
import tw.group4.util.Hibernate;

@RestController
public class RoutePlanning {

	@Autowired
	PositionService service;
	
	@Autowired
	MyJourneyService mjService;
	
//	刪除我規劃的行程資料
	@Hibernate
	@DeleteMapping(value = "/35/myJourney/{id}")
	public Map<String, String> deleteMyJourney(@PathVariable String id) {

		boolean result = mjService.deleteJourney(id);
		
		HashMap<String, String> map = new HashMap<String, String>();
		if (result==true) {
			map.put("result", "successful");
		}else {
			map.put("result", "failed");
		}
		
		return map;
	}
	
//	更新我規劃的行程資料
	@Hibernate
	@PutMapping(value = "/35/myJourney")
	public Map<String, String> updateMyJourney(@RequestBody MyJourney myJourney, HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		if(Objects.nonNull(session.getAttribute("member"))) {			
			WebsiteMember member = (WebsiteMember)session.getAttribute("member");
			myJourney.setMemberName(member.getName());
		}
		boolean result = mjService.updateJourney(myJourney);
		
		HashMap<String, String> map = new HashMap<String, String>();
		if (result==true) {
			map.put("result", "successful");
		}else {
			map.put("result", "failed");
		}
		
		return map;
	}
	
//	新增我規劃的行程資料
	@Hibernate
	@PostMapping(value = "/35/myJourney")
	public Map<String, String> postMyJourney(@RequestBody MyJourney myJourney, HttpServletRequest request) {
		
		HashMap<String, String> map = new HashMap<String, String>();
		HttpSession session = request.getSession();
		if(Objects.nonNull(session.getAttribute("member"))) {			
			WebsiteMember member = (WebsiteMember)session.getAttribute("member");
			myJourney.setMemberName(member.getName());
		}
		boolean result = mjService.insertMyJourney(myJourney);
		
		if (result == true) {
			map.put("result", "successful");
		}else {
			map.put("result", "failed");
		}
		
		return map;
	}
	
//	查詢我規劃的所有行程資料
	@Hibernate
	@GetMapping(value = "/35/myJourney")
	public List<MyJourney> getMyJourney(HttpServletRequest request) {
		
		List<MyJourney> list = null;
		HttpSession session = request.getSession();
		if(Objects.nonNull(session.getAttribute("member"))) {			
			WebsiteMember member = (WebsiteMember)session.getAttribute("member");
			list = mjService.getMyJourney(member.getName());
		}

		return list;
	}
	
//	查詢特定/不特定的活動資料
	@Hibernate
	@GetMapping(value = "/35/routePlanning/{userLocation}/{userDistance}/{actCategory}" + ".ctrl")
	public Map<String, Object> routePlanningGetAll(@PathVariable String userLocation, @PathVariable String userDistance,
			@PathVariable String actCategory) {

        Integer category;
		switch (actCategory) {
		case "所有":
			category = 0;
			break;
		case "音樂":
			category = 1;
			break;
		case "戲劇":
			category = 2;
			break;
		case "舞蹈":
			category = 3;
			break;
		case "親子":
			category = 4;
			break;
		case "獨立音樂":
			category = 5;
			break;
		case "展覽":
			category = 6;
			break;
		case "講座":
			category = 7;
			break;
		case "電影":
			category = 8;
			break;
		case "綜藝":
			category = 11;
			break;
		case "競賽":
			category = 13;
			break;
		case "徵選":
			category = 14;
			break;
		case "其他":
			category = 15;
			break;
		case "未知分類":
			category = 16;
			break;
		case "演唱會":
			category = 17;
			break;
		case "研習課程":
			category = 19;
			break;
		default:
			category = 0;
			break;
		}
		
		Map<String, Double> userCoords = service.getUserCoords(userLocation);
		List<Position> list;
		if(!category.equals(0)) {		
			list = service.selectNearActsByDistanceAndCategory(userLocation, userDistance, category);
		}else {
			list = service.selectNearActsByDistance(userLocation, userDistance);
		}

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userCoords", userCoords);
		map.put("nearActs", list);

		return map;
	}
}
