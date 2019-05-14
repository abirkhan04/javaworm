package com.javaworm.springbootinmemoryauth.controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	
//	@Autowired
//  private UserDetailsService userService;

    @GetMapping("/")
    public String greeting(Authentication authentication) {
        return "Spring Security In-memory Authentication Example";
    }
}