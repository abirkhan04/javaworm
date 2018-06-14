package com.java8.methodreference;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.time.temporal.ChronoUnit;

public class Person {

    public enum Sex {
        MALE, FEMALE
    }

    String name;
    LocalDate birthday;
    Sex gender;
    String emailAddress;

    public long getAge() {
       long daysBetween = ChronoUnit.YEARS.between( birthday, LocalDate.now());
       return daysBetween;
        // ...
    }
    
    public Person( LocalDate birthDay){
        this.birthday = birthDay;
    }
    
    public LocalDate getBirthday() {
        return birthday;
    }    

    public static int compareByAge(Person a, Person b) {
        return a.birthday.compareTo(b.birthday);
    }
    
    public static List<Person> createRoster(){
         List<Person> personList = new ArrayList<Person>();
         
         LocalDate birthDay1 = LocalDate.of(1987, Month.JANUARY, 1);
         LocalDate birthDay2 = LocalDate.of(1987, Month.OCTOBER, 4);
         personList.add(new Person(birthDay2));
         personList.add(new Person(birthDay1));
         
        return personList;
    }

}

