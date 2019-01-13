package com.javaworm.designpattern.creational.abstractfactory;

public class RentedHome implements Home{

	@Override
	public void type() {
		System.out.println("This is Rented Home");
	}
}