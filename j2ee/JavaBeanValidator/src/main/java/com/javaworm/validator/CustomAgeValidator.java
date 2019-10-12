package com.javaworm.validator;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


public class CustomAgeValidator implements ConstraintValidator<Age, LocalDate>{

	protected long minimumValidAge;
	
	public void initialize(Age ageValue) {
		this.minimumValidAge = ageValue.value();
	}
	
	public boolean isValid(LocalDate localDate, ConstraintValidatorContext context) {
		// TODO Auto-generated method stub
	      // null values are valid
        if ( localDate == null ) {
            return true;
        }
        LocalDate today = LocalDate.now();
        return ChronoUnit.YEARS.between(localDate, today)>= minimumValidAge;
	}
	
}
