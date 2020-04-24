package com.javaworm.javastreams;

import java.util.HashSet;
import java.util.Set;

public class Teacher {

	private String name;
	private Set<String> course;

	public Teacher(String name) {
		this.name = name;
	}

	public void addCourse(String courseName) {
		if (this.course == null) {
			this.course = new HashSet<String>();
		}
		this.course.add(courseName);
	}

	public String getName() {
		return name;
	}

	public Set<String> getCourse() {
		return course;
	}

	public void setCourse(Set<String> course) {
		this.course = course;
	}

	public void setName(String name) {
		this.name = name;
	}

}
