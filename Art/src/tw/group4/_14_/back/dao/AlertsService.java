package tw.group4._14_.back.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.group4._14_.back.Alerts;
import tw.group4._14_.front.model.OrderListBeamAP;

@Service
public class AlertsService {

	private AlertsDAOImpl aImpl;
	
	@Autowired
	public AlertsService(AlertsDAOImpl aImpl) {
		this.aImpl = aImpl;
	}
	
	
	public AlertsService() {
		
	}
	
	public Alerts select(int alertsNo) {
		return aImpl.select(alertsNo);
	}
	
	public List<Alerts> selectPartAlerts() {
		return aImpl.selectPartAlerts();
	}
	
	
	public List<Alerts> selectAllAlerts() {
		return aImpl.selectAllAlerts();
	}
	
	public Alerts insert(Alerts al) {
		return aImpl.insert(al);
	}
	
	
	public boolean deleteAlerts(int alertsNo) {
		return aImpl.deleteAlerts(alertsNo);
	}
	
	public Alerts update(Alerts al) {
		return aImpl.update(al);
	}
	
	public Long sumTotal() {
		return aImpl.sumTotal();
		
	}
	
	public Long sumMessageAP() {
		return aImpl.sumMessageAP();
	}

	public Long sumAlertsUnRead() {
		return aImpl.sumAlertsUnRead();
	}


}
