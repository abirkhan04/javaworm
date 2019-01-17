package com.javaworm.designpattern.structural.bridge;

public class Rectangle extends Shape {

	protected Rectangle(CreateApi createApi) {
		super(createApi);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void create() {
		// TODO Auto-generated method stub
		System.out.println("Rectangle is created.");
	}

}
