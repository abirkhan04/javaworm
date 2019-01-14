package com.javaworm.designpattern.structural.filter;

import java.util.ArrayList;
import java.util.List;

public class CriteriaRed implements Criteria {

	@Override
	public List<Vehicle> meetCriteria(List<Vehicle> vehicles) {
		List<Vehicle> redVehicles = new ArrayList<Vehicle>();

		for (Vehicle vehicle : vehicles) {
			if (vehicle.getColor().equalsIgnoreCase("red")) {
				redVehicles.add(vehicle);
			}
		}
		return redVehicles;
	}
}
