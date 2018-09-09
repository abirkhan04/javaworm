package com.javaworm.repository;

import org.springframework.data.repository.CrudRepository;

import com.javaworm.model.Vehicle;


public interface VehicleRepository<V> extends CrudRepository<Vehicle, Long>{
}
