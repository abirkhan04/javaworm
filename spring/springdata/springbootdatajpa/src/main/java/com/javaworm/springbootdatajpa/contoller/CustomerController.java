package com.javaworm.springbootdatajpa.contoller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.javaworm.springbootdatajpa.model.Customer;
import com.javaworm.springbootdatajpa.service.CustomerService;




@RestController
public class CustomerController {
     
	
	@Autowired
	CustomerService customerService;
	
	@RequestMapping(value = "/allcustomer", method = RequestMethod.GET)
	public @ResponseBody List<Customer> getAllCustomer() {
		return customerService.findAllCustomer();
	}
	
	@RequestMapping(value = "/insertcustomer/{fna"
			+ "me}/{lname}", method = RequestMethod.GET)
	public @ResponseBody String insertCustomer(@PathVariable("fname") String firstName,
			@PathVariable("lname") String lastName) {
		return customerService.insertCustomer(firstName, lastName);
	}
	
	@RequestMapping(value = "/updatecustomer/{id}/{fname}/{lname}", method = RequestMethod.GET)
	public @ResponseBody String updateCustomer(@PathVariable("id") String Id,
			@PathVariable("fname") String fname, @PathVariable("lname") String lname) {
		
		
		Optional<Customer> customerOptional = customerService.finById(Id);
		System.out.println("Id"+Id);
		if(customerOptional.isPresent()){
		  Customer customer = customerOptional.get();
		
		  customer.setFirstName(fname);
		  customer.setLastName(lname);
		  return customerService.updateCustomer(customer);
		}else{
			return "Customer Not Found";
		}
	}
	
	
	@RequestMapping(value = "/deletecustomer/{id}", method = RequestMethod.GET)
	public @ResponseBody String updateCustomer(@PathVariable("id") String Id) {
		
		
		Optional<Customer> customerOptional = customerService.finById(Id);
		System.out.println("Id"+Id);
		if(customerOptional.isPresent()){
		  Customer customer = customerOptional.get();
		  return customerService.deleteCustomer(customer);
		}else{
			return "Customer Not Found";
		}
	}
}