package com.javaworm.springbootdatajpa.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.Cacheable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.javaworm.springbootdatajpa.model.Customer;
import com.javaworm.springbootdatajpa.repository.CustomerRepository;

@Service
public class CustomerService {

	 @Autowired
	 CustomerRepository customerRepository;
	 	 
	 public List<Customer> findAllCustomer(){
		return (List<Customer>) customerRepository.findAll();
	 }

	  
	public String insertCustomer(Customer customer) {
		customerRepository.save(customer);		
		return "Customer is Successfully inserted";
	}


	public Optional<Customer> finById(String Id) {
		Long id = Long.valueOf(Id);
		return customerRepository.findById(id);
	}

	public String updateCustomer(Customer customer) {
		customerRepository.save(customer);
		return "Customer is successfully updated.";
	}

	public String deleteCustomer(Customer customer) {
		customerRepository.delete(customer);
		return "Customer is successfully deleted.";
	}


	public List<Customer> findCustomerByName(String firstName, String lastName) {
    	return customerRepository.findByFirstNameAndLastName(firstName, lastName);
    }
    
}