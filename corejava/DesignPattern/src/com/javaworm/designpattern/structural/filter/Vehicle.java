package com.javaworm.designpattern.structural.filter;

public class Vehicle {

	private String color;
	private String model;
	private float price;

	public Vehicle(String color, String model, float price) {
		// TODO Auto-generated constructor stub
		this.color = color;
		this.model = model;
		this.price = price;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

}
