package com.javaworm.crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.reactive.function.BodyExtractors;
import org.springframework.web.reactive.function.BodyInserter;
import org.springframework.web.reactive.function.BodyInserters;
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
		return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(personRepository.findAll(),
				Person.class);
	}

	public Mono<ServerResponse> createPerson(ServerRequest request) {
		Mono<Person> person = request.bodyToMono(Person.class);
		return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(personRepository.saveAll(person),
				Person.class);
	}

	public Mono<ServerResponse> updatePerson(ServerRequest request) {
		Mono<Person> person = request.body(BodyExtractors.toMono(Person.class));
		Mono<Integer> personId = Mono.just(Integer.valueOf(request.pathVariable("id")));
		return personRepository.findById(personId).flatMap(p -> {
			Mono<Person> mp = Mono.just(p);
			mp = person;
			return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
					.body(personRepository.saveAll(mp), Person.class).switchIfEmpty(ServerResponse.notFound().build());
		});
	}

	public Mono<ServerResponse> deletePerson(ServerRequest request) {
		Mono<Integer> personId = Mono.just(Integer.valueOf(request.pathVariable("id")));
		return personRepository.findById(personId).flatMap(p -> {
			return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
					.body(personRepository.delete(p).thenReturn(p), Person.class)
					.switchIfEmpty(ServerResponse.notFound().build());
		});
	}
}