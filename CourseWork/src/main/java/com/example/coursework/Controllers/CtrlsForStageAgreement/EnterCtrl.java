package com.example.coursework.Controllers.CtrlsForStageAgreement;

import com.example.coursework.CRUDforTables.StageAgreement;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class EnterCtrl {
    @FXML
    public TextField stage_num;
    @FXML
    public TextField contract_code;
    @FXML
    public TextField date_execution;
    @FXML
    public TextField code_execution;
    @FXML
    public TextField stage_amount;
    @FXML
    public TextField advance_amount;

    public void button1Clicked(ActionEvent actionEvent) {
        StageAgreement stageAgreement = new StageAgreement();
        stageAgreement.createData(Integer.parseInt(contract_code.getText()), Integer.parseInt(stage_num.getText()), date_execution.getText(),
                Integer.parseInt(code_execution.getText()),Integer.parseInt(stage_amount.getText()),Integer.parseInt(advance_amount.getText()));
    }
}
