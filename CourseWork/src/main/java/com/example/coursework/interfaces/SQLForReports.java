package com.example.coursework.interfaces;

import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

import java.util.Map;

public interface SQLForReports {
    void firstReport(String column, String filter, String column2, String where);
    void secondReport(String column, String filter, String column2, String where);
    void thirdReport(String column, String filter, String column2, String where);
}
