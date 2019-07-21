package com.javaworm.model;

public class Furniture {

    private String name;
    private String price;

    public Furniture(String name, String price) {
    	this.name = name;
    	this.price = price;
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

}