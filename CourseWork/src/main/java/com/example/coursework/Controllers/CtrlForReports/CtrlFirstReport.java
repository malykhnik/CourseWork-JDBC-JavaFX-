package com.example.coursework.Controllers.CtrlForReports;

import com.example.coursework.SQLforReports.ReportSQL;
import javafx.event.ActionEvent;

public class CtrlFirstReport {
    public void button1Clicked(ActionEvent actionEvent) {
        ReportSQL reportSQL = new ReportSQL();
        reportSQL.firstReport();
    }
}