package beanvalidation;

import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


public class BeanValidator {
	
	public static Log log = LogFactory.getLog(BeanValidator.class);
	
	public static void validateStudent(Student student) {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		javax.validation.Validator validator = factory.getValidator();
		Set<ConstraintViolation<Student>> violations = validator.validate(student);
		for (ConstraintViolation<Student> violation : violations) {
		    log.error(violation.getMessage());
		}
	}	
	
	public static void main(String args[]){
		Student student = new Student();
		student.setStudying(true);
		student.setAboutMe("Its all about me!");
		student.setAge(31);
		validateStudent(student);
	}

}
