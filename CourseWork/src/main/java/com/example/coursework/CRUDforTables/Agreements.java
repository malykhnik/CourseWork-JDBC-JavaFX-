package com.example.coursework.CRUDforTables;

import com.example.coursework.ConnectionToDB;
import com.example.coursework.interfaces.AgreementsCRUD;

import java.sql.*;

public class Agreements implements AgreementsCRUD {
    private ConnectionToDB ctDB;

    private void connect() {
        ctDB = new ConnectionToDB("jdbc:postgresql://localhost:5432/course_work",
                "postgres", "postgres");
    }

    @Override
    public void createData(int customer_code,
                           int executor_code,
                           int contract_type_code,
                           int code_org,
                           int execution_code,
                           int code_NDS,
                           Date date_execution) {
        connect();
        try {
            Connection connection = DriverManager.getConnection(ctDB.getUrl(),
                    ctDB.getUsername(), ctDB.getPassword());

            String sqlQuery = "INSERT INTO agreements (customer_code,executor_code," +
                    "contract_type_code,code_org,execution_code,code_NDS,date_execution) VALUES (?,?,?,?,?,?,?)";
            PreparedStatement statement = connection.prepareStatement(sqlQuery);

            statement.setInt(1, customer_code);
            statement.setInt(2, executor_code);
            statement.setInt(3, contract_type_code);
            statement.setInt(4, code_org);
            statement.setInt(5, execution_code);
            statement.setInt(6, code_NDS);
            statement.setDate(7, date_execution);

            statement.executeUpdate();

            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

//    @Override
//    public void readData() {
////        connect();
////        try {
////            Connection connection = DriverManager.getConnection(ctDB.getUrl(),
////                    ctDB.getUsername(), ctDB.getPassword());
////
////            String sqlQuery = "SELECT * FROM agreements";
////            PreparedStatement statement = connection.prepareStatement(sqlQuery);
////            statement.setInt(1, Integer.parseInt(value));
////
////            statement.executeUpdate();
////
////            statement.close();
////            connection.close();
////        } catch (SQLException e) {
////            e.printStackTrace();
////        }
//    }

    @Override
    public void updateData(String colName, String condition, String newVal) {
        connect();
        try {
            Connection connection = DriverManager.getConnection(ctDB.getUrl(),
                    ctDB.getUsername(), ctDB.getPassword());

            String sqlQuery = "UPDATE agreements SET " + colName + " = ?" + " WHERE " + condition;
            PreparedStatement statement = connection.prepareStatement(sqlQuery);
            statement.setInt(1, Integer.parseInt(newVal));

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

            String sqlQuery = "DELETE FROM agreements WHERE " + columnName + " = ?";
            PreparedStatement statement = connection.prepareStatement(sqlQuery);
            statement.setInt(1, Integer.parseInt(value));

            statement.executeUpdate();

            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
