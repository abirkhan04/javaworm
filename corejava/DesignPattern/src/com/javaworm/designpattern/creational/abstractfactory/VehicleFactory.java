package com.javaworm.designpattern.creational.abstractfactory;

public class VehicleFactory extends AbstractFactory {

	@Override
	Vehicle getVehicle(String vehicleType) {
		// TODO Auto-generated method stub
		if (vehicleType == null) {
			return null;
		}

		if (vehicleType.equalsIgnoreCase("bike")) {
			return new Bike();

		} else if (vehicleType.equalsIgnoreCase("boat")) {
			return new Boat();

		} else if (vehicleType.equalsIgnoreCase("plane")) {
			return new Plane();
		}

		return null;
	}

	@Override
	Home getHome(String homeType) {
		// TODO Auto-generated method stub
		return null;
	}

}
