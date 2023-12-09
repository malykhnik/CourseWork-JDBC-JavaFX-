package com.example.coursework.Controllers.CtrlForAgreementTypes;

import com.example.coursework.CRUDforTables.AgreementType;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class EnterCtrl {
    @FXML
    private TextField agreementTypesEnter;

    @FXML
    public void button1Clicked(ActionEvent actionEvent) {
        AgreementType agreementType = new AgreementType();

        agreementType.createData(agreementTypesEnter.getText());
    }
}
