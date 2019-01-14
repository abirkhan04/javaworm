package com.javaworm.designpattern.creational.prototype;

public class Toyota extends Car {

	public Toyota() {
		name = "Toyota";
	}

	@Override
	void display() {
		// TODO Auto-generated method stub
		System.out.println(name + " is displayed");
	}

}