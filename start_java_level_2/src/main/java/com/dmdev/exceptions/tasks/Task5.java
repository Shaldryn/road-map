package com.dmdev.exceptions.tasks;

/**
 * 5. Бросить одно из существующих в JDK исключений, отловить его и
 * выбросить своё собственное, указав в качестве причины отловленное.
 */
public class Task5 {

    public static void main(String[] args) {
        try {
            catchCustomException();
        } catch (DmdevException e) {
            System.err.println("catched in main");
            e.printStackTrace();
        }
    }

    public static void catchCustomException() {
        try {
            unsafe();
        } catch (RuntimeException e) {
            System.err.println("Catch int catchCustomException method");
            throw new DmdevException(e);
        }
    }

    public static void unsafe() {
        throw new RuntimeException("Ooops");
    }
}
