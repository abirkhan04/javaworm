package com.javaworm.designpattern.creational.abstractfactory;

public class HomeFactory extends AbstractFactory {

	@Override
	Vehicle getVehicle(String vehicleType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	Home getHome(String homeType) {
		// TODO Auto-generated method stub
		if (homeType == null) {
			return null;
		}
		if (homeType.equalsIgnoreCase("owned")) {
			return new OwnHome();
		} else if (homeType.equalsIgnoreCase("rented")) {
			return new RentedHome();
		}
		return null;
	}
}
