package com.example.coursework.CRUDforTables;

import com.example.coursework.ConnectionToDB;
import com.example.coursework.interfaces.StageAgreementCRUD;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class StageAgreement implements StageAgreementCRUD {
    private ConnectionToDB ctDB;

    private void connect() {
        ctDB = new ConnectionToDB("jdbc:postgresql://localhost:5432/course_work",
                "postgres", "postgres");
    }

    @Override
    public void createData(int contract_code,
                           int stage_num,
                           String date_execution,
                           int code_execution,
                           int stage_amount,
                           int advance_amount) {
        connect();

        try {
            Connection connection = DriverManager.getConnection(ctDB.getUrl(),
                    ctDB.getUsername(), ctDB.getPassword());

            String sqlQuery = "INSERT INTO stage_agreement (contract_code,stage_num," +
                    "date_execution,code_execution,stage_amount,advance_amount) VALUES (?,?,?,?,?,?)";
            PreparedStatement statement = connection.prepareStatement(sqlQuery);

            statement.setInt(1, contract_code);
            statement.setInt(2, stage_num);
            statement.setDate(3, stringToSqlDate(date_execution));
            statement.setInt(4, code_execution);
            statement.setInt(5, stage_amount);
            statement.setInt(6, advance_amount);

            statement.executeUpdate();

            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateData(String columnName, String condition, String newValue) {
        connect();
        try {
            Connection connection = DriverManager.getConnection(ctDB.getUrl(),
                    ctDB.getUsername(), ctDB.getPassword());

            String sqlQuery = "UPDATE stage_agreement SET " + columnName + " = ?" + " WHERE " + condition;
            PreparedStatement statement = connection.prepareStatement(sqlQuery);
            if (columnName.equals("contract_code") || columnName.equals("stage_num") ||
                    columnName.equals("code_execution") || columnName.equals("stage_amount") ||
                    columnName.equals("advance_amount")) {
                statement.setInt(1, Integer.parseInt(newValue));
            } else {
                statement.setDate(1, stringToSqlDate(newValue));
            }

            statement.executeUpdate();

            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteData(String columnName, String val) {
        connect();
        try {
            Connection connection = DriverManager.getConnection(ctDB.getUrl(),
                    ctDB.getUsername(), ctDB.getPassword());

            String sqlQuery = "DELETE FROM stage_agreement WHERE " + columnName + " = ?";
            PreparedStatement statement = connection.prepareStatement(sqlQuery);

            if (columnName.equals("contract_code") || columnName.equals("stage_num") ||
                    columnName.equals("code_execution") || columnName.equals("stage_amount") ||
                    columnName.equals("advance_amount")) {
                statement.setInt(1, Integer.parseInt(val));
            } else {
                statement.setDate(1, stringToSqlDate(val));
            }

            statement.executeUpdate();

            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static Date stringToSqlDate(String date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        java.util.Date currentDate = new java.util.Date();
        Date sqlDate = new Date(currentDate.getTime());

        try {
            java.util.Date parsedDate = dateFormat.parse(date);
            sqlDate = new Date(parsedDate.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return sqlDate;
    }
}
