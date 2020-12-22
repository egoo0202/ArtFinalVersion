package tw.group4._35_.csr.model;

import java.util.List;

import tw.group4._35_.geo.model.Activity;

public interface InterfaceActivityDao {

	//按藝文類別選取所有資訊
	List<Activity> selectDBtoActbyCat(int typeCode);

	//選取所有資訊
	List<Activity> selectDBtoAct();

}