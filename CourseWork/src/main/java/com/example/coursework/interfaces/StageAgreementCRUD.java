package com.example.coursework.interfaces;

public interface StageAgreementCRUD {
    void createData(int contract_code,
                    int stage_num,
                    String date_execution,
                    int code_execution,
                    int stage_amount,
                    int advance_amount);
    //    void readData();
    void updateData(String columnName, String condition, String newValue);
    void deleteData(String columnName, String val);
}
