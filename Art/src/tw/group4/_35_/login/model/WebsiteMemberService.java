package tw.group4._35_.login.model;

import java.sql.Blob;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WebsiteMemberService {

	private WebsiteMemberDao dao;

	@Autowired
	public WebsiteMemberService(WebsiteMemberDao dao) {
		this.dao = dao;
	}
	
	public WebsiteMember insert(WebsiteMember wmBean) {
		return dao.insert(wmBean);
	}
	
	public int insertWithResult(WebsiteMember wmBean) {
		return dao.insertWithResult(wmBean);
	}
	
	//按id讀取資料庫內會員的方法
	public WebsiteMember selectById(int id) {
		return dao.selectById(id);
	}
	
	//傳入登入表單輸入會員資料進行驗證的方法
	public Boolean checkLogin(WebsiteMember member) {
		return dao.checkLogin(member);
	}
	
	//傳入登入表單輸入會員名確認無重複的方法
	public Boolean checkNameExsist(String name) {
		return dao.checkNameExsist(name);
	}
	
	//傳入登入表單輸入會員資料，回傳會員完整資料放到session
	public WebsiteMember getMemberFullInfo(WebsiteMember member) {
		return dao.getMemberFullInfo(member);
	}
	
	//傳入登入表單輸入會員資料，回傳會員完整資料+圖片ByteArray放到session
	public byte[] getMemberPicByteArray(WebsiteMember member) {
		WebsiteMember memberResult = dao.getMemberFullInfo(member);
		Blob blob = memberResult.getMemberPic();
		
//		Blob轉byteArray須設定Blob.getBytes(long pos, int length)
		byte[] byteArray = null;
		try {
			byteArray = blob.getBytes(1, (int) blob.length());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return byteArray;
	}
	
//	查詢會員表格所有資料
	public List<WebsiteMember> selectAllMembers(){

		return dao.selectAllMembers();
	}
	
//	查詢會員表格所有資料包含會員圖片的Base64Str
	public List<WebsiteMember> selectAllMembersBase64Str(){
		List<WebsiteMember> list = dao.selectAllMembers();
		List<WebsiteMember> base64StrList = new ArrayList<WebsiteMember>();
		
		for(WebsiteMember item : list) {
			if(item.getMemberPic() == null) {
				base64StrList.add(item);
			}else {
				Blob memberPic = item.getMemberPic();
				String base64Str = null;
				try {
					byte[] memberPicByte = memberPic.getBytes(1, (int) memberPic.length());
					base64Str = Base64.getEncoder().encodeToString(memberPicByte);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				item.setMemberPicBase64Str(base64Str);
				base64StrList.add(item);
			}
		}
			
		return base64StrList;
	}
	
//	只包含個人資訊的會員資料
	public List<WebsiteMember> selectSingleMemberBase64Str(String name) {
		List<WebsiteMember> list = dao.selectSingleMember(name);
		List<WebsiteMember> base64StrList = new ArrayList<WebsiteMember>();
		
		for(WebsiteMember item : list) {
			if(item.getMemberPic() == null) {
				base64StrList.add(item);
			}else {
				Blob memberPic = item.getMemberPic();
				String base64Str = null;
				try {
					byte[] memberPicByte = memberPic.getBytes(1, (int) memberPic.length());
					base64Str = Base64.getEncoder().encodeToString(memberPicByte);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				item.setMemberPicBase64Str(base64Str);
				base64StrList.add(item);
			}
		}
		
		return base64StrList;
	}
	
//	刪除會員資料
	public boolean deleteMemberByName(String name) {
		return dao.deleteMemberByName(name);
	}
	
//	更新會員資料
	public boolean updateMemberByName(WebsiteMember member) {
		return dao.updateMemberByName(member);
	}
	
	public WebsiteMember update(WebsiteMember wmBean) {
		return dao.update(wmBean);
		
	}
	
}
