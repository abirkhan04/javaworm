package com.javaworm.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.javaworm.entity.Person;

public interface PersonRepository extends ReactiveMongoRepository<Person, Integer>{

}
