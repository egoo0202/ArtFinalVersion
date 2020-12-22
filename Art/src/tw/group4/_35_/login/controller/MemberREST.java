package tw.group4._35_.login.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tw.group4._35_.login.model.WebsiteMember;
import tw.group4._35_.login.model.WebsiteMemberService;
import tw.group4.util.Hibernate;

@RestController
public class MemberREST {

	@Autowired
	WebsiteMemberService service;
//	headers : {
//        'Content-Type' : 'application/json; charset=UTF-8'
//    },
	
//  讀取並傳回單筆會員資料，指定回傳json格式
//	DataTable目前取代單筆搜尋功能
//	@GetMapping(value = "/35/members/{name}"+".ctrl")
//	public @ResponseBody WebsiteMember displayMember(@PathVariable String name) {
//		WebsiteMember member = service.selectByName(name);
//		
//		return member;
//	}
	
//	新增單筆會員資料
	@Hibernate
	@PostMapping(value= "/35/members.ctrl")
	public Map<String, String> postMembers(@RequestBody WebsiteMember member) {
		
		int result = service.insertWithResult(member);
		
		HashMap<String, String> map = new HashMap<>();
		try {
			if (result == 1) {
				map.put("success", "新增成功"); 
			} else if (result == 0) {
				map.put("fail", "帳號重複");
			}
			
		} catch(Exception e) {
			map.put("fail", e.getMessage());
		}
		map.put("fail", "前段就被攔阻");
		
		return map;
	}
	
//	刪除單筆會員資料
	@Hibernate
	@DeleteMapping(value= "/35/members/{name}"+".ctrl")
	public Map<String, String> deleteMembers(@PathVariable String name) {	
		
		boolean result = service.deleteMemberByName(name);

		Map<String, String> map = new HashMap<>();

		if (result) {
			map.put("success", "停權成功");
		}else {
			map.put("fail", "停權失敗");
		}
		
		return map;
	}
	
//  修改單筆會員資料
	@Hibernate
	@PutMapping(value = "/35/members/{name}"+".ctrl")
	public Map<String, String> updateMember(@RequestBody WebsiteMember member, @PathVariable String name) {
		System.out.println(name);
		System.out.println(member.getRealName());
		System.out.println("dfsd");
//		if (name != null) {
//			member = service.findByPrimaryKey(key);
//			if (member == null) {
//				throw new RuntimeException("鍵值不存在, key=" + key);
//			}
//			service.evictMember(member0);
//		} else {
//			throw new RuntimeException("鍵值不存在, key=" + key);
//		}
//
		Map<String, String> map = new HashMap<>();
//		try {
//			service.updateMember(member);
//			map.put("success", "更新成功");
//		} catch (Exception e) {
//			e.printStackTrace();
//			map.put("fail", "更新失敗");
//		}
		map.put("fail", "其他原因更新失敗");
		
		return map;
	}
	
}
