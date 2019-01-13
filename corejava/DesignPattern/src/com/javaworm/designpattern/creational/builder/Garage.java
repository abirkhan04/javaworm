package com.javaworm.designpattern.creational.builder;

import java.util.ArrayList;
import java.util.List;

public class Garage {

	private List<Vehicle> vehiclelist = new ArrayList<Vehicle>();

	public void addVehicle(Vehicle vehicle) {
		vehiclelist.add(vehicle);
	}

	public float getCost() {
		float cost = 0.0f;

		for (Vehicle item : vehiclelist) {
			cost += item.price();
		}
		return cost;
	}

	public void showItems() {

		for (Vehicle item : vehiclelist) {
			System.out.print("Vehicle : " + item.name());
			System.out.print("Vehicle Body : " + item.Body());
			System.out.print(", Body color : " + item.bodyColor());
			System.out.println(", Price : " + item.price());
		}
	}
}
