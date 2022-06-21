package com.dmdev.function.lesson21;

import java.util.Optional;
import java.util.stream.Stream;

public class MapReduceExample {

    /**
     * [1000_000] -> age -> max
     * <p>
     * [1000_000] -> age -> max -> max
     * <p>
     * [1000_000] -> age -> max
     */
    public static void main(String[] args) {
//        Stream.of(
//                        new Student(18, "Ivan"),
//                        new Student(23, "Petr"),
//                        new Student(34, "Vasya"),
//                        new Student(45, "Sveta"),
//                        new Student(20, "Katya"),
//                        new Student(68, "Den"),
//                        new Student(101, "Kira")
//                )
////                .parallel()
////                .sequential()
//                .map(Student::getAge)
////                .reduce(Math::max)
//                .reduce(Integer::sum)
//                .ifPresent(System.out::println);

        Optional<Student> optionalStudent = Stream.of(
                        new Student(18, "Ivan"),
                        new Student(23, "Petr"),
                        new Student(34, "Vasya"),
                        new Student(45, "Sveta"),
                        new Student(20, "Katya"),
                        new Student(68, "Den"),
                        new Student(101, "Kira")
                )
//                .filter(student -> student.getAge() < 18)
//                .flatMap(student -> student.getMarks().stream())
//                .map(mark->)
                .reduce(((student1, student2) -> student1.getAge() > student2.getAge() ? student1 : student2));

        optionalStudent.ifPresent(System.out::println);
        optionalStudent
                .map(Student::getAge)
//                .filter(age -> age > 25)
//                .flatMap(age -> Optional.of(age * 2))
//                .flatMap(age -> Optional.ofNullable(null))
                .map(age -> null)
                .ifPresent(System.out::println);
    }
}
