package com.example.coursework.CRUDforTables;

import com.example.coursework.ConnectionToDB;
import com.example.coursework.interfaces.AgreementTypeCRUD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AgreementType implements AgreementTypeCRUD {
    private ConnectionToDB ctDB;

    private void connect() {
        ctDB = new ConnectionToDB("jdbc:postgresql://localhost:5432/course_work",
                "postgres", "postgres");
    }

    @Override
    public void createData(String type_name) {
        connect();

        try {
            Connection connection = DriverManager.getConnection(ctDB.getUrl(),
                    ctDB.getUsername(), ctDB.getPassword());

            String sqlQuery = "INSERT INTO agreement_types (type_name) VALUES (?)";
            PreparedStatement statement = connection.prepareStatement(sqlQuery);

            statement.setString(1, type_name);

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

            String sqlQuery = "UPDATE agreement_types SET " + type_name + " = ?" + " WHERE " + condition;
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

            String sqlQuery = "DELETE FROM agreement_types WHERE " + columnName + " = ?";
            PreparedStatement statement = connection.prepareStatement(sqlQuery);
            if (columnName.equals("code_contract")) {
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
