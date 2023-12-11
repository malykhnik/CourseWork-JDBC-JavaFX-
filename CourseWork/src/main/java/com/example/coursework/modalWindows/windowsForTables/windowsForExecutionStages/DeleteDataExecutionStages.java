package com.example.coursework.modalWindows.windowsForTables.windowsForExecutionStages;

import com.example.coursework.HelloApplication;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class DeleteDataExecutionStages {
    public static void newWindow(String title) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("views/viewsForExecutionStages/delete-view-executionStages.fxml"));
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);

        Scene scene = new Scene(fxmlLoader.load(), 300, 600);

        window.setTitle(title);
        window.setScene(scene);
        window.showAndWait();
    }
}
