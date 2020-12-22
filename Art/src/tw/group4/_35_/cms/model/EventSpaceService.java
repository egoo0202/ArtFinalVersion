package tw.group4._35_.cms.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventSpaceService implements InterfaceEventSpaceService {
	
	private InterfaceEventSpaceDao dao;
	
	@Autowired
	public EventSpaceService(InterfaceEventSpaceDao dao) {		
		this.dao = dao;
	}
	
	@Override
	public List<EventSpace> select(String name) {
		return dao.select(name);
	}
	
	@Override
	public List<EventSpace> selectAll() {
		return dao.selectAll();
	}
	
	@Override
	public EventSpace insert(EventSpace bean) {
		return dao.insert(bean);
	}

	@Override
	public boolean update(EventSpace bean) {
		return dao.update(bean);
	}

	@Override
	public boolean delete(String name) {
		return dao.delete(name);
	}

}
