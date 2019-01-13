package com.javaworm.designpattern.creational.abstractfactory;

public class FactoryProducer {

	public static AbstractFactory getFactory(String choice) {

		if (choice.equalsIgnoreCase("Vehicle")) {
			return new VehicleFactory();

		} else if (choice.equalsIgnoreCase("Home")) {
			return new HomeFactory();
		}

		return null;
	}
}
