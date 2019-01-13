package com.javaworm.designpattern.creational.builder;

public abstract class Car implements Vehicle {

	@Override
	public Engine engine() {
		return new GasEngine();
	}

	public abstract float price();
}
