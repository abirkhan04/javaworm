package com.javaworm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javaworm.entity.Persons;
import com.javaworm.repository.PersonRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/persons")
public class PersonsController {

	@Autowired
	PersonRepository personRepository;

	@GetMapping
	public Flux<Persons> getAllUser() {
		return personRepository.findAll();
	}

	@PostMapping
	public Mono<Persons> createUser(@RequestBody Persons person) {
		return personRepository.save(person);
	}

	@GetMapping("/{id}")
	public Mono<ResponseEntity<Persons>> getUserById(@PathVariable(value = "id") int userId) {
		return personRepository.findById(userId).map(savedTweet -> ResponseEntity.ok(savedTweet))
				.defaultIfEmpty(ResponseEntity.notFound().build());
	}
}
