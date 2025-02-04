package io.hexlet.javafxrepair;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class RepairApplication extends Application {
    private DatabaseManager databaseManager;

    @Override
    public void start(Stage stage) throws IOException {
        databaseManager = new DatabaseManager();
        databaseManager
//                .createDatabase()
                .openConnection()
                .initialization();
        FXMLLoader fxmlLoader = new FXMLLoader(RepairApplication.class.getResource("main-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Repair");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void stop() throws Exception {
        databaseManager.closeConnection();
        super.stop();
    }
}