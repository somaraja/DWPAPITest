package com.dwp.api.test.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	@RequestMapping({"/","/dwpapitest"})
	public String home() {
		return "Welcome to Department for Work and Pensions API Challenge!<br><br>Please use any one of the following end points<br>1) http://localhost:8081/dwpapitest/users (This is GET method to get all users using above mentioned API)\r<br>"
				+ "	2) http://localhost:8081/dwpapitest/users/city?city=London (This is GET method to get users belongs to certain city using above mentioned API, Note here city is dynamic value)\r<br>"
				+ "	3) http://localhost:8081/dwpapitest/users/coordinates?city=London&distance=50 (This is GET method to get users belongs to certain city and with in certain distance using above mentioned API, Note here city and distance are dynamic values)";
	}

}
