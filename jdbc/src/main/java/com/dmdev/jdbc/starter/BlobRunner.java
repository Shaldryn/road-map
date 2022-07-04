package com.dmdev.jdbc.starter;

import com.dmdev.jdbc.starter.util.ConnectionManager;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.sql.SQLException;

public class BlobRunner {

    public static void main(String[] args) throws SQLException, IOException {
//        blob - Postgres аналог bytea
//        clob - Postgres аналог TEXT
//        saveImage();
        getImage();
    }

    public static void getImage() throws SQLException, IOException {
        var sql = "SELECT image FROM aircraft WHERE id = ?";
        try (var connection = ConnectionManager.get();
             var preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, 1);
            var resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                var image = resultSet.getBytes("image");
                Files.write(Path.of("jdbc", "src", "main", "resources", "boing777_new.jpg"), image, StandardOpenOption.CREATE);
            }
        }
    }

    public static void saveImage() throws SQLException, IOException {
        var sql = "UPDATE aircraft SET image = ? WHERE id = 1";
        try (var connection = ConnectionManager.get();
             var preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setBytes(1, Files.readAllBytes(Path.of("jdbc", "src", "main", "resources", "boing777.jpg")));
//            preparedStatement.setString(); // for TEXT
            preparedStatement.executeUpdate();
        }
    }

    /*
    для СУБД, у которых есть blob/clob
     */
    public static void saveImageOther() throws SQLException, IOException {
        var sql = "UPDATE aircraft SET image = ? WHERE id = 1";
        try (var connection = ConnectionManager.get();
             var preparedStatement = connection.prepareStatement(sql)) {
            connection.setAutoCommit(false);
            var blob = connection.createBlob();
            blob.setBytes(1, Files.readAllBytes(Path.of("jdbc", "src", "main", "resources", "boing777.jpg")));

            preparedStatement.setBlob(1, blob);
            preparedStatement.executeUpdate();
            connection.commit();
        }
    }
}
