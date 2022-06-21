package com.dmdev.io.lesson22;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class WriterRunner {

    public static void main(String[] args) throws IOException {
        Path path = Path.of("start_java_level_2", "src", "main", "resources", "writer2.txt");
//        try (BufferedWriter fileWriter = new BufferedWriter(new FileWriter(path, true))) {
        Files.write(path, List.of("Hello World!", "Java"));

//        try (BufferedWriter fileWriter = Files.newBufferedWriter(path)) {
//            fileWriter.append("Hello World!");
//            fileWriter.newLine();
//            fileWriter.append("Java");
//        }
    }
}
