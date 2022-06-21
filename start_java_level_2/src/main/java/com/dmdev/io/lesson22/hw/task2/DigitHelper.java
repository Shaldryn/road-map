package com.dmdev.io.lesson22.hw.task2;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class DigitHelper {

    private DigitHelper() {
    }

    public static List<String> readSorted(Path filePath) throws IOException {
        try (Stream<String> lines = Files.lines(filePath, StandardCharsets.UTF_8)) {
            return lines.mapToInt(Integer::parseInt)
                    .sorted()
                    .mapToObj(String::valueOf)
                    .collect(Collectors.toList());
        }
    }
}
