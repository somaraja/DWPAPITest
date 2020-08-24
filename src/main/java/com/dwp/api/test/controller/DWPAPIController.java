package com.dwp.api.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dwp.api.test.model.User;
import com.dwp.api.test.service.DWPAPIService;

@RestController
@RequestMapping("/dwpapitest")
public class DWPAPIController {
	@Autowired
	DWPAPIService apiService;

	@GetMapping(path = "/users/city")
	@ResponseBody
	public List<User> getUsersForCity(String city) {

		return apiService.getUsersForCity(city);
	}

	@GetMapping(path = "/users")
	@ResponseBody
	public List<User> getAllUsers() {

		return apiService.getAllUsers();
	}

	@GetMapping(path = "/users/coordinates")
	@ResponseBody
	public List<User> getUsersInCoordinates(String city, Double distance) {

		return apiService.getUsersInCoordinates(city, distance);
	}	
}
