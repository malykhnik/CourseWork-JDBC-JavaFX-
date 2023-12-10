package com.example.coursework.CRUDforTables;

import com.example.coursework.ConnectionToDB;
import com.example.coursework.interfaces.PaymentCRUD;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Payment implements PaymentCRUD {
    private ConnectionToDB ctDB;

    private void connect() {
        ctDB = new ConnectionToDB("jdbc:postgresql://localhost:5432/course_work",
                "postgres", "postgres");
    }

    @Override
    public void createData(int contract_code,
                           String date_payment,
                           int sum_payment,
                           int code_type_payment,
                           String num_payment_doc) {
        connect();

        try {
            Connection connection = DriverManager.getConnection(ctDB.getUrl(),
                    ctDB.getUsername(), ctDB.getPassword());

            String sqlQuery = "INSERT INTO payment (contract_code, date_payment,sum_payment,code_type_payment,num_payment_doc) VALUES (?,?,?,?,?)";
            PreparedStatement statement = connection.prepareStatement(sqlQuery);

            statement.setInt(1, contract_code);
            statement.setDate(2, stringToSqlDate(date_payment));
            statement.setInt(3, sum_payment);
            statement.setInt(4, code_type_payment);
            statement.setString(5, num_payment_doc);

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

            String sqlQuery = "UPDATE payment SET " + columnName + " = ?" + " WHERE " + condition;
            PreparedStatement statement = connection.prepareStatement(sqlQuery);
            if (columnName.equals("sum_payment") || columnName.equals("code_type_payment")) {
                statement.setInt(1, Integer.parseInt(newValue));
            }
            else if (columnName.equals("num_payment_doc")){
                statement.setString(1, newValue);
            }
            else {
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

            String sqlQuery = "DELETE FROM payment WHERE " + columnName + " = ?";
            PreparedStatement statement = connection.prepareStatement(sqlQuery);

            if (columnName.equals("sum_payment") || columnName.equals("code_type_payment") || columnName.equals("contract_code")) {
                statement.setInt(1, Integer.parseInt(val));
            }
            else if (columnName.equals("num_payment_doc")){
                statement.setString(1, val);
            }
            else {
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
