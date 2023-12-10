package com.example.coursework.Controllers.CtrlsForPayment;

import com.example.coursework.CRUDforTables.Payment;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

public class DeleteCtrl {
    @FXML
    public ChoiceBox<String> choiceBox;
    @FXML
    public TextField txtField;

    public void button1Clicked(ActionEvent actionEvent) {
        Payment payment = new Payment();
        payment.deleteData(choiceBox.getValue(), txtField.getText());
    }
}
