package com.javaworm.designpattern.structural.bridge;

public abstract class Shape {
	protected CreateApi createApi;

	protected Shape(CreateApi createApi) {
		this.createApi = createApi;
	}

	public abstract void create();
}
