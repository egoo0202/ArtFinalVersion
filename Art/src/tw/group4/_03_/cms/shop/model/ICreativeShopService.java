package tw.group4._03_.cms.shop.model;

import java.util.List;

public interface ICreativeShopService {
	
	public boolean checkShopId(int shopId);

//	public boolean checkReservation(int shopId);
	
	public CreativeShopBean insert(CreativeShopBean bean);

	public CreativeShopBean select(int shopId);

	public List<CreativeShopBean> selectByShopId(int shopId);

	// 5 ==========================
	
	public List<CreativeShopBean> selectByShopName(String shopName);

	public List<CreativeShopBean> selectByMemberId(int memberId);

	public List<CreativeShopBean> selectByShopNameAndMemberId(String shopName, int memberId);
	
	public List<CreativeShopBean> selectAll();

	public List<CreativeShopBean> selectByReservation();
	
	// 10 ==========================
	
	public List<CreativeShopBean> selectByMemberIdAndReservation(int memberId);
	
	public List<CreativeShopBean> selectByShopNameAndReservation(String shopName);
	
	public List<CreativeShopBean> selectByShopNameAndMemberIdAndReservation(String shopName, int memberId);
		
	public CreativeShopBean update( 
			int shopId, String shopName, int memberId, String image, String intro, 
			String cityName, String address, String openTime, String phone, String fax, 
			String email, String facebook, String website, int clicks, byte[] reservation);
	
	public boolean delete(int shopId);
	
	// 15 ==========================

	public List<CreativeShopBean> select16OrderByShopId();
	
	public List<CreativeShopBean> select16OrderByPopularity();
	
	public List<CreativeShopBean> select9OrderByPopularity();
	
}
