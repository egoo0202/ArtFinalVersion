package tw.group4._11_.model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//import javax.servlet.http.HttpSession;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserSAService {

	private UserSADao uDao;

	@Autowired
	public UserSAService(UserSADao uDao) {
		this.uDao = uDao;
	}
	
	public List<UserSABean> selectQueryAll(int page, String query){
		return uDao.selectPage(page);
	}
	
	public int selectCount() {
		return uDao.selectCount();
	}
	
	public int getTotlaPage() {
		return uDao.getTotlePage();
	}
	
	public int getPages(String query) {
		return uDao.getPages(query);
	}
	
	public byte[] picSaByteArray(UserSABean uBean) {
		return uDao.picSaByteArray(uBean);
	}
	
	public List<UserSABean> selectAll(){
		return uDao.selectAll();
	}
	
	public List<UserSABean> search(String word){
		return uDao.search(word);
	}
	
	public DonateRecordBean insert(DonateRecordBean record) {
		return uDao.insert(record);
	}
	
	public UserSABean selectById(int id) {
		return uDao.selectById(id);
	}
	
	public List<UserSABean> selectPage(int page){
		List<UserSABean> list = uDao.selectPage(page);
		List<UserSABean> listNew = new ArrayList<UserSABean>();
		
		for (UserSABean item: list) {
//			System.out.println(item.getPic_SA());
//			System.out.println(item.getName_SA());
			try {
				byte[] byteArray = item.getPic_SA().getBytes(1, (int) item.getPic_SA().length());
				item.setPic2_SA(Base64.encodeBase64String(byteArray));
			} catch (SQLException e) {
				e.printStackTrace();
			}
			listNew.add(item);
		}
		return listNew;
		
//		return pDao.selectPage(page);
	}
	
	public List<UserSABean> selectAllSA(){
		List<UserSABean> list = uDao.selectAll();
		List<UserSABean> listNew = new ArrayList<UserSABean>();
		
		for (UserSABean item: list) {
//			System.out.println(item.getPic_SA());
//			System.out.println(item.getName_SA());
			try {
				byte[] byteArray = item.getPic_SA().getBytes(1, (int) item.getPic_SA().length());
				item.setPic2_SA(Base64.encodeBase64String(byteArray));
			} catch (SQLException e) {
				e.printStackTrace();
			}
			listNew.add(item);
		}
		return listNew;
	}
	
	public List<UserSABean> selectIdSA(int id){
		List<UserSABean> list = uDao.searchID(id);
		List<UserSABean> listNew = new ArrayList<UserSABean>();
		
		for (UserSABean item: list) {
			System.out.println(item.getPic_SA());
			System.out.println(item.getName_SA());
			try {
				byte[] byteArray = item.getPic_SA().getBytes(1, (int) item.getPic_SA().length());
				item.setPic2_SA(Base64.encodeBase64String(byteArray));
			} catch (SQLException e) {
				e.printStackTrace();
			}
			listNew.add(item);
		}
		return listNew;
	}
	
	public UserSABean donateToSA(int id_SA , int sal_SA) {
		return uDao.donateToSA(id_SA, sal_SA);
	}
	
	public List<DonateRecordBean> showList(String name) {
		return uDao.showList(name);
	}
	
	public List<DonateRecordBean> showAllDonateRecord(){
		return uDao.showAllDonateRecord();
	}
//	public DonateRecordBean recordDonation(
//			int id_SA , 
//			int donate_SA , 
//			HttpSession hSession) {
//		return uDao.recordDonation(id_SA, donate_SA, hSession);
//	}
}
