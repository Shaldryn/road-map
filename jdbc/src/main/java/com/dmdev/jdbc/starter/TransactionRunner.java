package com.dmdev.jdbc.starter;

import com.dmdev.jdbc.starter.util.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class TransactionRunner {

    public static void main(String[] args) throws SQLException {
//        transaction();
        batchQuery();
    }

    private static void transaction() throws SQLException {
        var flightId = 9L;
        var deleteFlightSql = "DELETE FROM flight WHERE id = ?";
        var deleteTicketsSql = "DELETE FROM ticket WHERE flight_id = ?";
        Connection connection = null;
        PreparedStatement deleteFLightStatement = null;
        PreparedStatement deleteTicketsStatement = null;
        try {
            connection = ConnectionManager.get();
            deleteFLightStatement = connection.prepareStatement(deleteFlightSql);
            deleteTicketsStatement = connection.prepareStatement(deleteTicketsSql);

            connection.setAutoCommit(false);

            deleteFLightStatement.setLong(1, flightId);
            deleteTicketsStatement.setLong(1, flightId);

            deleteTicketsStatement.executeUpdate();
            deleteFLightStatement.executeUpdate();
            connection.commit();
        } catch (Exception e) {
            if (connection != null) {
                connection.rollback();
            }
            throw e;
        } finally {
            if (connection != null) {
                connection.close();
            }
            if (deleteFLightStatement != null) {
                deleteFLightStatement.close();
            }
            if (deleteTicketsStatement != null) {
                deleteTicketsStatement.close();
            }
        }
    }

    private static void batchQuery() throws SQLException {
        var flightId = 9L;
        var deleteFlightSql = "DELETE FROM flight WHERE id = " + flightId;
        var deleteTicketsSql = "DELETE FROM ticket WHERE flight_id = " + flightId;
        Connection connection = null;
        Statement statement = null;
        try {
            connection = ConnectionManager.get();
            connection.setAutoCommit(false);

            statement = connection.createStatement();
            statement.addBatch(deleteTicketsSql);
            statement.addBatch(deleteFlightSql);

            var ints = statement.executeBatch();

            connection.commit();
        } catch (Exception e) {
            if (connection != null) {
                connection.rollback();
            }
            throw e;
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
    }
}
