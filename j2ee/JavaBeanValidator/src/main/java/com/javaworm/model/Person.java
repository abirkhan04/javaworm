package com.javaworm.model;

import java.time.LocalDate;
import java.util.Date;

import com.javaworm.validator.Age;

public class Person {

	@Age(value=18) 
	private LocalDate birthDate;

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

    

}
