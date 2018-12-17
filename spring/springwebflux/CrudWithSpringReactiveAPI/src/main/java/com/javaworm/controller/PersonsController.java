package com.javaworm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javaworm.entity.Person;
import com.javaworm.repository.PersonRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/persons")
public class PersonsController {

	@Autowired
	PersonRepository personRepository;

	@GetMapping
	public Flux<Person> getAllUser() {
		return personRepository.findAll();
	}

	@PostMapping
	public Mono<Person> createUser(@RequestBody Person person) {
		return personRepository.save(person);
	}

	@GetMapping("/{id}")
	public Mono<ResponseEntity<Person>> getUserById(@PathVariable(value = "id") int userId) {
		return personRepository.findById(userId).map(savedTweet -> ResponseEntity.ok(savedTweet))
				.defaultIfEmpty(ResponseEntity.notFound().build());
	}

	@PutMapping("/{id}")
	public Mono<Person> updateUserById(@RequestBody Person person, @PathVariable(value = "id") int userId) {
		person.setId(userId);
		return personRepository.save(person);
	}

	@DeleteMapping("/{id}")
	public Mono<Void> deleteUserById(@PathVariable(value = "id") int userId) {
		Person person = new Person();
		person.setId(userId);
		return personRepository.delete(person);
	}
}
