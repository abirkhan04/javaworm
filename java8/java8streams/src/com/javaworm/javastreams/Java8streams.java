package com.javaworm.javastreams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Java8streams {

	List<Integer> listofNumbers = Arrays.asList(1, 2, 3, 4, 5, 5, 6, 6, 7, 8,
			8, 9);
	static List<Person> personList = new ArrayList<Person>();
	static {
		personList.add(new Person(1, "Abir", "HithStreet", "C"));
		personList.add(new Person(2, "Khan", "Second Street", "A"));
		personList.add(new Person(3, "Sumon", "Third Street", "C"));
	}

	// Example of an stream operation
	public ArrayList<Integer> sortListbyStream() {
		ArrayList<Integer> personListofIds = (ArrayList<Integer>) personList
				.stream().filter(t -> t.getGrade().equalsIgnoreCase("C"))
				.sorted(new SortById().reversed()).map(Person::getId)
				.collect(Collectors.toList());
		return personListofIds;
	}

	// Use of distinct
	public List<Integer> collectDistinctNumbers() {

		List<Integer> distinctlistofNumbers = listofNumbers.stream().distinct()
				.limit(5).skip(2).collect(Collectors.toList());
		return distinctlistofNumbers;
	}

	// Finding Matching element
	public Boolean isNumberGreaterThanANumber() {
		Boolean x = listofNumbers.stream().allMatch(t -> t > 100);
		return x;
	}

	// Use of find first and find any
	public void findFirstAndAnyDemo() {
		listofNumbers.stream().filter(t -> t > 10).findFirst()
				.ifPresent(System.out::println);
	}

	public static void main(String args[]) {
		Java8streams java8streams = new Java8streams();
		List<Integer> personIdList = java8streams.sortListbyStream();
		List<Integer> distinctlistofNumbers = java8streams
				.collectDistinctNumbers();
		for (int i = 0; i < personIdList.size(); i++) {
			System.out.println("Person Id List:" + personIdList.get(i));
		}

		for (int i = 0; i < distinctlistofNumbers.size(); i++) {
			System.out.println("Number List:" + distinctlistofNumbers.get(i));
		}

		System.out.println(java8streams.isNumberGreaterThanANumber());
		java8streams.findFirstAndAnyDemo();
	}

}

class SortById implements Comparator<Person> {
	@Override
	public int compare(Person o1, Person o2) {
		// TODO Auto-generated method stub
		return o1.getId() < o2.getId() ? -1 : o1.getId() > o2.getId() ? 1 : 0;
	}

}