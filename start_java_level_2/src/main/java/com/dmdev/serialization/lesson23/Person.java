package com.dmdev.serialization.lesson23;

import java.io.Serializable;

public class Person implements Serializable {

    private static final long serialVersionUID = -3469157977589184053L;
    private int age;
    private transient String fierstName; // не сериализующее поле

    public Person(int age, String fierstName) {
        this.age = age;
        this.fierstName = fierstName;
    }

    public int getAge() {
        return age;
    }

    public String getFierstName() {
        return fierstName;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", fierstName='" + fierstName + '\'' +
                '}';
    }
}
