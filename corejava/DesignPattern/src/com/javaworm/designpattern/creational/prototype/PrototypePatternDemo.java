package com.javaworm.designpattern.creational.prototype;

public class PrototypePatternDemo {
	public static void main(String[] args) {
		CarCache.loadCache();

		Car clonedCar1 = (Car) CarCache.getCar("1");
		System.out.println("Car : " + clonedCar1.getName());

		Car clonedCar2 = (Car) CarCache.getCar("2");
		System.out.println("Car : " + clonedCar2.getName());
	}
}
