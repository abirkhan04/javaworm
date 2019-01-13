package com.javaworm.designpattern.creational.factory;

public class CarFactory {

	   //use getShape method to get object of type shape 
	   public Car getCar(String carType){
	      if(carType == null){
	         return null;
	      }		
	      if(carType.equalsIgnoreCase("Hatchback")){
	         return new Hatchback();
	         
	      } else if(carType.equalsIgnoreCase("Sedan")){
	         return new Sedan();
	         
	      } else if(carType.equalsIgnoreCase("MPV")){
	         return new MPV();
	      }
	      
	      return null;
	   }
	
}
