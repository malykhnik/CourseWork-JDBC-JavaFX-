package com.example.coursework.Controllers.CtrlsForPayment;

import com.example.coursework.CRUDforTables.Payment;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class EnterCtrl {
    @FXML
    public TextField contract_code;
    @FXML
    public TextField date_payment;
    @FXML
    public TextField sum_payment;
    @FXML
    public TextField code_type_payment;
    @FXML
    public TextField num_payment_doc;

    public void button1Clicked(ActionEvent actionEvent) {
        Payment payment = new Payment();
        payment.createData(Integer.parseInt(contract_code.getText()), date_payment.getText(), Integer.parseInt(sum_payment.getText()),Integer.parseInt(code_type_payment.getText()),num_payment_doc.getText());
    }
}
