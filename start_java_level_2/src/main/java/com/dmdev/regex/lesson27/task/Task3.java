package com.dmdev.regex.lesson27.task;

/**
 * 3. Написать программу, выполняющую поиск в строке всех тегов
 * абзацев, в т.ч. тех, у которых есть параметры, например <p id
 * ="p1">,
 * и замену их на простые теги абзацев <p>.
 */
public class Task3 {

    public static void main(String[] args) {
        String regex = "(<p .+?>)(.+?</p>)";
        String input = "<p>sdfs sdfsdfaf </p> <b> efefef </b> efgefgefe egegeg <p id=\"p1\">sfsfsfs sfsf</p>" +
                "sfdsff <p>dgd gdgdgdg <p id=\"p2\">21324 gfg</p> dfgfg";
        System.out.println(input.replaceAll(regex, "<p>$2"));
    }
}
