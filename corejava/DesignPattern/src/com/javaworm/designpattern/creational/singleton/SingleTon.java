package com.javaworm.designpattern.creational.singleton;

public class SingleTon {

	private static SingleTon object = new SingleTon();

	private SingleTon() {
	}

	public static SingleTon getObject() {
		return object;
	}

	public void dothetask() {
		System.out.println("Singleton is doing its task");
	}
}
