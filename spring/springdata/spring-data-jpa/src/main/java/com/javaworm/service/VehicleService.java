package com.javaworm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.javaworm.model.Vehicle;
import com.javaworm.repository.VehicleRepository;

@Service
public class VehicleService {
	
	@Autowired
	VehicleRepository<Vehicle> vehicleRepository;
	
	
	@Transactional
	public List<Vehicle> getAllVehicles() {
		return (List<Vehicle>) vehicleRepository.findAll();
	}
}


