package com.javaworm.designpattern.creational.builder;

public class BuilderPatternDemo {

	public static void main(String[] args) {

		GarageBuilder garageBuilder = new GarageBuilder();

		Garage myGarage = garageBuilder.PrepareMyGarage();
		System.out.println("My Garage");
		myGarage.showItems();
		System.out.println("Total Cost: " + myGarage.getCost());

	}
}
