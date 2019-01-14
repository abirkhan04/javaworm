package com.javaworm.designpattern.structural.filter;

import java.util.List;

public interface Criteria {
	public List<Vehicle> meetCriteria(List<Vehicle> vehicles);
}
