package com.example.coursework.Controllers.CtrlsForAgreements;

import com.example.coursework.CRUDforTables.Agreements;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.time.LocalDate;
import java.sql.Date;

public class EnterCtrl {
    @FXML
    private TextField v3, v4, v5, v6, v7, v8, v9;

    @FXML
    public void button1Clicked(ActionEvent actionEvent) {
        Agreements agreements = new Agreements();
        Date dateValue = new Date(System.currentTimeMillis());

        LocalDate localDate = dateValue.toLocalDate();
        LocalDate newDate = localDate.plusMonths(Integer.parseInt(v9.getText()));

        dateValue = Date.valueOf(newDate);
        agreements.createData(
                Integer.parseInt(v3.getText()),
                Integer.parseInt(v4.getText()),
                Integer.parseInt(v5.getText()),
                Integer.parseInt(v6.getText()),
                Integer.parseInt(v7.getText()),
                Integer.parseInt(v8.getText()),
                dateValue);
    }

}

