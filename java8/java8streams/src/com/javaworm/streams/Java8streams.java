package com.javaworm.streams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Java8streams {

	List<Person> personList = new ArrayList<Person>();

	public ArrayList<Integer> sortListbyStream() {
		personList.add(new Person(1, "Abir", "HithStreet", "C"));
		personList.add(new Person(2, "Khan", "Second Street", "A"));
		personList.add(new Person(3, "Sumon", "Third Street", "C"));

		ArrayList<Integer> personListofIds = (ArrayList<Integer>) personList
				.stream().filter(t -> t.getGrade().equalsIgnoreCase("C"))
				.sorted(new SortById().reversed()).map(Person::getId)
				.collect(Collectors.toList());
		System.out.println("Size of ids: " + personListofIds.size());
		return personListofIds;
	}

	public static void main(String args[]) {
		Java8streams java8streams = new Java8streams();
		List<Integer> personIdList = java8streams.sortListbyStream();
		for (int i = 0; i < personIdList.size(); i++) {
			System.out.println("Person Id List:" + personIdList.get(i));
		}
	}

}

class SortById implements Comparator<Person> {

	@Override
	public int compare(Person o1, Person o2) {
		// TODO Auto-generated method stub
		return o1.getId() < o2.getId() ? -1 : o1.getId() > o2.getId() ? 1 : 0;
	}

}