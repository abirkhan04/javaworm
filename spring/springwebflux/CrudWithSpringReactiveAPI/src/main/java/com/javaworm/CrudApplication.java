package com.javaworm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

import com.javaworm.repository.PersonRepository;

@SpringBootApplication
@EnableReactiveMongoRepositories
public class CrudApplication {

	@Autowired
	PersonRepository personRepository;

	public static void main(String[] args) {
		SpringApplication.run(CrudApplication.class, args);
	}
}
