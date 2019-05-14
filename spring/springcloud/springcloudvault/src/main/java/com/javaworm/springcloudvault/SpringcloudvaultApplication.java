package com.javaworm.springcloudvault;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@SpringBootApplication
public class SpringcloudvaultApplication {

	  @Value("${config.name}")
	  String name = "World";

	  @RequestMapping("/")
	  public String home() {
	    return "Hello " + name;
	  }
		
	  public static void main(String[] args) {
		SpringApplication.run(SpringcloudvaultApplication.class, args);
	  }
}