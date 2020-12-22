package tw.group4._14_.back.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.group4._14_.front.model.OrderListBeamAP;

@Service("MbOrderListDAOServiceAP")
public class MbOrderListDAOServiceAP {

	private MbOrderListDAOImpAP mDAO;
	
	public MbOrderListDAOServiceAP() {
		
	}
	
	@Autowired
	public MbOrderListDAOServiceAP(MbOrderListDAOImpAP mDAO) {
		this.mDAO = mDAO;
	}
	
	public OrderListBeamAP select(int orderListID) {
		return mDAO.select(orderListID);
	}
	
	public boolean delete(int orderListID) {
		return mDAO.delete(orderListID);
	}
}
