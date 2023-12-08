package com.example.coursework.Controllers.CtrlsForAgreements;

import com.example.coursework.CRUDforTables.Agreements;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

public class DeleteCtrl {
    @FXML
    private ChoiceBox<String> choiceBox3; //Выбор удаления для таблицы agreements
    @FXML
    private TextField agreementsDelete;

    public void button1Clicked(ActionEvent actionEvent) {
        Agreements agreements = new Agreements();

        agreements.deleteData(choiceBox3.getValue(), agreementsDelete.getText());
    }
}
