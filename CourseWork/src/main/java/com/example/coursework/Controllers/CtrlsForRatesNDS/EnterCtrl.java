package com.example.coursework.Controllers.CtrlsForRatesNDS;

import com.example.coursework.CRUDforTables.ExecutionStage;
import com.example.coursework.CRUDforTables.RatesNDS;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class EnterCtrl {
    @FXML
    private TextField txtField;

    @FXML
    public void button1Clicked(ActionEvent actionEvent) {
        RatesNDS ratesNDS = new RatesNDS();

        ratesNDS.createData(txtField.getText());
    }
}
