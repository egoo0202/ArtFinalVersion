package tw.group4._35_.cms.model;

import java.util.List;

public interface InterfaceEventSpaceService {

	List<EventSpace> select(String name);

	List<EventSpace> selectAll();

	EventSpace insert(EventSpace bean);

	boolean update(EventSpace bean);

	boolean delete(String name);

}