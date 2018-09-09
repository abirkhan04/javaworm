package com.javaworm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.javaworm.model.Vehicle;
import com.javaworm.service.VehicleService;


@RestController
public class VehicleController {
	
	@Autowired
	VehicleService vehicleService;

	@RequestMapping(value = "/allvehicle", method = RequestMethod.GET)
	public @ResponseBody List<Vehicle> getAllVehicles() {
		return vehicleService.getAllVehicles();
	}
	
	

}