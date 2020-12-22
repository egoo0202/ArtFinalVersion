package tw.group4._35_.cms.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import tw.group4._35_.cms.model.EventSpace;
import tw.group4._35_.cms.model.InterfaceEventSpaceService;
import tw.group4.util.Hibernate;

@Controller
public class InsertInto {
	
	@Autowired
	private InterfaceEventSpaceService esService;
	
	@RequestMapping(path = "/35/addData", method = RequestMethod.GET)
	public String addData() {
		return "35/cms/addData";
	}
	
	@Hibernate
	@RequestMapping(path = "/35/insertInto.ctrl", method = RequestMethod.GET)
	public String insertInto(
			@RequestParam(name = "name")String name,
			@RequestParam(name = "owner")String owner,
			@RequestParam(name = "address")String address,
			@RequestParam(name = "type")String type,
			@RequestParam(name = "shoppingArea")String shoppingArea,
			@RequestParam(name = "transportation")String transportation,
			@RequestParam(name = "capacity")String strCapacity,
			@RequestParam(name = "unitPrice")String strUnitPrice,
			@RequestParam(name = "area")String strArea,
			@RequestParam(name = "rentalTime")String strRentalTime,
			@RequestParam(name = "activityInfo")String activityInfo,
			@RequestParam(name = "contactInfo")String contactInfo,
			Model m) {
		
		Double capacity = null;
		try {
			capacity = Double.parseDouble(strCapacity);
		} catch (Exception e) {
			capacity = 0.0;
		}
		Double unitPrice = null;
		try {
			unitPrice = Double.parseDouble(strUnitPrice);
		} catch (Exception e) {
			unitPrice = 0.0;
		}
		Double area = null;
		try {
			area = Double.parseDouble(strArea);
		} catch (Exception e) {
			area = 0.0;
		}
		LocalDate rentalTime = null;
		try {
			rentalTime = LocalDate.parse(strRentalTime);
		} catch (Exception e) {
			LocalDate now=LocalDate.now();
			rentalTime = now;
		}
		
		EventSpace bean = new EventSpace(name, owner, address, type, shoppingArea, transportation, 
				capacity, unitPrice, area, rentalTime, activityInfo, contactInfo);
		
		InterfaceEventSpaceService service = esService;
		EventSpace insertResult = service.insert(bean);
		
		if(insertResult==null) {
			m.addAttribute("insertResult", "該筆資料已存在，若是需要修改請返回首頁進行點選修改");
		}else {
			m.addAttribute("insertResult", "新增成功");
			m.addAttribute("eventSpace", insertResult);
		}
		
		return "35/cms/addDataResult";
	}

}
