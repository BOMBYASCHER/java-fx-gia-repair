package io.hexlet.javafxrepair.controller;

import io.hexlet.javafxrepair.dto.RequestForm;
import io.hexlet.javafxrepair.service.RequestService;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.sql.Date;

public class AddController {
    @FXML
    private TextField tfRequestNumber;
    @FXML
    private DatePicker dpStartDate;
    @FXML
    private TextField tfType;
    @FXML
    private TextField tfModel;
    @FXML
    private TextArea taProblem;
    @FXML
    private TextField tfFullName;
    @FXML
    private TextField tfPhone;
    @FXML
    private MenuButton mbStatus;
    @FXML
    private MenuItem miNew;
    @FXML
    private MenuItem miProcess;
    @FXML
    private MenuItem miFinish;
    @FXML
    private Button btnSubmit;

    @FXML
    private void initialize() {
        btnSubmit.setOnMouseClicked(mouseEvent -> onSubmitClick());
        miProcess.setOnAction(actionEvent -> mbStatus.setText(miProcess.getText()));
        miFinish.setOnAction(actionEvent -> mbStatus.setText(miFinish.getText()));
        miNew.setOnAction(actionEvent -> mbStatus.setText(miNew.getText()));
    }

    private void onSubmitClick() {
        try {
            Integer requestId = parseInt(tfRequestNumber.getText());
            Date start = Date.valueOf(dpStartDate.getValue());
            String type = tfType.getText();
            String model = tfModel.getText();
            String problem = taProblem.getText();
            String fullName = tfFullName.getText();
            String phone = tfPhone.getText();
            String status = mbStatus.getText();
            RequestForm requestForm = new RequestForm(
                    requestId,
                    start,
                    type,
                    model,
                    problem,
                    fullName,
                    phone,
                    status
            );
            RequestService.saveRequest(requestForm);
        } catch (NumberFormatException e) {
            showNumberError();
        }
    }

    private Integer parseInt(String text) throws NumberFormatException {
        if (Integer.parseInt(String.valueOf(text.charAt(0))) == 0) {
            throw new NumberFormatException();
        }
        return Integer.parseInt(text);
    }

    private void showNumberError() {
        Alert alert = new Alert(Alert.AlertType.ERROR, "Номер заявки должен быть числом не начинающимся с нуля.");
        alert.setTitle("Incorrect form data");
        alert.setHeaderText("Номер заявки указан неверно");
        alert.show();
    }
}
