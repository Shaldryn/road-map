package com.dmdev.collections.lesson20.map;

import com.dmdev.collections.lesson20.person.Person;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortExample {

    public static void main(String[] args) {
        List<String> strings = Arrays.asList("123", "456", "14", "678");
        System.out.println(strings);

        Collections.sort(strings);
        System.out.println(strings);

//        Collections.sort(strings, new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return o2.compareTo(o1);
//            }
//        });
        Collections.sort(strings, Comparator.reverseOrder());
        System.out.println(strings);

        List<Person> personList = Arrays.asList(
                new Person(1, "Ivan", "Ivanov"),
                new Person(29, "Petr", "Petrov"),
                new Person(3, "Sveta", "Svetikova")
        );
        System.out.println(personList);

        Collections.sort(personList);
        System.out.println(personList);

//        personList.sort(new FirstNameComparator());
        personList.sort(Comparator.comparing(Person::getFirstName).thenComparing(Person::getLastName));
        System.out.println(personList);



    }

    public static class FirstNameComparator implements Comparator<Person> {
        @Override
        public int compare(Person o1, Person o2) {
            return o1.getFirstName().compareTo(o2.getFirstName());
        }
    }
}
