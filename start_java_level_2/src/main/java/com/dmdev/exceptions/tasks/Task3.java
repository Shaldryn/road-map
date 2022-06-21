package com.dmdev.exceptions.tasks;

/**
 * 3. Создать собственный класс-исключение - наследник класса Exception.
 *           Создать метод, выбрасывающий это исключение.
 *           Вызвать этот метод и отловить исключение. Вывести stack trace в
 * консоль.
 *
 * 4. Повторить предыдущее упражнение, но наследуя свой класс от класса
 * RuntimeException.
 * Добавить в конструктор своего класса возможность указания
 * сообщения.
 */
public class Task3 {

    public static void main(String[] args) {
        try {
            unsafe();
        } catch (DmdevException e) {
            System.err.println(e.getMessage());
            System.err.println(e.getCause());
            e.printStackTrace();
        }
    }

    public static void unsafe() {//throws DmdevException {
        throw new DmdevException(new RuntimeException("runtime exception"));
    }
}
