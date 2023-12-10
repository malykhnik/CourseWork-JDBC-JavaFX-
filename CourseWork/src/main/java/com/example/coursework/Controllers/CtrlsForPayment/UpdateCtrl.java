package com.example.coursework.Controllers.CtrlsForPayment;

import com.example.coursework.CRUDforTables.Payment;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

public class UpdateCtrl {
    @FXML
    public TextField condition;
    @FXML
    public TextField txtField;
    @FXML
    public ChoiceBox<String> choiceBox;

    public void button1Clicked(ActionEvent actionEvent) {
        Payment payment = new Payment();
        payment.updateData(choiceBox.getValue(), condition.getText(), txtField.getText());
    }
}
