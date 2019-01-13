package com.javaworm.designpattern.creational.builder;

public abstract class Bike implements Vehicle {

	@Override
	public Engine engine() {
		// TODO Auto-generated method stub
		return new PetrolEngine();
	}

	public abstract float price();

}
