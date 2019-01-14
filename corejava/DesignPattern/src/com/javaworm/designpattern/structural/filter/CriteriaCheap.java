package com.javaworm.designpattern.structural.filter;

import java.util.ArrayList;
import java.util.List;

public class CriteriaCheap implements Criteria {

	@Override
	public List<Vehicle> meetCriteria(List<Vehicle> vehicles) {
		List<Vehicle> cheapVehicles = new ArrayList<Vehicle>();

		for (Vehicle vehicle : vehicles) {
			if (vehicle.getPrice() < 10000) {
				cheapVehicles.add(vehicle);
			}
		}
		return cheapVehicles;
	}
}
