package com.javaworm.designpattern.structural.bridge;

public class BridgePatternDemo {
	public static void main(String[] args) {
		Shape Circle = new Circle(new CreateCircle());
		Shape Rectangle = new Rectangle(new CreateRectangle());

		Circle.create();
		Rectangle.create();
	}
}
