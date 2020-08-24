package com.dwp.api.test.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.dwp.api.test.model.User;
import com.dwp.api.test.service.DWPAPIService;

public class DWPAPIControllerTest {
	@InjectMocks
	DWPAPIController controller;

	@Mock
	DWPAPIService service;

	@BeforeEach
	public void init() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	public void test_getUsersForCity() {
		User user = new User();
		List<User> users = new ArrayList<>();
		users.add(user);
		when(service.getUsersForCity("London")).thenReturn(users);
		assertEquals(1, controller.getUsersForCity("London").size());
	}

	@Test
	public void test_getAllUsers() {
		User user = new User();
		List<User> users = new ArrayList<>();
		users.add(user);

		when(service.getAllUsers()).thenReturn(users);
		assertEquals(1, controller.getAllUsers().size());
	}

	@Test
	public void getUsersInCoordinates() {
		User user = new User();
		List<User> users = new ArrayList<>();
		users.add(user);

		when(service.getUsersInCoordinates("London", 50d)).thenReturn(users);
		assertEquals(1, controller.getUsersInCoordinates("London", 50d).size());
	}

}
