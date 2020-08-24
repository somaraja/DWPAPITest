package com.dwp.api.test.service;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.dwp.api.test.model.Coordinates;
import com.dwp.api.test.model.User;
import com.dwp.api.test.service.impl.DWPAPIServiceImpl;
import com.dwp.api.test.util.DistanceUtils;

public class DWPAPIServiceTest {

	@Value("${api.url}")
	String apiURL;

	@Value("${openstreetmap.url}")
	private String openStreetMapURL;

	@Mock
	RestTemplate mockRestTemplate;

	@InjectMocks
	DWPAPIServiceImpl service;

	@BeforeEach
	public void init() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	public void test_getUsersForCity() {
		User user = new User();
		List<User> users = new ArrayList<>();
		users.add(user);

		when(mockRestTemplate.exchange(apiURL + "/city/London/users", HttpMethod.GET, null,
				new ParameterizedTypeReference<List<User>>() {
				})).thenReturn(new ResponseEntity<>(users, HttpStatus.OK));

		assertTrue(service.getUsersForCity("London").contains(user));
	}

	@Test
	public void test_getAllUsers() {
		User user = new User();
		List<User> users = new ArrayList<>();
		users.add(user);

		when(mockRestTemplate.exchange(apiURL + "/users", HttpMethod.GET, null,
				new ParameterizedTypeReference<List<User>>() {
				})).thenReturn(new ResponseEntity<>(users, HttpStatus.OK));

		assertTrue(service.getAllUsers().contains(user));
	}

	@Test
	public void getUsersInCoordinates() {
		User user = new User();
		List<User> users = new ArrayList<>();
		users.add(user);

		Coordinates[] coordinates = { new Coordinates(51.5074, -0.1278) };

		when(mockRestTemplate.exchange(apiURL + "/users", HttpMethod.GET, null,
				new ParameterizedTypeReference<List<User>>() {
				})).thenReturn(new ResponseEntity<>(users, HttpStatus.OK));

		when(mockRestTemplate.getForObject(openStreetMapURL + "London", Coordinates[].class)).thenReturn(coordinates);

		MockedStatic<DistanceUtils> distanceUtils = Mockito.mockStatic(DistanceUtils.class);

		distanceUtils.when(() -> DistanceUtils.calculateDistance(new Coordinates(51.5074, -0.1278),
				new Coordinates(51.5024, -0.1278))).thenReturn(40d);

		assertTrue(service.getUsersInCoordinates("London", 50d).contains(user));
	}
}
