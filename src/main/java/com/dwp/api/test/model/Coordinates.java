package com.dwp.api.test.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Coordinates {
	@JsonProperty("lat")
	private double latitude;
	@JsonProperty("lon")
	private double longitude;
}
