package tw.group4._35_.unusedInitweb.controller;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import tw.group4._35_.unusedInitweb.model.CreateTableInsertDataService;

@Controller
public class EstablishDatabase {
	
	@Autowired
	SessionFactory sessionFactory;
	
	@Autowired
	CreateTableInsertDataService citiService;
	
	@RequestMapping(path = "/35/establishDatabase.ctrl", method = RequestMethod.GET)
	public String establishDatabase() {
		citiService.executeOrder();

		return "35/init/establishDatabaseResult";
	}
}
