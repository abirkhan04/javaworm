package com.javaworm.designpattern.structural.adapter;

public class ColorPickerAdapter implements ColorPicker {

	AdvancedColorPicker advancedColorPicker;

	public ColorPickerAdapter(String colorName) {

		if (colorName.equalsIgnoreCase("red")) {
			advancedColorPicker = new RedColor();
		}

		if (colorName.equalsIgnoreCase("green")) {
			advancedColorPicker = new GreenColor();
		}

	}

	@Override
	public void pickColor(String colorType) {
		// TODO Auto-generated method stub
		if (colorType.equalsIgnoreCase("red")) {
			advancedColorPicker.pickRedColor(colorType);
			;
		}

		if (colorType.equalsIgnoreCase("green")) {
			advancedColorPicker.pickGreenColor(colorType);
		}
	}

}
