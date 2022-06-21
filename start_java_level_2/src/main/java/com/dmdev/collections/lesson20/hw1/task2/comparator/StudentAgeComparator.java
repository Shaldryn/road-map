package com.dmdev.collections.lesson20.hw1.task2.comparator;

import com.dmdev.collections.lesson20.hw1.task2.Student;

import java.util.Comparator;

public class StudentAgeComparator implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        return Integer.compare(o1.getAge(), o2.getAge());
    }
}
