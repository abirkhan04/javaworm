package com.javaworm.designpattern.creational.prototype;


import java.util.Hashtable;

public class CarCache {

	private static Hashtable<String, Car> carMap = new Hashtable<String, Car>();

	public static Car getCar(String carId) {
		Car cachedCar = carMap.get(carId);
		return (Car) cachedCar.clone();
	}

	public static void loadCache() {
		Toyota t1 = new Toyota();
		t1.setId("1");
		carMap.put(t1.getId(), t1);

		Honda h1 = new Honda();
		h1.setId("2");
		carMap.put(h1.getId(), h1);

	}

}
