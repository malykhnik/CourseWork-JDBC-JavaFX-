package com.example.coursework.Controllers.CtrlForReports;

import com.example.coursework.SQLforReports.ReportSQL;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

import java.util.Map;

public class CtrlFirstReport {
    @FXML
    public ChoiceBox<String> choiceBox; //выбор столбца
    @FXML
    public ChoiceBox<String> choiceBox1; //фильтр
    @FXML
    public ChoiceBox<String> choiceBox2;
    @FXML
    public TextField txtField;

    public void button1Clicked(ActionEvent actionEvent) {
        ReportSQL reportSQL = new ReportSQL();

        reportSQL.firstReport(choiceBox.getValue(), choiceBox1.getValue(), choiceBox2.getValue(),txtField.getText());
    }

}
