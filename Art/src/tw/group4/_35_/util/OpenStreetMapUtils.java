package tw.group4._35_.util;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
//import org.apache.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;

public class OpenStreetMapUtils {

    public final static Logger log = LogManager.getLogger("OpenStreeMapUtils");
//    public final static Logger log = Logger.getLogger("OpenStreeMapUtils");

    private static OpenStreetMapUtils instance = null;

	@SuppressWarnings("unused")
	private JSONParser jsonParser;

    public OpenStreetMapUtils() {
        jsonParser = new JSONParser();
    }

    public static OpenStreetMapUtils getInstance() {
        if (instance == null) {
            instance = new OpenStreetMapUtils();
        }
        return instance;
    }

    private String getRequest(String url) throws Exception {

        final URL obj = new URL(url);
        final HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("POST");
//        con.setRequestMethod("GET");

        if (con.getResponseCode() != 200) { //Status Code200代表ok，其餘代表錯誤可能要用其他方法拿
            return null;
        }

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();      

        return response.toString();
    }

    public Map<String, Double> getCoordinates(String address) {
        Map<String, Double> res;
        StringBuffer query;
        String[] split = address.split(" ");
        String queryResult = null;

        query = new StringBuffer();
        res = new HashMap<String, Double>();

        query.append("https://nominatim.openstreetmap.org/search?q=");//api接口，會有變更可能
//        query.append("https://nominatim.openstreetmap.org/search/");//api接口，會有變更可能
//        query.append("https://nominatim.openstreetmap.org/ui/search.html?q=");//api接口，會有變更可能

        if (split.length == 0) {
            return null;
        }

        for (int i = 0; i < split.length; i++) {
            query.append(split[i]);
            if (i < (split.length - 1)) {
                query.append("+");
            }
        }
        query.append("&format=json&addressdetails=1");
//        query.append("?&format=json&addressdetails=1");

        log.debug("Query:" + query);

        try {
            queryResult = getRequest(query.toString());
        } catch (Exception e) {
            log.error("Error when trying to get data with the following query " + query);
        }

        if (queryResult == null) {
            return null;
        }

        Object obj = JSONValue.parse(queryResult); //這邊開始使用json simple api
        //把原本字串型態的queryResult強制轉型為JSONValue
        //開Object型態的obj變數放置
        log.debug("obj=" + obj);

        if (obj instanceof JSONArray) {
            JSONArray array = (JSONArray) obj;
            if (array.size() > 0) {
                JSONObject jsonObject = (JSONObject) array.get(0);

                String lon = (String) jsonObject.get("lon");
                String lat = (String) jsonObject.get("lat");
                log.debug("lat=" + lat);
                log.debug("lon=" + lon);
                res.put("lon", Double.parseDouble(lon));
                res.put("lat", Double.parseDouble(lat));

            }
        }

        return res;
    }
}

//參考資料:http://julien.gunnm.org/geek/programming/2015/09/13/how-to-get-geocoding-information-in-java-without-google-maps-api/
