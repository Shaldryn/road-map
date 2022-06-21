package com.dmdev.collections.lesson20.hw1.task2;

import java.util.List;

public final class StudentHelper {

    private StudentHelper() {
    }

    /**
     * Всегда нужно быть аккуратным с коллекциями, ибо они могут приходить пустыми. Следовательно,
     * нельзя брать первые элемент из этой коллекции без предварительной проверки, что он существует
     */
    public static Student getTheBestStudent(List<Student> students) {
        Student theBestStudent = null;
        for (Student student : students) {
            if (theBestStudent == null || theBestStudent.getAverageMark() < student.getAverageMark()) {
                theBestStudent = student;
            }
        }
        return theBestStudent;
    }
}
