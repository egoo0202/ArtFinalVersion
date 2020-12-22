package tw.group4._35_.init.dao;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.sql.Blob;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.sql.rowset.serial.SerialBlob;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import tw.group4._35_.cms.model.EventSpace;
import tw.group4._35_.geo.model.Activity;
import tw.group4._35_.geo.model.Position;
import tw.group4._35_.login.model.WebsiteMember;
import tw.group4._35_.util.GlobalService;
import tw.group4.util.HibernateUtilNoWeb;

public class DataForDB {
	
	//讀取網路上的json檔為Activity型態
	public List<Activity> readJsonToAct() {
		
		List<Activity> list = new ArrayList<Activity>();
//		try (InputStream fis = new URL("https://cloud.culture.tw/frontsite/trans/SearchShowAction.do?method=doFindTypeJ&category=all").openStream();
		try (FileInputStream fis = new FileInputStream("IOFiles/inputJSON/1.json");
				InputStreamReader isr = new InputStreamReader(fis, "UTF8");
				BufferedReader br = new BufferedReader(isr);	
				) {
			int c;
			StringBuilder strBuilder = new StringBuilder();
			while ((c = br.read())!=-1) {
				char d =(char)c;
				strBuilder.append(String.valueOf(d));
			}
			
			String tableStr= String.valueOf(strBuilder);
			
			Gson gson = new Gson();
			Type listType = new TypeToken<List<Activity>>() {}.getType();
			List<Activity> jsonArr = gson.fromJson(tableStr,listType);

			for (Activity item: jsonArr) {
				Activity act = new Activity();
				
				act.setUqid(item.getUqid());
				act.setTitle(item.getTitle());
				act.setCategory(item.getCategory());
				Map hashMap1= new HashMap();
				for (int i=0 ; i < item.getShowInfo().size(); i++) {
					hashMap1 = item.getShowInfo().get(i);										
				}
				act.setLocation(String.valueOf(hashMap1.get("location")));
				act.setLocationName(String.valueOf(hashMap1.get("locationName")));
				act.setOnSales(String.valueOf(hashMap1.get("onSales")));
				act.setPrice(String.valueOf(hashMap1.get("price")));
				act.setTime(String.valueOf(hashMap1.get("time")));
				act.setEndTime(String.valueOf(hashMap1.get("endTime")));
				String str1= "";
				for (int i=0 ; i < item.getMasterUnit().size(); i++) {
					str1 = item.getMasterUnit().get(i);										
				}
				act.setMainUnit(str1);
				act.setShowUnit(item.getShowUnit());
				act.setImage(item.getImage());								
				act.setStartDate(item.getStartDate());
				act.setEndDate(item.getEndDate());
				list.add(act);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("已讀取文化部json檔為Activity");
		return list;
	}
	
	//Activity物件塞進資料庫
	public void actWriteDB() {
		
		List<Activity> list = readJsonToAct();
		
		SessionFactory factory = HibernateUtilNoWeb.getSessionFactory();
		Session session = factory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		System.out.println("Transaction Begin.");
		
		int counter = 0;
		try {
			for (Activity item: list) {
				
				session.save(item);
				counter++;
				
				if(counter%50==0) {
					session.flush();
					session.clear();
				}
			}	
			tx.commit();
			System.out.println("Transaction Commit.");
		} catch (Exception e) {
			tx.rollback();
			System.out.println("Transaction Rollback.");
			e.printStackTrace();
		}finally {
			System.out.println("Session Closed.");
		}
		
//		HibernateUtilNoWeb.closeSessionFactory();

		System.out.println(counter+"筆資料已寫入Activity表格");
		
	}
	
	//取得所有Activity的資料
	public List<Activity> readDBToAct() {
		
		SessionFactory factory = HibernateUtilNoWeb.getSessionFactory();
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		
		Query<Activity> query = session.createQuery("From Activity", Activity.class);
		List<Activity> list = query.list();
		
		session.close();
			
		System.out.println("已讀取Activity表格為Activity物件");
		return list;
	}
	
	//寫入資料到Position表格
	//除了寫入從csv檔轉來的Position物件
	//同時間還要寫入Activity的uqid所以傳入Activity物件取值
	public void ptActWriteDB() {
		
		List<Position> listPt = readCSVtoPt();
		List<Activity> listAct = readDBToAct();
			
		for (Activity item: listAct) {

			//System.out.println(listPt.get(i).getNo()+": "+listPt.get(i).getTitle());
			//遍歷找尋Activity內符合Position物件NO的ID，然後再給Position物件uqid的值
			for (int i=0; i<listPt.size();i++) {
				if (listPt.get(i).getNo().equals(item.getId())) {
					listPt.get(i).setUqid(item.getUqid());
					listPt.get(i).setTitle(item.getTitle());
					listPt.get(i).setCategory(item.getCategory());
					listPt.get(i).setLocationName(item.getLocationName());
					listPt.get(i).setPrice(item.getPrice());
					listPt.get(i).setTime(item.getTime());
					listPt.get(i).setMainUnit(item.getMainUnit());
					listPt.get(i).setShowUnit(item.getShowUnit());
					break;
				}else {
					continue;
				}
			}
		}
		
		SessionFactory factory = HibernateUtilNoWeb.getSessionFactory();
		Session session = factory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		System.out.println("Transaction Begin.");
		
		int counter = 0;
		try {
			for (Position item: listPt) {
				
				session.save(item);
				counter++;
				
				if(counter%50==0) {
					session.flush();
					session.clear();
				}
			}	
			tx.commit();
			System.out.println("Transaction Commit.");
		} catch (Exception e) {
			tx.rollback();
			System.out.println("Transaction Rollback.");
			e.printStackTrace();
		}finally {
			System.out.println("Session Closed.");
		}
		
//		HibernateUtilNoWeb.closeSessionFactory();

		System.out.println(counter+"筆資料已寫入Position表格");
	}
	
	//Activity表格轉字串，為了輸出要上傳內政部做經緯度表格的csv檔
	public String actToString() {
		
		List<Activity> list = this.readDBToAct();
		
		StringBuilder sb = new StringBuilder();
		sb.append("ID(非必填),縣市(必填),鄉鎮(必填),村里(可不填),鄰(可不填),地址(必填)\n");
		String addressStr="";
		for(Activity item: list) {
			addressStr = item.getLocation();
			if (addressStr!=null) {
				if (addressStr.contains(",")){
					addressStr  = item.getLocation().replace(",", "、");
				}
				if (addressStr.regionMatches(0, "202", 0, 3)){
					sb.append(item.getId()+","+addressStr.substring(4,7)+","+addressStr.substring(7,10)+","+","+","+addressStr.substring(10)+"\n");
				}else if (addressStr.regionMatches(0, "74彰", 0, 3)) {
					sb.append(item.getId()+","+addressStr.substring(2,5)+","+addressStr.substring(5,8)+","+","+","+addressStr.substring(8)+"\n");
				}else if (addressStr.charAt(0) >= 48 && addressStr.charAt(0) <= 57 && addressStr.indexOf("區") == 9 && addressStr.length() > 10) {
					sb.append(item.getId()+","+addressStr.substring(5,8)+","+addressStr.substring(8,10)+","+","+","+addressStr.substring(10)+"\n");
				}else if (addressStr.charAt(0) >= 48 && addressStr.charAt(0) <= 57 && addressStr.length() > 11) {
					sb.append(item.getId()+","+addressStr.substring(5,8)+","+addressStr.substring(8,11)+","+","+","+addressStr.substring(11)+"\n");
				}else if (addressStr.length() > 6 && addressStr.indexOf("區") == 4){
					sb.append(item.getId()+","+addressStr.substring(0,3)+","+addressStr.substring(3,5)+","+","+","+addressStr.substring(5)+"\n");
				}else if (addressStr.length() > 6){
					sb.append(item.getId()+","+addressStr.substring(0,3)+","+addressStr.substring(3,6)+","+","+","+addressStr.substring(6)+"\n");
				}else if (addressStr.length() > 5){
					sb.append(item.getId()+","+addressStr.substring(0,3)+","+addressStr.substring(3,6)+","+","+","+"\n");
				}else if (addressStr.length() > 4){
					sb.append(item.getId()+","+addressStr.substring(0,3)+","+addressStr.substring(3,5)+","+","+","+"\n");
				}else {
					sb.append(item.getId()+","+","+","+","+","+"\n");
				}
			}else {
				sb.append(item.getId()+","+","+","+","+","+"\n");
			}
			
		}
		String str = String.valueOf(sb);
		System.out.println("Activity物件已轉換為字串物件");
		return str;
		
	}
	
	//Activity物件轉字串後寫入要上傳內政部做經緯度表格的csv檔
	public void stringWriteCSV() {

//		FileOutputStream某參數設定true，資料會從覆蓋寫入變成插入
		try( FileOutputStream fos = new FileOutputStream("IOFiles/outputCSV/1.csv");
				OutputStreamWriter osw = new OutputStreamWriter(fos, "BIG5");
				BufferedWriter bw = new BufferedWriter(osw);
				){
			
			String string = actToString();
			bw.write(string);
			
		} catch (FileNotFoundException e) { //file not found時的exception			
			e.printStackTrace();
		} catch (IOException e) { //close時會丟出的exception
			e.printStackTrace();
		}
		System.out.println("字串物件已寫入至1.csv檔");

	}
	
	//讀取內政部轉換下來的csv檔，轉成List<PositionBean>資料型態
	public List<Position> readCSVtoPt() {

		List<Position> list = new ArrayList<Position>();
//		FileOutputStream某參數設定true，資料會從覆蓋寫入變成插入
		try( FileInputStream fis = new FileInputStream("IOFiles/inputCSV/2.csv");
				InputStreamReader isr = new InputStreamReader(fis, "BIG5");
				BufferedReader br = new BufferedReader(isr);
				){
			
			StringBuilder sb = new StringBuilder();
			int c; //BufferedReader.read()回傳的是int型態，先建變數接
			while ((c=br.read())!=-1) {	
				char d=(char)c;  //ASCII型態的數字轉成位元代碼
				sb.append(String.valueOf(d)); //位元代碼轉人類看的字串
			}
			
			String str =String.valueOf(sb);
			String[] strArr = str.split("[,\n\r]");
//			for (String item: strArr) {
//				System.out.println(item);
//			}
			
//			for (int i=13; i<strArr.length; i+=13) { //Win
			for (int i=12; i<strArr.length; i+=12) { //Mac
				Position pt = new Position();
				if(strArr[i+8].equals("門牌比對失敗或格式有誤")) {
					pt.setNo(Integer.valueOf(strArr[i]));
					pt.setCity(null);
					pt.setDistrict(null);
					pt.setVillage(null);
					pt.setAddress(null);
					pt.setLatitude(0.0);
					pt.setLongitude(0.0);	
				}else {
					pt.setNo(Integer.valueOf(strArr[i]));
					pt.setCity(strArr[i+1]);
					pt.setDistrict(strArr[i+2]);
					pt.setVillage(strArr[i+3]);
					pt.setAddress(strArr[i+4]);
					pt.setLatitude(Double.valueOf(strArr[i+10]));
					pt.setLongitude(Double.valueOf(strArr[i+9]));	
				}
				list.add(pt);
			}
			
		} catch (FileNotFoundException e) { //file not found時的exception			
			e.printStackTrace();
		} catch (IOException e) { //close時會丟出的exception
			e.printStackTrace();
		}
		System.out.println("已讀取滿滿經緯度資訊的2.csv檔為Position物件");
		return list;
		
	}
	
//	塞入場地資訊
	public void esWriteDB() {
		
		List<EventSpace> list = new ArrayList<EventSpace>();
		EventSpace es1 = new EventSpace("捷運音樂廳", "台北捷運", "中山北路長安西路口", "演奏廳", "中山雙連商圈", "捷運中山站", 350.0, 10000.0, 100.0, null, "誠品週年慶", "北捷公司活動小組");
		EventSpace es2 = new EventSpace("自由廣場", "文化部", "中山南路", "開放廣場", "古亭小南門商圈", "捷運中正紀念堂站", 3500.0, 1000.0, 1500.0, null, "抗議活動", "文化部兩廳院");
		EventSpace es3 = new EventSpace("西門紅樓", "台北市政府", "西寧南路", "小型活動場所", "西門町商圈", "捷運西門站", 250.0, 15000.0, 70.0, null, "西街少年", "紅樓文創公司");
		EventSpace es4 = new EventSpace("海邊的卡夫卡", "台北市政府", "羅斯福路", "小型活動場所", "公館商圈", "捷運公館站", 350.0, 18000.0, 90.0, null, "台大校慶", "卡夫卡有限公司");
		EventSpace es5 = new EventSpace("華山Legacy", "台北市政府", "北平東路", "中型活動場所", "忠孝新生商圈", "捷運忠孝新生站", 550.0, 21000.0, 95.0, null, "三創電玩展", "華山藝文小隊");
		EventSpace es6 = new EventSpace("汐止區公所前廣場", "汐止區公所", "新台五路", "開放廣場", "汐止車站商圈", "汐止火車站", 700.0, 0.0, 150.0, null, "汐止夜市農產品特展", "汐止區公所");
		EventSpace es7 = new EventSpace("天秀宮廣場", "汐止天秀宮", "勤進路", "開放廣場", "蟲鳴鳥叫", "汐止區公所巴士", 1250.0, 100.0, 110.0, null, "汐止大尖山賞花趣", "天秀宮");
		EventSpace es8 = new EventSpace("新北市政府竹筍廣場", "新北市政府", "縣民大道", "開放廣場", "板橋車站商圈", "捷運板橋站，板橋火車站", 30000.0, 9000.0, 250.0, null, "遠百週年慶", "新北市政府文化局");
		EventSpace es9 = new EventSpace("中央大學學生活動中心", "中央大學", "中央路", "室內活動場域", "中央學生葷街", "中央大學公車站", 1500.0, 600.0, 75.0, null, "中央大學校慶", "中央大學課外活動組");
		EventSpace es10 = new EventSpace("府中15", "新北市政府", "縣民大道", "影像展覽館", "府中商圈", "捷運府中站", 700.0, 13000.0, 125.0, null, "陳立數學園遊會", "新北市政府文化局");
		EventSpace es11 = new EventSpace("435藝文特區", "新北市政府", "中正路", "博物館", "板橋中正路商圈", "板橋中正路公車站", 850.0, 4800.0, 225.0, null, "新北果菜市場特賣會", "新北市政府文化局");
		EventSpace es12 = new EventSpace("華山1914", "台北市政府", "北平東路", "中型活動場所", "忠孝新生商圈", "捷運忠孝新生站", 550.0, 21000.0, 95.0, null, "原價屋骨折特賣", "華山藝文小隊");
		EventSpace es13 = new EventSpace("四四南村", "台北市政府", "信義路", "小型開放場域", "台北101商圈", "捷運台北101站", 1550.0, 81000.0, 45.0, null, "台北世貿婦幼展", "台北市政府文化局");
		list.add(es1);
		list.add(es2);
		list.add(es3);
		list.add(es4);
		list.add(es5);
		list.add(es6);
		list.add(es7);
		list.add(es8);
		list.add(es9);
		list.add(es10);
		list.add(es11);
		list.add(es12);
		list.add(es13);

		SessionFactory factory = HibernateUtilNoWeb.getSessionFactory();
		Session session = factory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		System.out.println("Transaction Begin.");
		
		int counter = 0;
		try {
			for (EventSpace item: list) {
				
				EventSpace bean = new EventSpace(item.getName(), item.getOwner(), item.getAddress(), item.getType(), item.getShoppingArea(), item.getTransportation(), item.getCapacity(), item.getUnitPrice(), item.getArea(), item.getRentalTime(), item.getActivityInfo(), item.getContactInfo());
				session.save(bean);
				counter++;
				
				if(counter%50==0) {
					session.flush();
					session.clear();
				}
			}	
			tx.commit();
			System.out.println("Transaction Commit.");
		} catch (Exception e) {
			tx.rollback();
			System.out.println("Transaction Rollback.");
			e.printStackTrace();
		}finally {
			System.out.println("Session Closed.");
		}
		
//		HibernateUtilNoWeb.closeSessionFactory();		

		System.out.println("已插入EventSpace資料列");
	}
	
//	塞入預設的幾組帳密
	public void wmWriteDB() {
		
//		註冊時間
		LocalDate now = LocalDate.now();
//		塞入預設使用者圖片
		List<FileInputStream> fisList = new ArrayList<FileInputStream>();
		List<Blob> blobList = new ArrayList<Blob>();
		try {
//			先輸入為BufferedImage (image)
			FileInputStream fis1 = new FileInputStream("IOFiles/inputJPG/admin.JPG");
			FileInputStream fis2 = new FileInputStream("IOFiles/inputJPG/member.JPG");
			FileInputStream fis3 = new FileInputStream("IOFiles/inputJPG/alien.JPG");
			FileInputStream fis4 = new FileInputStream("IOFiles/inputJPG/others.JPG");
			fisList.add(fis1);
			fisList.add(fis2);
			fisList.add(fis3);
			fisList.add(fis4);
			for (FileInputStream item: fisList) {
				BufferedImage image = ImageIO.read(item);
//				再把BufferedImage轉為ByteArrayOutputStream (baos)
				ByteArrayOutputStream baos = new ByteArrayOutputStream();
				ImageIO.write(image, "jpg", baos);
//				ByteArrayOutputStream轉ByteArray (ba)
				byte[] ba = baos.toByteArray();
// 				convert Byte array to Blob using SerialBlob() method
				Blob blob = new SerialBlob(ba);
				blobList.add(blob);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
//		加密預設密碼oracle
		String password = GlobalService.getMD5Endocing(
				GlobalService.encryptString("oracle"));
		
		List<WebsiteMember> list = new ArrayList<WebsiteMember>();
		WebsiteMember wm1 = new WebsiteMember("admin", password, "管理員", "凱達格蘭大道一號", "admin@gmail.com", "0988588168", "admin", blobList.get(0), "art", now, 100000.0, 0, 0, 0, "valid");
		WebsiteMember wm2 = new WebsiteMember("member", password, "王曉明", "凱達格蘭大道二號", "aaartgroup4@gmail.com", "0966588168", "user", blobList.get(1), "photo", now, 10000.0, 0, 0, 0, "valid");
		WebsiteMember wm3 = new WebsiteMember("alien", password, "林外星", "凱達格蘭大道三號", "aaartgroup4@gmail.com", "0967679881", "user", blobList.get(2), "eating", now, 1000.0, 0, 0, 0, "valid");
		WebsiteMember wm4 = new WebsiteMember("alex", password, "艾力克斯權", "凱達格蘭大道四號", "alien@gmail.com", "0967867881", "user", blobList.get(3), "shopping", now, 1000.0, 0, 0, 0, "valid");
		WebsiteMember wm5 = new WebsiteMember("hanjiping", password, "韓志平", "凱達格蘭大道五號", "alien@gmail.com", "0967632881", "user", blobList.get(3), "surfing", now, 1000.0, 0, 0, 0, "valid");
		WebsiteMember wm6 = new WebsiteMember("nandaosan", password, "南道山", "凱達格蘭大道六號", "alien@gmail.com", "0967947551", "user", blobList.get(3), "running", now, 1000.0, 0, 0, 0,"valid");
		WebsiteMember wm7 = new WebsiteMember("yungsan", password, "容山", "凱達格蘭大道七號", "alien@gmail.com", "0962463706", "user", blobList.get(3), "music", now, 1000.0, 0, 0, 0, "valid");
		WebsiteMember wm8 = new WebsiteMember("chesan", password, "哲山", "凱達格蘭大道八號", "alien@gmail.com", "0935819881", "user", blobList.get(3), "sports", now, 1000.0, 0, 0, 0, "valid");
		WebsiteMember wm9 = new WebsiteMember("dalmi", password, "徐達美", "凱達格蘭大道九號", "alien@gmail.com", "0965367164", "user", blobList.get(3), "fashion", now, 1000.0, 0, 0, 0, "valid");
		WebsiteMember wm10 = new WebsiteMember("yongtsai", password, "徐仁才", "凱達格蘭大道十號", "alien@gmail.com", "0961359834", "user", blobList.get(3), "history", now, 1000.0, 0, 0, 0, "valid");
		WebsiteMember wm11 = new WebsiteMember("jingming", password, "菁明", "凱達格蘭大道11號", "alien@gmail.com", "0937089001", "user", blobList.get(3), "geography", now, 1000.0, 0, 0, 0, "valid");
		WebsiteMember wm12 = new WebsiteMember("sandbox", password, "沙盒", "凱達格蘭大道12號", "alien@gmail.com", "0967889951", "user", blobList.get(3), "climbing", now, 1000.0, 0, 0, 0, "valid");
		WebsiteMember wm13 = new WebsiteMember("startup", password, "史大啊", "凱達格蘭大道13號", "alien@gmail.com", "0962419881", "user", blobList.get(3), "hiking", now, 1000.0, 0, 0, 0, "valid");
		WebsiteMember wm14 = new WebsiteMember("running", password, "快跑啊", "凱達格蘭大道14號", "alien@gmail.com", "0906841289", "user", blobList.get(3), "cooking", now, 1000.0, 0, 0, 0, "valid");
		WebsiteMember wm15 = new WebsiteMember("itaewon", password, "梨泰院", "凱達格蘭大道15號", "alien@gmail.com", "0911538891", "user", blobList.get(3), "fighting", now, 1000.0, 0, 0, 0, "valid");
		WebsiteMember wm16 = new WebsiteMember("nainai", password, "奶奶", "凱達格蘭大道16號", "alien@gmail.com", "0966358891", "user", blobList.get(3), "reading", now, 1000.0, 0, 0, 0,"valid");
		WebsiteMember wm17 = new WebsiteMember("alisu", password, "有西", "凱達格蘭大道17號", "alien@gmail.com", "0969505891", "user", blobList.get(3), "gaming", now, 1000.0, 0, 0, 0,"valid");
		WebsiteMember wm18 = new WebsiteMember("suzuki", password, "鈴木", "凱達格蘭大道18號", "alien@gmail.com", "0988916923", "user", blobList.get(3), "driving", now, 1000.0, 0, 0, 0,"valid");
		WebsiteMember wm19 = new WebsiteMember("aloha", password, "阿羅哈", "凱達格蘭大道19號", "alien@gmail.com", "0918493203", "user", blobList.get(3), "singing", now, 1000.0, 0, 0, 0,"valid");
		WebsiteMember wm20 = new WebsiteMember("yoyoyo", password, "又幼又", "凱達格蘭大道20號", "alien@gmail.com", "0910479213", "user", blobList.get(3), "rap", now, 1000.0, 0, 0, 0,"valid");

		list.add(wm1);
		list.add(wm2);
		list.add(wm3);
		list.add(wm4);
		list.add(wm5);
		list.add(wm6);
		list.add(wm7);
		list.add(wm8);
		list.add(wm9);
		list.add(wm10);
		list.add(wm11);
		list.add(wm12);
		list.add(wm13);
		list.add(wm14);
		list.add(wm15);
		list.add(wm16);
		list.add(wm17);
		list.add(wm18);
		list.add(wm19);
		list.add(wm20);
		
		SessionFactory factory = HibernateUtilNoWeb.getSessionFactory();
		Session session = factory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		System.out.println("Transaction Begin.");
		
		int counter = 0;
		try {
			for (WebsiteMember item: list) {
				
				WebsiteMember bean = new WebsiteMember(item.getName(), item.getPassword(), item.getRealName(), item.getAddress(), item.getEmail(), item.getTel(), item.getMemberType(), item.getMemberPic(), item.getPreference(), item.getRegisterTime(), item.getPurchaseLimit(), item.getDeco(), item.getHome(), item.getBook(), item.getStatus());
				session.save(bean);
				counter++;
				
				if(counter%50==0) {
					session.flush();
					session.clear();
				}
			}	
			tx.commit();
			System.out.println("Transaction Commit.");
		} catch (Exception e) {
			tx.rollback();
			System.out.println("Transaction Rollback.");
			e.printStackTrace();
		}finally {
			System.out.println("Session Closed.");
		}
		
//		HibernateUtilNoWeb.closeSessionFactory();		
		
		System.out.println("已插入WebsiteMember資料列");
	}

}
