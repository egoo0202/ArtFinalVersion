package tw.group4._11_.model;

import java.util.List;

import org.springframework.stereotype.Service;
@Service
public class StreetArtistBeanService {

	private StreetArtistBeanDAO sDao;
	
	public StreetArtistBeanService(StreetArtistBeanDAO sDao) {
		this.sDao = sDao;
	}

	public StreetArtistBean insert(StreetArtistBean sBean) {
		return sDao.insert(sBean);
	}

	public StreetArtistBean select(int Id_SA) {
		return sDao.select(Id_SA);
	}
	
	public List<StreetArtistBean> selectAll(){
		return sDao.selectAll();
	}
	
	public StreetArtistBean update(int Id_SA , String name_SA , String country_SA , String theme_SA , String classification_SA) {
		return sDao.update(Id_SA, name_SA, country_SA, theme_SA, classification_SA);
	}
	
	public boolean delete(int Id_SA) {
		return sDao.delete(Id_SA);
	}
	
	public List<StreetArtistBean> searchID(int id){
		return sDao.searchID(id);
	}
	
	public List<StreetArtistBean> search(String word){
		return sDao.search(word);
	}
	
	public int showSal(int id) {
		return sDao.showSal(id);
	}
}
