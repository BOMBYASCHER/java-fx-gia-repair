package io.hexlet.javafxrepair.controller;

import io.hexlet.javafxrepair.dto.UpdateRequest;
import io.hexlet.javafxrepair.model.Request;
import io.hexlet.javafxrepair.model.User;
import io.hexlet.javafxrepair.service.RequestService;
import io.hexlet.javafxrepair.service.UserService;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.sql.Date;

import static io.hexlet.javafxrepair.ErrorViewer.showError;

public class EditRequestController {
    private final Request request;

    @FXML
    private Label labelRequestNumber;
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
    private DatePicker dpFinishDate;
    @FXML
    private TextArea taRepairParts;
    @FXML
    private MenuButton mbMaster;
    @FXML
    private Button btnSubmit;

    public EditRequestController(Request request) {
        this.request = request;
    }

    @FXML
    private void initialize() {
        labelRequestNumber.setText(labelRequestNumber.getText() + request.getId());
        tfType.setText(request.getType());
        tfModel.setText(request.getModel());
        taProblem.setText(request.getProblemDescription());
//        User currentUser = UserService.getUser(request);
        User client = UserService.getUser(request);
        tfFullName.setText(client.getFio());
        tfPhone.setText(client.getPhone());
        dpStartDate.setValue(request.getStartDate().toLocalDate());
        mbStatus.setText(request.getStatus());
        miProcess.setOnAction(actionEvent -> mbStatus.setText(miProcess.getText()));
        miFinish.setOnAction(actionEvent -> mbStatus.setText(miFinish.getText()));
        miNew.setOnAction(actionEvent -> mbStatus.setText(miNew.getText()));
        dpFinishDate.setValue(request.getFinishDate() == null ? null : request.getFinishDate().toLocalDate());
        taRepairParts.setText(request.getRepairParts());
        mbMaster.setText(String.valueOf(request.getMasterId()));
        var menuItemsMaster = UserService.getMasters().stream()
                .map(u -> new MenuItem(u.getId().toString()))
                .toList();
        menuItemsMaster.forEach(miMaster -> mbMaster.setText(miMaster.getText()));
        mbMaster.getItems().addAll(menuItemsMaster);
        btnSubmit.setOnMouseClicked(mouseEvent -> onSubmitClick());
    }

    private void onSubmitClick() {
        try {
            String type = tfType.getText();
            String model = tfModel.getText();
            String problem = taProblem.getText();
            String fullName = tfFullName.getText();
            String phone = tfPhone.getText();
            String status = mbStatus.getText();
            Date finishDate = dpFinishDate.getValue() == null ? null : Date.valueOf(dpFinishDate.getValue());
            String repairParts = taRepairParts.getText();
            request.setType(type);
            request.setModel(model);
            request.setProblemDescription(problem);
            request.setStatus(status);
            request.setFinishDate(finishDate);
            request.setRepairParts(repairParts);
            request.setMasterId(getMasterId());
            UpdateRequest updateRequest = new UpdateRequest(request);
            updateRequest.setFullName(fullName);
            updateRequest.setPhone(phone);
            RequestService.updateRequest(updateRequest);
        } catch (NullPointerException e) {
            showError("Заполните данные формы.", "Есть пустые поля");
        }
        catch (Exception e) {
            showError(e.getMessage(), "Что-то пошло не так");
        }
    }

    private int getMasterId() {
        try {
            return Integer.parseInt(mbMaster.getText());
        } catch (NumberFormatException e) {
            throw new NumberFormatException();
        }
    }
}
