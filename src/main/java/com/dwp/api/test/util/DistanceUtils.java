package com.dwp.api.test.util;

import com.dwp.api.test.model.Coordinates;

public class DistanceUtils {
	public static double calculateDistance(Coordinates userCoordinates, Coordinates cityCoordinates) {
		if ((userCoordinates.getLatitude() == cityCoordinates.getLatitude())
				&& (userCoordinates.getLongitude() == cityCoordinates.getLongitude())) {
			return 0;
		}
		double longitude = userCoordinates.getLongitude() - cityCoordinates.getLongitude();
		double distance = Math.sin(Math.toRadians(userCoordinates.getLatitude()))
				* Math.sin(Math.toRadians(cityCoordinates.getLatitude()))
				+ Math.cos(Math.toRadians(userCoordinates.getLatitude()))
						* Math.cos(Math.toRadians(cityCoordinates.getLatitude())) * Math.cos(Math.toRadians(longitude));
		distance = Math.acos(distance);
		distance = Math.toDegrees(distance);
		distance = distance * 60 * 1.1515;

		return distance;

	}
}
