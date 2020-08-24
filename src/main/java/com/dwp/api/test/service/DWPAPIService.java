package com.dwp.api.test.service;

import java.util.List;

import com.dwp.api.test.model.User;

public interface DWPAPIService {
	List<User> getAllUsers();
	List<User> getUsersForCity(String city);
	List<User> getUsersInCoordinates(String city, Double distance);
}
