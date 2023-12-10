package com.example.coursework.interfaces;

import java.sql.Date;

public interface PaymentCRUD {
    void createData(int contract_code,
                    String date_payment,
                    int sum_payment,
                    int code_type_payment,
                    String num_payment_doc);
    //    void readData();
    void updateData(String columnName, String condition, String newValue);
    void deleteData(String columnName, String val);
}
