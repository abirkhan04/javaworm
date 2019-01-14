package com.javaworm.designpattern.structural.filter;

import java.util.ArrayList;
import java.util.List;

public class CriteriaPatternDemo {
	public static void main(String[] args) {
		List<Vehicle> vehicles = new ArrayList<Vehicle>();

		vehicles.add(new Vehicle("red", "2003", 2000));
		vehicles.add(new Vehicle("white", "2005", 3000));
		vehicles.add(new Vehicle("blue", "2007", 1000));
		vehicles.add(new Vehicle("white", "2015", 12000));
		vehicles.add(new Vehicle("green", "2016", 16000));
		vehicles.add(new Vehicle("yellow", "2018", 18000));

		Criteria red = new CriteriaRed();
		Criteria white = new CriteriaWhite();
		Criteria cheap = new CriteriaCheap();
		Criteria costly = new CriteriaCostly();

		System.out.println("Red: ");
		printVehicles(red.meetCriteria(vehicles));

		System.out.println("\nWhite: ");
		printVehicles(white.meetCriteria(vehicles));

		System.out.println("\nCheap Vehicle: ");
		printVehicles(cheap.meetCriteria(vehicles));

		System.out.println("\nCostly Vehicle: ");
		printVehicles(costly.meetCriteria(vehicles));
	}

	public static void printVehicles(List<Vehicle> vehicles) {

		for (Vehicle vehicle : vehicles) {
			System.out.println("Vahicle : [ Color : " + vehicle.getColor() + ", Model : " + vehicle.getModel()
					+ ", Price : " + vehicle.getPrice() + " ]");
		}
	}
}
