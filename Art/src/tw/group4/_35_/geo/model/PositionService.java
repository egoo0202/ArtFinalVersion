package tw.group4._35_.geo.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Random;

//import org.apache.log4j.BasicConfigurator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.sf.geographiclib.*;
//import from Geolib，除了數學公式外，還考慮到地球弧度實際變化來計算經緯度間的距離
import tw.group4._35_.util.OpenStreetMapUtils;

@Service
public class PositionService implements InterfacePositionService {

	private InterfacePositionDao dao;

	public Geodesic geod = Geodesic.WGS84;

	@Autowired
	public PositionService(InterfacePositionDao dao) {
		this.dao = dao;
	}

	@Override
	public List<Position> getPositionBean() {
		return dao.readAllToPt();
	}

	@Override
	public List<Position> getNoNullPositionBean() {
		return dao.readNoNullToPt();
	}

	@Override
	public Map<String, Double> getUserCoords(String userLocation) {
		Map<String, Double> coords;
		coords = OpenStreetMapUtils.getInstance().getCoordinates(userLocation);
		return coords;
	}

	@Override
	public Double getDistance(Double lat1, Double lon1, Double lat2, Double lon2) {
		GeodesicLine line = geod.InverseLine(lat1, lon1, lat2, lon2,
				GeodesicMask.DISTANCE_IN | GeodesicMask.LATITUDE | GeodesicMask.LONGITUDE);
		Double d = line.Distance() / 1000; // 最後除一千是為了把公尺單位轉換成公里
		return (double) (Math.round(d * 100) / 100); // 去除多餘小數點
	}

	@Override
	public List<Position> setDistance(String userLocation, List<Position> list) {

//			BasicConfigurator.configure();
//			OpenStreetMapUtils.log.info("This is Logger Info");
//			上面兩行初始化log4j設定，這個東西拿來記錄get到的地理資訊，沒初始化會出現以下錯誤
		// WARN No appenders could be found for logger
		Map<String, Double> coords = getUserCoords(userLocation);
		Double userLat = coords.get("lat");
		Double userLon = coords.get("lon");

		Double distance = 0.0;
		for (Position itemPt : list) {
			if (itemPt.getLatitude().equals(0.0)) {
				itemPt.setDistance(0.0);
			} else {
				distance = this.getDistance(itemPt.getLatitude(), itemPt.getLongitude(), userLat, userLon);
				itemPt.setDistance(distance);
			}
		}

		return list;
	}

	@Override
	public List<Position> selectNearActs(String userLocation) {
		List<Position> listAll = getPositionBean();
		List<Position> list = setDistance(userLocation, listAll);
		List<Position> cleanList = new ArrayList<Position>();
		for (Position item : list) {
			if (item.getDistance().equals(0.0)) {

			} else {
				cleanList.add(item);
			}
		}
		// 在bean中覆寫了Comparable介面的排序方法
		// 設定依照物件中的距離屬性排序
		Collections.sort(cleanList);

		return cleanList;
	}

	@Override
	public List<Position> selectNearActsByDistance(String userLocation, String userDistance) {
		List<Position> listAll = getPositionBean();
		List<Position> list = setDistance(userLocation, listAll);
		List<Position> listByDistance = new ArrayList<Position>();
		Double d = Double.valueOf(userDistance);

		for (Position item : list) {
			int result = Double.compare(item.getDistance(), d);
			if (!item.getDistance().equals(0.0) && result < 0) {
				listByDistance.add(item);
			}
		}
		if (listByDistance.size() == 0) {
			listByDistance.add(new Position());
		}

		// 作為地圖呈現不用排序
		// 在bean中覆寫了Comparable介面的排序方法
		// 設定依照物件中的距離屬性排序
		// Collections.sort(cleanList);

		return listByDistance;
	}

	@Override
	public List<Position> recommendList() {
		// 數表格總數
		List<Position> list = getNoNullPositionBean();
		int count = 0;
		for (Position itemCount : list) {
			count++;
		}

		// 取亂數後的隨機三個
		int[] arr = produceRandomArray(count);
		List<Position> noNullList = getNoNullPositionBean();
		List<Position> recommendList = new ArrayList<Position>();
		for (int i = 0; i < 3; i++) {
			int timesCount = 0;
			for (Position item : noNullList) {
				timesCount++;
				if (timesCount == arr[i]) {
					Position pt = new Position();
					pt.setNo(item.getNo());
					pt.setCity(item.getCity());
					pt.setDistrict(item.getDistrict());
					pt.setVillage(item.getVillage());
					pt.setAddress(item.getAddress());
					pt.setTitle(item.getTitle());
					pt.setCategory(item.getCategory());
					pt.setLocationName(item.getLocationName());
					pt.setPrice(item.getPrice());
					pt.setTime(item.getTime());
					pt.setMainUnit(item.getMainUnit());
					pt.setShowUnit(item.getShowUnit());
					recommendList.add(pt);
					break;
				} else {
					continue;
				}
			}
		}

		return recommendList;
	}
	
	@Override
	public List<Position> recommendNearActsList(String userLocation, String userDistance) {
		// 數附近幾公里活動總數
		List<Position> list = selectNearActsByDistance(userLocation, userDistance);
		int count = 0;
		for (Position itemCount : list) {
			count++;
		}
		
		// 取亂數後的隨機三個
		int[] arr = produceRandomArray(count);
		List<Position> noNullList = selectNearActsByDistance(userLocation, userDistance);
		List<Position> recommendList = new ArrayList<Position>();
		for (int i = 0; i < 3; i++) {
			int timesCount = 0;
			for (Position item : noNullList) {
				timesCount++;
				if (timesCount == arr[i]) {
					Position pt = new Position();
					pt.setNo(item.getNo());
					pt.setCity(item.getCity());
					pt.setDistrict(item.getDistrict());
					pt.setVillage(item.getVillage());
					pt.setAddress(item.getAddress());
					pt.setTitle(item.getTitle());
					pt.setCategory(item.getCategory());
					pt.setLocationName(item.getLocationName());
					pt.setPrice(item.getPrice());
					pt.setTime(item.getTime());
					pt.setMainUnit(item.getMainUnit());
					pt.setShowUnit(item.getShowUnit());
					recommendList.add(pt);
					break;
				} else {
					continue;
				}
			}
		}
		
		return recommendList;
	}

	@Override
	public int[] produceRandomArray(int count) {

		Random rd = new Random(); // creating Random object
		int[] arr = new int[3];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = rd.nextInt(count) + 1; // storing random integers in an array
			for (int j = 0; j < i; j++) {
				while (arr[j] == arr[i]) {
					j = 0;
					arr[i] = rd.nextInt(count) + 1;
				}
			}
//				System.out.println(arr[i]); // printing each array element
		}
		return arr;
	}

	@Override
	public List<Position> selectByCategory(Integer Category) {
		return dao.selectByCategory(Category);
	}

	@Override
	public List<Position> selectNearActsByDistanceAndCategory(String userLocation, String userDistance,
			Integer Category) {
		List<Position> listCategory = selectByCategory(Category);
		List<Position> list = setDistance(userLocation, listCategory);
		List<Position> listByDistance = new ArrayList<Position>();
		Double d = Double.valueOf(userDistance);
		
//		依據使用者撰寫距離篩選活動以及篩選非零活動
		for (Position item : list) {
			int result = Double.compare(item.getDistance(), d);
			if (!item.getDistance().equals(0.0) && result < 0) {
				listByDistance.add(item);
			}
		}
		if (listByDistance.size() == 0) {
			listByDistance.add(new Position());
		}

		// 作為地圖呈現不用排序
		// 在bean中覆寫了Comparable介面的排序方法
		// 設定依照物件中的距離屬性排序
		// Collections.sort(cleanList);

		return listByDistance;
	}

}