package com.example.coursework.Controllers.CtrlsForAgreements;

import com.example.coursework.CRUDforTables.Agreements;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

public class UpdateCtrl {
    @FXML
    private ChoiceBox<String> choiceBox1; //выбор что обновляем
    @FXML
    private ChoiceBox<String> choiceBox2; //выбор по какому условию
    @FXML
    private TextField txtField2;
    @FXML
    private TextField txtField1;

    public void button1Clicked(ActionEvent actionEvent) {
        Agreements agreements = new Agreements();

        agreements.updateData(choiceBox1.getValue(), txtField2.getText(), txtField1.getText());
    }
}
