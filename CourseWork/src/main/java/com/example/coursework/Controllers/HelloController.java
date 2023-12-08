package com.example.coursework.Controllers;

import com.example.coursework.modalWindows.windowsForAgreementTypes.EnterDataAgreementTypes;
import com.example.coursework.modalWindows.windowsForAgreementTypes.UpdateDataAgreementTypes;
import com.example.coursework.modalWindows.windowsForAgreements.DeleteDataAgreements;
import com.example.coursework.modalWindows.windowsForAgreements.EnterDataAgreements;
import com.example.coursework.modalWindows.windowsForAgreements.UpdateDataAgreements;

import com.example.coursework.modalWindows.windowsForAgreementTypes.DeleteDataAgreementTypes;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;

import java.io.IOException;

public class HelloController {
    @FXML
    private ChoiceBox<String> choiceBox1; //Выбор действия
    @FXML
    private ChoiceBox<String> choiceBox2; //Выбор таблицы

    private String action;
    private String table;

    public void button2Clicked(ActionEvent actionEvent) throws IOException {
        action = choiceBox1.getValue();
        table = choiceBox2.getValue();
        if (table.equals("Договора")) {
            switch (action) {
                case "Добавить":
                    EnterDataAgreements.newWindow("Ввод данных");
                    break;
                case "Удалить":
                    DeleteDataAgreements.newWindow("Удаление данных");
                    break;
                case "Изменить":
                    UpdateDataAgreements.newWindow("Обновление данных");
                    break;
            }
        } else if (table.equals("Типы договоров")) {
            switch (action) {
                case "Добавить":
                    EnterDataAgreementTypes.newWindow("Ввод данных");
                    break;
                case "Удалить":
                    DeleteDataAgreementTypes.newWindow("Удаление данных");
                    break;
                case "Изменить":
                    UpdateDataAgreementTypes.newWindow("Обновление данных");
                    break;
            }
        }
    }

}