package com.javaworm.designpattern.creational.factory;

public class FactoryPatternDemo{
	
	public static void main(String[] args){
		      CarFactory carFactory = new CarFactory();

		      //get an object of Circle and call its draw method.
		      Car car1 = carFactory.getCar("Hatchback");

		      //call draw method of Circle
		      car1.create();

		      Car car2 = carFactory.getCar("Sedan");

		      //call draw method of Circle
		      car2.create();

		      //get an object of Square and call its draw method.
		      Car car3 = carFactory.getCar("MPV");

		      //call draw method of square
		      car3.create();
		   }
}
