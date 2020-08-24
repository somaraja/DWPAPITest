package com.dwp.api.test.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.dwp.api.test.model.Coordinates;
import com.dwp.api.test.model.User;
import com.dwp.api.test.service.DWPAPIService;
import com.dwp.api.test.util.DistanceUtils;

@Service
public class DWPAPIServiceImpl implements DWPAPIService {
	@Value("${api.url}")
	private String apiURL;
	
	@Value("${openstreetmap.url}")
	private String openStreetMapURL;

	@Autowired
	private RestTemplate restTemplate;

	@Override
	public List<User> getAllUsers() {
		return getUsers(apiURL + "/users");
	}

	@Override
	public List<User> getUsersForCity(String city) {
		return getUsers(apiURL + "/city/" + city + "/users");
	}

	@Override
	public List<User> getUsersInCoordinates(String city, Double distance) {
		List<User> users = getAllUsers();
		List<User> coordUsers = new ArrayList<>();

		Coordinates[] coordinates = restTemplate.getForObject(
				openStreetMapURL+city, Coordinates[].class);

		for (User user : users) {
			Coordinates userCoordinates = new Coordinates(user.getLatitude(), user.getLongitude());
			Coordinates cityCoordinates = new Coordinates(coordinates[0].getLatitude(), coordinates[0].getLongitude());
			double distanceCoords = DistanceUtils.calculateDistance(userCoordinates, cityCoordinates);

			if (distanceCoords <= distance) {
				coordUsers.add(user);
			}
		}
		return coordUsers;
	}

	private List<User> getUsers(String url) {
		ResponseEntity<List<User>> userResponse = restTemplate.exchange(url, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<User>>() {
				});
		return userResponse.getBody();
	}

}
