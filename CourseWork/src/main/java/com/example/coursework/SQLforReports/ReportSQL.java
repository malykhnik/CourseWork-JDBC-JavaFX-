package com.example.coursework.SQLforReports;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import com.example.coursework.ConnectionToDB;
import com.example.coursework.interfaces.SQLForReports;

public class ReportSQL implements SQLForReports {
    private ConnectionToDB ctDB;

    private void connect() {
        ctDB = new ConnectionToDB("jdbc:postgresql://localhost:5432/course_work",
                "postgres", "postgres");
    }
    @Override
    public void firstReport() {
        connect();
        try {
            Connection connection = DriverManager.getConnection(ctDB.getUrl(),
                    ctDB.getUsername(), ctDB.getPassword());
            Statement statement = connection.createStatement();

            String sqlQuery = "SELECT a.contract_code, sa.stage_num, sa.date_execution AS stage_date, es.stage_name, sa.stage_amount, sa.advance_amount, p.date_payment, p.sum_payment " +
                    "FROM agreements AS a " +
                    "LEFT JOIN stage_agreement AS sa ON a.contract_code = sa.contract_code " +
                    "LEFT JOIN execution_stages AS es ON sa.code_execution = es.code_execution " +
                    "LEFT JOIN payment AS p ON a.contract_code = p.contract_code " +
                    "ORDER BY a.contract_code, sa.stage_num";
            ResultSet resultSet = statement.executeQuery(sqlQuery);

            FileWriter fileWriter = new FileWriter(  "C:/Users/shere/IdeaProjects/CourseWork/src/main/resources/com/example/coursework/reports/Report_on_Contract_Details");
            while (resultSet.next()) {
                String contractCode = resultSet.getString("contract_code");
                int stageNum = resultSet.getInt("stage_num");
                Date stageDate = resultSet.getDate("stage_date");
                String stageName = resultSet.getString("stage_name");
                double stageAmount = resultSet.getDouble("stage_amount");
                double advanceAmount = resultSet.getDouble("advance_amount");
                Date paymentDate = resultSet.getDate("date_payment");
                double paymentSum = resultSet.getDouble("sum_payment");

                fileWriter.write("Contract Code: " + contractCode + "\n");
                fileWriter.write("Stage Num: " + stageNum + "\n");
                fileWriter.write("Stage Date: " + stageDate + "\n");
                fileWriter.write("Stage Name: " + stageName + "\n");
                fileWriter.write("Stage Amount: " + stageAmount + "\n");
                fileWriter.write("Advance Amount: " + advanceAmount + "\n");
                fileWriter.write("Payment Date: " + paymentDate + "\n");
                fileWriter.write("Payment Sum: " + paymentSum + "\n");
                fileWriter.write("--------------------\n");
            }

            resultSet.close();
            statement.close();
            connection.close();
            fileWriter.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public void secondReport() {
        connect();
        try {
            Connection connection = DriverManager.getConnection(ctDB.getUrl(),
                    ctDB.getUsername(), ctDB.getPassword());

            Statement statement = connection.createStatement();

            String sqlQuery = "SELECT a.contract_code, sa.stage_num, sa.date_execution AS stage_date, sa.stage_amount, sa.advance_amount, tp.name_type_payment " +
                    "FROM agreements AS a " +
                    "LEFT JOIN stage_agreement AS sa ON a.contract_code = sa.contract_code " +
                    "LEFT JOIN type_payments AS tp ON sa.code_execution = tp.code_type_payment " +
                    "ORDER BY a.contract_code, sa.stage_num";
            ResultSet resultSet = statement.executeQuery(sqlQuery);

            FileWriter fileWriter = new FileWriter("C:/Users/shere/IdeaProjects/CourseWork/src/main/resources/com/example/coursework/reports/Planned_Payments");
            while (resultSet.next()) {
                String contractCode = resultSet.getString("contract_code");
                int stageNum = resultSet.getInt("stage_num");
                Date stageDate = resultSet.getDate("stage_date");
                double stageAmount = resultSet.getDouble("stage_amount");
                double advanceAmount = resultSet.getDouble("advance_amount");
                String typeOfPayment = resultSet.getString("name_type_payment");

                fileWriter.write("Contract Code: " + contractCode + "\n");
                fileWriter.write("Stage Num: " + stageNum + "\n");
                fileWriter.write("Stage Date: " + stageDate + "\n");
                fileWriter.write("Stage Amount: " + stageAmount + "\n");
                fileWriter.write("Advance Amount: " + advanceAmount + "\n");
                fileWriter.write("Type of Payment: " + typeOfPayment + "\n");
                fileWriter.write("--------------------\n");
            }

            resultSet.close();
            statement.close();
            connection.close();
            fileWriter.close();
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void thirdReport() {
        connect();
        try {
            Connection connection = DriverManager.getConnection(ctDB.getUrl(),
                    ctDB.getUsername(), ctDB.getPassword());

            Statement statement = connection.createStatement();

            String sqlQuery = "SELECT a.contract_code, p.date_payment, p.sum_payment, tp.name_type_payment " +
                    "FROM agreements AS a " +
                    "LEFT JOIN payment AS p ON a.contract_code = p.contract_code " +
                    "LEFT JOIN type_payments AS tp ON p.code_type_payment = tp.code_type_payment " +
                    "ORDER BY a.contract_code, p.date_payment";
            ResultSet resultSet = statement.executeQuery(sqlQuery);

            FileWriter fileWriter = new FileWriter("C:/Users/shere/IdeaProjects/CourseWork/src/main/resources/com/example/coursework/reports/Actual_Payments");
            while (resultSet.next()) {
                String contractCode = resultSet.getString("contract_code");
                Date paymentDate = resultSet.getDate("date_payment");
                double paymentSum = resultSet.getDouble("sum_payment");
                String typeOfPayment = resultSet.getString("name_type_payment");

                fileWriter.write("Contract Code: " + contractCode + "\n");
                fileWriter.write("Payment Date: " + paymentDate + "\n");
                fileWriter.write("Payment Sum: " + paymentSum + "\n");
                fileWriter.write("Type of Payment: " + typeOfPayment + "\n");
                fileWriter.write("--------------------\n");
            }

            // Step 5: Close the resources
            resultSet.close();
            statement.close();
            connection.close();
            fileWriter.close();
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }
}
