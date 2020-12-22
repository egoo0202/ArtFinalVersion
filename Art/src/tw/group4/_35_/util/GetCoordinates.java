package tw.group4._35_.util;
import java.util.Map;

//import org.apache.log4j.BasicConfigurator;

public class GetCoordinates {
    static String address = "潮州";

    public static void main(String[] args) {
//		BasicConfigurator.configure();
//		OpenStreetMapUtils.log.info("This is Logger Info");
//		上面兩行初始化log4j設定，這個東西拿來記錄get到的地理資訊，沒初始化會出現以下錯誤
//		log4j:WARN No appenders could be found for logger (OpenStreeMapUtils).
//		log4j:WARN Please initialize the log4j system properly.
//		log4j:WARN See http://logging.apache.org/log4j/1.2/faq.html#noconfig for more info.
    	
        Map<String, Double> coords;
        coords = OpenStreetMapUtils.getInstance().getCoordinates(address);

        System.out.println("latitude :" + coords.get("lat"));
        System.out.println("longitude:" + coords.get("lon"));
    }
}
