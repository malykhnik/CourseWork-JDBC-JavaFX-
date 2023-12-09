package com.example.coursework.Controllers.CtrlsForExecutionStages;

import com.example.coursework.CRUDforTables.ExecutionStage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class EnterCtrl {
    @FXML
    private TextField txtField;

    @FXML
    public void button1Clicked(ActionEvent actionEvent) {
        ExecutionStage executionStage = new ExecutionStage();

        executionStage.createData(txtField.getText());
    }
}
