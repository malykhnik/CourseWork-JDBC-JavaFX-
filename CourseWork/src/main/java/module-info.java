module com.example.coursework {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.coursework to javafx.fxml;
    exports com.example.coursework;
    exports com.example.coursework.Controllers;
    opens com.example.coursework.Controllers to javafx.fxml;
    exports com.example.coursework.Controllers.CtrlsForAgreements;
    opens com.example.coursework.Controllers.CtrlsForAgreements to javafx.fxml;
    exports com.example.coursework.Controllers.CtrlsForAgreementTypes;
    opens com.example.coursework.Controllers.CtrlsForAgreementTypes to javafx.fxml;
}