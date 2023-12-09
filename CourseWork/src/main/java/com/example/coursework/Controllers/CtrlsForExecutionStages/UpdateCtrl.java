package com.example.coursework.Controllers.CtrlsForExecutionStages;

import com.example.coursework.CRUDforTables.AgreementType;
import com.example.coursework.CRUDforTables.ExecutionStage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class UpdateCtrl {
    @FXML
    private TextField txtField;
    @FXML
    private TextField condition;

    public void button1Clicked(ActionEvent actionEvent) {
        ExecutionStage executionStage = new ExecutionStage();

        executionStage.updateData("stage_name", condition.getText(), txtField.getText());
    }
}
