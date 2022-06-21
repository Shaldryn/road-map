package com.dmdev.serialization.lesson23;

import java.io.*;
import java.nio.file.Path;

public class SerializationDemo {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Path path = Path.of("start_java_level_2", "src", "main", "resources", "student.out");
        writeObject(path);
        readObject(path);
    }

    private static void readObject(Path path) throws IOException, ClassNotFoundException {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(path.toFile()))) {
            Object object = objectInputStream.readObject(); //если в файле несколько объектов, нужно каждый раз прописывать этот метод
            System.out.println(object);
        }
    }

    private static void writeObject(Path path) throws IOException {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(path.toFile()))) {
            Person sergey = new Person(26, "Sergey");
            objectOutputStream.writeObject(sergey);
        }
    }
}
