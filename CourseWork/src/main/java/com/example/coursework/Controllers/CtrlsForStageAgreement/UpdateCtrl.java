package com.example.coursework.Controllers.CtrlsForStageAgreement;

import com.example.coursework.CRUDforTables.StageAgreement;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

public class UpdateCtrl {
    @FXML
    public ChoiceBox<String> choiceBox;
    @FXML
    public TextField condition;
    @FXML
    public TextField txtField;

    public void button1Clicked(ActionEvent actionEvent) {
        StageAgreement stageAgreement = new StageAgreement();
        stageAgreement.updateData(choiceBox.getValue(),condition.getText(),txtField.getText());
    }
}
