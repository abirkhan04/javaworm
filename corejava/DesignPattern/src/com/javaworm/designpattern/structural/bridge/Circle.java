package com.javaworm.designpattern.structural.bridge;

public class Circle extends Shape{

	protected Circle(CreateApi createApi){
		super(createApi);
	}

	@Override
	public void create() {
		// TODO Auto-generated method stub
		createApi.createShape();
	}

}
