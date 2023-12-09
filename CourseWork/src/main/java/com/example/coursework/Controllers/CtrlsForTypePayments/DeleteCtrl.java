package com.example.coursework.Controllers.CtrlsForTypePayments;

import com.example.coursework.CRUDforTables.RatesNDS;
import com.example.coursework.CRUDforTables.TypePayments;
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
        TypePayments typePayments = new TypePayments();

        typePayments.deleteData(choiceBox.getValue(), txtField.getText());
    }
}
