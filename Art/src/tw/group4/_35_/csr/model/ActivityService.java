package tw.group4._35_.csr.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.group4._35_.geo.model.Activity;

@Service
public class ActivityService implements InterfaceActivityService {
	
	private InterfaceActivityDao dao;
	
	//重要，該建構子代表建構服務層物件的同時，也透過spring autowired註冊了一個dao，沒註冊會一直叫不到dao物件哦
	//這個dao是服務層物件的屬性，俄羅斯娃娃的概念
	@Autowired
	public ActivityService(InterfaceActivityDao dao) {
		this.dao = dao;
	}
	
	//資料存取的底層方法寫在dao物件內，這邊沒有特別service要做
	//那就直接return dao.方法
	@Override
	public List<Activity> selectDBtoActbyCat(int typeCode) {
		return dao.selectDBtoActbyCat(typeCode);
	}
	
	@Override
	public List<Activity> selectDBtoAct() {
		return dao.selectDBtoAct();
	}
	
	
}
