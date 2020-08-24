package com.dwp.api.test.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class User {
	@JsonProperty("id")
	private Integer id;
	@JsonProperty("first_name")
	private String firstName;
	@JsonProperty("last_name")
	private String lastName;
	@JsonProperty("email")
	private String email;
	@JsonProperty("ip_address")
	private String ipAddress;
	@JsonProperty("latitude")
    private double latitude;
	@JsonProperty("longitude")
    private double longitude;
}
