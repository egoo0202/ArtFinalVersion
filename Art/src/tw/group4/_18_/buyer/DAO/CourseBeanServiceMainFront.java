package tw.group4._18_.buyer.DAO;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.group4._04_.back.cmsAct.model.ShowBean2;
import tw.group4._14_.back.ARTProduct;
import tw.group4._18_.buyer.model.CourseFront;

@Service("CourseBeanServiceFront")
public class CourseBeanServiceMainFront {

	private CourseBeanDAOMainFront cDAOF;

	public CourseBeanServiceMainFront() {

	}

	@Autowired
	public CourseBeanServiceMainFront(CourseBeanDAOMainFront cDAOF) {
		this.cDAOF = cDAOF;
	}
	
	
	public CourseFront selectF(String coId) {
		CourseFront courseFront = cDAOF.selectF(coId);
		byte[] byt = courseFront.getCoAct_Image();

		String encodedString = Base64.encodeBase64String(byt);
		courseFront.setCoAct_ImageStr(encodedString);
		return courseFront;
	}
	
	
	public List<CourseFront> selectAllF() {

		List<CourseFront> list = cDAOF.selectAllF();
		List<CourseFront> list2 = new ArrayList<CourseFront>();
		for (int i = 0; i < list.size(); i++) {
			byte[] byt = list.get(i).getCoAct_Image();

			String encodedString = Base64.encodeBase64String(byt); // Base64是一種能將任意Binary資料用64種字元組合成字串的方法
			list.get(i).setCoAct_ImageStr(encodedString);
			list2.add(list.get(i));
		}
//		list2.get(0).getCoAct_ImageStr();
		return list2;
	}
	
		
	public List<CourseFront> searchByWord(String searchWord){
		List<CourseFront> list = cDAOF.searchByWord(searchWord);
		List<CourseFront> list2 = new ArrayList<CourseFront>();
		for (int i = 0; i < list.size(); i++) {
			byte[] byt = list.get(i).getCoAct_Image();

			String encodedString = Base64.encodeBase64String(byt); // Base64是一種能將任意Binary資料用64種字元組合成字串的方法
			list.get(i).setCoAct_ImageStr(encodedString);
			list2.add(list.get(i));
		}
		return cDAOF.searchByWord(searchWord);
	}
	
	
	public List<CourseFront> searchByType(String searchType){
		List<CourseFront> list = cDAOF.searchByType(searchType);
		List<CourseFront> list2 = new ArrayList<CourseFront>();
		for (int i = 0; i < list.size(); i++) {
			byte[] byt = list.get(i).getCoAct_Image();

			String encodedString = Base64.encodeBase64String(byt); // Base64是一種能將任意Binary資料用64種字元組合成字串的方法
			list.get(i).setCoAct_ImageStr(encodedString);
			list2.add(list.get(i));
		}
		return cDAOF.searchByType(searchType);
	}
	
	
}
