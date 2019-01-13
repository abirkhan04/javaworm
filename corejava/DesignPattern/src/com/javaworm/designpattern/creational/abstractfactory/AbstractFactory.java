package com.javaworm.designpattern.creational.abstractfactory;

public abstract class AbstractFactory {
	   abstract Vehicle getVehicle(String vehicleType);
	   abstract Home getHome(String homeType);
}
