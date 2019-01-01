package com.javaworm.crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.javaworm.entity.Person;
import com.javaworm.repository.PersonRepository;

import reactor.core.publisher.Mono;


@Component
public class CRUDHandler {
		
	
	@Autowired
	PersonRepository personRepository;
	
		
	public Mono<ServerResponse> listAllPersons(ServerRequest request) {
		return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
				.body(personRepository.findAll(), Person.class);
	}
	
	
	public Mono<ServerResponse> createPerson(ServerRequest request) {
		 Mono<Person> person = request.bodyToMono(Person.class);
		 return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
					.body( personRepository.saveAll(person), Person.class);
	}
}