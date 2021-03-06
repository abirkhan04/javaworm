package com.javaworm.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Persons")
public class Person {
	/**
	 *
	 */
	@Id
	private String id;
	private String name;
	private String age;

	public Person() {

	}

	public Person(String name, String age) {
		this.name = name;
		this.age = age;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Users [id=" + id + ", name=" + name + ", age=" + age + "]";
	}
	
}
