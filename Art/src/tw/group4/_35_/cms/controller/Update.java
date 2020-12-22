package tw.group4._35_.cms.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
public class Update {
	
	@Autowired
	InterfaceEventSpaceService esService;
	
	@RequestMapping(path = "/35/editEventSpace", method = RequestMethod.GET)
	public String editEventSpace(
			@RequestParam(name = "id")String strId,
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
		
		List<String> list = new ArrayList<String>();
		list.add(strId);
		list.add(name);
		list.add(owner);
		list.add(address);
		list.add(type);
		list.add(shoppingArea);
		list.add(transportation);
		list.add(strCapacity);
		list.add(strUnitPrice);
		list.add(strArea);
		list.add(strRentalTime);
		list.add(activityInfo);
		list.add(contactInfo);
		m.addAttribute("list", list);
		
		return "35/cms/editEventSpace";
	}
	
	@Hibernate
	@RequestMapping(path = "/35/update.ctrl", method = RequestMethod.GET)
	public String update(
			@RequestParam(name = "id")String strId,
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
		int id = Integer.parseInt(strId);
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
		
		EventSpace bean = new EventSpace(id, name, owner, address, type, shoppingArea, transportation, 
				capacity, unitPrice, area, rentalTime, activityInfo, contactInfo);
		
		InterfaceEventSpaceService service = esService;
		boolean updateResult = service.update(bean);
		
		if(updateResult) {
			m.addAttribute("updateResult", "更新成功");
			m.addAttribute("eventSpace", bean);
		}else {
			m.addAttribute("updateResult", "更新失敗");
		}
		
		return "35/cms/editEventSpaceResult";
	}
}
