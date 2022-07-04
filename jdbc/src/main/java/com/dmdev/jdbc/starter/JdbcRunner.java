package com.dmdev.jdbc.starter;

import com.dmdev.jdbc.starter.util.ConnectionManager;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class JdbcRunner {

    public static void main(String[] args) throws SQLException {
//        Class<Driver> driverClass = Driver.class;
////        String sql = "CREATE TABLE IF NOT EXISTS info(" +
////                "id SERIAL PRIMARY KEY," +
////                "data TEXT NOT NULL" +
////                ");";
////        String sql = "INSERT INTO info (data)" +
////                "VALUES" +
////                "('Test1')," +
////                "('Test2')," +
////                "('Test3')," +
////                "('Test4');";
////        String sql = "UPDATE info SET data = 'TestTest' WHERE id = 4;";
//        String sql = "SELECT * FROM ticket;";
//        try (var connection = ConnectionManager.open();
////             var statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE)) { //включаем возможность изменять данные в ResultSet(почти не используется, только для выборки)
//             var statement = connection.createStatement()) {
//            System.out.println(connection.getSchema());
//            System.out.println(connection.getTransactionIsolation());
////            var executeResult = statement.execute(sql);
////            var executeResult = statement.executeUpdate(sql);
////            var executeResult = statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
////            var generatedKeys = statement.getGeneratedKeys();
////            System.out.println(executeResult);
////            System.out.println(statement.getUpdateCount());
//            var executeResult = statement.executeQuery(sql);
//            while (executeResult.next()) {
//                System.out.println(executeResult.getLong("id"));
//                System.out.println(executeResult.getString("passenger_no"));
//                System.out.println(executeResult.getBigDecimal("cost"));
//                System.out.println("-------");
//            }
//        }

//        String flightId = "2 OR 1 = 1; DROP TABLE info;"; //SQL Injection
//        var result = getTicketsByFlightId(flightId);
//        System.out.println(result);

//        Long flightId = 2L;
//        var result = getTicketsByFlightId(flightId);
//        System.out.println(result);

//        var result = getFlightsBetween(LocalDate.of(2020, 10, 1).atStartOfDay(), LocalDateTime.now());
//        System.out.println(result);

        try {
            checkMetaData();
        } finally {
            ConnectionManager.closePool();
        }
    }

//    private static List<Long> getTicketsByFlightId(String flightId) throws SQLException {
//        String sql = String.format("SELECT id FROM ticket WHERE flight_id = %s", flightId);
//        List<Long> result = new ArrayList<>();
//        try (var connection = ConnectionManager.open();
//             var statement = connection.createStatement()) {
//            var resultSet = statement.executeQuery(sql);
//            while (resultSet.next()) {
////                result.add(resultSet.getLong("id"));
//                result.add(resultSet.getObject("id", Long.class)); //если поле может иметь значение NULL
//            }
//        }
//        return result;
//    }

    private static List<Long> getTicketsByFlightId(Long flightId) throws SQLException {
        String sql = "SELECT id FROM ticket WHERE flight_id = ?";
        List<Long> result = new ArrayList<>();
        try (var connection = ConnectionManager.get();
             var preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setLong(1, flightId);
            var resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
//                result.add(resultSet.getLong("id"));
                result.add(resultSet.getObject("id", Long.class)); //если поле может иметь значение NULL
            }
        }
        return result;
    }

    private static List<Long> getFlightsBetween(LocalDateTime start, LocalDateTime end) throws SQLException {
        String sql = "SELECT id FROM flight WHERE departure_date BETWEEN ? AND ?";
        List<Long> result = new ArrayList<>();
        try (var connection = ConnectionManager.get();
             var preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setFetchSize(50);
            preparedStatement.setQueryTimeout(10);
            preparedStatement.setMaxRows(100);

            System.out.println(preparedStatement);
            preparedStatement.setTimestamp(1, Timestamp.valueOf(start));
            System.out.println(preparedStatement);
            preparedStatement.setTimestamp(2, Timestamp.valueOf(end));
            System.out.println(preparedStatement);

            var resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                result.add(resultSet.getObject("id", Long.class)); // не getLong для избегания лишнего boxing/unboxing
            }
            return result;
        }
    }

    private static void checkMetaData() throws SQLException {
        try (var connection = ConnectionManager.get()) {
            var metaData = connection.getMetaData();
            var catalogs = metaData.getCatalogs();
            while (catalogs.next()) {
                var catalog = catalogs.getString(1);
//                System.out.println(catalog);
                var schemas = metaData.getSchemas();
                while (schemas.next()) {
                    var schema = schemas.getString("TABLE_SCHEM");
//                    System.out.println(schema);
//                    var tables = metaData.getTables(catalog, schema, "%", null);
                    var tables = metaData.getTables(catalog, schema, "%", new String[] {"TABLE"});
                    if (schema.equals("public")) {
                        while (tables.next()) {
                            System.out.println(tables.getString("TABLE_NAME"));
                        }
                    }
                }
            }
        }
    }
}
