package tw.group4._35_.csr.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

//import org.apache.log4j.BasicConfigurator;
import org.springframework.stereotype.Service;

import net.sf.geographiclib.Geodesic;
import net.sf.geographiclib.GeodesicLine;
import net.sf.geographiclib.GeodesicMask;
import tw.group4._35_.util.OpenStreetMapUtils;

@Service
public class FoundingService {
	
	public double latTPE = 25.105497;
	public double lonTPE = 121.597366;
	public double latKSH =	22.633333;
	public double lonKSH =	120.266670;
	public double latTC = 24.147736;
	public double lonTC = 120.673645;
	public double latTN =	22.999727;
	public double lonTN =	120.227028;
	public double latTY =	24.99368;
	public double lonTY =	121.29696;
	public Geodesic geod = Geodesic.WGS84;
	
	public Double getDistance(Double lat1, Double lon1, Double lat2, Double lon2) {
		GeodesicLine line = geod.InverseLine(lat1, lon1, lat2, lon2, GeodesicMask.DISTANCE_IN | GeodesicMask.LATITUDE | GeodesicMask.LONGITUDE);
		Double d = line.Distance()/1000; //最後除一千是為了把公尺單位轉換成公里
		return (double) (Math.round(d*100)/100); //去除多餘小數點
	}
	
	public int evaluateHowFar (String kidsLocation) {
		Map<String, Double> coords;
//		BasicConfigurator.configure();
//		OpenStreetMapUtils.log.info("This is Logger Info");
//		上面兩行初始化log4j設定，這個東西拿來記錄get到的地理資訊，沒初始化會出現以下錯誤
		//WARN No appenders could be found for logger
		coords = OpenStreetMapUtils.getInstance().getCoordinates(kidsLocation);
		Double kidsLat = coords.get("lat");
        Double kidsLon = coords.get("lon");
        
        List<Double> list = calFiveCityDistance(kidsLat, kidsLon);
        int score = 0;
        for (Double distance:list) {
        	if (distance < 25) {
        		score=0;
        		break;
        	}else if (distance < 50) {
        		score+=1;
        	}else if (distance < 100) {
        		score+=3;
        	}else if (distance < 150) {
        		score+=6;
        	}else if (distance < 200) {
        		score+=9;
        	}else {
        		score+=12;
        	}
        }
        
        return score;
	}
	
	public List<Double> calFiveCityDistance(Double kidsLat, Double kidsLon) {
		 Double distanceTPE = getDistance(latTPE, lonTPE, kidsLat, kidsLon);
	     Double distanceKSH = getDistance(latKSH, lonKSH, kidsLat, kidsLon);
	     Double distanceTC = getDistance(latTC, lonTC, kidsLat, kidsLon);
	     Double distanceTN = getDistance(latTN, lonTN, kidsLat, kidsLon);
	     Double distanceTY = getDistance(latTY, lonTY, kidsLat, kidsLon);
	     List<Double> list = new ArrayList<Double>();
	     list.add(distanceTPE);
	     list.add(distanceKSH);
	     list.add(distanceTC);
	     list.add(distanceTN);
	     list.add(distanceTY);
	     
	     return list;
	}
	
	public int getKidAmount(String kidsLocation) {
		int score = evaluateHowFar(kidsLocation);
		int r = 0;
		if (score<50) {
			r = (int)(Math.random()*(5-1+1))+1;
		}else if (score<100) {
			r = (int)(Math.random()*(25-11+1))+11;
		}else {
			r = (int)(Math.random()*(50-25+1))+25;
		}
		int amount = score * r;
		return amount;
	}
	
}
