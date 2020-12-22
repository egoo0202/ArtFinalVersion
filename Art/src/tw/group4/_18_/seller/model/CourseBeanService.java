package tw.group4._18_.seller.model;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("CourseBeanService")
public class CourseBeanService {
	
private CourseBeanDAO cDAO;
	
	public CourseBeanService() {
		
	}

	@Autowired
	public CourseBeanService(CourseBeanDAO cDAO) {
		this.cDAO = cDAO;
	}
	
	public Course insert(Course co) {
		return cDAO.insert(co);

	}
	
	public Course select(String coId) {
		return cDAO.select(coId);
	}
	
	
	public Course selectB(String coId) {
		Course course = cDAO.selectB(coId);
		byte[] byt = course.getCoAct_Image();

		String encodedString = Base64.encodeBase64String(byt);
		course.setCoAct_ImageStr(encodedString);
		return course;
	}
	
	
	public List<Course> selectAll() {
		
		List<Course> list = cDAO.selectAll();
		List<Course> list2 = new ArrayList<Course>() ; 
		for (int i = 0; i < list.size(); i++) {
			byte[] byt =list.get(i).getCoAct_Image();
			
			String encodedString = Base64.encodeBase64String(byt);  //Base64是一種能將任意Binary資料用64種字元組合成字串的方法
			list.get(i).setCoAct_ImageStr(encodedString);
			list2.add(list.get(i));
		}
//		list2.get(0).getCoAct_ImageStr();
		return list2;
	}
	
	public boolean update(String coId, String coTitle, String coAct_Type, String coAct_Location, String coLocation_Name , int coNum,  int coPrice, 
			String coAct_Date, String coAct_Time, String coEnd_Date, String coEnd_Time, String coAct_Description, int coHot, byte[] coAct_Image) {
		return cDAO.update(coId, coTitle, coAct_Type, coAct_Location, coLocation_Name, coNum, coPrice, coAct_Date, coAct_Time, coEnd_Date, coEnd_Time, coAct_Description, coHot, coAct_Image);
	}
	
	public boolean delete(String coId) {
		return cDAO.delete(coId);
	}
	
	
	public List<Course> searchByWord(String searchWord){
		return cDAO.searchByWord(searchWord);
	}
	
	
	public List<Course> searchByType(String searchType){
		return cDAO.searchByType(searchType);
	}
}
