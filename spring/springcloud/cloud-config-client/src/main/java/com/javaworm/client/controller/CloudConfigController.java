package com.javaworm.client.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CloudConfigController {
	
	
	 @Value("${user.role}")
	 private String role;
	
	
	 @RequestMapping(
	 value = "/javaworm/{name}", 
	 method = RequestMethod.GET, 
	 produces = MediaType.TEXT_PLAIN_VALUE)
	 public String role(@PathVariable("name") String username) {
	        return String.format("Hello!  You're %s and you are a(n) %s...\n", username, role);
	    }
	 
	  @Value("${config.name}")
	  String name = "World";

	  @RequestMapping("/")
	  public String home() {
	    return "Hello " + name;
	  }

}