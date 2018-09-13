package com.javaworm.springbootdatajpa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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

	  
	public String insertCustomer(String firstName, String lastName) {
		Customer customer = new Customer(firstName, lastName);
		customerRepository.save(customer);		
		return "Customer is Successfully Started";
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
}