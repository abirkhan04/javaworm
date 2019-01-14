package com.javaworm.designpattern.structural.adapter;

public class AdapterPatternDemo {
	public static void main(String[] args) {
		PickColor pickColor = new PickColor();

		pickColor.pickColor("blue");
		pickColor.pickColor("red");
		pickColor.pickColor("green");
		pickColor.pickColor("white");
	}
}