package com.example.coursework.Controllers.CtrlsForTypePayments;

import com.example.coursework.CRUDforTables.RatesNDS;
import com.example.coursework.CRUDforTables.TypePayments;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class EnterCtrl {
    @FXML
    private TextField txtField;

    @FXML
    public void button1Clicked(ActionEvent actionEvent) {
        TypePayments typePayments = new TypePayments();

        typePayments.createData(txtField.getText());
    }
}
