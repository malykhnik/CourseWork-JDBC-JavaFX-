package com.example.coursework.Controllers.CtrlForReports;

import com.example.coursework.SQLforReports.ReportSQL;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

import java.util.Map;

public class CtrlSecondReport {
    @FXML
    public ChoiceBox<String> choiceBox;
    @FXML
    public ChoiceBox<String> choiceBox1;
    @FXML
    public ChoiceBox<String> choiceBox2;
    @FXML
    public TextField txtField;

    public void button1Clicked(ActionEvent actionEvent) {
        ReportSQL reportSQL = new ReportSQL();
        reportSQL.secondReport(choiceBox.getValue(), choiceBox1.getValue(), choiceBox2.getValue(),txtField.getText());
    }
}
