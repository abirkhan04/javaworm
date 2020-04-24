package com.javaworm.javastreams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FlatMapExample {
	public static void main(String args[]) {
		String[][] multiDimentionalArray = new String[][] { { "a", "b" }, { "c", "d" }, { "e", "f" } };
		Stream<String[]> streamOfStringArray = Arrays.stream(multiDimentionalArray);
		Stream<String[]> stream = streamOfStringArray.filter(x -> "c".equals(x));
		stream.forEach((item) -> {
			System.out.println("No item will be printed-->" + item);
		});
		Stream<String> streamOfString = Arrays.stream(multiDimentionalArray).flatMap((item) -> Arrays.stream(item));
		Stream<String> flatStream = streamOfString.filter((x) -> "c".equals(x));
		flatStream.forEach((item) -> {
			System.out.println("An item will be printed -->" + item);
		});

		// Flat map with set ........
		Teacher teacher1 = new Teacher("Abir");
		teacher1.addCourse("course 1");
		teacher1.addCourse("course 2");
		teacher1.addCourse("course 3");

		Teacher teacher2 = new Teacher("Khan");
		teacher2.addCourse("course 1");
		teacher2.addCourse("course 2");
		teacher2.addCourse("course 4");

		List<Teacher> teacherList = new ArrayList<Teacher>();
		teacherList.add(teacher1);
		teacherList.add(teacher2);

		List<String> collectCourses = teacherList.stream().map(item -> item.getCourse()).flatMap(x -> x.stream())
				.distinct().collect(Collectors.toList());
		collectCourses.forEach((item) -> {
			System.out.println("Item here" + item);
		});
	}
}
