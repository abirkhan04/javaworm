package com.javaworm.controller

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestMapping

@RestController
@RequestMapping("/api")
public class SecuredRestController {
	
	@GetMapping("/test")
	fun testSecurity():String {
		return "Testing API Security"
	}

}