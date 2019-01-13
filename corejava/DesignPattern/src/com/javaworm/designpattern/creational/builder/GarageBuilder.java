package com.javaworm.designpattern.creational.builder;

public class GarageBuilder {

	public Garage PrepareMyGarage() {
		Garage garage = new Garage();
		garage.addVehicle(new Cruiser());
		garage.addVehicle(new Cruiser());
		garage.addVehicle(new ToyotaCorolla());

		return garage;
	}

}
