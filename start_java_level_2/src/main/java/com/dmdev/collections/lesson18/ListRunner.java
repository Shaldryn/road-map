package com.dmdev.collections.lesson18;

public class ListRunner {

    public static void main(String[] args) {
        List<String> list = new List<>(10);
        list.add("String1");
        list.add("String2");
        list.add("String3");

        String element = list.get(1);
        System.out.println(element);
        System.out.println();

//        for (String s : list) {
//            System.out.println(s);
//        }

        list.iterator().forEachRemaining(System.out::println);

    }
}
