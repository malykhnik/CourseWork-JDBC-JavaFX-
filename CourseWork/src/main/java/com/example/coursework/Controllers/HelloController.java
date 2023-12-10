package com.example.coursework.Controllers;

import com.example.coursework.modalWindows.windowsForAgreementTypes.EnterDataAgreementTypes;
import com.example.coursework.modalWindows.windowsForAgreementTypes.UpdateDataAgreementTypes;
import com.example.coursework.modalWindows.windowsForAgreements.DeleteDataAgreements;
import com.example.coursework.modalWindows.windowsForAgreements.EnterDataAgreements;
import com.example.coursework.modalWindows.windowsForAgreements.UpdateDataAgreements;

import com.example.coursework.modalWindows.windowsForAgreementTypes.DeleteDataAgreementTypes;
import com.example.coursework.modalWindows.windowsForExecutionStages.DeleteDataExecutionStages;
import com.example.coursework.modalWindows.windowsForExecutionStages.EnterDataExecutionStages;
import com.example.coursework.modalWindows.windowsForExecutionStages.UpdateDataExecutionStages;
import com.example.coursework.modalWindows.windowsForPayment.DeleteDataPayment;
import com.example.coursework.modalWindows.windowsForPayment.EnterDataPayment;
import com.example.coursework.modalWindows.windowsForPayment.UpdateDataPayment;
import com.example.coursework.modalWindows.windowsForRatesNDS.DeleteDataRatesNDS;
import com.example.coursework.modalWindows.windowsForRatesNDS.EnterDataRatesNDS;
import com.example.coursework.modalWindows.windowsForRatesNDS.UpdateDataRatesNDS;
import com.example.coursework.modalWindows.windowsForStageAgreement.DeleteDataStageAgreement;
import com.example.coursework.modalWindows.windowsForStageAgreement.EnterDataStageAgreement;
import com.example.coursework.modalWindows.windowsForStageAgreement.UpdateDataStageAgreement;
import com.example.coursework.modalWindows.windowsForTypePayments.DeleteDataTypePayments;
import com.example.coursework.modalWindows.windowsForTypePayments.EnterDataTypePayments;
import com.example.coursework.modalWindows.windowsForTypePayments.UpdateDataTypePayments;
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
        } else if (table.equals("Стадии исполнения")) {
            switch (action) {
                case "Добавить":
                    EnterDataExecutionStages.newWindow("Ввод данных");
                    break;
                case "Удалить":
                    DeleteDataExecutionStages.newWindow("Удаление данных");
                    break;
                case "Изменить":
                    UpdateDataExecutionStages.newWindow("Обновление данных");
                    break;
            }
        } else if (table.equals("Ставки НДС")) {
            switch (action) {
                case "Добавить":
                    EnterDataRatesNDS.newWindow("Ввод данных");
                    break;
                case "Удалить":
                    DeleteDataRatesNDS.newWindow("Удаление данных");
                    break;
                case "Изменить":
                    UpdateDataRatesNDS.newWindow("Обновление данных");
                    break;
            }
        } else if (table.equals("Виды оплат")) {
            switch (action) {
                case "Добавить":
                    EnterDataTypePayments.newWindow("Ввод данных");
                    break;
                case "Удалить":
                    DeleteDataTypePayments.newWindow("Удаление данных");
                    break;
                case "Изменить":
                    UpdateDataTypePayments.newWindow("Обновление данных");
                    break;
            }
        } else if (table.equals("Оплата")) {
            switch (action) {
                case "Добавить":
                    EnterDataPayment.newWindow("Ввод данных");
                    break;
                case "Удалить":
                    DeleteDataPayment.newWindow("Удаление данных");
                    break;
                case "Изменить":
                    UpdateDataPayment.newWindow("Обновление данных");
                    break;
            }
        } else if (table.equals("Этапы договоров")) {
            switch (action) {
                case "Добавить":
                    EnterDataStageAgreement.newWindow("Ввод данных");
                    break;
                case "Удалить":
                    DeleteDataStageAgreement.newWindow("Удаление данных");
                    break;
                case "Изменить":
                    UpdateDataStageAgreement.newWindow("Обновление данных");
                    break;
            }
        }

    }
}