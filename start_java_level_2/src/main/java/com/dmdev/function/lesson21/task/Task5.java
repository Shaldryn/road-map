package com.dmdev.function.lesson21.task;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

/**
 * 5. Дан класс Person с полями firstName, lastName,
 * age.
 * Вывести полное имя самого старшего человека, у
 * которого длина этого имени не превышает 15
 * символов.
 */
public class Task5 {

    public static void main(String[] args) {
        List<Person> persons = List.of(
                new Person("Ivan", "Ivanov", 20),
                new Person("Petr", "Petrov", 25),
                new Person("Sveta", "Svetikova", 33),
                new Person("Kate", "Ivanova", 25),
                new Person("Slava", "Slavikov", 18),
                new Person("Arni", "Kutuzov", 56)
//                new Person("75682", "Kutuzov", 56),
//                new Person("75682", "Slavikov", 28)
//                new Person("Arni", "Kutuzov", 56)
        );

        Map<String, List<Person>> collect = persons.parallelStream().collect(Collectors.groupingBy(Person::getFirstName, mapping(person -> person, toList())));
        for (Map.Entry<String, List<Person>> entry : collect.entrySet()) {
            if (entry.getKey().equals("Arni")) {
                Person actual = null;
                for (Person person : persons) {
                    if (person.getFirstName().equals("Arni")) {
                        actual = person;
                    }
                }
                System.out.println(entry.getValue().get(0) == actual);
                entry.getValue().forEach(value -> value.setAge(10));
            }
        }

        System.out.println(persons);

//        long count = persons.stream().map(Person::getFirstName).distinct().count();//collect(groupingBy(e -> e, counting())).entrySet().stream().filter(entry -> entry.getValue() > 1).count();
//        System.out.println(count);

//        persons.stream()
//                .filter(person -> person.getFullName().length() < 15)
//                .max(Comparator.comparing(Person::getAge))
//                .map(Person::getFullName)
//                .ifPresent(System.out::println);
//
//        Map<Integer, List<String>> map = persons.stream()
//                .collect(groupingBy(Person::getAge,
//                        mapping(Person::getFullName, toList())));
//        Map<Integer, Person> personMap = persons.stream()
//                .collect(toMap(Person::getAge, Function.identity()));//identity -> (person -> person)
//        System.out.println(map);
//        System.out.println(personMap);
    }
}
