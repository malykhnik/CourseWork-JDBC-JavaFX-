package com.example.coursework.interfaces;

import java.sql.Date;

public interface AgreementTypeCRUD {
    void createData(String type_name);
    //    void readData();
    void updateData(String type_name, String condition, String newVal);
    void deleteData(String columnName, String value);
}
