package com.dmdev.regex.lesson27.task;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 2. Написать программу, выполняющую поиск в строке
 * шестнадцатеричных чисел, записанных по правилам Java,
 * с помощью регулярных выражений и выводящую их на страницу.
 */
public class Task2 {

    public static void main(String[] args) {
        String regex = "0[xX][0-9a-fA-F]+";
        String input = "sdfsff 0Xff adsfaga 0x12 dgfdgddgd 0XAB dsgsdg 1x24F fhfhf dg 0TaC";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}
