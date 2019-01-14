package com.javaworm.designpattern.structural.adapter;

public class PickColor implements ColorPicker {

	ColorPickerAdapter colorPickerAdapter;

	@Override
	public void pickColor(String colorType) {
		// TODO Auto-generated method stub
		if (colorType.equalsIgnoreCase("blue")) {
			System.out.println("Picking Blue Color");
		} else if (colorType.equalsIgnoreCase("red") || colorType.equalsIgnoreCase("green")) {
			colorPickerAdapter = new ColorPickerAdapter(colorType);
			colorPickerAdapter.pickColor(colorType);
		} else {
			System.out.println("Invalid Color");
		}
	}

}
