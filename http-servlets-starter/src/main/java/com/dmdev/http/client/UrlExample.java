package com.dmdev.http.client;

import java.io.IOException;
import java.net.URL;

public class UrlExample {

    public static void main(String[] args) throws IOException {
//        checkGoogle();
        var url = new URL("file:D:\\Education\\Projects\\dmdev\\http-servlets-starter\\src\\main\\java\\com\\dmdev\\http\\socket\\DatagramRunner.java");
        var urlConnection = url.openConnection();

        System.out.println(new String(urlConnection.getInputStream().readAllBytes()));
    }

    private static void checkGoogle() throws IOException {
        var url = new URL("https://www.google.com"); //GET
        var urlConnection = url.openConnection();

//        urlConnection.setDoOutput(true); //POST
//        try (var outputStream = urlConnection.getOutputStream()) {
//        }

        System.out.println();
    }
}
