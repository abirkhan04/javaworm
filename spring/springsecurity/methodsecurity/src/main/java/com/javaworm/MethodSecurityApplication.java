package com.javaworm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class }, scanBasePackages = "com.javaworm")
public class MethodSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(MethodSecurityApplication.class, args);
	}
}
