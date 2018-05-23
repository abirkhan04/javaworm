package com.java8.methodreference;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MethodReference {

    List<Person> roster = Person.creatRoster();
    Person[] rosterAsArray = roster.toArray(new Person[roster.size()]);

    public boolean traditionalSort() {
        // Traditional implementation of comparator
        class PersonAgeComparator implements Comparator<Person> {
            public int compare(Person a, Person b) {
                return a.getBirthday()
                    .compareTo(b.getBirthday());
            }
        }

        Arrays.sort(rosterAsArray, new PersonAgeComparator());

        return rosterAsArray[0].getAge() > rosterAsArray[1].getAge();
    }

    public boolean lambdaSort() {
        Arrays.sort(rosterAsArray, (a, b) -> {
            return a.getBirthday()
                .compareTo(b.getBirthday());
        });
        return rosterAsArray[0].getAge() > rosterAsArray[1].getAge();
    }

    public boolean methodReferenceSort() {
        Arrays.sort(rosterAsArray, Person::compareByAge);
        return rosterAsArray[0].getAge() > rosterAsArray[1].getAge();
    }

}
