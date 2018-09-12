package com.javaworm.springbootdatajpa.repository;

import org.springframework.data.repository.CrudRepository;
import com.javaworm.springbootdatajpa.model.Customer;



public interface CustomerRepository extends CrudRepository<Customer, Long>{
    	
}
