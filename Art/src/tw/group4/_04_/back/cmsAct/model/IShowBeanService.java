package tw.group4._04_.back.cmsAct.model;

import java.io.IOException;
import java.util.List;

public interface IShowBeanService {
	public ShowBean insert(ShowBean showbean);
	public ShowBean select(int actId);
	public List<ShowBean> selectAll();
	public List<ShowBean> selectAll2();
	public ShowBean update(int actno, String title, int category, String location, String locationName,
			String mainunit, String showunit, String description, String startdate, String enddate);
	public boolean delete(int actid) ;
	public  List<ShowBean> find(String searchString);
}
