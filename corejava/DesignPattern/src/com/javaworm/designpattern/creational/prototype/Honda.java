package com.javaworm.designpattern.creational.prototype;

public class Honda extends Car {

	public Honda(){
		     name = "Honda";
		 }

	@Override
	public void display() {
		System.out.println(name+" is displayed");
	}

}
