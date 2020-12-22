package tw.group4._14_.dashboard.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.group4._14_.dashboard.model.EntryClickRate;


@Service("DashboardService")
public class DashboardService {

	@Autowired
	private DashboardDAOImpl dDao;
	
	public DashboardService() {
		
	}
	
	public DashboardService(DashboardDAOImpl dDao) {
		this.dDao = dDao;
	}
	
	
	public Long sumTicketTotal() {
		return dDao.sumTicketTotal();
	}
	
	public Long sumMember() {
		return dDao.sumMember();
	}
	
	public Long sumArtistTotal() {
		return dDao.sumArtistTotal();
	}
	
	public Long sumCourseTotal() {
		return dDao.sumCourseTotal();
	}
	
	
	public EntryClickRate insert(EntryClickRate ecr) {
		return dDao.insert(ecr);
	}
	
	public Long sumTicketClick() {
		return dDao.sumTicketClick();
	}
	
	public Long sumShopClick() {
		return dDao.sumShopClick();
	}
	
	public Long sumRestaurantClick() {
		return dDao.sumRestaurantClick();
	}
	
	public Long sumMapClick() {
		return dDao.sumMapClick();
	}

	public Long sumNearbyClick() {
		return dDao.sumNearbyClick();
	}
	
	public Long sumCourseClick() {
		return dDao.sumCourseClick();
	}
	
	public Long sumArtistClick() {
		return dDao.sumArtistClick();
	}
	
	public Long sumRestaurantOrder() {
		return dDao.sumRestaurantOrder();
	}
	
	public Long sumRestaurantAdTotal() {
		return dDao.sumRestaurantAdTotal();
	}
	
	public Long sumRestaurantChTotal() {
		return dDao.sumRestaurantChTotal();
	}
}
