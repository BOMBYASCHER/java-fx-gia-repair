package io.hexlet.javafxrepair.controller;

import io.hexlet.javafxrepair.RepairApplication;
import io.hexlet.javafxrepair.service.LoginService;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {
    @FXML
    private TextField tfUsername;
    @FXML
    private PasswordField pfPassword;
    @FXML
    private Button btnEnter;

    @FXML
    public void initialize() {
        btnEnter.setOnMouseClicked(mouseEvent -> {
            String username = tfUsername.getText();
            String password = pfPassword.getText();
            if (LoginService.authenticate(username, password)) {
                btnEnter.getParent().getScene().getWindow().hide();
                FXMLLoader fxmlLoader = new FXMLLoader(RepairApplication.class.getResource("main-view.fxml"));
                Scene scene;
                try {
                    scene = new Scene(fxmlLoader.load());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                Stage stage = new Stage();
                stage.setTitle("Repair");
                stage.setScene(scene);
                stage.show();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Please check your username and password.");
                alert.setTitle("Incorrect login data");
                alert.setHeaderText("Please check your data.");
                alert.show();
            }
        });
    }
}
