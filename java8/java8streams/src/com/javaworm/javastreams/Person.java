package com.javaworm.javastreams;

public class Person {

	public Integer Id;

	public String name;

	public String address;

	public String grade;

	public Person(Integer id, String name, String address, String grade) {
		this.Id = id;
		this.name = name;
		this.address = address;
		this.grade = grade;
	}

	public Integer getId() {
		return Id;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
