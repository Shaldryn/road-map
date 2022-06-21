package com.dmdev.io.lesson22;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class ReaderRunner {

    public static void main(String[] args) throws IOException {
        Path path = Path.of("start_java_level_2", "src", "main", "resources", "test.txt");
        try (Stream<String> lines = Files.lines(path)) {
            lines.forEach(System.out::println);
        }
        // Reader предназначен для работы с текстовой информацией
//        try (BufferedReader fileReader = new BufferedReader(new FileReader(file))) {
//            String collect = fileReader.lines()
//                    .collect(Collectors.joining("\n"));
//            System.out.println(collect);
//        }
    }
}
