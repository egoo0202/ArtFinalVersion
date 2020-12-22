package tw.group4._14_.front.model.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.group4._14_.front.model.MessageBoardAP;

@Service("MessageBoardImplAPService")
public class MessageBoardAPService {

	private MessageBoardImplAP mDaoAp;

	public MessageBoardAPService() {
		
	}
	
	@Autowired
	public MessageBoardAPService(MessageBoardImplAP mDaoAp) {
		this.mDaoAp = mDaoAp;
	}
	
	public MessageBoardAP insert(MessageBoardAP mb) {
		return mDaoAp.insert(mb);
	}
	
	public MessageBoardAP updateMessage(MessageBoardAP mb) {
		return mDaoAp.updateMessage(mb);
	}
	
	public List<MessageBoardAP> selectPdBoardAPs(Integer apId) {
		return mDaoAp.selectPdBoardAPs(apId);
	}
	
	public List<MessageBoardAP> selectAllPdBoardAPs() {
		return mDaoAp.selectAllPdBoardAPs();
	}
	
	public Long countMessageNum(int apId) {
		return mDaoAp.countMessageNum(apId);
	}
	
	public boolean deleteMessage(int mNo) {
		return mDaoAp.deleteMessage(mNo);
	}
	
	public MessageBoardAP selectMessage (int mNo) {
		return mDaoAp.selectMessage(mNo);
	}
	
}
