package tw.group4._35_.geo.model;

import java.util.List;
import java.util.Map;

public interface InterfacePositionService {

	List<Position> getPositionBean();

	List<Position> getNoNullPositionBean();
	
	Map<String, Double> getUserCoords(String userLocation);

	Double getDistance(Double lat1, Double lon1, Double lat2, Double lon2);

	List<Position> setDistance(String userLocation, List<Position> list);
	
	List<Position> selectNearActs(String userLocation);
	
	List<Position> selectNearActsByDistance(String userLocation, String userDistance);

	List<Position> recommendList();
	
	List<Position> recommendNearActsList(String userLocation, String userDistance);

	int[] produceRandomArray(int count);
	
	List<Position> selectByCategory(Integer Category);
	
	public List<Position> selectNearActsByDistanceAndCategory(String userLocation, String userDistance, Integer Category);

}