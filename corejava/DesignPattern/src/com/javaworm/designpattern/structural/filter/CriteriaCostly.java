package com.javaworm.designpattern.structural.filter;

import java.util.ArrayList;
import java.util.List;

public class CriteriaCostly implements Criteria {

	@Override
	public List<Vehicle> meetCriteria(List<Vehicle> vehicles) {
		List<Vehicle> costlyVehicles = new ArrayList<Vehicle>();

		for (Vehicle vehicle : vehicles) {
			if (vehicle.getPrice() > 10000) {
				costlyVehicles.add(vehicle);
			}
		}
		return costlyVehicles;
	}
}
