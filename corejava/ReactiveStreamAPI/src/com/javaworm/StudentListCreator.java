package com.javaworm;

import java.util.ArrayList;
import java.util.List;

public class StudentListCreator {
	
	public static List<Student> getStudents() {

		Student s1 = new Student(1, "A1");
		Student s2 = new Student(1, "A2");
		Student s3 = new Student(1, "A3");
		Student s4 = new Student(1, "A4");
		Student s5 = new Student(1, "A5");
		
		List<Student> students = new ArrayList<Student>();
		students.add(s1);
		students.add(s2);
		students.add(s3);
		students.add(s4);
		students.add(s5);
		
		return students;
	}

}
