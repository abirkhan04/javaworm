package com.javaworm.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import com.javaworm.entity.Persons;

public interface PersonRepository extends ReactiveMongoRepository<Persons, Integer>{

}
