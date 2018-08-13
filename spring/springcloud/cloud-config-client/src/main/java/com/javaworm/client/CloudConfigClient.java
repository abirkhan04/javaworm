package com.javaworm.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class CloudConfigClient {

	public static void main(String[] args) {
		SpringApplication.run(CloudConfigClient.class, args);
	}

}
