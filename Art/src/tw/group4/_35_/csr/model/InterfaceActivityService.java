package tw.group4._35_.csr.model;

import java.util.List;

import tw.group4._35_.geo.model.Activity;

public interface InterfaceActivityService {

	//資料存取的底層方法寫在dao物件內，這邊沒有特別service要做
	//那就直接return dao.方法
	List<Activity> selectDBtoActbyCat(int typeCode);

	List<Activity> selectDBtoAct();

}