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

    exports com.example.coursework.Controllers.CtrlForAgreementTypes;
    opens com.example.coursework.Controllers.CtrlForAgreementTypes to javafx.fxml;

    exports com.example.coursework.Controllers.CtrlsForExecutionStages;
    opens com.example.coursework.Controllers.CtrlsForExecutionStages to javafx.fxml;

    exports com.example.coursework.Controllers.CtrlsForRatesNDS;
    opens com.example.coursework.Controllers.CtrlsForRatesNDS to javafx.fxml;

    exports com.example.coursework.Controllers.CtrlsForTypePayments;
    opens com.example.coursework.Controllers.CtrlsForTypePayments to javafx.fxml;

    exports com.example.coursework.Controllers.CtrlsForPayment;
    opens com.example.coursework.Controllers.CtrlsForPayment to javafx.fxml;

    exports com.example.coursework.Controllers.CtrlsForStageAgreement;
    opens com.example.coursework.Controllers.CtrlsForStageAgreement to javafx.fxml;
}