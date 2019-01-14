package com.javaworm.designpattern.structural.filter;

import java.util.ArrayList;
import java.util.List;

public class CriteriaWhite implements Criteria {

	@Override
	public List<Vehicle> meetCriteria(List<Vehicle> vehicles) {
		List<Vehicle> whiteVehicles = new ArrayList<Vehicle>();

		for (Vehicle vehicle : vehicles) {
			if (vehicle.getColor().equalsIgnoreCase("white")) {
				whiteVehicles.add(vehicle);
			}
		}
		return whiteVehicles;
	}

}
