package com.example.coursework.interfaces;

import java.sql.Date;

public interface AgreementsCRUD {
    void createData(int customer_code,
                    int executor_code,
                    int contract_type_code,
                    int code_org,
                    int execution_code,
                    int code_NDS,
                    Date date_execution);
//    void readData();
    void updateData(String columnName, String condition, String newValue);
    void deleteData(String columnName, String val);
}
