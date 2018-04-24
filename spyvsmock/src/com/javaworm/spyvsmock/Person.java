package com.javaworm.spyvsmock;

public class Person {

	private String firstName ;
	private String lastName;
	private Integer age;


	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	@SuppressWarnings("unused")
	private String fullName(String firstName, String lastName){
		System.out.println("Full Name: " +firstName+lastName);	
		return firstName+lastName;		
	}

}
