package com.example.coursework.Controllers.CtrlsForAgreementTypes;

import com.example.coursework.CRUDforTables.AgreementType;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class UpdateCtrl {
    @FXML
    private TextField agreementTypesUpdate;
    @FXML
    private TextField condition;

    public void button1Clicked(ActionEvent actionEvent) {
        AgreementType agreementType = new AgreementType();

        agreementType.updateData("type_name", condition.getText(), agreementTypesUpdate.getText());
    }
}
