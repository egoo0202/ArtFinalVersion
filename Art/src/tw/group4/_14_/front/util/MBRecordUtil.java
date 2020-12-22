package tw.group4._14_.front.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.group4._14_.front.model.MBRecordBean;
import tw.group4._14_.front.model.dao.MBRecordDAOService;

@Service
public class MBRecordUtil {
	
	@Autowired
	private MBRecordDAOService mbrService;
	
	
	public void MBRCtrlIncrease(int mid,int apid) {
		
		
		//改成用會員編號當成 pk
			int result = mbrService.searchMessage(mid, apid);
	if (result > 0) {
		
		MBRecordBean mbr = mbrService.selectMessage(mid, apid);
		int status = mbr.getStatus();
		status++;
		mbr.setStatus(status);
		mbrService.changeStatus(mbr);
		
	}else {
		MBRecordBean mbrBean = new MBRecordBean();
		mbrBean.setApid(apid);
		mbrBean.setMberId(mid);
		mbrBean.setStatus(1);
		mbrService.insertMBRecord(mbrBean);
	}
			
		
			
	}
	
	
	public void MBRCtrlDecrease(int mid,int apid) {
		
		MBRecordBean mbr = mbrService.selectMessage(mid, apid);
		int status = mbr.getStatus();
		status--;
		mbr.setStatus(status);
		mbrService.changeStatus(mbr);
	}
}
