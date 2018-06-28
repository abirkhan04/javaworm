package com.javaworm.oauth2client.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Oauth2ClientController {

	@GetMapping("/")
	@ResponseBody
	public String helloFromJavaworm() {
		return "Hi, I am from javaworm.com!";
	}
	
	@GetMapping("/callback")
	@ResponseBody
	public String securedUrl() {
		return "This url is secured.";
	}
	
	
	
	

}
