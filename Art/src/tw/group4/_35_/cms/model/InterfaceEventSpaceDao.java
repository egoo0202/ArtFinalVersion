package tw.group4._35_.cms.model;

import java.util.List;

public interface InterfaceEventSpaceDao {

	//依場地名稱查詢
	List<EventSpace> select(String name);

	//查詢全部場地
	List<EventSpace> selectAll();

	//新增。存在就不新增，不存在才新增。
	EventSpace insert(EventSpace bean);

	//更新。傳入bean.getId對應的資料，確認資料庫有這筆後。
	//detach搜尋到的物件再次進行更新
	boolean update(EventSpace bean);

	//刪除。傳入name有對應資料才刪除。
	boolean delete(String name);

}