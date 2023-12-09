package com.example.coursework.Controllers.CtrlsForExecutionStages;

import com.example.coursework.CRUDforTables.AgreementType;
import com.example.coursework.CRUDforTables.ExecutionStage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

public class DeleteCtrl {
    @FXML
    private ChoiceBox<String> choiceBox;
    @FXML
    private TextField txtField;

    public void button1Clicked(ActionEvent actionEvent) {
        ExecutionStage executionStage = new ExecutionStage();

        executionStage.deleteData(choiceBox.getValue(), txtField.getText());
    }
}
