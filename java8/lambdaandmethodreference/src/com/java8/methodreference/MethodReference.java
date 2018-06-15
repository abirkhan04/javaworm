package com.java8.methodreference;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MethodReference {

    List<Person> roster = Person.createRoster();
    Person[] rosterArray = roster.toArray(new Person[roster.size()]);

    public boolean traditionalSort() {
        // Traditional implementation of comparator
        class PersonAgeComparator implements Comparator<Person> {
            public int compare(Person a, Person b) {
                return a.getBirthday()
                    .compareTo(b.getBirthday());
            }
        }

        Arrays.sort(rosterArray, new PersonAgeComparator());

        return rosterArray[0].getAge() > rosterArray[1].getAge();
    }

    public boolean lambdaSort() {
        Arrays.sort(rosterArray, (a, b) -> {
            return a.getBirthday()
                .compareTo(b.getBirthday());
        });
        return rosterArray[0].getAge() > rosterArray[1].getAge();
    }

    public boolean methodReferenceSort() {
        Arrays.sort(rosterArray, Person::compareByAge);
        return rosterArray[0].getAge() > rosterArray[1].getAge();
    }

}