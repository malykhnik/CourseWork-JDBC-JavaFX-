package com.example.coursework.Controllers.CtrlForAgreementTypes;

import com.example.coursework.CRUDforTables.AgreementType;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

public class DeleteCtrl {
    @FXML
    private ChoiceBox<String> choiceBox;
    @FXML
    private TextField agreementTypesDelete;

    public void button1Clicked(ActionEvent actionEvent) {
        AgreementType agreementType = new AgreementType();

        agreementType.deleteData(choiceBox.getValue(), agreementTypesDelete.getText());
    }
}
