package com.javaworm.designpattern.structural.adapter;

public class GreenColor implements AdvancedColorPicker {

	@Override
	public void pickRedColor(String colorName) {
		// TODO Auto-generated method stub

	}

	@Override
	public void pickGreenColor(String colorName) {
		// TODO Auto-generated method stub
		System.out.println("Picking Green Color");
	}

}
