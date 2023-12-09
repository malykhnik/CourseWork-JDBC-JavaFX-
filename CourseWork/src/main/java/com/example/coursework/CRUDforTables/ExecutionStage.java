package com.example.coursework.CRUDforTables;

import com.example.coursework.ConnectionToDB;
import com.example.coursework.interfaces.TableWith2ColsCRUD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ExecutionStage implements TableWith2ColsCRUD {
    private ConnectionToDB ctDB;

    private void connect() {
        ctDB = new ConnectionToDB("jdbc:postgresql://localhost:5432/course_work",
                "postgres", "postgres");
    }

    @Override
    public void createData(String stage_name) {
        connect();

        try {
            Connection connection = DriverManager.getConnection(ctDB.getUrl(),
                    ctDB.getUsername(), ctDB.getPassword());

            String sqlQuery = "INSERT INTO execution_stages (stage_name) VALUES (?)";
            PreparedStatement statement = connection.prepareStatement(sqlQuery);

            statement.setString(1, stage_name);

            statement.executeUpdate();

            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateData(String type_name, String condition, String newVal) {
        connect();
        try {
            Connection connection = DriverManager.getConnection(ctDB.getUrl(),
                    ctDB.getUsername(), ctDB.getPassword());

            String sqlQuery = "UPDATE execution_stages SET " + type_name + " = ?" + " WHERE " + condition;
            PreparedStatement statement = connection.prepareStatement(sqlQuery);
            statement.setString(1, newVal);

            statement.executeUpdate();

            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteData(String columnName, String value) {
        connect();
        try {
            Connection connection = DriverManager.getConnection(ctDB.getUrl(),
                    ctDB.getUsername(), ctDB.getPassword());

            String sqlQuery = "DELETE FROM execution_stages WHERE " + columnName + " = ?";
            PreparedStatement statement = connection.prepareStatement(sqlQuery);
            if (columnName.equals("code_execution")) {
                statement.setInt(1, Integer.parseInt(value));
            } else {
                statement.setString(1, value);
            }

            statement.executeUpdate();

            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
