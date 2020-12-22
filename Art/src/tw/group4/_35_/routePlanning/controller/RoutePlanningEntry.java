package tw.group4._35_.routePlanning.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import tw.group4._14_.dashboard.dao.DashboardService;
import tw.group4._14_.dashboard.model.EntryClickRate;
import tw.group4.util.Hibernate;
import tw.group4.util.NeedLogin;

@Controller
public class RoutePlanningEntry {
	
	@Autowired
	private DashboardService dbService;

	@Hibernate
	@GetMapping(value = "/35/routePlanningEntry")
	public String routePlanningEntry() {
		EntryClickRate ecr = new EntryClickRate();
		ecr.setMap(1);
		dbService.insert(ecr);
		return "35/routePlanning/allRoutes";
	}
	
	@NeedLogin
	@GetMapping(value = "/35/myJourneyEntry")
	public String myJourneyEntry() {
		
		return "35/routePlanning/myJourney";
	}

}
