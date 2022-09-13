package com.dmdev.function.lesson21;

import java.util.Base64;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamExample {

    public static void main(String[] args) {
//        List<String> strings = List.of("88", "11", "22", "33", "44", "55", "66");
//        for (String string : strings) {
//            String value = string + string;
//            Integer intValue = Integer.valueOf(value);
//            if (intValue % 2 == 0) {
//                System.out.println(intValue);
//            }
//        }

//        strings.stream()
//                .map(string -> string + string)
//                .map(Integer::valueOf)
//                .filter(value -> value % 2 == 0)
//                .sorted()
//                .skip(1)
//                .limit(2)
//                .mapToInt(Integer::intValue)
//                .forEach(System.out::println);

//        IntSummaryStatistics intSummaryStatistics = strings.stream()
//                .map(string -> string + string)
//                .map(Integer::valueOf)
//                .filter(value -> value % 2 == 0)
//                .sorted()
//                .skip(1)
//                .limit(2)
//                .mapToInt(Integer::intValue)
////                .mapToObj(Integer::valueOf)
//                .summaryStatistics();

//        System.out.println(intSummaryStatistics);
//
//        List<String> collect = Stream.of("88", "11", "22", "33", "44", "55", "66")
//                .peek(System.out::println) //foreach только не терминальный
//                .collect(Collectors.toList());

//        IntStream.of(1, 4, 5, 6);
//        IntStream.range(0, 10)
//                .forEach(System.out::println);
//        IntStream.iterate(0, operand -> operand + 3)
//                .skip(10)
//                .limit(20)
//                .forEach(System.out::println);
//        for (int i = 0; i < 10; i++) {
//            System.out.println(i);
//        }

        var teamList = List.of(1, 2, 3, 4, 5, 6);
        var responseList = List.of(1, 2, 3, 5, 6, 10, 12, 15);

//        Predicate<Integer> isIncorrectId = teamList::contains;
//        var collect = responseList.stream()
//                .filter(Predicate.not(isIncorrectId))
//                .collect(Collectors.toList());

        Predicate<Integer> isIncorrectId = responseList::contains;
        var collect = teamList.stream()
                .filter(Predicate.not(isIncorrectId))
                .collect(Collectors.toList());

        System.out.println(collect);


        String encodedString = "SmF2YSDQvdC1INGC0L7RgNC80L7Qt9C40YIhCg==";

        byte[] decodedBytes = Base64.getDecoder().decode(encodedString);
        String decodedString = new String(decodedBytes);

        System.out.println(decodedString);



    }
}
