package tw.group4._35_.routePlanning.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyJourneyService {
	
	MyJourneyDao dao;
	
	@Autowired
	public MyJourneyService(MyJourneyDao dao) {
		this.dao = dao;
	}
	
	public boolean insertMyJourney(MyJourney myJourney) {
		return dao.insertMyJourney(myJourney);
	}
	
	public List<MyJourney> getMyJourney(String memberName) {
		return dao.getMyJourney(memberName);
	}
	
	public boolean deleteJourney(String id) {
		return dao.deleteJourney(id);
	}
	
	public boolean updateJourney(MyJourney myJourney) {
		return dao.updateJourney(myJourney);
	}
}
