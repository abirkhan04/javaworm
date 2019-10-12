package BeanValidationTest;

import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.Before;
import org.junit.Test;

import com.javaworm.model.Person;

public class PersonTest {
	
	private Validator validator;
		
	Person person;
	
	@Before
	public void setUp() throws Exception{
		  person = new Person();
	      ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
	      validator = factory.getValidator();
	}
	
	
	@Test 
	public void isValidBirthDate() {
		 person.setBirthDate(LocalDate.of(1987,8,4));
	     Set<ConstraintViolation<Person>> violations = validator.validate(person);
	     assertTrue(violations.isEmpty());
	}
	
}
