package com.example.coursework.modalWindows.windowsForTables.windowsForRatesNDS;

import com.example.coursework.HelloApplication;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class UpdateDataRatesNDS {
    public static void newWindow(String title) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("views/viewsForRatesNDS/update-view-ratesNDS.fxml"));
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);

        Scene scene = new Scene(fxmlLoader.load(), 300, 600);

        window.setTitle(title);
        window.setScene(scene);
        window.showAndWait();
    }
}
