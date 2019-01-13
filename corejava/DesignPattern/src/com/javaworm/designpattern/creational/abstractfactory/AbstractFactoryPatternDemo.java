package com.javaworm.designpattern.creational.abstractfactory;

public class AbstractFactoryPatternDemo {
	public static void main(String[] args) {

		// get shape factory
		AbstractFactory vehicleFactory = FactoryProducer.getFactory("Vehicle");

		// get an object of Shape Circle
		Vehicle vehicle1 = vehicleFactory.getVehicle("bike");

		// call draw method of Shape Circle
		vehicle1.create();

		// get an object of Shape Rectangle
		Vehicle vehicle2 = vehicleFactory.getVehicle("boat");

		// call draw method of Shape Circle
		vehicle2.create();

		// get color factory
		AbstractFactory homeFactory = FactoryProducer.getFactory("home");

		// get an object of Color Red
		Home home1 = homeFactory.getHome("owned");

		// call fill method of Red
		home1.type();

		// get an object of Color Green
		Home home2 = homeFactory.getHome("rented");

		// call fill method of Green
		home2.type();

	}
}