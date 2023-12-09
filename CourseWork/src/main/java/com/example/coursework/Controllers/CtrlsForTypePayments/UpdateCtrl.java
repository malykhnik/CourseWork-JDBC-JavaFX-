package com.example.coursework.Controllers.CtrlsForTypePayments;

import com.example.coursework.CRUDforTables.TypePayments;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class UpdateCtrl {
    @FXML
    private TextField txtField;
    @FXML
    private TextField condition;

    public void button1Clicked(ActionEvent actionEvent) {
        TypePayments typePayments = new TypePayments();

        typePayments.updateData("name_type_payment", condition.getText(), txtField.getText());
    }
}
