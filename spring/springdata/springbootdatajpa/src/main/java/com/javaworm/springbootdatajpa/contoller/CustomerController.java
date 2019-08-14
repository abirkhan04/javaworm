package com.javaworm.springbootdatajpa.contoller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.javaworm.springbootdatajpa.model.Customer;
import com.javaworm.springbootdatajpa.service.CustomerService;


@RestController
public class CustomerController {
     
	
	@Autowired
	CustomerService customerService;
	
	@CacheEvict(value = "customers", allEntries = true)
	@RequestMapping(value = "/allcustomer", method = RequestMethod.GET)
	public @ResponseBody List<Customer> getAllCustomer() {
		System.out.println("Invoked");
		return customerService.findAllCustomer();
	}
	
	@RequestMapping(value = "/insertcustomer", method = RequestMethod.POST)
	public @ResponseBody String insertCustomer(@RequestBody Customer customer) {
		System.out.println("customer-->"+customer.getFirstName());
		return customerService.insertCustomer(customer);
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
	
	@Cacheable("customers")
	@RequestMapping(value = "/findcustomerbyname/{firstname}/{lastname}", method = RequestMethod.GET)
	public @ResponseBody List<Customer> getCustomerByName(@PathVariable("firstname") String firstName, @PathVariable("lastname") String lastName) {
		deliberateSlowingOfService(3000L);
		return customerService.findCustomerByName(firstName, lastName);
	}
	
	@Cacheable("Number")
	private Integer getFixedNumber() {
		return 10;
	}
	
	private void deliberateSlowingOfService(Long time){
    	try {
    		System.out.println("Inside slowering");
    		Thread.sleep(time);
    	}catch(InterruptedException e) {
             throw new IllegalStateException(e);    		
    	}
    }

}
