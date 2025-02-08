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
                .openConnection()
                .initialization();
        FXMLLoader fxmlLoader = new FXMLLoader(RepairApplication.class.getResource("login-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Login");
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