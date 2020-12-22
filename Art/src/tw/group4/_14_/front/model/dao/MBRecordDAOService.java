package tw.group4._14_.front.model.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.group4._14_.front.model.MBRecordBean;

@Service("MBRecordDAOService")
public class MBRecordDAOService {
	
	
	private MBRecordDAOImpl mbrDao;
	
	public MBRecordDAOService() {
		
	}

	@Autowired
	public MBRecordDAOService(MBRecordDAOImpl mbrDao) {
		this.mbrDao = mbrDao;
	}
	
	public MBRecordBean insertMBRecord(MBRecordBean mbid) {
		return mbrDao.insertMBRecord(mbid);
	}
	
	
	public int searchMessage (int mid, int apid) {
		
		return mbrDao.searchMessage(mid, apid);
	}
	
	public MBRecordBean selectMessage (int mid, int apid) {
		return mbrDao.selectMessage(mid, apid);
	}
	
	
	public MBRecordBean changeStatus(MBRecordBean pd) {
		return mbrDao.changeStatus(pd);
	}

	public int sumMessage (int apid) {
		return mbrDao.sumMessage(apid);
	}
}
