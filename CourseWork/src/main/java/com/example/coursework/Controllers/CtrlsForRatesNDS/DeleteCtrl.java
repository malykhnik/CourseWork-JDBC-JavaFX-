package com.example.coursework.Controllers.CtrlsForRatesNDS;

import com.example.coursework.CRUDforTables.ExecutionStage;
import com.example.coursework.CRUDforTables.RatesNDS;
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
        RatesNDS ratesNDS = new RatesNDS();

        ratesNDS.deleteData(choiceBox.getValue(), txtField.getText());
    }
}
